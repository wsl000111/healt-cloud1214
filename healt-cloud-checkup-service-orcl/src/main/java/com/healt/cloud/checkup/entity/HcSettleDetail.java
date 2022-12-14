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
 * 收费细表
 * </p>
 *
 * @author GuYue
 * @since 2022-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_SETTLE_DETAIL")
@ApiModel(value="HcSettleDetail对象", description="收费细表")
public class HcSettleDetail implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "体检次数")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "单据号码")
    @TableField("RCPT_NO")
    @JsonProperty("RCPT_NO")
    private String rcptNo;

    @ApiModelProperty(value = "个人编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "收费日期")
    @TableField("SETTLING_DATE")
    @JsonProperty("SETTLING_DATE")
    private Date settlingDate;

    @ApiModelProperty(value = "项目编码")
    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @ApiModelProperty(value = "应收")
    @TableField("COSTS")
    @JsonProperty("COSTS")
    private BigDecimal costs;

    @ApiModelProperty(value = "实收")
    @TableField("PAYMENTS")
    @JsonProperty("PAYMENTS")
    private BigDecimal payments;

    @ApiModelProperty(value = "套餐编码")
    @TableField("SET_CODE")
    @JsonProperty("SET_CODE")
    private String setCode;

    @ApiModelProperty(value = "折扣率")
    @TableField("DISCOUNT_RATE")
    @JsonProperty("DISCOUNT_RATE")
    private BigDecimal discountRate;

    @ApiModelProperty(value = "加项")
    @TableField("ADD_ITEM")
    @JsonProperty("ADD_ITEM")
    private String addItem;

    @ApiModelProperty(value = "收费人")
    @TableField("USER_ID")
    @JsonProperty("USER_ID")
    private String userId;

    @ApiModelProperty(value = "收费人姓名")
    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "退费单据号")
    @TableField("RETURN_REPT_NO")
    @JsonProperty("RETURN_REPT_NO")
    private String returnReptNo;

    @ApiModelProperty(value = "数量")
    @TableField("NUM")
    @JsonProperty("NUM")
    private BigDecimal num;

    @TableField("DEL_USER_ID")
    @JsonProperty("DEL_USER_ID")
    private String delUserId;

    @TableField("DEL_USER_NAME")
    @JsonProperty("DEL_USER_NAME")
    private String delUserName;

    @TableField("DEL_DATE")
    @JsonProperty("DEL_DATE")
    private Date delDate;

    @TableField("DEL_NOTE")
    @JsonProperty("DEL_NOTE")
    private String delNote;


}
