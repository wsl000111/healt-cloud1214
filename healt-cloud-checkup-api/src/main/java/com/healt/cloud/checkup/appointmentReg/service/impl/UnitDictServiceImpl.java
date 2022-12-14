package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcUnitInfo;
import com.healt.cloud.checkup.entity.HcUnitVisitInfo;
import com.healt.cloud.checkup.service.ws.WebServiceClient;
import com.healt.cloud.checkup.service.ws.his.companyArchive.CompanyArchiveCreateReqBody;
import com.healt.cloud.checkup.service.ws.his.companyArchive.CompanyInfo;
import com.healt.cloud.checkup.vo.appointmentReg.hcUintDict.SaveHcUnitDictListVo;
import com.healt.cloud.checkup.vo.appointmentReg.hcUintDict.SaveHcUnitDictVo;
import com.healt.cloud.checkup.service.HcUnitInfoService;
import com.healt.cloud.checkup.service.HcUnitVisitInfoService;
import com.healt.cloud.checkup.appointmentReg.service.UnitDictService;
import com.healt.cloud.common.utils.PropertiesUtils;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-28 9:35
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class UnitDictServiceImpl implements UnitDictService {

    private HcUnitInfoService hcUnitInfoService;

    private HcUnitVisitInfoService hcUnitVisitInfoService;

    @Override
    public List<HcUnitInfo> findUnitList(String hospitalCode) {
        QueryWrapper<HcUnitInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalCode);
        List<HcUnitInfo> list = hcUnitInfoService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcUnitInfo());
        }
        return list;
    }


    @Override
    public List<HcUnitInfo> findDtUnit(String hospitalId, String unitId) {
        QueryWrapper<HcUnitInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.ne("UNIT_ID", "0000");
        queryWrapper.eq("UNIT_ID", unitId);
        queryWrapper.orderByAsc("UNIT_ID").orderByAsc("UNIT_NAME");
        List<HcUnitInfo> list = hcUnitInfoService.list(queryWrapper);
        if(list.size()==0){
            list.add(new HcUnitInfo());
        }
        return list;
    }

    @Override
    public List<HcUnitInfo> findDtUnit(String hospitalId) {
        QueryWrapper<HcUnitInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.ne("UNIT_ID", "0000");
        queryWrapper.orderByAsc("UNIT_ID").orderByAsc("UNIT_NAME");
        List<HcUnitInfo> list = hcUnitInfoService.list(queryWrapper);
        if(list.size()==0){
            list.add(new HcUnitInfo());
        }
        return list;
    }

    public HcUnitVisitInfo findUnitVisitOne(String hospitalCode, String unitId){
        QueryWrapper<HcUnitVisitInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalCode);
        queryWrapper.eq("unit_id", unitId);
        return hcUnitVisitInfoService.getOne(queryWrapper);
    }

    @Autowired
    private WebServiceClient client;

    @Override
    public void saveUnitDictList(SaveHcUnitDictListVo saveHcUnitDictListVo) {
        for(SaveHcUnitDictVo saveHcUnitDictVo : saveHcUnitDictListVo.getSaveHcUnitDictList()){
            switch (saveHcUnitDictVo.getStat()){
                case "add":
                    for(HcUnitInfo hcUnitInfo : saveHcUnitDictVo.getHcUnitInfo()){
                        hcUnitInfo.setRegisterDate(new Date());
                        //调用平台，单位建档
                        CompanyArchiveCreateReqBody body = new CompanyArchiveCreateReqBody();
                        CompanyInfo companyInfo = new CompanyInfo();
                        body.setCompanyInfo(companyInfo);
                        companyInfo.setExamCompanyNo(hcUnitInfo.getUnitId());
                        companyInfo.setExamCompanyName(hcUnitInfo.getUnitName());
                        companyInfo.setAreaCode(PropertiesUtils.AREACODE);
                        String examCompanyID = client.companyArchiveCreate(body,"saveUnitDictList");
                        hcUnitInfo.setExamcompanyid(examCompanyID);
                        hcUnitInfoService.save(hcUnitInfo);
                    }
                    break;
                case "delete":
                    for(HcUnitInfo hcUnitInfo : saveHcUnitDictVo.getHcUnitInfo()){
                        HcUnitVisitInfo hcUnitVisitInfo = findUnitVisitOne(hcUnitInfo.getHospitalId(), hcUnitInfo.getUnitId());
                        if(hcUnitVisitInfo != null){
                            throw new CommonException(10000, "单位不能删除，已经发生业务");
                        }
                        QueryWrapper<HcUnitInfo> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID", hcUnitInfo.getHospitalId());
                        queryWrapper.eq("UNIT_ID", hcUnitInfo.getHospitalId());
                        hcUnitInfoService.remove(queryWrapper);
                    }
                    break;
                case "update":
                    for(HcUnitInfo hcUnitInfo : saveHcUnitDictVo.getHcUnitInfo()){
                        //调用平台，单位建档
                        CompanyArchiveCreateReqBody body = new CompanyArchiveCreateReqBody();
                        CompanyInfo companyInfo = new CompanyInfo();
                        body.setCompanyInfo(companyInfo);
                        companyInfo.setExamCompanyNo(hcUnitInfo.getUnitId());
                        companyInfo.setExamCompanyName(hcUnitInfo.getUnitName());
                        companyInfo.setAreaCode(PropertiesUtils.AREACODE);
                        String examCompanyID = client.companyArchiveCreate(body,"saveUnitDictList");
                        hcUnitInfo.setExamcompanyid(examCompanyID);
                        UpdateWrapper<HcUnitInfo> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID", hcUnitInfo.getHospitalId());
                        updateWrapper.eq("UNIT_ID", hcUnitInfo.getUnitId());
                        hcUnitInfoService.update(hcUnitInfo, updateWrapper);
                    }
                    break;
            }
        }
    }
}
