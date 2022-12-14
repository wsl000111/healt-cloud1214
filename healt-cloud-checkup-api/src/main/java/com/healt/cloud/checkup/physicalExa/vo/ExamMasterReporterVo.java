package com.healt.cloud.checkup.physicalExa.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-25 16:16
 */
@Data
public class ExamMasterReporterVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("REPORTER")
    @JsonProperty("REPORTER")
    private String reporter;

    @TableField("EXAM_CLASS")
    @JsonProperty("EXAM_CLASS")
    private String examClass;
}
