package com.healt.cloud.checkup.service.tcp.message;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author GuYue
 * @date 2022-07-17 23:57
 * @description: TODO
 */
public class MessageParseUtil {

    private static final char START_OF_BLOCK = '\u000b';//mllp协议开头
    private static final char END_OF_BLOCK = '\u001c';//mllp协议结束
    private static final char CARRIAGE_RETURN = 13;//mllp协议换行符
    private static final int END_OF_TRANSMISSION = 0;
    private static final String FIELD_DELIMITER = String.valueOf(CARRIAGE_RETURN);//分隔符

    public static String getMessage(InputStream anInputStream) throws IOException {

        boolean end_of_message = false;
        String parsedMessage = new String();
        int characterReceived = 0;
        try {
            int available = 0;
            int waitTime =0;
            while (true){
                available = anInputStream.available();
                if(available != 0){
                    break;
                }
                if(waitTime == 1000){//等待2s无响应
                    break;
                }
                try {
                    waitTime += 100;
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(available == 0){
                return null;
            }
            characterReceived = anInputStream.read();
        } catch (SocketException e) {
            System.out.println("Unable to read from socket stream.Connection may have been closed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        if (characterReceived == END_OF_TRANSMISSION) {
            return null;
        }
        if (characterReceived != START_OF_BLOCK) {
            throw new RuntimeException("Start of block character has not been received");
        }
        List<Integer> list = new ArrayList();
        while (!end_of_message) {
            characterReceived = anInputStream.read();
            if (characterReceived == END_OF_TRANSMISSION) {
                throw new RuntimeException("Message terminated without end of message character");
            }
            if (characterReceived == END_OF_BLOCK) {
                characterReceived = anInputStream.read();
                if (characterReceived != CARRIAGE_RETURN) {
                    throw new RuntimeException("End of message character must be followed by a carriage return character");
                }
                end_of_message = true;
            } else {
                list.add(characterReceived);
                //parsedMessage.append((char) characterReceived);
            }
        }
        byte[] bytes = new byte[list.size()];
        for(int i = 0 ;i<list.size(); i++){
            bytes[i] = list.get(i).byteValue();
        }
        parsedMessage = new String(bytes, "utf-8");
        //System.out.println(getMessageControlID(parsedMessage));
        return parsedMessage;
    }

    public static String getMessageValue(String aParsedHL7Message, String key) {
        if(StringUtils.isEmpty(aParsedHL7Message)){
            return "";
        }
        StringTokenizer tokenizer = new StringTokenizer(aParsedHL7Message, FIELD_DELIMITER);

        while (tokenizer.hasMoreElements())
        {
            String token = tokenizer.nextToken();
            if (token.contains(key)){
                return token;
            }
        }
        return "";
    }

    public static List<String> getOBXList(String aParsedHL7Message){
        List<String> strList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(aParsedHL7Message, FIELD_DELIMITER);
        while (tokenizer.hasMoreElements())
        {
            String token = tokenizer.nextToken();
            if (token.startsWith("OBX")){
                strList.add(token);
            }
        }
        return strList;
    }

    public static List<String> getOBRList(String aParsedHL7Message){
        List<String> strList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(aParsedHL7Message, FIELD_DELIMITER);
        while (tokenizer.hasMoreElements())
        {
            String token = tokenizer.nextToken();
            if (token.startsWith("OBR")){
                strList.add(token);
            }
        }
        return strList;
    }

    public static List<String> getDG1List(String aParsedHL7Message){
        List<String> strList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(aParsedHL7Message, FIELD_DELIMITER);
        while (tokenizer.hasMoreElements())
        {
            String token = tokenizer.nextToken();
            if (token.startsWith("DG1")){
                strList.add(token);
            }
        }
        return strList;
    }

    public static String getValueByIndex(String msgValue, int index){
        String[] msgArrya = msgValue.split("\\|");
        if(msgArrya.length<index){
            return "";
        }
        return msgArrya[index-1];
     }
}
