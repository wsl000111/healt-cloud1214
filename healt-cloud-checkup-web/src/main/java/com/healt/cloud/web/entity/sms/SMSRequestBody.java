package com.healt.cloud.web.entity.sms;

import lombok.Data;
import org.apache.tomcat.util.security.MD5Encoder;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

/**
 * @author GuYue
 * @date 2022-09-14 14:11
 * @description: TODO
 */
@Data
public class SMSRequestBody implements Serializable {
    //企业名称
    private String ecName;
    //接口账号用户名
    private String apId;
    //收信手机号码
    private String mobiles;
    //短信内容
    private String content;
    //签名编码。在云MAS平台『管理』→『接口管理』→『短信接入用户管理』获取
    private String sign;
    //扩展码。依据申请开户的服务代码匹配类型而定，如为精确匹配，此项填写空字符串（""）；
    //如为模糊匹配，此项可填写空字符串或自定义的扩展码，注：服务代码加扩展码总长度不能超过20位
    private String addSerial;
    //参数校验序列，生成方法：将ecName、apId、secretKey、mobiles、content、sign、addSerial按序拼接（无间隔符），通过MD5（32位小写）计算得出值
    private String mac;
}
