package com.healt.cloud.checkup.questionnaire.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-10 15:51
 */
@Data
public class SaveQuestionListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveQuestionVo> saveQuestion;

}
