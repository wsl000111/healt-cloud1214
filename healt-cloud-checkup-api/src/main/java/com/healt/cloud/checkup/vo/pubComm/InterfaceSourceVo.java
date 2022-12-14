package com.healt.cloud.checkup.vo.pubComm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-03 9:51
 */
@Data
public class InterfaceSourceVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "接口库编号")
    @TableId(value = "SOURCE_ID")
    @JsonProperty("SOURCE_ID")
    private String sourceId;

    @ApiModelProperty(value = "接口库名称")
    @TableField("SOURCE_NAME")
    @JsonProperty("SOURCE_NAME")
    private String sourceName;

    @ApiModelProperty(value = "服务名")
    @TableField("SERVICE_NAME")
    @JsonProperty("SERVICE_NAME")
    private String serviceName;

    @ApiModelProperty(value = "登陆用户")
    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "登陆密码")
    @TableField("PASSWORD")
    @JsonProperty("PASSWORD")
    private String password;

    @ApiModelProperty(value = "写入接口的科室")
    @TableField("ORDER_DEPT")
    @JsonProperty("ORDER_DEPT")
    private String orderDept;
}
