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
 * @since 2022-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_CLINIC_PARTS")
@ApiModel(value="VClinicParts对象", description="")
public class VClinicParts implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("CLINIC_ITEM_CODE")
    @JsonProperty("CLINIC_ITEM_CODE")
    private String clinicItemCode;

    @TableField("CLINIC_ITEM_NAME")
    @JsonProperty("CLINIC_ITEM_NAME")
    private String clinicItemName;

    @TableField("PARTS_VALUE")
    @JsonProperty("PARTS_VALUE")
    private String partsValue;

    @TableField("PARTS_NAME")
    @JsonProperty("PARTS_NAME")
    private String partsName;


}
