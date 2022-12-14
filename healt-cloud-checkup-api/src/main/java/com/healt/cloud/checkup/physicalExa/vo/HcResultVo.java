package com.healt.cloud.checkup.physicalExa.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-05-23 16:15
 */
@Data
public class HcResultVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "个人编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "人员单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "单位体检次数")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "科室ID")
    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @ApiModelProperty(value = "科室名称")
    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "组合编码")
    @TableField("ITEM_ASSEM_CODE")
    @JsonProperty("ITEM_ASSEM_CODE")
    private String itemAssemCode;

    @ApiModelProperty(value = "组合名称")
    @TableField("ITEM_ASSEM_NAME")
    @JsonProperty("ITEM_ASSEM_NAME")
    private String itemAssemName;

    @ApiModelProperty(value = "项目编码")
    @TableField("HC_ITEM_CODE")
    @JsonProperty("HC_ITEM_CODE")
    private String hcItemCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("HC_ITEM_NAME")
    @JsonProperty("HC_ITEM_NAME")
    private String hcItemName;

    @ApiModelProperty(value = "组合排序")
    @TableField("ASSEM_SORT_NO")
    @JsonProperty("ASSEM_SORT_NO")
    private Integer assemSortNo;

    @ApiModelProperty(value = "项目排序")
    @TableField("ITEM_ORDER_NO")
    @JsonProperty("ITEM_ORDER_NO")
    private Integer itemOrderNo;

    @ApiModelProperty(value = "检查 还是 检验")
    @TableField("SHOW_TYPE")
    @JsonProperty("SHOW_TYPE")
    private String showType;

    @ApiModelProperty(value = "结果类型")
    @TableField("RESULT_TYPE")
    @JsonProperty("RESULT_TYPE")
    private String resultType;

    @ApiModelProperty(value = "结果的关键字，一般情况下与体检结果相同")
    @TableField("KEY_NAME")
    @JsonProperty("KEY_NAME")
    private String keyName;

    @ApiModelProperty(value = "结果")
    @TableField("HC_RESULT")
    @JsonProperty("HC_RESULT")
    private String hcResult;

    @ApiModelProperty(value = "结果 数值型")
    @TableField("RESULT_DECIMAL")
    @JsonProperty("RESULT_DECIMAL")
    private BigDecimal resultDecimal;

    @ApiModelProperty(value = "结果时间")
    @TableField("RESULT_DATE")
    @JsonProperty("RESULT_DATE")
    private Date resultDate;

    @ApiModelProperty(value = "结果单位")
    @TableField("UNIT")
    @JsonProperty("UNIT")
    private String unit;

    @ApiModelProperty(value = "参考范围")
    @TableField("PRINT_CONTEXT")
    @JsonProperty("PRINT_CONTEXT")
    private String printContext;

    @ApiModelProperty(value = "正常标志 说明结果是否正常")
    @TableField("ABNORMAL_INDICATOR")
    @JsonProperty("ABNORMAL_INDICATOR")
    private String abnormalIndicator;

    @ApiModelProperty(value = "体检报告时间")
    @TableField("HC_RESULT_DATE")
    @JsonProperty("HC_RESULT_DATE")
    private Date hcResultDate;
}
