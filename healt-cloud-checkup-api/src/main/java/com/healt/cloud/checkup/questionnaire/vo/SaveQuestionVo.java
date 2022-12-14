package com.healt.cloud.checkup.questionnaire.vo;

import com.healt.cloud.checkup.entity.HcQuestionDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-10 15:54
 */
@Data
public class SaveQuestionVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcQuestionDict> hcQuestionDict;
}
