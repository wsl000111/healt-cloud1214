package com.healt.cloud.checkup.entity;

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
 * 体检单位传HIS收费临时表
 * </p>
 *
 * @author GuYue
 * @since 2022-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("COMPANY_COST_BACK")
@ApiModel(value="CompanyCostBack对象", description="体检单位传HIS收费临时表")
public class CompanyCostBack implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "体检单位ID")
    @TableField("EXAMCOMPANYID")
    @JsonProperty("EXAMCOMPANYID")
    private String examcompanyid;

    @ApiModelProperty(value = "体检单位编号")
    @TableField("EXAMCOMPANYNO")
    @JsonProperty("EXAMCOMPANYNO")
    private String examcompanyno;

    @ApiModelProperty(value = "体检单位名称")
    @TableField("EXAMCOMPANYNAME")
    @JsonProperty("EXAMCOMPANYNAME")
    private String examcompanyname;

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

    @ApiModelProperty(value = "申请时间")
    @TableField("APPLYDATE")
    @JsonProperty("APPLYDATE")
    private String applydate;

    @ApiModelProperty(value = "院区编码")
    @TableField("AREACODE")
    @JsonProperty("AREACODE")
    private String areacode;

    @ApiModelProperty(value = "1 发起申请，2 撤销申请")
    @TableField("CANCTYPE")
    @JsonProperty("CANCTYPE")
    private String canctype;

    @ApiModelProperty(value = "体检系统中费用唯一 ID")
    @TableField("ORDERID")
    @JsonProperty("ORDERID")
    private String orderid;

    @ApiModelProperty(value = "诊疗项目分类")
    @TableField("CLINICTYPE")
    @JsonProperty("CLINICTYPE")
    private String clinictype;

    @ApiModelProperty(value = "项目分类")
    @TableField("FEEITEMCLASS")
    @JsonProperty("FEEITEMCLASS")
    private String feeitemclass;

    @ApiModelProperty(value = "诊疗项目 ID")
    @TableField("CLINICITEMID")
    @JsonProperty("CLINICITEMID")
    private String clinicitemid;

    @ApiModelProperty(value = "数量")
    @TableField("NUM")
    @JsonProperty("NUM")
    private String num;

    @ApiModelProperty(value = "数量单位")
    @TableField("UNIT")
    @JsonProperty("UNIT")
    private String unit;

    @ApiModelProperty(value = "单价")
    @TableField("UNITPRICE")
    @JsonProperty("UNITPRICE")
    private String unitprice;

    @ApiModelProperty(value = "应收费用")
    @TableField("RECEIVABLEPRICE")
    @JsonProperty("RECEIVABLEPRICE")
    private String receivableprice;

    @ApiModelProperty(value = "优惠费用")
    @TableField("DISCOUNTSPRICE")
    @JsonProperty("DISCOUNTSPRICE")
    private String discountsprice;

    @ApiModelProperty(value = "实收费用")
    @TableField("REALPRICE")
    @JsonProperty("REALPRICE")
    private String realprice;

    @ApiModelProperty(value = "操作员编码")
    @TableField("OPERATOR")
    @JsonProperty("OPERATOR")
    private String operator;

    @ApiModelProperty(value = "用于存储体检系统本次团检缴费人次")
    @TableField("DESC_BZ")
    @JsonProperty("DESC_BZ")
    private String descBz;

    @ApiModelProperty(value = "消息ID作为主键之一")
    @TableField("MSGID")
    @JsonProperty("MSGID")
    private String msgid;

    @ApiModelProperty(value = "结算标识")
    @TableField("REKID")
    @JsonProperty("REKID")
    private String rekid;

    @ApiModelProperty(value = "单位ID")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "单位体检次数")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private String unitVisitId;


}
