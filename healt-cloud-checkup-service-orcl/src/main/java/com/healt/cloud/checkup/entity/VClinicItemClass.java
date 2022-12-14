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
@TableName("V_CLINIC_ITEM_CLASS")
@ApiModel(value="VClinicItemClass对象", description="")
public class VClinicItemClass implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("SERIAL_NO")
    @JsonProperty("SERIAL_NO")
    private Integer serialNo;

    @TableField("CLASS_CODE")
    @JsonProperty("CLASS_CODE")
    private String classCode;

    @TableField("CLASS_NAME")
    @JsonProperty("CLASS_NAME")
    private String className;


}
