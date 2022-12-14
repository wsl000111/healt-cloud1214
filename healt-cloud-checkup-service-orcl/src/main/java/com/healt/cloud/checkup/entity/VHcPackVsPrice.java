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
 * @since 2022-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_HC_PACK_VS_PRICE")
@ApiModel(value="VHcPackVsPrice对象", description="")
public class VHcPackVsPrice implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @TableField("CLINIC_ITEM_CODE")
    @JsonProperty("CLINIC_ITEM_CODE")
    private String clinicItemCode;

    @TableField("CLINIC_ITEM_NAME")
    @JsonProperty("CLINIC_ITEM_NAME")
    private String clinicItemName;

    @TableField("ITEM_CLASS")
    @JsonProperty("ITEM_CLASS")
    private String itemClass;

    @TableField("CHARGE_ITEM_CODE")
    @JsonProperty("CHARGE_ITEM_CODE")
    private String chargeItemCode;

    @TableField("CHARGE_ITEM_NAME")
    @JsonProperty("CHARGE_ITEM_NAME")
    private String chargeItemName;

    @TableField("CHARGE_ITEM_CLASS")
    @JsonProperty("CHARGE_ITEM_CLASS")
    private String chargeItemClass;

    @TableField("CHARGE_PRICEMONEY")
    @JsonProperty("CHARGE_PRICEMONEY")
    private BigDecimal chargePricemoney;

    @TableField("OUTP_RCPT_CODE")
    @JsonProperty("OUTP_RCPT_CODE")
    private String outpRcptCode;

    @TableField("ITEM_UNIT")
    @JsonProperty("ITEM_UNIT")
    private String itemUnit;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
