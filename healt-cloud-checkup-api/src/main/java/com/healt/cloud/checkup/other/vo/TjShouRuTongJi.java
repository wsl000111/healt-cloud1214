package com.healt.cloud.checkup.other.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-10-10 19:44
 * @description: TODO
 */
@Data
public class TjShouRuTongJi implements Serializable {

    @JsonProperty("UNIT_NAME")
    private String unit_name;

    @JsonProperty("TCMC")
    private String tcmc;

    @JsonProperty("SEX")
    private String sex;

    @JsonProperty("RS")
    private String rs;

    @JsonProperty("TJCOSTS")
    private String tjcosts;

    @JsonProperty("TJCHARGES")
    private String tjcharges;

    @JsonProperty("FLAG")
    private String flag;

    @JsonProperty("SXTYPE")
    private String sxtype;

}
