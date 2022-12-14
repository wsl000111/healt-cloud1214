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
 * 体检组合项目对照HIS价表项目
 * </p>
 *
 * @author GuYue
 * @since 2022-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_PACK_VS_PRICE")
@ApiModel(value="HcPackVsPrice对象", description="体检组合项目对照HIS价表项目")
public class HcPackVsPrice implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "组合项目代码")
    @TableId(value = "ITEM_PACK_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "类别")
    @TableField("ITEM_CLASS")
    @JsonProperty("ITEM_CLASS")
    private String itemClass;

    @ApiModelProperty(value = "诊疗项目编码")
    @TableField("CLINIC_ITEM_CODE")
    @JsonProperty("CLINIC_ITEM_CODE")
    private String clinicItemCode;

    @ApiModelProperty(value = "诊疗项目名称")
    @TableField("CLINIC_ITEM_NAME")
    @JsonProperty("CLINIC_ITEM_NAME")
    private String clinicItemName;

    @ApiModelProperty(value = "价表项目")
    @TableField("CHARGE_ITEM_CODE")
    @JsonProperty("CHARGE_ITEM_CODE")
    private String chargeItemCode;

    @ApiModelProperty(value = "价表项目名称")
    @TableField("CHARGE_ITEM_NAME")
    @JsonProperty("CHARGE_ITEM_NAME")
    private String chargeItemName;

    @ApiModelProperty(value = "机构代码")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "价表项目类别")
    @TableField("CHARGE_ITEM_CLASS")
    @JsonProperty("CHARGE_ITEM_CLASS")
    private String chargeItemClass;

    @ApiModelProperty(value = "价表项目单价")
    @TableField("CHARGE_PRICEMONEY")
    @JsonProperty("CHARGE_PRICEMONEY")
    private BigDecimal chargePricemoney;

    @ApiModelProperty(value = "价表项目单位")
    @TableField("ITEM_UNIT")
    @JsonProperty("ITEM_UNIT")
    private String itemUnit;

}
