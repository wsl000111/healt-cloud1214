package com.healt.cloud.pdf.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.healt.cloud.checkup.entity.HcPersonInfo;
import com.healt.cloud.checkup.entity.WebUserInfo;
import com.healt.cloud.checkup.entity.WebUserInfoBind;
import com.healt.cloud.checkup.service.HcPersonInfoService;
import com.healt.cloud.checkup.service.WebUserInfoBindService;
import com.healt.cloud.checkup.service.WebUserInfoService;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.FirstLetterUtils;
import com.healt.cloud.common.utils.IDCardUtils;
import com.healt.cloud.pdf.entity.SaveHcPersonDictListVo;
import com.healt.cloud.pdf.entity.SaveHcPersonDictVo;
import com.healt.cloud.pdf.entity.WebUserInfoVo;
import com.healt.cloud.pdf.http.HttpResult;
import com.healt.cloud.pdf.service.MyWebUserInfoService;
import com.healt.cloud.pdf.utils.PropertiesUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@AllArgsConstructor
@RequestMapping("/bind")
public class BindPersonController {

    private RestTemplate restTemplate;

    private WebUserInfoService webUserInfoService;

    private HcPersonInfoService hcPersonInfoService;

    private MyWebUserInfoService myWebUserInfoService;

    private WebUserInfoBindService webUserInfoBindService;


    @RequestMapping(method = RequestMethod.POST, value = "/addBindPerson")
    @ResponseBody
    public HttpResult addBindPerson(HttpServletRequest request ,@RequestBody WebUserInfoVo webUserInfoVo) {
        //判断绑定人数量
        if(!this.canBind(webUserInfoVo.getId())){
            return HttpResult.error(500,"您最多可以绑定5人");
        }
        //将身份证号最后一位大写
        webUserInfoVo.setIdNo(webUserInfoVo.getIdNo().toUpperCase());
        //先在WEB_USER_INFO_BIND表中查询是否存有此人信息，若有，说明已经绑定过，不进行绑定操作
        //根据id查询公众号注册表，比对身份证号，防止绑定自己
        LambdaQueryWrapper<WebUserInfo> webUserInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webUserInfoLambdaQueryWrapper.eq(WebUserInfo::getId, webUserInfoVo.getId());
        List<WebUserInfo> webUserInfoList = webUserInfoService.list(webUserInfoLambdaQueryWrapper);
        if(webUserInfoList.size()>0){
            if(webUserInfoList.get(0).getIdNo().equals(webUserInfoVo.getIdNo())){
                return HttpResult.error(500,"您无需绑定自己！");
            }
        }

        WebUserInfoBind webUserInfoBind = new WebUserInfoBind();
        //根据身份证号和绑定ID查询绑定表，如果已经绑定过，判断姓名是否一致, 不一致，提示，一致，直接返回成功
        LambdaQueryWrapper<WebUserInfoBind> webUserInfoBindLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webUserInfoBindLambdaQueryWrapper.eq(WebUserInfoBind::getBindId, webUserInfoVo.getId());
        webUserInfoBindLambdaQueryWrapper.eq(WebUserInfoBind::getIdNo, webUserInfoVo.getIdNo());

        List<WebUserInfoBind> webUserInfoBinds = webUserInfoBindService.list(webUserInfoBindLambdaQueryWrapper);
        //已经绑定过此人
        if(webUserInfoBinds.size()>0){
            if(!webUserInfoVo.getUserName().equals(webUserInfoBinds.get(0).getUserName())){
                return HttpResult.error(500,"请核对身份证号和姓名是否正确！");
            }else{
                return HttpResult.ok("绑定成功");
            }
        }
        //如果没有绑定过此人，进行绑定
        else {
            //判断体检系统是否建档
            LambdaQueryWrapper<HcPersonInfo> hcPersonInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            hcPersonInfoLambdaQueryWrapper.eq(HcPersonInfo::getIdNo, webUserInfoVo.getIdNo());
            List<HcPersonInfo> hcPersonInfoList = hcPersonInfoService.list(hcPersonInfoLambdaQueryWrapper);
            //体检系统未建档
            if(hcPersonInfoList.isEmpty()){
                SaveHcPersonDictListVo saveHcPersonDictListVo = new SaveHcPersonDictListVo();
                SaveHcPersonDictVo saveHcPersonDictVo  = new SaveHcPersonDictVo();
                HcPersonInfo hcPersonInfo = new HcPersonInfo();
                hcPersonInfo.setHospitalId("0001");
                hcPersonInfo.setUnitId("0000");
                hcPersonInfo.setUnitName("个人体检");
                hcPersonInfo.setIdNo(webUserInfoVo.getIdNo());
                hcPersonInfo.setName(webUserInfoVo.getUserName());
                hcPersonInfo.setMobile(webUserInfoVo.getPhoneNo());
                hcPersonInfo.setSex(IDCardUtils.getSex(webUserInfoVo.getIdNo()));
                hcPersonInfo.setInputCode(FirstLetterUtils.getFirstLetter(webUserInfoVo.getUserName()).toUpperCase());
                hcPersonInfo.setBarthday(DateUtils.parseString(IDCardUtils.getBirthday(webUserInfoVo.getIdNo()), "yyyy-MM-dd"));
                hcPersonInfo.setUserId("wxgzh");
                hcPersonInfo.setUserName("微信公众号");
                saveHcPersonDictVo.setStat("add");
                List<HcPersonInfo> hcPersonInfos = new ArrayList<>();
                hcPersonInfos.add(hcPersonInfo);
                saveHcPersonDictVo.setHcPersonInfo(hcPersonInfos);
                List<SaveHcPersonDictVo> saveHcPersonDictList = new ArrayList<>();
                saveHcPersonDictList.add(saveHcPersonDictVo);
                saveHcPersonDictListVo.setSaveHcPersonDictList(saveHcPersonDictList);
                //调用his建档方法
                String url = PropertiesUtils.SAVE_PERSON_DICT_LIST;
                ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, saveHcPersonDictListVo, HttpResult.class);
                //如果his建档成功，公众号建档
                if(responseEntity.getBody().getCode() == 200){
                    //查询体检建档信息，获取personId，保存到webuserinfobind表中
                    LambdaQueryWrapper<HcPersonInfo> hcPersonInfoLambdaQueryWrapper1 = new LambdaQueryWrapper<>();
                    hcPersonInfoLambdaQueryWrapper1.eq(HcPersonInfo::getIdNo, webUserInfoVo.getIdNo());
                    List<HcPersonInfo> hcPersonInfoList1 = hcPersonInfoService.list(hcPersonInfoLambdaQueryWrapper);
                    webUserInfoBind.setId(UUID.randomUUID().toString());
                    webUserInfoBind.setInsertDate(new Date());
                    webUserInfoBind.setIdNo(webUserInfoVo.getIdNo());
                    webUserInfoBind.setUserName(webUserInfoVo.getUserName());
                    webUserInfoBind.setPhoneNo(hcPersonInfoList1.get(0).getMobile());
                    webUserInfoBind.setPersonId(hcPersonInfoList1.get(0).getPersonId());
                    webUserInfoBind.setBindId(webUserInfoVo.getId());
                    webUserInfoBind.setRelationShip(webUserInfoVo.getRelationShip());
                    try {
                        webUserInfoBindService.save(webUserInfoBind);
                    } catch (Exception e) {
                        return HttpResult.error(401, "绑定用户失败");
                    }
                    return HttpResult.ok(webUserInfoBind);
                }else{//平台验证返回的错误为500时，一般情况下为身份证号与姓名不匹配
                    return HttpResult.error(500,"请核对身份证号和姓名是否正确！");
                }
            }else {//体检系统已经建档，直接公众号建档
                webUserInfoBind.setId(UUID.randomUUID().toString());
                webUserInfoBind.setInsertDate(new Date());
                webUserInfoBind.setIdNo(webUserInfoVo.getIdNo());
                webUserInfoBind.setUserName(webUserInfoVo.getUserName());
                webUserInfoBind.setPhoneNo(hcPersonInfoList.get(0).getMobile());
                webUserInfoBind.setPersonId(hcPersonInfoList.get(0).getPersonId());
                webUserInfoBind.setBindId(webUserInfoVo.getId());
                webUserInfoBind.setRelationShip(webUserInfoVo.getRelationShip());
                try {
                    webUserInfoBindService.save(webUserInfoBind);
                } catch (Exception e) {
                    return HttpResult.error(401, "绑定用户失败");
                }
                return HttpResult.ok(webUserInfoBind);
            }
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/selectBindPerson")
    @ResponseBody
    public HttpResult selectBindPerson(HttpServletRequest request ,@RequestBody String  id) {
        if(id == null || id.equals("")){
            return  HttpResult.error(500,"请登录");
        }
        //查询绑定表
        LambdaQueryWrapper<WebUserInfoBind> webUserInfoBindLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webUserInfoBindLambdaQueryWrapper.eq(WebUserInfoBind::getBindId, id);
        List<WebUserInfoBind> webUserInfoBinds = webUserInfoBindService.list(webUserInfoBindLambdaQueryWrapper);

        return HttpResult.ok(webUserInfoBinds);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteBindPerson")
    @ResponseBody
    public HttpResult deleteBindPerson(HttpServletRequest request ,@RequestBody WebUserInfoVo webUserInfoVo) {
        LambdaQueryWrapper<WebUserInfoBind> webUserInfoBindLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webUserInfoBindLambdaQueryWrapper.eq(WebUserInfoBind::getId, webUserInfoVo.getBindId());
        webUserInfoBindLambdaQueryWrapper.eq(WebUserInfoBind::getBindId, webUserInfoVo.getId());
        if(webUserInfoBindService.remove(webUserInfoBindLambdaQueryWrapper)){
            return HttpResult.ok("解绑成功");
        }
        return HttpResult.error(500,"解绑失败");
    }

    /**
     * 查询bindId，最多只能绑五个人
     */
    private boolean bindIdCount(String bindId){
        LambdaQueryWrapper<WebUserInfo> webUserInfoIdLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webUserInfoIdLambdaQueryWrapper.eq(WebUserInfo::getBindId, bindId);
        List<WebUserInfo> webUserInfoList = webUserInfoService.list(webUserInfoIdLambdaQueryWrapper);
        if(webUserInfoList.size() >= 5){
            return false;
        }else {
            return true;
        }
    }

    private boolean canBind(String id){
        LambdaQueryWrapper<WebUserInfoBind> webUserInfoBindLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webUserInfoBindLambdaQueryWrapper.eq(WebUserInfoBind::getBindId, id);
        long count = webUserInfoBindService.count(webUserInfoBindLambdaQueryWrapper);
        if(count>5){
            return false;
        }else{
            return true;
        }
    }


}
