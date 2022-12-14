package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 项目字典
 * </p>
 *
 * @author GuYue
 * @since 2022-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_ITEM_DICT")
@ApiModel(value="HcItemDict对象", description="项目字典")
public class HcItemDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "项目编码")
    @TableField("ITEM_CODE")
    @JsonProperty("ITEM_CODE")
    private String itemCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEM_NAME")
    @JsonProperty("ITEM_NAME")
    private String itemName;

    @ApiModelProperty(value = "输入码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @ApiModelProperty(value = "体检科室")
    @TableField("HC_DEPT_CODE")
    @JsonProperty("HC_DEPT_CODE")
    private String hcDeptCode;

    @ApiModelProperty(value = "序号")
    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "输入类型")
    @TableField("INPUT_TYPE")
    @JsonProperty("INPUT_TYPE")
    private String inputType;

    @ApiModelProperty(value = "结果类型")
    @TableField("RESULT_TYPE")
    @JsonProperty("RESULT_TYPE")
    private String resultType;

    @ApiModelProperty(value = "正常值")
    @TableField("NORMAL_VALUE")
    @JsonProperty("NORMAL_VALUE")
    private String normalValue;

    @ApiModelProperty(value = "默认值")
    @TableField("DEFAULT_VALUE")
    @JsonProperty("DEFAULT_VALUE")
    private String defaultValue;

    @ApiModelProperty(value = "结果单位")
    @TableField("UNIT")
    @JsonProperty("UNIT")
    private String unit;

    @ApiModelProperty(value = "上限")
    @TableField("TOP_LIMIT")
    @JsonProperty("TOP_LIMIT")
    private BigDecimal topLimit;

    @ApiModelProperty(value = "下限")
    @TableField("BOTTOM_LIMIT")
    @JsonProperty("BOTTOM_LIMIT")
    private BigDecimal bottomLimit;

    @ApiModelProperty(value = "女性上限")
    @TableField("FMTOP_LIMIT")
    @JsonProperty("FMTOP_LIMIT")
    private BigDecimal fmtopLimit;

    @ApiModelProperty(value = "女性下限")
    @TableField("FMBOTTOM_LIMIT")
    @JsonProperty("FMBOTTOM_LIMIT")
    private BigDecimal fmbottomLimit;

    @ApiModelProperty(value = "打印内容")
    @TableField("PRINT_CONTEXT")
    @JsonProperty("PRINT_CONTEXT")
    private String printContext;

    @ApiModelProperty(value = "描述")
    @TableField("DESCRIBES")
    @JsonProperty("DESCRIBES")
    private String describes;

    @ApiModelProperty(value = "建议")
    @TableField("ADVICE")
    @JsonProperty("ADVICE")
    private String advice;

    @ApiModelProperty(value = "注释")
    @TableField("NOTES")
    @JsonProperty("NOTES")
    private String notes;

    @ApiModelProperty(value = "有效标志")
    @TableField("EFFECTIVE_FLAG")
    @JsonProperty("EFFECTIVE_FLAG")
    private String effectiveFlag;

    @ApiModelProperty(value = "机构编码")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "价格")
    @TableField("ITEM_PRICE")
    @JsonProperty("ITEM_PRICE")
    private BigDecimal itemPrice;


}
