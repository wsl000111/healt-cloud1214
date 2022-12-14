package com.healt.cloud.checkup.controller.webSerivce;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.healt.cloud.checkup.appointmentReg.mapper.PersonAppointRegMapper;
import com.healt.cloud.checkup.entity.HcExamMaster;
import com.healt.cloud.checkup.entity.Hl7ReceiveLog;
import com.healt.cloud.checkup.service.HcExamMasterService;
import com.healt.cloud.checkup.service.Hl7ReceiveLogService;
import com.healt.cloud.checkup.service.ws.his.*;
import com.healt.cloud.checkup.service.ws.his.archive.ArchiveCreateCardInfo;
import com.healt.cloud.checkup.service.ws.his.archive.ArchiveCreatePatientInfo;
import com.healt.cloud.checkup.service.ws.his.costDetailBilling.CostDetailBillingChargeItem;
import com.healt.cloud.checkup.service.ws.his.costDetailBilling.CostDetailBillingPatientInfo;
import com.healt.cloud.checkup.vo.sys.depart.VHisDeptDictVo;
import com.healt.cloud.checkup.service.ws.WebServiceClient;
import com.healt.cloud.common.utils.PropertiesUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-07-01 11:12
 * @description: TODO
 */
@RestController
@RequestMapping("/ws")
@Api(tags = "webService接口API")
public class WebServiceController {

    private String isHis = PropertiesUtils.ISHIS;

    private String areaCode = PropertiesUtils.AREACODE;

    private String medInstCode = PropertiesUtils.MEDINSTCODE;

    @Autowired
    private WebServiceClient client;

    @Autowired
    private PersonAppointRegMapper personAppointRegMapper;

    @ApiOperation("/查询是否建档")
    @GetMapping("/archiveQuery")
    public String archiveQuery(String medInstCode, String areaCode, String idCard, String patientName) {
        return client.archiveQuery(medInstCode, areaCode, idCard, patientName, "findPersonInfoWS");
    }

    public String archivePatient(String personListStr){
        if(StringUtils.isEmpty(personListStr)){
            return "";
        }
        personListStr.split(",");
        return "";
    }

    @ApiOperation("/建档")
    @GetMapping("/archiveCreate")
    public CreateArchiveResponse archiveCreate(){
        ArchiveCreatePatientInfo patientInfo = new ArchiveCreatePatientInfo();
        patientInfo.setAreaCode(areaCode);
        patientInfo.setPatientSex("1");
        patientInfo.setPatientName("杨过");
        patientInfo.setBirthDate("19900307000000");
        patientInfo.setChildrenName("");
        patientInfo.setIdCard("110101199003073634");
        patientInfo.setInsuranceType("1");
        patientInfo.setRelation("");
        patientInfo.setPyCode("YG");
        patientInfo.setPhoneNo("13888888888");
        patientInfo.setOccupationCode("99");
        patientInfo.setMedInstCode(medInstCode);
        ArchiveCreateCardInfo cardInfo = new ArchiveCreateCardInfo();
        cardInfo.setExpireTime("");
        cardInfo.setIdentityNum("110101199003073634");
        cardInfo.setIdentityType("4");
        String trackDate = "110101199003073634|19900307";
        cardInfo.setTrackData(trackDate);
        cardInfo.setValidTime("");
        return client.archiveCreate(patientInfo, cardInfo, "archiveCreate");
    }

    @ApiOperation("码表查询, " +
            "性别 参见 GB2261-80, " +
            "医嘱类型 参见 YB0056, " +
            "检查部位代码&检查部位名称 参见 YB0083, " +
            "诊疗项目分类 YB0003" +
            "项目类型 YB0004, " +
            "终端类型 PIX0003, " +
            "性别 GB2261-80, " +
            "费别类型 YB0005, " +
            "传染病患者职业编码 CV02.01.202, " +
            "卡类型 PIX0001, " +
            "用户类别编码 BCS0011, " +
            "导引介质类型 PIX0001, " +
            "样本代码&样本名称 YB0006")
    @GetMapping("/mdmCodeQuery")
    public List<CodeTable> mdmCodeQuery(String standardCode){
        List<CodeTable> list = client.mdmCodeQuery(standardCode, "mdmCodeQuery");
        if(list == null){
            list = new ArrayList<>();
        }
        return list;
    }

    @ApiOperation("/更新his标本字典")
    @GetMapping("/updateHisSpecimanDict")
    public String updateHisSpecimanDict(){
        return client.updateHisSpecimanDict();
    }

    @ApiOperation("/诊疗项目查询")
    @GetMapping("/mdmClinicitemQuery/{itemClass}")
    public List<ClinicItemEntity> mdmClinicitemQuery(@PathVariable String itemClass){
        return client.mdmClinicitemQuery(itemClass, "mdmClinicitemQuery");
    }

    @ApiOperation("/价表项目查询, ItemClass项目类型为*时查询所有价表项目，ItemCode为*时不进行过滤")
    @GetMapping("/mdmClinicpriceQuery/{itemClass}/{itemCode}")
    public List<BdClinicpriceQueryVO> mdmClinicpriceQuery(@PathVariable String itemClass,
                                                          @PathVariable String itemCode){
        return client.mdmClinicpriceQuery(itemClass, itemCode, "mdmClinicpriceQuery");
    }

    @ApiOperation("/根据用户工号查询唯一对应用户的数据")
    @GetMapping("/userQueryInfo/{userName}")
    public List<BcsUumUser> userQueryInfo(@PathVariable String userName){
        return client.userQueryInfo(userName, "userQueryInfo");
    }

    @ApiOperation("/用户账号列表及账号信息查询")
    @GetMapping("/userQueryList/{deptName}")
    public List<BcsUumUser> userQueryList(@PathVariable String deptName){
        List<BcsUumUser> bcsUumUserList = client.userQueryList(deptName, "userQueryList");
        if(bcsUumUserList==null){
            return new ArrayList<>();
        }
        return bcsUumUserList;
    }

    @ApiOperation("/组织机构查询")
    @GetMapping("/mdmOrganizationQuery/{areaCode}/{medInstCode}")
    public List<VHisDeptDictVo> mdmOrganizationQuery(@PathVariable String areaCode, @PathVariable String medInstCode){
        List<VHisDeptDictVo> list = client.mdmOrganizationQuery(areaCode, medInstCode, "mdmOrganizationQuery");
        if(list == null){
            return new ArrayList<>();
        }
        return list;
    }

    @ApiOperation("/接收soap协议请求")
    @PostMapping("/message")
    public String message(@RequestBody String soapRequestStr){
        System.out.println(soapRequestStr);
        return soapRequestStr;
    }

    @ApiOperation("/测试序列生成")
    @PostMapping("/testOrderId")
    public String testOrderId(){
        String orderId = "";
        for(int i=0;i<2;i++){
            String orderIdNew = personAppointRegMapper.selectOrderId().toString();
            orderId = orderId+","+orderIdNew;
        }
        return orderId;
    }

    @ApiOperation("/退费申请")
    @GetMapping("/costRefundApply")
    public String costRefundApply(){
        return client.costRefundApply(null, "costDetailReturn");
    }

    @ApiOperation("/单点登录")
    @GetMapping("/ssoLogin/{sysUri}/{ticket}")
    public String ssoLogin(String sysUri, String ticket){
        return client.ssoLogin(sysUri, ticket);
    }

    @ApiOperation("/查询pdf报告地址")
    @GetMapping("/reportPdfUrl/{patientId}/{applyNo}")
    public String reportPdfUrl(String patientId, String applyNo){
        return client.pdfReporQuery(patientId, applyNo);
    }

    @Autowired
    public Hl7ReceiveLogService hl7ReceiveLogService;

    @Autowired
    public HcExamMasterService hcExamMasterService;

    @GetMapping("/refreshFromHl7Log")
    public String refreshFromHl7Log(){
        LambdaQueryWrapper<Hl7ReceiveLog> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.isNotNull(Hl7ReceiveLog::getApplyNo);
        queryWrapper.orderByDesc(Hl7ReceiveLog::getInsertDate);
        List<Hl7ReceiveLog> list = hl7ReceiveLogService.list(queryWrapper);
        for(int i = 0; i<list.size(); i++){
            Hl7ReceiveLog log = list.get(i);
            String applyNo = log.getApplyNo();
            String hl7Data = log.getHl7Data();

            LambdaQueryWrapper<HcExamMaster> hcExamMasterLambdaQueryWrapper = new LambdaQueryWrapper<>();
            hcExamMasterLambdaQueryWrapper.eq(HcExamMaster::getExamNo, applyNo);
            HcExamMaster hcExamMaster = hcExamMasterService.getOne(hcExamMasterLambdaQueryWrapper);
            if(hcExamMaster!=null){
                //hcExamMaster =
            }
            String exam = "";
            String lab = "";

        }
        return "";
    }

    public static String clob2str(){
        return "";
    }

}
