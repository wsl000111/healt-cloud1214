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
 * 
 * </p>
 *
 * @author GuYue
 * @since 2022-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_CLINIC_ITEMS")
@ApiModel(value="VClinicItems对象", description="")
public class VClinicItems implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("ITEM_NAME")
    @JsonProperty("ITEM_NAME")
    private String itemName;

    @TableField("ITEM_CLASS")
    @JsonProperty("ITEM_CLASS")
    private String itemClass;

    @TableField("ITEM_CODE")
    @JsonProperty("ITEM_CODE")
    private String itemCode;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @TableField("EXPAND3")
    @JsonProperty("EXPAND3")
    private String expand3;


}
