package com.healt.cloud.checkup.queryReport.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-29 14:05
 */
@Data
public class FinalDocoterVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "初审医生")
    @TableField("FIRST_DOCOTER")
    @JsonProperty("FIRST_DOCOTER")
    private String firstDocoter;

    @ApiModelProperty(value = "终审医生名称")
    @TableField("FINAL_NAME")
    @JsonProperty("NAME")
    private String name;

    @JsonProperty("SUM_COUNT")
    private String sumCount;
}
