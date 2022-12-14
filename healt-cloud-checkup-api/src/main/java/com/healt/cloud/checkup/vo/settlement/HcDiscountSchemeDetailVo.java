package com.healt.cloud.checkup.vo.settlement;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author linklee
 * @create 2022-05-06 11:25
 */
@Data
public class HcDiscountSchemeDetailVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

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
