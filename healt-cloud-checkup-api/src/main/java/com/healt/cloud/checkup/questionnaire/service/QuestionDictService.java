package com.healt.cloud.checkup.questionnaire.service;

import com.healt.cloud.checkup.entity.HcQuestionDict;
import com.healt.cloud.checkup.questionnaire.vo.HcQuestionDictVo;
import com.healt.cloud.checkup.questionnaire.vo.SaveQuestionListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-10 13:58
 */
public interface QuestionDictService {

    public List<HcQuestionDict> findQuestion(String hospitalId, String investCode);

    public void saveQuestion(SaveQuestionListVo saveQuestionList);

    public List<HcQuestionDict> findQuestionWeb(String hospitalId, String investCode);

    List<HcQuestionDictVo> findQuestionAndAnswerWeb(String hospitalId, String investCode);
}
