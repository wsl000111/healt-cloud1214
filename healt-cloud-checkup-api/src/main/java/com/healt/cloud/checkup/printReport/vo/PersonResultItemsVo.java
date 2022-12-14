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
public class PersonResultItemsVo implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonProperty("XH")
    private String xh;

    @ApiModelProperty(value = "内容")
    @TableField("CONTENT")
    @JsonProperty("CONTENT")
    private String content;

    @ApiModelProperty(value = "附加描述")
    @TableField("DESCRIPTION")
    @JsonProperty("DESCRIPTION")
    private String description;

    @ApiModelProperty(value = "科室ID")
    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @ApiModelProperty(value = "科室名称")
    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "排序序号")
    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;
}
