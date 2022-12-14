package com.healt.cloud.checkup.service.tcp.client;

import com.healt.cloud.checkup.entity.Hl7Log;
import com.healt.cloud.checkup.service.Hl7LogService;
import com.healt.cloud.checkup.service.tcp.message.MessageParseUtil;
import com.healt.cloud.checkup.service.tcp.vo.lab.LabApplyVo;
import com.healt.cloud.common.utils.CommonUtils;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.PropertiesUtils;
import com.healt.cloud.resultex.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-07-18 14:30
 */
public class LabApplyMLLPTCPClient {

    private static final char END_OF_BLOCK = '\u001c';
    private static final char START_OF_BLOCK = '\u000b';
    private static final char CARRIAGE_RETURN = 13;
    private static String SENDER = "PHYS";
    private static String RECEIVER = "HIS";

    Socket socket = null;
    InputStream in = null;
    OutputStream out = null;

    private Hl7LogService hl7LogService;

    public LabApplyMLLPTCPClient(Hl7LogService hl7LogService){
        this.hl7LogService = hl7LogService;
    }
    public LabApplyMLLPTCPClient(){}

    public boolean sendLabApply(LabApplyVo labApplyVo){

        try{
            //创建socket对象
            socket = new Socket(PropertiesUtils.SOCKETIP,  PropertiesUtils.SOCKETPORT);
            System.out.println("Connected to Server");

            StringBuffer testHL7MessageToTransmit = new StringBuffer();

//            testHL7MessageToTransmit.append(START_OF_BLOCK)
//                    //MSH|^~\&|UMC||LIS||20220105101052||OML^O21^OML^O23|a8f662b8-6e7a|P|2.6^^&&&&D56D2C42401AAC6F36&&V1.0|||NE|AL||utf-8
//                    .append("MSH|^~\\&|HIS||ESB||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||OML^O21^OML^O23|"+ CommonUtils.getUUID() +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
//                    .append(CARRIAGE_RETURN)
//                    //PID||201532012|652101198612221332^^^^01||马志明^^^MA ZHI MING||19861222000000|1|||&华容文化路 179 号^华容^岳阳^湖南|||||^^2|||652101198612221332|||^汉族^1
//                    .append("PID||"+ labApplyVo.getPID_2() +"|||"+ labApplyVo.getPID_5() +"||"+ labApplyVo.getPID_7() +"|"+ labApplyVo.getPID_8() +"||||||||||||||")
//                    .append(CARRIAGE_RETURN)
//                    //PV1||1|1007^^^||||0831||||||0||||||1||||||||||||||||||||H0002|||||20220105100100||||||
//                    .append("PV1||"+ labApplyVo.getPV1_2() +"|"+ labApplyVo.getPV1_3_1() +"^^^||||"+ labApplyVo.getPV1_7() +"||||||||||||"+ labApplyVo.getPV1_19() +"||||||||||||||||||||"+ labApplyVo.getPV1_39() +"|||||"+ labApplyVo.getPV1_44() +"||||||")
//                    .append(CARRIAGE_RETURN)
//                    //ORC|NW|02C2123141^^100834|||2|1|107||20220105100732|||101275^汤鑫|||||||||肝胆内科^^1007||||||||C|||检验科^^1218
//                    .append("ORC|"+ labApplyVo.getORC_1() +"|"+ labApplyVo.getORC_2() +"|||||||"+ labApplyVo.getORC_9() +"|||"+ labApplyVo.getORC_12() +"|||||||||"+ labApplyVo.getORC_21() +"||||||||"+ labApplyVo.getORC_29() +"|||"+ labApplyVo.getORC_32())
//                    .append(CARRIAGE_RETURN)
//                    //OBR|1|||JY011^肝功能全套|1||||||||临床信息||1&血||||180.00||||||||||||检验目的|||||||||||||||||||
//                    .append("OBR|"+ labApplyVo.getOBR_1() +"|||"+ labApplyVo.getOBR_4() +"|"+ labApplyVo.getOBR_5() +"||||||||||"+ labApplyVo.getOBR_15_1() +"||||"+ labApplyVo.getOBR_19() +"|||||||||||||||||||||||||||||||")
//                    .append(CARRIAGE_RETURN)
//                    //DG1|1||K72.905^肝功能不全|||A
//                    .append("DG1|"+ labApplyVo.getDG1_1() +"||"+ labApplyVo.getDG1_3() +"|||"+ labApplyVo.getDG1_6())
//                    .append(CARRIAGE_RETURN)
//                    .append(END_OF_BLOCK)
//                    .append(CARRIAGE_RETURN);
            testHL7MessageToTransmit.append(START_OF_BLOCK)
                    //MSH|^~\&|UMC||LIS||20220105101052||OML^O21^OML^O23|a8f662b8-6e7a|P|2.6^^&&&&D56D2C42401AAC6F36&&V1.0|||NE|AL||utf-8
                    .append("MSH|^~\\&|"+SENDER+"||"+RECEIVER+"||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||OML^O21^OML_O23|"+ CommonUtils.getUUID() +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                    .append(CARRIAGE_RETURN)
                    .append(labApplyVo.toString())
                    .append(END_OF_BLOCK)
                    .append(CARRIAGE_RETURN);

            in = socket.getInputStream();
            out = socket.getOutputStream();


            Hl7Log paramIn = new Hl7Log();
            paramIn.setDataStr(testHL7MessageToTransmit.toString());
            paramIn.setDataType("入参");
            paramIn.setMethod("ExamApplyMLLPTCPClient.sendLabApply");
            paramIn.setUuid(CommonUtils.getUUID());
            paramIn.setInsertDate(new Date());
            hl7LogService.save(paramIn);

            // Send the MLLP-wrapped HL7 message to the server
            out.write(testHL7MessageToTransmit.toString().getBytes("utf-8"));
            out.flush();
            //接收服务端返回数据,因为有延迟，getMessage方法做了等待处理
            String aParsedHL7Message = aParsedHL7Message = MessageParseUtil.getMessage(in);
            System.out.println(aParsedHL7Message);
            //String aParsedHL7Message = MessageParseUtil.getMessage(in);
            if(aParsedHL7Message==null){
                return false;
            }
            String msa = MessageParseUtil.getMessageValue(aParsedHL7Message, "MSA");
            String[] resultArray = msa.split("\\|");
            String success = resultArray[1];

            Hl7Log paramOut = new Hl7Log();
            paramOut.setDataStr(aParsedHL7Message);
            paramOut.setDataType("出参");
            paramOut.setMethod("LabApplyMLLPTCPClient.sendLabApply");
            paramOut.setUuid(paramIn.getUuid());
            paramOut.setInsertDate(new Date());
            hl7LogService.save(paramOut);

            //System.out.println(resultArray[1]);
            if("CE".equals(success)){
//                String err = MessageParseUtil.getMessageValue(aParsedHL7Message, "ERR");
//                String[] errArray = err.split("\\|");
//                throw new CommonException(500, errArray[3]);
                return false;
            }

            // 关闭socket
            //socket.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            try {
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
                if (socket !=null)
                    socket.close();
                socket = null;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
