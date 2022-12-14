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
 * @author linklee
 * @since 2022-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_COSTCLASS_DICT")
@ApiModel(value="VCostclassDict对象", description="")
public class VCostclassDict implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("DICT_TYPE")
    @JsonProperty("DICT_TYPE")
    private String dictType;

    @TableField("CODE")
    @JsonProperty("CODE")
    private String code;

    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @TableField("USE_FLAG")
    @JsonProperty("USE_FLAG")
    private String useFlag;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;


}
