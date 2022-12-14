package com.healt.cloud.checkup.vo.busniess.packClinic;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author GuYue
 * @since 2022-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_CLINIC_ITEMS")
@ApiModel(value="VClinicItems对象", description="")
public class VClinicItemsVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("ITEM_NAME")
    @JsonProperty("ITEM_NAME")
    private String itemName;

    @TableField("ITEM_NAME")
    @JsonProperty("NAME")
    private String name;

    @TableField("ITEM_CLASS")
    @JsonProperty("ITEM_CLASS")
    private String itemClass;

    @TableField("ITEM_CODE")
    @JsonProperty("ITEM_CODE")
    private String itemCode;

    @TableField("ITEM_CODE")
    @JsonProperty("CODE")
    private String code;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @TableField("EXPAND3")
    @JsonProperty("EXPAND3")
    private String expand3;

    @TableField("PRICE_MONEY")
    @JsonProperty("PRICE_MONEY")
    private BigDecimal priceMoney;
}
