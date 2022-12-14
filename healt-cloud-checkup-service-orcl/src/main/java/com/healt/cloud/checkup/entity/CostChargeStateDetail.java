package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * HIS计费返回的收费状态主表
 * </p>
 *
 * @author GuYue
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("COST_CHARGE_STATE_DETAIL")
@ApiModel(value="CostChargeStateDetail对象", description="HIS计费返回的收费状态主表")
public class CostChargeStateDetail implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "单位ID 个人用 0000")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "单位体检次数 ")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "个人收费的话个人体检ID")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "个人收费 体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "体检类别 1= 个人体检、2=单位体检")
    @TableField("EXAMTYPE")
    @JsonProperty("EXAMTYPE")
    private String examtype;

    @ApiModelProperty(value = "体检号 计费的时候拼的是 PERSON_ID_PERSON_VISIT_ID")
    @TableField("EXAMNO")
    @JsonProperty("EXAMNO")
    private String examno;

    @ApiModelProperty(value = "体检单位编号")
    @TableField("EXAMCOMPANYNO")
    @JsonProperty("EXAMCOMPANYNO")
    private String examcompanyno;

    @ApiModelProperty(value = "体检单位名称")
    @TableField("EXAMCOMPANYNAME")
    @JsonProperty("EXAMCOMPANYNAME")
    private String examcompanyname;

    @ApiModelProperty(value = "HIS人员ID")
    @TableField("PATIENTID")
    @JsonProperty("PATIENTID")
    private String patientid;

    @ApiModelProperty(value = "HIS人员就诊次数")
    @TableField("VISITID")
    @JsonProperty("VISITID")
    private String visitid;

    @ApiModelProperty(value = "收费状态 码表:BSS0002，0=未收、1= 已收、2=已退、3=红冲")
    @TableField("FEESTATUS")
    @JsonProperty("FEESTATUS")
    private String feestatus;

    @ApiModelProperty(value = "收据号")
    @TableField("REKID")
    @JsonProperty("REKID")
    private String rekid;

    @ApiModelProperty(value = "项目编码")
    @TableField("ITEMCODE")
    @JsonProperty("ITEMCODE")
    private String itemcode;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEMNAME")
    @JsonProperty("ITEMNAME")
    private String itemname;

    @ApiModelProperty(value = "项目单位")
    @TableField("ITEMUNIT")
    @JsonProperty("ITEMUNIT")
    private String itemunit;

    @ApiModelProperty(value = "项目单价")
    @TableField("UNITPRICE")
    @JsonProperty("UNITPRICE")
    private String unitprice;

    @ApiModelProperty(value = "数量")
    @TableField("NUM")
    @JsonProperty("NUM")
    private BigDecimal num;

    @ApiModelProperty(value = "项目金额")
    @TableField("ITEMPRICE")
    @JsonProperty("ITEMPRICE")
    private BigDecimal itemprice;


}
