package com.healt.cloud.checkup.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcInvestResult;
import com.healt.cloud.checkup.questionnaire.mapper.InvestResultMapper;
import com.healt.cloud.checkup.questionnaire.service.InvestResultService;
import com.healt.cloud.checkup.questionnaire.vo.SaveInvestResultListVo;
import com.healt.cloud.checkup.questionnaire.vo.SaveInvestResultVo;
import com.healt.cloud.checkup.service.HcInvestResultService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 14:33
 */
@Service
@AllArgsConstructor
public class InvestResultServiceImpl implements InvestResultService {

    private InvestResultMapper investResultMapper;

    private HcInvestResultService hcInvestResultService;

    @Override
    public List<HcInvestResult> findInvestResult(String hospitalId, String investCode) {
        QueryWrapper<HcInvestResult> wrapper = new QueryWrapper<>();
        wrapper.eq("HOSPITAL_ID",hospitalId);
        wrapper.eq("INVEST_CODE",investCode);
        List<HcInvestResult> list = hcInvestResultService.list(wrapper);
        if (list.size() == 0) {
            list.add(new HcInvestResult());
        }
        return list;
    }

    @Override
    public void saveInvestResult(SaveInvestResultListVo saveInvestResultList) {
        for (SaveInvestResultVo saveInvestResultVo : saveInvestResultList.getSaveInvestResult()) {
            switch (saveInvestResultVo.getStat()) {
                case "delete" :
                    for (HcInvestResult hcInvestResult : saveInvestResultVo.getHcInvestResult()) {
                        QueryWrapper<HcInvestResult> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID",hcInvestResult.getHospitalId());
                        queryWrapper.eq("INVEST_ID",hcInvestResult.getInvestId());
                        queryWrapper.eq("INVEST_CODE",hcInvestResult.getInvestCode());
                        queryWrapper.eq("QUESTION_CODE",hcInvestResult.getQuestionCode());
                        queryWrapper.eq("ANSWER_CODE",hcInvestResult.getAnswerCode());
                        hcInvestResultService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    hcInvestResultService.saveBatch(saveInvestResultVo.getHcInvestResult());
                    break;
                case "update" :
                    for (HcInvestResult hcInvestResult : saveInvestResultVo.getHcInvestResult()) {
                        UpdateWrapper<HcInvestResult> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID",hcInvestResult.getHospitalId());
                        updateWrapper.eq("INVEST_ID",hcInvestResult.getInvestId());
                        updateWrapper.eq("INVEST_CODE",hcInvestResult.getInvestCode());
                        updateWrapper.eq("QUESTION_CODE",hcInvestResult.getQuestionCode());
                        updateWrapper.eq("ANSWER_CODE",hcInvestResult.getAnswerCode());
                        hcInvestResultService.update(hcInvestResult,updateWrapper);
                    }
                    break;
            }
        }
    }


}
