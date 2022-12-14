package com.healt.cloud.checkup.queryReport.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author linklee
 * @create 2022-08-01 10:59
 */
@Data
public class SettleMasterQueryNewVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "收费日期")
    //@TableField("SETTLING_DATE")
    @JsonProperty("SETTLING_DATE")
    private String settlingDate;

    @ApiModelProperty(value = "单据号码")
    //@TableField("RCPT_NO")
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
    //@TableField("UNIT_NAME")
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
    //@TableField("SETTLE_TYPE")
    @JsonProperty("SETTLE_TYPE")
    private String settleType;

    //@TableField("JION_FLAG")
    @JsonProperty("INVOICE_NO")
    private String invoiceNo;

    @JsonProperty("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "应收")
    @TableField("COSTS")
    @JsonProperty("COSTS")
    private BigDecimal costs;

    @JsonProperty("CHARGES")
    private BigDecimal charges;

}
