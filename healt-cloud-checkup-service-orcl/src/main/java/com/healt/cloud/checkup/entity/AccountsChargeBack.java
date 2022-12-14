package com.healt.cloud.checkup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
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
 * 团检收费状态回传表
 * </p>
 *
 * @author GuYue
 * @since 2022-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ACCOUNTS_CHARGE_BACK")
@ApiModel(value="AccountsChargeBack对象", description="团检收费状态回传表")
public class AccountsChargeBack implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "体检单位 ID")
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

    @ApiModelProperty(value = "院区编码")
    @TableField("APPLYORGCODE")
    @JsonProperty("APPLYORGCODE")
    private String applyorgcode;

    @ApiModelProperty(value = "医疗机构 ID")
    @TableField("MEDINSTID")
    @JsonProperty("MEDINSTID")
    private String medinstid;

    @ApiModelProperty(value = "医嘱 ID")
    @TableField("ORDERID")
    @JsonProperty("ORDERID")
    private String orderid;

    @ApiModelProperty(value = "结算序号")
    @TableField("REKNO")
    @JsonProperty("REKNO")
    private String rekno;

    @ApiModelProperty(value = "结算标识")
    @TableField("REKID")
    @JsonProperty("REKID")
    private String rekid;

    @ApiModelProperty(value = "操作员编码")
    @TableField("OPERATOR")
    @JsonProperty("OPERATOR")
    private String operator;

    @ApiModelProperty(value = "操作时间")
    @TableField("OPERATETIME")
    @JsonProperty("OPERATETIME")
    private Date operatetime;

    @ApiModelProperty(value = "收费状态")
    @TableField("FEESTATUS")
    @JsonProperty("FEESTATUS")
    private String feestatus;

    @ApiModelProperty(value = "发票号")
    @TableField("INVOICEID")
    @JsonProperty("INVOICEID")
    private String invoiceid;


}
