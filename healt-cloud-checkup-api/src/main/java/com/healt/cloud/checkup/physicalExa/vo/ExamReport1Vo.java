package com.healt.cloud.checkup.physicalExa.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-25 17:26
 */
@Data
public class ExamReport1Vo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("EXAM_PARA")
    @JsonProperty("EXAM_PARA")
    private String examPara;

    @TableField("DESCRIPTION")
    @JsonProperty("DESCRIPTION")
    private String description;

    @TableField("IMPRESSION")
    @JsonProperty("IMPRESSION")
    private String impression;

    @TableField("RECOMMENDATION")
    @JsonProperty("RECOMMENDATION")
    private String recommendation;

    @TableField("IS_ABNORMAL")
    @JsonProperty("IS_ABNORMAL")
    private String isAbnormal;

}
