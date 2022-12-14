package com.healt.cloud.checkup.queryReport.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-05-26 14:04
 */
@Data
public class PersonListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String selectflag;

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

    @ApiModelProperty(value = "出生日期")
    @TableField("BARTHDAY")
    @JsonProperty("BARTHDAY")
    private Date barthday;

    @ApiModelProperty(value = "终审时间")
    @TableField("FINAL_DATE")
    @JsonProperty("FINAL_DATE")
    private Date finalDate;

    @ApiModelProperty(value = "终审医生名称")
    @TableField("FINAL_NAME")
    @JsonProperty("FINAL_NAME")
    private String finalName;

    @ApiModelProperty(value = "婚姻状况")
    @TableField("MARITAL_STATUS")
    @JsonProperty("MARITAL_STATUS")
    private String maritalStatus;

    @TableField("AREA")
    @JsonProperty("AREA")
    private String area;

    @ApiModelProperty(value = "身份证号")
    @TableField("ID_NO")
    @JsonProperty("ID_NO")
    private String idNo;

    @TableField("COUNTY")
    @JsonProperty("COUNTY")
    private String county;

    @ApiModelProperty(value = "部门")
    @TableField("DEPARTMENT")
    @JsonProperty("DEPARTMENT")
    private String department;

    @JsonProperty("GEZFY")
    private String gezfy;

    @JsonProperty("GRCHARGES")
    private String grcharges;

    @JsonProperty("TCJE")
    private String tcje;

}
