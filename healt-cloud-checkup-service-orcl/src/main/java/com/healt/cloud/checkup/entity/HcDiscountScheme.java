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
 * 打折方案主表
 * </p>
 *
 * @author linklee
 * @since 2022-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_DISCOUNT_SCHEME")
@ApiModel(value="HcDiscountScheme对象", description="打折方案主表")
public class HcDiscountScheme implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "打折方案名")
    @TableField("SCHEME_NAME")
    @JsonProperty("SCHEME_NAME")
    private String schemeName;

    @ApiModelProperty(value = "打折方案编码")
    @TableField("SCHEME_CODE")
    @JsonProperty("SCHEME_CODE")
    private String schemeCode;

    @ApiModelProperty(value = "是否有效 1有效 0无效")
    @TableField("EFFECTIVE_FLAG")
    @JsonProperty("EFFECTIVE_FLAG")
    private String effectiveFlag;

    @ApiModelProperty(value = "医院编号")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
