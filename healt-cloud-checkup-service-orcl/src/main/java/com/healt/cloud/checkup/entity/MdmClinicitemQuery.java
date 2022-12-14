package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * HIS诊疗项目信息查询
 * </p>
 *
 * @author GuYue
 * @since 2022-07-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("MDM_CLINICITEM_QUERY")
@ApiModel(value="MdmClinicitemQuery对象", description="HIS诊疗项目信息查询")
public class MdmClinicitemQuery implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "HIS 内部 ID， 服务调用者不能使用 ID 应 使用编码")
    @TableId(value = "CLINICID", type = IdType.ASSIGN_ID)
    @JsonProperty("CLINICID")
    private String clinicId;

    @ApiModelProperty(value = "诊疗项目编码")
    @TableField("ITEMCODE")
    @JsonProperty("ITEMCODE")
    private String itemCode;

    @ApiModelProperty(value = "诊疗项目名称")
    @TableField("ITEMNAME")
    @JsonProperty("ITEMNAME")
    private String itemName;

    @ApiModelProperty(value = "诊疗项目分类编码")
    @TableField("ITEMCLASS")
    @JsonProperty("ITEMCLASS")
    private String itemClass;

    @ApiModelProperty(value = "诊疗项目分类名称")
    @TableField("ITEMCLASSNAME")
    @JsonProperty("ITEMCLASSNAME")
    private String itemClassName;

    @ApiModelProperty(value = "物价码")
    @TableField("PRICESTDCODE")
    @JsonProperty("PRICESTDCODE")
    private String priceStdCode;

    @ApiModelProperty(value = "院区编码")
    @TableField("AREACODE")
    @JsonProperty("AREACODE")
    private String areaCode;

    @ApiModelProperty(value = "国家平台对照码")
    @TableField("NATIONSTDCODE")
    @JsonProperty("NATIONSTDCODE")
    private String nationStdCode;

    @ApiModelProperty(value = "省平台对照码")
    @TableField("PROVINCESTDCODE")
    @JsonProperty("PROVINCESTDCODE")
    private String provinceStdCode;

    @ApiModelProperty(value = "医疗机构编码")
    @TableField("MEDINSTCODE")
    @JsonProperty("MEDINSTCODE")
    private String medInstCode;

    @ApiModelProperty(value = "是否启用  1 可用 0 禁用")
    @TableField("ISENABLE")
    @JsonProperty("ISENABLE")
    private String isEnable;

    @ApiModelProperty(value = "数量")
    @TableField("DEFAULTQUANTITY")
    @JsonProperty("DEFAULTQUANTITY")
    private BigDecimal defaultQuantity;

    @ApiModelProperty(value = "零售价")
    @TableField("SALESPRICE")
    @JsonProperty("SALESPRICE")
    private BigDecimal salesPrice;

    @ApiModelProperty(value = "应收费用")
    @TableField("CHARGES")
    @JsonProperty("CHARGES")
    private BigDecimal charges;

    @ApiModelProperty(value = "规格")
    @TableField("SPEC")
    @JsonProperty("SPEC")
    private String spec;

    @ApiModelProperty(value = "单位")
    @TableField("ITEMUNIT")
    @JsonProperty("ITEMUNIT")
    private String itemUnit;

    @ApiModelProperty(value = "执行科室")
    @TableField("EXECORGCODE")
    @JsonProperty("EXECORGCODE")
    private String execOrgCode;

    @ApiModelProperty(value = "属性类别")
    @TableField("PROPERTYCLASS")
    @JsonProperty("PROPERTYCLASS")
    private String propertyClass;

    @ApiModelProperty(value = "属性类别名称")
    @TableField("PROPERTYCLASSNAME")
    @JsonProperty("PROPERTYCLASSNAME")
    private String propertyClassName;

    @ApiModelProperty(value = "备注")
    @TableField("DESCN")
    @JsonProperty("DESCN")
    private String descn;

    @ApiModelProperty(value = "拼音码")
    @TableField("PYCODE")
    @JsonProperty("PYCODE")
    private String pyCode;

    @ApiModelProperty(value = "五笔码")
    @TableField("WBCODE")
    @JsonProperty("WBCODE")
    private String wbCode;


}
