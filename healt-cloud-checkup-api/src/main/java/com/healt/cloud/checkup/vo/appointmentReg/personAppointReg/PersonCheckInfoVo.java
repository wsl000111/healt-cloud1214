package com.healt.cloud.checkup.vo.appointmentReg.personAppointReg;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-04-17 9:49
 */
@Data
public class PersonCheckInfoVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "人员编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "人员名称")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "体检次数")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "单位名称")
    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

    @ApiModelProperty(value = "检前签到时间")
    @TableField("BEFORE_DATE")
    @JsonProperty("BEFORE_DATE")
    private Date beforeDate;

    @ApiModelProperty(value = "检前系统用户名称")
    @TableField("BEFORE_NAME")
    @JsonProperty("BEFORE_NAME")
    private String beforeName;

    @ApiModelProperty(value = "检完签到")
    @TableField("FINISHED_SIGN")
    @JsonProperty("FINISHED_SIGN")
    private String finishedSign;

    @ApiModelProperty(value = "检查状态 0-已预约 1-已执行2-待审核 7-已初审 9-已终审")
    @TableField("RESULT_STATUS")
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

    @ApiModelProperty(value = "终审医生")
    @TableField("FINAL_DOCOTER")
    @JsonProperty("FINAL_DOCOTER")
    private String finalDocoter;

    @ApiModelProperty(value = "终审时间")
    @TableField("FINAL_DATE")
    @JsonProperty("FINAL_DATE")
    private Date finalDate;

    @ApiModelProperty(value = "终审医生名称")
    @TableField("FINAL_NAME")
    @JsonProperty("FINAL_NAME")
    private String finalName;

    //以下三个字段，hc_person_visit_info a, hc_person_info b 表中均没有
    @ApiModelProperty(value = "初审医生")
    @TableField("FIRST_DOCOTER")
    @JsonProperty("FIRST_DOCOTER")
    private String firstDocoter;

    @ApiModelProperty(value = "初审时间")
    @TableField("FIRST_DATE")
    @JsonProperty("FIRST_DATE")
    private Date firstDate;

    @ApiModelProperty(value = "初审医生名称")
    @TableField("FIRST_NAME")
    @JsonProperty("FIRST_NAME")
    private String firstName;
}
