package com.healt.cloud.checkup.frmDivDocDepart.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-22 23:45
 * @description: TODO
 */
@Data
public class ValidateRightVo implements Serializable {

    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @TableField("CLASS_NAME")
    @JsonProperty("CLASS_NAME")
    private String className;
}
