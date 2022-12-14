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
 * 机构代码表
 * </p>
 *
 * @author GuYue
 * @since 2022-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HOSPITAL_DICT")
@ApiModel(value="HospitalDict对象", description="机构代码表")
public class HospitalDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "机构名称")
    @TableField("HOSPITAL_NAME")
    @JsonProperty("HOSPITAL_NAME")
    private String hospitalName;

    @ApiModelProperty(value = "拼音简写")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @ApiModelProperty(value = "邮政编码")
    @TableField("POST_CODE")
    @JsonProperty("POST_CODE")
    private String postCode;

    @ApiModelProperty(value = "电子邮箱")
    @TableField("EMAIL")
    @JsonProperty("EMAIL")
    private String email;

    @ApiModelProperty(value = "联系电话")
    @TableField("TEL")
    @JsonProperty("TEL")
    private String tel;

    @ApiModelProperty(value = "出现在主检报告补充说明中的")
    @TableField("GREETING")
    @JsonProperty("GREETING")
    private String greeting;

    @ApiModelProperty(value = "重要提示")
    @TableField("TIPS")
    @JsonProperty("TIPS")
    private String tips;

    @ApiModelProperty(value = "报告页脚")
    @TableField("FOOTER")
    @JsonProperty("FOOTER")
    private String footer;

    @ApiModelProperty(value = "收费单据首码")
    @TableField("INITIAL_CHARGE")
    @JsonProperty("INITIAL_CHARGE")
    private String initialCharge;

    @ApiModelProperty(value = "退费单据首码")
    @TableField("INITIAL_RETURNS")
    @JsonProperty("INITIAL_RETURNS")
    private String initialReturns;

    @ApiModelProperty(value = "下一收费单据号")
    @TableField("NEXT_CHARGE_NO")
    @JsonProperty("NEXT_CHARGE_NO")
    private BigDecimal nextChargeNo;

    @ApiModelProperty(value = "下一退费单据号")
    @TableField("NEXT_RETURNS_NO")
    @JsonProperty("NEXT_RETURNS_NO")
    private BigDecimal nextReturnsNo;

    @ApiModelProperty(value = "检验申请号首码")
    @TableField("INITIAL_LAB")
    @JsonProperty("INITIAL_LAB")
    private String initialLab;

    @ApiModelProperty(value = "检查申请号首码")
    @TableField("INITIAL_EXAM")
    @JsonProperty("INITIAL_EXAM")
    private String initialExam;

    @ApiModelProperty(value = "检查前判断收费")
    @TableField("IS_CHECK_CHARGE")
    @JsonProperty("IS_CHECK_CHARGE")
    private String isCheckCharge;

    @ApiModelProperty(value = "开启医保")
    @TableField("OPEN_INSURANCE")
    @JsonProperty("OPEN_INSURANCE")
    private String openInsurance;

    @ApiModelProperty(value = "备注")
    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;


}
