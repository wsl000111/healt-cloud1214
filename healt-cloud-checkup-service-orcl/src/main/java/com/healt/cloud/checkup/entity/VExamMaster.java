package com.healt.cloud.checkup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
//import com.fasterxml.jackson.annotation.JsonInclude;//不返回null值字段
import com.fasterxml.jackson.annotation.JsonProperty;//前端传值有下划线

/**
 * <p>
 * 
 * </p>
 *
 * @author linklee
 * @since 2022-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_EXAM_MASTER")
@ApiModel(value="VExamMaster对象", description="")
public class VExamMaster implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("EXAM_NO")
    @JsonProperty("EXAM_NO")
    private String examNo;

    @TableField("PATIENT_ID")
    @JsonProperty("PATIENT_ID")
    private String patientId;

    @TableField("VISIT_ID")
    @JsonProperty("VISIT_ID")
    private Integer visitId;

    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @TableField("DATE_OF_BIRTH")
    @JsonProperty("DATE_OF_BIRTH")
    private Date dateOfBirth;

    @TableField("EXAM_CLASS")
    @JsonProperty("EXAM_CLASS")
    private String examClass;

    @TableField("EXAM_SUB_CLASS")
    @JsonProperty("EXAM_SUB_CLASS")
    private String examSubClass;

    @TableField("CLIN_SYMP")
    @JsonProperty("CLIN_SYMP")
    private String clinSymp;

    @TableField("PHYS_SIGN")
    @JsonProperty("PHYS_SIGN")
    private String physSign;

    @TableField("REQ_DATE_TIME")
    @JsonProperty("REQ_DATE_TIME")
    private Date reqDateTime;

    @TableField("REQ_DEPT")
    @JsonProperty("REQ_DEPT")
    private String reqDept;

    @TableField("REQ_PHYSICIAN")
    @JsonProperty("REQ_PHYSICIAN")
    private String reqPhysician;

    @TableField("REPORT_DATE_TIME")
    @JsonProperty("REPORT_DATE_TIME")
    private Date reportDateTime;

    @TableField("RESULT_STATUS")
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

    @TableField("REPORTER")
    @JsonProperty("REPORTER")
    private String reporter;


}
