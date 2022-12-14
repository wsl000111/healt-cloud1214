package com.healt.cloud.checkup.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcInvestType;
import com.healt.cloud.checkup.questionnaire.mapper.InvestTypeMapper;
import com.healt.cloud.checkup.questionnaire.service.InvestTypeService;
import com.healt.cloud.checkup.questionnaire.vo.SaveInvestTypeListVo;
import com.healt.cloud.checkup.questionnaire.vo.SaveInvestTypeVo;
import com.healt.cloud.checkup.service.HcInvestTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 9:53
 */
@Service
@AllArgsConstructor
public class InvestTypeServiceImpl implements InvestTypeService {

    private InvestTypeMapper investTypeMapper;

    private HcInvestTypeService hcInvestTypeService;

    @Override
    public List<HcInvestType> findInvestType(String hospitalId) {
        QueryWrapper<HcInvestType> wrapper = new QueryWrapper<>();
        wrapper.eq("HOSPITAL_ID",hospitalId);
        List<HcInvestType> list = hcInvestTypeService.list(wrapper);
        if (list.size() == 0) {
            list.add(new HcInvestType());
        }
        return list;
    }

    @Override
    public void saveInvestType(SaveInvestTypeListVo saveInvestTypeList) {
        for (SaveInvestTypeVo saveInvestTypeVo : saveInvestTypeList.getSaveInvestType()) {
            switch (saveInvestTypeVo.getStat()) {
                case "delete" :
                    for (HcInvestType hcInvestType : saveInvestTypeVo.getHcInvestType()) {
                        QueryWrapper<HcInvestType> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("INVEST_CODE",hcInvestType.getInvestCode());
                        queryWrapper.eq("HOSPITAL_ID",hcInvestType.getHospitalId());
                        hcInvestTypeService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    String hospitalId = saveInvestTypeVo.getHcInvestType().get(0).getHospitalId();
                    Integer max = investTypeMapper.findMaxInvestCode(hospitalId);
                    if (max == null) {
                        max = 0;
                    }
                    for (HcInvestType hcInvestType : saveInvestTypeVo.getHcInvestType()) {
                        max += 1;
                        String investCode = String.format("%04d", max);
                        //System.out.println(investCode);
                        hcInvestType.setInvestCode(investCode);
                        hcInvestTypeService.save(hcInvestType);
                    }
                    break;
                case "update" :
                    for (HcInvestType hcInvestType : saveInvestTypeVo.getHcInvestType()) {
                        UpdateWrapper<HcInvestType> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("INVEST_CODE",hcInvestType.getInvestCode());
                        updateWrapper.eq("HOSPITAL_ID",hcInvestType.getHospitalId());
                        hcInvestTypeService.update(hcInvestType,updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public List<HcInvestType> findInvestTypeWeb(String hospitalId) {
        QueryWrapper<HcInvestType> wrapper = new QueryWrapper<>();
        wrapper.eq("HOSPITAL_ID",hospitalId);
        wrapper.eq("EFFECTIVE",1);
        List<HcInvestType> list = hcInvestTypeService.list(wrapper);
        return list;
    }
}
