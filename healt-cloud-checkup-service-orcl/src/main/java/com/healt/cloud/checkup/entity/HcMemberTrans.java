package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * 会员卡交易记录
 * </p>
 *
 * @author linklee
 * @since 2022-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_MEMBER_TRANS")
@ApiModel(value="HcMemberTrans对象", description="会员卡交易记录")
public class HcMemberTrans implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "卡号")
    @TableField("CARD_NO")
    @JsonProperty("CARD_NO")
    private String cardNo;

    @ApiModelProperty(value = "交易号")
    @TableField("TRANS_NO")
    @JsonProperty("TRANS_NO")
    private String transNo;

    @ApiModelProperty(value = "交易类型?充值 退款 结算 退费 过户")
    @TableField("TRANS_TYPE")
    @JsonProperty("TRANS_TYPE")
    private String transType;

    @ApiModelProperty(value = "交易方式?现金 支票 微信")
    @TableField("PAY")
    @JsonProperty("PAY")
    private String pay;

    @ApiModelProperty(value = "金额")
    @TableField("MONEY")
    @JsonProperty("MONEY")
    private BigDecimal money;

    @ApiModelProperty(value = "交易日期")
    @TableField("TRANS_DATE")
    @JsonProperty("TRANS_DATE")
    private Date transDate;

    @ApiModelProperty(value = "操作员")
    @TableField("USER_ID")
    @JsonProperty("USER_ID")
    private String userId;

    @ApiModelProperty(value = "备注")
    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;


}
