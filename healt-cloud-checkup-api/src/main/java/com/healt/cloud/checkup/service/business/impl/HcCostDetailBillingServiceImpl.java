package com.healt.cloud.checkup.service.business.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.mapper.HcCostDetailBillingMapper;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.service.business.HcCostDetailBillingService;
import com.healt.cloud.checkup.service.ws.his.companyCostBack.CompanyCostBackReqBody;
import com.healt.cloud.checkup.service.ws.his.companyCostBack.CompanyCostChargeItem;
import com.healt.cloud.checkup.service.ws.his.companyCostBack.CompanyCostChargeItemList;
import com.healt.cloud.checkup.service.ws.his.companyCostBack.CompanyCostChargeState;
import com.healt.cloud.checkup.service.ws.his.costDetailReturn.*;
import com.healt.cloud.checkup.service.ws.his.costRefundApply.ChargeState;
import com.healt.cloud.checkup.service.ws.his.costRefundApply.CostRefundApplyReqBody;
import com.healt.cloud.checkup.service.ws.his.costRefundApply.Item;
import com.healt.cloud.checkup.vo.busniess.costDetail.CostDetailBillingDictVo;
import com.healt.cloud.checkup.vo.busniess.costDetail.CostDetailBillingVo;
import com.healt.cloud.checkup.vo.busniess.costDetail.SaveCostDetailBillingListVo;
import com.healt.cloud.checkup.vo.busniess.costDetail.SaveCostDetailBillingVo;
import com.healt.cloud.checkup.service.ws.WebServiceClient;
import com.healt.cloud.checkup.service.ws.his.costDetailBilling.CostDetailBillingChargeItem;
import com.healt.cloud.checkup.service.ws.his.costDetailBilling.CostDetailBillingPatientInfo;
import com.healt.cloud.checkup.vo.companyCostCharge.CompanyCostChargeItemVo;
import com.healt.cloud.checkup.vo.companyCostCharge.CompanyCostChargePatientInfo;
import com.healt.cloud.checkup.vo.companyCostCharge.CompanyCostChargeStateVo;
import com.healt.cloud.checkup.vo.companyCostCharge.CompanyCostChargeStateVoList;
import com.healt.cloud.checkup.vo.saveCostDetailReturn.SaveCostDetailReturn;
import com.healt.cloud.checkup.vo.saveCostDetailReturn.SaveCostDetailReturnVo;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.PropertiesUtils;
import com.healt.cloud.resultex.exception.CommonException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-07-14 12:41
 * @description: TODO
 */
@Service
public class HcCostDetailBillingServiceImpl implements HcCostDetailBillingService {

    private String areaCode = PropertiesUtils.AREACODE;

    private String medInstCode = PropertiesUtils.MEDINSTCODE;

    @Autowired
    private CostDetailBillingService costDetailBillingService;

    @Autowired
    HcPersonInfoService hcPersonInfoService;

    @Autowired
    private WebServiceClient client;

    @Autowired
    private HcCostDetailBillingMapper hcCostDetailBillingMapper;

    @Autowired
    private HcPersonAppregItemsService hcPersonAppregItemsService;

    @Autowired
    private CompanyCostBackService companyCostBackService;

    @Autowired
    private HcUnitInfoService hcUnitInfoService;

    @Override
    public List<CostDetailBilling> findCostDetailBilling(String hospitalId, String personId, String personVisitId) {
        QueryWrapper<CostDetailBilling> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("PERSON_VISIT_ID", personVisitId)
                .eq("PERSON_ID", personId)
                .eq("HOSPITAL_ID", hospitalId);
        List<CostDetailBilling> list = costDetailBillingService.list(queryWrapper);
        if(list.size()==0){
            list.add(new CostDetailBilling());
        }
        return list;
    }

    //收费
    @Override
    public void saveCostDetailBillingList(SaveCostDetailBillingListVo saveCostDetailBillingList) {

        String hospitalId = saveCostDetailBillingList.getSaveCostDetailBilling().get(0).getCostDetailBilling().get(0).getHospitalId();
        String operator = saveCostDetailBillingList.getSaveCostDetailBilling().get(0).getCostDetailBilling().get(0).getApplyDoctorCode();

        //调用接口，传输收费数据
        for(SaveCostDetailBillingVo saveCostDetailBilling : saveCostDetailBillingList.getSaveCostDetailBilling()){
            CostDetailBillingPatientInfo detailBillingPatientInfo = this.detailBillingPatientInfo(saveCostDetailBilling, hospitalId, operator);
            detailBillingPatientInfo.setAreaCode(areaCode);
            detailBillingPatientInfo.setMedInstCode(medInstCode);
            List<CostDetailBillingChargeItem> chargeItemList = this.chargeItemList(saveCostDetailBilling.getCostDetailBilling());
            String result = client.costDetailBilling(detailBillingPatientInfo, chargeItemList, "saveCostDetailBillingList");
            if("CA".equals(result)){//发送成功

                List<CostDetailBillingVo> list = saveCostDetailBilling.getCostDetailBilling();
                List<CostDetailBilling> costDetailBillings = new ArrayList<>();
                for(CostDetailBillingVo costDetailBillingVo : list){
                    CostDetailBilling costDetailBilling = new CostDetailBilling();
                    BeanUtils.copyProperties(saveCostDetailBilling, costDetailBilling);
                    BeanUtils.copyProperties(costDetailBillingVo, costDetailBilling);
                    costDetailBillings.add(costDetailBilling);
                }
                costDetailBillingService.saveBatch(costDetailBillings);

                //更新体检预约项目上传HIS收费标记为1
                String itemPackCodeCache = "";
                for(CostDetailBillingVo costDetailBillingVo : list){
                    String itemPackCode = costDetailBillingVo.getItemPackCode();
                    if(itemPackCode.equals(itemPackCodeCache)){
                        continue;
                    }
                    //select sum(CHARGES) from cost_detail_billing where orderid = '83057'

                    BigDecimal sumCharges = hcCostDetailBillingMapper.sumCharges(costDetailBillingVo.getOrderId());
                    UpdateWrapper<HcPersonAppregItems> updateWrapper = new UpdateWrapper<>();
                    updateWrapper.set("UPLOAD_FLAG", "1");
                    updateWrapper.set("charges", sumCharges);
                    updateWrapper.eq("HOSPITAL_ID", costDetailBillingVo.getHospitalId())
                            .eq("PERSON_ID", saveCostDetailBilling.getPersonId())
                            .eq("PERSON_VISIT_ID", saveCostDetailBilling.getPersonVisitId())
                            .eq("ITEM_PACK_CODE", costDetailBillingVo.getItemPackCode())
                            .eq("ITEM_NO", costDetailBillingVo.getHcItemNo());
                    itemPackCodeCache = itemPackCode;
                    hcPersonAppregItemsService.update(updateWrapper);
                }
            }
        }
    }

    @Override
    public List<CostDetailBilling> findCostDetailBillingFilter(CostDetailBillingDictVo costDetailBillingDictVo) {
        List<CostDetailBilling> list = hcCostDetailBillingMapper.findCostDetailBillingFilter(costDetailBillingDictVo);
        if(list.size()==0){
            list.add(new CostDetailBilling());
        }
        return list;
    }

    @Autowired
    private CostDetailReturnService costDetailReturnService;

    //退费
    @Override
    public void saveCostDetailReturn(SaveCostDetailReturnVo saveCostDetailReturnVo) {
        List<CostDetailReturn> costDetailReturnList = new ArrayList<>();
        List<SaveCostDetailReturn> saveCostDetailReturnList = saveCostDetailReturnVo.getSaveCostDetailReturn();
        CostRefundApplyReqBody body = new CostRefundApplyReqBody();
        ChargeState chargeState = new ChargeState();
        body.setChargeState(chargeState);
        List<Item> itemList = new ArrayList<>();
        ChargeState.ItemListVo itemListVo = new ChargeState.ItemListVo();
        for(SaveCostDetailReturn saveCostDetailReturn :  saveCostDetailReturnList){

            chargeState.setItemListVo(itemListVo);
            chargeState.setExamType(saveCostDetailReturn.getEXAMTYPE());
            chargeState.setPatientType(saveCostDetailReturn.getPATIENTTYPE());
            chargeState.setExamNo(saveCostDetailReturn.getEXAMCOMPANYNO());
            chargeState.setPatientId(saveCostDetailReturn.getPATIENTID());
            chargeState.setVisitId(saveCostDetailReturn.getVISITID());
            chargeState.setAreaCode(PropertiesUtils.AREACODE);
            chargeState.setCancType("1");//1 发起退费申请，2 撤销退费申请
            List<com.healt.cloud.checkup.vo.saveCostDetailReturn.CostDetailBillingVo> costDetailBillingVoList = saveCostDetailReturn.getCostDetailBilling();
            for(com.healt.cloud.checkup.vo.saveCostDetailReturn.CostDetailBillingVo vo : costDetailBillingVoList){

                //退费时需保存退费中间表 COST_DETAIL_RETURN
                CostDetailReturn costDetailReturn = new CostDetailReturn();
                costDetailReturn.setPaivisitid(saveCostDetailReturn.getPAIVISITID());
                costDetailReturn.setPersonId(saveCostDetailReturn.getPERSON_ID());
                costDetailReturn.setPersonVisitId(Integer.parseInt(saveCostDetailReturn.getPERSON_VISIT_ID()));
                costDetailReturn.setUnit(saveCostDetailReturn.getUNIT_ID());
                if(StringUtils.isNotEmpty(saveCostDetailReturn.getUNIT_VISIT_ID())){
                    costDetailReturn.setUnitVisitId(Integer.parseInt(saveCostDetailReturn.getUNIT_VISIT_ID()));
                }
                costDetailReturn.setPatientname(saveCostDetailReturn.getPATIENTNAME());
                costDetailReturn.setPatienttype(saveCostDetailReturn.getPATIENTTYPE());
                if(StringUtils.isNotEmpty(saveCostDetailReturn.getVISITID())){
                    costDetailReturn.setVisitid(Integer.parseInt(saveCostDetailReturn.getVISITID()));
                }
                costDetailReturn.setPaivisitid(saveCostDetailReturn.getPAIVISITID());
                costDetailReturn.setExamtype(saveCostDetailReturn.getEXAMTYPE());
                costDetailReturn.setExamcompanyno(saveCostDetailReturn.getEXAMCOMPANYNO());
                costDetailReturn.setExamcompanyname(saveCostDetailReturn.getEXAMCOMPANYNAME());
                costDetailReturn.setCurrentorgdcode(saveCostDetailReturn.getCURRENTORGDCODE());
                costDetailReturn.setCurrentwardcode(saveCostDetailReturn.getCURRENTWARDCODE());
                costDetailReturn.setOrderid(vo.getORDERID());
                costDetailReturn.setApplyno(vo.getAPPLYNO());
                costDetailReturn.setClinictype(vo.getCLINICTYPE());
                costDetailReturn.setFeeitemclass(vo.getFEEITEMCLASS());
                costDetailReturn.setClinicitemid(vo.getCLINICITEMID());
                costDetailReturn.setClinicitemname(vo.getCLINICITEMNAME());
                costDetailReturn.setItemtype(vo.getITEMTYPE());
                costDetailReturn.setFeeitemid(vo.getFEEITEMID());
                costDetailReturn.setFeeitemname(vo.getFEEITEMNAME());
                costDetailReturn.setDrugspec(vo.getDRUGSPEC());
                costDetailReturn.setPharmacyfactoryname(vo.getPHARMACYFACTORYNAME());
                if(StringUtils.isNotEmpty(vo.getNUM())){
                    costDetailReturn.setNum(new BigDecimal(vo.getNUM()));
                }
                costDetailReturn.setUnit(vo.getUNIT());
                if(StringUtils.isNotEmpty(vo.getUNITPRICE())){
                    costDetailReturn.setUnitprice(new BigDecimal(vo.getUNITPRICE()));
                }
                if(StringUtils.isNotEmpty(vo.getTOTALPRICE())){
                    costDetailReturn.setUnitcoeff(new BigDecimal(vo.getTOTALPRICE()));
                }
                if(StringUtils.isNotEmpty(vo.getCHARGES())){
                    costDetailReturn.setCharges(new BigDecimal(vo.getCHARGES()));
                }
                costDetailReturn.setClassonrcpt(vo.getCLASSONRCPT());
                costDetailReturn.setApplydoctorcode(vo.getAPPLYDOCTORCODE());
                costDetailReturn.setApplydoctorname(vo.getAPPLYDOCTORNAME());
                costDetailReturn.setApplyorgcode(vo.getAPPLYORGCODE());
                costDetailReturn.setApplyorgname(vo.getAPPLYORGNAME());
                costDetailReturn.setExecorgcode(vo.getEXECORGCODE());
                costDetailReturn.setExecorgname(vo.getEXECORGNAME());
                costDetailReturn.setChargedate(vo.getCHARGEDATE());
                costDetailReturn.setEnterdate(vo.getENTERDATE());
                costDetailReturn.setHospitalId(vo.getHOSPITAL_ID());
                costDetailReturn.setItemPackCode(vo.getITEM_PACK_CODE());
                if(StringUtils.isNotEmpty(vo.getHC_ITEM_NO())){
                    costDetailReturn.setHcItemNo(Integer.parseInt(vo.getHC_ITEM_NO()));
                }
                costDetailReturn.setOldRekid(saveCostDetailReturn.getREKID());
                costDetailReturn.setCancreason(saveCostDetailReturn.getCANCREASON());
                costDetailReturnList.add(costDetailReturn);

                chargeState.setApplyDoctorCode(vo.getAPPLYDOCTORCODE());
                chargeState.setApplyDoctorName(vo.getAPPLYDOCTORNAME());
                chargeState.setApplyOrgCode(vo.getAPPLYORGCODE());
                chargeState.setApplyOrgName(vo.getAPPLYORGNAME());
                chargeState.setApplyDate(DateUtils.getDateYYYYMMDDHHMMSS());
                Item item = new Item();
                item.setOrderId(vo.getORDERID());
                item.setClinicItemId(vo.getCLINICITEMID());
                item.setClinicItemName(vo.getCLINICITEMNAME());
                item.setFeeItemId(vo.getFEEITEMID());
                item.setFeeItemName(vo.getFEEITEMNAME());
                item.setDrugSpec(vo.getDRUGSPEC());
                item.setNum(vo.getNUM());
                item.setUnit(vo.getUNIT());
                item.setUnitPrice(vo.getUNITPRICE());
                itemList.add(item);
            }
            itemListVo.setItem(itemList);
        }
        String result = client.costRefundApply(body,"saveCostDetailReturn");
        if("CA".equals(result)){

            for(CostDetailReturn costDetailReturn : costDetailReturnList){
                try {
                    costDetailReturnService.save(costDetailReturn);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    //作废明细申请
    @Override
    public void cancelCostDetailBillingList(SaveCostDetailBillingListVo saveCostDetailBillingList) {
        List<SaveCostDetailBillingVo> saveCostDetailBillingVoList = saveCostDetailBillingList.getSaveCostDetailBilling();
        for(SaveCostDetailBillingVo saveCostDetailBillingVo : saveCostDetailBillingVoList){
            CostDetailReturnReqBody body = new CostDetailReturnReqBody();
            PatientInfo patientInfo = new PatientInfo();
            ChargeItemList chargeItemList = new ChargeItemList();
            List<ChargeItem> chargeItems = new ArrayList<>();
            chargeItemList.setChargeItem(chargeItems);
            TotalMoney totalMoney = new TotalMoney();
            body.setPatientInfo(patientInfo);
            body.setChargeItemList(chargeItemList);
            body.setTotalRefundMoney(totalMoney);

            patientInfo.setPatientId(saveCostDetailBillingVo.getPatientId());
            patientInfo.setPatientName(saveCostDetailBillingVo.getPatientName());
            patientInfo.setPatientType(saveCostDetailBillingVo.getPatientType());
            patientInfo.setIdentityType("4");//介质类型，4：身份证
            //根据personId查询体检人信息
            QueryWrapper<HcPersonInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("person_id", saveCostDetailBillingVo.getPersonId());
            HcPersonInfo hcPersonInfo = hcPersonInfoService.getOne(queryWrapper);
            patientInfo.setIdentityNum(hcPersonInfo.getIdNo());
            patientInfo.setVisitId(saveCostDetailBillingVo.getVisitId().toString());
            patientInfo.setMedInstCode(PropertiesUtils.MEDINSTCODE);
            patientInfo.setAreaCode(PropertiesUtils.AREACODE);
            patientInfo.setOperator(saveCostDetailBillingVo.getCostDetailBilling().get(0).getApplyDoctorCode());
            patientInfo.setPaiVisitId(saveCostDetailBillingVo.getPaiVisitId());
            patientInfo.setExamType(saveCostDetailBillingVo.getExamType());
            patientInfo.setExamCompanyNo(saveCostDetailBillingVo.getExamCompanyNo());
            patientInfo.setExamCompanyName(saveCostDetailBillingVo.getExamCompanyName());

            List<CostDetailBillingVo> costDetailBilling = saveCostDetailBillingVo.getCostDetailBilling();

            BigDecimal totalRefundMoney = new BigDecimal(0);

            for(CostDetailBillingVo costDetailBillingVo : costDetailBilling){
                ChargeItem chargeItem = new ChargeItem();
                chargeItem.setOrderId(costDetailBillingVo.getOrderId());
                chargeItem.setClinicItemId(costDetailBillingVo.getClinicItemId());
                chargeItem.setClinicItemName(costDetailBillingVo.getClinicItemName());
                chargeItem.setItemType(costDetailBillingVo.getItemType());
                chargeItem.setFeeItemId(costDetailBillingVo.getFeeItemId());
                chargeItem.setDrugSpec(costDetailBillingVo.getDrugSpec());
                chargeItem.setNum(costDetailBillingVo.getNum().toString());
                chargeItem.setUnit(costDetailBillingVo.getUnit());
                if(costDetailBillingVo.getUnitPrice()!=null){
                    chargeItem.setUnitPrice(costDetailBillingVo.getUnitPrice().toString());
                }
                if(costDetailBillingVo.getUnitCoeff()!=null){
                    chargeItem.setUnitCoeff(costDetailBillingVo.getUnitCoeff().toString());
                }
                if(costDetailBillingVo.getTotalPrice()!=null){
                    chargeItem.setTotalPrice(costDetailBillingVo.getTotalPrice().toString());
                    totalRefundMoney = totalRefundMoney.add(costDetailBillingVo.getTotalPrice());
                }
                chargeItem.setApplyDoctorCode(costDetailBillingVo.getApplyDoctorCode());
                chargeItem.setApplyDoctorName(costDetailBillingVo.getApplyDoctorName());
                chargeItem.setApplyOrgCode(costDetailBillingVo.getApplyOrgCode());
                chargeItem.setApplyOrgName(costDetailBillingVo.getApplyOrgName());
                chargeItem.setExecOrgCode(costDetailBillingVo.getExecOrgCode());
                chargeItem.setExecOrgName(costDetailBillingVo.getExecOrgName());
                chargeItems.add(chargeItem);
            }
            totalMoney.setTotalRefundMoney(totalRefundMoney.toString());

            String result = client.costDetailReturn(body, "cancelCostDetailBillingList");
            //String result = "CA";
            if("CA".equals(result)){
                //更新hc_person_appreg_item表将对应的upload_flag字段设置为null，
                //select * from hc_person_appreg_items a where a.person_id =''
                //  and a.person_visit_id ='' and a.bill_indicator ='0' and a.upload_flag = '1' and a.tj_order_id is null
                LambdaUpdateWrapper<HcPersonAppregItems> updateWrapper = new LambdaUpdateWrapper<>();
                HcPersonAppregItems hcPersonAppregItems = new HcPersonAppregItems();
                hcPersonAppregItems.setUploadFlag("");
                updateWrapper.set(HcPersonAppregItems::getUploadFlag, "");
                updateWrapper.eq(HcPersonAppregItems::getPersonId, saveCostDetailBillingVo.getPersonId());
                updateWrapper.eq(HcPersonAppregItems::getPersonVisitId, saveCostDetailBillingVo.getVisitId().toString());
                updateWrapper.eq(HcPersonAppregItems::getBillIndicator,"0");
                updateWrapper.eq(HcPersonAppregItems::getUploadFlag, "1");
                updateWrapper.isNull(HcPersonAppregItems::getTjOrderId);
                hcPersonAppregItemsService.update(updateWrapper);
                //删除cost_detail_billing表中的记录
                //select * from cost_detail_billing a whre  a.person_id ='' and a.person_visit_id ='' and a.rekid is null ;
                LambdaUpdateWrapper<CostDetailBilling> costDetailBillingLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
                costDetailBillingLambdaUpdateWrapper.eq(CostDetailBilling::getPersonId, saveCostDetailBillingVo.getPersonId());
                costDetailBillingLambdaUpdateWrapper.eq(CostDetailBilling::getPersonVisitId, saveCostDetailBillingVo.getVisitId());
                costDetailBillingLambdaUpdateWrapper.isNull(CostDetailBilling::getRekid);
                costDetailBillingService.remove(costDetailBillingLambdaUpdateWrapper);
            }
        }
    }

    //单位缴费申请/撤销
    @Override
    public void companyCostBack(CompanyCostChargeStateVoList companyCostChargeStateVoList) {

        List<CompanyCostChargeStateVo> companyCostChargeStateVos = companyCostChargeStateVoList.getCompanyCostChargeStateVoList();

        for(CompanyCostChargeStateVo companyCostChargeStateVo : companyCostChargeStateVos){
            //1 发起申请，2 撤销申请
            String cancType = companyCostChargeStateVo.getCancType();
            if("1".equals(cancType)){
                //生成Orderid；SQ_COMPANY_ORDER_ID
                String orderId = hcCostDetailBillingMapper.findCompanyOrderId().toString();
                //根据unitId查询单位信息
                LambdaQueryWrapper<HcUnitInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                lambdaQueryWrapper.eq(HcUnitInfo::getUnitId, companyCostChargeStateVo.getUnitId());
                List<HcUnitInfo> list = hcUnitInfoService.list(lambdaQueryWrapper);
                HcUnitInfo hcUnitInfo = list.get(0);
                companyCostChargeStateVo.setExamCompanyID(hcUnitInfo.getExamcompanyid());
                companyCostChargeStateVo.setAreaCode(PropertiesUtils.AREACODE);
                companyCostChargeStateVo.setMedInstId(PropertiesUtils.MEDINSTCODE);

                CompanyCostBackReqBody body = new CompanyCostBackReqBody();
                CompanyCostChargeState chargeState = new CompanyCostChargeState();
                body.setChargeState(chargeState);
                if(StringUtils.isNotEmpty(companyCostChargeStateVo.getApplyDate())){
                    if(companyCostChargeStateVo.getApplyDate().contains("/")){
                        chargeState.setApplyDate(DateUtils.getDateYYYYMMDDHHMMSS(DateUtils.parseString(companyCostChargeStateVo.getApplyDate(), "yyyy/MM/dd hh:mm:ss")));
                    }else if(companyCostChargeStateVo.getApplyDate().contains("-")){
                        chargeState.setApplyDate(DateUtils.getDateYYYYMMDDHHMMSS(DateUtils.parseString(companyCostChargeStateVo.getApplyDate(), "yyyy-MM-dd hh:mm:ss")));
                    }
                }
                chargeState.setApplyOrgCode(companyCostChargeStateVo.getApplyOrgCode());
                chargeState.setApplyOrgName(companyCostChargeStateVo.getApplyOrgName());
                chargeState.setAreaCode(companyCostChargeStateVo.getAreaCode());
                chargeState.setCancType(companyCostChargeStateVo.getCancType());
                chargeState.setExamCompanyID(companyCostChargeStateVo.getExamCompanyID());
                chargeState.setExamCompanyName(companyCostChargeStateVo.getExamCompanyName());
                chargeState.setExamCompanyNo(companyCostChargeStateVo.getExamCompanyNo());
                chargeState.setExecOrgCode(companyCostChargeStateVo.getExecOrgCode());
                chargeState.setExecOrgName(companyCostChargeStateVo.getExecOrgName());
                chargeState.setMedInstId(companyCostChargeStateVo.getMedInstId());
                chargeState.setApplyDate(DateUtils.getDateYYYYMMDDHHMMSS());

                List<CompanyCostChargeItem> chargeItemList = new ArrayList<>();
                CompanyCostChargeItemList chargeItemListBean = new CompanyCostChargeItemList();
                chargeState.setChargeItemList(chargeItemListBean);
                chargeItemListBean.setChargeItem(chargeItemList);
                List<CompanyCostChargeItemVo> chargeItemVoList = companyCostChargeStateVo.getChargeItem();
                for(CompanyCostChargeItemVo vo : chargeItemVoList){
                    CompanyCostChargeItem item = new CompanyCostChargeItem();
                    chargeItemList.add(item);
                    item.setClinicItemId(vo.getClinicItemId());
                    item.setClinicType(vo.getClinicType());
                    item.setDesc(vo.getDesc());
                    item.setDiscountsPrice(vo.getDiscountsPrice());
                    item.setFeeItemClass(vo.getFeeItemClass());
                    item.setNum(vo.getNum());
                    item.setOperator(vo.getOperatorId());
                    item.setOrderId(orderId);
                    item.setRealPrice(vo.getRealPrice());
                    item.setReceivablePrice(vo.getReceivablePrice());
                    item.setUnit(vo.getUnit());
                    item.setUnitPrice(vo.getUnitPrice());
                }

                String result = client.companyCostBack(body, "companyCostBack");

                if("CA".equals(result)){//申请发送成功，人员更新标记, 插入团检费用表
                    List<CompanyCostChargePatientInfo> patientInfos = companyCostChargeStateVo.getPatientInfos();
                    for(CompanyCostChargePatientInfo info : patientInfos){
                        LambdaUpdateWrapper<HcPersonAppregItems> updateWrapper = new LambdaUpdateWrapper<>();
                        updateWrapper.set(HcPersonAppregItems :: getUploadFlag, "1");
                        updateWrapper.set(HcPersonAppregItems :: getTjOrderId, orderId);
                        updateWrapper.set(HcPersonAppregItems :: getCharges, info.getCharges());
                        updateWrapper.eq(HcPersonAppregItems :: getPersonId, info.getPersonId());
                        updateWrapper.eq(HcPersonAppregItems :: getPersonVisitId, info.getPersonVisitId());
                        updateWrapper.eq(HcPersonAppregItems :: getItemPackCode, info.getItemPackCode());
                        updateWrapper.eq(HcPersonAppregItems :: getItemNo, info.getItemNo());
                        hcPersonAppregItemsService.update(updateWrapper);
                    }
                    CompanyCostBack companyCostBack = new CompanyCostBack();
                    companyCostBack.setExamcompanyid(companyCostChargeStateVo.getExamCompanyID());
                    companyCostBack.setExamcompanyno(companyCostChargeStateVo.getExamCompanyNo());
                    companyCostBack.setExamcompanyname(companyCostChargeStateVo.getExamCompanyName());
                    companyCostBack.setApplyorgcode(companyCostChargeStateVo.getApplyOrgCode());
                    companyCostBack.setApplyorgname(companyCostChargeStateVo.getApplyOrgName());
                    companyCostBack.setExecorgcode(companyCostChargeStateVo.getExecOrgCode());
                    companyCostBack.setExecorgname(companyCostChargeStateVo.getExecOrgName());
                    companyCostBack.setApplydate(companyCostChargeStateVo.getApplyDate());
                    companyCostBack.setAreacode(companyCostChargeStateVo.getAreaCode());
                    companyCostBack.setCanctype(companyCostChargeStateVo.getCancType());
                    companyCostBack.setOrderid(orderId);
                    companyCostBack.setClinictype(companyCostChargeStateVo.getChargeItem().get(0).getClinicType());
                    companyCostBack.setFeeitemclass(companyCostChargeStateVo.getChargeItem().get(0).getFeeItemClass());
                    companyCostBack.setClinicitemid(companyCostChargeStateVo.getChargeItem().get(0).getClinicItemId());
                    companyCostBack.setNum(companyCostChargeStateVo.getChargeItem().get(0).getNum());
                    companyCostBack.setUnit(companyCostChargeStateVo.getChargeItem().get(0).getUnit());
                    companyCostBack.setUnitprice(companyCostChargeStateVo.getChargeItem().get(0).getUnitPrice());
                    companyCostBack.setReceivableprice(companyCostChargeStateVo.getChargeItem().get(0).getReceivablePrice());
                    companyCostBack.setDiscountsprice(companyCostChargeStateVo.getChargeItem().get(0).getDiscountsPrice());
                    companyCostBack.setRealprice(companyCostChargeStateVo.getChargeItem().get(0).getRealPrice());
                    companyCostBack.setOperator(companyCostChargeStateVo.getChargeItem().get(0).getOperatorId());
                    companyCostBack.setDescBz(companyCostChargeStateVo.getChargeItem().get(0).getDesc());
                    companyCostBack.setUnitId(companyCostChargeStateVo.getUnitId());
                    companyCostBack.setUnitVisitId(companyCostChargeStateVo.getUnitVisitId());
                    companyCostBackService.save(companyCostBack);
                }
            }
            else if("2".equals(cancType)){

                String orderId = companyCostChargeStateVo.getChargeItem().get(0).getOrderId();
                //根据unitId查询单位信息
                LambdaQueryWrapper<HcUnitInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                lambdaQueryWrapper.eq(HcUnitInfo::getUnitId, companyCostChargeStateVo.getUnitId());
                List<HcUnitInfo> list = hcUnitInfoService.list(lambdaQueryWrapper);
                HcUnitInfo hcUnitInfo = list.get(0);
                companyCostChargeStateVo.setExamCompanyID(hcUnitInfo.getExamcompanyid());
                companyCostChargeStateVo.setExamCompanyName(hcUnitInfo.getUnitName());
                companyCostChargeStateVo.setAreaCode(PropertiesUtils.AREACODE);
                companyCostChargeStateVo.setMedInstId(PropertiesUtils.MEDINSTCODE);

                CompanyCostBackReqBody body = new CompanyCostBackReqBody();
                CompanyCostChargeState chargeState = new CompanyCostChargeState();
                body.setChargeState(chargeState);
                if(StringUtils.isNotEmpty(companyCostChargeStateVo.getApplyDate())){
                    if(companyCostChargeStateVo.getApplyDate().contains("/")){
                        chargeState.setApplyDate(DateUtils.getDateYYYYMMDDHHMMSS(DateUtils.parseString(companyCostChargeStateVo.getApplyDate(), "yyyy/MM/dd hh:mm:ss")));
                    }else if(companyCostChargeStateVo.getApplyDate().contains("-")){
                        chargeState.setApplyDate(DateUtils.getDateYYYYMMDDHHMMSS(DateUtils.parseString(companyCostChargeStateVo.getApplyDate(), "yyyy-MM-dd hh:mm:ss")));
                    }
                }
                chargeState.setApplyOrgCode(companyCostChargeStateVo.getApplyOrgCode());
                chargeState.setApplyOrgName(companyCostChargeStateVo.getApplyOrgName());
                chargeState.setAreaCode(companyCostChargeStateVo.getAreaCode());
                chargeState.setCancType(companyCostChargeStateVo.getCancType());
                chargeState.setExamCompanyID(companyCostChargeStateVo.getExamCompanyID());
                chargeState.setExamCompanyName(companyCostChargeStateVo.getExamCompanyName());
                chargeState.setExamCompanyNo(companyCostChargeStateVo.getExamCompanyNo());
                chargeState.setExecOrgCode(companyCostChargeStateVo.getExecOrgCode());
                chargeState.setExecOrgName(companyCostChargeStateVo.getExecOrgName());
                chargeState.setMedInstId(companyCostChargeStateVo.getMedInstId());
                chargeState.setApplyDate(DateUtils.getDateYYYYMMDDHHMMSS());

                List<CompanyCostChargeItem> chargeItemList = new ArrayList<>();
                CompanyCostChargeItemList chargeItemListBean = new CompanyCostChargeItemList();
                chargeState.setChargeItemList(chargeItemListBean);
                chargeItemListBean.setChargeItem(chargeItemList);
                List<CompanyCostChargeItemVo> chargeItemVoList = companyCostChargeStateVo.getChargeItem();
                for(CompanyCostChargeItemVo vo : chargeItemVoList){
                    CompanyCostChargeItem item = new CompanyCostChargeItem();
                    chargeItemList.add(item);
                    item.setClinicItemId(vo.getClinicItemId());
                    item.setClinicType(vo.getClinicType());
                    item.setDesc(vo.getDesc());
                    item.setDiscountsPrice(vo.getDiscountsPrice());
                    item.setFeeItemClass(vo.getFeeItemClass());
                    item.setNum(vo.getNum());
                    item.setOperator(vo.getOperatorId());
                    item.setOrderId(orderId);
                    item.setRealPrice(vo.getRealPrice());
                    item.setReceivablePrice(vo.getReceivablePrice());
                    item.setUnit(vo.getUnit());
                    item.setUnitPrice(vo.getUnitPrice());
                }
                String result = client.companyCostBack(body, "companyCostBack");
                if("CA".equals(result)){//申请发送成功，人员更新标记, 插入团检费用表
                    LambdaUpdateWrapper<HcPersonAppregItems> updateWrapper = new LambdaUpdateWrapper<>();
                    updateWrapper.eq(HcPersonAppregItems :: getTjOrderId, orderId);
                    updateWrapper.set(HcPersonAppregItems :: getUploadFlag, "");
                    updateWrapper.set(HcPersonAppregItems :: getTjOrderId, "");
                    hcPersonAppregItemsService.update(updateWrapper);

                    LambdaUpdateWrapper<CompanyCostBack> companyCostBackLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
                    companyCostBackLambdaUpdateWrapper.eq(CompanyCostBack::getOrderid, orderId);
                    companyCostBackLambdaUpdateWrapper.set(CompanyCostBack::getCanctype, "2");
                    companyCostBackService.update(companyCostBackLambdaUpdateWrapper);
                }
            }
        }
    }

    @Override
    public List<CompanyCostBack> findCompanyCostBacks(String unitId, String unitVisitId, String canctype) {
        LambdaQueryWrapper<CompanyCostBack> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(CompanyCostBack::getUnitId, unitId);
        lambdaQueryWrapper.eq(CompanyCostBack::getUnitVisitId, unitVisitId);
        lambdaQueryWrapper.eq(CompanyCostBack::getCanctype, canctype);
        lambdaQueryWrapper.isNull(CompanyCostBack::getRekid);
        List<CompanyCostBack> list = companyCostBackService.list(lambdaQueryWrapper);
        if(list.size() == 0){
            list.add(new CompanyCostBack());
        }
        return list;
    }

    private List<CostDetailBillingChargeItem> chargeItemList(List<CostDetailBillingVo> costDetailBilling) {
        List<CostDetailBillingChargeItem> items = new ArrayList<>();
        for(CostDetailBillingVo costDetailBillingVo : costDetailBilling){
            CostDetailBillingChargeItem item = new CostDetailBillingChargeItem();
            BeanUtils.copyProperties(costDetailBillingVo, item);
            item.setOperator(costDetailBillingVo.getApplyDoctorCode());
            //解决类型不一致造成的无法赋值的问题
            item.setNum(costDetailBillingVo.getNum().toString());
            if(costDetailBillingVo.getTotalPrice()!=null){
                item.setTotalPrice(costDetailBillingVo.getTotalPrice().toString());
            }
            if(costDetailBillingVo.getUnitPrice()!=null){
                item.setUnitPrice(costDetailBillingVo.getUnitPrice().toString());
            }
            if(costDetailBillingVo.getTotalPrice()!=null){
                item.setTotalPrice(costDetailBillingVo.getTotalPrice().toString());
            }
            if(costDetailBillingVo.getCharges()!=null){
                item.setCharges(costDetailBillingVo.getCharges().toString());
            }
            items.add(item);
        }
        return items;
    }

    private CostDetailBillingPatientInfo detailBillingPatientInfo(SaveCostDetailBillingVo saveCostDetailBilling, String hospitalId, String operator) {
        CostDetailBillingPatientInfo patientInfo = new CostDetailBillingPatientInfo();
        BeanUtils.copyProperties(saveCostDetailBilling, patientInfo);
        //解决类型不一致造成的无法赋值的问题
        patientInfo.setVisitId(saveCostDetailBilling.getVisitId().toString());
        patientInfo.setIdentityType("4");
        //根据personId查询体检人信息
        QueryWrapper<HcPersonInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("person_id", saveCostDetailBilling.getPersonId());
        queryWrapper.eq("hospital_id", hospitalId);
        HcPersonInfo hcPersonInfo = hcPersonInfoService.getOne(queryWrapper);
        patientInfo.setIdentityNum(hcPersonInfo.getIdNo());
        patientInfo.setOperator(operator);
        return patientInfo;
    }
}
