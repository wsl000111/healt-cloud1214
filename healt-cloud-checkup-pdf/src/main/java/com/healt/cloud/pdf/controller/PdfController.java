package com.healt.cloud.pdf.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.FirstLetterUtils;
import com.healt.cloud.common.utils.IDCardUtils;
import com.healt.cloud.pdf.entity.*;
import com.healt.cloud.pdf.http.HttpResult;
import com.healt.cloud.pdf.service.MyWebUserInfoService;
import com.healt.cloud.pdf.utils.PdfUtils;
import com.healt.cloud.pdf.utils.PropertiesUtils;
import com.healt.cloud.pdf.utils.StringReplaceUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author GuYue
 * @date 2022-09-16 8:50
 * @description: TODO
 */
@Controller
@AllArgsConstructor
@RequestMapping("/pdf")
public class PdfController {

    private RestTemplate restTemplate;

    private HcPersonReportPdfService hcPersonReportPdfService;

    private HcPersonVisitInfoService hcPersonVisitInfoService;

    private HcPersonInfoService hcPersonInfoService;

    private WebUserInfoService webUserInfoService;

    private MyWebUserInfoService myWebUserInfoService;

    private WebPersonOrdersService webPersonOrdersService;

    private HcPackSetDictService hcPackSetDictService;

    private HcItemPackDictService hcItemPackDictService;

    private HcSetVsPackDictService hcSetVsPackDictService;

    private WebPackSetViewService webPackSetViewService;

    private DepartDictService departDictService;

    private WebUserInfoBindService webUserInfoBindService;

    private WebSetVsUnitService webSetVsUnitService;

    @RequestMapping(method = RequestMethod.POST, value = "/uploadPdf")
    @ResponseBody
    public HttpResult uploadPdf(@RequestBody UploadPdfVo uploadPdfVo) {
        String url = PropertiesUtils.URL + "/reportCenter/pdfReportList/" + uploadPdfVo.getPersonId() + "/" + uploadPdfVo.getVisitId();
        HttpResult httpResult = restTemplate.getForObject(url, HttpResult.class);
        Object obj = httpResult.getData();
        if (obj != null) {
            try {
                List<LinkedHashMap<String, Object>> linkedHashMapList = (List<LinkedHashMap<String, Object>>) obj;
                System.out.println(linkedHashMapList);
                //List<PersonPdfReportVo> otherPdfList = (List<PersonPdfReportVo>) obj;
                List<InputStream> sourcesList = new ArrayList();
                //System.out.println(uploadPdfVo);
                InputStream inputStream = new ByteArrayInputStream(uploadPdfVo.getArraryByte());
                sourcesList.add(inputStream);
                for (LinkedHashMap<String, Object> linkedHashMap : linkedHashMapList) {
                    String pdfUrl = linkedHashMap.get("REPORT_URL").toString();
                    System.out.println(pdfUrl);
                    if(StringUtils.isEmpty(pdfUrl)){
                        continue;
                    }
                    sourcesList.add(PdfUtils.getInputStreamByUrl(pdfUrl));
                }

                //查询体检签到日期
                LambdaQueryWrapper<HcPersonVisitInfo> hcPersonVisitInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
                hcPersonVisitInfoLambdaQueryWrapper.eq(HcPersonVisitInfo::getPersonId, uploadPdfVo.getPersonId());
                hcPersonVisitInfoLambdaQueryWrapper.eq(HcPersonVisitInfo::getPersonVisitId, uploadPdfVo.getVisitId());
                List<HcPersonVisitInfo> hcPersonVisitInfos = hcPersonVisitInfoService.list(hcPersonVisitInfoLambdaQueryWrapper);
                Date beforeDate = hcPersonVisitInfos.get(0).getBeforeDate();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(beforeDate);
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH)+1;
                int day = calendar.get(Calendar.DATE);

                String targetPath = "D:\\pdf\\"+ year + "\\"+ month + "\\"+ day + "\\" + uploadPdfVo.getPersonId() + "\\";
                String id = UUID.randomUUID().toString();
                String fileName = uploadPdfVo.getPersonId()+"_"+uploadPdfVo.getVisitId() + ".pdf";
                PdfUtils.mulFile2One(sourcesList, targetPath, fileName);

                //根据pid,vid查询是否有记录
                LambdaQueryWrapper<HcPersonReportPdf> hcPersonReportPdfLambdaQueryWrapper = new LambdaQueryWrapper<>();
                hcPersonReportPdfLambdaQueryWrapper.eq(HcPersonReportPdf::getPersonId, uploadPdfVo.getPersonId());
                hcPersonReportPdfLambdaQueryWrapper.eq(HcPersonReportPdf::getPersonVisitId, uploadPdfVo.getVisitId());
                List<HcPersonReportPdf> hcPersonReportPdfList = hcPersonReportPdfService.list(hcPersonReportPdfLambdaQueryWrapper);
                if(hcPersonReportPdfList!=null&&hcPersonReportPdfList.size()>0){//已有记录先删除，在新增
                    LambdaUpdateWrapper<HcPersonReportPdf> hcPersonReportPdfLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//                    hcPersonReportPdfLambdaUpdateWrapper.set(HcPersonReportPdf::getPdfUrl, targetPath + fileName);
//                    hcPersonReportPdfLambdaUpdateWrapper.set(HcPersonReportPdf::getInsertDate, new Date());
//                    hcPersonReportPdfLambdaUpdateWrapper.set(HcPersonReportPdf::getId, id);
                    hcPersonReportPdfLambdaUpdateWrapper.eq(HcPersonReportPdf::getPersonId, uploadPdfVo.getPersonId());
                    hcPersonReportPdfLambdaUpdateWrapper.eq(HcPersonReportPdf::getPersonVisitId, uploadPdfVo.getVisitId());
                    hcPersonReportPdfService.remove(hcPersonReportPdfLambdaUpdateWrapper);

                    HcPersonReportPdf hcPersonReportPdf = new HcPersonReportPdf();
                    hcPersonReportPdf.setId(id);
                    hcPersonReportPdf.setPersonId(uploadPdfVo.getPersonId());
                    hcPersonReportPdf.setPersonVisitId(uploadPdfVo.getVisitId());
                    hcPersonReportPdf.setInsertDate(new Date());
                    hcPersonReportPdf.setPdfUrl(targetPath + fileName);
                    hcPersonReportPdf.setBeforeDate(hcPersonVisitInfos.get(0).getBeforeDate());
                    hcPersonReportPdf.setPersonType(hcPersonVisitInfos.get(0).getUnitId().equals("0000")?"个人":"团体");
                    hcPersonReportPdfService.save(hcPersonReportPdf);
                }else{//新增
                    //将路径存储到数据库
                    HcPersonReportPdf hcPersonReportPdf = new HcPersonReportPdf();
                    hcPersonReportPdf.setId(id);
                    hcPersonReportPdf.setPersonId(uploadPdfVo.getPersonId());
                    hcPersonReportPdf.setPersonVisitId(uploadPdfVo.getVisitId());
                    hcPersonReportPdf.setInsertDate(new Date());
                    hcPersonReportPdf.setPdfUrl(targetPath + fileName);
                    hcPersonReportPdf.setBeforeDate(hcPersonVisitInfos.get(0).getBeforeDate());
                    hcPersonReportPdf.setPersonType(hcPersonVisitInfos.get(0).getUnitId().equals("0000")?"个人":"团体");
                    hcPersonReportPdfService.saveOrUpdate(hcPersonReportPdf);
                }

            } catch (Exception e) {
                e.printStackTrace();
                return HttpResult.error("pdf生成失败!"+e.getMessage());
            }
        }
        return HttpResult.ok();
    }

    /**
     * 查询个人报告
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/personReportList")
    @ResponseBody
    public HttpResult personReportList(@RequestBody String id) {
        //通过token中的id去 HEALTHCHECKUP.WEB_USER_INFO表里查用户信息
        LambdaQueryWrapper<WebUserInfo> webUserInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webUserInfoLambdaQueryWrapper.eq(WebUserInfo::getId, id);
        List<WebUserInfo> webUserInfoVo = webUserInfoService.list(webUserInfoLambdaQueryWrapper);
        if(null==webUserInfoVo||webUserInfoVo.size()==0){
            return HttpResult.error(401,"未查询到该用户，请先注册");
        }else{
            LambdaQueryWrapper<HcPersonInfo> hcPersonInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            hcPersonInfoLambdaQueryWrapper.eq(HcPersonInfo::getIdNo, webUserInfoVo.get(0).getIdNo());
            List<HcPersonInfo> hcPersonInfoList = hcPersonInfoService.list(hcPersonInfoLambdaQueryWrapper);
            if(null==hcPersonInfoList||hcPersonInfoList.size()==0){
                return HttpResult.error(401,"未查询到该用户，请先注册");
            }else {
                String personId = hcPersonInfoList.get(0).getPersonId();
                String idNo = StringReplaceUtil.idCardReplaceWithStar(webUserInfoVo.get(0).getIdNo());
                LambdaQueryWrapper<HcPersonReportPdf> hcPersonReportPdfLambdaQueryWrapper = new LambdaQueryWrapper<>();
                hcPersonReportPdfLambdaQueryWrapper.eq(HcPersonReportPdf::getPersonId, personId);
                hcPersonReportPdfLambdaQueryWrapper.orderByDesc(HcPersonReportPdf::getBeforeDate);
                hcPersonReportPdfLambdaQueryWrapper.orderByDesc(HcPersonReportPdf::getInsertDate);
                List<HcPersonReportPdf> hcPersonReportPdfList = hcPersonReportPdfService.list(hcPersonReportPdfLambdaQueryWrapper);
                List<PersonReportListResVo> personReportListResVos = new ArrayList();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                HcPersonReportPdf hcPersonReportPdfCache = new HcPersonReportPdf();
                for (HcPersonReportPdf hcPersonReportPdf : hcPersonReportPdfList) {
                    if(hcPersonReportPdf.getPersonId().equals(hcPersonReportPdfCache.getPersonId())&&
                            hcPersonReportPdf.getPersonVisitId().equals(hcPersonReportPdfCache.getPersonVisitId())){
                        continue;
                    }
                    PersonReportListResVo personReportListResVo = new PersonReportListResVo();
                    personReportListResVo.setName(webUserInfoVo.get(0).getUserName());
                    personReportListResVo.setIdNo(StringReplaceUtil.idCardReplaceWithStar(idNo));
                    personReportListResVo.setPersonId(hcPersonReportPdf.getPersonId());
                    personReportListResVo.setPersonVisitId(hcPersonReportPdf.getPersonVisitId());
                    personReportListResVo.setInsertDate(df1.format(hcPersonReportPdf.getInsertDate()));
                    personReportListResVo.setBeforeDate(df.format(hcPersonReportPdf.getBeforeDate()));
                    personReportListResVo.setPersonType(hcPersonReportPdf.getPersonType());
                    personReportListResVos.add(personReportListResVo);
                    hcPersonReportPdfCache = hcPersonReportPdf;
                }
                System.out.println(personReportListResVos);
                return HttpResult.ok(personReportListResVos);
            }
        }
    }

    /**
     * 查询个人报告
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/personReportListBind")
    @ResponseBody
    public HttpResult personReportListBind(@RequestBody String id) {
        //查询WEB_USER_INFO_BIND表里查用户信息
        LambdaQueryWrapper<WebUserInfoBind> webUserInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webUserInfoLambdaQueryWrapper.eq(WebUserInfoBind::getId, id);
        List<WebUserInfoBind> webUserInfoVo = webUserInfoBindService.list(webUserInfoLambdaQueryWrapper);
        if(null==webUserInfoVo||webUserInfoVo.size()==0){
            return HttpResult.error(500,"未查询到该体检人");
        }else{
            LambdaQueryWrapper<HcPersonInfo> hcPersonInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            hcPersonInfoLambdaQueryWrapper.eq(HcPersonInfo::getIdNo, webUserInfoVo.get(0).getIdNo());
            List<HcPersonInfo> hcPersonInfoList = hcPersonInfoService.list(hcPersonInfoLambdaQueryWrapper);
            if(null==hcPersonInfoList||hcPersonInfoList.size()==0){
                return HttpResult.error(500,"未查询到该用户，请先注册");
            }else {
                String personId = hcPersonInfoList.get(0).getPersonId();
                String idNo = StringReplaceUtil.idCardReplaceWithStar(webUserInfoVo.get(0).getIdNo());
                LambdaQueryWrapper<HcPersonReportPdf> hcPersonReportPdfLambdaQueryWrapper = new LambdaQueryWrapper<>();
                hcPersonReportPdfLambdaQueryWrapper.eq(HcPersonReportPdf::getPersonId, personId);
                hcPersonReportPdfLambdaQueryWrapper.orderByDesc(HcPersonReportPdf::getBeforeDate);
                hcPersonReportPdfLambdaQueryWrapper.orderByDesc(HcPersonReportPdf::getInsertDate);
                List<HcPersonReportPdf> hcPersonReportPdfList = hcPersonReportPdfService.list(hcPersonReportPdfLambdaQueryWrapper);
                List<PersonReportListResVo> personReportListResVos = new ArrayList();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                HcPersonReportPdf hcPersonReportPdfCache = new HcPersonReportPdf();
                for (HcPersonReportPdf hcPersonReportPdf : hcPersonReportPdfList) {
                    if(hcPersonReportPdf.getPersonId().equals(hcPersonReportPdfCache.getPersonId())&&
                            hcPersonReportPdf.getPersonVisitId().equals(hcPersonReportPdfCache.getPersonVisitId())){
                        continue;
                    }
                    PersonReportListResVo personReportListResVo = new PersonReportListResVo();
                    personReportListResVo.setName(webUserInfoVo.get(0).getUserName());
                    personReportListResVo.setIdNo(StringReplaceUtil.idCardReplaceWithStar(idNo));
                    personReportListResVo.setPersonId(hcPersonReportPdf.getPersonId());
                    personReportListResVo.setPersonVisitId(hcPersonReportPdf.getPersonVisitId());
                    personReportListResVo.setInsertDate(df1.format(hcPersonReportPdf.getInsertDate()));
                    personReportListResVo.setBeforeDate(df.format(hcPersonReportPdf.getBeforeDate()));
                    personReportListResVo.setPersonType(hcPersonReportPdf.getPersonType());
                    personReportListResVos.add(personReportListResVo);
                    hcPersonReportPdfCache = hcPersonReportPdf;
                }
                System.out.println(personReportListResVos);
                return HttpResult.ok(personReportListResVos);
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/downloadPdfFile")
    @ResponseBody
    public String downloadPdfFile(@RequestParam("personId") String personId, @RequestParam("personVisitId") String personVisitId) {
        LambdaQueryWrapper<HcPersonReportPdf> hcPersonReportPdfLambdaQueryWrapper = new LambdaQueryWrapper<>();
        hcPersonReportPdfLambdaQueryWrapper.eq(HcPersonReportPdf::getPersonId, personId);
        hcPersonReportPdfLambdaQueryWrapper.eq(HcPersonReportPdf::getPersonVisitId, personVisitId);
        hcPersonReportPdfLambdaQueryWrapper.orderByDesc(HcPersonReportPdf::getInsertDate);
        List<HcPersonReportPdf> hcPersonReportPdfList = hcPersonReportPdfService.list(hcPersonReportPdfLambdaQueryWrapper);
        byte[] fileBytes = null;
        String result = null;
        if (hcPersonReportPdfList.size() > 0) {
            String pdfUrl = hcPersonReportPdfList.get(0).getPdfUrl();
            File file = new File(pdfUrl);
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                fileBytes = new byte[(int) file.length()];
                fis.read(fileBytes);
                result = Base64Utils.encodeToString(fileBytes);
            } catch (Exception e) {
                fileBytes = new byte[]{};
            } finally {
                if (null != fis) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testUploadPdf")
    @ResponseBody
    public HttpResult testUploadPdf() {
        try {
            List<String> otherPdfList = new ArrayList<>();
            otherPdfList.add("http://www.leomay.com/upload/file/mmo-20170707165001.pdf");
            otherPdfList.add("http://www.leomay.com/upload/file/mmo-20170707165001.pdf");
            List<InputStream> sourcesList = new ArrayList();

            for (String pdfUrl : otherPdfList) {
                sourcesList.add(PdfUtils.getInputStreamByUrl(pdfUrl));
            }
            String targetPath = "D:\\pdf\\123123\\223423\\";
            String fileName = UUID.randomUUID() + ".pdf";
            PdfUtils.mulFile2One(sourcesList, targetPath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return HttpResult.ok();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    public HttpResult login(@RequestBody WebUserInfoVo webUserInfoVo) {
        //先在WEB_USER_INFO表中查询是否存有此人信息，若有，验证手机号是否与数据库数据相同
        LambdaQueryWrapper<WebUserInfo> webUserInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webUserInfoLambdaQueryWrapper.eq(WebUserInfo::getPhoneNo, webUserInfoVo.getPhoneNo());
        List<WebUserInfo> webUserInfoList = webUserInfoService.list(webUserInfoLambdaQueryWrapper);
        if (webUserInfoList.isEmpty()) {
            return HttpResult.error(500,"请先注册");
        } else {
            return HttpResult.ok(webUserInfoList.get(0).getId());
        }

    }
    /**
     * 注册：一个手机号只能注册一个用户，首先根据手机号查询WebUserInfo表，是否有记录，有记录说明已经注册过，提示该手机号无法注册
     *
     */
    @RequestMapping(method = RequestMethod.POST, value = "/regeist")
    @ResponseBody
    public HttpResult regeist(@RequestBody WebUserInfoVo webUserInfoVo) {
        WebUserInfo webUserInfo = new WebUserInfo();
        //根据手机号查询公众号是否建档
        LambdaQueryWrapper<WebUserInfo> webUserInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //webUserInfoLambdaQueryWrapper.eq(WebUserInfo::getIdNo, webUserInfoVo.getIdNo());
        webUserInfoLambdaQueryWrapper.eq(WebUserInfo::getPhoneNo, webUserInfoVo.getPhoneNo());
        List<WebUserInfo> webUserInfoList = webUserInfoService.list(webUserInfoLambdaQueryWrapper);
        //公众号已经建档，说明手机号已经注册过
        if(webUserInfoList.size()>0){
            return HttpResult.error(500,"此手机号码已经注册，请您直接登陆");
        }else{//公众号没有建档
            //将身份证号最后一位大写
            webUserInfoVo.setIdNo(webUserInfoVo.getIdNo().toUpperCase());
            //去HcPersonInfo表里查，看是否需要建档
            LambdaQueryWrapper<HcPersonInfo> hcPersonInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            hcPersonInfoLambdaQueryWrapper.eq(HcPersonInfo::getIdNo, webUserInfoVo.getIdNo());
            List<HcPersonInfo> hcPersonInfoList = hcPersonInfoService.list(hcPersonInfoLambdaQueryWrapper);
            if(hcPersonInfoList.isEmpty()){ //体检系统未建档
                //去HcPersonInfo表中建档
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

                String url = PropertiesUtils.SAVE_PERSON_DICT_LIST;
                ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, saveHcPersonDictListVo, HttpResult.class);
                if(responseEntity.getBody().getCode() == 500){
                    return HttpResult.error(500, "请核对身份证号和姓名是否正确!");
                }
                if(responseEntity.getBody().getCode() == 200){
                    //再查一遍信息，保存到webuserinfo表中
                    LambdaQueryWrapper<HcPersonInfo> hcPersonInfoLambdaQueryWrapper1 = new LambdaQueryWrapper<>();
                    hcPersonInfoLambdaQueryWrapper1.eq(HcPersonInfo::getIdNo, webUserInfoVo.getIdNo());
                    List<HcPersonInfo> hcPersonInfoList1 = hcPersonInfoService.list(hcPersonInfoLambdaQueryWrapper);
                    webUserInfo.setId(UUID.randomUUID().toString());
                    webUserInfo.setInsertDate(new Date());
                    webUserInfo.setIdNo(webUserInfoVo.getIdNo());
                    //用不用写正则判断是否为空
                    webUserInfo.setUserName(webUserInfoVo.getUserName());
                    webUserInfo.setPhoneNo(webUserInfoVo.getPhoneNo());
                    webUserInfo.setPersonId(hcPersonInfoList1.get(0).getPersonId());
                    try {
                        myWebUserInfoService.save(webUserInfo);
                    } catch (Exception e) {
                        return HttpResult.error(500, "注册用户失败");
                    }
                    LambdaQueryWrapper<WebUserInfo> webUserInfoIdLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    webUserInfoIdLambdaQueryWrapper.eq(WebUserInfo::getIdNo, webUserInfoVo.getIdNo());
                    List<WebUserInfo> webUserInfoList1 = webUserInfoService.list(webUserInfoIdLambdaQueryWrapper);
                    return HttpResult.ok(webUserInfoList1.get(0));
                }else{
                    return HttpResult.error(500,"注册用户失败");
                }
            }else { //身份证号已建档，判断姓名是否相同
                webUserInfo.setId(UUID.randomUUID().toString());
                webUserInfo.setInsertDate(new Date());
                webUserInfo.setIdNo(webUserInfoVo.getIdNo());
                webUserInfo.setUserName(webUserInfoVo.getUserName());
                webUserInfo.setPhoneNo(webUserInfoVo.getPhoneNo());
                webUserInfo.setPersonId(hcPersonInfoList.get(0).getPersonId());
                webUserInfo.setRelationShip("本人");
                if(!hcPersonInfoList.get(0).getName().equals(webUserInfoVo.getUserName())){
                    return HttpResult.error(500, "请核对身份证号和姓名是否正确!");
                }
                try {
                    myWebUserInfoService.save(webUserInfo);
                    LambdaQueryWrapper<WebUserInfo> webUserInfoIdLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    webUserInfoIdLambdaQueryWrapper.eq(WebUserInfo::getIdNo, webUserInfoVo.getIdNo());
                    List<WebUserInfo> webUserInfoList1 = webUserInfoService.list(webUserInfoIdLambdaQueryWrapper);
                    return HttpResult.ok(webUserInfoList1.get(0));
                } catch (Exception e) {
                    return HttpResult.error(500, "注册用户失败");
                }
            }
        }
//        else{//公众号已建档
//            WebUserInfo webUserInfo1 = webUserInfoList.get(0);
//            if(!webUserInfo1.getUserName().equals(webUserInfoVo.getUserName())){
//                return HttpResult.error(500, "请核对身份证号和姓名是否正确!");
//            }
//            return HttpResult.ok(webUserInfoList.get(0));
//        }
    }

    /**
     * 根据id查询首页展示信息
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/homePageInfo")
    @ResponseBody
    public HttpResult homePageInfo(@RequestBody String id) {
        LambdaQueryWrapper<WebUserInfo> webUserInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webUserInfoLambdaQueryWrapper.eq(WebUserInfo::getId, id);
        List<WebUserInfo> webUserInfoList = webUserInfoService.list(webUserInfoLambdaQueryWrapper);
        if(webUserInfoList.isEmpty()){
            return HttpResult.error(401, "请先注册！");
        }
        return HttpResult.ok(webUserInfoList.get(0));
    }

    /**
     * 查询订单信息
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/webPersonOrdersList")
    @ResponseBody
    public HttpResult personOrderList(@RequestBody String id) {
        //通过token中的id去 HEALTHCHECKUP.WEB_USER_INFO表里查用户信息
        LambdaQueryWrapper<WebUserInfo> webUserInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webUserInfoLambdaQueryWrapper.eq(WebUserInfo::getId, id);
        List<WebUserInfo> webUserInfoVo = webUserInfoService.list(webUserInfoLambdaQueryWrapper);
        if (webUserInfoVo.isEmpty()){//如果没查到
            return HttpResult.error(500,"未查询到该用户");
        }else{//如果查到了
            LambdaQueryWrapper<HcPersonInfo> hcPersonInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            hcPersonInfoLambdaQueryWrapper.eq(HcPersonInfo::getIdNo, webUserInfoVo.get(0).getIdNo());
            List<HcPersonInfo> hcPersonInfoList = hcPersonInfoService.list(hcPersonInfoLambdaQueryWrapper);
            if(hcPersonInfoList.isEmpty()){
                return HttpResult.error(500,"未查询到该用户");
            }else{
                LambdaQueryWrapper<WebPersonOrders> webPersonOrdersLambdaQueryWrapper = new LambdaQueryWrapper<>();
                webPersonOrdersLambdaQueryWrapper.eq(WebPersonOrders::getPersonId, hcPersonInfoList.get(0).getPersonId());
                webPersonOrdersLambdaQueryWrapper.orderByAsc(WebPersonOrders::getAppointsDate);
                List<WebPersonOrders> webPersonOrdersList = webPersonOrdersService.list(webPersonOrdersLambdaQueryWrapper);
                final Map<Integer,List<WebPersonOrders>> map = new HashMap<>();
                webPersonOrdersList.forEach(webPersonOrders -> {
                    List<WebPersonOrders> tempList = map.get(webPersonOrders.getPersonVisitId());
                    if(null==tempList||tempList.size()==0){
                        tempList = new ArrayList<>();
                    }
                    webPersonOrders.setIdNo(StringReplaceUtil.idCardReplaceWithStar(webPersonOrders.getIdNo()));
                    tempList.add(webPersonOrders);
                    map.put(webPersonOrders.getPersonVisitId(),tempList);
                });
                System.out.println(map);
                return HttpResult.ok(map);
            }
        }
    }

    /**
     * 查询订单信息
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/webPersonOrdersListBind")
    @ResponseBody
    public HttpResult personOrderListBind(@RequestBody String id) {
        //通过token中的id去 HEALTHCHECKUP.WEB_USER_INFO表里查用户信息
        LambdaQueryWrapper<WebUserInfoBind> webUserInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webUserInfoLambdaQueryWrapper.eq(WebUserInfoBind::getId, id);
        List<WebUserInfoBind> webUserInfoVo = webUserInfoBindService.list(webUserInfoLambdaQueryWrapper);
        if (webUserInfoVo.isEmpty()){//如果没查到
            return HttpResult.error(500,"未查询到该用户");
        }else{//如果查到了
            LambdaQueryWrapper<HcPersonInfo> hcPersonInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            hcPersonInfoLambdaQueryWrapper.eq(HcPersonInfo::getIdNo, webUserInfoVo.get(0).getIdNo());
            List<HcPersonInfo> hcPersonInfoList = hcPersonInfoService.list(hcPersonInfoLambdaQueryWrapper);
            if(hcPersonInfoList.isEmpty()){
                return HttpResult.error(500,"未查询到该用户");
            }else{
                LambdaQueryWrapper<WebPersonOrders> webPersonOrdersLambdaQueryWrapper = new LambdaQueryWrapper<>();
                webPersonOrdersLambdaQueryWrapper.eq(WebPersonOrders::getPersonId, hcPersonInfoList.get(0).getPersonId());
                webPersonOrdersLambdaQueryWrapper.orderByAsc(WebPersonOrders::getAppointsDate);
                List<WebPersonOrders> webPersonOrdersList = webPersonOrdersService.list(webPersonOrdersLambdaQueryWrapper);
                final Map<Integer,List<WebPersonOrders>> map = new HashMap<>();
                webPersonOrdersList.forEach(webPersonOrders -> {
                    List<WebPersonOrders> tempList = map.get(webPersonOrders.getPersonVisitId());
                    if(null==tempList||tempList.size()==0){
                        tempList = new ArrayList<>();
                    }
                    webPersonOrders.setIdNo(StringReplaceUtil.idCardReplaceWithStar(webPersonOrders.getIdNo()));
                    tempList.add(webPersonOrders);
                    map.put(webPersonOrders.getPersonVisitId(),tempList);
                });
                System.out.println(map);
                return HttpResult.ok(map);
            }
        }
    }

    /**
     * 查询体检套餐
     */
    @RequestMapping(method = RequestMethod.POST, value = "/webPackSetViewList")
    @ResponseBody
    public HttpResult webPackSetViewList(@RequestBody String id) {
        if(StringUtils.isEmpty(id)){
            HttpResult.error(401,"请先登录");
        }

        LambdaQueryWrapper<WebPackSetView> webPackSetViewListLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webPackSetViewListLambdaQueryWrapper.like(WebPackSetView::getSetName, "线上");
        List<WebPackSetView> webPackSetViewList = webPackSetViewService.list(webPackSetViewListLambdaQueryWrapper);
        for(WebPackSetView webPackSetView : webPackSetViewList){
            webPackSetView.setSetName(webPackSetView.getSetName().replace("线上", ""));
            System.out.println(webPackSetView.getSetName());
        }
        webPackSetViewListLambdaQueryWrapper.clear();
        webPackSetViewListLambdaQueryWrapper.like(WebPackSetView::getSetName, "富士康");
        List<WebPackSetView> webPackSetViewList1 = webPackSetViewService.list(webPackSetViewListLambdaQueryWrapper);
        for(WebPackSetView webPackSetView : webPackSetViewList1){
            webPackSetView.setSetName(webPackSetView.getSetName().replace("（50元）", "").replace("（50）", ""));
            webPackSetViewList.add(webPackSetView);
        }
        return HttpResult.ok(webPackSetViewList);
    }

    /**
     * 体检预约
     * 流程： 首先生成新的person_visit_id，拼装hc_person_visit_info信息，
     *      然后根据setCode查询套餐明细，拼装hc_person_appreg_items信息，
     *      注意个人预约和单位人员预约的区别
     *      新增预约时，先判断是否已有预约项目未签到（判断条件hc_person_visit_info中before_sign = 0）
     *      没签到不允许新增预约
     */
    @RequestMapping(method = RequestMethod.POST, value = "/checkUpOrder")
    @ResponseBody
    public HttpResult checkUpOrder(@RequestBody CheckUpOrderVo checkUpOrderVo) {
        System.out.println(checkUpOrderVo);
        SaveHcPersonVisitInfoListVo saveHcPersonVisitInfoList  = new SaveHcPersonVisitInfoListVo();
        List<SaveHcPersonVisitInfoVo> hcPersonVisitInfoVoList = new ArrayList<>();
        saveHcPersonVisitInfoList.setHcPersonVisitInfoVo(hcPersonVisitInfoVoList);
        SaveHcPersonVisitInfoVo saveHcPersonVisitInfoVo  = new SaveHcPersonVisitInfoVo();
        saveHcPersonVisitInfoVo.setStat("add");
        hcPersonVisitInfoVoList.add(saveHcPersonVisitInfoVo);
        List<HcPersonVisitInfo> hcPersonVisitInfoList = new ArrayList<>();
        List<HcPersonAppregItems> hcPersonAppregItemsList = new ArrayList<>();
        saveHcPersonVisitInfoVo.setHcPersonVisitInfo(hcPersonVisitInfoList);
        saveHcPersonVisitInfoVo.setHcPersonAppregItems(hcPersonAppregItemsList);
        //根据setCode查询套餐字典，通过setName判断是团检还是个检
        LambdaQueryWrapper<HcPackSetDict> hcPackSetDictLambdaQueryWrapper = new LambdaQueryWrapper<>();
        hcPackSetDictLambdaQueryWrapper.eq(HcPackSetDict::getSetCode, checkUpOrderVo.getSetCode());
        List<HcPackSetDict> hcPackSetDicts = hcPackSetDictService.list(hcPackSetDictLambdaQueryWrapper);
        if(hcPackSetDicts.size()==0){
            return HttpResult.error(500,"该套餐可能已下架！");
        }
        String setName = hcPackSetDicts.get(0).getSetName();
        String sex = hcPackSetDicts.get(0).getSex();
        String unitId = "0000";
        int unitVisitId = 0;
        String unitName = "";
        //根据套餐编码查询单位
        LambdaQueryWrapper<WebSetVsUnit> webSetVsUnitLambdaQueryWrapper = new LambdaQueryWrapper<>();
        webSetVsUnitLambdaQueryWrapper.eq(WebSetVsUnit::getSetCode, checkUpOrderVo.getSetCode());
        List<WebSetVsUnit> webSetVsUnitList = webSetVsUnitService.list(webSetVsUnitLambdaQueryWrapper);
        if(!webSetVsUnitList.isEmpty()){//非空表示团检套餐
            unitId = webSetVsUnitList.get(0).getUnitId();
            unitVisitId = 1;
            unitName = webSetVsUnitList.get(0).getUnitName();
        }
//        if(setName.contains("富士康协助单位")){
//            unitId = "1279";
//            unitVisitId = 1;
//            unitName = "富士康协助单位";
//        }else if(setName.contains("富士康入职")){
//            unitId = "580";
//            unitVisitId = 1;
//            unitName = "富士康入职";
//        }else if(setName.contains("富士康成人入职")){
//            unitId = "580";
//            unitVisitId = 1;
//            unitName = "富士康入职";
//        }
        String personId = "";
        String idNo = "";
        //本人预约
        if(checkUpOrderVo.getId().equals(checkUpOrderVo.getAppointId())){
            //根据id获取体检id
            LambdaQueryWrapper<WebUserInfo> webUserInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            webUserInfoLambdaQueryWrapper.eq(WebUserInfo::getId, checkUpOrderVo.getId());
            List<WebUserInfo> webUserInfoList = webUserInfoService.list(webUserInfoLambdaQueryWrapper);
            if(webUserInfoList.size()>0){
                personId = webUserInfoList.get(0).getPersonId();
                idNo = webUserInfoList.get(0).getIdNo();
            }else{
                return HttpResult.error(500,"预约失败！");
            }
        }else{//绑定人预约
            //根据bindId获取体检id
            LambdaQueryWrapper<WebUserInfoBind> webUserInfoBindLambdaQueryWrapper = new LambdaQueryWrapper<>();
            webUserInfoBindLambdaQueryWrapper.eq(WebUserInfoBind::getId, checkUpOrderVo.getAppointId());
            WebUserInfoBind webUserInfoBind = webUserInfoBindService.getOne(webUserInfoBindLambdaQueryWrapper);
            if(webUserInfoBind!=null){
                personId = webUserInfoBind.getPersonId();
                idNo = webUserInfoBind.getIdNo();
            }else{
                return HttpResult.error(500,"预约失败！");
            }
        }
        //根据身份证获取性别
        String idSex = IDCardUtils.getSex(idNo);
        //判断套餐性别限制
        //女性套餐时，如果idSex为男性，预约失败
        if("女".equals(sex)&&"男".equals(idSex)){
            return HttpResult.error(500,"该套餐为女性套餐！");
        }
        if("男".equals(sex)&&"女".equals(idSex)){
            return HttpResult.error(500,"该套餐为男性套餐！");
        }
        //查询hc_person_visit_info表是否有未签到的预约，有未完成的预约（before_sign = 0 未签到），不能新增预约
        LambdaQueryWrapper<HcPersonVisitInfo> hcPersonVisitInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        hcPersonVisitInfoLambdaQueryWrapper.eq(HcPersonVisitInfo::getPersonId, personId);
        hcPersonVisitInfoLambdaQueryWrapper.eq(HcPersonVisitInfo::getBeforeSign, "0");
        List<HcPersonVisitInfo> hcPersonVisitInfos = hcPersonVisitInfoService.list(hcPersonVisitInfoLambdaQueryWrapper);
        if(hcPersonVisitInfos.size()>0){//有未完成的预约
            return HttpResult.error(500,"您还有未完成的预约！");
        }
        //取最大体检次数
        String maxVisitId = "";
        QueryWrapper<HcPersonVisitInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", "0001");
        queryWrapper.eq("PERSON_ID", personId);
        queryWrapper.select("nvl(max(person_visit_id),0) MAX_PERSON_VISIT_ID");
        Map<String, Object> result = hcPersonVisitInfoService.getMap(queryWrapper);
        if(result != null){
            maxVisitId = (result.get("MAX_PERSON_VISIT_ID")).toString();
        }else{
            maxVisitId = "1";
        }
        //拼装hc_person_visit_info对象
        HcPersonVisitInfo hcPersonVisitInfo = new HcPersonVisitInfo();
        hcPersonVisitInfo.setHospitalId("0001");
        hcPersonVisitInfo.setPersonId(personId);
        hcPersonVisitInfo.setPersonVisitId(Integer.parseInt(maxVisitId)+1);
        hcPersonVisitInfo.setUnitId(unitId);
        hcPersonVisitInfo.setUnitVisitId(unitVisitId);
        hcPersonVisitInfo.setUnitName(unitName);
        hcPersonVisitInfo.setAppointsDate(DateUtils.parseString(checkUpOrderVo.getAppointsDate(), "yyyy-MM-dd hh:mm:ss"));
        hcPersonVisitInfo.setFinishedSign("0");
        int age = IDCardUtils.getAge(idNo);
        hcPersonVisitInfo.setAge(age);
        hcPersonVisitInfo.setResultStatus("0");
        hcPersonVisitInfo.setBuildDate(new Date());
        hcPersonVisitInfo.setUserId("wxgzh");
        hcPersonVisitInfo.setUserName("微信公众号");
        hcPersonVisitInfoList.add(hcPersonVisitInfo);

        //拼装 hc_Person_Appreg_Items
        //根据set_code查询套餐明细
        //1.查询套餐与组合对照表
        LambdaQueryWrapper<HcSetVsPackDict> setVsPackDictLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setVsPackDictLambdaQueryWrapper.eq(HcSetVsPackDict::getSetCode, checkUpOrderVo.getSetCode());
        List<HcSetVsPackDict> hcSetVsPackDictList = hcSetVsPackDictService.list(setVsPackDictLambdaQueryWrapper);
        for(HcSetVsPackDict hcSetVsPackDict : hcSetVsPackDictList){
            //2.根据对照表查询组合项目集合
            LambdaQueryWrapper<HcItemPackDict> hcItemPackDictLambdaQueryWrapper = new LambdaQueryWrapper<>();
            hcItemPackDictLambdaQueryWrapper.eq(HcItemPackDict::getItemPackCode, hcSetVsPackDict.getItemPackCode());
            HcItemPackDict hcItemPackDict = hcItemPackDictService.getOne(hcItemPackDictLambdaQueryWrapper);
            //3.拼装hcPersonAppregItems对象
            HcPersonAppregItems hcPersonAppregItems = new HcPersonAppregItems();
            hcPersonAppregItems.setHospitalId("0001");
            hcPersonAppregItems.setPersonId(personId);
            hcPersonAppregItems.setPersonVisitId(hcPersonVisitInfo.getPersonVisitId());
            hcPersonAppregItems.setUnitId(unitId);
            hcPersonAppregItems.setUnitVisitId(unitVisitId);
            hcPersonAppregItems.setItemPackCode(hcItemPackDict.getItemPackCode());
            hcPersonAppregItems.setItemPackName(hcItemPackDict.getItemPackName());
            hcPersonAppregItems.setRegisterDate(hcPersonVisitInfo.getAppointsDate());
            hcPersonAppregItems.setRegister("wxgzh");
            hcPersonAppregItems.setRegisterName("微信公众号");
            hcPersonAppregItems.setAddItem("0");
            hcPersonAppregItems.setChartCode(hcItemPackDict.getGuidegroupCode());
            hcPersonAppregItems.setCosts(hcItemPackDict.getItemPackPrice());
//            hcPersonAppregItems.setCharges(hcItemPackDict.getItemPackDiscountPrice());
            hcPersonAppregItems.setCharges(hcItemPackDict.getItemPackPrice());
            hcPersonAppregItems.setBillIndicator("0");
            hcPersonAppregItems.setFinishedSign("未完成");
            hcPersonAppregItems.setNum(new BigDecimal(1));
            if(StringUtils.isEmpty(hcSetVsPackDict.getItemNo())){
                hcPersonAppregItems.setItemNo(1);
            }else{
                hcPersonAppregItems.setItemNo(Integer.parseInt(hcSetVsPackDict.getItemNo()));
            }
            hcPersonAppregItems.setDeptId(hcItemPackDict.getHcDeptCode());
            LambdaQueryWrapper<DepartDict> departDictLambdaQueryWrapper = new LambdaQueryWrapper<>();
            departDictLambdaQueryWrapper.eq(DepartDict::getDeptId, hcItemPackDict.getHcDeptCode());
            List<DepartDict> departDictList = departDictService.list(departDictLambdaQueryWrapper);
            hcPersonAppregItems.setDeptName(departDictList.get(0).getDeptName());
            hcPersonAppregItemsList.add(hcPersonAppregItems);
        }
        //4.调用预约接口
        String url = PropertiesUtils.SAVE_PERSON_VISIT_INFO;
        ResponseEntity<HttpResult> responseEntity = restTemplate.postForEntity(url, saveHcPersonVisitInfoList, HttpResult.class);
        if(responseEntity.getBody().getCode() == 200){
            return HttpResult.ok("预约成功");
        }else{
            return HttpResult.error(500,"预约失败！");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/webPackSetList")
    @ResponseBody
    public HttpResult webPackSetList(){
        LambdaQueryWrapper<WebPackSetView> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(WebPackSetView::getIsDiscount, "1");
        queryWrapper.eq(WebPackSetView::getSetCode, "336");
        List<WebPackSetView> list = webPackSetViewService.list(queryWrapper);
        return HttpResult.ok(list);
    }
}
