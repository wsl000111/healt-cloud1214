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
 * @create 2022-05-31 10:37
 */
@Data
public class SettleMasterQueryVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "收费日期")
    @TableField("SETTLING_DATE")
    @JsonProperty("SETTLING_DATE")
    private String settlingDate;

    @ApiModelProperty(value = "单据号码")
    @TableField("RCPT_NO")
    @JsonProperty("RCPT_NO")
    private String rcptNo;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "体检次数")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "个人编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "单位名称")
    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

    @ApiModelProperty(value = "人员名称")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "结账方式")
    @TableField("SETTLE_TYPE")
    @JsonProperty("SETTLE_TYPE")
    private String settleType;

    @ApiModelProperty(value = "单位 个人")
    @TableField("JION_FLAG")
    @JsonProperty("JION_FLAG")
    private String jionFlag;

    @ApiModelProperty(value = "应收")
    @TableField("COSTS")
    @JsonProperty("COSTS")
    private BigDecimal costs;

    @ApiModelProperty(value = "实收")
    @TableField("PAYMENTS")
    @JsonProperty("PAYMENTS")
    private BigDecimal payments;

    @ApiModelProperty(value = "抹零")
    @TableField("WIPING_ZERO")
    @JsonProperty("WIPING_ZERO")
    private BigDecimal wipingZero;

    @ApiModelProperty(value = "折扣率")
    @TableField("DISCOUNT_RATE")
    @JsonProperty("DISCOUNT_RATE")
    private BigDecimal discountRate;

    @ApiModelProperty(value = "折扣金额")
    @TableField("DISCOUNT_MONEY")
    @JsonProperty("DISCOUNT_MONEY")
    private BigDecimal discountMoney;

    @ApiModelProperty(value = "收费人姓名")
    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "退费单据号")
    @TableField("RETURN_REPT_NO")
    @JsonProperty("RETURN_REPT_NO")
    private String returnReptNo;

    @ApiModelProperty(value = "发票号")
    @TableField("INVOICE_NO")
    @JsonProperty("INVOICE_NO")
    private String invoiceNo;

}
