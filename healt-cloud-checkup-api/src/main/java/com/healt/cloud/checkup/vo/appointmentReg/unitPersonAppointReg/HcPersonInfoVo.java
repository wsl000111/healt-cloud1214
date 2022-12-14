package com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuYue
 * @date 2022-04-12 14:07
 * @description: TODO
 */
@Data
public class HcPersonInfoVo implements Serializable {

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;


    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

    @TableField("ID_NO")
    @JsonProperty("ID_NO")
    private String idNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @TableField("BARTHDAY")
    @JsonProperty("BARTHDAY")
    private Date barthday;

    @TableField("MARITAL_STATUS")
    @JsonProperty("MARITAL_STATUS")
    private String maritalStatus;

    @TableField("COUNTRY")
    @JsonProperty("COUNTRY")
    private String country;

    @TableField("AREA")
    @JsonProperty("AREA")
    private String area;

    @TableField("NATION")
    @JsonProperty("NATION")
    private String nation;

    @TableField("PHONE_NUMBER")
    @JsonProperty("PHONE_NUMBER")
    private String phoneNumber;

    @TableField("SOURCE")
    @JsonProperty("SOURCE")
    private String source;

    @TableField("JOB")
    @JsonProperty("JOB")
    private String job;

    @TableField("EXAM_CLASS")
    @JsonProperty("EXAM_CLASS")
    private String examClass;

    @TableField("PERSON_LEVEL")
    @JsonProperty("PERSON_LEVEL")
    private String personLevel;

    @TableField("DEPARTMENT")
    @JsonProperty("DEPARTMENT")
    private String department;

    @TableField("CHARGE_TYPE")
    @JsonProperty("CHARGE_TYPE")
    private String chargeType;

    @TableField("PERSON_CHARGE")
    @JsonProperty("PERSON_CHARGE")
    private String personCharge;

    @TableField("RESULT_STATUS")
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

    @TableField("GROUP_ID")
    @JsonProperty("GROUP_ID")
    private String groupId;

    @TableField("AGE")
    @JsonProperty("AGE")
    private String age;

    @TableField("PATIENT_ID")
    @JsonProperty("PATIENT_ID")
    private String patientId;
}
