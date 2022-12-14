package com.healt.cloud.checkup.other.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liyongfei
 * @date 2022-08-29 8:53
 */
@Data
public class HcResultDictOtherVo implements Serializable {

//    select a.dept_name,a.item_assem_code,a.item_assem_name,
//    a.hc_item_code,a.hc_item_name,a.assem_sort_no,a.item_order_no,
//    a.key_name,a.hc_result,a.unit,a.print_context,a.abnormal_indicator,
//    a.hc_result_date,a.abnormal_flag

    @JsonProperty("DEPT_NAME")
    private String deptName;

    @JsonProperty("ITEM_ASSEM_CODE")
    private String itemAssemCode;

    @JsonProperty("ITEM_ASSEM_NAME")
    private String itemAssemName;

    @JsonProperty("HC_ITEM_CODE")
    private String hcItemCode;

    @JsonProperty("HC_ITEM_NAME")
    private String hcItemName;

    @JsonProperty("ASSEM_SORT_NO")
    private String assemSortNo;

    @JsonProperty("ITEM_ORDER_NO")
    private String itemOrderNo;

    @JsonProperty("KEY_NAME")
    private String keyName;

    @JsonProperty("HC_RESULT")
    private String hcResult;

    @JsonProperty("UNIT")
    private String unit;

    @JsonProperty("PRINT_CONTEXT")
    private String printContext;

    @JsonProperty("ABNORMAL_INDICATOR")
    private String abnormalIndicator;

    @JsonProperty("HC_RESULT_DATE")
    private String hcResultDate;

    @JsonProperty("ABNORMAL_FLAG")
    private String abnormalFlag;
}
