package com.healt.cloud.checkup.questionnaire.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 10:03
 */
@Data
public class SaveInvestTypeListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveInvestTypeVo> saveInvestType;
}
