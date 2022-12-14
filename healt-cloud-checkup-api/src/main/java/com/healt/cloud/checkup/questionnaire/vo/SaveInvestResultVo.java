package com.healt.cloud.checkup.questionnaire.vo;

import com.healt.cloud.checkup.entity.HcInvestResult;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 15:28
 */
@Data
public class SaveInvestResultVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcInvestResult> hcInvestResult;
}
