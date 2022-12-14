package com.healt.cloud.checkup.vo.settlement;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-04-09 14:30
 */
@Data
public class PersonVisitAndInfoVo implements Serializable{

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "体检次数")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "人员编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "检完签到")
    @TableField("FINISHED_SIGN")
    @JsonProperty("FINISHED_SIGN")
    private String finishedSign;

    @ApiModelProperty(value = "检查类别")
    @TableField("EXAM_CLASS")
    @JsonProperty("EXAM_CLASS")
    private String examClass;

    @ApiModelProperty(value = "体检费别")
    @TableField("PERSON_CHARGE")
    @JsonProperty("PERSON_CHARGE")
    private String personCharge;

    @ApiModelProperty(value = "年龄")
    @TableField("AGE")
    @JsonProperty("AGE")
    private Integer age;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "人员名称")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "")
    @TableField("PATIENT_ID")
    @JsonProperty("PATIENT_ID")
    private String patientId;

}
