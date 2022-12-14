package com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author GuYue
 * @date 2022-04-15 16:14
 * @description: TODO
 */
@Data
public class DtSetsVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "套餐编码")
    @TableId(value = "IS_GROUP")
    @JsonProperty("IS_GROUP")
    private String isGroup;

    @ApiModelProperty(value = "套餐编码")
    @TableId(value = "SET_CODE")
    @JsonProperty("SET_CODE")
    private String setCode;

    @ApiModelProperty(value = "套餐名称")
    @TableField("SET_NAME")
    @JsonProperty("SET_NAME")
    private String setName;

    @ApiModelProperty(value = "输入码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @ApiModelProperty(value = "项目序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "套餐金额")
    @TableField("SET_AMOUNT")
    @JsonProperty("SET_AMOUNT")
    private BigDecimal setAmount;

    @ApiModelProperty(value = "折扣率")
    @TableField("SET_DISCOUNT_AMOUNT")
    @JsonProperty("SET_DISCOUNT_AMOUNT")
    private BigDecimal setDiscountAmount;

    @ApiModelProperty(value = "有效标志")
    @TableField("EFFECTIVE_FLAG")
    @JsonProperty("EFFECTIVE_FLAG")
    private String effectiveFlag;

    @ApiModelProperty(value = "机构编码")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("IMG")
    @JsonProperty("IMG")
    private String img;
}
