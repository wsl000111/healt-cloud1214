package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * 会员卡
 * </p>
 *
 * @author linklee
 * @since 2022-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_MEMBER_INFO")
@ApiModel(value="HcMemberInfo对象", description="会员卡")
public class HcMemberInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "卡号")
    @TableField("CARD_NO")
    @JsonProperty("CARD_NO")
    private String cardNo;

    @ApiModelProperty(value = "姓名")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "密码")
    @TableField("PASSWORD")
    @JsonProperty("PASSWORD")
    private String password;

    @ApiModelProperty(value = "正常 注销 作废")
    @TableField("STATUS")
    @JsonProperty("STATUS")
    private String status;

    @ApiModelProperty(value = "金额")
    @TableField("MONEY")
    @JsonProperty("MONEY")
    private BigDecimal money;

    @ApiModelProperty(value = "建卡日期")
    @TableField("BUILD_DATE")
    @JsonProperty("BUILD_DATE")
    private Date buildDate;

    @ApiModelProperty(value = "总积分")
    @TableField("TOTAL_FUN")
    @JsonProperty("TOTAL_FUN")
    private BigDecimal totalFun;

    @ApiModelProperty(value = "可用积分")
    @TableField("CURRENT_FUN")
    @JsonProperty("CURRENT_FUN")
    private BigDecimal currentFun;

    @ApiModelProperty(value = "操作员")
    @TableField("USER_ID")
    @JsonProperty("USER_ID")
    private String userId;

    @ApiModelProperty(value = "截止日期")
    @TableField("OVER_DATE")
    @JsonProperty("OVER_DATE")
    private Date overDate;

    @ApiModelProperty(value = "变更日期")
    @TableField("TRANS_DATE")
    @JsonProperty("TRANS_DATE")
    private Date transDate;

    @ApiModelProperty(value = "卡类型")
    @TableField("CARD_TYPE")
    @JsonProperty("CARD_TYPE")
    private String cardType;

    @ApiModelProperty(value = "使用单位")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "身份证")
    @TableField("ID_NO")
    @JsonProperty("ID_NO")
    private String idNo;

    @ApiModelProperty(value = "体检号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "卡内编号")
    @TableField("SELF_NO")
    @JsonProperty("SELF_NO")
    private String selfNo;

    @ApiModelProperty(value = "备注")
    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;


}
