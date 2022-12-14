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
 * 健康体检授权字典
 * </p>
 *
 * @author GuYue
 * @since 2022-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HEALT_ENCRYPT_DICT")
@ApiModel(value="HealtEncryptDict对象", description="健康体检授权字典")
public class HealtEncryptDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "应用程序代码健康体检为HEALTHCHECKUP")
    @TableField("APPLICATION_CODE")
    @JsonProperty("APPLICATION_CODE")
    private String applicationCode;

    @ApiModelProperty(value = "版本号")
    @TableField("APPLICATION_VERSION")
    @JsonProperty("APPLICATION_VERSION")
    private String applicationVersion;

    @ApiModelProperty(value = "应用程序")
    @TableField("APPLICATION_NAME")
    @JsonProperty("APPLICATION_NAME")
    private String applicationName;

    @ApiModelProperty(value = "授权")
    @TableField("ENCRYPT_CODE")
    @JsonProperty("ENCRYPT_CODE")
    private String encryptCode;

    @ApiModelProperty(value = "机构ID")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
