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
 * 价表项目查询
 * </p>
 *
 * @author GuYue
 * @since 2022-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("MDM_CLINICPRICE_QUERY")
@ApiModel(value="MdmClinicpriceQuery对象", description="价表项目查询")
public class MdmClinicpriceQuery implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "价表项目 ID HIS 内部 ID")
    @TableField("PRICEID")
    @JsonProperty("PRICEID")
    private String priceid;

    @ApiModelProperty(value = "项目分类编码")
    @TableField("ITEMCLASS")
    @JsonProperty("ITEMCLASS")
    private String itemclass;

    @ApiModelProperty(value = "项目分类名称")
    @TableField("ITEMCLASSNAME")
    @JsonProperty("ITEMCLASSNAME")
    private String itemclassname;

    @ApiModelProperty(value = "项目编码")
    @TableField("ITEMCODE")
    @JsonProperty("ITEMCODE")
    private String itemcode;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEMNAME")
    @JsonProperty("ITEMNAME")
    private String itemname;

    @ApiModelProperty(value = "单位")
    @TableField("ITEMUNIT")
    @JsonProperty("ITEMUNIT")
    private String itemunit;

    @ApiModelProperty(value = "价格")
    @TableField("PRICEMONEY")
    @JsonProperty("PRICEMONEY")
    private String pricemoney;

    @ApiModelProperty(value = "生效时间 String 是 格 式 ：YYYYMMDDHHMMSS")
    @TableField("LATESTENABLETIME")
    @JsonProperty("LATESTENABLETIME")
    private String latestenabletime;

    @ApiModelProperty(value = "是否启用")
    @TableField("ISENABLE")
    @JsonProperty("ISENABLE")
    private String isenable;

    @ApiModelProperty(value = "拼音码")
    @TableField("PYCODE")
    @JsonProperty("PYCODE")
    private String pycode;

    @ApiModelProperty(value = "五笔码")
    @TableField("WBCODE")
    @JsonProperty("WBCODE")
    private String wbcode;

    @ApiModelProperty(value = "物价标准编码")
    @TableField("STANDARDCODE")
    @JsonProperty("STANDARDCODE")
    private String standardcode;

    @ApiModelProperty(value = "物价标准名称")
    @TableField("STANDARDNAME")
    @JsonProperty("STANDARDNAME")
    private String standardname;

    @ApiModelProperty(value = "手术等级")
    @TableField("OPERATIONLEVEL")
    @JsonProperty("OPERATIONLEVEL")
    private String operationlevel;

    @ApiModelProperty(value = "医疗分类监管编码")
    @TableField("REGULATORYCODE")
    @JsonProperty("REGULATORYCODE")
    private String regulatorycode;

    @ApiModelProperty(value = "治疗类型")
    @TableField("TREATMENTCLASS")
    @JsonProperty("TREATMENTCLASS")
    private String treatmentclass;

    @ApiModelProperty(value = "国家平台编码")
    @TableField("NATIONSTDCODE")
    @JsonProperty("NATIONSTDCODE")
    private String nationstdcode;

    @ApiModelProperty(value = "省平台编码")
    @TableField("PROVINCESTDCODE")
    @JsonProperty("PROVINCESTDCODE")
    private String provincestdcode;

    @ApiModelProperty(value = "院区编码")
    @TableField("AREACODE")
    @JsonProperty("AREACODE")
    private String areacode;

    @ApiModelProperty(value = "医疗机构编码")
    @TableField("MEDINSTCODE")
    @JsonProperty("MEDINSTCODE")
    private String medinstcode;

    @ApiModelProperty(value = "备注")
    @TableField("DESCN")
    @JsonProperty("DESCN")
    private String descn;


}
