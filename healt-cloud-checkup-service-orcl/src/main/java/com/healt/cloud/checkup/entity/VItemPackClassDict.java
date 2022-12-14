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
@TableName("V_ITEM_PACK_CLASS_DICT")
@ApiModel(value="VItemPackClassDict对象", description="")
public class VItemPackClassDict implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @TableField("CLASS_CODE")
    @JsonProperty("CLASS_CODE")
    private String classCode;

    @TableField("CLASS_NAME")
    @JsonProperty("CLASS_NAME")
    private String className;

    @TableField("CLASS_NOTE")
    @JsonProperty("CLASS_NOTE")
    private String classNote;


}
