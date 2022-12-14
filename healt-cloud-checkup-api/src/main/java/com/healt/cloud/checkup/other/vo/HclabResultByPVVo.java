package com.healt.cloud.checkup.other.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-08-26 18:36
 * @description: TODO
 */
@Data
public class HclabResultByPVVo implements Serializable {

    @JsonProperty("TEST_NO")
    private String testNo;

    @JsonProperty("PRINT_ORDER")
    private String printOrder;

    @JsonProperty("ITEM_NO")
    private String itemNo;

    @JsonProperty("REPORT_ITEM_NAME")
    private String reportItemName;

    @JsonProperty("REPORT_ITEM_CODE")
    private String reportItemCode;

    @JsonProperty("RESULT")
    private String result;

    @JsonProperty("ABNORMAL_INDICATOR")
    private String abnormalIndicator;

    @JsonProperty("PRINT_CONTEXT")
    private String printContext;

    @JsonProperty("UNITS")
    private String units;

}
