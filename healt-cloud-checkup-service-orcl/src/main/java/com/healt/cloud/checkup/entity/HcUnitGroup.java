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
 * 
 * </p>
 *
 * @author linklee
 * @since 2022-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_UNIT_GROUP")
@ApiModel(value="HcUnitGroup对象", description="")
public class HcUnitGroup implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "分组编码")
    @TableId(value = "GROUP_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("GROUP_CODE")
    private String groupCode;

    @ApiModelProperty(value = "分组名称")
    @TableField("GROUP_NAME")
    @JsonProperty("GROUP_NAME")
    private String groupName;

    @ApiModelProperty(value = "输入码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "体检次数")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "建组日期")
    @TableField("GROUP_CREATE_DATE")
    @JsonProperty("GROUP_CREATE_DATE")
    private Date groupCreateDate;

    @ApiModelProperty(value = "折扣率")
    @TableField("GROUP_DISCOUNT")
    @JsonProperty("GROUP_DISCOUNT")
    private BigDecimal groupDiscount;

    @ApiModelProperty(value = "机构编码")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "允许加项目")
    @TableField("ALLOW_ADD")
    @JsonProperty("ALLOW_ADD")
    private String allowAdd;

    @ApiModelProperty(value = "是否需要授权")
    @TableField("ALLOW_GRANT")
    @JsonProperty("ALLOW_GRANT")
    private String allowGrant;

    @ApiModelProperty(value = "授权人姓名")
    @TableField("GRANT_USER_NAME")
    @JsonProperty("GRANT_USER_NAME")
    private String grantUserName;

    @ApiModelProperty(value = "允许换项")
    @TableField("ALLOW_CHANGE")
    @JsonProperty("ALLOW_CHANGE")
    private String allowChange;

    @ApiModelProperty(value = "单位名称")
    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "年龄上限")
    @TableField("AGE_UP")
    @JsonProperty("AGE_UP")
    private Integer ageUp;

    @ApiModelProperty(value = "年龄下限")
    @TableField("AGE_DOWN")
    @JsonProperty("AGE_DOWN")
    private Integer ageDown;


}
