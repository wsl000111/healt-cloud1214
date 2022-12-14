package com.healt.cloud.checkup.autoUpdate.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-08 15:03
 * @description: TODO
 */
@Data
public class AppParsVo implements Serializable {
//code,name,'['||code||'] '||name codename,isdownload

    @JsonProperty("CODE")
    private String code;

    @JsonProperty("NAME")
    private String name;

    @JsonProperty("CODENAME")
    private String codename;

    @JsonProperty("ISDOWNLOAD")
    private String isdownload;
}
