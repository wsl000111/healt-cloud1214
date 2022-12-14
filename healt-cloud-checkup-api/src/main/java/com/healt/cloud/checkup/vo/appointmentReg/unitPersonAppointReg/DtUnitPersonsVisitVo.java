package com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author GuYue
 * @date 2022-04-13 11:10
 * @description: TODO
 */
public class DtUnitPersonsVisitVo {

    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitiId;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private String unitVisitId;

    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private String personVisitId;

    @TableField("GROUP_ID")
    @JsonProperty("GROUP_ID")
    private String groupId;

    @TableField("RESULT_STATUS")
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

    @TableField("GROUP_NAME")
    @JsonProperty("GROUP_NAME")
    private String groupName;

    @TableField("PATIENT_ID")
    @JsonProperty("PATIENT_ID")
    private String patientId;

}
