package com.healt.cloud.checkup.service.member.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.healt.cloud.checkup.entity.CommonDict;
import com.healt.cloud.checkup.entity.HcMemberInfo;
import com.healt.cloud.checkup.mapper.appointmentReg.MemberListMapper;
import com.healt.cloud.checkup.service.CommonDictService;
import com.healt.cloud.checkup.service.HcMemberInfoService;
import com.healt.cloud.checkup.service.member.MemberListService;
import com.healt.cloud.checkup.service.settlement.impl.PersonSettleReturnServiceImpl;
import com.healt.cloud.checkup.service.settlement.impl.PersonSettleServiceImpl;
import com.healt.cloud.checkup.vo.member.MemberDictVo;
import com.healt.cloud.checkup.vo.member.MemberListVo;
import com.healt.cloud.checkup.vo.member.UserListVo;
import com.healt.cloud.checkup.vo.member.vo.SaveCommonDictListVo;
import com.healt.cloud.checkup.vo.member.vo.SaveCommonDictVo;
import com.healt.cloud.checkup.vo.member.vo.SaveHcMemberInfoListVo;
import com.healt.cloud.checkup.vo.member.vo.SaveHcMemberInfoVo;
import com.healt.cloud.common.pages.PageResult;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linklee
 * @create 2022-05-09 14:00
 */
@Service
@AllArgsConstructor
public class MemberListServiceImpl implements MemberListService {

    private MemberListMapper memberListMapper;
    private CommonDictService commonDictService;

    private HcMemberInfoService hcMemberInfoService;
    private PersonSettleServiceImpl personSettleService;
    private PersonSettleReturnServiceImpl personSettleReturnService;

    @Override
    public PageResult findMemberListPage(MemberDictVo memberDictVo) {
        QueryWrapper<HcMemberInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", memberDictVo.getHospitalId());
        IPage<HcMemberInfo> page = new Page<>();
        page.setSize(memberDictVo.getPageSize());
        page.setCurrent(memberDictVo.getPageNum());
        page = hcMemberInfoService.page(page, queryWrapper);
        if(page.getRecords().size() == 0){
            List<MemberListVo> list = new ArrayList<>();
            list.add(new MemberListVo());
            return new PageResult(page.getCurrent(),page.getSize(),page.getTotal(), page.getPages(), list);
        } else {
            List<MemberListVo> list = new ArrayList<>();
            for (HcMemberInfo hcMemberInfo : page.getRecords()) {
                MemberListVo memberListVo = new MemberListVo();
                BeanUtils.copyProperties(hcMemberInfo,memberListVo);
                list.add(memberListVo);
            }
            return new PageResult(page.getCurrent(),page.getSize(),page.getTotal(), page.getPages(), list);
        }
    }

    @Override
    public List<UserListVo> findUserList(String hospitalId) {
        List<UserListVo> list = memberListMapper.findUserList(hospitalId);
        if (list.size() == 0) {
            list.add(new UserListVo());
        }
        return list;
    }

    @Override
    public List findCardNo(String hospitalId, String cardNo) {
        String no = memberListMapper.findCardNo(hospitalId,cardNo);
        if (no == null) {
            no = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("card_no",no);
        list.add(map);
        return list;
    }

    @Override
    @Transactional
    public void saveHcMemberInfo(SaveHcMemberInfoListVo saveHcMemberInfoList) {
        for (SaveHcMemberInfoVo saveHcMemberInfoVo : saveHcMemberInfoList.getSaveHcMemberInfoList()) {
            switch (saveHcMemberInfoVo.getStat()) {
                case "delete" :
                    for (HcMemberInfo hcMemberInfo : saveHcMemberInfoVo.getHcMemberInfo()) {
                        QueryWrapper<HcMemberInfo> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID", hcMemberInfo.getHospitalId());
                        queryWrapper.eq("CARD_NO", hcMemberInfo.getCardNo());
                        hcMemberInfoService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    hcMemberInfoService.saveBatch(saveHcMemberInfoVo.getHcMemberInfo());
                    for (HcMemberInfo mi : saveHcMemberInfoVo.getHcMemberInfo()) {
                        //写交易记录
                        personSettleService.saveMemberTrans(mi.getHospitalId(),mi.getCardNo(),"发卡",
                                saveHcMemberInfoVo.getPay(),mi.getMoney(),mi.getUserId(),mi.getNote());
                    }
                    break;
                case "update" :
                    for (HcMemberInfo hcMemberInfo : saveHcMemberInfoVo.getHcMemberInfo()) {
                        UpdateWrapper<HcMemberInfo> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID", hcMemberInfo.getHospitalId());
                        updateWrapper.eq("CARD_NO", hcMemberInfo.getCardNo());
                        hcMemberInfoService.update(hcMemberInfo,updateWrapper);
                    }
                    break;
            }
        }

    }

    @Override
    public List<MemberListVo> findDataByCardNo(String hospitalId, String cardNo) {
        List<MemberListVo> list = memberListMapper.findDataByCardNo(hospitalId,cardNo);
        if (list.size() == 0) {
            list.add(new MemberListVo());
        }
        return list;
    }

    @Override
    @Transactional
    public void updateMemberInfo(String hospitalId, String cardNo,String status) {
        memberListMapper.updateMemberInfo(hospitalId,cardNo,status);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("hospital_id",hospitalId);
        wrapper.eq("card_no",cardNo);
        HcMemberInfo mi = hcMemberInfoService.getOne(wrapper);
        //写交易记录
        personSettleService.saveMemberTrans(hospitalId,cardNo,status,
                null,new BigDecimal(0),mi.getUserId(),null);
    }

    @Override
    public List<CommonDict> findCardTypeList(String hospitalId) {
        List<CommonDict> list = memberListMapper.findCardTypeList(hospitalId);
        if (list.size() == 0) {
            list.add(new CommonDict());
        }
        return list;
    }

    @Override
    @Transactional
    public void updateMemberInfoMoney(String hospitalId, String cardNo, BigDecimal decTransMoney,String transType, String pay) {
        //取卡内金额
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("hospital_id",hospitalId);
        wrapper.eq("card_no",cardNo);
        HcMemberInfo mi = hcMemberInfoService.getOne(wrapper);
        //取待充值或退款金额
        if (decTransMoney.equals(null)) {
            throw new CommonException(500,"请输入充值金额！");
        }
        if (decTransMoney.compareTo(BigDecimal.ZERO) <= 0) {
            throw new CommonException(500,"金额输入有误！");
        }
        //取交易类型
        if (transType.equals(null)) {
            throw new CommonException(500,"充值类型必须输入！");
        }
        BigDecimal lastMoney = decTransMoney.subtract(mi.getMoney());
        if (transType.equals("退款")) {
            if (lastMoney.compareTo(new BigDecimal(0)) > 0) {
                throw new CommonException(500,"退款金额不能大于卡内余额！");
            }
            decTransMoney = decTransMoney.negate();
        }
        if (pay.equals(null)) {
            throw new CommonException(500,"支付方式必须输入！");
        }

        try {
            personSettleReturnService.updateMoneyInCard(hospitalId,cardNo,decTransMoney);
        } catch (Exception e) {
            throw new CommonException(500,"保存hc_member_info表失败！");
        }

        //写交易记录
        personSettleService.saveMemberTrans(hospitalId,cardNo,transType,pay,decTransMoney,mi.getUserId(),null);
    }

    @Override
    public void saveCommonDict(SaveCommonDictListVo saveCommonDictList) {
        for (SaveCommonDictVo saveCommonDictVo : saveCommonDictList.getSaveCommonDictList()) {
            switch (saveCommonDictVo.getStat()) {
                case "delete" :
                    for (CommonDict commonDict : saveCommonDictVo.getCommonDict()) {
                        QueryWrapper<CommonDict> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID", commonDict.getHospitalId());
                        queryWrapper.eq("DICT_TYPE", commonDict.getDictType());
                        queryWrapper.eq("CODE", commonDict.getCode());
                        commonDictService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    commonDictService.saveBatch(saveCommonDictVo.getCommonDict());
                    break;
                case "update" :
                    for (CommonDict commonDict : saveCommonDictVo.getCommonDict()) {
                        UpdateWrapper<CommonDict> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID", commonDict.getHospitalId());
                        updateWrapper.eq("DICT_TYPE", commonDict.getDictType());
                        updateWrapper.eq("CODE", commonDict.getCode());
                        commonDictService.update(commonDict,updateWrapper);
                    }
                    break;
            }
        }

    }
}
