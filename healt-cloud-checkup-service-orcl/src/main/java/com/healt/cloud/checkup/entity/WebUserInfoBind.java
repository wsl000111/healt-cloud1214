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
 * 体检人绑定关系表
 * </p>
 *
 * @author GuYue
 * @since 2022-10-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WEB_USER_INFO_BIND")
@ApiModel(value="WebUserInfoBind对象", description="体检人绑定关系表")
public class WebUserInfoBind implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableField("ID")
    @JsonProperty("ID")
    private String id;

    @ApiModelProperty(value = "绑定人id")
    @TableField("BIND_ID")
    @JsonProperty("BIND_ID")
    private String bindId;

    @ApiModelProperty(value = "绑定时间")
    @TableField("INSERT_DATE")
    @JsonProperty("INSERT_DATE")
    private Date insertDate;

    @ApiModelProperty(value = "微信号")
    @TableField("WX_NO")
    @JsonProperty("WX_NO")
    private String wxNo;

    @ApiModelProperty(value = "与本人关系")
    @TableField("RELATION_SHIP")
    @JsonProperty("RELATION_SHIP")
    private String relationShip;

    @ApiModelProperty(value = "微信openid")
    @TableField("OPEN_ID")
    @JsonProperty("OPEN_ID")
    private String openId;

    @ApiModelProperty(value = "姓名")
    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "身份证号")
    @TableField("ID_NO")
    @JsonProperty("ID_NO")
    private String idNo;

    @ApiModelProperty(value = "电话号")
    @TableField("PHONE_NO")
    @JsonProperty("PHONE_NO")
    private String phoneNo;

    @ApiModelProperty(value = "体检号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;


}
