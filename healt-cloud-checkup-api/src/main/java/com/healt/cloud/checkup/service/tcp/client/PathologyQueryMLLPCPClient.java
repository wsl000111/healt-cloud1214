package com.healt.cloud.checkup.service.tcp.client;

import com.healt.cloud.checkup.service.tcp.message.MessageParseUtil;
import com.healt.cloud.checkup.service.tcp.vo.pathology.PathologyQueryRspVo;
import com.healt.cloud.checkup.service.tcp.vo.pathology.PathologyQueryVo;
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
 * @create 2022-07-27 16:14
 */
@Service
public class PathologyQueryMLLPCPClient {

    private static final char END_OF_BLOCK = '\u001c';
    private static final char START_OF_BLOCK = '\u000b';
    private static final char CARRIAGE_RETURN = 13;

    public PathologyQueryRspVo sendPathologyQuery(PathologyQueryVo pathologyQueryVo){
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;
        try{
            //创建socket对象
            socket = new Socket(PropertiesUtils.SOCKETIP,  PropertiesUtils.SOCKETPORT);
            System.out.println("Connected to Server");

            StringBuffer testHL7MessageToTransmit = new StringBuffer();

            testHL7MessageToTransmit.append(START_OF_BLOCK)
                    //MSH|^~\&|HIS||ESB||20210918140521||OML^O21^OML^O21|169bb7ac-6180-4e04-b42b-07713334966b|P|2.6^^&&&&D56D2C42401AAC6F36&&V1.0|||NE|AL||UTF-8
                    .append("MSH|^~\\&|HIS||ESB||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||OML^O21^OML^O21|"+ CommonUtils.getUUID() +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                    .append(CARRIAGE_RETURN)
                    .append(pathologyQueryVo.toString())
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

            PathologyQueryRspVo pathologyQueryRspVo = new PathologyQueryRspVo();
            String qpd = MessageParseUtil.getMessageValue(aParsedHL7Message, "QPD");
            String[] resultArrayQPD = qpd.split("\\|");
            pathologyQueryRspVo.setQPD_1(resultArrayQPD[1]);
            pathologyQueryRspVo.setQPD_2(resultArrayQPD[2]);
            String[] qpd3 = resultArrayQPD[3].split("^");
            pathologyQueryRspVo.setQPD_3_1(qpd3[0]);
            pathologyQueryRspVo.setQPD_3_2(qpd3[1]);
            pathologyQueryRspVo.setQPD_3_3(qpd3[2]);
            pathologyQueryRspVo.setQPD_3_4(qpd3[3]);
            pathologyQueryRspVo.setQPD_3_5(qpd3[4]);
            String pid = MessageParseUtil.getMessageValue(aParsedHL7Message, "PID");
            String[] resultArrayPID = pid.split("\\|");
            pathologyQueryRspVo.setPID_2(resultArrayPID[2]);
            pathologyQueryRspVo.setPID_5(resultArrayPID[5]);
            pathologyQueryRspVo.setPID_7(resultArrayPID[7]);
            pathologyQueryRspVo.setPID_8(resultArrayPID[8]);
            String pv1 = MessageParseUtil.getMessageValue(aParsedHL7Message, "PV1");
            String[] resultArrayPV1 = pv1.split("\\|");
            pathologyQueryRspVo.setPV1_2(resultArrayPV1[2]);
            String[] pv13 = resultArrayPV1[3].split("^");
            pathologyQueryRspVo.setPV1_3_1(pv13[0]);
            pathologyQueryRspVo.setPV1_7(resultArrayPV1[7]);
            pathologyQueryRspVo.setPV1_19(resultArrayPV1[19]);
            pathologyQueryRspVo.setPV1_39(resultArrayPV1[39]);
            pathologyQueryRspVo.setPV1_44(resultArrayPV1[44]);
            String orc = MessageParseUtil.getMessageValue(aParsedHL7Message, "ORC");
            String[] resultArrayORC = orc.split("\\|");
            pathologyQueryRspVo.setORC_1(resultArrayORC[1]);
            pathologyQueryRspVo.setORC_2(resultArrayORC[2]);
            pathologyQueryRspVo.setORC_9(resultArrayORC[9]);
            pathologyQueryRspVo.setORC_12(resultArrayORC[12]);
            pathologyQueryRspVo.setORC_21(resultArrayORC[21]);
            pathologyQueryRspVo.setORC_29(resultArrayORC[29]);
            pathologyQueryRspVo.setORC_32(resultArrayORC[32]);
            List<String> obrList = MessageParseUtil.getOBRList(aParsedHL7Message);
            List<PathologyQueryRspVo.OBR> obrs = new ArrayList<>();
            for (String obr: obrList) {
                String[] resultArrayOBR = obr.split("\\|");
                PathologyQueryRspVo.OBR obrBody = new PathologyQueryRspVo.OBR();
                obrBody.setOBR_1(resultArrayOBR[1]);
                obrBody.setOBR_4(resultArrayOBR[4]);
                obrBody.setOBR_5(resultArrayOBR[5]);
                obrs.add(obrBody);
            }
            pathologyQueryRspVo.setObrList(obrs);
            List<String> obxList = MessageParseUtil.getOBXList(aParsedHL7Message);
            List<PathologyQueryRspVo.OBX> obxs = new ArrayList<>();
            for (String obx: obxList) {
                String[] resultArrayOBX = obx.split("\\|");
                PathologyQueryRspVo.OBX obxBody = new PathologyQueryRspVo.OBX();
                obxBody.setOBX_1(resultArrayOBX[1]);
                obxBody.setOBX_2(resultArrayOBX[2]);
                obxBody.setOBX_3(resultArrayOBX[3]);
                String[] resultArrayOBX5 = resultArrayOBX[5].split("^");
                obxBody.setOBX_5_1(resultArrayOBX5[0]);
                obxBody.setOBX_5_2(resultArrayOBX5[1]);
                obxBody.setOBX_11(resultArrayOBX[11]);
                obxs.add(obxBody);
            }
            pathologyQueryRspVo.setObxList(obxs);

            // 关闭socket
            socket.close();
            return pathologyQueryRspVo;
        }catch (Exception e){
            e.printStackTrace();
            return new PathologyQueryRspVo();
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
