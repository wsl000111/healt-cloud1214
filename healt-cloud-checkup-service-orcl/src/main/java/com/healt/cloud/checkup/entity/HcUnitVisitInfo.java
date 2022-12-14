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
 * 单位体检信息
 * </p>
 *
 * @author linklee
 * @since 2022-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_UNIT_VISIT_INFO")
@ApiModel(value="HcUnitVisitInfo对象", description="单位体检信息")
public class HcUnitVisitInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
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

    @ApiModelProperty(value = "单位名称")
    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

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

    @ApiModelProperty(value = "上级单位")
    @TableField("PARENT_CODE")
    @JsonProperty("PARENT_CODE")
    private String parentCode;

    @ApiModelProperty(value = "上级单位名称")
    @TableField("PARENT_NAME")
    @JsonProperty("PARENT_NAME")
    private String parentName;

    @ApiModelProperty(value = "建档日期")
    @TableField("REGISTER_DATE")
    @JsonProperty("REGISTER_DATE")
    private Date registerDate;

    @ApiModelProperty(value = "注册人编号")
    @TableField("USER_ID")
    @JsonProperty("USER_ID")
    private String userId;

    @ApiModelProperty(value = "注册人")
    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;

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

    @ApiModelProperty(value = "完成金额")
    @TableField("FINISHED_COSTS")
    @JsonProperty("FINISHED_COSTS")
    private BigDecimal finishedCosts;

    @ApiModelProperty(value = "完成实收")
    @TableField("FINISHED_CHARGES")
    @JsonProperty("FINISHED_CHARGES")
    private BigDecimal finishedCharges;


}
