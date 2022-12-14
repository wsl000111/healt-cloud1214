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
 * 模块下载参数设置
 * </p>
 *
 * @author GuYue
 * @since 2022-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HEALT_APPLICATIONS_PARA")
@ApiModel(value="HealtApplicationsPara对象", description="模块下载参数设置")
public class HealtApplicationsPara implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "应用程序代码")
    @TableId(value = "CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("CODE")
    private String code;

    @ApiModelProperty(value = "应用程序名称")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "上传下载路径")
    @TableField("REMOTEPATH")
    @JsonProperty("REMOTEPATH")
    private String remotepath;

    @ApiModelProperty(value = "下载模式(0-全部,1-增量)")
    @TableField("DOWNMODE")
    @JsonProperty("DOWNMODE")
    private String downmode;

    @ApiModelProperty(value = "是否启用下载功能(Y,N)")
    @TableField("ISDOWNLOAD")
    @JsonProperty("ISDOWNLOAD")
    private String isdownload;

    @ApiModelProperty(value = "是否只是更新PBD+EXE文件")
    @TableField("ISONLYDOWNPBD")
    @JsonProperty("ISONLYDOWNPBD")
    private String isonlydownpbd;

    @ApiModelProperty(value = "最后一次下载时间")
    @TableField("LASTUPLOADTIME")
    @JsonProperty("LASTUPLOADTIME")
    private String lastuploadtime;

    @ApiModelProperty(value = "备注")
    @TableField("MEMO")
    @JsonProperty("MEMO")
    private String memo;

    @ApiModelProperty(value = "分院代码")
    @TableField("HIS_UNIT_CODE")
    @JsonProperty("HIS_UNIT_CODE")
    private String hisUnitCode;


}
