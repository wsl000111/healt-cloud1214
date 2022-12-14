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
 * 支付表
 * </p>
 *
 * @author linklee
 * @since 2022-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_RCPT_PAY")
@ApiModel(value="HcRcptPay对象", description="支付表")
public class HcRcptPay implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "单据号码")
    @TableField("RCPT_NO")
    @JsonProperty("RCPT_NO")
    private String rcptNo;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "金额")
    @TableField("PAYMENT_MONEY")
    @JsonProperty("PAYMENT_MONEY")
    private BigDecimal paymentMoney;

    @ApiModelProperty(value = "会员卡医保卡 银联卡等")
    @TableField("CARD_NO")
    @JsonProperty("CARD_NO")
    private String cardNo;

    @ApiModelProperty(value = "支付类型")
    @TableField("PAYMENT_TYPE")
    @JsonProperty("PAYMENT_TYPE")
    private String paymentType;


}
