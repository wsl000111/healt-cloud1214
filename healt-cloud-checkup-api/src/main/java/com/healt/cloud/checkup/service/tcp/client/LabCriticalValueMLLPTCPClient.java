package com.healt.cloud.checkup.service.tcp.client;

import com.healt.cloud.checkup.service.tcp.message.MessageParseUtil;
import com.healt.cloud.checkup.service.tcp.vo.lab.LabCriticalValueVo;
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
 * @create 2022-07-20 11:03
 */
@Service
public class LabCriticalValueMLLPTCPClient {

    private static final char END_OF_BLOCK = '\u001c';
    private static final char START_OF_BLOCK = '\u000b';
    private static final char CARRIAGE_RETURN = 13;

    public void sendLabCriticalValue(LabCriticalValueVo labCriticalValueVo){
        try{
            //创建socket对象
            Socket socket = new Socket(PropertiesUtils.SOCKETIP,  PropertiesUtils.SOCKETPORT);
            System.out.println("Connected to Server");

            StringBuffer testHL7MessageToTransmit = new StringBuffer();

            testHL7MessageToTransmit.append(START_OF_BLOCK)
                    //MSH|^~\&|HIS||ESB||20210918140521||ORU^R01^ORL^R21|169bb7ac-6180-4e04-b42b-07713334966b|P|2.6^^&&&&D56D2C42401AAC6F36&&V1.0|||NE|AL||UTF-8
                    .append("MSH|^~\\&|HIS||ESB||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||ORU^R01^ORL^R21|"+ CommonUtils.getUUID() +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                    .append(CARRIAGE_RETURN)
                    .append(labCriticalValueVo.toString())
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
