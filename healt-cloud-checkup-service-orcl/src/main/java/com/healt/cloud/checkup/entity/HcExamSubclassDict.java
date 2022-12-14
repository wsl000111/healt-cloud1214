package com.healt.cloud.checkup.entity;

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
 * 检查类别记录
 * </p>
 *
 * @author GuYue
 * @since 2022-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_EXAM_SUBCLASS_DICT")
@ApiModel(value="HcExamSubclassDict对象", description="检查类别记录")
public class HcExamSubclassDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "检查类别序号")
    @TableField("SERIAL_NO")
    @JsonProperty("SERIAL_NO")
    private Integer serialNo;

    @ApiModelProperty(value = "检查类别名字")
    @TableId(value = "EXAM_CLASS_NAME", type = IdType.ASSIGN_ID)
    @JsonProperty("EXAM_CLASS_NAME")
    private String examClassName;

    @ApiModelProperty(value = "检查子类名字")
    @TableField("EXAM_SUBCLASS_NAME")
    @JsonProperty("EXAM_SUBCLASS_NAME")
    private String examSubclassName;

    @ApiModelProperty(value = "检查类别输入码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @ApiModelProperty(value = "医院编号")
    @TableField("HIS_UNIT_CODE")
    @JsonProperty("HIS_UNIT_CODE")
    private String hisUnitCode;

    @ApiModelProperty(value = "本地检查类别")
    @TableField("LOACAL_ID_CLASS")
    @JsonProperty("LOACAL_ID_CLASS")
    private String loacalIdClass;


}
