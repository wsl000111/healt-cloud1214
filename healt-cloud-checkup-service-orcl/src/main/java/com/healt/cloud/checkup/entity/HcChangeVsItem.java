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
 * 换项对照字典
 * </p>
 *
 * @author linklee
 * @since 2022-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_CHANGE_VS_ITEM")
@ApiModel(value="HcChangeVsItem对象", description="换项对照字典")
public class HcChangeVsItem implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构ID")
    @TableId(value = "HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "原项目代码")
    @TableField("ITEM_CODE")
    @JsonProperty("ITEM_CODE")
    private String itemCode;

    @ApiModelProperty(value = "原项目名称")
    @TableField("ITEM_NAME")
    @JsonProperty("ITEM_NAME")
    private String itemName;

    @ApiModelProperty(value = "拼音码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "原项目价格")
    @TableField("ITEM_PRICE")
    @JsonProperty("ITEM_PRICE")
    private BigDecimal itemPrice;

    @ApiModelProperty(value = "允许换成项目代码")
    @TableField("CHANGE_ITEM_CODE")
    @JsonProperty("CHANGE_ITEM_CODE")
    private String changeItemCode;

    @ApiModelProperty(value = "允许换成项目名称")
    @TableField("CHANGE_ITEM_NAME")
    @JsonProperty("CHANGE_ITEM_NAME")
    private String changeItemName;

    @ApiModelProperty(value = "拼音码")
    @TableField("CHANGE_INPUT_CODE")
    @JsonProperty("CHANGE_INPUT_CODE")
    private String changeInputCode;

    @ApiModelProperty(value = "换成项目单价")
    @TableField("CHANGE_ITEM_PRICE")
    @JsonProperty("CHANGE_ITEM_PRICE")
    private BigDecimal changeItemPrice;


}
