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
 * 收费主表
 * </p>
 *
 * @author GuYue
 * @since 2022-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_SETTLE_MASTER")
@ApiModel(value="HcSettleMaster对象", description="收费主表")
public class HcSettleMaster implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "体检次数")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "单据号码")
    @TableField("RCPT_NO")
    @JsonProperty("RCPT_NO")
    private String rcptNo;

    @ApiModelProperty(value = "个人编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "收费日期")
    @TableField("SETTLING_DATE")
    @JsonProperty("SETTLING_DATE")
    private Date settlingDate;

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

    @ApiModelProperty(value = "收费人")
    @TableField("USER_ID")
    @JsonProperty("USER_ID")
    private String userId;

    @ApiModelProperty(value = "收费人姓名")
    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "发票号")
    @TableField("INVOICE_NO")
    @JsonProperty("INVOICE_NO")
    private String invoiceNo;

    @ApiModelProperty(value = "退费单据号")
    @TableField("RETURN_REPT_NO")
    @JsonProperty("RETURN_REPT_NO")
    private String returnReptNo;

    @ApiModelProperty(value = "结账号")
    @TableField("ACCT_NO")
    @JsonProperty("ACCT_NO")
    private String acctNo;

    @ApiModelProperty(value = "到账标志")
    @TableField("FINISH_FLAG")
    @JsonProperty("FINISH_FLAG")
    private String finishFlag;

    @ApiModelProperty(value = "到账时间")
    @TableField("FINISH_DATE")
    @JsonProperty("FINISH_DATE")
    private Date finishDate;

    @ApiModelProperty(value = "到账收入人，系统用户")
    @TableField("FINISH_USER_CODE")
    @JsonProperty("FINISH_USER_CODE")
    private String finishUserCode;

    @TableField("RETURN_FLAG")
    @JsonProperty("RETURN_FLAG")
    private String returnFlag;

    @TableField("PRINT_FLAG")
    @JsonProperty("PRINT_FLAG")
    private String printFlag;

    @TableField("PRINT_GRANT_USER")
    @JsonProperty("PRINT_GRANT_USER")
    private String printGrantUser;


}
