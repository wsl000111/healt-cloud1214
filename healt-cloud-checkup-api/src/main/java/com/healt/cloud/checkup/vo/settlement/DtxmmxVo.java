package com.healt.cloud.checkup.vo.settlement;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author linklee
 * @create 2022-05-03 15:45
 */
@Data
public class DtxmmxVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "人员编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "单位名称")
    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

    @ApiModelProperty(value = "项目编码")
    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "姓名")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @TableField("COST_CLASS_NAME")
    @JsonProperty("COST_CLASS_NAME")
    private String costClassName;

    @ApiModelProperty(value = "数量")
    @TableField("NUM")
    @JsonProperty("NUM")
    private BigDecimal num;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "应收")
    @TableField("COSTS")
    @JsonProperty("COSTS")
    private BigDecimal costs;

    @ApiModelProperty(value = "实收")
    @TableField("CHARGES")
    @JsonProperty("CHARGES")
    private BigDecimal charges;

    @ApiModelProperty(value = "缴费标志")
    @TableField("BILL_INDICATOR")
    @JsonProperty("BILL_INDICATOR")
    private String billIndicator;

    @TableField("DISCOUNT_RATE")
    @JsonProperty("DISCOUNT_RATE")
    private String discountRate;

    @ApiModelProperty(value = "完成标志")
    @TableField("FINISHED_SIGN")
    @JsonProperty("FINISHED_SIGN")
    private String finishedSign;

    @ApiModelProperty(value = "是否加项")
    @TableField("ADD_ITEM")
    @JsonProperty("ADD_ITEM")
    private String addItem;

    @ApiModelProperty(value = "套餐编码")
    @TableField("SET_CODE")
    @JsonProperty("SET_CODE")
    private String setCode;

    @ApiModelProperty(value = "是否折扣")
    @TableField("IS_DISCOUNT")
    @JsonProperty("IS_DISCOUNT")
    private String isDiscount;

    @ApiModelProperty(value = "是否折扣")
    @TableField("ZL_ITEM_CODE")
    @JsonProperty("ZL_ITEM_CODE")
    private String zlItemCode;

    @ApiModelProperty(value = "是否折扣")
    @TableField("ZL_ITEM_NAME")
    @JsonProperty("ZL_ITEM_NAME")
    private String zlItemName;

}
