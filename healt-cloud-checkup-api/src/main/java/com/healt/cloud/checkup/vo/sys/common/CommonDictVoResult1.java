package com.healt.cloud.checkup.vo.sys.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-22 9:35
 * @description: TODO
 */
@Data
public class CommonDictVoResult1 implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonProperty("CODE")
    private String code;

    @ApiModelProperty(value = "名称")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "输入码")
    @JsonProperty("INPUT_CODE")
    private String inputCode;
}
