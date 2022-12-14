package com.healt.cloud.checkup.service.ws;

import com.healt.cloud.checkup.entity.HisSpecimanDict;
import com.healt.cloud.checkup.entity.WebserviceLog;
import com.healt.cloud.checkup.service.HisSpecimanDictService;
import com.healt.cloud.checkup.service.WebserviceLogService;
import com.healt.cloud.checkup.service.ws.his.*;
import com.healt.cloud.checkup.service.ws.his.archive.ApplyRequestBody;
import com.healt.cloud.checkup.service.ws.his.archive.ArchiveCreateCardInfo;
import com.healt.cloud.checkup.service.ws.his.archive.ArchiveCreatePatientInfo;
import com.healt.cloud.checkup.service.ws.his.archive.ArchiveCreateReqBody;
import com.healt.cloud.checkup.service.ws.his.companyArchive.CompanyArchiveCreateReqBody;
import com.healt.cloud.checkup.service.ws.his.companyArchive.CompanyResult;
import com.healt.cloud.checkup.service.ws.his.companyCostBack.CompanyCostBackReqBody;
import com.healt.cloud.checkup.service.ws.his.costDetailBilling.CostDetailBillingChargeItem;
import com.healt.cloud.checkup.service.ws.his.costDetailBilling.CostDetailBillingChargeItemList;
import com.healt.cloud.checkup.service.ws.his.costDetailBilling.CostDetailBillingPatientInfo;
import com.healt.cloud.checkup.service.ws.his.costDetailBilling.CostDetailBillingReqBody;
import com.healt.cloud.checkup.service.ws.his.costDetailReturn.CostDetailReturnReqBody;
import com.healt.cloud.checkup.service.ws.his.costRefundApply.ChargeState;
import com.healt.cloud.checkup.service.ws.his.costRefundApply.CostRefundApplyReqBody;
import com.healt.cloud.checkup.service.ws.his.costRefundApply.Item;
import com.healt.cloud.checkup.service.ws.his.login.SSOLoginRequestBody;
import com.healt.cloud.checkup.service.ws.his.mdmClinicitemQuery.ClinicItemQueryReqBody;
import com.healt.cloud.checkup.service.ws.his.mdmClinicpriceQuery.ClinicpriceQueryReqBody;
import com.healt.cloud.checkup.service.ws.his.mdmCode.MdmCodeQueryReqBody;
import com.healt.cloud.checkup.service.ws.his.organization.OrganizationRequestBody;
import com.healt.cloud.checkup.service.ws.his.reportFile.*;
import com.healt.cloud.checkup.service.ws.his.userInfo.UserInfo;
import com.healt.cloud.checkup.service.ws.his.userInfo.UserInfoRequestBody;
import com.healt.cloud.checkup.service.ws.his.userInfo.UserListRequestBody;
import com.healt.cloud.checkup.vo.sys.depart.VHisDeptDictVo;
import com.healt.cloud.common.utils.CommonUtils;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.PropertiesUtils;
import com.healt.cloud.common.utils.SoapUtil;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-06-29 14:24
 * @description: TODO
 */
@Service
@Slf4j
public class WebServiceClient {

    @Autowired
    private WebserviceLogService webserviceLogService;

    @Autowired
    private HisSpecimanDictService hisSpecimanDictService;

    private String areaCode = PropertiesUtils.AREACODE;

    private String medInstCodeClient = PropertiesUtils.MEDINSTCODE;

    private String authCode = PropertiesUtils.AUTHCODE;

    /**
     * 查询是否建档
     * @param medInstCode
     * @param areaCode
     * @param idCard
     * @param patientName
     * @return
     */
    public String findPersonInfoWS(String medInstCode, String areaCode, String idCard, String patientName, String methodName) {

        MsgLog msgLog = new MsgLog();
        msgLog.setTerminalNo("1");
        msgLog.setUserId("1");
        msgLog.setRequestWay("1");
        msgLog.setPlatformCode("1");
        msgLog.setIpAddr("1");
        PatientInfo patientInfo = new PatientInfo();
        patientInfo.setIdCard(idCard);
        patientInfo.setPatientName(patientName);
        patientInfo.setAreaCode(areaCode);
        patientInfo.setMedInstCode(medInstCode);
        ApplyRequestBody body = new ApplyRequestBody();
        body.setMsgLog(msgLog);
        body.setPatientInfo(patientInfo);
        String resXml = this.sendMessage("ARCHIVE_QUERY", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            String standardListXml = SoapUtil.subXml(resXml, "<PatientInfo>", "</PatientInfo>");
            patientInfo  = SoapUtil.xml2Bean(standardListXml, PatientInfo.class);
            if("0".equals(patientInfo.getIsArchive())){
                return patientInfo.getIsArchive();
            }
            return patientInfo.getPatientId();
        }
        return "";
    }

    /**
     * 查询是否建档
     * @param medInstCode
     * @param areaCode
     * @param idCard
     * @param patientName
     * @return
     */
    public String archiveQuery(String medInstCode, String areaCode, String idCard, String patientName, String methodName) {
        MsgLog msgLog = new MsgLog();
        msgLog.setTerminalNo("1");
        msgLog.setUserId("1");
        msgLog.setRequestWay("3");
        msgLog.setPlatformCode("1");
        msgLog.setIpAddr("");
        PatientInfo patientInfo = new PatientInfo();
        patientInfo.setIdCard(idCard);
        patientInfo.setPatientName(patientName);
        patientInfo.setAreaCode(areaCode);
        patientInfo.setMedInstCode(medInstCode);
        ApplyRequestBody body = new ApplyRequestBody();
        body.setMsgLog(msgLog);
        body.setPatientInfo(patientInfo);
        String resXml = this.sendMessage("ARCHIVE_QUERY", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            String standardListXml = SoapUtil.subXml(resXml, "<PatientInfo>", "</PatientInfo>");
            patientInfo  = SoapUtil.xml2Bean(standardListXml, PatientInfo.class);
            if("0".equals(patientInfo.getIsArchive())){
                return patientInfo.getIsArchive();
            }
            return patientInfo.getPatientId();
        }
        return "";
    }

    /**
     * 建档
     * @param patientInfo
     * @param cardInfo
     * @param methodName
     */
    public CreateArchiveResponse archiveCreate(ArchiveCreatePatientInfo patientInfo, ArchiveCreateCardInfo cardInfo, String methodName){
        ArchiveCreateReqBody body = new ArchiveCreateReqBody();
        MsgLog msgLog = new MsgLog();
        msgLog.setTerminalNo("1");
        msgLog.setUserId("");
        msgLog.setRequestWay("3");
        msgLog.setIpAddr("");
        body.setMsgLog(msgLog);
        body.setCardInfo(cardInfo);
        body.setPatientInfo(patientInfo);
        String resXml = this.sendMessage("ARCHIVE_CREATE", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        //建档失败，已存在
        if(result == null){//<Code>CE</Code><Data xsi:type="xs:string" xmlns:xs="http://www.w3.org/2001/XMLSchema"/><Desc>BizException [message=建档失败：[患者身份证已存在], code=-604]</Desc>
            throw new CommonException(500, SoapUtil.subXml(resXml, "<Desc>", "</Desc>"));
        }
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            if(resXml.contains("<PatientInfo/>")){
                return null;
            }
            CreateArchiveResponse createArchiveResponse = new CreateArchiveResponse();
            String createArchivePatientInfoXml = SoapUtil.subXml(resXml, "<PatientInfo>", "</PatientInfo>");
            CreateArchivePatientInfoVO createArchivePatientInfoVO = SoapUtil.xml2Bean(createArchivePatientInfoXml, CreateArchivePatientInfoVO.class);
            createArchiveResponse.setPatientInfo(createArchivePatientInfoVO);
            String standardListXml = SoapUtil.subXml(resXml, "<AccountInfo>", "</AccountInfo>");
            CreateArchiveAccountInfoVO createArchiveAccountInfoVO = SoapUtil.xml2Bean(standardListXml, CreateArchiveAccountInfoVO.class);
            createArchiveResponse.setAccountInfo(createArchiveAccountInfoVO);
            return createArchiveResponse;
        }
        return null;
    }

    /**
     * 码表查询
     * @param standardCode 标准代码
     */
    public List<CodeTable> mdmCodeQuery(String standardCode, String methodName){
        MdmCodeQueryReqBody body = new MdmCodeQueryReqBody();
        body.setStandardCode(standardCode);
        String resXml = this.sendMessage("MDM_CODE_QUERY", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        if(result==null){//这样的xml解析会出错<Result><Code>CE</Code><Data xmlns:xs="http://www.w3.org/2001/XMLSchema" xsi:type="xs:string"></Data><Desc>BizException [message=记录未找到：【{}】, code=-10]</Desc></Result>
            return null;
        }
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            String standardListXml = SoapUtil.subXml(resXml, "<StandardList>", "</StandardList>");
            CodeTableResponse.StandardList standardList = SoapUtil.xml2Bean(standardListXml, CodeTableResponse.StandardList.class);;
            List<CodeTable> list = standardList.getStandard();
            return list;
        }
        return null;
    }

    public String updateHisSpecimanDict(){
        List<CodeTable> codeTableList = this.mdmCodeQuery("YB0006" , "updateHisSpecimanDict");
        List<HisSpecimanDict> hisSpecimanDicts = new ArrayList<>();
        for (CodeTable codeTable:codeTableList) {
            List<CodeTableItem> codeTableItems = codeTable.getItemList().getItem();
            for(CodeTableItem codeTableItem:codeTableItems){
                HisSpecimanDict hisSpecimanDict = new HisSpecimanDict();
                hisSpecimanDict.setItemId(new BigDecimal(codeTableItem.getItemId()));
                hisSpecimanDict.setItemName(codeTableItem.getItemName());
                hisSpecimanDict.setItemValue(codeTableItem.getItemValue());
                hisSpecimanDict.setPyCode(codeTableItem.getPyCode());
                hisSpecimanDict.setWbCode(codeTableItem.getWbCode());
                hisSpecimanDicts.add(hisSpecimanDict);
            }
        }
        if(hisSpecimanDictService.saveOrUpdateBatch(hisSpecimanDicts)){
            return "success";
        }
        return "failed";
    }

    /**
     *  HIS组织机构查询
     * @param areaCode 院区编码
     * @param medInstCode 医疗机构编码
     */
    public List<VHisDeptDictVo> mdmOrganizationQuery(String areaCode, String medInstCode, String methodName){
        List<VHisDeptDictVo> vHisDeptDictVos = new ArrayList<>();
        OrganizationRequestBody body = new OrganizationRequestBody();
        body.setAreaCode(areaCode);
        body.setMedInstCode(medInstCode);
        String resXml = this.sendMessage("MDM_ORGANIZATION_QUERY", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        if(result==null){//这样的xml解析会出错<Result><Code>CE</Code><Data xmlns:xs="http://www.w3.org/2001/XMLSchema" xsi:type="xs:string"></Data><Desc>BizException [message=记录未找到：【{}】, code=-10]</Desc></Result>
            return null;
        }
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            String userInfoListXml = SoapUtil.subXml(resXml, "<OrganizationList>", "</OrganizationList>");
            OrganizationResponse.OrganizationList organizationList = SoapUtil.xml2Bean(userInfoListXml, OrganizationResponse.OrganizationList.class);
            List<Org> list = organizationList.getOrganization();
            for(Org org : list){
                VHisDeptDictVo vHisDeptDictVo = new VHisDeptDictVo();
                vHisDeptDictVo.setDeptCode(org.getOrgCode());
                vHisDeptDictVo.setCode(org.getOrgCode());
                vHisDeptDictVo.setDeptName(org.getOrgName());
                vHisDeptDictVo.setName(org.getOrgName());
                vHisDeptDictVo.setInputCode(org.getPyCode());
                vHisDeptDictVo.setHospitalId(org.getAreaCode());
                //vHisDeptDictVo.setSerialNo(org.getSortNo().intValue());
                vHisDeptDictVos.add(vHisDeptDictVo);
            }
        }
        return vHisDeptDictVos;
    }

    /**
     * 诊疗项目查询 一般在初期同步基础数据的时候使用，建议传诊疗项目分类，查询指定类型的诊疗项目
     * @param itemClass 为空时，查询所有类别
     * @param methodName
     */
    public List<ClinicItemEntity> mdmClinicitemQuery(String itemClass, String methodName){
        ClinicItemQueryReqBody body = new ClinicItemQueryReqBody();
        body.setItemClass(itemClass);
        body.setAreaCode(areaCode);
        body.setMedInstCode(medInstCodeClient);
        String resXml = this.sendMessage("MDM_CLINICITEM_QUERY", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        if(result==null){//这样的xml解析会出错<Result><Code>CE</Code><Data xmlns:xs="http://www.w3.org/2001/XMLSchema" xsi:type="xs:string"></Data><Desc>BizException [message=记录未找到：【{}】, code=-10]</Desc></Result>
            return null;
        }
        if ("CE".equals(result.getCode())){
            //return "error:"+result.getDesc();
            if(result.getDesc().contains("记录未找到")){
                return null;
            }else{
                throw new CommonException(500, result.getDesc());
            }
        }else if("CA".equals(result.getCode())){
            String clinicItemDictListXml = SoapUtil.subXml(resXml, "<ClinicItemDictList>", "</ClinicItemDictList>");
            ClinicItemResponse.ClinicItemDictList clinicItemDictList = SoapUtil.xml2Bean(clinicItemDictListXml, ClinicItemResponse.ClinicItemDictList.class);;
            return clinicItemDictList.getClinicItemDict();
        }
        return null;
    }


    /**
     * 价表项目查询itemClass、itemCode为*时不进行过滤
     * @param itemClass
     * @param itemCode
     * @param methodName
     */
    public List<BdClinicpriceQueryVO> mdmClinicpriceQuery(String itemClass, String itemCode, String methodName) {
        ClinicpriceQueryReqBody body = new ClinicpriceQueryReqBody();
        body.setMedInstCode(medInstCodeClient);
        body.setAreaCode(areaCode);
        if(!"*".equals(itemClass)){
            body.setItemClass(itemClass);
        }
        if(!"*".equals(itemCode)){
            body.setItemCode(itemCode);
        }
        String resXml = this.sendMessage("MDM_CLINICPRICE_QUERY", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        if(result==null){//这样的xml解析会出错<Result><Code>CE</Code><Data xmlns:xs="http://www.w3.org/2001/XMLSchema" xsi:type="xs:string"></Data><Desc>BizException [message=记录未找到：【{}】, code=-10]</Desc></Result>
            return null;
        }
        if ("CE".equals(result.getCode())){
            //return "error:"+result.getDesc();
            if(result.getDesc().contains("记录未找到")){
                return null;
            }else{
                throw new CommonException(500, result.getDesc());
            }
        }else if("CA".equals(result.getCode())){
            String clinicPriceListXml = SoapUtil.subXml(resXml, "<ClinicPriceList>", "</ClinicPriceList>");
            QueryBdClinicpriceListRrsponse.ClinicPriceList clinicPriceList = SoapUtil.xml2Bean(clinicPriceListXml, QueryBdClinicpriceListRrsponse.ClinicPriceList.class);;
            return clinicPriceList.getClinicPrice();
        }
        return null;
    }

    /**
     * 明细计费
     * @param detailBillingPatientInfo
     * @param chargeItemList
     * @param methodName
     * @return
     */
    public String costDetailBilling(CostDetailBillingPatientInfo detailBillingPatientInfo, List<CostDetailBillingChargeItem> chargeItemList, String methodName){
        CostDetailBillingReqBody body = new CostDetailBillingReqBody();
        body.setPatientInfo(detailBillingPatientInfo);
        CostDetailBillingChargeItemList costDetailBillingChargeItemList = new CostDetailBillingChargeItemList();
        costDetailBillingChargeItemList.setChargeItem(chargeItemList);
        body.setChargeItemList(costDetailBillingChargeItemList);

        String resXml = this.sendMessage("COST_DETAIL_BILLING", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        if(result == null){//<Code>CE</Code><Data xsi:type="xs:string" xmlns:xs="http://www.w3.org/2001/XMLSchema"/><Desc>BizException [message=建档失败：[患者身份证已存在], code=-604]</Desc>
            throw new CommonException(500, SoapUtil.subXml(resXml, "<Desc>", "</Desc>"));
        }
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            return "CA";
        }
        return null;
    }

    /**
     * 明细作废
     */
    public String costDetailReturn(CostDetailReturnReqBody body, String methodName) {

        String resXml = this.sendMessage("COST_DETAIL_RETURN", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        if(result == null){
            throw new CommonException(500, SoapUtil.subXml(resXml, "<Desc>", "</Desc>"));
        }
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            return "CA";
        }
        return null;

    }

    /**
     * 明细退费
     */
    public String costRefundApply(CostRefundApplyReqBody body, String methodName){

        String resXml = this.sendMessage("COST_REFUND_APPLY", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        if(result == null){
            throw new CommonException(500, SoapUtil.subXml(resXml, "<Desc>", "</Desc>"));
        }
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            return "CA";
        }
        return null;
    }

    /**
     * 团检费用申请/撤销
     * @return
     */
    public String companyCostBack(CompanyCostBackReqBody body, String methodName){

        String resXml = this.sendMessage("COMPANY_COST_BACK", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        if(result == null){
            throw new CommonException(500, SoapUtil.subXml(resXml, "<Desc>", "</Desc>"));
        }
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            return "CA";
        }
        return null;
    }

    /**
     *  HIS用户账号信息查询
     * @param userName 用户工号
     */
    public List<BcsUumUser> userQueryInfo(String userName, String methodName){
        List<BcsUumUser> list = new ArrayList<>();
        UserInfoRequestBody body = new UserInfoRequestBody();
        body.setUserName(userName);

        String resXml = this.sendMessage("USER_QUERY_INFO", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);

        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            String userInfoXml = SoapUtil.subXml(resXml, "<UserInfo>", "</UserInfo>");
            BcsUumUser userInfo = SoapUtil.xml2Bean(userInfoXml, BcsUumUser.class);;
            list.add(userInfo);
        }
        return list;
    }

    /**
     *  HIS用户账号列表及账号信息查询
     */
    public List<BcsUumUser> userQueryList(String workDept,String methodName){
        UserInfo userInfo = new UserInfo();
        if(!"*".equals(workDept)){
            userInfo.setWorkDept(workDept);
        }
        UserListRequestBody body = new UserListRequestBody();
        body.setUserInfo(userInfo);
        String resXml = this.sendMessage("USER_QUERY_LIST", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            if(resXml.contains("<UserInfoList/>")){
                return null;
            }
            String userInfoListXml = SoapUtil.subXml(resXml, "<UserInfoList>", "</UserInfoList>");
            BcsUumUserResponse.UserInfoList userInfoList = SoapUtil.xml2Bean(userInfoListXml, BcsUumUserResponse.UserInfoList.class);;
            return userInfoList.getUserInfo();
        }
        return null;
    }

    /**
     * 发布报告文件
     * @param fileReqBody
     * @param methodName
     */
    public String publishReportFile(PublishReportFileReportInfo fileReqBody, String methodName){
        PublishReportFileReqBody body = new PublishReportFileReqBody();
        body.setReportInfo(fileReqBody);
        String resXml = this.sendMessage("PDV_PUBLISH_REPORT_FILE", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        //发布报告文件失败
        if(result == null){
            throw new CommonException(500, SoapUtil.subXml(resXml, "<Desc>", "</Desc>"));
        }
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            return "CA";
        }
        return null;
    }

    /**
     * 作废报告文件
     * @param fileReqBody
     * @param methodName
     */
    public String cancelReportFile(CancelReportFileReportInfo fileReqBody, String methodName){
        CancelReportFileReqBody body = new CancelReportFileReqBody();
        body.setReportInfo(fileReqBody);
        String resXml = this.sendMessage("PDV_CANCEL_REPORT_FILE", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        //作废报告文件失败
        if(result == null){
            throw new CommonException(500, SoapUtil.subXml(resXml, "<Desc>", "</Desc>"));
        }
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            return "CA";
        }
        return null;
    }

    /**
     * 单点登录
     * @param sysUri
     * @param ticket
     * @return
     */
    public String ssoLogin(String sysUri, String ticket) {
        SSOLoginRequestBody body = new SSOLoginRequestBody();
        body.setST(ticket);
        body.setSysUri(sysUri);
        String resXml = this.sendMessage("USER_LOGIN_VERIFICATION", body, "ssoLogin");
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        if(result == null){
            throw new CommonException(500, SoapUtil.subXml(resXml, "<Desc>", "</Desc>"));
        }
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            if(resXml.contains("<UserInfo/>")){
                return null;
            }
            String userInfoListXml = SoapUtil.subXml(resXml, "<UserInfo>", "</UserInfo>");
            BcsUumUser userInfo = SoapUtil.xml2Bean(userInfoListXml, BcsUumUser.class);;
            return userInfo.getUserName();
        }
        return "";
    }

    /**
     * pdf报告url查询
     * @param patientId
     * @param applyNo 报告申请号
     * @return
     */
    public String pdfReporQuery(String patientId, String applyNo) {
        PdfReporQueryReqBody body = new PdfReporQueryReqBody();
        PdfReporQueryReportInfo reportInfo = new PdfReporQueryReportInfo();
        reportInfo.setPatientId(patientId);
        reportInfo.setPatientType("3");
        reportInfo.setApplyNo(applyNo);
        body.setReportInfo(reportInfo);
        String resXml = this.sendMessage("PDV_REPOR_QUERY", body, "pdfReporQuery");
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        Result result = SoapUtil.xml2Bean(resultXml, Result.class);
        if(result == null){
            throw new CommonException(500, SoapUtil.subXml(resXml, "<Desc>", "</Desc>"));
        }
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            if(resXml.contains("<ReportList/>")){
                return null;
            }
            String userInfoListXml = SoapUtil.subXml(resXml, "<ReportList>", "</ReportList>");
            PdfReportResponse.ReportList reportList = SoapUtil.xml2Bean(userInfoListXml, PdfReportResponse.ReportList.class);
            List<PdfReport> pdfReportList = reportList.getReportInfo();
            return pdfReportList.get(0).getReportUrl();
        }
        return null;
    }

    /**
     * 单位建档
     * @return
     */
    public String companyArchiveCreate(CompanyArchiveCreateReqBody body, String methodName){
        String resXml = this.sendMessage("COMPANY_ARCHIVE_CREATE", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        CompanyResult result = SoapUtil.xml2Bean(resultXml, CompanyResult.class);
        //建档失败，已存在
        if(result == null){//<Code>CE</Code><Data xsi:type="xs:string" xmlns:xs="http://www.w3.org/2001/XMLSchema"/><Desc>BizException [message=建档失败：[患者身份证已存在], code=-604]</Desc>
            throw new CommonException(500, SoapUtil.subXml(resXml, "<Desc>", "</Desc>"));
        }
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            if(resXml.contains("</ExamCompanyID>")){
                throw new CommonException(500, "生成平台ID出错，请重试！");
            }
            String examCompanyID = SoapUtil.getValue(resXml, "<examCompanyID>", "</examCompanyID>");
            if(StringUtils.isEmpty(examCompanyID)){
                throw new CommonException(500, "生成平台ID出错，请重试！");
            }else{
                return examCompanyID;
            }
        }
        return "";
    }


    /**
     * 单位档案修改
     * @return
     */
    public String companyArchiveModify(CompanyArchiveCreateReqBody body, String methodName){
        String resXml = this.sendMessage("COMPANY_ARCHIVE_MODIFY", body, methodName);
        String resultXml = SoapUtil.subXml(resXml, "<Result>", "</Result>");
        CompanyResult result = SoapUtil.xml2Bean(resultXml, CompanyResult.class);
        //建档失败，已存在
        if(result == null){//<Code>CE</Code><Data xsi:type="xs:string" xmlns:xs="http://www.w3.org/2001/XMLSchema"/><Desc>BizException [message=建档失败：[患者身份证已存在], code=-604]</Desc>
            throw new CommonException(500, SoapUtil.subXml(resXml, "<Desc>", "</Desc>"));
        }
        if ("CE".equals(result.getCode())){
            throw new CommonException(500, result.getDesc());
        }else if("CA".equals(result.getCode())){
            String examCompanyID = result.getExamCompanyID();
            if(StringUtils.isEmpty(examCompanyID)){
                return "";
            }else{
                return examCompanyID;
            }
        }
        return "";
    }

    public String sendMessage(String servieCode, Object obj, String methodName){
        String uuid = CommonUtils.getUUID();
        String soapXml = "";
        String prefix = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<soap:Envelope\n" +
                "    xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "    xmlns:weg=\"http://wegohis.com\">\n" +
                "    <soap:Header/>\n" +
                "    <soap:Body>\n" +
                "        <weg:message>\n" +
                "            <Request>\n";
        String suffix = "\n" +
                "            </Request>\n" +
                "        </weg:message>\n" +
                "    </soap:Body>\n" +
                "</soap:Envelope>";
        String headerXml = "     <Header>\n" +
                "                    <Sender>"+PropertiesUtils.SENDER+"</Sender>\n" +
                "                    <Receiver>"+PropertiesUtils.RECEIVER+"</Receiver>\n" +
                "                    <SendDate>"+DateUtils.praseDate(new Date(), "yyyyMMddHHmmss")+"</SendDate>\n" +
                "                    <ServiceCode>"+servieCode+"</ServiceCode>\n" +
                "                    <MsgId>"+uuid+"</MsgId>\n" +
                "                    <AuthCode>"+authCode+"</AuthCode>\n" +
                "                    <Version>1.0</Version>\n" +
                "                </Header>";
        String bodyXml = SoapUtil.bean2Xml(obj);
        //request.setBody(body);
        //TODO 将请求request存入日志
        soapXml = prefix+headerXml+"\n"+bodyXml+suffix;
        //System.out.println(soapXml);
//        log.info("webservice请求：");
//        log.info(soapXml);
        WebserviceLog webserviceLog = new WebserviceLog();
        webserviceLog.setUuid(uuid);
        webserviceLog.setInsertDate(new Date());
        webserviceLog.setDataStr(soapXml);
        webserviceLog.setDataType("请求");
        webserviceLog.setMethod(methodName);
        webserviceLogService.save(webserviceLog);

        String resXml = SoapUtil.doPostSoap1_1(soapXml);
//        log.info("webservice响应：");
//        log.info(soapXml);

        //TODO 将响应结果转为字符串存入日志
        WebserviceLog logOut = new WebserviceLog();
        logOut.setUuid(uuid);
        logOut.setInsertDate(new Date());
        logOut.setDataStr(resXml);
        logOut.setDataType("响应");
        logOut.setMethod(methodName);
        webserviceLogService.save(logOut);
        return resXml;
    }

}
