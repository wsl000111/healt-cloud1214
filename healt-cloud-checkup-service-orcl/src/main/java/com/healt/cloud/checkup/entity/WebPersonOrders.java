package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
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
 * 
 * </p>
 *
 * @author GuYue
 * @since 2022-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WEB_PERSON_ORDERS")
@ApiModel(value="WebPersonOrders对象", description="")
public class WebPersonOrders implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @TableField("ID_NO")
    @JsonProperty("ID_NO")
    private String idNo;

    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @TableField("BARTHDAY")
    @JsonProperty("BARTHDAY")
    private Date barthday;

    @TableField("PHONE_NUMBER")
    @JsonProperty("PHONE_NUMBER")
    private String phoneNumber;

    @TableField("MOBILE")
    @JsonProperty("MOBILE")
    private String mobile;

    @TableField("APPOINTS_DATE")
    @JsonProperty("APPOINTS_DATE")
    private Date appointsDate;

    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

    @TableField("FINISHED_SIGN")
    @JsonProperty("FINISHED_SIGN")
    private String finishedSign;

    @TableField("FINISHED_DATE")
    @JsonProperty("FINISHED_DATE")
    private Date finishedDate;

    @TableField("RESULT_STATUS")
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @TableField("COSTS")
    @JsonProperty("COSTS")
    private BigDecimal costs;

    @TableField("CHARGES")
    @JsonProperty("CHARGES")
    private BigDecimal charges;

    @TableField("BILL_INDICATOR")
    @JsonProperty("BILL_INDICATOR")
    private String billIndicator;

    @TableField("ITEM_FINISHED_SIGN")
    @JsonProperty("ITEM_FINISHED_SIGN")
    private String itemFinishedSign;

    @TableField("ORDER_ID")
    @JsonProperty("ORDER_ID")
    private String orderId;


}
