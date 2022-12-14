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
 * 
 * </p>
 *
 * @author GuYue
 * @since 2022-08-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HIS_SPECIMAN_DICT")
@ApiModel(value="HisSpecimanDict对象", description="")
public class HisSpecimanDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "标本id")
    @TableField("ITEM_ID")
    @JsonProperty("ITEM_ID")
    private BigDecimal itemId;

    @ApiModelProperty(value = "标本名称")
    @TableId(value = "ITEM_NAME", type = IdType.ASSIGN_ID)
    @JsonProperty("ITEM_NAME")
    private String itemName;

    @ApiModelProperty(value = "标本值")
    @TableField("ITEM_VALUE")
    @JsonProperty("ITEM_VALUE")
    private String itemValue;

    @ApiModelProperty(value = "拼音码")
    @TableField("PY_CODE")
    @JsonProperty("PY_CODE")
    private String pyCode;

    @ApiModelProperty(value = "五笔码")
    @TableField("WB_CODE")
    @JsonProperty("WB_CODE")
    private String wbCode;


}
