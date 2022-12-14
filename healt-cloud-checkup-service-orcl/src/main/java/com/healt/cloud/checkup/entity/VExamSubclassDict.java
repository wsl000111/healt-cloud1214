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
 * @since 2022-03-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_EXAM_SUBCLASS_DICT")
@ApiModel(value="VExamSubclassDict对象", description="")
public class VExamSubclassDict implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("SERIAL_NO")
    @JsonProperty("SERIAL_NO")
    private String serialNo;

    @TableField("EXAM_CLASS_NAME")
    @JsonProperty("EXAM_CLASS_NAME")
    private String examClassName;

    @TableField("EXAM_SUBCLASS_NAME")
    @JsonProperty("EXAM_SUBCLASS_NAME")
    private String examSubclassName;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @TableField("LOACAL_ID_CLASS")
    @JsonProperty("LOACAL_ID_CLASS")
    private String loacalIdClass;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
