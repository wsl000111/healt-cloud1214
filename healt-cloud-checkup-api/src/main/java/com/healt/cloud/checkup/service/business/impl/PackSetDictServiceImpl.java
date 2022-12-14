package com.healt.cloud.checkup.service.business.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcPackSetDict;
import com.healt.cloud.checkup.entity.HcSetVsPackDict;
import com.healt.cloud.checkup.mapper.BusinessMapper;
import com.healt.cloud.checkup.service.HcPackSetDictService;
import com.healt.cloud.checkup.service.HcSetVsPackDictService;
import com.healt.cloud.checkup.service.business.PackSetDictService;
import com.healt.cloud.checkup.vo.busniess.packClinic.SaveHcPackSetDictListVo;
import com.healt.cloud.checkup.vo.busniess.packClinic.SaveHcPackSetDictVo;
import com.healt.cloud.checkup.vo.busniess.packSet.HcSetVsPackDictVo;
import com.healt.cloud.checkup.vo.busniess.packSet.PackSetNewVo;
import com.healt.cloud.checkup.vo.busniess.packSet.SaveHcSetVsPackDictVo;
import com.healt.cloud.checkup.vo.busniess.packSet.VHcItemPackDictVo;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-17 11:05
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class PackSetDictServiceImpl implements PackSetDictService {

    private HcPackSetDictService hcPackSetDictService;

    private HcSetVsPackDictService hcSetVsPackDictService;

    private BusinessMapper businessMapper;

    @Override
    public List<HcPackSetDict> findDtPackSetDict(String hospitalId) {
        QueryWrapper<HcPackSetDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.orderByAsc("ITEM_NO");
        List<HcPackSetDict> list = hcPackSetDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcPackSetDict());
        }
        return list;
    }

    @Override
    public List<HcSetVsPackDictVo> findDtSetVsPack(String hospitalId, String setCode) {
        List<HcSetVsPackDictVo> list = businessMapper.findDtSetVsPack(hospitalId, setCode);
        if(list.size() == 0){
            list.add(new HcSetVsPackDictVo());
        }
        return list;
    }

    @Override
    public List<VHcItemPackDictVo> findDtItemPackDict(String hospitalId) {
        List<VHcItemPackDictVo> list = businessMapper.findDtItemPackDict(hospitalId);
        if(list.size() == 0){
            list.add(new VHcItemPackDictVo());
        }
        return list;
    }

    @Override
    public void saveHcSetVsPackDictList(SaveHcSetVsPackDictVo saveHcSetVsPackDictVo) {
        switch (saveHcSetVsPackDictVo.getStat()){
            case "delete" :
                for(HcSetVsPackDict hcSetVsPackDict : saveHcSetVsPackDictVo.getHcSetVsPackDict()){
                    QueryWrapper<HcSetVsPackDict> hcSetVsPackDictWrapper = new QueryWrapper<>();
                    if(StringUtils.isNotEmpty(hcSetVsPackDict.getItemPackCode())){
                        hcSetVsPackDictWrapper.eq("ITEM_PACK_CODE", hcSetVsPackDict.getItemPackCode());
                        hcSetVsPackDictWrapper.eq("SET_CODE", hcSetVsPackDict.getSetCode());
                        hcSetVsPackDictWrapper.eq("HOSPITAL_ID", hcSetVsPackDict.getHospitalId());
                        hcSetVsPackDictService.remove(hcSetVsPackDictWrapper);
                        UpdateWrapper<HcSetVsPackDict> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.setSql("ITEM_NO = ITEM_NO - 1");
                        updateWrapper.gt("ITEM_NO", hcSetVsPackDict.getItemNo()); //gt 大于
                        updateWrapper.eq("HOSPITAL_ID", hcSetVsPackDict.getHospitalId());
                        updateWrapper.eq("SET_CODE", hcSetVsPackDict.getSetCode());
                        //updateWrapper.eq("ITEM_PACK_CODE", hcSetVsPackDict.getItemPackCode());
                        hcSetVsPackDictService.update(updateWrapper);
                    } else {
                        hcSetVsPackDictWrapper.eq("SET_CODE", hcSetVsPackDict.getSetCode());
                        hcSetVsPackDictWrapper.eq("HOSPITAL_ID", hcSetVsPackDict.getHospitalId());
                        hcSetVsPackDictService.remove(hcSetVsPackDictWrapper);
                        QueryWrapper<HcPackSetDict> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("SET_CODE", hcSetVsPackDict.getSetCode());
                        queryWrapper.eq("HOSPITAL_ID", hcSetVsPackDict.getHospitalId());
                        hcPackSetDictService.remove(queryWrapper);
                    }
                }
                break;
            case "add":
                hcSetVsPackDictService.saveBatch(saveHcSetVsPackDictVo.getHcSetVsPackDict());
                break;
        }
    }

    @Override
    public void saveHcPackSetDictList(SaveHcPackSetDictListVo saveHcPackSetDictListVo) {
        for(SaveHcPackSetDictVo saveHcPackSetDictVo : saveHcPackSetDictListVo.getSaveHcPackSetDictList()){
            switch (saveHcPackSetDictVo.getStat()){
                case "add":
                    hcPackSetDictService.saveBatch(saveHcPackSetDictVo.getHcPackSetDict());
                    break;
                case "update":
                    for(HcPackSetDict hcPackSetDict : saveHcPackSetDictVo.getHcPackSetDict()){
                        UpdateWrapper<HcPackSetDict> updateWrapper= new UpdateWrapper<>();
                        updateWrapper.eq("hospital_id", hcPackSetDict.getHospitalId());
                        updateWrapper.eq("SET_CODE", hcPackSetDict.getSetCode());
                        hcPackSetDictService.update(hcPackSetDict, updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public List<PackSetNewVo> findPackSetNew() {
        List<PackSetNewVo> list = businessMapper.findPackSetNew();
        if(list.size() == 0){
            list.add(new PackSetNewVo());
        }
        return list;
    }

}
