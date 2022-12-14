package com.healt.cloud.web.controller;

import com.healt.cloud.web.compontent.CaptchaCache;
import com.healt.cloud.web.entity.sms.SMSRequestBody;
import com.healt.cloud.web.http.HttpResult;
import com.healt.cloud.web.http.HttpsRequest;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author GuYue
 * @date 2022-09-13 13:07
 * @description: TODO
 */
@Controller
@AllArgsConstructor
@RequestMapping("/code")
public class CodeController {

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/checkCode")
    @ResponseBody
    public HttpResult checkCode(@RequestParam("mobile") String mobile, @RequestParam("code") String code){
        Map<String, Object> captchaBean = cache.getCache(mobile);
        if(captchaBean!=null){
            long expiredTime = Long.parseLong(captchaBean.get(CaptchaCache.EXPIREDTIME).toString());
            if(expiredTime < System.currentTimeMillis()) {
                return HttpResult.error("验证码已过期！请重新获取");
            }
            String captcha = captchaBean.get(CaptchaCache.CAPTCHA).toString();
            if(captcha.equals(code)){
                return HttpResult.ok();
            }
        }
        return HttpResult.error(500, "验证码错误");
    }

    /**
     * 发送手机短信验证码
     * @param mobile
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/sendSMS")
    @ResponseBody
    public HttpResult sendSMS(@RequestParam("mobile") String mobile){
        if(mobile == null || mobile.equals("")) {
            return HttpResult.error("请填写手机号码");
        }
        //为防止恶意短信攻击，对同一电话号码短信验证码请求进行过期验证
        Map<String, Object> captchaBean = cache.getCache(mobile);
        if(captchaBean!=null) {
            long expiredTime = Long.parseLong(captchaBean.get(CaptchaCache.EXPIREDTIME).toString());
            if(expiredTime-60*9000 > System.currentTimeMillis()) {
                return HttpResult.error("验证码发送过于频繁，请60秒后重试！");
            }
        }
        //生成6位短信验证码
        try {
            String text = getSmsCaptcha();
            System.out.println("smsCaptcha:"+text);
            //TODO 对接短信平台
            //String result = HttpsRequest.sendSMS(mobile, text);
            String result = "success";
            if("success".equalsIgnoreCase(result)){

            }else{
                System.out.println(result+mobile);
                return HttpResult.error("发送验证码失败，请稍后重试");
            }
            //将短信验证码、过期时间存入cache中
            captchaBean = new HashMap();
            captchaBean.put(CaptchaCache.CAPTCHA, text);
            captchaBean.put(CaptchaCache.EXPIREDTIME, System.currentTimeMillis()+60*10000);
            cache.setCache(mobile, captchaBean);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResult.error("发送验证码失败，请稍后重试");
        }
        return HttpResult.ok("验证码发送成功");
    }


    private CaptchaCache cache;

    private String getSmsCaptcha() {
        Random r = new Random();
        int i;
        do {
            i = r.nextInt(999999);
        } while (i<100000);
        return i+"";
    }
}
