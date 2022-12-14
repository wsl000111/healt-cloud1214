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
 * 模块上传下载日志
 * </p>
 *
 * @author GuYue
 * @since 2022-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HEALT_UPDATE_LOG")
@ApiModel(value="HealtUpdateLog对象", description="模块上传下载日志")
public class HealtUpdateLog implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "发生日期")
    @TableField("RQ")
    @JsonProperty("RQ")
    private Date rq;

    @ApiModelProperty(value = "模块代码")
    @TableField("APP_CODE")
    @JsonProperty("APP_CODE")
    private String appCode;

    @ApiModelProperty(value = "工作站IP地址")
    @TableField("WSIP")
    @JsonProperty("WSIP")
    private String wsip;

    @ApiModelProperty(value = "工作站名称")
    @TableField("WSNAME")
    @JsonProperty("WSNAME")
    private String wsname;

    @ApiModelProperty(value = "版本号")
    @TableField("VERSION")
    @JsonProperty("VERSION")
    private String version;

    @ApiModelProperty(value = "关键字")
    @TableField("KEY")
    @JsonProperty("KEY")
    private String key;

    @ApiModelProperty(value = "更新类型")
    @TableField("UPDATE_TYPE")
    @JsonProperty("UPDATE_TYPE")
    private String updateType;


}
