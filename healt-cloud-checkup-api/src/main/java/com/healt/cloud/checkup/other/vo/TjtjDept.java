package com.healt.cloud.checkup.other.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-10-11 13:06
 * @description: TODO
 */
@Data
public class TjtjDept implements Serializable {

    @JsonProperty("ITEM_PACK_NAME")
    private String item_pack_name;

    @JsonProperty("ITEM_PACK_CODE")
    private String item_pack_code;

    @JsonProperty("DEPT_ID")
    private String dept_id;

    @JsonProperty("DEPT_NAME")
    private String dept_name;

    @JsonProperty("FLAG")
    private String flag;

    @JsonProperty("GRS")
    private String grs;

    @JsonProperty("GRCOSTS")
    private String grcosts;

    @JsonProperty("GRCHARGES")
    private String grcharges;

    @JsonProperty("TJRS")
    private String tjrs;

    @JsonProperty("TJCOSTS")
    private String tjcosts;

    @JsonProperty("TJCHARGES")
    private String tjcharges;

}
