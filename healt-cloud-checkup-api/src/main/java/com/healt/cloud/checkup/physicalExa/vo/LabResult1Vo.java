package com.healt.cloud.checkup.physicalExa.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-05-23 15:57
 */
@Data
public class LabResult1Vo implements Serializable {

    private static final long serialVersionUID=1L;

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

    @TableField("TEST_NO")
    @JsonProperty("TEST_NO")
    private String testNo;
}
