package com.healt.cloud.checkup.sysDict.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-27 16:24
 */
@Data
public class AllocatedDeptVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "科室编号")
    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "用户编码")
    @TableField("USER_ID")
    @JsonProperty("USER_ID")
    private String userId;
}
