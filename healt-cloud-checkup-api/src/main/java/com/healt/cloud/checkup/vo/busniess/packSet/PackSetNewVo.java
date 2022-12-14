package com.healt.cloud.checkup.vo.busniess.packSet;

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
 * @create 2022-08-02 11:15
 */
@Data
public class PackSetNewVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "套餐编码")
    @TableId(value = "SET_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("SET_CODE")
    private String setCode;

    @ApiModelProperty(value = "套餐名称")
    @TableField("SET_NAME")
    @JsonProperty("SET_NAME")
    private String setName;

    @ApiModelProperty(value = "项目编码")
    @TableId(value = "ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @ApiModelProperty(value = "套餐金额")
    @TableField("SET_AMOUNT")
    @JsonProperty("SET_AMOUNT")
    private BigDecimal setAmount;

    @ApiModelProperty(value = "组合价格")
    @TableField("ITEM_PACK_PRICE")
    @JsonProperty("ITEM_PACK_PRICE")
    private BigDecimal itemPackPrice;

    @ApiModelProperty(value = "应收金额")
    @JsonProperty("YSJE")
    private BigDecimal ysje;

    @ApiModelProperty(value = "折扣率")
    @JsonProperty("ZKL")
    private BigDecimal zkl;

}
