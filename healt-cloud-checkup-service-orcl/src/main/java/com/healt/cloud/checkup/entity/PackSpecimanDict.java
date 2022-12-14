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
 * 组合标本字典
 * </p>
 *
 * @author GuYue
 * @since 2022-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PACK_SPECIMAN_DICT")
@ApiModel(value="PackSpecimanDict对象", description="组合标本字典")
public class PackSpecimanDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "标本编码")
    @TableField("SPECIMAN_CODE")
    @JsonProperty("SPECIMAN_CODE")
    private String specimanCode;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "标本名称")
    @TableField("SPECIMAN_NAME")
    @JsonProperty("SPECIMAN_NAME")
    private String specimanName;

    @ApiModelProperty(value = "序号")
    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @ApiModelProperty(value = "输入码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;


}
