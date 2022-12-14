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
@TableName("V_INTERFACE_SOURCE")
@ApiModel(value="VInterfaceSource对象", description="")
public class VInterfaceSource implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("SOURCE_ID")
    @JsonProperty("SOURCE_ID")
    private String sourceId;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("SOURCE_NAME")
    @JsonProperty("SOURCE_NAME")
    private String sourceName;

    @TableField("SERVICE_NAME")
    @JsonProperty("SERVICE_NAME")
    private String serviceName;

    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;

    @TableField("PASSWORD")
    @JsonProperty("PASSWORD")
    private String password;

    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;


}
