package com.healt.cloud.checkup.physicalExa.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-25 16:01
 */
@Data
public class ExamReportVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("DESCRIPTION")
    @JsonProperty("DESCRIPTION")
    private String description;

    @TableField("IMPRESSION")
    @JsonProperty("IMPRESSION")
    private String impression;

    @TableField("RECOMMENDATION")
    @JsonProperty("RECOMMENDATION")
    private String recommendation;

    @TableField("EXAM_PARA")
    @JsonProperty("EXAM_PARA")
    private String examPara;

}
