package com.healt.cloud.checkup.service.tcp.client;

import com.healt.cloud.checkup.service.tcp.message.MessageParseUtil;
import com.healt.cloud.checkup.service.tcp.vo.lab.LabQueryRspVo;
import com.healt.cloud.checkup.service.tcp.vo.lab.LabQueryVo;
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
 * @create 2022-07-18 14:31
 */
@Service
public class LabQueryMLLPTCPClient {

    private static final char END_OF_BLOCK = '\u001c';
    private static final char START_OF_BLOCK = '\u000b';
    private static final char CARRIAGE_RETURN = 13;

    public LabQueryRspVo sendLabQuery(LabQueryVo labQueryVo){
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;
        try{
            //创建socket对象
            socket = new Socket(PropertiesUtils.SOCKETIP,  PropertiesUtils.SOCKETPORT);
            System.out.println("Connected to Server");

            StringBuffer testHL7MessageToTransmit = new StringBuffer();

            testHL7MessageToTransmit.append(START_OF_BLOCK)
                    //MSH|^~\&|UMC||LIS||20220105101052||QBP^Z06^QBP^Q11|a8f662b8-6e7a|P|2.6^^&&&&D56D2C42401AAC6F36&&V1.0|||NE|AL||utf-8
                    .append("MSH|^~\\&|HIS||ESB||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||QBP^Z06^QBP^Q11|"+ CommonUtils.getUUID() +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                    .append(CARRIAGE_RETURN)
                    .append(labQueryVo.toString())
                    .append(END_OF_BLOCK)
                    .append(CARRIAGE_RETURN);

            in = socket.getInputStream();
            out = socket.getOutputStream();

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

            LabQueryRspVo labQueryRspVo = new LabQueryRspVo();
            String qpd = MessageParseUtil.getMessageValue(aParsedHL7Message, "QPD");
            String[] resultArrayQPD = qpd.split("\\|");
            labQueryRspVo.setQPD_1(resultArrayQPD[1]);
            labQueryRspVo.setQPD_2(resultArrayQPD[2]);
            String[] qpd3 = resultArrayQPD[3].split("^");
            labQueryRspVo.setQPD_3_1(qpd3[0]);
            labQueryRspVo.setQPD_3_2(qpd3[1]);
            labQueryRspVo.setQPD_3_3(qpd3[2]);
            labQueryRspVo.setQPD_3_4(qpd3[3]);
            labQueryRspVo.setQPD_3_5(qpd3[4]);
            labQueryRspVo.setQPD_3_6(qpd3[5]);
            String pid = MessageParseUtil.getMessageValue(aParsedHL7Message, "PID");
            String[] resultArrayPID = pid.split("\\|");
            labQueryRspVo.setPID_2(resultArrayPID[2]);
            labQueryRspVo.setPID_5(resultArrayPID[5]);
            labQueryRspVo.setPID_7(resultArrayPID[7]);
            labQueryRspVo.setPID_8(resultArrayPID[8]);
            String pv1 = MessageParseUtil.getMessageValue(aParsedHL7Message, "PV1");
            String[] resultArrayPV1 = pv1.split("\\|");
            labQueryRspVo.setPV1_2(resultArrayPV1[2]);
            String[] pv13 = resultArrayPV1[3].split("^");
            labQueryRspVo.setPV1_3_1(pv13[0]);
            labQueryRspVo.setPV1_7(resultArrayPV1[7]);
            labQueryRspVo.setPV1_19(resultArrayPV1[19]);
            labQueryRspVo.setPV1_39(resultArrayPV1[39]);
            labQueryRspVo.setPV1_44(resultArrayPV1[44]);
            String orc = MessageParseUtil.getMessageValue(aParsedHL7Message, "ORC");
            String[] resultArrayORC = orc.split("\\|");
            labQueryRspVo.setORC_1(resultArrayORC[1]);
            labQueryRspVo.setORC_2(resultArrayORC[2]);
            labQueryRspVo.setORC_9(resultArrayORC[9]);
            labQueryRspVo.setORC_12(resultArrayORC[12]);
            labQueryRspVo.setORC_21(resultArrayORC[21]);
            labQueryRspVo.setORC_29(resultArrayORC[29]);
            labQueryRspVo.setORC_32(resultArrayORC[32]);
            List<String> obrList = MessageParseUtil.getOBRList(aParsedHL7Message);
            List<LabQueryRspVo.OBR> obrs = new ArrayList<>();
            for (String obr: obrList) {
                String[] resultArrayOBR = obr.split("\\|");
                LabQueryRspVo.OBR obrBody = new LabQueryRspVo.OBR();
                obrBody.setOBR_1(resultArrayOBR[1]);
                obrBody.setOBR_4(resultArrayOBR[4]);
                obrBody.setOBR_5(resultArrayOBR[5]);
                String[] resultArrayOBR15 = resultArrayOBR[15].split("^");
                obrBody.setOBR_15_1(resultArrayOBR15[0]);
                obrBody.setOBR_19(resultArrayOBR[19]);
                obrs.add(obrBody);
            }
            labQueryRspVo.setObrList(obrs);

            List<String> dg1List = MessageParseUtil.getDG1List(aParsedHL7Message);
            List<LabQueryRspVo.DG1> dg1s = new ArrayList<>();
            for (String dg1: dg1List) {
                String[] resultArrayDG1 = dg1.split("\\|");
                LabQueryRspVo.DG1 dg1Body = new LabQueryRspVo.DG1();
                dg1Body.setDG1_1(resultArrayDG1[1]);
                dg1Body.setDG1_3(resultArrayDG1[3]);
                dg1Body.setDG1_6(resultArrayDG1[6]);
                dg1s.add(dg1Body);
            }
            labQueryRspVo.setDg1List(dg1s);

            // 关闭socket
            socket.close();
            return labQueryRspVo;
        }catch (Exception e){
            e.printStackTrace();
            return new LabQueryRspVo();
        }finally {
            try {
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
                if (socket !=null)
                    socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
