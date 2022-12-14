package com.healt.cloud.checkup.printReport.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-06-01 11:32
 */
@Data
public class PersonResultVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "检查描述")
    @TableField("CONCLUSION_TEXT")
    @JsonProperty("CONCLUSION_TEXT")
    private String conclusionText;

    @ApiModelProperty(value = "科室建议")
    @TableField("SUGGEST_TEXT")
    @JsonProperty("SUGGEST_TEXT")
    private String suggestText;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;
}
