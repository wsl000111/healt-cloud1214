package com.healt.cloud.checkup.queryReport.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-05-28 15:16
 */
@Data
public class PersonItemsCostVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "收费日期")
    @TableField("SETTLING_DATE")
    @JsonProperty("SETTLING_DATE")
    private Date settlingDate;

    @ApiModelProperty(value = "项目编码")
    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @ApiModelProperty(value = "应收")
    @TableField("COSTS")
    @JsonProperty("COSTS")
    private BigDecimal costs;

    @ApiModelProperty(value = "实收")
    @TableField("PAYMENTS")
    @JsonProperty("PAYMENTS")
    private BigDecimal payments;

    @ApiModelProperty(value = "套餐编码")
    @TableField("SET_CODE")
    @JsonProperty("SET_CODE")
    private String setCode;

    @ApiModelProperty(value = "折扣率")
    @TableField("DISCOUNT_RATE")
    @JsonProperty("DISCOUNT_RATE")
    private BigDecimal discountRate;

    @TableField("CLASS_NAME")
    @JsonProperty("CLASS_NAME")
    private String className;
}
