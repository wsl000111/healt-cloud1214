package com.healt.cloud.checkup.other.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liyongfei
 * @date 2022-09-03 10:44
 */
@Data
public class CostDetailBillingByTimeVo implements Serializable {

    @JsonProperty("DEPT_ID")
    private String deptId;

    @JsonProperty("DEPT_NAME")
    private String deptName;

    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @JsonProperty("DJ")
    private String dj;

    @JsonProperty("GRS")
    private String grs;

    @JsonProperty("GRCOSTS")
    private String grcosts;

    @JsonProperty("GRCHARGES")
    private String grcharges;

    @JsonProperty("TJCOSTS")
    private String tjcosts;

    @JsonProperty("TJCHARGES")
    private String tjcharges;

    @JsonProperty("TJRS")
    private String tjrs;
}
