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
 * 检验项目
 * </p>
 *
 * @author GuYue
 * @since 2022-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HCLAB_TEST_ITEMS")
@ApiModel(value="HclabTestItems对象", description="检验项目")
public class HclabTestItems implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "申请序号")
    @TableId(value = "TEST_NO", type = IdType.ASSIGN_ID)
    @JsonProperty("TEST_NO")
    private String testNo;

    @ApiModelProperty(value = "项目序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEM_NAME")
    @JsonProperty("ITEM_NAME")
    private String itemName;

    @ApiModelProperty(value = "项目代码")
    @TableField("ITEM_CODE")
    @JsonProperty("ITEM_CODE")
    private String itemCode;

    @ApiModelProperty(value = "开单标记")
    @TableField("BILLING_INDICATOR")
    @JsonProperty("BILLING_INDICATOR")
    private Integer billingIndicator;

    @ApiModelProperty(value = "测试经过")
    @TableField("TEST_BY")
    @JsonProperty("TEST_BY")
    private String testBy;

    @TableField("CHARGES")
    @JsonProperty("CHARGES")
    private BigDecimal charges;


}
