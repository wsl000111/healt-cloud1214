package com.healt.cloud.checkup.queryReport.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-05-26 15:35
 */
@Data
public class PersonNotFinalListVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "人员编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "体检费别")
    @TableField("PERSON_CHARGE")
    @JsonProperty("PERSON_CHARGE")
    private String personCharge;

    @JsonProperty("BEFORE_SIGN")
    private String beforeSign;

    @ApiModelProperty(value = "检前签到时间")
    @TableField("BEFORE_DATE")
    @JsonProperty("BEFORE_DATE")
    private Date beforeDate;

    @ApiModelProperty(value = "年龄")
    @TableField("AGE")
    @JsonProperty("AGE")
    private Integer age;

    @ApiModelProperty(value = "检查类别")
    @TableField("EXAM_CLASS")
    @JsonProperty("EXAM_CLASS")
    private String examClass;

    @ApiModelProperty(value = "职业")
    @TableField("JOB")
    @JsonProperty("JOB")
    private String job;

    @ApiModelProperty(value = "人员名称")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "单位名称")
    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

    @ApiModelProperty(value = "建档时间")
    @TableField("BUILD_DATE")
    @JsonProperty("BUILD_DATE")
    private Date buildDate;

    @ApiModelProperty(value = "检查状态 0-已预约 1-已执行2-待审核 7-已初审 9-已终审")
    @TableField("RESULT_STATUS")
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

}
