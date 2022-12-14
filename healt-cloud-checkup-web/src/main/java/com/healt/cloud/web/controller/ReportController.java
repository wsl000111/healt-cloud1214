package com.healt.cloud.web.controller;

import cn.hutool.core.util.IdcardUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.healt.cloud.web.compontent.CaptchaCache;
import com.healt.cloud.web.entity.report.CheckUpOrderVo;
import com.healt.cloud.web.entity.report.CheckUpOrderVo1;
import com.healt.cloud.web.entity.report.PersonReportListReqVo;
import com.healt.cloud.web.entity.report.WebUserInfoVo;
import com.healt.cloud.web.http.HttpResult;
import com.healt.cloud.web.utils.IDCardUtils;
import com.healt.cloud.web.utils.JwtTokenUtils;
import com.healt.cloud.web.utils.PropertiesUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GuYue
 * @date 2022-09-15 12:14
 * @description: TODO
 */
@Controller
@AllArgsConstructor
@RequestMapping("/reportWeb")
public class ReportController {

    @Autowired
    CodeController codeController;

    private RestTemplate restTemplate;

    private CaptchaCache cache;

    /**
     * 查詢報告
     * @param request
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/loadPersonReportList")
    @ResponseBody
    public HttpResult reportList(HttpServletRequest request ,@RequestBody WebUserInfoVo webUserInfoVo) {

        String token = request.getHeader("token");
        if(token==null||token.equals("")){
            return HttpResult.error(401,"用户未登录");
        }else{
            String id =  JwtTokenUtils.getIdFromToken(token);
            if(id==null||id.equals("")){
                return HttpResult.error(500,"用户未注册");
            }else{
                String bindId = webUserInfoVo.getBindId();
                if(id.equals(bindId)) {//本人查询报告
                    String url = PropertiesUtils.PERSON_REPORT_LIST;
                    ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, id, HttpResult.class);
                    System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
                    return HttpResult.ok(responseEntity.getBody().getData());
                }else{//绑定人查询报告
                    id = bindId;
                    String url = PropertiesUtils.PERSON_REPORT_LIST_BIND;
                    ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, id, HttpResult.class);
                    System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
                    return HttpResult.ok(responseEntity.getBody().getData());
                }
            }
        }
    }

    /**
     * 查詢訂單
     * @param request
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/webPersonOrdersList")
    @ResponseBody
    public HttpResult webPersonOrdersList(HttpServletRequest request, @RequestBody WebUserInfoVo webUserInfoVo){
        String token = request.getHeader("token");
        if(token==null||token.equals("")){
            return HttpResult.error(401,"用户未登录");
        }else{
            String id =  JwtTokenUtils.getIdFromToken(token);
            if(id==null||id.equals("")){
                return HttpResult.error(500,"用户未注册");
            }else{
                String bindId = webUserInfoVo.getBindId();
                if(id.equals(bindId)) {
                    String url = PropertiesUtils.WEB_PERSON_ORDERS_LIST;
                    ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, id, HttpResult.class);
                    System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
                    return HttpResult.ok(responseEntity.getBody().getData());
                }else{
                    id = bindId;
                    String url = PropertiesUtils.WEB_PERSON_ORDERS_LIST_BIND;
                    ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, id, HttpResult.class);
                    System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
                    return HttpResult.ok(responseEntity.getBody().getData());
                }
            }
        }
    }

    /**
     * 首页信息展示
     * @param request
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/homePageInfo")
    @ResponseBody
    public HttpResult homePageInfo(HttpServletRequest request){
        String token = request.getHeader("token");
        if(token==null||token.equals("")){
            return HttpResult.error(401,"用户未登录");
        }else{
            String id =  JwtTokenUtils.getIdFromToken(token);
            System.out.println(id);
            if(id==null||id.equals("")){
                return HttpResult.error(500,"用户未注册");
            }else{
                String url = PropertiesUtils.HOME_PAGE_INFO;
                ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, id, HttpResult.class);
                if(responseEntity.getBody().getCode() == 200){
                    return HttpResult.ok(responseEntity.getBody().getData());
                }else{
                    return HttpResult.error(responseEntity.getBody().getCode(), responseEntity.getBody().getMsg());
                }
            }
        }
    }


    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/downloadPdf")
    @ResponseBody
    public String downloadPdf(@RequestParam("personId") String personId, @RequestParam("personVisitId") String personVisitId){
        String url = PropertiesUtils.DOWNLOAD_PDF_FILE+"?personId="+personId+"&personVisitId="+personVisitId;
        String result = restTemplate.getForObject(url, String.class);
        String targetUrl = PropertiesUtils.TARGET_URL;
        byte[] byt  = Base64Utils.decodeFromString(result);
        File file = this.createFile(personId,personVisitId);
        FileOutputStream outputStream  = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(byt);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        targetUrl = targetUrl+file.getName();
        return targetUrl;
    }


    private File createFile(String personId,String personVisitId){
        String fileName = personId+"_"+personVisitId+".pdf";
        String filePath = "c:/download/";
        File file = new File(filePath+fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 登录时根据身份证号查询个人信息
     *
     * @param webUserInfoVo
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    public HttpResult login(@RequestBody WebUserInfoVo webUserInfoVo){
        if(webUserInfoVo.getPhoneNo()==null || webUserInfoVo.getPhoneNo().equals("")){
            return HttpResult.error(500,"手机号不能为空");
        }
        if(webUserInfoVo.getCode() != null && !webUserInfoVo.getCode().equals("")){
            Map<String, Object> captchaBean = cache.getCache(webUserInfoVo.getPhoneNo());
            if(captchaBean!=null){
                long expiredTime = Long.parseLong(captchaBean.get(CaptchaCache.EXPIREDTIME).toString());
                if(expiredTime < System.currentTimeMillis()) {
                    return HttpResult.error(500,"验证码已过期！请重新获取");
                }
                String captcha = captchaBean.get(CaptchaCache.CAPTCHA).toString();
                if(captcha.equals(webUserInfoVo.getCode())){
                    String url = PropertiesUtils.LOGIN;
                    ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, webUserInfoVo, HttpResult.class);
                    System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
                    if(responseEntity.getBody().getCode()== 200){
                        Map<String, Object> map = new HashMap<>();
                        System.out.println(responseEntity.getBody().getMsg());
                        map.put("id", responseEntity.getBody().getMsg());
                        String  token  = JwtTokenUtils.generateToken(map);
                        return HttpResult.token(token);
                    }else{
                        return HttpResult.error(responseEntity.getBody().getCode(), responseEntity.getBody().getMsg());
                    }
                }
            }
            return HttpResult.error(500, "验证码错误");
        }else{
            return HttpResult.error("登录失败！");
        }
    }
    /**
     * 注册
     *
     * @param webUserInfoVo
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/regeist")
    @ResponseBody
    public HttpResult regeist(@RequestBody WebUserInfoVo webUserInfoVo){

        if (webUserInfoVo.getIdNo()==null || webUserInfoVo.getIdNo().equals("")){
            return HttpResult.error(500,"身份证号不能为空");
        }
        if(!IdcardUtil.isValidCard(webUserInfoVo.getIdNo())){
            return HttpResult.error(500,"请核对您的身份证号是否填写正确");
        }
        if(webUserInfoVo.getPhoneNo()==null || webUserInfoVo.getPhoneNo().equals("")){
            return HttpResult.error(500,"手机号不能为空");
        }
        if(webUserInfoVo.getUserName() == null || webUserInfoVo.getUserName().equals("")){
            return  HttpResult.error(500,"姓名不能为空");
        }

        if(webUserInfoVo.getCode() != null && !webUserInfoVo.getCode().equals("")){
            Map<String, Object> captchaBean = cache.getCache(webUserInfoVo.getPhoneNo());
            if(captchaBean!=null){
                long expiredTime = Long.parseLong(captchaBean.get(CaptchaCache.EXPIREDTIME).toString());
                if(expiredTime < System.currentTimeMillis()) {
                    return HttpResult.error(500,"验证码已过期！请重新获取");
                }
                String captcha = captchaBean.get(CaptchaCache.CAPTCHA).toString();
                if(captcha.equals(webUserInfoVo.getCode())){
                    String url = PropertiesUtils.REGEIST;
                    ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, webUserInfoVo, HttpResult.class);
                    if(responseEntity.getBody().getCode()!=200){
                        return HttpResult.error(responseEntity.getBody().getCode(), responseEntity.getBody().getMsg());
                    }
                    Map data = (Map) responseEntity.getBody().getData();
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", data.get("ID").toString());
                    String  token  = JwtTokenUtils.generateToken(map);
                    System.out.println(token);
                    return HttpResult.token(token);
                }
            }
            return HttpResult.error(500, "验证码错误");
        }else{
            return HttpResult.error("注册失败！");
        }
    }

    /**
     * 添加绑定人
     * @param request
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/addBindPerson")
    @ResponseBody
    public HttpResult addBindPerson(HttpServletRequest request ,@RequestBody WebUserInfoVo webUserInfoVo){
        if(webUserInfoVo.getPhoneNo() == null || webUserInfoVo.getPhoneNo().equals("")){
            return  HttpResult.error(500,"电话号不能为空");
        }
        if(webUserInfoVo.getIdNo() == null || webUserInfoVo.getIdNo().equals("")){
            return  HttpResult.error(500,"身份证号不能为空");
        }
        //校验身份证号是否正确，防止输入错误
        if(!IdcardUtil.isValidCard(webUserInfoVo.getIdNo())){
            return HttpResult.error(500,"请核对您的身份证号是否填写正确");
        }
        if(webUserInfoVo.getUserName() == null || webUserInfoVo.getUserName().equals("")){
            return  HttpResult.error(500,"姓名不能为空");
        }
        if(webUserInfoVo.getRelationShip() == null || webUserInfoVo.getRelationShip().equals("")){
            return  HttpResult.error(500,"关系不能为空");
        }
        String token = request.getHeader("token");
        if(token==null||token.equals("")){
            return HttpResult.error(401,"用户未登录");
        }else{
            String id =  JwtTokenUtils.getIdFromToken(token);
            if(id==null||id.equals("")){
                return HttpResult.error(500,"用户未注册");
            }else{
                webUserInfoVo.setId(id);
                String url = PropertiesUtils.ADD_BIND_PERSON;
                ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, webUserInfoVo, HttpResult.class);
                System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
                return responseEntity.getBody();
            }
        }
    }
    /**
     * 查询绑定人
     * @param request
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/selectBindPerson")
    @ResponseBody
    public HttpResult selectBindPerson(HttpServletRequest request ){
        String token = request.getHeader("token");
        if(token==null||token.equals("")){
            return HttpResult.error(401,"用户未登录");
        }else{
            String id =  JwtTokenUtils.getIdFromToken(token);
            if(id==null||id.equals("")){
                return HttpResult.error(500,"用户未注册");
            }else{
                String url = PropertiesUtils.SELECT_BIND_PERSON;
                ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, id, HttpResult.class);
                System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
                return HttpResult.ok(responseEntity.getBody().getData());
            }
        }
    }

    /**
     * 删除绑定人（解绑）
     * @param request
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/deleteBindPerson")
    @ResponseBody
    public HttpResult deleteBindPerson(HttpServletRequest request ,@RequestBody WebUserInfoVo webUserInfoVo){
        String token = request.getHeader("token");
        if(token==null||token.equals("")){
            return HttpResult.error(401,"用户未登录");
        }else{
            String id =  JwtTokenUtils.getIdFromToken(token);
            if(id==null||id.equals("")){
                return HttpResult.error(500,"请先注册");
            }else{
                webUserInfoVo.setBindId(webUserInfoVo.getBindId());
                webUserInfoVo.setId(id);
                String url = PropertiesUtils.DELETE_BIND_PERSON;
                ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, webUserInfoVo, HttpResult.class);
                System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
                return HttpResult.ok(responseEntity.getBody().getData());
            }
        }
    }

//    /**
//     * 查询体检套餐
//     * @param request
//     * @return
//     */
//    @CrossOrigin
//    @RequestMapping(method = RequestMethod.POST, value = "/hcPackSetDictList")
//    @ResponseBody
//    public HttpResult hcPackSetDictList(HttpServletRequest request ){
//        String token = request.getHeader("token");
//        if(token==null||token.equals("")){
//            return HttpResult.error(401,"用户未登录");
//        }else{
//            String id =  JwtTokenUtils.getIdFromToken(token);
//            if(id==null||id.equals("")){
//                return HttpResult.error(401,"请先注册");
//            }else{
//                String url = PropertiesUtils.HC_PACK_SET_DICT_LIST;
//                ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, id, HttpResult.class);
//                System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
//                return HttpResult.ok(responseEntity.getBody().getData());
//            }
//        }
//    }
//    /**
//     * 查询体检套餐详细
//     * @param request
//     * @return
//     */
//    @CrossOrigin
//    @RequestMapping(method = RequestMethod.POST, value = "/hcItemPackDictList")
//    @ResponseBody
//    public HttpResult hcItemPackDictList(HttpServletRequest request ,@RequestBody String setCode){
//        String token = request.getHeader("token");
//        if(token==null||token.equals("")){
//            return HttpResult.error(401,"用户未登录");
//        }else{
//            String id =  JwtTokenUtils.getIdFromToken(token);
//            if(id==null||id.equals("")){
//                return HttpResult.error(401,"请先注册");
//            }else{
//                String url = PropertiesUtils.HC_ITEM_PACK_DICT_LIST;
//                ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, setCode, HttpResult.class);
//                System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
//                return HttpResult.ok(responseEntity.getBody().getData());
//            }
//        }
//    }
    /**
     * 查询体检套餐
     * @param request
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/webPackSetViewList")
    @ResponseBody
    public HttpResult webPackSetViewList(HttpServletRequest request){
//        return HttpResult.error(500,"敬请期待！");
        String token = request.getHeader("token");
        if(token==null||token.equals("")){
            return HttpResult.error(401,"用户未登录");
        }else{
            String id =  JwtTokenUtils.getIdFromToken(token);
            if(id==null||id.equals("")){
                return HttpResult.error(401,"请先注册");
            }else{
                String url = PropertiesUtils.WEB_PACK_SET_VIEW_LIST;
                ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, id, HttpResult.class);
                System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
                return HttpResult.ok(responseEntity.getBody().getData());
            }
        }
    }
    /**
     * 预约体检
     */

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/checkUpOrder")
    @ResponseBody
    public HttpResult checkUpOrder(HttpServletRequest request ,@RequestBody CheckUpOrderVo checkUpOrderVo){
        System.out.println(checkUpOrderVo);
        if(checkUpOrderVo.getSetCode() == null || checkUpOrderVo.getSetCode().equals("")){
            return  HttpResult.error(500,"套餐号不能为空");
        }
        if(checkUpOrderVo.getAppointsDate() == null ){
            return  HttpResult.error(500,"预约时间不能为空");
        }
        String token = request.getHeader("token");
        if(token==null||token.equals("")){
            return HttpResult.error(401,"用户未登录");
        }else{
            String id =  JwtTokenUtils.getIdFromToken(token);
            CheckUpOrderVo1 checkUpOrderVo1 = new CheckUpOrderVo1();
            checkUpOrderVo1.setId(id);
            if(checkUpOrderVo.getId() == null || checkUpOrderVo.getId().equals("")){
                return HttpResult.error(500, "预约失败，请联系客服咨询处理");
            }else{
                String check_up_order = PropertiesUtils.CHECK_UP_ORDER;
                checkUpOrderVo1.setAppointId(checkUpOrderVo.getId());
                checkUpOrderVo1.setSetCode(checkUpOrderVo.getSetCode());
                checkUpOrderVo1.setAppointsDate(checkUpOrderVo.getAppointsDate());
                ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(check_up_order, checkUpOrderVo1, HttpResult.class);
                if(responseEntity.getBody().getCode() == 200){
                    return HttpResult.ok(responseEntity.getBody().getMsg());
                }else{
                    return HttpResult.error(responseEntity.getBody().getCode(), responseEntity.getBody().getMsg());
                }
            }
        }
    }

}
