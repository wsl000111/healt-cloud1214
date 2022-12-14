package com.healt.cloud.checkup.service.tcp.client;

/**
 * @author GuYue
 * @date 2022-07-17 11:05
 * @description: TODO
 */

import com.healt.cloud.checkup.entity.Hl7Log;
import com.healt.cloud.checkup.service.Hl7LogService;
import com.healt.cloud.checkup.service.tcp.message.MessageParseUtil;
import com.healt.cloud.checkup.service.tcp.vo.exam.ExamApplyVo;
import com.healt.cloud.common.utils.CommonUtils;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.List;

public class ExamApplyMLLPTCPClient {

    private static final char END_OF_BLOCK = 0x1c;
    private static final char END_OF_DBLOCK = 0x0d;
    private static final char START_OF_BLOCK = 0x0b;
    private static final char CARRIAGE_RETURN = 13;
    private static String SENDER = "PHYS";
    private static String RECEIVER = "HIS";
    Socket socket = null;
    InputStream in = null;
    OutputStream out = null;

    private Hl7LogService hl7LogService;

    public ExamApplyMLLPTCPClient(Hl7LogService hl7LogService){
        this.hl7LogService = hl7LogService;
    }
    public ExamApplyMLLPTCPClient(){}

    public boolean sendExamApply(ExamApplyVo examApplyVo){

        try{
            //创建socket对象
            if(socket == null){
                System.out.println("Create ExamApplyMLLPTCPClient Socket");
                socket = new Socket(PropertiesUtils.SOCKETIP,  PropertiesUtils.SOCKETPORT);
                in = socket.getInputStream();
                out = socket.getOutputStream();
            }
            System.out.println("Connected to Server");

            StringBuffer testHL7MessageToTransmit = new StringBuffer();
            String uuid = CommonUtils.getUUID();
            String orc_1 = examApplyVo.getORC_1();
            if("CA".equals(orc_1)){
                testHL7MessageToTransmit.append(START_OF_BLOCK)
                        //MSH|^~\&|HIS||ESB||20210918140521||ORM^O01^ORM^O01|169bb7ac-6180-4e04-b42b-07713334966b|P|2.6^^&&&&D56D2C42401AAC6F36&&V1.0|||CA|AL||UTF-8
                        .append("MSH|^~\\&|"+SENDER+"||"+RECEIVER+"||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||ORM^O01^ORM_O01|"+ uuid +"|P|2.6^^&&&&V1.0|||CA|AL||UTF-8")
                        .append(CARRIAGE_RETURN)
                        .append(examApplyVo.toString())
                        .append(END_OF_BLOCK)
                        .append(END_OF_DBLOCK);
            }else{
                testHL7MessageToTransmit.append(START_OF_BLOCK)
                        //MSH|^~\&|HIS||ESB||20210918140521||ORM^O01^ORM^O01|169bb7ac-6180-4e04-b42b-07713334966b|P|2.6^^&&&&D56D2C42401AAC6F36&&V1.0|||NE|AL||UTF-8
                        .append("MSH|^~\\&|"+SENDER+"||"+RECEIVER+"||"+ DateUtils.getDateYYYYMMDDHHMMSS() +"||ORM^O01^ORM_O01|"+ uuid +"|P|2.6^^&&&&V1.0|||NE|AL||UTF-8")
                        .append(CARRIAGE_RETURN)
                        .append(examApplyVo.toString())
                        .append(END_OF_BLOCK)
                        .append(END_OF_DBLOCK);
            }

            Hl7Log paramIn = new Hl7Log();
            paramIn.setDataStr(testHL7MessageToTransmit.toString());
            paramIn.setDataType("发送");
            paramIn.setMethod(examApplyVo.getORC_32());
            paramIn.setUuid(uuid);
            paramIn.setInsertDate(new Date());
            paramIn.setApplyNo(examApplyVo.getORC_2());
            hl7LogService.save(paramIn);

            // Send the MLLP-wrapped HL7 message to the server
            out.write(testHL7MessageToTransmit.toString().getBytes("utf-8"));
            out.flush();
            //接收服务端返回数据
            String aParsedHL7Message = MessageParseUtil.getMessage(in);
            if(aParsedHL7Message == null){
                return false;
            }
            String msa = MessageParseUtil.getMessageValue(aParsedHL7Message, "MSA");
            String[] resultArray = msa.split("\\|");
            String success = resultArray[1];

            Hl7Log paramOut = new Hl7Log();
            paramOut.setDataStr(aParsedHL7Message);
            paramOut.setDataType("接收");
            paramOut.setMethod(examApplyVo.getORC_21());
            paramOut.setUuid(paramIn.getUuid());
            paramOut.setInsertDate(new Date());
            paramIn.setApplyNo(examApplyVo.getORC_2());
            hl7LogService.save(paramOut);

            //System.out.println(resultArray[1]);
            if("CE".equals(success)){//发送申请失败
//                String err = MessageParseUtil.getMessageValue(aParsedHL7Message, "ERR");
//                String[] errArray = err.split("\\|");
                //throw new CommonException(500, errArray[3]);
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
                socket=null;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
