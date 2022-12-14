package com.healt.cloud.checkup.service.tcp.client;

import com.healt.cloud.checkup.service.tcp.message.MessageParseUtil;
import com.healt.cloud.checkup.service.tcp.vo.lab.LabReportQueryRspVo;
import com.healt.cloud.checkup.service.tcp.vo.lab.LabReportQueryVo;
import com.healt.cloud.checkup.service.tcp.vo.lab.OBX;
import com.healt.cloud.common.utils.CommonUtils;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.PropertiesUtils;
import com.healt.cloud.resultex.exception.CommonException;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author linklee
 * @create 2022-07-19 15:55
 */
@Service
public class LabReportQueryMLLPTCPClient {

    private static final char END_OF_BLOCK = '\u001c';
    private static final char START_OF_BLOCK = '\u000b';
    private static final char CARRIAGE_RETURN = 13;

    public LabReportQueryRspVo sendLabReportQuery(LabReportQueryVo labReportQueryVo){
        try{
            //创建socket对象
            Socket socket = new Socket(PropertiesUtils.SOCKETIP,  PropertiesUtils.SOCKETPORT);
            System.out.println("Connected to Server");

            StringBuffer testHL7MessageToTransmit = new StringBuffer();
            testHL7MessageToTransmit.append(START_OF_BLOCK)
                    //MSH|^~\&|UMC||LIS||20220105101052||QBP^Z08^QBP^Q11|a8f662b8-6e7a|P|2.6^^&&&&D56D2C42401AAC6F36&&V1.0|||NE|AL||utf-8
                    .append("MSH|^~\\&|HIS||ESB||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||QBP^Z08^QBP^Q11|"+ CommonUtils.getUUID() +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                    .append(CARRIAGE_RETURN)
                    .append(labReportQueryVo.toString())
                    .append(CARRIAGE_RETURN)
                    .append(END_OF_BLOCK)
                    .append(CARRIAGE_RETURN);

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            // Send the MLLP-wrapped HL7 message to the server
            out.write(testHL7MessageToTransmit.toString().getBytes("utf-8"));

            //接收服务端返回数据
            String aParsedHL7Message = MessageParseUtil.getMessage(in);
            String msa = MessageParseUtil.getMessageValue(aParsedHL7Message, "MSA");
            String[] resultArray = msa.split("\\|");
            String success = resultArray[1];
            //System.out.println(resultArray[1]);
            if("CE".equals(success)){
                String err = MessageParseUtil.getMessageValue(aParsedHL7Message, "ERR");
                String[] errArray = err.split("\\|");
                throw new CommonException(500, errArray[3]);
            }

            LabReportQueryRspVo labReportQueryRspVo = new LabReportQueryRspVo();
            String qpd = MessageParseUtil.getMessageValue(aParsedHL7Message, "QPD");
            String[] resultArrayQPD = qpd.split("\\|");
            labReportQueryRspVo.setQPD_1(resultArrayQPD[1]);
            labReportQueryRspVo.setQPD_2(resultArrayQPD[2]);
            String[] qpd3 = resultArrayQPD[3].split("^");
            labReportQueryRspVo.setQPD_3_1(qpd3[0]);
            labReportQueryRspVo.setQPD_3_2(qpd3[1]);
            labReportQueryRspVo.setQPD_3_3(qpd3[2]);
            labReportQueryRspVo.setQPD_3_4(qpd3[3]);
            labReportQueryRspVo.setQPD_3_5(qpd3[4]);
            String pid = MessageParseUtil.getMessageValue(aParsedHL7Message, "PID");
            String[] resultArrayPID = pid.split("\\|");
            labReportQueryRspVo.setPID_2(resultArrayPID[2]);
            labReportQueryRspVo.setPID_5(resultArrayPID[5]);
            labReportQueryRspVo.setPID_7(resultArrayPID[7]);
            labReportQueryRspVo.setPID_8(resultArrayPID[8]);
            String pv1 = MessageParseUtil.getMessageValue(aParsedHL7Message, "PV1");
            String[] resultArrayPV1 = pv1.split("\\|");
            labReportQueryRspVo.setPV1_2(resultArrayPV1[2]);
            String[] pv13 = resultArrayPV1[3].split("^");
            labReportQueryRspVo.setPV1_3_1(pv13[0]);
            labReportQueryRspVo.setPV1_7(resultArrayPV1[7]);
            labReportQueryRspVo.setPV1_19(resultArrayPV1[19]);
            labReportQueryRspVo.setPV1_39(resultArrayPV1[39]);
            labReportQueryRspVo.setPV1_44(resultArrayPV1[44]);
            String orc = MessageParseUtil.getMessageValue(aParsedHL7Message, "ORC");
            String[] resultArrayORC = orc.split("\\|");
            labReportQueryRspVo.setORC_1(resultArrayORC[1]);
            labReportQueryRspVo.setORC_2(resultArrayORC[2]);
            labReportQueryRspVo.setORC_16(resultArrayORC[16]);
            labReportQueryRspVo.setORC_29(resultArrayORC[29]);
            labReportQueryRspVo.setORC_32(resultArrayORC[32]);
            String obr = MessageParseUtil.getMessageValue(aParsedHL7Message, "OBR");
            String[] resultArrayOBR = obr.split("\\|");
            labReportQueryRspVo.setOBR_1(resultArrayOBR[1]);
            labReportQueryRspVo.setOBR_3(resultArrayOBR[3]);
            labReportQueryRspVo.setOBR_4(resultArrayOBR[4]);
            labReportQueryRspVo.setOBR_7(resultArrayOBR[7]);
            labReportQueryRspVo.setOBR_11(resultArrayOBR[11]);
            labReportQueryRspVo.setOBR_14(resultArrayOBR[14]);
            labReportQueryRspVo.setOBR_15_1(resultArrayOBR[15]);
            labReportQueryRspVo.setOBR_22(resultArrayOBR[22]);
            labReportQueryRspVo.setOBR_24(resultArrayOBR[24]);
            labReportQueryRspVo.setOBR_25(resultArrayOBR[25]);
            labReportQueryRspVo.setOBR_34_1(resultArrayOBR[34]);
            labReportQueryRspVo.setOBR_35_1(resultArrayOBR[35]);
            String[] obr47 = resultArrayOBR[47].split("^");
            labReportQueryRspVo.setOBR_47_2(obr47[1]);
            labReportQueryRspVo.setOBR_50(resultArrayPV1[50]);
            List<String> obxStrList = MessageParseUtil.getOBXList(aParsedHL7Message);
            List<OBX> obxList = new ArrayList<>();
            for (int i = 0; i < obxStrList.size(); i++) {
                String obxi = obxStrList.get(i);
                String[] resultArrayOBXI = obxi.split("\\|");
                OBX obx = new OBX();
                obx.setOBX_1(resultArrayOBXI[1]);
                obx.setOBX_2(resultArrayOBXI[2]);
                String[] obxi5 = resultArrayOBXI[5].split("^");
                obx.setOBX_5_1(obxi5[0]);
                obx.setOBX_5_2(obxi5[1]);
                obx.setOBX_7(resultArrayOBXI[7]);
                obx.setOBX_14(resultArrayOBXI[14]);
                obx.setOBX_17(resultArrayOBXI[17]);
                obxList.add(obx);
            }
            labReportQueryRspVo.setObxList(obxList);

            // 关闭socket
            socket.close();
            return labReportQueryRspVo;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new LabReportQueryRspVo();
    }
}
