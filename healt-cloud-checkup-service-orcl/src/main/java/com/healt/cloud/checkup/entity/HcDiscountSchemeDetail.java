package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
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
 * 体检打折优惠方案明细
 * </p>
 *
 * @author linklee
 * @since 2022-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_DISCOUNT_SCHEME_DETAIL")
@ApiModel(value="HcDiscountSchemeDetail对象", description="体检打折优惠方案明细")
public class HcDiscountSchemeDetail implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "打折方案代码")
    @TableId(value = "SCHEME_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("SCHEME_CODE")
    private String schemeCode;

    @ApiModelProperty(value = "项目组合代码")
    @TableField("ITEM_ASSEM_CODE")
    @JsonProperty("ITEM_ASSEM_CODE")
    private String itemAssemCode;

    @ApiModelProperty(value = "打折类别 打折系数0  打折金额1")
    @TableField("DISCOUNT_CLASS")
    @JsonProperty("DISCOUNT_CLASS")
    private String discountClass;

    @ApiModelProperty(value = "打折系数")
    @TableField("DISCOUNT_RATIO")
    @JsonProperty("DISCOUNT_RATIO")
    private BigDecimal discountRatio;

    @ApiModelProperty(value = "打折金额")
    @TableField("DISCOUNT_PRICE")
    @JsonProperty("DISCOUNT_PRICE")
    private BigDecimal discountPrice;

    @ApiModelProperty(value = "机构编号")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
