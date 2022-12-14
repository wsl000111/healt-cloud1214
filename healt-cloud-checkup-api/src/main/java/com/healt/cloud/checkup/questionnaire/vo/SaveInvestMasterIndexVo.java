package com.healt.cloud.checkup.questionnaire.vo;

import com.healt.cloud.checkup.entity.HcInvestMasterIndex;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 14:14
 */
@Data
public class SaveInvestMasterIndexVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcInvestMasterIndex> hcInvestMasterIndex;
}
