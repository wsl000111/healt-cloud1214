package com.healt.cloud.checkup.questionnaire.vo;

import com.healt.cloud.checkup.entity.HcAnswerDict;
import com.healt.cloud.checkup.entity.HcQuestionDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-06-14 14:08
 * @description: TODO
 */
@Data
public class HcQuestionDictVo implements Serializable {
    private static final long serialVersionUID=1L;

    private HcQuestionDict question;

    private List<HcAnswerDict> answerList;
}
