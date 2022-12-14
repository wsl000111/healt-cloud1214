package com.healt.cloud.web.utils;


//import com.mnt.lcms.common.utils.json.JSONUtil;
//import com.mnt.lcms.preg.rest.util.http.HttpUtils;

import java.util.HashMap;
import java.util.Map;

public class MenuUtil {
    /*----------------------------- 自定义菜单开始 ---------------------------------*/
    private static final String APP_ID = "wx45ced7452976fd7b";  //资源ID
    private static final String APP_SECRET = "f49781e33e56b560a4a5c330b9f2bf5e";  //资源ID
    private static final String CHANNEL_ID = "r5y23ec9dfb111eb96600242ac121222";  //channel ID
    public static final String host = "preg.myyahealth.com";
    public static final String hostApi = "api.myyahealth.com%2frestPreg";
    public static final String downloadUrl = "https://" + host + "/download";
    public static final String birthLoveUrl = "https://www.wjx.cn/jq/72495398.aspx";//产后关爱链接
    //科研
    public static final String scanUrl = "https://src.myyahealth.com/mnt/ky/qr";
    //token
    public static final String ACCESS_TOKEN = "61_RyAZ5cNJ6oC9_vqMV1NgLuijGnTbOTTDBm7uu2dCiZ5s4wChqDd6y1xevG0iejHjdx6kwh1N-wSiowPcOa-kic3g4dnWFz2QtP50JsNuf1tAu297lzFZiiizSLQxdeA2bgVmbNCdPHw5uaWbHFIeAJAXVY";
    //微信授权链接前缀
    public static final String WECHAT_URL_PREFIX = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + APP_ID + "&redirect_uri=";
    //微信授权链接后缀
    public static final String WECHAT_URL_SUFFIX = "&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";

    //public static final String httpUrl = "https%3a%2f%2fapi.myyahealth.com%2frestPreg%2fwechatOauthPublic";
    public static final String httpUrl = "http%3a%2f%2fpgcs.myahealth.cc%2fpregApi%2fparamoauth";

//    /**
//     * 自定义菜单方法
//     *
//     * @return
//     */
//    public static Map<String, String> createMenu() {
//        String url = "https://api.weixin.qq.com/cgi-bin/menu/create" + "?" + "access_token=" + ACCESS_TOKEN;
//        String data = "";
//        //菜单发布
//        data =
//                "{ " +
//                        " \"button\": [" +
//                        "           {                                                                                           " +
//                        "              \"type\":\"view\",                                                                              " +
//                        "              \"name\":\"我的医生\",                                                                             " +
//                        "              \"url\":\"" + getOauthUrl(APP_ID, "mydoctor", "mydoctor", CHANNEL_ID, httpUrl) + "\"                                         " +
//                        "           },                                                                                                   " +
//                        "           {                                                                                                   " +
//                        "              \"name\":\"科研服务\",                                                                             " +
//                        "              \"sub_button\":[                                                                                 " +
//
//                        "           {                                                                                           " +
//                        "              \"type\":\"view\",                                                                              " +
//                        "              \"name\":\"扫一扫(维D)\",                                                                             " +
//                        "              \"url\":\"" + scanUrl + "\"                                         " +
//                        "           },                                                                                           " +
//                        "           {                                                                                           " +
//                        "              \"type\":\"view\",                                                                              " +
//                        "              \"name\":\"科研项目\",                                                                             " +
//                        "              \"url\":\"" + getOauthUrl(APP_ID, "research", "research", CHANNEL_ID, httpUrl) + "\"                                         " +
//                        "           }   " +
//
//                        "               ]                                                                                                              " +
//                        "           },   " +
//                        "           {                                                                                                   " +
//                        "              \"name\":\"更多\",                                                                             " +
//                        "              \"sub_button\":[                                                                                 " +
////
//                        "           {                                                                                           " +
//                        "              \"type\":\"view\",                                                                              " +
//                        "              \"name\":\"产后关爱\",                                                                             " +
//                        "              \"url\":\"" + birthLoveUrl + "\"" +
//                        "           },                                                                                           " +
//
//                        "           {                                                                                           " +
//                        "              \"type\":\"view\",                                                                              " +
//                        "              \"name\":\"下载APP\",                                                                             " +
//                        "              \"url\":\"" + downloadUrl + "\"" +
//                        "           }                                                                                                   " +
//                        "               ]                                                                                                              " +
//                        "           }   " +
//                        "] " +
//                        "}";
//
//        System.out.println(data);
//        Map<String, String> map = new HashMap<>();
//        map.put("data", data);
//        Map<String, String> resultMap = HttpUtils.post(url, data);
//        System.out.println(JSONUtil.toJsonString(resultMap));
//        return null;
//    }

    /**
     * 拼接授权链接
     *
     * @param appid
     * @param paramId
     * @param paramType
     * @param channelId
     * @param url
     * @return
     */
    private static String getOauthUrl(String appid, String paramId, String paramType, String channelId, String url) {
        //群服务微信授权链接前缀
        String prefix = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri=";
        //群服务微信授权链接后缀
        String suffix = "&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
        String redirect_uri = url + "%3fparamId%3D" + paramId + "%26paramType%3d" + paramType + "%26channelId%3D" + channelId;
        redirect_uri = prefix + redirect_uri + suffix;
        return redirect_uri;
    }

//    public static void main(String[] args) {
//        System.out.println(createMenu());
//    }
}
