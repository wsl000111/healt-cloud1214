package com.healt.cloud.checkup.queryReport.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-06-02 15:59
 */
@Data
public class MoneyTypeVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "收费人")
    @TableField("USER_ID")
    @JsonProperty("USER_ID")
    private String userId;

    @ApiModelProperty(value = "收费人姓名")
    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "支付类型")
    @TableField("PAYMENT_TYPE")
    @JsonProperty("PAYMENT_TYPE")
    private String paymentType;
}
