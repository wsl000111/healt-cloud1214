package com.healt.cloud.checkup.questionnaire.service;

import com.healt.cloud.checkup.entity.HcAnswerDict;
import com.healt.cloud.checkup.questionnaire.vo.SaveAnswerListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-10 13:58
 */
public interface AnswerDictService {

    public List<HcAnswerDict> findAnswer(String hospitalId, String investCode, String questionCode);

    public void saveAnswer(SaveAnswerListVo saveAnswerList);
}
