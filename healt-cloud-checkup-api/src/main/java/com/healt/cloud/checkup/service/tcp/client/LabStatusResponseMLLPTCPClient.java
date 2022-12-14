package com.healt.cloud.checkup.service.tcp.client;

import com.healt.cloud.checkup.service.tcp.message.MessageParseUtil;
import com.healt.cloud.checkup.service.tcp.vo.lab.LabStatusResponseVo;
import com.healt.cloud.common.utils.CommonUtils;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.PropertiesUtils;
import com.healt.cloud.resultex.exception.CommonException;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author linklee
 * @create 2022-07-18 14:33
 */
@Service
public class LabStatusResponseMLLPTCPClient {

    private static final char END_OF_BLOCK = '\u001c';
    private static final char START_OF_BLOCK = '\u000b';
    private static final char CARRIAGE_RETURN = 13;

    public void sendLabStatusResponse(LabStatusResponseVo labStatusResponseVo){
        try{
            //创建socket对象
            Socket socket = new Socket(PropertiesUtils.SOCKETIP,  PropertiesUtils.SOCKETPORT);
            System.out.println("Connected to Server");

            StringBuffer testHL7MessageToTransmit = new StringBuffer();
            testHL7MessageToTransmit.append(START_OF_BLOCK)
                    //MSH|^~\&|LIS|LIS|HIS|HIS|20211224162118||ORG^O20|MSG202201041524|P|2.6^^&&&&5aa80a27e8c14153073cf36&&V1.0|||NE|AL||UTF-8
                    .append("MSH|^~\\&|HIS||ESB||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||ORG^O20|"+ CommonUtils.getUUID() +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                    .append(CARRIAGE_RETURN)
                    .append(labStatusResponseVo.toString())
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

            // 关闭socket
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
