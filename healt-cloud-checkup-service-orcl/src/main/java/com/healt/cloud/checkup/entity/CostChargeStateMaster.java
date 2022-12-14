package com.healt.cloud.checkup.entity;

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
 * HIS计费返回的收费状态主表
 * </p>
 *
 * @author GuYue
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("COST_CHARGE_STATE_MASTER")
@ApiModel(value="CostChargeStateMaster对象", description="HIS计费返回的收费状态主表")
public class CostChargeStateMaster implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
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

    @ApiModelProperty(value = "码表:BSS0002，0=未收、1= 已收、2=已退、3=红冲")
    @TableField("FEESTATUS")
    @JsonProperty("FEESTATUS")
    private String feestatus;

    @ApiModelProperty(value = "收费操作员")
    @TableField("OPERATOR")
    @JsonProperty("OPERATOR")
    private String operator;

    @ApiModelProperty(value = "收费操作时间")
    @TableField("OPERATETIME")
    @JsonProperty("OPERATETIME")
    private Date operatetime;

    @ApiModelProperty(value = "his结算收据号")
    @TableField("REKID")
    @JsonProperty("REKID")
    private String rekid;

    @ApiModelProperty(value = "his发票号码")
    @TableField("INVOICEID")
    @JsonProperty("INVOICEID")
    private String invoiceid;

    @ApiModelProperty(value = "申请医生编码")
    @TableField("APPLYDOCTORCODE")
    @JsonProperty("APPLYDOCTORCODE")
    private String applydoctorcode;

    @ApiModelProperty(value = "申请医生姓名")
    @TableField("APPLYDOCTORNAME")
    @JsonProperty("APPLYDOCTORNAME")
    private String applydoctorname;

    @ApiModelProperty(value = "申请科室编码")
    @TableField("APPLYORGCODE")
    @JsonProperty("APPLYORGCODE")
    private String applyorgcode;

    @ApiModelProperty(value = "申请科室名称")
    @TableField("APPLYORGNAME")
    @JsonProperty("APPLYORGNAME")
    private String applyorgname;

    @ApiModelProperty(value = "执行科室编码")
    @TableField("EXECORGCODE")
    @JsonProperty("EXECORGCODE")
    private String execorgcode;

    @ApiModelProperty(value = "执行科室名称")
    @TableField("EXECORGNAME")
    @JsonProperty("EXECORGNAME")
    private String execorgname;

    @ApiModelProperty(value = "执行标志执行标记（0=未执行,1=已 执 行 ,50= 取 消 执 行 , 码 表:EMR0010）")
    @TableField("EXECFLAG")
    @JsonProperty("EXECFLAG")
    private String execflag;

    @ApiModelProperty(value = "院区编码 ")
    @TableField("AREACODE")
    @JsonProperty("AREACODE")
    private String areacode;


}
