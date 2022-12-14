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
 * 
 * </p>
 *
 * @author GuYue
 * @since 2022-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_HOSPITAL_DICT")
@ApiModel(value="VHospitalDict对象", description="")
public class VHospitalDict implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("HOSPITAL_NAME")
    @JsonProperty("HOSPITAL_NAME")
    private String hospitalName;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @TableField("POST_CODE")
    @JsonProperty("POST_CODE")
    private String postCode;

    @TableField("EMAIL")
    @JsonProperty("EMAIL")
    private String email;

    @TableField("GREETING")
    @JsonProperty("GREETING")
    private String greeting;

    @TableField("TIPS")
    @JsonProperty("TIPS")
    private String tips;

    @TableField("FOOTER")
    @JsonProperty("FOOTER")
    private String footer;

    @TableField("INITIAL_CHARGE")
    @JsonProperty("INITIAL_CHARGE")
    private String initialCharge;

    @TableField("INITIAL_RETURNS")
    @JsonProperty("INITIAL_RETURNS")
    private String initialReturns;

    @TableField("NEXT_CHARGE_NO")
    @JsonProperty("NEXT_CHARGE_NO")
    private BigDecimal nextChargeNo;

    @TableField("NEXT_RETURNS_NO")
    @JsonProperty("NEXT_RETURNS_NO")
    private BigDecimal nextReturnsNo;

    @TableField("INITIAL_LAB")
    @JsonProperty("INITIAL_LAB")
    private String initialLab;

    @TableField("INITIAL_EXAM")
    @JsonProperty("INITIAL_EXAM")
    private String initialExam;

    @TableField("IS_CHECK_CHARGE")
    @JsonProperty("IS_CHECK_CHARGE")
    private String isCheckCharge;

    @TableField("OPEN_INSURANCE")
    @JsonProperty("OPEN_INSURANCE")
    private String openInsurance;

    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;


}
