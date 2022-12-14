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
 * FTP更新参数设置
 * </p>
 *
 * @author GuYue
 * @since 2022-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HEALT_UPDATE_PARA")
@ApiModel(value="HealtUpdatePara对象", description="FTP更新参数设置")
public class HealtUpdatePara implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "FTP参数代码")
    @TableField("CODE")
    @JsonProperty("CODE")
    private String code;

    @ApiModelProperty(value = "FTP参数名称")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "FTP参数值")
    @TableField("VALUE")
    @JsonProperty("VALUE")
    private String value;

    @ApiModelProperty(value = "FTP参数备注")
    @TableField("BZ")
    @JsonProperty("BZ")
    private String bz;

    @TableField("HIS_UNIT_CODE")
    @JsonProperty("HIS_UNIT_CODE")
    private String hisUnitCode;


}
