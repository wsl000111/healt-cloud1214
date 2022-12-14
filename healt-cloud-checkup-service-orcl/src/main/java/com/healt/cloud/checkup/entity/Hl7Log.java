package com.healt.cloud.checkup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
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
 * @since 2022-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HL7_LOG")
@ApiModel(value="Hl7Log对象", description="")
public class Hl7Log implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "日志插入日期")
    @TableField("INSERT_DATE")
    @JsonProperty("INSERT_DATE")
    private Date insertDate;

    @ApiModelProperty(value = "参数字符串")
    @TableField("DATA_STR")
    @JsonProperty("DATA_STR")
    private String dataStr;

    @ApiModelProperty(value = "参数类型：入参/出参")
    @TableField("DATA_TYPE")
    @JsonProperty("DATA_TYPE")
    private String dataType;

    @ApiModelProperty(value = "调用的方法")
    @TableField("METHOD")
    @JsonProperty("METHOD")
    private String method;

    @ApiModelProperty(value = "同一组入参出参uuid相同")
    @TableField("UUID")
    @JsonProperty("UUID")
    private String uuid;

    @ApiModelProperty(value = "申请号")
    @TableField("APPLY_NO")
    @JsonProperty("APPLY_NO")
    private String applyNo;


}
