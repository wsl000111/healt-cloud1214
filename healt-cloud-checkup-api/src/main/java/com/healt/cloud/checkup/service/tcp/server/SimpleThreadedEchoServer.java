package com.healt.cloud.checkup.service.tcp.server;

/**
 * @author GuYue
 * @date 2022-07-17 10:59
 * @description: TODO
 */
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.appointmentReg.mapper.PersonInfoMapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.service.HclabResultService;
import com.healt.cloud.checkup.service.tcp.message.MessageParseUtil;
import com.healt.cloud.checkup.service.tcp.vo.pathology.PathologyApplyRspVo;
import com.healt.cloud.checkup.service.tcp.vo.pathology.PathologyApplyRspVo_old;
import com.healt.cloud.common.utils.CommonUtils;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.PropertiesUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Component
public class SimpleThreadedEchoServer implements Runnable{

    private static final char START_OF_BLOCK = '\u000b';//mllp协议开头
    private static final char END_OF_BLOCK = '\u001c';//mllp协议结束1
    private static final char END_OF_BLOCK2 = 13;//mllp协议结束2
    private static final char CARRIAGE_RETURN = 13;//mllp协议换行符

    private int listenPort;

    private static HclabTestMasterService hclabTestMasterService;
    @Autowired
    public void setHclabTestMasterService (HclabTestMasterService hclabTestMasterService){
        SimpleThreadedEchoServer.hclabTestMasterService = hclabTestMasterService;
    }

    private static HclabResultService hclabResultService;
    @Autowired
    public void setHclabResultService (HclabResultService hclabResultService){
        SimpleThreadedEchoServer.hclabResultService = hclabResultService;
    }

    private static HcExamMasterService hcExamMasterService;
    @Autowired
    public void setHcExamMasterService (HcExamMasterService hcExamMasterService){
        SimpleThreadedEchoServer.hcExamMasterService = hcExamMasterService;
    }

    private static HcExamItemsService hcExamItemsService;
    @Autowired
    public void setHcExamItemsService (HcExamItemsService hcExamItemsService){
        SimpleThreadedEchoServer.hcExamItemsService = hcExamItemsService;
    }

    private static HcExamReportService hcExamReportService;
    @Autowired
    public void setHcExamReportService (HcExamReportService hcExamReportService){
        SimpleThreadedEchoServer.hcExamReportService = hcExamReportService;
    }

    private static HcPersonVisitInfoService hcPersonVisitInfoService;
    @Autowired
    public void setHcExamReportService (HcPersonVisitInfoService hcPersonVisitInfoService){
        SimpleThreadedEchoServer.hcPersonVisitInfoService = hcPersonVisitInfoService;
    }

    private static HcPersonInfoService hcPersonInfoService;
    @Autowired
    public void setHcPersonInfoService (HcPersonInfoService hcPersonInfoService){
        SimpleThreadedEchoServer.hcPersonInfoService = hcPersonInfoService;
    }

    private static PersonInfoMapper personInfoMapper;
    @Autowired
    public void setPersonInfoMapper (PersonInfoMapper personInfoMapper){
        SimpleThreadedEchoServer.personInfoMapper = personInfoMapper;
    }

    private static VHcItemPackDictService vHcItemPackDictService;
    @Autowired
    public void setVHcItemPackDictService (VHcItemPackDictService vHcItemPackDictService){
        SimpleThreadedEchoServer.vHcItemPackDictService = vHcItemPackDictService;
    }

    private static HcPackVsClinicService hcPackVsClinicService;
    @Autowired
    public void setHcPackVsClinicService (HcPackVsClinicService hcPackVsClinicService){
        SimpleThreadedEchoServer.hcPackVsClinicService = hcPackVsClinicService;
    }

    private static HcItemPackDictService hcItemPackDictService;
    @Autowired
    public void setHcItemPackDictService (HcItemPackDictService hcItemPackDictService){
        SimpleThreadedEchoServer.hcItemPackDictService = hcItemPackDictService;
    }

    private static Hl7ReceiveLogService hl7ReceiveLogService;
    @Autowired
    public void setHl7ReceiveLogService(Hl7ReceiveLogService hl7ReceiveLogService){
        System.out.println("hl7ReceiveLogService");
        SimpleThreadedEchoServer.hl7ReceiveLogService = hl7ReceiveLogService;
    }

    private static HcPersonAppregItemsService hcPersonAppregItemsService;
    @Autowired
    public void setHcPersonAppregItemsService(HcPersonAppregItemsService hcPersonAppregItemsService) {
        System.out.println("注入hcPersonAppregItemsService");
        SimpleThreadedEchoServer.hcPersonAppregItemsService = hcPersonAppregItemsService;
    }


    public SimpleThreadedEchoServer(){}

    public SimpleThreadedEchoServer(int aListenPort) {
        listenPort = aListenPort;
    }

    public static void main(String[] args) {
        SimpleThreadedEchoServer server = new SimpleThreadedEchoServer(1080);
        server.acceptIncomingConnections();
    }

    @Bean
    public void createSockerService(){
        SimpleThreadedEchoServer server = new SimpleThreadedEchoServer(1080);
        new Thread(server).start();
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(listenPort, 5); //Accept up to 5 clients in the queue
            System.out.println("Server has been started");
            Socket clientSocket = null;
            while (true) {
                clientSocket = server.accept();
                handleIncomingConnection(clientSocket);
            }
        } catch (BindException e) {
            System.out.println("Unable to bind to port " + listenPort);
        } catch (IOException e) {
            System.out.println("Unable to instantiate a ServerSocket on port: " + listenPort);
        }
    }

    private void acceptIncomingConnections() {
        try {
            ServerSocket server = new ServerSocket(listenPort, 5); //Accept up to 5 clients in the queue
            System.out.println("Server has been started");
            Socket clientSocket = null;
            while (true) {
                clientSocket = server.accept();
                System.out.println("new client");
                handleIncomingConnection(clientSocket);
            }
        } catch (BindException e) {
            System.out.println("Unable to bind to port " + listenPort);
        } catch (IOException e) {
            System.out.println("Unable to instantiate a ServerSocket on port: " + listenPort);
        }
    }

    protected void handleIncomingConnection(Socket aConnectionToHandle) {
        new Thread(new ConnectionHandler(aConnectionToHandle)).start();
    }

    //@Slf4j
    private static class ConnectionHandler implements Runnable {
        private String authCode = "f4d032801283371e266828fed1101828";
        private Socket connection = null;
        private int receivedMessageSize;
        private byte[] receivedByeBuffer = new byte[BUFFER_SIZE];
        private static final int BUFFER_SIZE = 32;
        private static String SENDER = "PHYS";
        private static String RECEIVER = "HIS";

        public ConnectionHandler(Socket aClientSocket) {
            System.out.println("ConnectionHandler is new-"+DateUtils.praseDate(new Date(),"yyyyMMdd HH:mm:ss")+"-"+aClientSocket.toString());
            connection = aClientSocket;
        }

        public void run() {
            InputStream in = null;
            OutputStream out = null;
            String msh10 = "";
            Hl7ReceiveLog hl7ReceiveLog = new Hl7ReceiveLog();
            try {
                in = connection.getInputStream();
                System.out.println("获取输入流信息："+DateUtils.praseDate(new Date(),"yyyyMMdd HH:mm:ss")+"-"+connection.toString());
                boolean OK = true;
                String errMsg = "";
                //接收客户端字节流数据
                String aParsedHL7Message = MessageParseUtil.getMessage(in);

                //log.info("接收平台信息："+aParsedHL7Message);
                Hl7ReceiveLog hl7ReceiveLogIn = new Hl7ReceiveLog();
                hl7ReceiveLogIn.setDataType("接收");
                hl7ReceiveLogIn.setInsertDate(new Date());
                hl7ReceiveLogIn.setMethod("接收平台信息");
                hl7ReceiveLogIn.setUuid("");
                hl7ReceiveLogIn.setApplyNo("");
                hl7ReceiveLogIn.setHl7Data(aParsedHL7Message);
                //hl7ReceiveLogService.save(hl7ReceiveLogIn);

                String msh = "";
                String msh_9 = "";
                //消息 ID
                String msh_10 = "";
                String patientId = "";//患者id
                String code = ""; // 引导介质编码
                String type = ""; //引导介质类型
                String name = ""; //患者姓名
                String deptName = ""; //执行科室名称

                if(StringUtils.isEmpty(aParsedHL7Message)){//客户端心跳检测
                    OK = true;
                    errMsg = "";
                }else{
                    //获取消息类型
                    msh = MessageParseUtil.getMessageValue(aParsedHL7Message, "MSH");
                    msh_9 = MessageParseUtil.getValueByIndex(msh, 9);
                    System.out.println(msh_9);
                    msh_10 = MessageParseUtil.getValueByIndex(msh, 10);
                    msh10 = msh_10;
                    //获取PID
                    String PID = MessageParseUtil.getMessageValue(aParsedHL7Message, "PID");
                    patientId = MessageParseUtil.getValueByIndex(PID, 3);
                    String pid3 = MessageParseUtil.getValueByIndex(PID, 4);
                    //String[] pid3Ary = pid3.split("\\^");
//                    code = pid3Ary[0];
//                    type = pid3Ary[4];
                    code = "";
                    type = "";
                    name = "";//MessageParseUtil.getValueByIndex(PID, 6).split("\\^")[0];
                    String ORC = MessageParseUtil.getMessageValue(aParsedHL7Message, "ORC");
                    deptName = "";//MessageParseUtil.getValueByIndex(ORC, 33);

                }
                if("ORG^O20^ORG_O20".equals(msh_9)){//检验状态回传
                    try {
                        String orc = MessageParseUtil.getMessageValue(aParsedHL7Message, "ORC");
                        String labTestNo = MessageParseUtil.getValueByIndex(orc, 2);//开单者申请单号
                        String[] labTestNos = labTestNo.split("^");
                        String testNo = labTestNos[0];
                        //TODO 此处无5这个参数，只在obr里面有结果状态参数，但是obr是多个，所以此处疑问
                        String status = MessageParseUtil.getValueByIndex(orc, 5);//检验状态

                        hl7ReceiveLog.setDataType("接收");
                        hl7ReceiveLog.setInsertDate(new Date());
                        hl7ReceiveLog.setMethod("ORG^O20^ORG_O20 检验状态回传");
                        hl7ReceiveLog.setUuid(msh10);
                        hl7ReceiveLog.setApplyNo(labTestNo);
                        if(StringUtils.isNotEmpty(patientId)){
                            hl7ReceiveLog.setPatientId(patientId);
                        }
                        hl7ReceiveLog.setHl7Data(aParsedHL7Message);
                        hl7ReceiveLogService.save(hl7ReceiveLog);

                        UpdateWrapper<HclabTestMaster> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("TEST_NO",testNo);
                        updateWrapper.set("RESULT_STATUS",status);
                        hclabTestMasterService.update(null,updateWrapper);
                    } catch (Exception e) {
                        OK = false;
                        errMsg = e.toString();
                        e.printStackTrace();
                    }

                    out = connection.getOutputStream();
                    StringBuffer testHL7MessageToTransmit = new StringBuffer();
                    //向客户端响应数据
                    testHL7MessageToTransmit.append(START_OF_BLOCK)
                            .append("MSH|^~\\&|"+SENDER+"||"+RECEIVER+"||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||ACK^O01|"+ msh_10 +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                            .append(CARRIAGE_RETURN);
                    if(OK){
                        testHL7MessageToTransmit.append("MSA|CA|"+msh_10);
                    }else{
                        testHL7MessageToTransmit.append("MSA|CE|"+msh10+"|"+errMsg);//.append("ERR||||E|"+errMsg+"|||");
                    }
                    testHL7MessageToTransmit.append(CARRIAGE_RETURN)
                            .append(END_OF_BLOCK)
                            .append(END_OF_BLOCK2);
                    out.write(testHL7MessageToTransmit.toString().getBytes("utf-8"));
                    out.close();
                    in.close();
                    connection.close();  // Close the socket.  We are done serving this client
                }
                else if("OUL^R21^OUL_R21".equals(msh_9)){//检验报告发布/撤销
                    try {

                        String obr = MessageParseUtil.getMessageValue(aParsedHL7Message, "OBR");
                        String labTestNo = MessageParseUtil.getValueByIndex(obr, 12);
                        String labDate = MessageParseUtil.getValueByIndex(obr, 23);//操作时间
                        String baoGaoDoctorStr = MessageParseUtil.getValueByIndex(obr, 35);
                        String shenHeDoctorStr = MessageParseUtil.getValueByIndex(obr, 36);

                        String baoGaoDoctor = "";
                        String shenHeDoctor = "";
                        if(StringUtils.isNotEmpty(baoGaoDoctorStr)){
                            if(baoGaoDoctorStr.contains("&")){
                                String[] baoGaoDoctorAry = baoGaoDoctorStr.split("&");
                                baoGaoDoctor = baoGaoDoctorAry[1];
                            }
                            if(baoGaoDoctorStr.contains("^")){
                                String[] baoGaoDoctorAry = baoGaoDoctorStr.split("\\^");
                                baoGaoDoctor = baoGaoDoctorAry[1];
                            }
                        }
                        if(StringUtils.isNotEmpty(baoGaoDoctorStr)){
                            if(shenHeDoctorStr.contains("&")){
                                String[] shenHeDoctorAry = shenHeDoctorStr.split("&");
                                shenHeDoctor = shenHeDoctorAry[1];
                            }
                            if(shenHeDoctorStr.contains("^")){
                                String[] shenHeDoctorAry = shenHeDoctorStr.split("\\^");
                                shenHeDoctor = shenHeDoctorAry[1];
                            }
                        }

                        hl7ReceiveLog.setDataType("接收");
                        hl7ReceiveLog.setInsertDate(new Date());
                        hl7ReceiveLog.setMethod("OUL^R21^OUL_R21 检验报告发布/撤销");
                        hl7ReceiveLog.setUuid(msh10);
                        hl7ReceiveLog.setApplyNo(labTestNo);
                        hl7ReceiveLog.setHl7Data(aParsedHL7Message);
                        hl7ReceiveLog.setPatientId(patientId);
                        hl7ReceiveLog.setCode(code);
                        hl7ReceiveLog.setType(type);
                        hl7ReceiveLog.setName(name);
                        hl7ReceiveLog.setDeptName(deptName);
                        hl7ReceiveLogService.save(hl7ReceiveLog);

                        String status = MessageParseUtil.getValueByIndex(obr, 26);
                        if(status!=null){
                            if(status.equals("F")){
                                status = "4";
                            }else{
                                status = "0";
                            }
                            if(status.equals("D")){
                                status = "0";
                            }
                        }

                        UpdateWrapper<HclabTestMaster> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("TEST_NO",labTestNo);
                        updateWrapper.set("RESULT_STATUS",status);
                        updateWrapper.set("TRANSCRIPTIONIST", baoGaoDoctor);
                        updateWrapper.set("VERIFIED_BY", shenHeDoctor);
                        updateWrapper.set("RESULTS_RPT_DATE_TIME",DateUtils.parseString(labDate,"yyyyMMddHHmmss"));
                        hclabTestMasterService.update(null,updateWrapper);

//                        List<String> obrList = MessageParseUtil.getOBRList(aParsedHL7Message);
//                        for(String obr : obrList){
//                            String itemNo = MessageParseUtil.getValueByIndex(obr, 1);
//                            String sample = MessageParseUtil.getValueByIndex(obr, 15);
//                            String[] samples = sample.split("^");
//                            String[] sampleCode = samples[0].split("&");
//                            String item = MessageParseUtil.getValueByIndex(obr, 4);
//                            String[] items = item.split("^");
//                            String advice = MessageParseUtil.getValueByIndex(obr, 19);
//                        }
                        QueryWrapper<HclabResult> hclabResultQueryWrapper = new QueryWrapper<>();
                        hclabResultQueryWrapper.eq("test_no", labTestNo);
                        hclabResultService.remove(hclabResultQueryWrapper);
                        List<String> obxList = MessageParseUtil.getOBXList(aParsedHL7Message);
                        //处理obxList里面的重复项目
                        List<String> obxListNew = new ArrayList<>();
                        for(String old : obxList){
                            boolean contains = false;
                            for(String nw : obxListNew){
                                if(old.equals(nw)){
                                    contains = true;
                                    continue;
                                }
                            }
                            if(!contains){
                                obxListNew.add(old);
                            }
                        }
                        for(String obx : obxListNew){
                            String itemNo = MessageParseUtil.getValueByIndex(obx, 2);
                            //项目名称^项目代码 obx3 项目编码^项目名称
                            String reportItem = MessageParseUtil.getValueByIndex(obx, 4);
                            String[] reportItems = reportItem.split("\\^");

                            String result = MessageParseUtil.getValueByIndex(obx, 6);
                            String[] results = result.split("\\^");
                            String units = MessageParseUtil.getValueByIndex(obx, 7);
                            //参考范围
                            String resultRange = MessageParseUtil.getValueByIndex(obx, 8);
                            //结果正常标志
                            String abnormalIndicator = MessageParseUtil.getValueByIndex(obx, 9);
                            String resultDateTime = MessageParseUtil.getValueByIndex(obx, 15);

                            HclabResult hclabResult = new HclabResult();
                            hclabResult.setTestNo(labTestNo);
                            hclabResult.setItemNo(Integer.parseInt(itemNo));
                            hclabResult.setPrintOrder(0);
                            hclabResult.setReportItemName(reportItems[1]);
                            hclabResult.setReportItemCode(reportItems[0]);
                            hclabResult.setResult(results[0]);
                            //特殊字符处理\S\转成^
                            if(StringUtils.isNotEmpty(units)){
                                units = CommonUtils.hl7ReplaceStr(units);
                            }
                            hclabResult.setUnits(units);
                            hclabResult.setAbnormalIndicator(abnormalIndicator);
                            hclabResult.setInstrumentId("");
                            if(StringUtils.isEmpty(resultDateTime)){
                                hclabResult.setResultDateTime(new Date());
                            }else{
                                hclabResult.setResultDateTime(DateUtils.parseString(resultDateTime,"yyyyMMddHHmmss"));
                            }
                            hclabResult.setPrintContext(resultRange);
                            //hclabResult.setResultRange(resultRange);
                            //----暂时搁置----hclabResult.setSampleCode(sampleCode[0]);
                            //--------hclabResult.setSpecimanId("");
                            //--------hclabResult.setItemCode(items[0]);
                            //--------hclabResult.setItemName(items[1]);
                            hclabResult.setCriticalValues("");
                            //hclabResult.setSureDateTime();
                            hclabResult.setSureNurse("");
                            //hclabResult.setSureDateTime1();
                            hclabResult.setSureDoctor("");
                            //--------hclabResult.setAdvice(advice);
                            hclabResult.setClinicref("");
//                            LambdaUpdateWrapper<HclabResult> hclabResultLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//                            hclabResultLambdaUpdateWrapper.eq(HclabResult::getTestNo, labTestNo);
//                            hclabResultLambdaUpdateWrapper.eq(HclabResult::getItemNo, Integer.parseInt(itemNo));
//                            hclabResultLambdaUpdateWrapper.set(HclabResult::getTestNo, labTestNo);
//                            hclabResultLambdaUpdateWrapper.set(HclabResult::getItemNo, Integer.parseInt(itemNo));
//                            hclabResultLambdaUpdateWrapper.set(HclabResult::getReportItemName, reportItems[1]);
//                            hclabResultLambdaUpdateWrapper.set(HclabResult::getReportItemCode, reportItems[0]);
//                            hclabResultLambdaUpdateWrapper.set(HclabResult::getResult, results[0]);
//                            hclabResultLambdaUpdateWrapper.set(HclabResult::getUnits, units);
//                            hclabResultLambdaUpdateWrapper.set(HclabResult::getAbnormalIndicator, abnormalIndicator);
//                            hclabResultLambdaUpdateWrapper.set(HclabResult::getResultDateTime, DateUtils.parseString(resultDateTime,"yyyyMMddHHmmss"));
//                            hclabResultLambdaUpdateWrapper.set(HclabResult::getResultRange, resultRange);

                            hclabResultService.save(hclabResult);
                        }
                    } catch (Exception e) {
                        OK = false;
                        errMsg = e.toString();
                        e.printStackTrace();
                    }
                    out = connection.getOutputStream();
                    StringBuffer testHL7MessageToTransmit = new StringBuffer();
                    //向客户端响应数据
                    testHL7MessageToTransmit.append(START_OF_BLOCK)
                            .append("MSH|^~\\&|"+SENDER+"||"+RECEIVER+"||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||ACK^O01|"+ msh_10 +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                            .append(CARRIAGE_RETURN);
                    if(OK){
                        testHL7MessageToTransmit.append("MSA|CA|"+msh_10);
                    }else{
                        testHL7MessageToTransmit.append("MSA|CE|"+msh10+"|"+errMsg);
//                                .append("ERR||||E|"+errMsg+"|||");
                    }
                    testHL7MessageToTransmit.append(CARRIAGE_RETURN)
                            .append(END_OF_BLOCK)
                            .append(END_OF_BLOCK2);
                    out.write(testHL7MessageToTransmit.toString().getBytes("utf-8"));
                    out.flush();
                    Hl7ReceiveLog hl7ReceiveLog1 = new Hl7ReceiveLog();
                    hl7ReceiveLog1.setDataType("返回");
                    hl7ReceiveLog1.setInsertDate(new Date());
                    hl7ReceiveLog1.setMethod("OUL^R21^OUL_R21 检验报告发布/撤销");
                    hl7ReceiveLog1.setUuid(msh10);
                    hl7ReceiveLog1.setApplyNo(hl7ReceiveLog.getApplyNo());
                    hl7ReceiveLog1.setHl7Data(testHL7MessageToTransmit.toString());
                    hl7ReceiveLogService.save(hl7ReceiveLog1);
                    out.close();
                    in.close();
                    connection.close();  // Close the socket.  We are done serving this client
                }
                else if("ORL^O01^ORL_O01".equals(msh_9)||"ORL^O21^ORL_O21".equals(msh_9)){//检查状态回传或病理状态回传

                    //检查状态回传 更新HcExamMaster的Status状态为4  报告时间reportDateTime 报告者reporter 插入HcExamReporter
                    try {
                        String orc = MessageParseUtil.getMessageValue(aParsedHL7Message, "ORC");
                        String examMasterNo = MessageParseUtil.getValueByIndex(orc, 3);//开单者申请单号
                        String[] examMasterNos = examMasterNo.split("\\^");
                        String examNo = examMasterNos[0];
                        String status = MessageParseUtil.getValueByIndex(orc, 6);//检查状态

                        hl7ReceiveLog.setDataType("接收");
                        hl7ReceiveLog.setInsertDate(new Date());
                        hl7ReceiveLog.setMethod("ORL^O01^ORL_O01 OUL^R21^OUL_R21 检查状态回传或病理状态回传");
                        hl7ReceiveLog.setUuid(msh10);
                        hl7ReceiveLog.setApplyNo(examNo);
                        hl7ReceiveLog.setPatientId(patientId);
                        hl7ReceiveLog.setHl7Data(aParsedHL7Message);
                        hl7ReceiveLogService.save(hl7ReceiveLog);
//                        20 检查预约
//                        7 取消预约
//                        25 检查签到
//                        30 检查登记 到检，在检查系统登记，准备做检查
//                        31 取消登记
//                        40 检查开始
//                        50 图像到达
//                        60 初步报告 不单独发送状态变更，只发送初步报告（文字
//                        报告之前发）
//                        70 审核发布 不单独发送状态变更，只发送审核报告
//                        80 取消报告
//                        switch (status){
//                            case "20":
//                                status = ""//"检查预约";
//                                break;
//                            case "7":
//                                status = "取消预约";
//                                break;
//                            case "25":
//                                status = "检查签到";
//                                break;
//                            case "30":
//                                status = "检查登记";
//                                break;
//                            case "31":
//                                status = "取消登记";
//                                break;
//                            case "40":
//                                status = "检查开始";
//                                break;
//                            case "50":
//                                status = "图像到达";
//                                break;
//                            case "60":
//                                status = "初步报告";
//                                break;
//                            case "70":
//                                status = "审核发布";
//                                break;
//                            case "80":
//                                status = "取消报告";
//                                break;
//                        }
                        UpdateWrapper<HcExamMaster> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("EXAM_NO",examNo);
//                        updateWrapper.set("RESULT_STATUS",status);
                        updateWrapper.set("RPTSTATUS",status);
//                        if(status.equals("4") ){
                            hcExamMasterService.update(null,updateWrapper);
//                        }
                    } catch (Exception e) {
                        OK = false;
                        errMsg = e.toString();
                        e.printStackTrace();
                    }

                    out = connection.getOutputStream();
                    StringBuffer testHL7MessageToTransmit = new StringBuffer();
                    //向客户端响应数据
                    testHL7MessageToTransmit.append(START_OF_BLOCK)
                            .append("MSH|^~\\&|"+SENDER+"||"+RECEIVER+"||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||ACK^O01|"+ msh_10 +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                            .append(CARRIAGE_RETURN);
                    if(OK){
                        testHL7MessageToTransmit.append("MSA|CA|"+msh_10);
                    }else{
                        testHL7MessageToTransmit.append("MSA|CE|"+msh10+"|"+errMsg);
                    }
                    testHL7MessageToTransmit.append(CARRIAGE_RETURN)
                            .append(END_OF_BLOCK)
                            .append(END_OF_BLOCK2);
                    out.write(testHL7MessageToTransmit.toString().getBytes("utf-8"));
                    out.flush();

                    Hl7ReceiveLog hl7ReceiveLog1 = new Hl7ReceiveLog();
                    hl7ReceiveLog1.setDataType("返回");
                    hl7ReceiveLog1.setInsertDate(new Date());
                    hl7ReceiveLog1.setMethod(hl7ReceiveLog.getMethod());
                    hl7ReceiveLog1.setUuid(msh10);
                    hl7ReceiveLog1.setApplyNo(hl7ReceiveLog.getApplyNo());
                    hl7ReceiveLog1.setHl7Data(testHL7MessageToTransmit.toString());
                    hl7ReceiveLog1.setPatientId(patientId);
                    hl7ReceiveLogService.save(hl7ReceiveLog1);

                    out.close();
                    in.close();
                    connection.close();  // Close the socket.  We are done serving this client
                }
                else if("ORU^R01^ORU_R01".equals(msh_9)){//检查报告发布/撤销或者病理报告发布/撤销

                    //回传检查报告 要更新 hc_exam_master的 result_status 状态为4， REPORT_DATE_TIME为报告时间，结果插入exam_report
                    try {
                        String msh_15 = MessageParseUtil.getValueByIndex(msh, 15);
                        if("NE".equals(msh_15)) {//消息类型NE发布，CE撤销
                            String orc = MessageParseUtil.getMessageValue(aParsedHL7Message, "ORC");
                            String examMasterNo = MessageParseUtil.getValueByIndex(orc, 3);//开单者申请单号
                            String[] examMasterNos = examMasterNo.split("\\^");
                            String examNo = examMasterNos[0];

                            hl7ReceiveLog.setDataType("接收");
                            hl7ReceiveLog.setInsertDate(new Date());
                            hl7ReceiveLog.setMethod("ORU^R01^ORU_R01 检查报告发布/撤销或者病理报告发布/撤销");
                            hl7ReceiveLog.setUuid(msh10);
                            hl7ReceiveLog.setApplyNo(examNo);
                            hl7ReceiveLog.setHl7Data(aParsedHL7Message);
                            hl7ReceiveLog.setPatientId(patientId);
                            hl7ReceiveLogService.save(hl7ReceiveLog);

                            //orc=>master obr=>items obx=>results
                            List<String> obrList = MessageParseUtil.getOBRList(aParsedHL7Message);
                            String obr = "";
                            String status = "";
                            String reportDate = "";
                            if(obrList.size()>0){
                                obr = obrList.get(0);
                                status = MessageParseUtil.getValueByIndex(obr, 26);//检查状态
                                if(status.equals("F")){
                                    status = "4";
                                }
                                reportDate = MessageParseUtil.getValueByIndex(obr, 23);//报告时间
                            }
                            String reporterStr = MessageParseUtil.getValueByIndex(obr, 35);//报告医生
                            String reporter = "";
                            if(StringUtils.isNotEmpty(reporterStr)){
                                if(reporterStr.contains("&")){
                                    String[] reporterAry = reporterStr.split("&");
                                    reporter = reporterAry[1];
                                }
                                if(reporterStr.contains("^")){
                                    String[] reporterAry = reporterStr.split("\\^");
                                    reporter = reporterAry[1];
                                }
                            }
                            String shenHeDoctorStr = MessageParseUtil.getValueByIndex(obr, 36);
                            String shenHeDoctor = ""; //审核医生
                            if(StringUtils.isNotEmpty(shenHeDoctorStr)){
                                if(shenHeDoctorStr.contains("&")){
                                    String[] shenHeDoctorAry = shenHeDoctorStr.split("&");
                                    shenHeDoctor = shenHeDoctorAry[1];
                                }
                                if(shenHeDoctorStr.contains("^")){
                                    String[] shenHeDoctorAry = shenHeDoctorStr.split("\\^");
                                    shenHeDoctor = shenHeDoctorAry[1];
                                }
                            }

                            Date reportDateDate = new Date();
//                            if(StringUtils.isEmpty(reportDate)){
//                                reportDate = MessageParseUtil.getValueByIndex(orc, 55);
//                            }
                            if(StringUtils.isNotEmpty(reportDate)){
                                reportDateDate = DateUtils.parseString(reportDate,"yyyyMMddHHmmss");
                            }
                            UpdateWrapper<HcExamMaster> updateWrapper = new UpdateWrapper<>();
                            updateWrapper.eq("EXAM_NO", examNo.trim());
                            updateWrapper.set("reporter", reporter);
                            updateWrapper.set("VERIFIER", shenHeDoctor);
                            updateWrapper.set("RESULT_STATUS", status);
                            updateWrapper.set("REPORT_DATE_TIME", reportDateDate);
                            hcExamMasterService.update(updateWrapper);
                            List<String> obxList = MessageParseUtil.getOBXList(aParsedHL7Message);
                            for (String obx : obxList) {
                                //检查方法/检查参数
                                String examPara = MessageParseUtil.getValueByIndex(obx, 18);
                                //检查所见^检查结果
                                String description = MessageParseUtil.getValueByIndex(obx, 6);
                                String[] descriptions = description.split("\\^");
                                //实际取的图文报告地址
                                String ieId = MessageParseUtil.getValueByIndex(obx, 8);
                                //异常标记
                                String isAbnormal = MessageParseUtil.getValueByIndex(obx, 9);
                                String doc = MessageParseUtil.getValueByIndex(obx, 17);
                                String[] docs = {"",""};
                                if(doc.contains("&")){
                                    if(doc.contains("~")){
                                        docs[0] = doc.split("~")[0].split("&")[1];
                                        docs[1] = doc.split("~")[1].split("&")[1];
                                    }else{
                                        docs = doc.split("&");
                                    }
                                }else if(doc.contains("^")){
                                    docs = doc.split("\\^");
                                }

                                HcExamReport hcExamReporter = new HcExamReport();
                                hcExamReporter.setExamNo(examNo);
                                hcExamReporter.setExamPara(examPara);
                                hcExamReporter.setDescription(CommonUtils.hl7ReplaceStr(descriptions[0]));
                                System.out.println(hcExamReporter.getDescription());
                                if(descriptions.length>1){
                                    hcExamReporter.setImpression(CommonUtils.hl7ReplaceStr(descriptions[1]));
                                }
                                System.out.println(hcExamReporter.getImpression());
                                hcExamReporter.setRecommendation("");
                                hcExamReporter.setIsAbnormal(isAbnormal);
                                hcExamReporter.setUseImage("");//报告中图象编号
                                hcExamReporter.setMemo("");
                                //hcExamReporter.setPrintFlag();
                                hcExamReporter.setIeId(ieId);//ie地址:此处写的和上一处一样
                                hcExamReporter.setInsertDate(new Date());
                                //----hcExamReporter.setReportDate(DateUtils.parseString("yyyy-MM-dd HH:mm:ss",reportDate));
                                hcExamReporter.setDiagnose(CommonUtils.hl7ReplaceStr(descriptions[0]));
                                hcExamReporter.setCriticalValues("");
                                hcExamReporter.setHisUnitCode("");
                                //----hcExamReporter.setReportDateTime(DateUtils.parseString("yyyy-MM-dd HH:mm:ss",reportDate));
                                hcExamReporter.setReportDateTimeBack("");
                                hcExamReporter.setReporter(docs[0]);
                                hcExamReporter.setYsName(docs[1]);
                                hcExamReportService.saveOrUpdate(hcExamReporter);
                                //查询hcExamReport是否有记录
//                                LambdaQueryWrapper<HcExamReport> hcExamReportLambdaQueryWrapper = new LambdaQueryWrapper<>();
//                                hcExamReportLambdaQueryWrapper.eq(HcExamReport::getExamNo, examNo);
//                                List<HcExamReport> hcExamReportList = hcExamReportService.list(hcExamReportLambdaQueryWrapper);
//                                if(hcExamReportList.size()>0){
//                                    hcExamReportService.saveOrUpdate(hcExamReporter);
//                                    //当报告多次回传时，说明有改动，查询hcPersonAppregItems中当前检查状态更改为未完成
//                                    LambdaUpdateWrapper<HcPersonAppregItems> hcPersonAppregItemsLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//                                    hcPersonAppregItemsLambdaUpdateWrapper.eq(HcPersonAppregItems::getApplyNo, examNo);
//                                    hcPersonAppregItemsLambdaUpdateWrapper.set(HcPersonAppregItems::getFinishedSign, "未完成");
//                                    hcPersonAppregItemsService.update(hcPersonAppregItemsLambdaUpdateWrapper);
//                                }else{
//                                    hcExamReportService.saveOrUpdate(hcExamReporter);
//                                }
                            }
                        }else if("CE".equals(msh_15)){
                            String orc = MessageParseUtil.getMessageValue(aParsedHL7Message, "ORC");
                            String examNo = MessageParseUtil.getValueByIndex(orc, 2);//开单者申请单号
                            String status = MessageParseUtil.getValueByIndex(orc, 5);//检查状态
                            UpdateWrapper<HcExamMaster> updateWrapper = new UpdateWrapper<>();
                            updateWrapper.eq("EXAM_NO",examNo);
                            updateWrapper.set("RESULT_STATUS",status);
                            hcExamMasterService.update(null,updateWrapper);
                        }
                    } catch (Exception e) {
                        OK = false;
                        errMsg = e.toString();
                        e.printStackTrace();
                    }
                    out = connection.getOutputStream();
                    StringBuffer testHL7MessageToTransmit = new StringBuffer();

//                    List<String> obrList = MessageParseUtil.getOBXList(aParsedHL7Message);
//                    for(String obr : obrList){
//                        String isitId = MessageParseUtil.getValueByIndex(pv1, 19);//就诊次数
//                    }

                    //向客户端响应数据
                    testHL7MessageToTransmit.append(START_OF_BLOCK)
                            .append("MSH|^~\\&|"+SENDER+"||"+RECEIVER+"||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||ACK^O01|"+ msh_10 +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                            .append(CARRIAGE_RETURN);
                    if(OK){
                        testHL7MessageToTransmit.append("MSA|CA|"+msh_10);
                    }else{
                        testHL7MessageToTransmit.append("MSA|CE|"+msh10+"|"+errMsg);
                    }
                    testHL7MessageToTransmit.append(CARRIAGE_RETURN)
                            .append(END_OF_BLOCK)
                            .append(END_OF_BLOCK2);
                    out.write(testHL7MessageToTransmit.toString().getBytes("utf-8"));
                    out.flush();
                    Hl7ReceiveLog hl7ReceiveLog1 = new Hl7ReceiveLog();
                    hl7ReceiveLog1.setDataType("返回");
                    hl7ReceiveLog1.setInsertDate(new Date());
                    hl7ReceiveLog1.setMethod(hl7ReceiveLog.getMethod());
                    hl7ReceiveLog1.setUuid(msh10);
                    hl7ReceiveLog1.setApplyNo(hl7ReceiveLog.getApplyNo());
                    hl7ReceiveLog1.setPatientId(patientId);
                    hl7ReceiveLog1.setHl7Data(testHL7MessageToTransmit.toString());
                    hl7ReceiveLogService.save(hl7ReceiveLog1);

                    out.close();
                    in.close();
                    connection.close();
                }else if("QBP^Z07^QBP_Q11".equals(msh_9)){//病理申请查询

                    PathologyApplyRspVo pathologyApplyRspVo = new PathologyApplyRspVo();
                    String messageName = "";
                    String queryTip = "";
                    String patientType = "";
                    //String patientId = "";
                    String visitId = "";
                    String qpd_3_4 = "";
                    String deptId = "";
                    //String deptName = "";
                    String startDate = "";
                    String endDate = "";
                    String applyNo = "";
                    String qpd = null;
                    HcPersonInfo hcPersonInfo = new HcPersonInfo();
                    try {
                        qpd = MessageParseUtil.getMessageValue(aParsedHL7Message, "QPD");
                        //查询消息名称
                        messageName = MessageParseUtil.getValueByIndex(qpd, 2);
                        //查询标记
                        queryTip =  MessageParseUtil.getValueByIndex(qpd, 3);
                        String qpd_3 = MessageParseUtil.getValueByIndex(qpd, 4);
                        String[] qpd_3_array = qpd_3.split("\\^");
                        patientType = qpd_3_array[0];
                        patientId = qpd_3_array[1].trim();

                        try{
                            visitId = qpd_3_array[2];
//                            qpd_3_4 = qpd_3_array[3];
//                            String[] qpd_3_4_array = null;
//                            if(StringUtils.isNotEmpty(qpd_3_4)){
//                                qpd_3_4_array = qpd_3_4.split("^");
//                                deptId = qpd_3_4_array[0];
//                                deptName = qpd_3_4_array[1];
//                            }
//                            startDate = qpd_3_array[4];
//                            endDate = qpd_3_array[5];
//                            applyNo = qpd_3_array[6];
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        if(StringUtils.isEmpty(patientId)){
                            errMsg = "患者 ID 不能为空";
                        }

                        hl7ReceiveLog.setDataType("接收");
                        hl7ReceiveLog.setInsertDate(new Date());
                        hl7ReceiveLog.setMethod("QBP^Z07^QBP_Q11 病理申请查询");
                        hl7ReceiveLog.setUuid(msh10);
                        hl7ReceiveLog.setPatientId(patientId);
                        hl7ReceiveLog.setHl7Data(aParsedHL7Message);
                        hl7ReceiveLogService.save(hl7ReceiveLog);

                        //根据patientId查询患者信息
//                        //查询HcPersonVisitInfo表
//                        LambdaQueryWrapper<HcPersonVisitInfo> hcPersonVisitInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
//                        hcPersonVisitInfoLambdaQueryWrapper.eq(HcPersonVisitInfo::getPatientId, patientId);
//                        hcPersonVisitInfoLambdaQueryWrapper.eq(HcPersonVisitInfo::getPersonVisitId, visitId);
//                        HcPersonVisitInfo hcPersonVisitInfo = hcPersonVisitInfoService.getOne(hcPersonVisitInfoLambdaQueryWrapper);
                        //查询HcPersonInfo表
                        LambdaQueryWrapper<HcPersonInfo> hcPersonInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
                        hcPersonInfoLambdaQueryWrapper.eq(HcPersonInfo::getPatientId, patientId);
                        hcPersonInfo = hcPersonInfoService.getOne(hcPersonInfoLambdaQueryWrapper);
                        //如果visitId为null，查询最大visitId
                        if(StringUtils.isEmpty(visitId)){
                            Integer personVisitId = personInfoMapper.findMaxVisitId(patientId);
                            if(personVisitId != null){
                                visitId = personVisitId.toString();
                            }
                        }

                    } catch (Exception e) {
                        OK = false;
                        errMsg = e.toString();
                        e.printStackTrace();
                    }
                    List<HcExamMaster> hcExamMasterList = new ArrayList<>();
                    if(StringUtils.isEmpty(visitId)){
                        OK = false;
                        errMsg = "没有查询到体检人"+patientId;
                    }else{
                        //根据条件查询病理申请
                        LambdaQueryWrapper<HcExamMaster> hcExamMasterLambdaQueryWrapper = new LambdaQueryWrapper<>();
                        hcExamMasterLambdaQueryWrapper.eq(HcExamMaster::getPatientId, hcPersonInfo.getPersonId());
                        //因为病理没有体检次数概念，所以去掉visit_id条件
                        //hcExamMasterLambdaQueryWrapper.eq(HcExamMaster::getVisitId, visitId);
                        hcExamMasterLambdaQueryWrapper.and(hcExamMasterWrapper -> hcExamMasterWrapper
                                .eq(HcExamMaster::getRptstatus, "25").or().eq(HcExamMaster::getRptstatus, "40")
                                .or().eq(HcExamMaster::getRptstatus, "31"));
                        hcExamMasterLambdaQueryWrapper.eq(HcExamMaster::getExamClass, "病理");
                        hcExamMasterList = hcExamMasterService.list(hcExamMasterLambdaQueryWrapper);
                        //对hcExamMasterList进行过滤，找到病理申请
                        hcExamMasterList = hcExamMasterList.stream().filter(hcExamMaster -> hcExamMaster.getPerformedBy().contains("病理")).collect(Collectors.toList());

                    }
                    if(hcExamMasterList.size()<1){
                        OK = false;
                        errMsg = "没有查询到申请！";
                    }

                    out = connection.getOutputStream();
                    StringBuffer testHL7MessageToTransmit = new StringBuffer();
                    //向客户端响应数据
                    testHL7MessageToTransmit.append(START_OF_BLOCK)
                            .append("MSH|^~\\&|"+SENDER+"||"+RECEIVER+"||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||RSP^Z06^RSP_Z06|"+ msh_10 +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                            .append(CARRIAGE_RETURN);
                    if(OK){
                        testHL7MessageToTransmit.append("MSA|AA|"+msh_10);

                        //查询标记
                        pathologyApplyRspVo.setQAK_1(queryTip);
                        //匹配的记录总数
                        pathologyApplyRspVo.setQAK_4(hcExamMasterList.size()+"");
                        //本次回应中的记录数
                        pathologyApplyRspVo.setQAK_5(hcExamMasterList.size()+"");
                        //剩余记录总数
                        pathologyApplyRspVo.setQAK_6("0");

                        //查询消息名称
                        pathologyApplyRspVo.setQPD_1(messageName);
                        //查询标记
                        pathologyApplyRspVo.setQPD_2(queryTip);
                        //患者类别
                        pathologyApplyRspVo.setQPD_3_1(patientType);
                        //患者 ID
                        pathologyApplyRspVo.setQPD_3_2(patientId);
                        //就诊次数
                        pathologyApplyRspVo.setQPD_3_3(visitId);
                        //执行科室
                        pathologyApplyRspVo.setQPD_3_4(qpd_3_4);
                        //申请时间开始时间
                        pathologyApplyRspVo.setQPD_3_5(startDate);
                        //申请时间结束时间
                        pathologyApplyRspVo.setQPD_3_6(endDate);
                        //申请单号
                        pathologyApplyRspVo.setQPD_3_7(applyNo);

                        pathologyApplyRspVo.setPID_2(patientId);

                        pathologyApplyRspVo.setPID_5(hcPersonInfo.getName()+"^^^"+CommonUtils.getPYFull(hcPersonInfo.getName()));
                        pathologyApplyRspVo.setPID_7(DateUtils.getDateYYYYMMDDHHMMSS(hcPersonInfo.getBarthday()));
                        switch (hcPersonInfo.getSex()){
                            case "女":
                                pathologyApplyRspVo.setPID_8(PropertiesUtils.FEMALE);
                                break;
                            case "男":
                                pathologyApplyRspVo.setPID_8(PropertiesUtils.MALE);
                                break;
                            default:
                                pathologyApplyRspVo.setPID_8(PropertiesUtils.OTHER_SEX);
                        }
                        pathologyApplyRspVo.setPID_13_1(hcPersonInfo.getMobile());
                        pathologyApplyRspVo.setPID_16(hcPersonInfo.getMaritalStatus());
                        pathologyApplyRspVo.setPID_19(hcPersonInfo.getIdNo());
                        pathologyApplyRspVo.setPID_22(hcPersonInfo.getNation());
                        List<PathologyApplyRspVo.ITEM> itemList = new ArrayList<>();
                        for(HcExamMaster hcExamMaster : hcExamMasterList){
                            PathologyApplyRspVo.ITEM item = pathologyApplyRspVo.new ITEM();
                            item.setPV1_2(patientType);
                            item.setPV1_3_1(PropertiesUtils.DEPT_ID);
                            //就诊医生
                            item.setPV1_7(hcExamMaster.getReqPhysician());
                            item.setPV1_19(visitId);
                            item.setPV1_39(PropertiesUtils.AREACODE);
                            //就诊时间
                            item.setPV1_44(DateUtils.getDateYYYYMMDDHHMMSS(hcExamMaster.getExamDateTime()));

                            item.setORC_1("NW");
                            item.setORC_2(hcExamMaster.getExamNo()+"^^"+hcExamMaster.getExamNo());
                            item.setORC_9(DateUtils.getDateYYYYMMDDHHMMSS(hcExamMaster.getReqDateTime()));
                            item.setORC_12(hcExamMaster.getReqPhysician()+"^"+hcExamMaster.getReqPhysician());
                            item.setORC_21(PropertiesUtils.DEPT_NAME+"^"+PropertiesUtils.DEPT_ID);
                            item.setORC_29("O");
                            item.setORC_32(hcExamMaster.getPerformedBy()+"^"+PropertiesUtils.BLCODE);

                            //查询明细
                            LambdaQueryWrapper<HcExamItems> hcExamItemsLambdaQueryWrapper = new LambdaQueryWrapper<>();
                            hcExamItemsLambdaQueryWrapper.eq(HcExamItems::getExamNo, hcExamMaster.getExamNo());
                            HcExamItems hcExamItems = hcExamItemsService.getOne(hcExamItemsLambdaQueryWrapper);

                            //根据itemc_code查询组合与诊疗项目对照
                            LambdaQueryWrapper<HcPackVsClinic>  hcPackVsClinicServiceLambdaQueryWrapper= new LambdaQueryWrapper<>();
                            hcPackVsClinicServiceLambdaQueryWrapper.eq(HcPackVsClinic::getItemCode, hcExamItems.getExamItemCode());
                            HcPackVsClinic hcPackVsClinic = hcPackVsClinicService.getOne(hcPackVsClinicServiceLambdaQueryWrapper);

                            item.setOBR_1("1");
                            item.setOBR_4(hcPackVsClinic.getItemCode()+"^"+hcPackVsClinic.getItemName());
                            item.setOBR_5("0");

                            item.setDG1_1("1");
                            //临床诊断 Z00.001^健康查体
                            item.setDG1_3("健康查体^Z00.001");
                            //诊断类型 默认值 A
                            item.setDG1_6("A");

                            item.setSPM_1("1");
                            item.setSPM_2_1(hcExamMaster.getExamNo());
                            item.setSPM_4("todo");
                            item.setSPM_5("");
                            item.setSPM_6_1(DateUtils.getDateYYYYMMDDHHMMSS());
                            item.setSPM_6_2(DateUtils.getDateYYYYMMDDHHMMSS(hcExamMaster.getReqDateTime()));
                            item.setSPM_7_1(PropertiesUtils.DEPT_ID);
                            item.setSPM_7_2(PropertiesUtils.DEPT_NAME);
                            //根据item_pack_code查询组合项目信息获取标本名称
                            LambdaQueryWrapper<HcItemPackDict> hcItemPackDictLambdaQueryWrapper = new LambdaQueryWrapper<>();
                            hcItemPackDictLambdaQueryWrapper.eq(HcItemPackDict::getItemPackCode, hcPackVsClinic.getItemPackCode());
                            HcItemPackDict hcItemPackDict = hcItemPackDictService.getOne(hcItemPackDictLambdaQueryWrapper);
                            item.setSPM_14(hcItemPackDict.getSpecimanName());

                            pathologyApplyRspVo.setSAC_3("");//病理是否有试管需要确认
                            itemList.add(item);
                        }
                        pathologyApplyRspVo.setItemList(itemList);

                        testHL7MessageToTransmit.append(CARRIAGE_RETURN)
                                .append(pathologyApplyRspVo)
                                .append(END_OF_BLOCK)
                                .append(CARRIAGE_RETURN);
                        out.write(testHL7MessageToTransmit.toString().getBytes("utf-8"));
                    }else{
                        testHL7MessageToTransmit
                                .append("MSA|CE|"+msh10+"|"+errMsg)
                                .append(CARRIAGE_RETURN)
                                .append(END_OF_BLOCK)
                                .append(END_OF_BLOCK2);
                        out.write(testHL7MessageToTransmit.toString().getBytes("utf-8"));
                    }
                    out.flush();

                    Hl7ReceiveLog hl7ReceiveLog1 = new Hl7ReceiveLog();
                    hl7ReceiveLog1.setDataType("返回");
                    hl7ReceiveLog1.setInsertDate(new Date());
                    hl7ReceiveLog1.setMethod(hl7ReceiveLog.getMethod());
                    hl7ReceiveLog1.setUuid(msh10);
                    hl7ReceiveLog1.setHl7Data(testHL7MessageToTransmit.toString());
                    if(StringUtils.isNotEmpty(patientId)){
                        hl7ReceiveLog1.setPatientId(patientId);
                    }
                    hl7ReceiveLogService.save(hl7ReceiveLog1);

                    out.close();
                    in.close();
                    connection.close();  // Close the socket.  We are done serving this client
                    System.out.println("业务处理完毕，关闭连接："+DateUtils.praseDate(new Date(),"yyyyMMdd HH:mm:ss")+"-"+connection.toString());

                }else{
                    hl7ReceiveLog.setDataType("接收");
                    hl7ReceiveLog.setInsertDate(new Date());
                    hl7ReceiveLog.setMethod(msh_9);
                    hl7ReceiveLog.setUuid(msh10);
                    hl7ReceiveLog.setApplyNo("");
                    hl7ReceiveLog.setHl7Data(aParsedHL7Message);
                    //hl7ReceiveLogService.save(hl7ReceiveLog);

                    out = connection.getOutputStream();
                    StringBuffer testHL7MessageToTransmit = new StringBuffer();
                    errMsg = "没有找到相关服务"+msh_9;
                    //向客户端响应数据
                    testHL7MessageToTransmit.append(START_OF_BLOCK)
                            .append("MSH|^~\\&|"+SENDER+"||"+RECEIVER+"||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||ACK^O01|"+ msh10 +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                            .append(CARRIAGE_RETURN)
                            .append("MSA|CE|"+msh10+"|"+errMsg)
                            .append(CARRIAGE_RETURN)
                            .append(END_OF_BLOCK)
                            .append(END_OF_BLOCK2);
                    out.write(testHL7MessageToTransmit.toString().getBytes("utf-8"));
                    Hl7ReceiveLog hl7ReceiveLog1 = new Hl7ReceiveLog();
                    hl7ReceiveLog1.setDataType("返回");
                    hl7ReceiveLog1.setInsertDate(new Date());
                    hl7ReceiveLog1.setMethod(hl7ReceiveLog.getMethod());
                    hl7ReceiveLog1.setUuid(msh10);
                    hl7ReceiveLog1.setHl7Data(testHL7MessageToTransmit.toString());
                    //hl7ReceiveLogService.save(hl7ReceiveLog1);
                    out.close();
                    in.close();
                    connection.close();  // Close the socket.  We are done serving this client
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error handling a client: " + e);
                //log.error("接收平台信息出错："+e.getMessage());
                try {
                    out = connection.getOutputStream();
                    StringBuffer testHL7MessageToTransmit = new StringBuffer();
                    String errMsg = e.getMessage();
                    //向客户端响应数据
                    testHL7MessageToTransmit.append(START_OF_BLOCK)
                            .append("MSH|^~\\&|"+SENDER+"||"+RECEIVER+"||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||ACK^O01|"+ msh10 +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                            .append(CARRIAGE_RETURN)
                            .append("MSA|CE|"+msh10+"|"+errMsg)
                            .append(CARRIAGE_RETURN)
                            .append(END_OF_BLOCK)
                            .append(END_OF_BLOCK2);

                    Hl7ReceiveLog hl7ReceiveLog1 = new Hl7ReceiveLog();
                    hl7ReceiveLog1.setDataType("返回");
                    hl7ReceiveLog1.setInsertDate(new Date());
                    hl7ReceiveLog1.setMethod(hl7ReceiveLog.getMethod());
                    hl7ReceiveLog1.setUuid(msh10);
                    hl7ReceiveLog1.setHl7Data(testHL7MessageToTransmit.toString());
                    //hl7ReceiveLogService.save(hl7ReceiveLog1);

                    out.write(testHL7MessageToTransmit.toString().getBytes("utf-8"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            } finally {
                try {
                    if(out!=null){
                        out.close();
                    }
                    if(in != null){
                        in.close();
                    }
                    if(connection!=null){
                        connection.close();
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
