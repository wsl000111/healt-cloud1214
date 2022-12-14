package com.healt.cloud.checkup.entity;

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
 * 体检项目结果关键字模板
 * </p>
 *
 * @author GuYue
 * @since 2022-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_ITEM_REPORT_WRITE_DICT")
@ApiModel(value="HcItemReportWriteDict对象", description="体检项目结果关键字模板")
public class HcItemReportWriteDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "项目编码")
    @TableId(value = "HC_ITEM_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("HC_ITEM_CODE")
    private String hcItemCode;

    @ApiModelProperty(value = "报告内容")
    @TableField("KEY_NAME")
    @JsonProperty("KEY_NAME")
    private String keyName;

    @ApiModelProperty(value = "序号")
    @TableField("ORDER_NO")
    @JsonProperty("ORDER_NO")
    private Integer orderNo;

    @ApiModelProperty(value = "结果描述")
    @TableField("ITEM_DESC")
    @JsonProperty("ITEM_DESC")
    private String itemDesc;

    @ApiModelProperty(value = "是否阳性")
    @TableField("DISEASE_SIGN")
    @JsonProperty("DISEASE_SIGN")
    private String diseaseSign;

    @ApiModelProperty(value = "对应诊断")
    @TableField("DIAGNOSIS")
    @JsonProperty("DIAGNOSIS")
    private String diagnosis;

    @ApiModelProperty(value = "名称是否进入阳性体征")
    @TableField("ITEM_NAME_FLAG")
    @JsonProperty("ITEM_NAME_FLAG")
    private String itemNameFlag;

    @ApiModelProperty(value = "输入码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @ApiModelProperty(value = "自定义输入码")
    @TableField("INPUT_CODE_CUST")
    @JsonProperty("INPUT_CODE_CUST")
    private String inputCodeCust;

    @ApiModelProperty(value = "医院编码")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
