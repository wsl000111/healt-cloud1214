package com.healt.cloud.checkup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
//import com.fasterxml.jackson.annotation.JsonInclude;//不返回null值字段
import com.fasterxml.jackson.annotation.JsonProperty;//前端传值有下划线

/**
 * <p>
 * 
 * </p>
 *
 * @author GuYue
 * @since 2022-05-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_EXAM_REPORT")
@ApiModel(value="VExamReport对象", description="")
public class VExamReport implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("EXAM_NO")
    @JsonProperty("EXAM_NO")
    private String examNo;

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

    @TableField("MEMO")
    @JsonProperty("MEMO")
    private String memo;

    @TableField("REPORT_DATE")
    @JsonProperty("REPORT_DATE")
    private Date reportDate;

    @TableField("CRITICAL_VALUES")
    @JsonProperty("CRITICAL_VALUES")
    private String criticalValues;

    @TableField("HIS_UNIT_CODE")
    @JsonProperty("HIS_UNIT_CODE")
    private String hisUnitCode;


}
