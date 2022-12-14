package com.healt.cloud.checkup.service.pubComm.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.service.tcp.client.LabApplyMLLPTCPClient;
import com.healt.cloud.checkup.mapper.pubComm.PubCommMapper;
import com.healt.cloud.checkup.service.pubComm.PubCommService;
import com.healt.cloud.checkup.service.tcp.client.ExamApplyMLLPTCPClient;
import com.healt.cloud.checkup.service.tcp.vo.exam.ExamApplyVo;
import com.healt.cloud.checkup.service.tcp.vo.lab.LabApplyVo;
import com.healt.cloud.checkup.service.ws.WebServiceClient;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.PersonItemsVo;
import com.healt.cloud.checkup.vo.pubComm.PersonVisitAndInfoVo;
import com.healt.cloud.checkup.vo.pubComm.InterfaceSourceVo;
import com.healt.cloud.checkup.vo.pubComm.PublicDictVo;
import com.healt.cloud.common.utils.CommonUtils;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.DruidUtils;
import com.healt.cloud.common.utils.PropertiesUtils;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.Data;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author linklee
 * @create 2022-05-03 9:31
 */
@Service
public class PubCommServiceImpl implements PubCommService {

    private static boolean crossDB = false;

    private static boolean outterInterface = false;

    @Autowired
    private PubCommMapper pubCommMapper;
    @Autowired
    private HcPersonVisitInfoService hcPersonVisitInfoService;
    @Autowired
    private HcUnitVisitInfoService hcUnitVisitInfoService;
    @Autowired
    private VHcItemPackDictService vHcItemPackDictService;
    @Autowired
    private PackTestTubeDictService packTestTubeDictService;
    @Autowired
    private HcItemReportWriteDictService hcItemReportWriteDictService;
    @Autowired
    private InterfaceSourceService interfaceSourceService;
    @Autowired
    private HcPackVsClinicService hcPackVsClinicService;
    @Autowired
    private HcExamMasterService hcExamMasterService;
    @Autowired
    private HcExamItemsService hcExamItemsService;
    @Autowired
    private HclabTestMasterService hclabTestMasterService;
    @Autowired
    private HclabTestItemsService hclabTestItemsService;
    @Autowired
    private WebServiceClient client;
    @Autowired
    HcPersonAppregItemsService hcPersonAppregItemsService;
    @Autowired
    private Hl7LogService hl7LogService;
    @Autowired
    private HisSpecimanDictService hisSpecimanDictService;
    @Autowired
    private HcItemPackDictService hcItemPackDictService;
    @Autowired
    private VClinicPartsService vClinicPartsService;

    @Override
    public List<InterfaceSourceVo> findItemExternalInterface(String hospitalId, String itemPackCode) {
        List<InterfaceSourceVo> list = pubCommMapper.findItemExternalInterface(hospitalId,itemPackCode);
        return list;
    }

    @Override
    public List<PublicDictVo> findPublicDict(String dictType) {
        List<PublicDictVo> list = pubCommMapper.findPublicDict(dictType);
        if (list.size() == 0) {
            list.add(new PublicDictVo());
        }
        return list;
    }

    @Override
    public String findPersonMaxVisit(String hospitalId, String personId) {
        QueryWrapper<HcPersonVisitInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("PERSON_ID", personId);
        queryWrapper.select("nvl(max(person_visit_id),0) maxPersonVisitId");
        Map<String, Object> result = hcPersonVisitInfoService.getMap(queryWrapper);
        if(result != null){
           return ((BigDecimal)result.get("MAXPERSONVISITID")).toString();
        }
        return "0";
    }

    @Override
    public String findUnitMaxVisit(String hospitalId, String unitId) {
        QueryWrapper<HcUnitVisitInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("unit_id", unitId);
        queryWrapper.select("nvl(max(unit_visit_id),0) maxUnitVisitId");
        Map<String, Object> result = hcUnitVisitInfoService.getMap(queryWrapper);
        if(result != null){
            return ((BigDecimal)result.get("MAXUNITVISITID")).toString();
        }
        return "0";
    }

    @Override
    public String findExamNoForItem(String hospitalId, String itemPackCode) {
        String applyNo = null;
        //判断组合项目与诊疗项目对照是否是检查项目
        QueryWrapper<HcPackVsClinic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId)
                .eq("ITEM_PACK_CODE", itemPackCode)
                .eq("ITEM_CLASS", "D");
        HcPackVsClinic hcPackVsClinic = hcPackVsClinicService.getOne(queryWrapper);
        if(hcPackVsClinic == null){
            return  "非诊疗项目";
        }
        if (crossDB) {//是否跨库
            List<InterfaceSourceVo> interfaceSourceVos = this.findItemExternalInterface(hospitalId, itemPackCode);
            if(interfaceSourceVos == null || interfaceSourceVos.size() == 0){
                return "msg:取项目接口数据源失败！";
            }
            String serviceName = interfaceSourceVos.get(0).getServiceName();
            String userName = interfaceSourceVos.get(0).getUserName();
            String password = interfaceSourceVos.get(0).getPassword();
            Connection conn = DruidUtils.getConnection(serviceName,userName,password);
            if(conn == null){
                return "msg:获取连接失败！";
            }
            try{
                QueryRunner queryRunner = new QueryRunner();
                String sql = "select hcexam.exam_no.nextval from dual";
                String examNo = queryRunner.query(conn, sql, new ScalarHandler<BigDecimal>()).toString();
                applyNo = examNo;
                if(examNo != null){
                    for(int i=examNo.length(); i<"0000000000".length(); i++){
                        applyNo = "0"+applyNo;
                    }
                }
            } catch (Exception e){
                throw new CommonException(500, "跨库操作异常！"+e.getMessage());
            } finally {
                try{
                    DbUtils.close(conn);
                }catch (SQLException sqlException) {
                    throw new CommonException(500, "connectioin关闭异常！"+sqlException.getMessage());
                }
            }
        } else if (outterInterface){ //是否调用外部接口

        } else { //同一数据源
            String examNo = pubCommMapper.selectExamNo();
            applyNo = examNo;
            if(examNo != null){
                for(int i=examNo.length(); i<"0000000000".length(); i++){
                    applyNo = "0"+applyNo;
                }
            }
        }
        return applyNo;
    }

    @Override
    public String findTestNoForItem(List<PersonItemsVo> personItemsVos, String hospitalId, String itemPackCode) {
        QueryWrapper<VHcItemPackDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalId);
        queryWrapper.eq("item_pack_code", itemPackCode);
        VHcItemPackDict vHcItemPackDict = vHcItemPackDictService.getOne(queryWrapper);
        if (vHcItemPackDict == null){
            return "";
        }
        //判断组合项目与诊疗项目对照是否是检验项目
        QueryWrapper<HcPackVsClinic> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("HOSPITAL_ID", hospitalId)
                .eq("ITEM_PACK_CODE", itemPackCode)
                .eq("ITEM_CLASS", "C");
        HcPackVsClinic hcPackVsClinic = hcPackVsClinicService.getOne(queryWrapper1);
        if(hcPackVsClinic == null){
            return  "非诊疗项目";
        }
        //判断组合项目
        String blood  = vHcItemPackDict.getDrawBlood();
        String tubeCode = vHcItemPackDict.getTestTubeCode();
        String itemPackName = vHcItemPackDict.getItemPackName();
        String specimanName = vHcItemPackDict.getSpecimanName();
        // 如果抽血项目没有指定试管，则返回
        if ("1".equals(blood)&&StringUtils.isEmpty(tubeCode)){
            throw  new CommonException(500, "检验申请出错" + itemPackName + "为抽血项目但没有指定试管。");
        }
        String applyNo = "";
        // 如果已经存在对应的申请号，则直接采用
        if(personItemsVos!=null){
            List<PersonItemsVo> list = personItemsVos.stream()
                    .filter(personItemsVo -> specimanName==null ? null ==personItemsVo.getSpecimanName() : specimanName.equals(personItemsVo.getSpecimanName()))
                    .filter(personItemsVo -> blood==null ? null==personItemsVo.getDrawBlood() : blood.equals(personItemsVo.getDrawBlood()))
                    .filter(personItemsVo -> tubeCode==null ? null==personItemsVo.getTestTubeCode() : tubeCode.equals(personItemsVo.getTestTubeCode()))
                    .filter(personItemsVo -> "0".equals(personItemsVo.getSubmitApply()))
                    .filter(personItemsVo -> StringUtils.isNotEmpty(personItemsVo.getApplyNo()))
                    .collect(Collectors.toList());
            if(list.size() > 0){
                applyNo = list.get(0).getApplyNo();
            }
        }
        if(StringUtils.isEmpty(applyNo)){
            if (crossDB) {//跨库处理
                List<InterfaceSourceVo> interfaceSourceVos = this.findItemExternalInterface(hospitalId, itemPackCode);
                if(interfaceSourceVos == null || interfaceSourceVos.size() == 0){
                    return "msg:取项目接口数据源失败！";
                }
                String serviceName = interfaceSourceVos.get(0).getServiceName();
                String userName = interfaceSourceVos.get(0).getUserName();
                String password = interfaceSourceVos.get(0).getPassword();
                Connection conn = DruidUtils.getConnection(serviceName,userName,password);
                if(conn == null){
                    return "msg:获取连接失败！";
                }
                try{
                    QueryRunner queryRunner = new QueryRunner();
                    String sqlTestNo = "Select to_char(HCLAB.lab_no.nextval) From dual";
                    String testNo = queryRunner.query(conn, sqlTestNo, new ScalarHandler<String>());
                    String sqlSysDate = "Select to_char(sysdate,'yymmdd') From dual";
                    String sysDate = queryRunner.query(conn, sqlSysDate, new ScalarHandler<String>());
                    applyNo = testNo;
                    if(testNo != null){
                        for(int i=testNo.length(); i<"000000".length(); i++){
                            applyNo = "0"+applyNo;
                        }
                        applyNo = sysDate+applyNo;
                    }
                } catch (Exception e){
                    throw new CommonException(500, "跨库操作异常！"+e.getMessage());
                } finally {
                    try{
                        DbUtils.close(conn);
                    }catch (SQLException sqlException) {
                        throw new CommonException(500, "connectioin关闭异常！"+sqlException.getMessage());
                    }
                }
            } else if (outterInterface){ //是否调用外部接口

            } else { //同一数据源
                String testNo = pubCommMapper.selectTestNo();
                String sysDate = pubCommMapper.selectSysdate();
                applyNo = testNo;
                if(testNo != null){
                    for(int i=testNo.length(); i<"000000".length(); i++){
                        applyNo = "0"+applyNo;
                    }
                    applyNo = sysDate+applyNo;
                }
            }
        }
        return applyNo;
    }

    @Override
    public String sendExamApply(List<Connection> connList, List<PersonItemsVo> personItemsVos, String userCode) {
        Map<String, Connection> connectionMap = new HashMap<>();
        //过滤没发送的项目
        List<PersonItemsVo> list = personItemsVos.stream()
                //.filter(personItemsVo -> StringUtils.isNotEmpty(personItemsVo.getApplyNo()))
                .filter(personItemsVo -> "0".equals(personItemsVo.getSubmitApply()))
                .filter(personItemsVo -> "检查".equals(personItemsVo.getApplyClass()))
                .collect(Collectors.toList());
        if (list.size()<1){
            return "";
        }
        //取个人信息
        String hospitalId = personItemsVos.get(0).getHospitalId();
        String personId = personItemsVos.get(0).getPersonId();
        Integer personVisitId = personItemsVos.get(0).getPersonVisitId();
        List<PersonVisitAndInfoVo> personVisitAndInfoVos = this.findPersonInfo(hospitalId,personId,personVisitId.toString());
        if(personVisitAndInfoVos==null||personVisitAndInfoVos.size() == 0){
            return "取个人基本信息失败";
        }
        PersonVisitAndInfoVo pInfo = personVisitAndInfoVos.get(0);
        String examClass = "";
        String examSubClass = "";
        String examClassCode = "";
        String orderBy = "";
        String applySendTo = "";//申请发往
        QueryRunner queryRunner = new QueryRunner();
        List<ExamApplyVo> examApplyVoList = new ArrayList<>();
        //需要发送申请的检查组合项目
        List<HcExamMaster> hcExamMasterList = new ArrayList<>();//发送成功的申请项目主记录集合
        List<HcExamItems> hcExamItemsList = new ArrayList<>();//发送成功的申请项目明细集合
        List<PersonItemsVo> personItemsVoList = new ArrayList<>();//发送成功的组合项目集合
        for (PersonItemsVo personItemsVo : list){
            String itemPackCode = personItemsVo.getItemPackCode();
            applySendTo = pubCommMapper.selectApplySendTo(itemPackCode);
            if(StringUtils.isEmpty(applySendTo)||"0000".equals(applySendTo)){
                continue;//不需要发往
            }
            if(crossDB){
                //取数据连接Connection
                List<InterfaceSourceVo> interfaceSourceVos = this.findItemExternalInterface(hospitalId, itemPackCode);
                if(interfaceSourceVos == null || interfaceSourceVos.size() == 0){
                    return "取项目接口数据源失败！";
                }
                String serviceName = interfaceSourceVos.get(0).getServiceName();
                String userName = interfaceSourceVos.get(0).getUserName();
                String password = interfaceSourceVos.get(0).getPassword();
                Connection conn = connectionMap.get(interfaceSourceVos.get(0).getServiceName()+interfaceSourceVos.get(0).getUserName()+interfaceSourceVos.get(0).getPassword());
                if(conn == null){
                    conn = DruidUtils.getConnection(interfaceSourceVos.get(0).getServiceName(), interfaceSourceVos.get(0).getUserName(), interfaceSourceVos.get(0).getPassword());
                    if (conn == null) {
                        return "获取连接失败！";
                    }else{
                        connectionMap.put(interfaceSourceVos.get(0).getServiceName()+interfaceSourceVos.get(0).getUserName()+interfaceSourceVos.get(0).getPassword(), conn);
                        connList.add(conn);
                    }
                }
                orderBy = interfaceSourceVos.get(0).getOrderDept();

                //取检查类别和检查子类
                List<Map<String, Object>> dataList = pubCommMapper.selectExamClass(hospitalId, itemPackCode);
                if(dataList == null || dataList.size() < 1){
                    return "取项目检查类别失败！itemPackCode:" + itemPackCode;
                }
                //System.out.println(dataList);
                examClass = dataList.get(0).get("EXAMCLASS").toString();
                examSubClass = dataList.get(0).get("EXAMSUBCLASS")==null?"":dataList.get(0).get("EXAMSUBCLASS").toString();
                examClassCode = dataList.get(0).get("EXAMCLASSCODE").toString();

//                QueryRunner queryRunner = new QueryRunner();
//            String selecctExamAppoints = "Select count(*) From exam_appoints where exam_no = " +personItemsVo.getApplyNo();
                BigDecimal resultSetBigD;
//            try{
//                resultSetBigD =  queryRunner.query(conn, selecctExamAppoints, new ScalarHandler<BigDecimal>());
//            }catch (Exception e){
//                return "查询exam_appoints表失败！"+e.getMessage();
//            }
//            int resultSet = resultSetBigD.intValue();
                int resultSet = 0;
                StringBuilder insertSql = new StringBuilder();
//            if(resultSet == 0){
//                insertSql.append("Insert Into exam_appoints ")
//                        .append("(EXAM_NO,LOCAL_ID_CLASS,PATIENT_LOCAL_ID,PATIENT_ID,VISIT_ID,")
//                        .append("NAME,NAME_PHONETIC,SEX,DATE_OF_BIRTH,Identity,")
//                        .append("CHARGE_TYPE,EXAM_CLASS,EXAM_SUB_CLASS,PERFORMED_BY,PATIENT_SOURCE,")
//                        .append("REQ_DATE_TIME,REQ_DEPT,REQ_PHYSICIAN,SCHEDULED_DATE,COSTS,CHARGES ) ")
//                        .append("Values ('")
//                        .append(personItemsVo.getApplyNo()+"','").append(examClassCode+"',").append("'','").append(personId+"','")
//                        .append(personVisitId+"','").append(pInfo.getName()+"','").append(pInfo.getInputCode()+"','").append(pInfo.getSex()+"',")
//                        .append("to_date('"+pInfo.getBarthday()+"','yyyy-mm-dd')"+",'").append(pInfo.getIdentity()+"','")
//                        .append(pInfo.getPersonCharge()+"','").append(examClass+"','").append(examSubClass+"',").append("'',")
//                        .append("'3',").append("sysdate,'").append(orderBy+"','").append(userCode+"',").append("sysdate,0,0)");
//                try{
//                    queryRunner.update(conn, insertSql.toString());
//                }catch (Exception e){
//                    return "插入exam_appoints表失败！"+e.getMessage();
//                }
//            }
                String selecctExamMaster = "Select count(*) From HC_EXAM_MASTER where exam_no = " + personItemsVo.getApplyNo();
                try{
                    resultSetBigD = queryRunner.query(conn, selecctExamMaster, new ScalarHandler<BigDecimal>());
                }catch (Exception e){
                    return "查询exam_master表失败" + e.getMessage();
                }
                resultSet = resultSetBigD.intValue();
                if(resultSet == 0){
                    insertSql.setLength(0);
                    insertSql.append("INSERT INTO HC_EXAM_MASTER(EXAM_NO, LOCAL_ID_CLASS, PATIENT_LOCAL_ID, PATIENT_ID, VISIT_ID,")
                            .append("NAME, NAME_PHONETIC, SEX, DATE_OF_BIRTH, Identity, CHARGE_TYPE,")
                            .append("EXAM_CLASS, EXAM_SUB_CLASS, PERFORMED_BY, PATIENT_SOURCE,REQ_DATE_TIME, REQ_DEPT,")
                            .append("REQ_PHYSICIAN, SCHEDULED_DATE_TIME,COSTS, CHARGES, RESULT_STATUS, EXAM_DATE_TIME, CHARGE_INDICATOR")
                            .append(") VALUES ('")
                            .append(personItemsVo.getApplyNo()+"','").append(examClassCode+"',").append("'','").append(personId+"','").append(personVisitId+"','")
                            .append(pInfo.getName()+"','").append(pInfo.getInputCode()+"','").append(pInfo.getSex()+"',")
                            .append("to_date('"+pInfo.getBarthday()+"','yyyy-mm-dd')"+",'").append(pInfo.getIdentity()+"','").append(pInfo.getPersonCharge()+"','")
                            .append(examClass+"','").append(examSubClass+"',").append("'',").append("'3',").append("sysdate,'").append(orderBy+"','")
                            .append(userCode+"',").append("sysdate,0,0,'2',sysdate,1)");
                    try{
                        queryRunner.update(conn, insertSql.toString());
                    }catch (Exception e){
                        return "插入HC_EXAM_MASTER表失败！"+e.getMessage();
                    }
                }

                //写明细

                List<Map<String, Object>> itemDataList = pubCommMapper.selectItemVsCode(hospitalId, itemPackCode);
                //List<Map<String, Object>> itemDataList = pubCommMapper.selectPackVsClinic(hospitalId, itemPackCode, "D");
                if(itemDataList == null || itemDataList.size() < 1){
                    return "取项组合项目对照失败！" + itemPackCode;
                }
                int itemNo = 0;
                String itemCode = "";
                String itemName = "";
                for(Map<String, Object> item : itemDataList){
                    itemNo++;
//                itemCode = item.get("EXTNAME").toString();
//                itemName = item.get("EXTCODE").toString();
                    itemCode = item.get("ITEMCODE").toString();
                    itemName = item.get("ITEMNAME").toString();
                    String selecctExamItem = "select count(*) From HC_EXAM_ITEMS where exam_no = " + personItemsVo.getApplyNo()+" and exam_item_no = "+itemNo;
                    try{
                        resultSetBigD = queryRunner.query(conn, selecctExamItem, new ScalarHandler<>());
                    }catch (Exception e){
                        return "查询exam_items表失败" + e.getMessage();
                    }
                    resultSet = resultSetBigD.intValue();
                    if(resultSet == 0){
                        insertSql.setLength(0);
                        insertSql.append("Insert Into HC_EXAM_ITEMS(exam_no, exam_item_no, exam_item_code, exam_item, costs) ")
                                .append("Values('").append(personItemsVo.getApplyNo()+"','").append(itemNo+"','")
                                .append(itemCode+"','").append(itemName+"', 0)");
                        try{
                            queryRunner.update(conn, insertSql.toString());
                        }catch (Exception e){
                            return "插入exam_items表失败！"+e.getMessage();
                        }
                    }
                }
            }else{
                //取检查类别和检查子类
                List<Map<String, Object>> dataList = pubCommMapper.selectExamClass(hospitalId, itemPackCode);
                if(dataList == null || dataList.size() < 1){
                    return "取项目检查类别失败！itemPackCode:" + itemPackCode;
                }
                //System.out.println(dataList);
                examClass = dataList.get(0).get("EXAMCLASS").toString();
                examSubClass = dataList.get(0).get("EXAMSUBCLASS")==null?"":dataList.get(0).get("EXAMSUBCLASS").toString();
                examClassCode = dataList.get(0).get("EXAMCLASSCODE").toString();

//            String selecctExamAppoints = "Select count(*) From exam_appoints where exam_no = " +personItemsVo.getApplyNo();
//            try{
//                resultSetBigD =  queryRunner.query(conn, selecctExamAppoints, new ScalarHandler<BigDecimal>());
//            }catch (Exception e){
//                return "查询exam_appoints表失败！"+e.getMessage();
//            }
//            int resultSet = resultSetBigD.intValue();
//            if(resultSet == 0){
//                insertSql.append("Insert Into exam_appoints ")
//                        .append("(EXAM_NO,LOCAL_ID_CLASS,PATIENT_LOCAL_ID,PATIENT_ID,VISIT_ID,")
//                        .append("NAME,NAME_PHONETIC,SEX,DATE_OF_BIRTH,Identity,")
//                        .append("CHARGE_TYPE,EXAM_CLASS,EXAM_SUB_CLASS,PERFORMED_BY,PATIENT_SOURCE,")
//                        .append("REQ_DATE_TIME,REQ_DEPT,REQ_PHYSICIAN,SCHEDULED_DATE,COSTS,CHARGES ) ")
//                        .append("Values ('")
//                        .append(personItemsVo.getApplyNo()+"','").append(examClassCode+"',").append("'','").append(personId+"','")
//                        .append(personVisitId+"','").append(pInfo.getName()+"','").append(pInfo.getInputCode()+"','").append(pInfo.getSex()+"',")
//                        .append("to_date('"+pInfo.getBarthday()+"','yyyy-mm-dd')"+",'").append(pInfo.getIdentity()+"','")
//                        .append(pInfo.getPersonCharge()+"','").append(examClass+"','").append(examSubClass+"',").append("'',")
//                        .append("'3',").append("sysdate,'").append(orderBy+"','").append(userCode+"',").append("sysdate,0,0)");
//                try{
//                    queryRunner.update(conn, insertSql.toString());
//                }catch (Exception e){
//                    return "插入exam_appoints表失败！"+e.getMessage();
//                }
//            }
                QueryWrapper<HcExamMaster> hcExamMasterQueryWrapper = new QueryWrapper<>();
                hcExamMasterQueryWrapper.eq("exam_no", personItemsVo.getApplyNo());
                Long resultSet = hcExamMasterService.count(hcExamMasterQueryWrapper);

                //HOSPITAL_ID, PERSON_ID, PERSON_VISIT_ID, ITEM_PACK_CODE, ITEM_NO
                //查询组合项目收费状态hc_person_appreg_items表的BILL_INDICATOR字段
                LambdaQueryWrapper<HcPersonAppregItems> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                lambdaQueryWrapper.eq(HcPersonAppregItems::getHospitalId, hospitalId);
                lambdaQueryWrapper.eq(HcPersonAppregItems::getPersonId, personId);
                lambdaQueryWrapper.eq(HcPersonAppregItems::getPersonVisitId, personVisitId);
                lambdaQueryWrapper.eq(HcPersonAppregItems::getItemPackCode, itemPackCode);
                HcPersonAppregItems hcPersonAppregItems = hcPersonAppregItemsService.getOne(lambdaQueryWrapper);
                String billIndicator = "0";
                if(hcPersonAppregItems!=null){
                    billIndicator = hcPersonAppregItems.getBillIndicator();
                }else{
                    throw new CommonException(500, "没有查询到预约项目:"+itemPackCode);
                }

                HcExamMaster examMaster = new HcExamMaster();
                if(resultSet == 0){
                    if(personItemsVo.getCosts()==null){
                        personItemsVo.setCosts(new BigDecimal(0));
                    }
                    if(personItemsVo.getCharges()==null){
                        personItemsVo.setCharges(new BigDecimal(0));
                    }
                    examMaster.setExamNo(personItemsVo.getApplyNo()) .setLocalIdClass(examClassCode).setPatientLocalId("")
                            .setPatientId(personId).setVisitId(personVisitId).setName(pInfo.getName())
                            .setNamePhonetic(pInfo.getInputCode()).setSex(pInfo.getSex())
                            .setDateOfBirth(DateUtils.parseString(pInfo.getBarthday(), "yyyy-MM-dd"))
                            .setIdentity(pInfo.getIdentity()).setChargeType(pInfo.getPersonCharge()).setExamClass(examClass)
                            .setExamSubClass(examSubClass).setPerformedBy(personItemsVo.getDeptName()).setPatientSource("3").setReqDateTime(new Date())
                            .setReqDept(PropertiesUtils.DEPT_NAME).setReqPhysician(userCode).setScheduledDateTime(new Date()).setCosts(personItemsVo.getCosts()).setCharges(personItemsVo.getCharges())
                            .setResultStatus("2").setExamDateTime(new Date()).setChargeIndicator(Integer.parseInt(billIndicator)).setRptstatus("25");
                    //hcExamMasterService.save(examMaster);
                    hcExamMasterList.add(examMaster);
                }
                //向HIS平台发送检查申请
                //拼装ExamApplyVo对象
                ExamApplyVo examApplyVo = new ExamApplyVo();
                examApplyVo.setOrbList(new ArrayList<>());
                //患者 ID
                examApplyVo.setPID_2(pInfo.getPatientId());
                // 患者姓名 黄安琪^^^HUANGANQI
                examApplyVo.setPID_5(pInfo.getName()+"^^^"+ CommonUtils.getPYFull(pInfo.getName()));
                // 出生日期
                examApplyVo.setPID_7(pInfo.getBarthday().replace("-", "")+"000000");
                // 性别 参见 GB2261-80
                examApplyVo.setPID_8(pInfo.getSex().equals("女")?"2":"1");
                examApplyVo.setPID_13_1(pInfo.getMobile());
                examApplyVo.setPID_19(pInfo.getIdNo());
                // PV1||1|101022101||||123123||||||0||||||2||||||||||||||||||||H0002|||||20220126094730
                //  患者类别 参见患者类型 YB0026
                String identity = "3";
                if(pInfo.getIdentity() != null){
                    identity = pInfo.getIdentity();
                }
                examApplyVo.setPV1_2(identity);
                // 科室 体检中心编码 97
                examApplyVo.setPV1_3_1(PropertiesUtils.DEPT_ID);
                // 就诊医生 ，暂时填写体检系统登录账号
                examApplyVo.setPV1_7(userCode);
                //就诊次数  填写体检次数
                examApplyVo.setPV1_19(personVisitId.toString());
                // 院区编码
                examApplyVo.setPV1_39(PropertiesUtils.AREACODE);
                // 就诊时间 ,暂时填写体检申请发送时间，即系统当前时间
                examApplyVo.setPV1_44(DateUtils.getDateYYYYMMDDHHMMSS());
                //ORC|NW|01D2018050800001|||||||20210918135813|||101275^ 张 大 大 ||||||||| 产 科 病 区^^1300110||||||20210920183000||D|||放射科^^1801010
                // 医嘱控制码 NW 申请 CA 撤销
                examApplyVo.setORC_1("NW");
                // 医技申请单号^^医嘱号
                examApplyVo.setORC_2(personItemsVo.getApplyNo()+"^^"+personItemsVo.getApplyNo());
                // 申请时间, 暂时写系统时间
                examApplyVo.setORC_9(DateUtils.getDateYYYYMMDDHHMMSS());
                // 申请医生 101275^张大大
                examApplyVo.setORC_12(personItemsVo.getRegister()+"^"+personItemsVo.getRegisterName());
                // 申请科室^^科室编码
                examApplyVo.setORC_21(PropertiesUtils.DEPT_NAME+"^^"+PropertiesUtils.DEPT_ID);
                // 医嘱类型,参见 YB0056
                examApplyVo.setORC_29("D");
                //根据组合项目查询his科室信息
                LambdaQueryWrapper<HcItemPackDict> hcItemPackDictLambdaQueryWrapper = new LambdaQueryWrapper<>();
                hcItemPackDictLambdaQueryWrapper.eq(HcItemPackDict::getItemPackCode, personItemsVo.getItemPackCode());
                HcItemPackDict hcItemPackDict = hcItemPackDictService.getOne(hcItemPackDictLambdaQueryWrapper);
                // 执行科室^^科室编码
                examApplyVo.setORC_32(hcItemPackDict.getHisDepartName()+"^^"+hcItemPackDict.getHisDepartCode());

                //写明细
                //List<Map<String, Object>> itemDataList = pubCommMapper.selectItemVsCode(hospitalId, itemPackCode);
                //查询组合项目与诊疗项目对照
                List<Map<String, Object>> itemDataList = pubCommMapper.selectPackVsClinic(hospitalId, itemPackCode, "D");
                if(itemDataList == null || itemDataList.size() < 1){
                    return "取项组合项目对照失败！" + itemPackCode;
                }
                int itemNo = 0;
                String itemCode = "";
                String itemName = "";
                Map<String, Object> item = itemDataList.get(0);
//                for(Map<String, Object> item : itemDataList){
                itemNo++;
                itemCode = item.get("EXTCODE").toString();
                itemName = item.get("EXTNAME").toString();
//                    itemCode = item.get("ITEMCODE").toString();
//                    itemName = item.get("ITEMNAME").toString();
//                String selecctExamItem = "select count(*) From HC_EXAM_ITEMS where exam_no = " + personItemsVo.getApplyNo()+" and exam_item_no = "+itemNo;
                //查询
                QueryWrapper<HcExamItems> hcExamItemsQueryWrapper = new QueryWrapper<>();
                hcExamItemsQueryWrapper.eq("exam_no", personItemsVo.getApplyNo()).eq("exam_item_no", itemNo);
                resultSet = hcExamItemsService.count(hcExamItemsQueryWrapper);
                if(resultSet == 0){
                    HcExamItems hcExamItems = new HcExamItems();
                    hcExamItems.setExamNo(personItemsVo.getApplyNo()).setExamItemNo(itemNo)
                            .setExamItemCode(itemCode).setExamItem(itemName).setCosts(new BigDecimal(0));
                    hcExamItemsList.add(hcExamItems);
                    //hcExamItemsService.save(hcExamItems);
                }
                ExamApplyVo.ORB orb = examApplyVo.new ORB();
                // 序号 从 1 开始，顺序增加
                orb.setORB_1(itemNo+"");
                // 诊疗项目代码^诊疗项目名称
                orb.setORB_4(itemCode+"^"+itemName);
                // 紧急标志 1 急 0 普通
                orb.setORB_5("0");
                //查询检查部位代码&检查部位名称视图。
//                String serviceName = PropertiesUtils.SERVICE_NAME;
//                String userName = PropertiesUtils.USER_NAME;
//                String password = PropertiesUtils.PASSWORD;
//                Connection conn = DruidUtils.getConnection(serviceName, userName, password);
//                String selectSql = "select clinic_item_code clinicItemCode, clinic_item_name clinicItemName," +
//                        "parts_value partsValue, parts_name partsName from hip.view_clinic_parts where " +
//                        "clinic_item_code = '"+itemCode+"'";
//                ViewClinicParts viewClinicParts = null;
//                if (conn == null) {
//                    throw new CommonException(500, "视图数据库访问失败");
//                }else{
//                    try{
//                        viewClinicParts = queryRunner.query(conn, selectSql, new ScalarHandler<ViewClinicParts>());
//                    }catch (Exception e){
//                        return "查询检查部位对照视图失败！"+e.getMessage();
//                    }
//                }
//                LambdaQueryWrapper<VClinicParts> vClinicPartsLambdaQueryWrapper = new LambdaQueryWrapper<>();
//                vClinicPartsLambdaQueryWrapper.eq(VClinicParts::getClinicItemCode, itemCode);
//                List<VClinicParts> viewClinicPartsList = vClinicPartsService.list(vClinicPartsLambdaQueryWrapper);
//                // 检查部位代码&检查部位名称 参见 YB0083
//                if(viewClinicPartsList.size()>0){
//                    orb.setORB_15_4(viewClinicPartsList.get(0).getPartsValue()+"&"+viewClinicPartsList.get(0).getPartsName());
//                }
                orb.setORB_15_4(examSubClass);
                // 项目金额
                orb.setORB_19(personItemsVo.getCosts().toString());
                examApplyVo.getOrbList().add(orb);
//                }
                examApplyVo.setDG1_1("1");
                examApplyVo.setDG1_3("Z00.001^健康查体");
                examApplyVo.setDG1_6("1");
                if(!personItemsVo.getDeptName().contains("病理")){
                    examApplyVoList.add(examApplyVo);
                }
            }
            //更新申请标志
            personItemsVoList.add(personItemsVo);
            //personItemsVo.setSubmitApply("1");
        }
        ExamApplyMLLPTCPClient examApplyMLLPTCPClient = new ExamApplyMLLPTCPClient(hl7LogService);
        List<ExamApplyVo> sendSuccessList = new ArrayList<>();
        boolean sendFail = false;
        for(ExamApplyVo examApplyVo : examApplyVoList){
            if(examApplyMLLPTCPClient.sendExamApply(examApplyVo)){//发送成功添加到成功集合r
                sendSuccessList.add(examApplyVo);
            }else{//发送失败，停止发送申请
                sendFail = true;
                break;
            }
        }
        if(sendFail){//有一个发送失败，将之前发送成功的，撤消申请
            for(ExamApplyVo examApplyVo : sendSuccessList){
                examApplyVo.setORC_1("CA");
                examApplyMLLPTCPClient.sendExamApply(examApplyVo);
            }
            return pInfo.getName()+"签到失败，请查看检查项目申请号是否生成";
        }else{//检查申请像平台发送成功后，添加到体检系统表
            hcExamMasterService.saveBatch(hcExamMasterList);
            hcExamItemsService.saveBatch(hcExamItemsList);
            for(PersonItemsVo vo : personItemsVoList){
                vo.setSubmitApply("1");
            }
        }
        return "";
    }

    @Data
    class LabMasterAndItem{
        private HclabTestMaster hclabTestMaster;
        private List<HclabTestItems> hclabTestItems;
    }

    @Override
    @Transactional
    public String sendLabApply(List<Connection> connList, List<PersonItemsVo> personItemsVos, String userName){
        //过滤检验项目
        List<PersonItemsVo> dt1 = new ArrayList<>();
        List<PersonItemsVo> drs = personItemsVos.stream()
                .filter(personItemsVo -> StringUtils.isNotEmpty(personItemsVo.getApplyNo()))
                .filter(personItemsVo -> "0".equals(personItemsVo.getSubmitApply()))
                .filter(personItemsVo -> "检验".equals(personItemsVo.getApplyClass()))
                .collect(Collectors.toList());
        if (drs.size() < 1) {
            return "";
        }
        //过滤不需要发送科室的项目
        for (PersonItemsVo dr1 : drs) {
            String itemPackCode = dr1.getItemPackCode();
            String applySendTo = pubCommMapper.selectApplySendTo(itemPackCode);
            if (applySendTo == null || "0000".equals(applySendTo)) {
                continue;//不需要发往
            }
            dt1.add(dr1);
        }
        //过滤没发送的项目 DataRow[] dataRows = dt1.Select()
        List<PersonItemsVo> dataRows = dt1;
        if (dataRows.size() < 1) {
            return "";
        }
        //取个人信息
        String hospitalId = dataRows.get(0).getHospitalId();
        String personId = dataRows.get(0).getPersonId();
        Integer personVisitId = dataRows.get(0).getPersonVisitId();
        List<PersonVisitAndInfoVo> personVisitAndInfoVos = this.findPersonInfo(hospitalId, personId, personVisitId.toString());
        if (personVisitAndInfoVos == null || personVisitAndInfoVos.size() == 0) {
            return "取个人基本信息失败";
        }
        PersonVisitAndInfoVo personInfo = personVisitAndInfoVos.get(0);
        //对体检组合项目集合进行分组操作，以申请号_标本名称_试管编码为key进行分组（分单，合管）
        Map<String, Long> groupMap = dataRows.stream().collect(Collectors.groupingBy(personItemsVo ->
                personItemsVo.getApplyNo() + "_" + personItemsVo.getSpecimanName() + "_" + personItemsVo.getTestTubeCode(), Collectors.counting()));
        //对分组字符串进行处理
        List<Map<String, Object>> query = groupMap.keySet().stream().map(key -> {
            String[] temp = key.split("_");
            Map<String, Object> record = new HashMap<>();
            record.put("applyNo", temp[0]);
            record.put("specimanName", temp[1]);
            record.put("testTubeCode", temp[2]);
            return record;
        }).collect(Collectors.toList());
        String tubeNote = "";
        List<PersonItemsVo> applyItems;
        int item_no = 0;

        List<LabMasterAndItem> labMasterAndItems = new ArrayList<>();

        List<LabApplyVo> labApplyVoList = new ArrayList<>();
        for (Map<String, Object> item : query) {
            LabMasterAndItem labMasterAndItem = new LabMasterAndItem();
            //查询组合试管字典
            QueryWrapper<PackTestTubeDict> packTestTubeDictQueryWrapper = new QueryWrapper<>();
            packTestTubeDictQueryWrapper.eq("tube_code", item.get("testTubeCode"));
            packTestTubeDictQueryWrapper.eq("hospital_id", hospitalId);
            PackTestTubeDict packTestTubeDict = packTestTubeDictService.getOne(packTestTubeDictQueryWrapper);
            tubeNote = packTestTubeDict == null ? "" : packTestTubeDict.getNote();

            //过滤相同申请号的组合项目放入applyItems集合中。
            applyItems = dataRows.stream().filter(row -> row.getApplyNo().equals(item.get("applyNo"))).collect(Collectors.toList());
            if (applyItems == null || applyItems.size() < 1) {
                continue;
            }
            if(crossDB){//走视图和表
                Map<String, Connection> connectionMap = new HashMap<>();
                //取数据连接Connection
                List<InterfaceSourceVo> interfaceSourceVos = this.findItemExternalInterface(hospitalId, applyItems.get(0).getItemPackCode());
                if (interfaceSourceVos == null || interfaceSourceVos.size() == 0) {
                    return "取项目接口数据源失败！";
                }
                Connection conn = connectionMap.get(interfaceSourceVos.get(0).getServiceName()+interfaceSourceVos.get(0).getUserName()+interfaceSourceVos.get(0).getPassword());
                if(conn == null){
                    conn = DruidUtils.getConnection(interfaceSourceVos.get(0).getServiceName(), interfaceSourceVos.get(0).getUserName(), interfaceSourceVos.get(0).getPassword());
                    if (conn == null) {
                        return "获取连接失败！";
                    }else{
                        connectionMap.put(interfaceSourceVos.get(0).getServiceName()+interfaceSourceVos.get(0).getUserName()+interfaceSourceVos.get(0).getPassword(), conn);
                        connList.add(conn);
                    }
                }

                //写入申请主记录
                String applyNo, visitId, name, namePh, personCharge, sex, age, specimenName, oper, orderBy, performedBy;
                applyNo = item.get("applyNo").toString();
                visitId = personInfo.getPersonVisitId().toString();
                name = personInfo.getName();
                namePh = personInfo.getInputCode();
                personCharge = personInfo.getPersonCharge();
                sex = personInfo.getSex();
                age = personInfo.getAge().toString();
                specimenName = item.get("specimanName")==null?"":item.get("specimanName").toString();
                oper = tubeNote;
                orderBy = userName;
                performedBy = interfaceSourceVos.get(0).getOrderDept();

                QueryRunner queryRunner = new QueryRunner();
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO hclab_test_master (TEST_NO,PRIORITY_INDICATOR,PATIENT_ID,VISIT_ID,")
                        .append("NAME,NAME_PHONETIC,CHARGE_TYPE,SEX,AGE,TEST_CAUSE,SPECIMEN,")
                        .append("NOTES_FOR_SPCM,REQUESTED_DATE_TIME,ORDERING_DEPT,ORDERING_PROVIDER,")
                        .append("PERFORMED_BY,RESULT_STATUS,COSTS,CHARGES,BILLING_INDICATOR) VALUES");
                sql.append("('"+applyNo+"',0,'"+personId+"'," + visitId + ",")
                        .append("'"+name+"','"+namePh+"','"+personCharge+"','"+sex+"'," + age + ",'体检','"+specimenName+"',")
                        .append("'"+tubeNote+"',sysdate,'"+orderBy+"','"+oper+"',")
                        .append("'"+performedBy+"','1',0,0,1)");
                try {
                    queryRunner.update(conn, sql.toString());
                } catch (SQLException sqlException) {
                    return "插入主检查记录失败"+sqlException.getMessage();
                }
                //写入明细记录
                for(int i=0; i<applyItems.size(); i++){
                    String itemPackCode = applyItems.get(i).getItemPackCode();
                    //取对照
                    //List<Map<String, Object>> dt = pubCommMapper.selectPackVsItemVsExternal(hospitalId, itemPackCode);
                    List<Map<String, Object>> dt = pubCommMapper.selectPackVsClinic(hospitalId, itemPackCode, "C");
                    if(dt == null || dt.size()<1){
                        return  "取项目对照失败！itemPackCode:"+ itemPackCode;
                    }
                    for(Map<String, Object> dr : dt){
                        sql.setLength(0);
                        item_no++;
                        //循环插入细表
                        String applyNO, itemNO, itemName, itemCode;
                        applyNO = applyItems.get(i).getApplyNo();
                        itemNO = item_no+"";
                        itemName = dr.get("EXTNAME")==null?"":dr.get("EXTNAME").toString();
                        itemCode = dr.get("EXTCODE")==null?"":dr.get("EXTCODE").toString();
                        try {
                            sql.append("INSERT INTO hclab_test_items (TEST_NO,ITEM_NO,ITEM_NAME,ITEM_CODE")
                                    .append(") VALUES ('"+applyNO+"'," + itemNO + ",'"+itemName+"','"+itemCode+"')");
                            queryRunner.update(conn, sql.toString());
                        } catch (SQLException sqlException) {
                            return "插入明细表错误！"+sqlException.getMessage();
                            //sqlException.printStackTrace();
                        }
                    }
                }
            }else{//走平台
                //写入申请主记录
                String applyNo, name, namePh, personCharge, sex, specimenName, oper, orderBy, performedBy;
                applyNo = item.get("applyNo").toString();
                int visitId = personInfo.getPersonVisitId();
                name = personInfo.getName();
                namePh = personInfo.getInputCode();
                personCharge = personInfo.getPersonCharge();
                sex = personInfo.getSex();
                int age = personInfo.getAge();
                specimenName = item.get("specimanName")==null?"":item.get("specimanName").toString();
                oper = tubeNote;
                performedBy="体检中心";

                //HOSPITAL_ID, PERSON_ID, PERSON_VISIT_ID, ITEM_PACK_CODE, ITEM_NO
                //查询组合项目收费状态hc_person_appreg_items表的BILL_INDICATOR字段
                LambdaQueryWrapper<HcPersonAppregItems> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                lambdaQueryWrapper.eq(HcPersonAppregItems::getHospitalId, hospitalId);
                lambdaQueryWrapper.eq(HcPersonAppregItems::getPersonId, personId);
                lambdaQueryWrapper.eq(HcPersonAppregItems::getPersonVisitId, personVisitId);
                lambdaQueryWrapper.eq(HcPersonAppregItems::getItemPackCode, applyItems.get(0).getItemPackCode());
                //获取其中一个组合项目的收费状态，一般情况下，相同申请单下的某个项目已收费，其他项目均已收费
                HcPersonAppregItems hcPersonAppregItems = hcPersonAppregItemsService.getOne(lambdaQueryWrapper);
                String billIndicator = "0";
                if(hcPersonAppregItems!=null){
                    billIndicator = hcPersonAppregItems.getBillIndicator();
                }else{
                    throw new CommonException(500, "没有查询到预约项目:"+applyItems.get(0).getItemPackCode());
                }
                String register = applyItems.get(0).getRegister();
                String registerName = applyItems.get(0).getRegisterName();
                //向HIS平台发送检查申请
                //拼装LabApplyVo对象
                LabApplyVo labApplyVo = new LabApplyVo();
                labApplyVo.setObrList(new ArrayList<>());
                //患者 ID
                labApplyVo.setPID_2(personInfo.getPatientId());
                //患者姓名 马 志 明 ^^^MA ZHI MING
                labApplyVo.setPID_5(personInfo.getName()+"^^^"+ CommonUtils.getPYFull(personInfo.getName()));
                //出生日期 19861222000000
                labApplyVo.setPID_7(personInfo.getBarthday()+"000000");
                //性别 参见 GB2261-80
                labApplyVo.setPID_8(personInfo.getSex().equals("nv")?"2":"1");

                //患者类别 参见 YB0026
                String identity = "3";
                if(personInfo.getIdentity() != null){
                    identity = personInfo.getIdentity();
                }
                labApplyVo.setPV1_2(identity);
                //科室
                labApplyVo.setPV1_3_1(PropertiesUtils.DEPT_ID);
                //就诊医生
                labApplyVo.setPV1_7(register);
                //就诊次数
                labApplyVo.setPV1_19(personVisitId.toString());
                //院区编码
                labApplyVo.setPV1_39(PropertiesUtils.AREACODE);
                //就诊时间
                labApplyVo.setPV1_44(DateUtils.getDateYYYYMMDDHHMMSS());
                //医嘱控制码 NW 申请、CA 撤销
                labApplyVo.setORC_1("NW");
                //医技申请单号^^医嘱号
                labApplyVo.setORC_2(applyNo+"^^"+applyNo);
                //申请时间
                labApplyVo.setORC_9(DateUtils.getDateYYYYMMDDHHMMSS());
                //申请医生 101275 ^汤鑫
                labApplyVo.setORC_12(register+"^"+registerName);
                //申请科室^^科室编码
                labApplyVo.setORC_21(PropertiesUtils.DEPT_NAME+"^^"+PropertiesUtils.DEPT_ID);
                //医嘱类型
                labApplyVo.setORC_29("D");
                //执行科室^^科室编码
                labApplyVo.setORC_32(applyItems.get(0).getDeptId()+"^^"+applyItems.get(0).getDeptName());
                //将同一申请单下的组合项目写入明细记录
                List<HclabTestItems> hclabTestItemsList = new ArrayList<>();

                //应收
                BigDecimal countCosts = new BigDecimal(0);
                //实收
                BigDecimal countCharges = new BigDecimal(0);

                item_no = 0;
                for(int i=0; i<applyItems.size(); i++){
                    //计算费用
                    if(applyItems.get(i).getCosts()!=null){
                        countCosts = countCosts.add(applyItems.get(i).getCosts());
                    }
                    if(applyItems.get(i).getCharges()!=null){
                        countCharges = countCharges.add(applyItems.get(i).getCharges());
                    }
                    String itemPackCode = applyItems.get(i).getItemPackCode();
                    //查询组合项目与诊疗项目对照表，获取当前组合项目的诊疗项目信息，集合就一条数据
                    //List<Map<String, Object>> dt = pubCommMapper.selectPackVsItemVsExternal(hospitalId, itemPackCode);
                    List<Map<String, Object>> dt = pubCommMapper.selectPackVsClinic(hospitalId, itemPackCode, "C");
                    if(dt == null || dt.size()<1){
                        return  "取项目对照失败！itemPackCode:"+ itemPackCode;
                    }
//                    for(Map<String, Object> dr : dt){
                    Map<String, Object> dr = dt.get(0);
                    item_no++;
//                    //根据test_no查询hclab_test_item最大item_no
//                    QueryWrapper<HclabTestItems> hclabTestItemsLambdaQueryWrapper = new QueryWrapper();
//                    hclabTestItemsLambdaQueryWrapper.eq("test_no", applyItems.get(0).getApplyNo());
//                    hclabTestItemsLambdaQueryWrapper.select("max(item_no) as max_no");
//                    Map<String, Object> map = hclabTestItemsService.getMap(hclabTestItemsLambdaQueryWrapper);
//                    if(map != null){
//                        BigDecimal maxNo = (BigDecimal) map.get("MAX_NO");
//                        item_no = maxNo.intValue() +1;
//                    }else{
//                        item_no++;
//                    }
                    //循环插入细表
                    String applyNO, itemName, itemCode;
                    int itemNO;
                    applyNO = applyItems.get(i).getApplyNo();
                    itemNO = item_no;
                    itemName = dr.get("EXTNAME")==null?"":dr.get("EXTNAME").toString();
                    itemCode = dr.get("EXTCODE")==null?"":dr.get("EXTCODE").toString();
                    HclabTestItems hclabTestItems = new HclabTestItems();
                    hclabTestItems.setTestNo(applyNO).setItemNo(itemNO).setItemName(itemName).setItemCode(itemCode);
                    hclabTestItemsList.add(hclabTestItems);
//                    if(!hclabTestItemsService.save(hclabTestItems)){
//                        return "插入明细表错误！";
//                    }
                    LabApplyVo.OBR obr = labApplyVo.new OBR();
                    //序号 医 技 申 请 明 细 序号，用于医嘱闭环使用
                    obr.setOBR_1(itemNO+"");
                    //检验项目 JY011^肝功能全套
                    obr.setOBR_4(itemCode+"^"+itemName);
                    //紧急标志 1 急，0 普通
                    obr.setOBR_5("0");
                    //样本代码&样本名称 参见 YB0006
                    //获取标本代码
                    LambdaQueryWrapper<HisSpecimanDict> hisSpecimanDictLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    hisSpecimanDictLambdaQueryWrapper.eq(HisSpecimanDict::getItemName, specimenName);
                    HisSpecimanDict hisSpecimanDict = hisSpecimanDictService.getOne(hisSpecimanDictLambdaQueryWrapper);
                    if(hisSpecimanDict!=null){
                        obr.setOBR_15_1(hisSpecimanDict.getItemValue()+"&"+specimenName);
                    }else{
                        obr.setOBR_15_1("&"+specimenName);
                    }
                    //项目金额
                    obr.setOBR_19(applyItems.get(i).getCosts().toString());
                    labApplyVo.getObrList().add(obr);
//                    }
                }
                labMasterAndItem.setHclabTestItems(hclabTestItemsList);
                //序号 只有 1 个 DG1,取申请单主表中的诊断
                labApplyVo.setDG1_1("1");
                //临床诊断 K72.905^肝功能不全
                labApplyVo.setDG1_3("Z00.001^健康查体");
                //诊断类型 默认值 A
                labApplyVo.setDG1_6("A");
                //检验申请推送，需放开此注解
                //labApplyVoList.add(labApplyVo);

                String vesselName = packTestTubeDict.getTubeName(); //试管名称


                //PersonItemsVo
                // (hospitalId=0001, personId=2022071300001, personVisitId=1, unitId=0000, unitVisitId=0, itemPackCode=36, itemPackName=肾功二项, registerDate=Wed Aug 03 17:32:13 CST 2022,
                // register=ldp, registerName=系统管理员, addItem=0, chartCode=3, applyNo=220803000528, submitApply=1, applyNoPrint=null, costs=10, charges=10, billIndicator=0,
                // finishedSign=未完成, num=1, setCode=null, itemNo=2, img=3, specimanName=静脉血, drawBlood=1, testTubeCode=20, applySendto=HIS0101, applyClass=检验, deptId=2, deptName=检验科)
                HclabTestMaster hclabTestMaster = new HclabTestMaster();
                hclabTestMaster.setTestNo(applyNo).setPriorityIndicator(0).setPatientId(personId).setVisitId(visitId)
                        .setName(name).setNamePhonetic(namePh).setChargeType(personCharge).setSex(sex).setAge(age).setTestCause("体检")
                        .setSpecimen(specimenName).setNotesForSpcm(tubeNote).setRequestedDateTime(new Date()).setOrderingDept(PropertiesUtils.DEPT_ID)
                        .setOrderingProvider(register).setPerformedBy(applyItems.get(0).getDeptId()).setResultStatus("1").setCosts(countCosts)
                        .setCharges(countCharges).setBillingIndicator(Integer.parseInt(billIndicator)).setVesselName(vesselName);
                labMasterAndItem.setHclabTestMaster(hclabTestMaster);
//                if(!hclabTestMasterService.save(hclabTestMaster)){
//                    return "插入主检查记录失败";
//                }
            }
            labMasterAndItems.add(labMasterAndItem);
        }
        LabApplyMLLPTCPClient labApplyMLLPTCPClient = new LabApplyMLLPTCPClient(hl7LogService);
        List<LabApplyVo> sendSuccessList = new ArrayList<>();
        boolean sendFail = false;
        for(LabApplyVo labApplyVo : labApplyVoList){
            if(labApplyMLLPTCPClient.sendLabApply(labApplyVo)){//发送成功添加到成功集合
                sendSuccessList.add(labApplyVo);
            }else{//发送失败，停止发送申请
                sendFail = true;
                break;
            }
        }
        if(sendFail){//有一个发送失败，将之前发送成功的，撤消申请
            for(LabApplyVo labApplyVo : sendSuccessList){
                labApplyVo.setORC_1("CA");
                labApplyMLLPTCPClient.sendLabApply(labApplyVo);
                //将失败的申请记录日志
            }
        }else{ //检验申请像平台发送成功后，添加到体检系统表
            for(LabMasterAndItem labMasterAndItem : labMasterAndItems){
                hclabTestMasterService.saveOrUpdate(labMasterAndItem.getHclabTestMaster());
                hclabTestItemsService.saveBatch(labMasterAndItem.getHclabTestItems());
            }
            //更新申请标志
            for(PersonItemsVo personItemsVo : dataRows){
                personItemsVo.setSubmitApply("1");
            }
        }
        return "";
    }

    @Override
    @Transactional
    public void deleteApply(List<Connection> connList, List<PersonItemsVo> dsItemList) {
//        Map<String, Connection> connectionMap = new HashMap<>();
//        //取数据连接Connection
//        List<InterfaceSourceVo> interfaceSourceVos = this.findItemExternalInterface(hospitalId, itemPackCode);
//        if (interfaceSourceVos == null || interfaceSourceVos.size() == 0) {
//            throw new CommonException(500, "取项目接口数据源失败！");
//        }
//        Connection conn = connectionMap.get(interfaceSourceVos.get(0).getServiceName()+interfaceSourceVos.get(0).getUserName()+interfaceSourceVos.get(0).getPassword());
//        if(conn == null){
//            conn = DruidUtils.getConnection(interfaceSourceVos.get(0).getServiceName(), interfaceSourceVos.get(0).getUserName(), interfaceSourceVos.get(0).getPassword());
//            if (conn == null) {
//                throw new CommonException(500, "获取连接失败！");
//            }else{
//                connectionMap.put(interfaceSourceVos.get(0).getServiceName()+interfaceSourceVos.get(0).getUserName()+interfaceSourceVos.get(0).getPassword(), conn);
//                connList.add(conn);
//            }
//        }
//        List<PersonItemsVo> drs = dsItemList.stream()
//                .filter(personItemsVo -> "0".equals(personItemsVo.getSubmitApply()))
//                .filter(personItemsVo -> "检验".equals(personItemsVo.getApplyClass()))
//                .collect(Collectors.toList());

    }

    @Override
    public String deleteExamOrLabApply(List<Connection> connList, HcPersonAppregItems item, String itemClass) {
//        Map<String, Connection> connectionMap = new HashMap<>();
//        //取数据连接Connection
//        List<InterfaceSourceVo> interfaceSourceVos = this.findItemExternalInterface(item.getHospitalId(), item.getItemPackCode());
//        if (interfaceSourceVos == null || interfaceSourceVos.size() == 0) {
//            throw new CommonException(500, "取项目接口数据源失败！");
//        }
//        Connection conn = connectionMap.get(interfaceSourceVos.get(0).getServiceName()+interfaceSourceVos.get(0).getUserName()+interfaceSourceVos.get(0).getPassword());
//        if(conn == null){
//            conn = DruidUtils.getConnection(interfaceSourceVos.get(0).getServiceName(), interfaceSourceVos.get(0).getUserName(), interfaceSourceVos.get(0).getPassword());
//            if (conn == null) {
//                throw new CommonException(500, "获取连接失败！");
//            }else{
//                connectionMap.put(interfaceSourceVos.get(0).getServiceName()+interfaceSourceVos.get(0).getUserName()+interfaceSourceVos.get(0).getPassword(), conn);
//                connList.add(conn);
//            }
//        }
        if(StringUtils.isEmpty(item.getApplyNo())){
            return null;
        }
        if("检查".equals(itemClass)){
//            QueryRunner queryRunner = new QueryRunner();
//            StringBuilder sql = new StringBuilder();
            //取检查状态
//            sql.append("SELECT result_status   FROM HC_EXAM_MASTER");
//            sql.append(" where EXAM_NO = '" + item.getApplyNo() + "' and HOSPITAL_ID = '" + item.getHospitalId() + "'");
            String resultstatus = null;
            QueryWrapper<HcExamMaster> hcExamMasterQueryWrapper = new QueryWrapper<>();
            hcExamMasterQueryWrapper.eq("EXAM_NO", item.getApplyNo());
            //hcExamMasterQueryWrapper.eq("HOSPITAL_ID", item.getHospitalId());
            HcExamMaster examMaster = hcExamMasterService.getOne(hcExamMasterQueryWrapper);
            resultstatus = examMaster.getResultStatus();
//            try {
//                resultstatus = queryRunner.query(conn, sql.toString(), new ScalarHandler<String>());
//            } catch (SQLException sqlException) {
//                sqlException.printStackTrace();
//                return "查询检查状态失败！";
//            }
            //未出报告，可以删除
            if(resultstatus == null || !"4".equals(resultstatus)){
                try {
//                    sql.setLength(0);
                    //删除申请记录
//                    sql.append("delete from exam_appoints where exam_no = '" + item.getApplyNo() + "'");
//                    queryRunner.update(conn,sql.toString());
                    //删除主记录
//                    sql.setLength(0);
//                    sql.append("delete from HC_EXAM_MASTER where exam_no = '" + item.getApplyNo() + "'");
//                    queryRunner.update(conn,sql.toString());

                    //向HIS平台发送检查撤销申请
                    //取个人信息
                    String hospitalId = item.getHospitalId();
                    String personId = item.getPersonId();
                    Integer personVisitId = item.getPersonVisitId();
                    List<PersonVisitAndInfoVo> personVisitAndInfoVos = this.findPersonInfo(hospitalId,personId,personVisitId.toString());
                    if(personVisitAndInfoVos==null||personVisitAndInfoVos.size() == 0){
                        return "取个人基本信息失败";
                    }
                    PersonVisitAndInfoVo pInfo = personVisitAndInfoVos.get(0);
                    //拼装ExamApplyVo对象
                    ExamApplyVo examApplyVo = new ExamApplyVo();
                    examApplyVo.setOrbList(new ArrayList<>());
                    //患者 ID
                    examApplyVo.setPID_2(pInfo.getPatientId());
                    // 患者姓名 黄安琪^^^HUANGANQI
                    examApplyVo.setPID_5(pInfo.getName()+"^^^"+ CommonUtils.getPYFull(pInfo.getName()));
                    // 出生日期
                    examApplyVo.setPID_7(pInfo.getBarthday().replace("-", "")+"000000");
                    // 性别 参见 GB2261-80
                    examApplyVo.setPID_8(pInfo.getSex().equals("女")?"2":"1");
                    examApplyVo.setPID_13_1(pInfo.getMobile());
                    examApplyVo.setPID_19(pInfo.getIdNo());
                    // PV1||1|101022101||||123123||||||0||||||2||||||||||||||||||||H0002|||||20220126094730
                    //  患者类别 参见患者类型 YB0026
                    String identity = "3";
                    if(pInfo.getIdentity() != null){
                        identity = pInfo.getIdentity();
                    }
                    examApplyVo.setPV1_2(identity);
                    // 科室 体检中心编码 97
                    examApplyVo.setPV1_3_1(PropertiesUtils.DEPT_ID);
                    // 就诊医生 ，暂时填写体检系统登录账号
                    examApplyVo.setPV1_7(item.getRegister());
                    //就诊次数  填写体检次数
                    examApplyVo.setPV1_19(personVisitId.toString());
                    // 院区编码
                    examApplyVo.setPV1_39(PropertiesUtils.AREACODE);
                    // 就诊时间 ,暂时填写体检申请发送时间，即系统当前时间
                    examApplyVo.setPV1_44(DateUtils.getDateYYYYMMDDHHMMSS());
                    //ORC|NW|01D2018050800001|||||||20210918135813|||101275^ 张 大 大 ||||||||| 产 科 病 区^^1300110||||||20210920183000||D|||放射科^^1801010
                    // 医嘱控制码 NW 申请 CA 撤销
                    examApplyVo.setORC_1("CA");
                    // 医技申请单号^^医嘱号
                    examApplyVo.setORC_2(item.getApplyNo()+"^^"+item.getApplyNo());
                    // 申请时间, 暂时写系统时间
                    examApplyVo.setORC_9(DateUtils.getDateYYYYMMDDHHMMSS());
                    // 申请医生 101275^张大大
                    examApplyVo.setORC_12(item.getRegister()+"^"+item.getRegisterName());
                    // 申请科室^^科室编码
                    examApplyVo.setORC_21(PropertiesUtils.DEPT_NAME+"^^"+PropertiesUtils.DEPT_ID);
                    // 医嘱类型,参见 YB0056
                    examApplyVo.setORC_29("D");
                    //根据组合项目查询his科室信息
                    LambdaQueryWrapper<HcItemPackDict> hcItemPackDictLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    hcItemPackDictLambdaQueryWrapper.eq(HcItemPackDict::getItemPackCode, item.getItemPackCode());
                    HcItemPackDict hcItemPackDict = hcItemPackDictService.getOne(hcItemPackDictLambdaQueryWrapper);
                    // 执行科室^^科室编码
                    examApplyVo.setORC_32(hcItemPackDict.getHisDepartName()+"^^"+hcItemPackDict.getHisDepartCode());

                    //查询组合项目与诊疗项目对照
                    List<Map<String, Object>> itemDataList = pubCommMapper.selectPackVsClinic(hospitalId, item.getItemPackCode(), "D");
                    if(itemDataList == null || itemDataList.size() < 1){
                        return "取项组合项目对照失败！" + item.getItemPackCode();
                    }
                    int itemNo = 0;
                    String itemCode = "";
                    String itemName = "";
                    Map<String, Object> itemMap = itemDataList.get(0);
                    itemNo++;
                    itemCode = itemMap.get("EXTCODE").toString();
                    itemName = itemMap.get("EXTNAME").toString();

                    ExamApplyVo.ORB orb = examApplyVo.new ORB();
                    // 序号 从 1 开始，顺序增加
                    orb.setORB_1(itemNo+"");
                    // 诊疗项目代码^诊疗项目名称
                    orb.setORB_4(itemCode+"^"+itemName);
                    // 紧急标志 1 急 0 普通
                    orb.setORB_5("0");
                    //查询检查部位代码&检查部位名称视图。
                    orb.setORB_15_4(examMaster.getExamSubClass());
                    // 项目金额
                    orb.setORB_19(item.getCosts().toString());
                    examApplyVo.getOrbList().add(orb);
                    examApplyVo.setDG1_1("1");
                    examApplyVo.setDG1_3("Z00.001^健康查体");
                    examApplyVo.setDG1_6("1");
                    ExamApplyMLLPTCPClient examApplyMLLPTCPClient = new ExamApplyMLLPTCPClient(hl7LogService);
                    if(!item.getDeptName().contains("病理")){
                        if(examApplyMLLPTCPClient.sendExamApply(examApplyVo)){//发送成功添加到成功集合r
                            hcExamMasterService.remove(hcExamMasterQueryWrapper);
                            //删除明细记录
//                    sql.setLength(0);
//                    sql.append("delete from HC_EXAM_ITEMS where exam_no = '" + item.getApplyNo() + "'");
//                    queryRunner.update(conn,sql.toString());
                            QueryWrapper<HcExamItems> hcExamItemsQueryWrapper = new QueryWrapper<>();
                            hcExamItemsQueryWrapper.eq("exam_no", item.getApplyNo());
                            hcExamItemsService.remove(hcExamItemsQueryWrapper);
                        }else{
                            return "发送HIS撤销申请失败！";
                        }
                    }else{
                        hcExamMasterService.remove(hcExamMasterQueryWrapper);
                        //删除明细记录
//                    sql.setLength(0);
//                    sql.append("delete from HC_EXAM_ITEMS where exam_no = '" + item.getApplyNo() + "'");
//                    queryRunner.update(conn,sql.toString());
                        QueryWrapper<HcExamItems> hcExamItemsQueryWrapper = new QueryWrapper<>();
                        hcExamItemsQueryWrapper.eq("exam_no", item.getApplyNo());
                        hcExamItemsService.remove(hcExamItemsQueryWrapper);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    return "删除检查申请失败！";
                }
            }
        }
        if("检验".equals(itemClass)){
//            QueryRunner queryRunner = new QueryRunner();
//            StringBuilder sql = new StringBuilder();
            //取检查状态
//            sql.append("SELECT result_status   FROM hclab_test_master");
//            sql.append(" where TEST_NO = '" + item.getApplyNo() + "' and HOSPITAL_ID = '" + item.getHospitalId() + "'");
            QueryWrapper<HclabTestMaster> hclabTestMasterQueryWrapper = new QueryWrapper<>();
            hclabTestMasterQueryWrapper.eq("TEST_NO", item.getApplyNo());
            //hclabTestMasterQueryWrapper.eq("HOSPITAL_ID", item.getHospitalId());
            HclabTestMaster hclabTestMaster = hclabTestMasterService.getOne(hclabTestMasterQueryWrapper);
            String resultstatus = null;
//            try {
//                resultstatus = queryRunner.query(conn, sql.toString(), new ScalarHandler<String>());
//            } catch (SQLException sqlException) {
//                sqlException.printStackTrace();
//                return "查询检验状态失败！";
//            }
            if(hclabTestMaster!=null){
                resultstatus = hclabTestMaster.getResultStatus();
            }
            //未出报告，可以删除
            if(resultstatus == null || Integer.parseInt(resultstatus)<3){
                try {
//                    sql.setLength(0);
                    //删除主记录
//                    sql.setLength(0);
//                    sql.append("delete from hclab_test_master where test_no = '" + item.getApplyNo() + "'  and hospital_id = '" + item.getHospitalId() + "'");
//                    queryRunner.update(conn,sql.toString());
                    hclabTestMasterService.remove(hclabTestMasterQueryWrapper);
                    //删除明细记录
//                    sql.setLength(0);
//                    sql.append("delete from hclab_test_items where test_no = '" + item.getApplyNo() + "'  and hospital_id = '" + item.getHospitalId() + "'");
//                    queryRunner.update(conn,sql.toString());
                    QueryWrapper<HclabTestItems> hclabTestItemsQueryWrapper = new QueryWrapper<>();
                    hclabTestItemsQueryWrapper.eq("TEST_NO", item.getApplyNo());
                    //hclabTestItemsQueryWrapper.eq("HOSPITAL_ID", item.getHospitalId());
                    hclabTestItemsService.remove(hclabTestItemsQueryWrapper);
                }catch (Exception e){
                    e.printStackTrace();
                    return "删除检验申请失败！";
                }
            }
        }
        return null;
    }

    @Override
    public List<HcItemReportWriteDict> findHcItemReportWriteDict(HcItemReportWriteDict hcItemReportWriteDict) {
        QueryWrapper<HcItemReportWriteDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotEmpty(hcItemReportWriteDict.getHospitalId()), "HOSPITAL_ID", hcItemReportWriteDict.getHospitalId());
        queryWrapper.eq(StringUtils.isNotEmpty(hcItemReportWriteDict.getHcItemCode()), "HC_ITEM_CODE", hcItemReportWriteDict.getHcItemCode());
        queryWrapper.eq(StringUtils.isNotEmpty(hcItemReportWriteDict.getKeyName()), "KEY_NAME", hcItemReportWriteDict.getKeyName());
        List<HcItemReportWriteDict> list = hcItemReportWriteDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcItemReportWriteDict());
        }
        return list;
    }

    @Override
    public List<PersonVisitAndInfoVo> findPersonInfo(String hospitalId, String personId, String personVisitId) {
        List<PersonVisitAndInfoVo> list = pubCommMapper.selectPersonInfo(hospitalId, personId, personVisitId);
        if(list.size()>0){
            return list;
        }
        return null;
    }

    @Override
    public List<Connection> getConnects(String hospitalId, String sourceId){
        QueryWrapper<InterfaceSource> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalId);
        queryWrapper.eq("source_id", sourceId);
        InterfaceSource interfaceSource = interfaceSourceService.getOne(queryWrapper);
        String serviceName = interfaceSource.getServiceName();
        String userName = interfaceSource.getUserName();
        String password = interfaceSource.getPassword();
        Connection conn = DruidUtils.getConnection(serviceName, userName, password);
        List<Connection> list = new ArrayList<>();
        if(conn!=null){
            list.add(conn);
        }
        return list;
    }
}
