package com.healt.cloud.checkup.vo.member;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-05-09 14:10
 */
@Data
public class MemberListVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "卡号")
    @TableField("CARD_NO")
    @JsonProperty("CARD_NO")
    private String cardNo;

    @ApiModelProperty(value = "姓名")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

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
