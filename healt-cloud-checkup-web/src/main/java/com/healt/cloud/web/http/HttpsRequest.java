package com.healt.cloud.web.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.healt.cloud.web.configuration.RestTemplateConfig;
import com.healt.cloud.web.entity.sms.SMSRequestBody;
import com.healt.cloud.web.entity.sms.SMSResponseBody;
import com.healt.cloud.web.utils.JSONUtils;
import com.healt.cloud.web.utils.PropertiesUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @author GuYue
 * @date 2022-09-14 8:56
 * @description: TODO
 */
public class HttpsRequest {

    public static RestTemplate getRestTemplate() {
        try {
            RestTemplate restTemplate = new RestTemplate(RestTemplateConfig.generateHttpRequestFactory());
            return restTemplate;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 短信平台信息推送
     */
    public static String sendSMS(String mobile, String code) throws JsonProcessingException {
        RestTemplate restTemplate = HttpsRequest.getRestTemplate();
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "*/*");
        headers.add("Content-Type", "application/json");
        SMSRequestBody smsRequestBody = new SMSRequestBody();
        smsRequestBody.setEcName(PropertiesUtils.EC_NAME);
        smsRequestBody.setApId(PropertiesUtils.AP_ID);
        smsRequestBody.setMobiles(mobile);
        String content = PropertiesUtils.CONTENT.replace("code", code);
        smsRequestBody.setContent(content);
        smsRequestBody.setSign(PropertiesUtils.SIGN);
        smsRequestBody.setAddSerial(PropertiesUtils.ADD_SERIAL);
        String mac = smsRequestBody.getEcName()+smsRequestBody.getApId()+PropertiesUtils.SECRET_KEY+smsRequestBody.getMobiles()
                +smsRequestBody.getContent()+smsRequestBody.getSign()+smsRequestBody.getAddSerial();
        //System.out.println(mac);
        mac = DigestUtils.md5DigestAsHex(mac.getBytes(StandardCharsets.UTF_8));
        //System.out.println(mac);
        smsRequestBody.setMac(mac);
        String requestBody = JSONUtils.bean2Json(smsRequestBody);
        //System.out.println(requestBody);
        //将参数进行base64加密
        String base64Str = Base64Utils.encodeToString(requestBody.getBytes(StandardCharsets.UTF_8));
        //System.out.println(base64Str);
        HttpEntity entity = new HttpEntity(base64Str, headers);
        ResponseEntity<String> responseEntity=restTemplate.postForEntity(PropertiesUtils.SMS_HTTPS_URL,entity,String.class);
        //获取返回结果
        String result=responseEntity.getBody();
        //System.out.println(result);
        SMSResponseBody smsResponseBody = JSONUtils.json2Bean(result, SMSResponseBody.class);
        return smsResponseBody.getRspcod();
    }

}
