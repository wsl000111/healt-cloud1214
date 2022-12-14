package com.healt.cloud.checkup.questionnaire.vo;

import com.healt.cloud.checkup.entity.HcInvestType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 10:04
 */
@Data
public class SaveInvestTypeVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcInvestType> hcInvestType;
}
