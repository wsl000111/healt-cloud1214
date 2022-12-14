package com.healt.cloud.checkup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
//import com.fasterxml.jackson.annotation.JsonInclude;//不返回null值字段
import com.fasterxml.jackson.annotation.JsonProperty;//前端传值有下划线

/**
 * <p>
 * 接口库定义
 * </p>
 *
 * @author linklee
 * @since 2022-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("INTERFACE_SOURCE")
@ApiModel(value="InterfaceSource对象", description="接口库定义")
public class InterfaceSource implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "接口库编号")
    @TableId(value = "SOURCE_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("SOURCE_ID")
    private String sourceId;

    @ApiModelProperty(value = "机构编号")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @JsonIgnore
    @ApiModelProperty(value = "接口库名称")
    @TableField("SOURCE_NAME")
    @JsonProperty("SOURCE_NAME")
    private String sourceName;

    @JsonIgnore
    @ApiModelProperty(value = "服务名")
    @TableField("SERVICE_NAME")
    @JsonProperty("SERVICE_NAME")
    private String serviceName;

    @JsonIgnore
    @ApiModelProperty(value = "登陆用户")
    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;

    @JsonIgnore
    @ApiModelProperty(value = "登陆密码")
    @TableField("PASSWORD")
    @JsonProperty("PASSWORD")
    private String password;

    @JsonIgnore
    @ApiModelProperty(value = "备注")
    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;

    @ApiModelProperty(value = "写入接口的科室")
    @TableField("ORDER_DEPT")
    @JsonProperty("ORDER_DEPT")
    private String orderDept;


}
