package com.healt.cloud.checkup.service.tcp.client;

/**
 * @author GuYue
 * @date 2022-07-17 11:05
 * @description: TODO
 */

import com.healt.cloud.checkup.service.tcp.message.MessageParseUtil;
import com.healt.cloud.common.utils.CommonUtils;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.PropertiesUtils;
import com.healt.cloud.resultex.exception.CommonException;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@Service
public class ExamQueryMLLPTCPClient {

    private static final char START_OF_BLOCK = '\u000b';//mllp协议开头
    private static final char END_OF_BLOCK = '\u001c';//mllp协议结束
    private static final char CARRIAGE_RETURN = 13;//mllp协议换行符

    public String examApplyQuery(Object ExamQueryVo){
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;
        try{
            StringBuffer testHL7MessageToTransmit = new StringBuffer();
            testHL7MessageToTransmit.append(START_OF_BLOCK)
                    //MSH|^~\&|PHYS||HIS||20220218140521||QBP^Z07^QBP^Q11|169bb7ac-6180-4e04-b42b-07713334966b|P|2.6^^&&&&V1.0|||NE|AL||UTF-8
                    .append("MSH|^~\\&|PHYS||HIS||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||QBP^Z04^QBP^Q11|"+ CommonUtils.getUUID() +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                    .append(CARRIAGE_RETURN)
                    //QPD|Z15^检查查询|Z0410|2^1005602518^5^1126^20220227000000^20220227235959
                    .append("QPD|Z04^查询检查申请信息|Z0410|3^2022032751^1^HIS0101&HIS0101^20220725182935^20220727182935^1^")
                    .append(CARRIAGE_RETURN)
                    //RCP|I
                    .append("RCP|I")
                    .append(CARRIAGE_RETURN)

                    .append(END_OF_BLOCK)
                    .append(CARRIAGE_RETURN);
            //创建socket对象
            socket = new Socket(PropertiesUtils.SOCKETIP,  PropertiesUtils.SOCKETPORT);
            //Socket socket = new Socket("localhost", 1080);
            System.out.println("Connected to Server");

            in = socket.getInputStream();
            out = socket.getOutputStream();

            // Send the MLLP-wrapped HL7 message to the server
            out.write(testHL7MessageToTransmit.toString().getBytes("UTF-8"));

            //接收服务端返回数据
            String aParsedHL7Message = MessageParseUtil.getMessage(in);
            String msa = MessageParseUtil.getMessageValue(aParsedHL7Message, "MSA");
            String[] resultArray = msa.split("\\|");
            String success = resultArray[1];
            //System.out.println(resultArray[1]);
            if("CE".equals(success)){
                String err = MessageParseUtil.getMessageValue(aParsedHL7Message, "ERR");
                String[] errArray = err.split("\\|");
                for(String str : errArray){
                    System.out.println(str);
                }
                throw new CommonException(500, errArray[4]);
            }

            // 关闭socket
            socket.close();

            return msa;
        }catch (Exception e){
            e.printStackTrace();
            throw new CommonException(500, e.getMessage());
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

    public static void main(String[] args) {
        new ExamQueryMLLPTCPClient().examApplyQuery(null);
    }

}
