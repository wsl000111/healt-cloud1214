package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.healt.cloud.checkup.entity.HcPersonInfo;
import com.healt.cloud.checkup.appointmentReg.mapper.PersonInfoMapper;
import com.healt.cloud.checkup.entity.HcPersonInfoErrlog;
import com.healt.cloud.checkup.service.HcPersonInfoErrlogService;
import com.healt.cloud.checkup.service.HcPersonInfoService;
import com.healt.cloud.checkup.appointmentReg.service.PersionInfoService;
import com.healt.cloud.checkup.service.ws.WebServiceClient;
import com.healt.cloud.checkup.service.ws.his.CodeTableItem;
import com.healt.cloud.checkup.service.ws.his.CreateArchiveResponse;
import com.healt.cloud.checkup.service.ws.his.archive.ArchiveCreateCardInfo;
import com.healt.cloud.checkup.service.ws.his.archive.ArchiveCreatePatientInfo;
import com.healt.cloud.checkup.vo.appointmentReg.hcPersonDict.HcPersonInfoVo;
import com.healt.cloud.checkup.vo.appointmentReg.hcPersonDict.SaveHcPersonDictListVo;
import com.healt.cloud.checkup.vo.appointmentReg.hcPersonDict.SaveHcPersonDictVo;
import com.healt.cloud.common.pages.PageResult;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.IDCardUtils;
import com.healt.cloud.common.utils.PropertiesUtils;
import com.healt.cloud.resultex.exception.CommonException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GuYue
 * @date 2022-03-22 9:00
 * @description: TODO
 */
@Service
public class PersionInfoServiceImpl implements PersionInfoService {

    @Autowired
    private HcPersonInfoService hcPersonInfoService;

    @Autowired
    private PersonInfoMapper personInfoMapper;

    private String isHis = PropertiesUtils.ISHIS;

    private String areaCode = PropertiesUtils.AREACODE;

    private String medInstCode = PropertiesUtils.MEDINSTCODE;

    @Autowired
    private WebServiceClient client;


    @Override
    public List<HcPersonInfo> findPersonList(String hospitalCode) {
        QueryWrapper<HcPersonInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalCode);
        List<HcPersonInfo> list = hcPersonInfoService.list(queryWrapper);
        if(list.size() == 0){
            HcPersonInfo hcPersonInfo = new HcPersonInfo();
            hcPersonInfo.setIsaway("");
            list.add(hcPersonInfo);
        }
        return list;
    }

    @Override
    public List<HcPersonInfo> findPersonList(String hospitalCode, String unitId) {
        QueryWrapper<HcPersonInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalCode);
        queryWrapper.eq("unit_id", unitId);
        List<HcPersonInfo> list = hcPersonInfoService.list(queryWrapper);
        if(list.size() == 0){
            HcPersonInfo hcPersonInfo = new HcPersonInfo();
            hcPersonInfo.setIsaway("");
            list.add(hcPersonInfo);
        }
        return list;
    }

    @Autowired
    private HcPersonInfoErrlogService hcPersonInfoErrlogService;
    @Override
    public void savePersonDictList(SaveHcPersonDictListVo saveHcPersonDictListVo) {
        for(SaveHcPersonDictVo saveHcPersonDictVo : saveHcPersonDictListVo.getSaveHcPersonDictList()){
            switch (saveHcPersonDictVo.getStat()){
                case "add":
                    for(HcPersonInfo hcPersonInfo : saveHcPersonDictVo.getHcPersonInfo()){
                        hcPersonInfo.setBuildDate(new Date());
                        hcPersonInfo.setIdNo(hcPersonInfo.getIdNo().trim().toUpperCase());
                        hcPersonInfo.setUserName(hcPersonInfo.getUserName().trim());
                        String patientId = "";

                        if ("Y".equals(isHis)) {
                            //WebService查询是否已经建档，如果建档，直接返回patientId,如果没有，则建档，然后返回patientId
                            String result = findPersonInfoWS(medInstCode, areaCode, hcPersonInfo.getIdNo(), hcPersonInfo.getName());
                            if(!"0".equals(result)){//已经建档
                                patientId = result;
                            }else{//建档获取平台patientId
                                try {
                                    CreateArchiveResponse createArchiveResponse = this.archiveCreate(hcPersonInfo, "savePersonDictList");
                                    if(createArchiveResponse == null){
                                        HcPersonInfoErrlog hcPersonInfoErrlog = new HcPersonInfoErrlog();
                                        hcPersonInfoErrlog.setErrReason("HIS建档出错，请稍后重试，或者联系HIS工程师排查问题");
                                        BeanUtils.copyProperties(hcPersonInfo,hcPersonInfoErrlog);
                                        if(saveHcPersonDictVo.getHcPersonInfo().size()==1){
                                            throw new CommonException(500, hcPersonInfo.getName()+"HIS建档出错，请稍后重试，或者联系HIS工程师排查问题");
                                        }
                                        continue;
                                    }
                                    patientId = createArchiveResponse.getPatientInfo().getPatientId();
                                }catch (CommonException e){
                                    e.printStackTrace();
                                    HcPersonInfoErrlog hcPersonInfoErrlog = new HcPersonInfoErrlog();
                                    hcPersonInfoErrlog.setErrReason("该身份证号已在HIS系统建档，请核对身份证号与姓名是否匹配");
                                    if(saveHcPersonDictVo.getHcPersonInfo().size()==1){
                                        throw new CommonException(500, hcPersonInfo.getName()+"的身份证号已在HIS系统建档，请核对身份证号与姓名是否匹配");
                                    }
                                    BeanUtils.copyProperties(hcPersonInfo,hcPersonInfoErrlog);
                                    try {
                                        hcPersonInfoErrlogService.save(hcPersonInfoErrlog);
                                    }catch (Exception e1){
                                        e1.printStackTrace();
                                    }
                                    continue;
                                }
                            }
                        }
                        hcPersonInfo.setPatientId(patientId);

                        //根据身份证号和姓名查询体检人员库
                        QueryWrapper<HcPersonInfo> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("hospital_id", hcPersonInfo.getHospitalId());
                        queryWrapper.eq("id_no", hcPersonInfo.getIdNo());
                        queryWrapper.eq("name", hcPersonInfo.getName());
                        List<HcPersonInfo> hcPersonInfos = hcPersonInfoService.list(queryWrapper);
                        if(hcPersonInfos.size()>0){
                            //已存在
                            LambdaUpdateWrapper<HcPersonInfo> hcPersonInfoLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
                            hcPersonInfoLambdaUpdateWrapper.eq(HcPersonInfo::getIdNo, hcPersonInfo.getIdNo());
                            hcPersonInfoLambdaUpdateWrapper.eq(HcPersonInfo::getName, hcPersonInfo.getName());
                            hcPersonInfoLambdaUpdateWrapper.set(HcPersonInfo::getUnitId, hcPersonInfo.getUnitId());
                            hcPersonInfoLambdaUpdateWrapper.set(HcPersonInfo::getUnitName, hcPersonInfo.getUnitName());
                            hcPersonInfoService.update(hcPersonInfoLambdaUpdateWrapper);
//                            HcPersonInfoErrlog hcPersonInfoErrlog = new HcPersonInfoErrlog();
//                            hcPersonInfoErrlog.setErrReason("体检系统身份证号已经注册！");
//                            BeanUtils.copyProperties(hcPersonInfo,hcPersonInfoErrlog);
//                            try {
//                                hcPersonInfoErrlogService.save(hcPersonInfoErrlog);
//                            }catch (Exception e){
//                                e.printStackTrace();
//                            }
                            continue;
                        }
                        //生成personId;前端不传时，生成
                        if(StringUtils.isEmpty(hcPersonInfo.getPersonId())){
                            String personId = findPeId(hcPersonInfo.getHospitalId());
                            hcPersonInfo.setPersonId(personId);
                        }
                        hcPersonInfoService.save(hcPersonInfo);
                    }
                    break;
                case "delete":
                    for(HcPersonInfo hcPersonInfo : saveHcPersonDictVo.getHcPersonInfo()){
                        QueryWrapper<HcPersonInfo> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID", hcPersonInfo.getHospitalId());
                        queryWrapper.eq("PERSON_ID", hcPersonInfo.getHospitalId());
                        hcPersonInfoService.remove(queryWrapper);
                    }
                    break;
                case "update":
                    for(HcPersonInfo hcPersonInfo : saveHcPersonDictVo.getHcPersonInfo()){
                        UpdateWrapper<HcPersonInfo> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID", hcPersonInfo.getHospitalId());
                        updateWrapper.eq("PERSON_ID", hcPersonInfo.getPersonId());
                        hcPersonInfoService.update(hcPersonInfo, updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    @Transactional
    public String findPeId(String hospitalCode) {
        return personInfoMapper.findPeId(hospitalCode);
    }

    @Override
    public PageResult<HcPersonInfo> findPersonListPage(HcPersonInfoVo hcPersonInfoVo) {
        QueryWrapper<HcPersonInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hcPersonInfoVo.getHospitalCode());
        if(StringUtils.isNotEmpty(hcPersonInfoVo.getUnitId())){
            queryWrapper.eq("UNIT_ID", hcPersonInfoVo.getUnitId());
        }
        if(StringUtils.isNotEmpty(hcPersonInfoVo.getGlzdmc())&&!"*".equals(hcPersonInfoVo.getGlzdmc())){
            queryWrapper.like(hcPersonInfoVo.getGlzdmc(), hcPersonInfoVo.getGlzdnr());
        }
        queryWrapper.orderByDesc("BUILD_DATE");
        IPage<HcPersonInfo> page = new Page<>();
        page.setSize(hcPersonInfoVo.getPageSize());
        page.setCurrent(hcPersonInfoVo.getPageNum());
        page = hcPersonInfoService.page(page, queryWrapper);
        if(page.getRecords().size() == 0){
            List<HcPersonInfo> list = new ArrayList<>();
            HcPersonInfo hcPersonInfo = new HcPersonInfo();
            hcPersonInfo.setIsaway("");
            list.add(hcPersonInfo);
            page.setRecords(list);
        }
        return new PageResult<HcPersonInfo>(page.getCurrent(), page.getSize(), page.getTotal(), page.getPages(), page.getRecords());
    }

    @Override
    public HcPersonInfo findPersonInfoWeb(HcPersonInfo hcPersonInfo) {
        QueryWrapper<HcPersonInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hcPersonInfo.getHospitalId());
        queryWrapper.eq("id_no", hcPersonInfo.getIdNo());
        queryWrapper.eq("mobile", hcPersonInfo.getMobile());
        HcPersonInfo hcPersonInfoFind = hcPersonInfoService.getOne(queryWrapper);
        if(hcPersonInfoFind == null){
            //生成personId
            hcPersonInfo.setPersonId(this.findPeId(hcPersonInfo.getHospitalId()));
            hcPersonInfoService.save(hcPersonInfo);
        }else{
            return hcPersonInfoFind;
        }
        return hcPersonInfo;
    }

    @Override
    public String findPersonInfoWS(String medInstCode, String areaCode, String idCard, String patientName) {
        return client.findPersonInfoWS(medInstCode, areaCode, idCard, patientName, "findPersonInfoWS");
    }

    @Override
    public CreateArchiveResponse archiveCreate(HcPersonInfo hcPersonInfo, String methodName){
        ArchiveCreatePatientInfo patientInfo = new ArchiveCreatePatientInfo();
        patientInfo.setAreaCode(areaCode);
        if(StringUtils.isEmpty(hcPersonInfo.getSex())){
            patientInfo.setPatientSex("9");
        }else{
            patientInfo.setPatientSex(hcPersonInfo.getSex().equals("女")?"2":"1");
        }
        patientInfo.setPatientName(hcPersonInfo.getName());
        patientInfo.setBirthDate(DateUtils.praseDate(hcPersonInfo.getBarthday(), "yyyyMMddHHmmss"));
        patientInfo.setChildrenName("");
        patientInfo.setIdCard(hcPersonInfo.getIdNo());
        if("Y".equals(isHis)){
            //码表查询，获取费别
            if(StringUtils.isEmpty(hcPersonInfo.getChargeType())){
                patientInfo.setInsuranceType("A");
            }else{
                List<CodeTableItem> codeTableItems= client.mdmCodeQuery("YB0005", "archiveCreate").get(0).getItemList().getItem();
                List<CodeTableItem> insuranceTypeList = codeTableItems.stream()
                        .filter(codeTableItem -> hcPersonInfo.getChargeType().equals(codeTableItem.getItemName()))
                        .collect(Collectors.toList());
                if(insuranceTypeList.size()>0){
                    patientInfo.setInsuranceType(insuranceTypeList.get(0).getItemValue());
                }else {
                    patientInfo.setInsuranceType("A");
                }
            }
        }else{
            patientInfo.setInsuranceType(hcPersonInfo.getChargeType());
        }
        patientInfo.setRelation("");
        patientInfo.setPyCode(hcPersonInfo.getInputCode());
        patientInfo.setPhoneNo(hcPersonInfo.getMobile());
        if("Y".equals(isHis)){
            //码表查询，获取职业编码
            List<CodeTableItem> codeTableItems= client.mdmCodeQuery("CV02.01.202", "archiveCreate").get(0).getItemList().getItem();
            if(StringUtils.isEmpty(hcPersonInfo.getIdentity())){
                patientInfo.setOccupationCode("99");
            }else{
                List<CodeTableItem> identityList = codeTableItems.stream()
                        .filter(codeTableItem -> hcPersonInfo.getIdentity().equals(codeTableItem.getItemName()))
                        .collect(Collectors.toList());
                if(identityList.size() >0){
                    patientInfo.setOccupationCode(identityList.get(0).getItemValue());
                }else{
                    patientInfo.setOccupationCode("99");
                }
            }
        }else{
            patientInfo.setOccupationCode(hcPersonInfo.getIdentity());
        }
        patientInfo.setMedInstCode(medInstCode);
        ArchiveCreateCardInfo cardInfo = new ArchiveCreateCardInfo();
        cardInfo.setExpireTime("");
        cardInfo.setIdentityNum(hcPersonInfo.getIdNo());
        cardInfo.setIdentityType("4");
        String trackDate = hcPersonInfo.getIdNo()+"|"+ IDCardUtils.getBirthday(hcPersonInfo.getIdNo()).replaceAll("-", "");
        cardInfo.setTrackData(trackDate);
        cardInfo.setValidTime("");
        CreateArchiveResponse createArchiveResponse = client.archiveCreate(patientInfo, cardInfo, methodName);
        return createArchiveResponse;
    }

}
