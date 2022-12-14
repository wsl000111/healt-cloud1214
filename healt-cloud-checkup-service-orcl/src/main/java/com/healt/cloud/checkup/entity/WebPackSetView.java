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
 * @since 2022-09-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WEB_PACK_SET_VIEW")
@ApiModel(value="WebPackSetView对象", description="")
public class WebPackSetView implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("SET_CODE")
    @JsonProperty("SET_CODE")
    private String setCode;

    @TableField("SET_NAME")
    @JsonProperty("SET_NAME")
    private String setName;

    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @TableField("SET_AMOUNT")
    @JsonProperty("SET_AMOUNT")
    private BigDecimal setAmount;

    @TableField("SET_DISCOUNT_AMOUNT")
    @JsonProperty("SET_DISCOUNT_AMOUNT")
    private BigDecimal setDiscountAmount;

    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @TableField("ITEM_PACK_PRICE")
    @JsonProperty("ITEM_PACK_PRICE")
    private BigDecimal itemPackPrice;

    @TableField("IS_DISCOUNT")
    @JsonProperty("IS_DISCOUNT")
    private String isDiscount;


}
