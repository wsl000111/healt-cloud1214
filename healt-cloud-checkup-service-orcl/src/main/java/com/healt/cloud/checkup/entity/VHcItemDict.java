package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2022-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_HC_ITEM_DICT")
@ApiModel(value="VHcItemDict对象", description="")
public class VHcItemDict implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("ITEM_CODE")
    @JsonProperty("ITEM_CODE")
    private String itemCode;

    @TableField("ITEM_NAME")
    @JsonProperty("ITEM_NAME")
    private String itemName;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @TableField("HC_DEPT_CODE")
    @JsonProperty("HC_DEPT_CODE")
    private String hcDeptCode;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @TableField("INPUT_TYPE")
    @JsonProperty("INPUT_TYPE")
    private String inputType;

    @TableField("RESULT_TYPE")
    @JsonProperty("RESULT_TYPE")
    private String resultType;

    @TableField("NORMAL_VALUE")
    @JsonProperty("NORMAL_VALUE")
    private String normalValue;

    @TableField("DEFAULT_VALUE")
    @JsonProperty("DEFAULT_VALUE")
    private String defaultValue;

    @TableField("UNIT")
    @JsonProperty("UNIT")
    private String unit;

    @TableField("TOP_LIMIT")
    @JsonProperty("TOP_LIMIT")
    private BigDecimal topLimit;

    @TableField("BOTTOM_LIMIT")
    @JsonProperty("BOTTOM_LIMIT")
    private BigDecimal bottomLimit;

    @TableField("FMTOP_LIMIT")
    @JsonProperty("FMTOP_LIMIT")
    private BigDecimal fmtopLimit;

    @TableField("FMBOTTOM_LIMIT")
    @JsonProperty("FMBOTTOM_LIMIT")
    private BigDecimal fmbottomLimit;

    @TableField("PRINT_CONTEXT")
    @JsonProperty("PRINT_CONTEXT")
    private String printContext;

    @TableField("DESCRIBES")
    @JsonProperty("DESCRIBES")
    private String describes;

    @TableField("ADVICE")
    @JsonProperty("ADVICE")
    private String advice;

    @TableField("NOTES")
    @JsonProperty("NOTES")
    private String notes;

    @TableField("EFFECTIVE_FLAG")
    @JsonProperty("EFFECTIVE_FLAG")
    private String effectiveFlag;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("ITEM_PRICE")
    @JsonProperty("ITEM_PRICE")
    private BigDecimal itemPrice;


}
