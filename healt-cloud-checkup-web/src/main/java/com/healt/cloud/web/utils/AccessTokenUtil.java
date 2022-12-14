package com.healt.cloud.web.utils;

//import com.mnt.lcms.common.core.enums.ProjectEnum;
//import com.mnt.lcms.common.core.response.RUtil;
//import com.mnt.lcms.preg.rest.util.http.HttpUtils;
//import com.mnt.lcms.preg.rest.wechat.config.Configure;
//import com.mnt.lcms.wechat.feign.WechatOatuh2FeignClient;
//import com.mnt.lcms.wechat.feign.WechatUserFeignClient;
//import com.mnt.lcms.wechat.vo.WechatOauth2TokenVo;
//import com.mnt.lcms.wechat.vo.WechatUserInfoVo;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Slf4j
@Component
public class AccessTokenUtil {

    private String  appId = "";

    private String appsecret = "";

    public Map<String, String> getAccessToken(String code) {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> result = getOauth2AccessToken(appId, appsecret, code);
        if (result.get("resultCode").equals("0000")) {
            map.put("openid", result.get("openid"));
            map.put("access_token", result.get("access_token"));
            map.put("resultCode", "SUCCESS");
            log.info("[oauth2认证信息]网页授权成功完毕");
        } else {
            map.put("resultCode", "ERROR");
        }
        return map;
    }

    // 换取网页授权
    private  Map<String, String> getOauth2AccessToken(String appId, String appSecret, String code) {

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        url = url.replace("APPID", appId);
        url = url.replace("SECRET", appSecret);
        url = url.replace("CODE", code);

        Map<String, String> data = HttpUtils.get(url);
        JSONObject json = JSONObject.fromObject(data);
        JSONObject jsonResult = null;

        Map<String, String> map = new HashMap<String, String>();
        if ("200".equals(json.get("statusCode"))) {
            log.info("json------------------"+json);
            jsonResult = JSONObject.fromObject(json.get("result"));
            log.info("jsonResult------------------"+jsonResult);
            if (jsonResult.has("access_token")) {
                log.info("[oauth2认证信息]access_token[" + jsonResult.getString("access_token") + "]");
                log.info("[oauth2认证信息]expires_in[" + jsonResult.getString("expires_in") + "]");
                log.info("[oauth2认证信息]refresh_token[" + jsonResult.getString("refresh_token") + "]");
                log.info("[oauth2认证信息]openid[" + jsonResult.getString("openid") + "]");
                log.info("[oauth2认证信息]scope[" + jsonResult.getString("scope") + "]");
                log.info("[oauth2认证信息]网页授权成功");

                map.put("access_token", jsonResult.getString("access_token"));
                map.put("expires_in", jsonResult.getString("expires_in"));
                map.put("refresh_token", jsonResult.getString("refresh_token"));
                map.put("openid", jsonResult.getString("openid"));
                map.put("scope", jsonResult.getString("scope"));

                map.put("resultCode", "0000");
                map.put("resultDesc", "网页授权成功");
            } else {
                log.info("[oauth2认证信息]网页授权失败");
                map.put("resultCode", "9999");
                map.put("resultDesc", "网页授权失败");
            }

        } else {
            map.put("resultCode", "201");
            map.put("resultDesc", "请求失败,请稍后再试");
        }

        return map;
    }

    // 拉取授权用户信息
    public  Map<String, String> getOauth2UserInfo(String accessToken, String openId) {

        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
        url = url.replace("ACCESS_TOKEN", accessToken);
        url = url.replace("OPENID", openId);

        Map<String, String> data = HttpUtils.get(url);
        JSONObject json = JSONObject.fromObject(data);
        JSONObject jsonResult = null;

        Map<String, String> map = new HashMap<String, String>();
        if ("200".equals(json.get("statusCode"))) {

            jsonResult = JSONObject.fromObject(json.get("result"));

            if (jsonResult.has("openid")) {
                map.put("openid", jsonResult.getString("openid"));
                map.put("nickname", jsonResult.getString("nickname"));
                map.put("sex", jsonResult.getString("sex"));
                map.put("province", jsonResult.getString("province"));
                map.put("city", jsonResult.getString("city"));
                map.put("country", jsonResult.getString("country"));
                map.put("headimgurl", jsonResult.getString("headimgurl"));
                map.put("nickname", jsonResult.getString("nickname"));

                log.info("[oauth2认证信息]拉取用户信息完毕");
                log.info("[oauth2认证信息]openid[" + jsonResult.getString("openid") + "]");

                map.put("resultCode", "0000");
                map.put("resultDesc", "拉取用户信息完毕");
            } else {
                log.info("[oauth2认证信息]拉取用户信息失败:" + jsonResult.toString());
                map.put("resultCode", "9999");
                map.put("resultDesc", "拉取用户信息失败");
            }

        } else {
            map.put("resultCode", "201");
            map.put("resultDesc", "请求失败,请稍后再试");
        }

        return map;
    }

    // 拉取用户信息
    public Map<String, String> getUserInfo(String accessToken, String openId) {

        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        url = url.replace("ACCESS_TOKEN", accessToken);
        url = url.replace("OPENID", openId);

        Map<String, String> data = HttpUtils.get(url);
        JSONObject json = JSONObject.fromObject(data);
        JSONObject jsonResult = null;

        Map<String, String> map = new HashMap<String, String>();
        if ("200".equals(json.get("statusCode"))) {

            jsonResult = JSONObject.fromObject(json.get("result"));

            if (jsonResult.has("openid")) {
                map.put("openid", jsonResult.getString("openid"));
                map.put("nickname", jsonResult.getString("nickname"));
                map.put("sex", jsonResult.getString("sex"));
                map.put("province", jsonResult.getString("province"));
                map.put("city", jsonResult.getString("city"));
                map.put("country", jsonResult.getString("country"));
                map.put("headimgurl", jsonResult.getString("headimgurl"));
                map.put("nickname", jsonResult.getString("nickname"));

                log.info("拉取用户信息完毕");
                log.info("[oauth2认证信息]openid[" + jsonResult.getString("openid") + "]");

                map.put("resultCode", "0000");
                map.put("resultDesc", "拉取用户信息完毕");
            } else {
                log.info("[oauth2认证信息]拉取用户信息失败:" + jsonResult.toString());
                map.put("resultCode", "9999");
                map.put("resultDesc", "拉取用户信息失败");
            }

        } else {
            map.put("resultCode", "201");
            map.put("resultDesc", "请求失败,请稍后再试");
        }

        return map;
    }

//    //获取应用access_token，并存入redis
//    public String getTokenByRedis() {
//        String accessToken = (String) redisTemplate.opsForValue().get("access_token");
//        log.info("accessToken:" + accessToken);
//        if (accessToken != null) {
//            if (validAccessToken(accessToken)) {
//                return accessToken;
//            } else {
//                return getAccessTokenByWx();
//            }
//
//        } else {
//            //调用腾讯接口，获取access_token,access_token每天限制调用2000次，故取出后放入redis，过期后重新调用接口
//            return getAccessTokenByWx();
//        }
//    }

//    /**
//     * 从微信获取access_token
//     *
//     * @return
//     */
//    private String getAccessTokenByWx() {
//        //调用腾讯接口，获取access_token,access_token每天限制调用2000次，故取出后放入redis，过期后重新调用接口
//        String url = "https://api.weixin.qq.com/cgi-bin/token" + "?"
//                + "grant_type=client_credential&" + "appid="
//                + configure.getAppid() + "&" + ""
//                + "secret=" + appsecret;
//        String data = "";
//        Map<String, String> rs = HttpUtils.post(url, data);
//        try {
//            String statusCode = rs.get("statusCode");
//            log.info("返回map：" + rs);
//            log.info("返回状态：" + statusCode);
//            if ("200".equals(statusCode)) {
//                String result = rs.get("result");
//                log.info("返回结果：" + result);
//                JSONObject jsonObject = JSONObject.fromObject(result);
//                log.info("jsonObject:" + jsonObject);
//                String token = jsonObject.getString("access_token");
//                redisTemplate.opsForValue().set("access_token", token, 6000, TimeUnit.SECONDS);
//                return token;
//            } else {
//                return null;
//            }
//        }catch(Exception ex){
//            ex.printStackTrace();
//            return null;
//        }
//    }


    /**
     * 验证access_token是否有效
     * @param access_token
     * @return
     */
    private Boolean validAccessToken(String access_token){
        String uri = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
        uri = uri.replace("ACCESS_TOKEN", access_token);
        Map<String, Object> map = HttpUtils.defaultHttpGet(uri, "UTF-8", 8000);
        if (map.isEmpty() || !map.get(HttpUtils.STATUS_CODE).equals(200)) {
            return false;
        }else{
            JSONObject result = JSONObject.fromObject(map.get(HttpUtils.RESULT));
            if("40001".equals(String.valueOf(result.get("errcode")))){
                return false;
            }
            return true;
        }
    }

}
