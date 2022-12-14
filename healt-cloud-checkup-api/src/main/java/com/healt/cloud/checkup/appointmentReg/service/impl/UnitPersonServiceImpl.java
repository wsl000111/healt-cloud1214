package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.appointmentReg.service.UnitPersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-07 14:59
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class UnitPersonServiceImpl implements UnitPersonService {

    private VHcClassDictService vHcClassDictService;

    private VCountryDictService vCountryDictService;

    private VAreaDictService vAreaDictService;

    private VNationDictService vNationDictService;

    private VOccupationDictService vOccupationDictService;

    private VMaritalStatusDictService vMaritalStatusDictService;

    private VCostclassDictService vCostclassDictService;

    private VIdentityDictService vIdentityDictService;

    @Override
    public List<VHcClassDict> findDtClassType(String hospitalId) {
        QueryWrapper<VHcClassDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("USE_FLAG", "1");
        queryWrapper.orderByAsc("SORT_NO");
        List<VHcClassDict> list = vHcClassDictService.list(queryWrapper);
        if(list.size()==0){
            list.add(new VHcClassDict());
        }
        return list;
    }

    @Override
    public List<VCountryDict> findDtCountry(String hospitalId) {
        QueryWrapper<VCountryDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("USE_FLAG", "1");
        queryWrapper.orderByAsc("SORT_NO");
        List<VCountryDict> list = vCountryDictService.list(queryWrapper);
        if(list.size()==0){
            list.add(new VCountryDict());
        }
        return list;
    }

    @Override
    public List<VAreaDict> findDtArea(String hospitalId) {
        QueryWrapper<VAreaDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("USE_FLAG", "1");
        queryWrapper.orderByAsc("SORT_NO");
        List<VAreaDict> list = vAreaDictService.list(queryWrapper);
        if(list.size()==0){
            list.add(new VAreaDict());
        }
        return list;
    }

    @Override
    public List<VNationDict> findDtNation(String hospitalId) {
        QueryWrapper<VNationDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("USE_FLAG", "1");
        queryWrapper.orderByAsc("SORT_NO");
        List<VNationDict> list = vNationDictService.list(queryWrapper);
        if(list.size()==0){
            list.add(new VNationDict());
        }
        return list;
    }

    @Override
    public List<VOccupationDict> findDtJob(String hospitalId) {
        QueryWrapper<VOccupationDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("USE_FLAG", "1");
        queryWrapper.orderByAsc("SORT_NO");
        List<VOccupationDict> list = vOccupationDictService.list(queryWrapper);
        if(list.size()==0){
            list.add(new VOccupationDict());
        }
        return list;
    }

    @Override
    public List<VMaritalStatusDict> findDtMaritalStatus(String hospitalId) {
        QueryWrapper<VMaritalStatusDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("USE_FLAG", "1");
        queryWrapper.orderByAsc("SORT_NO");
        List<VMaritalStatusDict> list = vMaritalStatusDictService.list(queryWrapper);
        if(list.size()==0){
            list.add(new VMaritalStatusDict());
        }
        return list;
    }

    @Override
    public List<VCostclassDict> findDtChargeType(String hospitalId) {
        QueryWrapper<VCostclassDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("USE_FLAG", "1");
        queryWrapper.orderByAsc("SORT_NO");
        List<VCostclassDict> list = vCostclassDictService.list(queryWrapper);
        if(list.size()==0){
            list.add(new VCostclassDict());
        }
        return list;
    }

    @Override
    public List<VIdentityDict> findDtIdentity(String hospitalId) {
        QueryWrapper<VIdentityDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("USE_FLAG", "1");
        queryWrapper.orderByAsc("SORT_NO");
        List<VIdentityDict> list = vIdentityDictService.list(queryWrapper);
        if(list.size()==0){
            list.add(new VIdentityDict());
        }
        return list;
    }
}
