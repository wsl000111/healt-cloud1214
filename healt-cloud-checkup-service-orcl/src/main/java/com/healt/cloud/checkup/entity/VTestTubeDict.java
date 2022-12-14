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
@TableName("V_TEST_TUBE_DICT")
@ApiModel(value="VTestTubeDict对象", description="")
public class VTestTubeDict implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("TUBE_CODE")
    @JsonProperty("TUBE_CODE")
    private String tubeCode;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("TUBE_NAME")
    @JsonProperty("TUBE_NAME")
    private String tubeName;

    @TableField("TUBE_COLOR")
    @JsonProperty("TUBE_COLOR")
    private String tubeColor;

    @TableField("TUBE_SPEC")
    @JsonProperty("TUBE_SPEC")
    private String tubeSpec;

    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;


}
