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
 * 套餐模板
 * </p>
 *
 * @author GuYue
 * @since 2022-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_PACK_SET_DICT")
@ApiModel(value="HcPackSetDict对象", description="套餐模板")
public class HcPackSetDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "套餐编码")
    @TableId(value = "SET_CODE", type = IdType.ASSIGN_ID)
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


}
