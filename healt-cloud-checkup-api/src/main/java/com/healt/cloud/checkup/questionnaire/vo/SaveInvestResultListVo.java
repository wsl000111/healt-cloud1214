package com.healt.cloud.checkup.questionnaire.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 15:27
 */
@Data
public class SaveInvestResultListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveInvestResultVo> saveInvestResult;
}
