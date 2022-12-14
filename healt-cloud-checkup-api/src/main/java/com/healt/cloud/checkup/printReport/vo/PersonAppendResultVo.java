package com.healt.cloud.checkup.printReport.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-06-01 11:29
 */
@Data
public class PersonAppendResultVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "内容")
    @TableField("CONTENT")
    @JsonProperty("CONTENT")
    private String content;

    @ApiModelProperty(value = "附加描述")
    @TableField("DESCRIPTION")
    @JsonProperty("DESCRIPTION")
    private String description;

}
