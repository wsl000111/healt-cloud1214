package com.healt.cloud.checkup.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcAnswerDict;
import com.healt.cloud.checkup.questionnaire.mapper.AnswerDictMapper;
import com.healt.cloud.checkup.questionnaire.service.AnswerDictService;
import com.healt.cloud.checkup.questionnaire.vo.SaveAnswerListVo;
import com.healt.cloud.checkup.questionnaire.vo.SaveAnswerVo;
import com.healt.cloud.checkup.service.HcAnswerDictService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-10 13:58
 */
@Service
@AllArgsConstructor
public class AnswerDictServiceImpl implements AnswerDictService {

    private AnswerDictMapper answerDictMapper;

    private HcAnswerDictService hcAnswerDictService;

    @Override
    public List<HcAnswerDict> findAnswer(String hospitalId, String investCode, String questionCode) {
        QueryWrapper<HcAnswerDict> wrapper = new QueryWrapper<>();
        wrapper.eq("HOSPITAL_ID",hospitalId);
        wrapper.eq("INVEST_CODE",investCode);
        wrapper.eq("QUESTION_CODE",questionCode);
        List<HcAnswerDict> list = hcAnswerDictService.list(wrapper);
        if (list.size() == 0) {
            list.add(new HcAnswerDict());
        }
        return list;
    }

    @Override
    public void saveAnswer(SaveAnswerListVo saveAnswerList) {
        for (SaveAnswerVo saveAnswerVo : saveAnswerList.getSaveAnswer()) {
            switch (saveAnswerVo.getStat()) {
                case "delete" :
                    for (HcAnswerDict hcAnswerDict : saveAnswerVo.getHcAnswerDict()) {
                        QueryWrapper<HcAnswerDict> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID",hcAnswerDict.getHospitalId());
                        queryWrapper.eq("INVEST_CODE",hcAnswerDict.getInvestCode());
                        queryWrapper.eq("QUESTION_CODE",hcAnswerDict.getQuestionCode());
                        queryWrapper.eq("ANSWER_CODE",hcAnswerDict.getAnswerCode());
                        hcAnswerDictService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    String hospitalId = saveAnswerVo.getHcAnswerDict().get(0).getHospitalId();
                    String investCode = saveAnswerVo.getHcAnswerDict().get(0).getInvestCode();
                    String questionCode = saveAnswerVo.getHcAnswerDict().get(0).getQuestionCode();
                    Integer max = answerDictMapper.findMaxAnswerCode(hospitalId,investCode,questionCode);
                    if (max == null) {
                        max = 0;
                    }
                    for (HcAnswerDict hcAnswerDict : saveAnswerVo.getHcAnswerDict()) {
                        max += 1;
                        String answerCode = String.format("%04d", max);
                        hcAnswerDict.setAnswerCode(answerCode);
                        hcAnswerDictService.save(hcAnswerDict);
                    }
                    break;
                case "update" :
                    for (HcAnswerDict hcAnswerDict : saveAnswerVo.getHcAnswerDict()) {
                        UpdateWrapper<HcAnswerDict> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID",hcAnswerDict.getHospitalId());
                        updateWrapper.eq("INVEST_CODE",hcAnswerDict.getInvestCode());
                        updateWrapper.eq("QUESTION_CODE",hcAnswerDict.getQuestionCode());
                        updateWrapper.eq("ANSWER_CODE",hcAnswerDict.getAnswerCode());
                        hcAnswerDictService.update(hcAnswerDict,updateWrapper);
                    }
                    break;
            }
        }
    }
}
