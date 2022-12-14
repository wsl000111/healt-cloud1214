package com.healt.cloud.checkup.vo.settlement;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author linklee
 * @create 2022-04-24 10:44
 */
@Data
public class SettleItemListVo implements Serializable {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

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

    @ApiModelProperty(value = "体检次数")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "项目编码")
    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @ApiModelProperty(value = "数量")
    @TableField("NUM")
    @JsonProperty("NUM")
    private BigDecimal num;

    @ApiModelProperty(value = "是否加项")
    @TableField("ADD_ITEM")
    @JsonProperty("ADD_ITEM")
    private String addItem;

    @ApiModelProperty(value = "套餐编码")
    @TableField("SET_CODE")
    @JsonProperty("SET_CODE")
    private String setCode;

    @ApiModelProperty(value = "应收")
    @TableField("COSTS")
    @JsonProperty("COSTS")
    private BigDecimal costs;

    @ApiModelProperty(value = "实收")
    @TableField("CHARGES")
    @JsonProperty("CHARGES")
    private BigDecimal charges;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @TableField("IS_DISCOUNT")
    @JsonProperty("IS_DISCOUNT")
    private String isDiscount;

    @TableField("PACK_CLASS")
    @JsonProperty("PACK_CLASS")
    private String packClass;

    @TableField("CLASS_NAME")
    @JsonProperty("CLASS_NAME")
    private String className;

    @TableField("ZL_ITEM_CODE")
    @JsonProperty("ZL_ITEM_CODE")
    private String zlItemCode;

    @TableField("ZL_ITEM_NAME")
    @JsonProperty("ZL_ITEM_NAME")
    private String zlItemName;



}
