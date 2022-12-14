package com.healt.cloud.checkup.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcInvestMasterIndex;
import com.healt.cloud.checkup.questionnaire.mapper.InvestMasterIndexMapper;
import com.healt.cloud.checkup.questionnaire.service.InvestMasterIndexService;
import com.healt.cloud.checkup.questionnaire.vo.SaveInvestMasterIndexListVo;
import com.healt.cloud.checkup.questionnaire.vo.SaveInvestMasterIndexVo;
import com.healt.cloud.checkup.service.HcInvestMasterIndexService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 13:44
 */
@Service
@AllArgsConstructor
public class InvestMasterIndexServiceImpl implements InvestMasterIndexService {

    private InvestMasterIndexMapper investMasterIndexMapper;

    private HcInvestMasterIndexService hcInvestMasterIndexService;

    @Override
    public List<HcInvestMasterIndex> findInvestMasterIndex(String hospitalId) {
        QueryWrapper<HcInvestMasterIndex> wrapper = new QueryWrapper<>();
        wrapper.eq("HOSPITAL_ID",hospitalId);
        List<HcInvestMasterIndex> list = hcInvestMasterIndexService.list(wrapper);
        if (list.size() == 0) {
            list.add(new HcInvestMasterIndex());
        }
        return list;
    }

    @Override
    public void saveInvestMasterIndexWeb(SaveInvestMasterIndexListVo saveInvestMasterIndexList) {
        for (SaveInvestMasterIndexVo saveInvestMasterIndexVo : saveInvestMasterIndexList.getSaveInvestMasterIndex()) {
            switch (saveInvestMasterIndexVo.getStat()) {
                case "delete" :
                    for (HcInvestMasterIndex hcInvestMasterIndex : saveInvestMasterIndexVo.getHcInvestMasterIndex()) {
                        QueryWrapper<HcInvestMasterIndex> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID",hcInvestMasterIndex.getHospitalId());
                        queryWrapper.eq("INVEST_ID",hcInvestMasterIndex.getInvestId());
                        hcInvestMasterIndexService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    hcInvestMasterIndexService.saveBatch(saveInvestMasterIndexVo.getHcInvestMasterIndex());
                    break;
                case "update" :
                    for (HcInvestMasterIndex hcInvestMasterIndex : saveInvestMasterIndexVo.getHcInvestMasterIndex()) {
                        UpdateWrapper<HcInvestMasterIndex> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID",hcInvestMasterIndex.getHospitalId());
                        updateWrapper.eq("INVEST_ID",hcInvestMasterIndex.getInvestId());
                        hcInvestMasterIndexService.update(hcInvestMasterIndex,updateWrapper);
                    }
                    break;
            }
        }
    }
}
