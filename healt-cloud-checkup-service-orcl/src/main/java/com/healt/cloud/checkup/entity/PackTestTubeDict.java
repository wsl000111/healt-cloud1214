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
 * 组合试管字典
 * </p>
 *
 * @author GuYue
 * @since 2022-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PACK_TEST_TUBE_DICT")
@ApiModel(value="PackTestTubeDict对象", description="组合试管字典")
public class PackTestTubeDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "试管编码")
    @TableField("TUBE_CODE")
    @JsonProperty("TUBE_CODE")
    private String tubeCode;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "试管名称")
    @TableField("TUBE_NAME")
    @JsonProperty("TUBE_NAME")
    private String tubeName;

    @ApiModelProperty(value = "规格")
    @TableField("TUBE_SPEC")
    @JsonProperty("TUBE_SPEC")
    private String tubeSpec;

    @ApiModelProperty(value = "颜色")
    @TableField("TUBE_COLOR")
    @JsonProperty("TUBE_COLOR")
    private String tubeColor;

    @ApiModelProperty(value = "序号")
    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @ApiModelProperty(value = "说明")
    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;

    @ApiModelProperty(value = "输入码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;


}
