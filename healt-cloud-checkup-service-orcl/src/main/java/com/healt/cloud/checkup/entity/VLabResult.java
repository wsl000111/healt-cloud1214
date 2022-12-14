package com.healt.cloud.checkup.entity;

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
 * @author linklee
 * @since 2022-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_LAB_RESULT")
@ApiModel(value="VLabResult对象", description="")
public class VLabResult implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("TEST_NO")
    @JsonProperty("TEST_NO")
    private String testNo;

    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @TableField("PRINT_ORDER")
    @JsonProperty("PRINT_ORDER")
    private Integer printOrder;

    @TableField("REPORT_ITEM_NAME")
    @JsonProperty("REPORT_ITEM_NAME")
    private String reportItemName;

    @TableField("REPORT_ITEM_CODE")
    @JsonProperty("REPORT_ITEM_CODE")
    private String reportItemCode;

    @TableField("RESULT")
    @JsonProperty("RESULT")
    private String result;

    @TableField("UNITS")
    @JsonProperty("UNITS")
    private String units;

    @TableField("ABNORMAL_INDICATOR")
    @JsonProperty("ABNORMAL_INDICATOR")
    private String abnormalIndicator;

    @TableField("INSTRUMENT_ID")
    @JsonProperty("INSTRUMENT_ID")
    private String instrumentId;

    @TableField("RESULT_DATE_TIME")
    @JsonProperty("RESULT_DATE_TIME")
    private Date resultDateTime;

    @TableField("PRINT_CONTEXT")
    @JsonProperty("PRINT_CONTEXT")
    private String printContext;

    @TableField("RESULT_RANGE")
    @JsonProperty("RESULT_RANGE")
    private String resultRange;

    @TableField("SAMPLE_CODE")
    @JsonProperty("SAMPLE_CODE")
    private String sampleCode;

    @TableField("SPECIMAN_ID")
    @JsonProperty("SPECIMAN_ID")
    private String specimanId;

    @TableField("ITEM_CODE")
    @JsonProperty("ITEM_CODE")
    private String itemCode;

    @TableField("ITEM_NAME")
    @JsonProperty("ITEM_NAME")
    private String itemName;


}
