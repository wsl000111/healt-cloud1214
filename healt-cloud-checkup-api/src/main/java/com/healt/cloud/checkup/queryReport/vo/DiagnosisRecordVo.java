package com.healt.cloud.checkup.queryReport.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-29 10:58
 */
@Data
public class DiagnosisRecordVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("rownum")
    @JsonProperty("XH")
    private String XH;

    @ApiModelProperty(value = "疾病或阳性体征的名称")
    @TableField("REC_CONTENT")
    @JsonProperty("REC_CONTENT")
    private String recContent;

    @ApiModelProperty(value = "1－疾病诊断 2－阳性发现 3职业")
    @TableField("REC_CLASS")
    @JsonProperty("REC_CLASS")
    private String recClass;
}
