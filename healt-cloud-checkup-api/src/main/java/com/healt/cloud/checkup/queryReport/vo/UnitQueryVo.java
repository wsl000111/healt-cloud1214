package com.healt.cloud.checkup.queryReport.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-05-19 15:58
 */
@Data
public class UnitQueryVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "单位名称")
    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

    @ApiModelProperty(value = "别名")
    @TableField("UNIT_ALIAS")
    @JsonProperty("UNIT_ALIAS")
    private String unitAlias;

    @ApiModelProperty(value = "联系人")
    @TableField("CONTACTS")
    @JsonProperty("CONTACTS")
    private String contacts;

    @ApiModelProperty(value = "电话")
    @TableField("PHONE")
    @JsonProperty("PHONE")
    private String phone;

    @ApiModelProperty(value = "地址")
    @TableField("ADDRESS")
    @JsonProperty("ADDRESS")
    private String address;

    @ApiModelProperty(value = "体检次数")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "预约日期")
    @TableField("APPOINTS_DATE")
    @JsonProperty("APPOINTS_DATE")
    private Date appointsDate;

    @ApiModelProperty(value = "预约完成日期")
    @TableField("APPOINTS_END_DATE")
    @JsonProperty("APPOINTS_END_DATE")
    private Date appointsEndDate;

    @ApiModelProperty(value = "完成标志")
    @TableField("FINISHED_SIGN")
    @JsonProperty("FINISHED_SIGN")
    private String finishedSign;

    @ApiModelProperty(value = "完成时间")
    @TableField("FINISHED_DATE")
    @JsonProperty("FINISHED_DATE")
    private Date finishedDate;

    @ApiModelProperty(value = "完成人数")
    @TableField("FINISHED_PERSONS")
    @JsonProperty("FINISHED_PERSONS")
    private Integer finishedPersons;

    @ApiModelProperty(value = "来源")
    @TableField("SOURCE")
    @JsonProperty("SOURCE")
    private String source;

    @ApiModelProperty(value = "单位类型")
    @TableField("UNIT_TYPE")
    @JsonProperty("UNIT_TYPE")
    private String unitType;

    @ApiModelProperty(value = "体检类型")
    @TableField("CLASS_TYPE")
    @JsonProperty("CLASS_TYPE")
    private String classType;

    @ApiModelProperty(value = "体检费别")
    @TableField("CHARGE_TYPE")
    @JsonProperty("CHARGE_TYPE")
    private String chargeType;

    @JsonProperty("COSTS")
    private String costs;

    @JsonProperty("PAYMENTS")
    private String payments;

    @JsonProperty("WIPING_ZERO")
    private String wipingZero;
}
