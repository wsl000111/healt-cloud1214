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
 * @create 2022-04-24 13:31
 */
@Data
public class SettlePayListVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
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
