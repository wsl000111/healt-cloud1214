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
 * 单位信息
 * </p>
 *
 * @author GuYue
 * @since 2022-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_UNIT_INFO")
@ApiModel(value="HcUnitInfo对象", description="单位信息")
public class HcUnitInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "单位名称")
    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

    @ApiModelProperty(value = "拼音简码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

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

    @ApiModelProperty(value = "上级单位")
    @TableField("PARENT_CODE")
    @JsonProperty("PARENT_CODE")
    private String parentCode;

    @ApiModelProperty(value = "上级单位名称")
    @TableField("PARENT_NAME")
    @JsonProperty("PARENT_NAME")
    private String parentName;

    @ApiModelProperty(value = "备注")
    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;

    @ApiModelProperty(value = "团检0，散户1")
    @TableField("UNIT_OR_PERSON")
    @JsonProperty("UNIT_OR_PERSON")
    private String unitOrPerson;

    @ApiModelProperty(value = "业务员，对应users中id")
    @TableField("SALESMAN_CODE")
    @JsonProperty("SALESMAN_CODE")
    private String salesmanCode;

    @ApiModelProperty(value = "平台返回体检单位ID")
    @TableField("EXAMCOMPANYID")
    @JsonProperty("EXAMCOMPANYID")
    private String examcompanyid;


}
