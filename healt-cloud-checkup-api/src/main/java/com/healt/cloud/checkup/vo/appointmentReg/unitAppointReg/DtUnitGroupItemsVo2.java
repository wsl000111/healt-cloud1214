package com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author GuYue
 * @date 2022-04-18 10:25
 * @description: TODO
 */
@Data
public class DtUnitGroupItemsVo2 implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "分组编码")
    @TableId(value = "GROUP_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("GROUP_CODE")
    private String groupCode;

    @ApiModelProperty(value = "分组名称")
    @TableField("GROUP_NAME")
    @JsonProperty("GROUP_NAME")
    private String groupName;

    @ApiModelProperty(value = "组合编码")
    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "组合名称")
    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @ApiModelProperty(value = "来源套餐名称")
    @TableField("SOURCE_NAME")
    @JsonProperty("SOURCE_NAME")
    private String sourceName;

    @ApiModelProperty(value = "机构编码")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "体检次数")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "允许打折")
    @TableField("DISCOUNT_FLAG")
    @JsonProperty("DISCOUNT_FLAG")
    private String discountFlag;

    @ApiModelProperty(value = "价格")
    @TableField("PRICE")
    @JsonProperty("PRICE")
    private BigDecimal price;

    @ApiModelProperty(value = "医保价格")
    @TableField("INSURANCE_PRICE")
    @JsonProperty("INSURANCE_PRICE")
    private BigDecimal insurancePrice;

    @ApiModelProperty(value = "数量")
    @TableField("NUM")
    @JsonProperty("NUM")
    private BigDecimal num;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @TableField("CLASS_NAME")
    @JsonProperty("CLASS_NAME")
    private String className;
}
