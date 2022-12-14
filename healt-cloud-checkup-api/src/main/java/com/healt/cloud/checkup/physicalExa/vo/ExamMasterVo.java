package com.healt.cloud.checkup.physicalExa.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-05-25 17:00
 */
@Data
public class ExamMasterVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("EXAM_NAME")
    @JsonProperty("EXAM_NAME")
    private String examName;

    @TableField("REQ_DATE_TIME")
    @JsonProperty("REQ_DATE_TIME")
    private Date reqDateTime;

    @TableField("EXAM_NO")
    @JsonProperty("EXAM_NO")
    private String examNo;
}
