package com.healt.cloud.checkup.service.settlement.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.service.settlement.PersonSettleService;
import com.healt.cloud.checkup.vo.settlement.*;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcSettleListVo;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcSettleMasterListVo;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcSettleMasterVo;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcSettleVo;
import com.healt.cloud.checkup.appointmentReg.mapper.PersonSettleMapper;
import com.healt.cloud.checkup.service.ws.WebServiceClient;
import com.healt.cloud.checkup.service.ws.his.CodeTableItem;
import com.healt.cloud.checkup.service.ws.his.costDetailBilling.CostDetailBillingChargeItem;
import com.healt.cloud.checkup.service.ws.his.costDetailBilling.CostDetailBillingPatientInfo;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.PropertiesUtils;
import com.healt.cloud.resultex.exception.CommonException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author linklee
 * @create 2022-04-09 13:58
 */
@Service
public class PersonSettleServiceImpl implements PersonSettleService {

    private String isHis = PropertiesUtils.ISHIS;

    private String areaCode = PropertiesUtils.AREACODE;

    private String medInstCode = PropertiesUtils.MEDINSTCODE;

    @Autowired
    private WebServiceClient client;

    @Autowired
    private PersonSettleMapper personSettleMapper;

    @Autowired
    private HcSettleMasterService hcSettleMasterService;

    @Autowired
    private HcSettleDetailService hcSettleDetailService;

    @Autowired
    private HcRcptPayService hcRcptPayService;

    @Autowired
    private HcMemberInfoService hcMemberInfoService;

    @Autowired
    private HcPersonInfoService hcPersonInfoService;

    @Autowired
    private HcPackVsClinicService hcPackVsClinicService;

    @Override
    public List<SettleItemListVo> findSettleItemList(String hospitalId, String personId, Integer personVisitId) {
        List<SettleItemListVo> list = personSettleMapper.findSettleItemList(hospitalId,personId,personVisitId);
        if(list.size() == 0){
            list.add(new SettleItemListVo());
        }
        return list;
    }

    @Override
    public List<SettlePayListVo> findSettlePayList() {
        List<SettlePayListVo> list = personSettleMapper.findSettlePayList();
        if(list.size() == 0){
            list.add(new SettlePayListVo());
        }
        return list;
    }

    @Override
    public List<PersonVisitAndInfoVo> findPersonVisitAndInfo(String hospitalId, String personId) {
        List<PersonVisitAndInfoVo> list = personSettleMapper.findPersonVisitAndInfo(hospitalId,personId);
        if(list.size() == 0){
            list.add(new PersonVisitAndInfoVo());
        }
        return list;
    }

    @Override
    public BigDecimal findMoneyInCard(String hospitalId, String cardNo) {
        //String money = personSettleMapper.findMoneyInCard(hospitalId,cardNo);
        QueryWrapper<HcMemberInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("hospital_id",hospitalId);
        wrapper.eq("card_no",cardNo);
        HcMemberInfo hcMemberInfo = hcMemberInfoService.getOne(wrapper);
        if (hcMemberInfo == null) {
            throw new CommonException(20001,"此卡号不存在");
        } else {
            BigDecimal money = hcMemberInfo.getMoney();
            if (money == null) {
                money = new BigDecimal(0);
            }
            return money;
        }
    }

    @Override
    public List<HospitalDictVo> findHospitalDict(String hospitalId) {
        List<HospitalDictVo> list = personSettleMapper.findHospitalDict(hospitalId);
        if(list.size() == 0){
            list.add(new HospitalDictVo());
        }
        return list;
    }

    @Override
    public void updateMoneyInCard(String hospitalId, String cardNo, BigDecimal paymentMoney) {
        //personSettleMapper.updateMoneyInCard(hospitalId,cardNo,paymentMoney);
        QueryWrapper<HcMemberInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("hospital_id",hospitalId);
        wrapper.eq("card_no",cardNo);
        HcMemberInfo hcMemberInfo = hcMemberInfoService.getOne(wrapper);
        if (hcMemberInfo == null) {
            throw new CommonException(500,"此卡号不存在");
        } else {
            BigDecimal money = hcMemberInfo.getMoney();
            BigDecimal lastMoney = money.subtract(paymentMoney);
            if (lastMoney.compareTo(new BigDecimal(0)) >= 0) {
                hcMemberInfo.setMoney(lastMoney);
                hcMemberInfoService.update(hcMemberInfo,wrapper);
            } else {
                throw new CommonException(500,"余额不足,未完成扣费");
            }
        }
    }

    @Override
    public void saveSettleMaster(SaveHcSettleMasterListVo saveHcSettleMasterListVo) {
        for (SaveHcSettleMasterVo saveHcSettleMasterVo : saveHcSettleMasterListVo.getSaveHcSettleMasterList()) {
            switch (saveHcSettleMasterVo.getStat()) {
                case "delete" :
                    for (HcSettleMaster hcSettleMaster : saveHcSettleMasterVo.getHcSettleMaster()) {
                        QueryWrapper<HcSettleMaster> queryWrapper = new QueryWrapper<HcSettleMaster>(hcSettleMaster);
                        hcSettleMasterService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    hcSettleMasterService.saveBatch(saveHcSettleMasterVo.getHcSettleMaster());
                    break;
                case "update" :
                    for (HcSettleMaster hcSettleMaster : saveHcSettleMasterVo.getHcSettleMaster()) {
                        UpdateWrapper<HcSettleMaster> updateWrapper = new UpdateWrapper<HcSettleMaster>(hcSettleMaster);
                        hcSettleMasterService.update(updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public void updateNextChargeNo(String hospitalId) {
        personSettleMapper.updateNextChargeNo(hospitalId);
    }

    @Override
    public void updateBillIndicator(String hospitalId, String personId, Integer personVisitId) {
        personSettleMapper.updateBillIndicator(hospitalId,personId,personVisitId);
    }

    public void saveMemberTrans(String hospitalId,String cardNo,String transType,
                                String pay,BigDecimal money,String userId,String note) {
        if (hospitalId.equals(null)) {
            throw new CommonException(500,"机构编码不能为空");
        }
        if (cardNo.equals(null)) {
            throw new CommonException(500,"卡号不能为空");
        }
        if (transType.equals(null)) {
            throw new CommonException(500,"交易类型不能为空");
        }
        if (userId.equals(null)) {
            throw new CommonException(500,"操作员不能为空");
        }
        String transNo = personSettleMapper.getMemberTransNo(hospitalId);
        if (transNo.equals(null)) {
            throw new CommonException(500,"生成交易号失败");
        }
        personSettleMapper.saveHcMemberTrans(hospitalId,cardNo,transNo,transType,pay,money,userId,note);
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
                            updateMoneyInCard(hcRcptPay.getHospitalId(),hcRcptPay.getCardNo(),hcRcptPay.getPaymentMoney());
                            //写交易记录
                            saveMemberTrans(hcRcptPay.getHospitalId(),hcRcptPay.getCardNo(),"结算",
                                    null,hcRcptPay.getPaymentMoney(),settleMaster.getUserName(),"");
                        }
                    }
                    hcSettleMasterService.saveBatch(saveHcSettleVo.getHcSettleMaster());
                    hcSettleDetailService.saveBatch(saveHcSettleVo.getHcSettleDetail());
                    hcRcptPayService.saveBatch(saveHcSettleVo.getHcRcptPay());

                    personSettleMapper.updateNextChargeNo(settleMaster.getHospitalId());
                    personSettleMapper.updateBillIndicator(settleMaster.getHospitalId(),settleMaster.getPersonId(),settleMaster.getPersonVisitId());
                    if("Y".equals(isHis)){
                        //发送HIS平台
                        CostDetailBillingPatientInfo detailBillingPatientInfo = this.detailBillingPatientInfo(settleMaster);
                        List<CostDetailBillingChargeItem> chargeItemList = this.chargeItemList(saveHcSettleVo.getHcSettleDetail());
                        client.costDetailBilling(detailBillingPatientInfo, chargeItemList, "saveHcSettleList");
                    }
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

    @Override
    public List<SbYyVo> findSbYy(String hospitalId, String unitId, Integer unitVisitId, String schemeCode) {
        List<SbYyVo> list = personSettleMapper.findSbYy(hospitalId, unitId, unitVisitId, schemeCode);
        if (list.size() == 0) {
            list.add(new SbYyVo());
        }
        return list;
    }

    private List<CostDetailBillingChargeItem> chargeItemList(List<HcSettleDetail> hcSettleDetails) {
        List<CostDetailBillingChargeItem> list = new ArrayList<>();
        for(HcSettleDetail hcSettleDetail : hcSettleDetails){
            CostDetailBillingChargeItem item = new CostDetailBillingChargeItem();
            //获取体检组合对应诊疗项目
            QueryWrapper<HcPackVsClinic> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("ITEM_PACK_CODE", hcSettleDetail.getItemPackCode());
            HcPackVsClinic hcPackVsClinic = hcPackVsClinicService.getOne(queryWrapper);
            if(hcPackVsClinic == null){
                throw new CommonException(500, "诊疗项目："+hcSettleDetail.getItemPackName()+"没有与His诊疗项目对照");
            }
            item.setClinicItemId(hcPackVsClinic.getItemCode());
            item.setClinicItemName(hcPackVsClinic.getItemName());
            item.setItemType("");//物价项目分类
            item.setFeeItemId("");//项目明细编码
            item.setFeeItemName("");//项目明细名称
            item.setDrugSpec("");//项目明细规格
            item.setPharmacyFactoryName("");//厂家/产地名称
            item.setNum(hcSettleDetail.getNum().toString());
            item.setUnit("");//数量单位
            item.setUnitPrice("");//单价
            item.setUnitCoeff("");//数量单位和基本单位的换算系数
            item.setTotalPrice(hcSettleDetail.getCosts().toString());//应收
            item.setCharges(hcSettleDetail.getPayments().toString());//实收
            item.setClinicPropertyClass("");//统计分类编码
            item.setApplyDoctorCode("");//申请医生编码
            item.setApplyDoctorName("");//申请医生名称
            item.setApplyOrgCode("95");//申请科室编码
            item.setApplyOrgName("体检中心");//申请科室名称
            item.setExecOrgCode("");//执行科室编码
            item.setExecOrgName("");//执行科室名称
            item.setChargeDate(DateUtils.praseDate(hcSettleDetail.getSettlingDate(), "yyyyMMddHHmmss"));
            item.setEnterDate(DateUtils.praseDate(new Date(), "yyyyMMddHHmmss"));
            item.setOperator(hcSettleDetail.getUnitId());
            list.add(item);
        }
        return list;
    }

    private CostDetailBillingPatientInfo detailBillingPatientInfo(HcSettleMaster settleMaster) {
        //查询体检患者信息
        QueryWrapper<HcPersonInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", settleMaster.getHospitalId());
        queryWrapper.eq("person_id", settleMaster.getPersonId());
        List<HcPersonInfo> list = hcPersonInfoService.list(queryWrapper);
        HcPersonInfo hcPersonInfo = null;
        if(list.size()>0){
            hcPersonInfo = list.get(0);
        }
        if(hcPersonInfo!=null){
            CostDetailBillingPatientInfo patientInfo = new CostDetailBillingPatientInfo();
            patientInfo.setPatientId(hcPersonInfo.getPatientId());
            patientInfo.setPatientName(hcPersonInfo.getName());
            patientInfo.setPatientType("3");
            patientInfo.setIdentityType("4");
            patientInfo.setIdentityNum(hcPersonInfo.getIdNo());
            patientInfo.setVisitId(settleMaster.getPersonVisitId().toString());
            patientInfo.setMedInstCode(medInstCode);
            patientInfo.setAreaCode(areaCode);
            patientInfo.setOperator("");
            patientInfo.setPaiVisitId(settleMaster.getPersonVisitId().toString());
            if(StringUtils.isEmpty(hcPersonInfo.getExamClass())){
                patientInfo.setExamType("1");
            }else{
                //查询码表
                List<CodeTableItem> codeTableItems= client.mdmCodeQuery("BCS0035", "detailBillingPatientInfo").get(0).getItemList().getItem();
                HcPersonInfo finalHcPersonInfo = hcPersonInfo;
                List<CodeTableItem> examClassList = codeTableItems.stream()
                        .filter(codeTableItem -> finalHcPersonInfo.getExamClass().equals(codeTableItem.getItemName()))
                        .collect(Collectors.toList());
                if(examClassList.size()>0){
                    patientInfo.setExamType(examClassList.get(0).getItemValue());
                }else{
                    patientInfo.setExamType("1");
                }
            }
            patientInfo.setExamCompanyNo(settleMaster.getUnitId());
            patientInfo.setExamCompanyName(settleMaster.getUnitId());
            patientInfo.setCurrentOrgdCode("95");//体检中心
            return patientInfo;
        }
        return null;
    }
}
