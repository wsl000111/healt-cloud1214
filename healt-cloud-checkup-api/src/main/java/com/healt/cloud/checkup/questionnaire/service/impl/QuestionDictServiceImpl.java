package com.healt.cloud.checkup.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcAnswerDict;
import com.healt.cloud.checkup.entity.HcQuestionDict;
import com.healt.cloud.checkup.questionnaire.mapper.QuestionDictMapper;
import com.healt.cloud.checkup.questionnaire.service.QuestionDictService;
import com.healt.cloud.checkup.questionnaire.vo.HcQuestionDictVo;
import com.healt.cloud.checkup.questionnaire.vo.SaveQuestionListVo;
import com.healt.cloud.checkup.questionnaire.vo.SaveQuestionVo;
import com.healt.cloud.checkup.service.HcAnswerDictService;
import com.healt.cloud.checkup.service.HcQuestionDictService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-10 13:59
 */
@Service
@AllArgsConstructor
public class QuestionDictServiceImpl implements QuestionDictService {

    private QuestionDictMapper questionDictMapper;

    private HcQuestionDictService hcQuestionDictService;

    private HcAnswerDictService hcAnswerDictService;

    @Override
    public List<HcQuestionDict> findQuestion(String hospitalId, String investCode) {
        QueryWrapper<HcQuestionDict> wrapper = new QueryWrapper<>();
        wrapper.eq("HOSPITAL_ID",hospitalId);
        wrapper.eq("INVEST_CODE",investCode);
        List<HcQuestionDict> list = hcQuestionDictService.list(wrapper);
        if (list.size() == 0) {
            list.add(new HcQuestionDict());
        }
        return list;
    }

    @Override
    public void saveQuestion(SaveQuestionListVo saveQuestionList) {
        for (SaveQuestionVo saveQuestionVo : saveQuestionList.getSaveQuestion()) {
            switch (saveQuestionVo.getStat()) {
                case "delete" :
                    for (HcQuestionDict hcQuestionDict : saveQuestionVo.getHcQuestionDict()) {
                        QueryWrapper<HcQuestionDict> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID",hcQuestionDict.getHospitalId());
                        queryWrapper.eq("INVEST_CODE",hcQuestionDict.getInvestCode());
                        queryWrapper.eq("QUESTION_CODE",hcQuestionDict.getQuestionCode());
                        hcQuestionDictService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    String hospitalId = saveQuestionVo.getHcQuestionDict().get(0).getHospitalId();
                    String investCode = saveQuestionVo.getHcQuestionDict().get(0).getInvestCode();
                    Integer max = questionDictMapper.findMaxQuestionCode(hospitalId,investCode);
                    if (max == null) {
                        max = 0;
                    }
                    for (HcQuestionDict hcQuestionDict : saveQuestionVo.getHcQuestionDict()) {
                        max += 1;
                        String questionCode = String.format("%04d", max);
                        hcQuestionDict.setQuestionCode(questionCode);
                        hcQuestionDictService.save(hcQuestionDict);
                    }
                    break;
                case "update" :
                    for (HcQuestionDict hcQuestionDict : saveQuestionVo.getHcQuestionDict()) {
                        UpdateWrapper<HcQuestionDict> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID",hcQuestionDict.getHospitalId());
                        updateWrapper.eq("INVEST_CODE",hcQuestionDict.getInvestCode());
                        updateWrapper.eq("QUESTION_CODE",hcQuestionDict.getQuestionCode());
                        hcQuestionDictService.update(hcQuestionDict,updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public List<HcQuestionDict> findQuestionWeb(String hospitalId, String investCode) {
        QueryWrapper<HcQuestionDict> wrapper = new QueryWrapper<>();
        wrapper.eq("HOSPITAL_ID",hospitalId);
        wrapper.eq("INVEST_CODE",investCode);
        wrapper.eq("EFFECTIVE",1);
        List<HcQuestionDict> list = hcQuestionDictService.list(wrapper);
        return list;
    }

    @Override
    public List<HcQuestionDictVo> findQuestionAndAnswerWeb(String hospitalId, String investCode) {
        List<HcQuestionDictVo> listVo = new ArrayList<>();
        QueryWrapper<HcQuestionDict> wrapper = new QueryWrapper<>();
        wrapper.eq("HOSPITAL_ID",hospitalId);
        wrapper.eq("INVEST_CODE",investCode);
        wrapper.eq("EFFECTIVE",1);
        wrapper.orderByAsc("QUESTION_SORT");
        List<HcQuestionDict> questionList = hcQuestionDictService.list(wrapper);
        for(HcQuestionDict hcQuestionDict : questionList){
            QueryWrapper<HcAnswerDict> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("HOSPITAL_ID",hospitalId);
            queryWrapper.eq("INVEST_CODE",investCode);
            queryWrapper.eq("QUESTION_CODE", hcQuestionDict.getQuestionCode());
            queryWrapper.eq("EFFECTIVE",1);
            queryWrapper.orderByAsc("ANSWER_CODE");
            List<HcAnswerDict> answerList = hcAnswerDictService.list(queryWrapper);
            HcQuestionDictVo hcQuestionDictVo = new HcQuestionDictVo();
            hcQuestionDictVo.setQuestion(hcQuestionDict);
            hcQuestionDictVo.setAnswerList(answerList);
            listVo.add(hcQuestionDictVo);
        }
        return listVo;
    }
}
