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
 * 检查项目记录
 * </p>
 *
 * @author GuYue
 * @since 2022-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_EXAM_ITEMS")
@ApiModel(value="HcExamItems对象", description="检查项目记录")
public class HcExamItems implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "申请序号")
    @TableId(value = "EXAM_NO", type = IdType.ASSIGN_ID)
    @JsonProperty("EXAM_NO")
    private String examNo;

    @ApiModelProperty(value = "项目序号")
    @TableField("EXAM_ITEM_NO")
    @JsonProperty("EXAM_ITEM_NO")
    private Integer examItemNo;

    @ApiModelProperty(value = "检查项目")
    @TableField("EXAM_ITEM")
    @JsonProperty("EXAM_ITEM")
    private String examItem;

    @ApiModelProperty(value = "项目代码")
    @TableField("EXAM_ITEM_CODE")
    @JsonProperty("EXAM_ITEM_CODE")
    private String examItemCode;

    @ApiModelProperty(value = "费用")
    @TableField("COSTS")
    @JsonProperty("COSTS")
    private BigDecimal costs;

    @ApiModelProperty(value = "开单标记")
    @TableField("BILLING_INDICATOR")
    @JsonProperty("BILLING_INDICATOR")
    private Integer billingIndicator;

    @ApiModelProperty(value = "数量")
    @TableField("AMOUNT")
    @JsonProperty("AMOUNT")
    private BigDecimal amount;

    @TableField("HIS_UNIT_CODE")
    @JsonProperty("HIS_UNIT_CODE")
    private String hisUnitCode;


}
