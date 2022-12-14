package com.healt.cloud.checkup.service.settlement.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcMemberInfo;
import com.healt.cloud.checkup.entity.HcRcptPay;
import com.healt.cloud.checkup.entity.HcSettleDetail;
import com.healt.cloud.checkup.entity.HcSettleMaster;
import com.healt.cloud.checkup.service.settlement.PersonSettleReturnService;
import com.healt.cloud.checkup.vo.settlement.RevItemsBillIndicator;
import com.healt.cloud.checkup.vo.settlement.SettleReturnItemListVo;
import com.healt.cloud.checkup.vo.settlement.SettleReturnPayListVo;
import com.healt.cloud.checkup.vo.settlement.SettleReturnPersonInfoVo;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcReturnSettleListVo;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcSettleVo;
import com.healt.cloud.checkup.appointmentReg.mapper.PersonSettleReturnMapper;
import com.healt.cloud.checkup.service.HcMemberInfoService;
import com.healt.cloud.checkup.service.HcRcptPayService;
import com.healt.cloud.checkup.service.HcSettleDetailService;
import com.healt.cloud.checkup.service.HcSettleMasterService;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author linklee
 * @create 2022-04-18 16:01
 */
@Service
@AllArgsConstructor
public class PersonSettleReturnServiceImpl implements PersonSettleReturnService {

    private PersonSettleReturnMapper personSettleReturnMapper;

    private HcSettleMasterService hcSettleMasterService;
    private HcSettleDetailService hcSettleDetailService;
    private HcRcptPayService hcRcptPayService;
    private HcMemberInfoService hcMemberInfoService;
    private PersonSettleServiceImpl personSettleService;

    @Override
    public List<SettleReturnItemListVo> findSettleReturnItemList(String hospitalId, String rcptNo) {
        List<SettleReturnItemListVo> list = personSettleReturnMapper.findSettleReturnItemList(hospitalId,rcptNo);
        if (list.size() == 0) {
            list.add(new SettleReturnItemListVo());
        }
        return list;
    }

    @Override
    public List<SettleReturnPayListVo> findSettleReturnPayList(String hospitalId, String rcptNo) {
        List<SettleReturnPayListVo> list = personSettleReturnMapper.findSettleReturnPayList(hospitalId,rcptNo);
        if (list.size() == 0) {
            list.add(new SettleReturnPayListVo());
        }
        return list;
    }

    @Override
    public List<HcSettleMaster> findHcSettleMaster(String hospitalId, String rcptNo) {
        List<HcSettleMaster> list = personSettleReturnMapper.findHcSettleMaster(hospitalId,rcptNo);
        if (list.size() == 0) {
            list.add(new HcSettleMaster());
        }
        return list;
    }

    @Override
    public List<SettleReturnPersonInfoVo> findSettleReturnPersonInfo(String hospitalId, String personId, Integer personVisitId) {
        List<SettleReturnPersonInfoVo> list = personSettleReturnMapper.findSettleReturnPersonInfo(hospitalId,personId,personVisitId);
        if (list.size() == 0) {
            list.add(new SettleReturnPersonInfoVo());
        }
        if (list.get(0).getResultStatus().equals("F")) {
            throw new CommonException(20001,"次单号的体检信息已经最终审核，不能退费");
        }
        return list;
    }

    @Override
    @Transactional
    public void saveHcReturnSettleList(SaveHcReturnSettleListVo saveHcReturnSettleList) {
        //SaveHcReturnSettleListVo hcReturnSettle = saveHcReturnSettleList.get(0);
        //将之前单据整单退费
        //主表
        HcSettleMaster master = findHcSettleMaster(saveHcReturnSettleList.getHospitalId(), saveHcReturnSettleList.getRcptNo()).get(0);
        master.setRcptNo(saveHcReturnSettleList.getNewRcptNo());
        master.setSettlingDate(new Date());
        if (null != master.getCosts()) {
            master.setCosts(master.getCosts().negate());
        }
        if (null != master.getPayments()) {
            master.setPayments(master.getPayments().negate());
        }
        if (null != master.getWipingZero()) {
            master.setWipingZero(master.getWipingZero().negate());
        }
        if (null != master.getDiscountMoney()) {
            master.setDiscountMoney(master.getDiscountMoney().negate());
        }
        master.setUserId(saveHcReturnSettleList.getUserName());
        master.setUserName(saveHcReturnSettleList.getUserRealName());
        master.setFinishDate(new Date());
        hcSettleMasterService.save(master);
        //细表
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("hospital_id",saveHcReturnSettleList.getHospitalId());
        wrapper.eq("rcpt_no",saveHcReturnSettleList.getRcptNo());
        List<HcSettleDetail> hcSettleDetailList = hcSettleDetailService.list(wrapper);
        for (HcSettleDetail detail : hcSettleDetailList) {
            detail.setRcptNo(saveHcReturnSettleList.getNewRcptNo());
            detail.setSettlingDate(new Date());
            if (null != detail.getCosts()) {
                detail.setCosts(detail.getCosts().negate());
            }
            if (null != detail.getPayments()) {
                detail.setPayments(detail.getPayments().negate());
            }
            detail.setUserId(saveHcReturnSettleList.getUserName());
            detail.setUserName(saveHcReturnSettleList.getUserRealName());
        }
        hcSettleDetailService.saveBatch(hcSettleDetailList);
        //支付方式
        List<HcRcptPay> hcRcptPayList = hcRcptPayService.list(wrapper);
        for (HcRcptPay hcRcptPay : hcRcptPayList) {
            hcRcptPay.setRcptNo(saveHcReturnSettleList.getNewRcptNo());
            if (!hcRcptPay.getPaymentMoney().equals(null)) {
                hcRcptPay.setPaymentMoney(hcRcptPay.getPaymentMoney().negate());
            }
        }
        hcRcptPayService.saveBatch(hcRcptPayList);
        //判断是否有会员卡支付
        for (HcRcptPay hcRcptPay : hcRcptPayList) {
            if (hcRcptPay.getPaymentType().equals("会员卡")) {
                //更新加上卡里金额
                updateMoneyInCard(hcRcptPay.getHospitalId(),hcRcptPay.getCardNo(),hcRcptPay.getPaymentMoney());
                //写交易记录
                if (!hcRcptPay.getPaymentMoney().equals(null)) {
                    personSettleService.saveMemberTrans(hcRcptPay.getHospitalId(),hcRcptPay.getCardNo(),"退费",
                            null,hcRcptPay.getPaymentMoney().negate(),saveHcReturnSettleList.getUserName(),"");
                } else {
                    personSettleService.saveMemberTrans(hcRcptPay.getHospitalId(),hcRcptPay.getCardNo(),"退费",
                            null,hcRcptPay.getPaymentMoney(),saveHcReturnSettleList.getUserName(),"");
                }
            }
        }
        //修改主表退费单据号
        personSettleReturnMapper.updateHcSettleMaster(saveHcReturnSettleList.getNewRcptNo(),saveHcReturnSettleList.getHospitalId(),saveHcReturnSettleList.getRcptNo());
        //修改细表退费单据号
        personSettleReturnMapper.updateHcSettleDetail(saveHcReturnSettleList.getNewRcptNo(),saveHcReturnSettleList.getHospitalId(),saveHcReturnSettleList.getRcptNo());
        //取退费项目 将其修改为未收费
        for (RevItemsBillIndicator rbi: saveHcReturnSettleList.getRevItemsBillIndicators()) {
            personSettleReturnMapper.updatePersonAppregItems(saveHcReturnSettleList.getHospitalId(),rbi.getPersonId(),rbi.getPersonVisitId(),
                                                            rbi.getItemPackCode(),rbi.getItemNo());
        }
        //取其它项目重新生成新单据
        if (!saveHcReturnSettleList.getSaveHcSettleList().equals(null)) {
            for (SaveHcSettleVo saveHcSettleVo : saveHcReturnSettleList.getSaveHcSettleList()) {
                switch (saveHcSettleVo.getStat()) {
                    case "delete" :
                        for (HcSettleMaster hcSettleMaster : saveHcSettleVo.getHcSettleMaster()) {
                            QueryWrapper<HcSettleMaster> queryWrapper = new QueryWrapper<HcSettleMaster>(hcSettleMaster);
                            hcSettleMasterService.remove(queryWrapper);
                        }
                        break;
                    case "add" :
                        //保存主表
                        hcSettleMasterService.saveBatch(saveHcSettleVo.getHcSettleMaster());
                        //保存细表
                        hcSettleDetailService.saveBatch(saveHcSettleVo.getHcSettleDetail());
                        //支付方式
                        hcRcptPayService.saveBatch(saveHcSettleVo.getHcRcptPay());
                        //判断是否有会员卡支付
                        QueryWrapper wrapperNew = new QueryWrapper();
                        wrapper.eq("hospital_id",saveHcReturnSettleList.getHospitalId());
                        wrapper.eq("rcpt_no",saveHcReturnSettleList.getNewRcptNo());
                        List<HcRcptPay> hcRcptPayListNew = hcRcptPayService.list(wrapperNew);
                        for (HcRcptPay hcRcptPay : hcRcptPayListNew) {
                            if (hcRcptPay.getPaymentType().equals("会员卡")) {
                                //更新减掉卡里金额
                                personSettleService.updateMoneyInCard(hcRcptPay.getHospitalId(),hcRcptPay.getCardNo(),hcRcptPay.getPaymentMoney());
                                //写交易记录
                                personSettleService.saveMemberTrans(hcRcptPay.getHospitalId(),hcRcptPay.getCardNo(),"结算",
                                        null,hcRcptPay.getPaymentMoney(),saveHcReturnSettleList.getUserName(),"");
                            }
                        }
                        //更新下一个单据号
                        personSettleReturnMapper.updateNextChargeNoTwo(saveHcReturnSettleList.getHospitalId());
                        break;
                    case "update" :
                        for (HcSettleMaster hcSettleMaster : saveHcSettleVo.getHcSettleMaster()) {
                            UpdateWrapper<HcSettleMaster> updateWrapper = new UpdateWrapper<HcSettleMaster>(hcSettleMaster);
                            hcSettleMasterService.update(updateWrapper);
                        }
                        break;
                }
            }
        }
        //int a = 10/0;
    }

    public void updateMoneyInCard(String hospitalId, String cardNo, BigDecimal paymentMoney) {
        QueryWrapper<HcMemberInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("hospital_id",hospitalId);
        wrapper.eq("card_no",cardNo);
        HcMemberInfo hcMemberInfo = hcMemberInfoService.getOne(wrapper);
        if (hcMemberInfo == null) {
            throw new CommonException(500,"此卡号不存在");
        } else {
            BigDecimal money = hcMemberInfo.getMoney();
            BigDecimal lastMoney = money.add(paymentMoney);
            if (lastMoney.compareTo(new BigDecimal(0)) >= 0) {
                hcMemberInfo.setMoney(lastMoney);
                hcMemberInfoService.update(hcMemberInfo,wrapper);
            } else {
                throw new CommonException(500,"余额不足,未完成扣费");
            }

        }
    }


    @Override
    public List<SettleReturnItemListVo> findSettleReturnItemListNew(String hospitalId, String rcptNo) {
        List<SettleReturnItemListVo> list = personSettleReturnMapper.findSettleReturnItemListNew(hospitalId,rcptNo);
        if (list.size() == 0) {
            list.add(new SettleReturnItemListVo());
        }
        return list;
    }
}
