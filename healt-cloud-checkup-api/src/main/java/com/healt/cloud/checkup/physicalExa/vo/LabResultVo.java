package com.healt.cloud.checkup.physicalExa.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-05-23 14:28
 */
@Data
public class LabResultVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "REPORT_ITEM_NAME")
    @JsonProperty("REPORT_ITEM_NAME")
    private String reportItemName;

    @TableId(value = "REPORT_ITEM_CODE")
    @JsonProperty("REPORT_ITEM_CODE")
    private String reportItemCode;

    @TableId(value = "RESULT")
    @JsonProperty("RESULT")
    private String result;

    @TableId(value = "UNITS")
    @JsonProperty("UNITS")
    private String units;

    @TableId(value = "ABNORMAL_INDICATOR")
    @JsonProperty("ABNORMAL_INDICATOR")
    private String abnormalIndicator;

    @TableId(value = "INSTRUMENT_ID")
    @JsonProperty("INSTRUMENT_ID")
    private String instrumentId;

    @TableId(value = "RESULT_DATE_TIME")
    @JsonProperty("RESULT_DATE_TIME")
    private Date resultDateTime;

    @TableId(value = "PRINT_CONTEXT")
    @JsonProperty("PRINT_CONTEXT")
    private String printContext;

    @TableId(value = "TEST_NO")
    @JsonProperty("TEST_NO")
    private String testNo;

}
