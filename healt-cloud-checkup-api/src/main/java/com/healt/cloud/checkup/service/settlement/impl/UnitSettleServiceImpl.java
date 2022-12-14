package com.healt.cloud.checkup.service.settlement.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcRcptPay;
import com.healt.cloud.checkup.entity.HcSettleMaster;
import com.healt.cloud.checkup.service.settlement.UnitSettleService;
import com.healt.cloud.checkup.vo.settlement.*;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcSettleListVo;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcSettleVo;
import com.healt.cloud.checkup.appointmentReg.mapper.PersonSettleMapper;
import com.healt.cloud.checkup.appointmentReg.mapper.UnitSettleMapper;
import com.healt.cloud.checkup.service.HcRcptPayService;
import com.healt.cloud.checkup.service.HcSettleDetailService;
import com.healt.cloud.checkup.service.HcSettleMasterService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-03 10:53
 */
@Service
@AllArgsConstructor
public class UnitSettleServiceImpl implements UnitSettleService {

    private UnitSettleMapper unitSettleMapper;

    private HcSettleMasterService hcSettleMasterService;
    private HcSettleDetailService hcSettleDetailService;
    private HcRcptPayService hcRcptPayService;
    private PersonSettleMapper personSettleMapper;
    private PersonSettleServiceImpl personSettleServiceImpl;

    @Override
    public List<UnitInfoVo> findUnitInfo(String hospitalId) {
        List<UnitInfoVo> list = unitSettleMapper.findUnitInfo(hospitalId);
        if (list.size() == 0) {
            list.add(new UnitInfoVo());
        }
        return list;
    }

    @Override
    public List<DiscountSchemeVo> findDiscountScheme() {
        List<DiscountSchemeVo> list = unitSettleMapper.findDiscountScheme();
        if (list.size() == 0) {
            list.add(new DiscountSchemeVo());
        }
        return list;
    }

    @Override
    public List<HcUnitGroupVo> findDtUnitGroup(String hospitalId, String unitId, Integer unitVisitId) {
        List<HcUnitGroupVo> list = unitSettleMapper.findDtUnitGroup(hospitalId, unitId, unitVisitId);
        if (list.size() == 0) {
            list.add(new HcUnitGroupVo());
        }
        return list;
    }

    @Override
    public List<DtxmmxVo> findDtxmmx(String hospitalId, String unitId, Integer unitVisitId) {
        List<DtxmmxVo> list = unitSettleMapper.findDtxmmx(hospitalId, unitId, unitVisitId);
        if (list.size() == 0) {
            list.add(new DtxmmxVo());
        }
        return list;
    }

    @Override
    public List<DtxmmxVo> findDtxmmxPerson(String hospitalId, String unitId, Integer unitVisitId, String personIdStr) {
        String personIdStrWhe = "(";
        if(StringUtils.isNotEmpty(personIdStr)){
            String[] personIdAry = personIdStr.split(",");
            for(int i=0;i<personIdAry.length;i++){
                personIdStrWhe += "'"+personIdAry[i]+"',";
            }
            personIdStrWhe = personIdStrWhe.substring(0, personIdStrWhe.length()-1);
        }
        personIdStrWhe += ")";
        List<DtxmmxVo> list = unitSettleMapper.findDtxmmxPerson(hospitalId, unitId, unitVisitId, personIdStrWhe);
        if (list.size() == 0) {
            list.add(new DtxmmxVo());
        }
        return list;
    }

    @Override
    public List<DtxmHZVo> findDtxmHZPerson(String hospitalId, String unitId, Integer unitVisitId, String personIdStr) {
        String personIdStrWhe = "(";
        if(StringUtils.isNotEmpty(personIdStr)){
            String[] personIdAry = personIdStr.split(",");
            for(int i=0;i<personIdAry.length;i++){
                personIdStrWhe += "'"+personIdAry[i]+"',";
            }
            personIdStrWhe = personIdStrWhe.substring(0, personIdStrWhe.length()-1);
        }
        personIdStrWhe += ")";
        List<DtxmHZVo> list = unitSettleMapper.findDtxmHZPerson(hospitalId, unitId, unitVisitId, personIdStrWhe);
        if (list.size() == 0) {
            list.add(new DtxmHZVo());
        }
        return list;
    }

    @Override
    public List<DtxmHZVo> findDtxmHZ(String hospitalId, String unitId, Integer unitVisitId) {
        List<DtxmHZVo> list = unitSettleMapper.findDtxmHZ(hospitalId, unitId, unitVisitId);
        if (list.size() == 0) {
            list.add(new DtxmHZVo());
        }
        return list;
    }

    @Override
    public List<SbYyVo> findSbYy(String hospitalId, String unitId, Integer unitVisitId, String schemeCode) {
        List<SbYyVo> list = unitSettleMapper.findSbYy(hospitalId, unitId, unitVisitId, schemeCode);
        if (list.size() == 0) {
            list.add(new SbYyVo());
        }
        return list;
    }

    @Override
    @Transactional
    public void saveHcSettleList(SaveHcSettleListVo saveHcSettleList) {
        for (SaveHcSettleVo saveHcSettleVo : saveHcSettleList.getSaveHcSettleList()) {
            switch (saveHcSettleVo.getStat()) {
                case "delete" :
                    for (HcSettleMaster hcSettleMaster : saveHcSettleVo.getHcSettleMaster()) {
                        QueryWrapper<HcSettleMaster> queryWrapper = new QueryWrapper<HcSettleMaster>(hcSettleMaster);
                        hcSettleMasterService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    HcSettleMaster settleMaster = saveHcSettleVo.getHcSettleMaster().get(0);
                    List<HcRcptPay> hcRcptPayList = saveHcSettleVo.getHcRcptPay();
                    for (HcRcptPay hcRcptPay : hcRcptPayList) {
                        if (hcRcptPay.getPaymentType().equals("会员卡")) {
                            //如果余额不足,则扣费失败
                            personSettleServiceImpl.updateMoneyInCard(hcRcptPay.getHospitalId(),hcRcptPay.getCardNo(),hcRcptPay.getPaymentMoney());
                            //写交易记录
                            personSettleServiceImpl.saveMemberTrans(hcRcptPay.getHospitalId(),hcRcptPay.getCardNo(),"结算",
                                    null,hcRcptPay.getPaymentMoney(),settleMaster.getUserName(),"");
                        }
                    }
                    hcSettleMasterService.saveBatch(saveHcSettleVo.getHcSettleMaster());
                    hcSettleDetailService.saveBatch(saveHcSettleVo.getHcSettleDetail());
                    hcRcptPayService.saveBatch(saveHcSettleVo.getHcRcptPay());

                    personSettleMapper.updateNextChargeNo(settleMaster.getHospitalId());
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

}
