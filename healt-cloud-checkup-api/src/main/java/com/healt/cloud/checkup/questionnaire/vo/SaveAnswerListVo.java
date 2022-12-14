package com.healt.cloud.checkup.questionnaire.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-10 16:34
 */
@Data
public class SaveAnswerListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveAnswerVo> saveAnswer;
}
