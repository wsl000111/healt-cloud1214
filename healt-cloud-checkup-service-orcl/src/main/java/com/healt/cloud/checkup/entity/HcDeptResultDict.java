package com.healt.cloud.checkup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 体检分科结果主记录
 * </p>
 *
 * @author GuYue
 * @since 2022-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_DEPT_RESULT_DICT")
@ApiModel(value="HcDeptResultDict对象", description="体检分科结果主记录")
public class HcDeptResultDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "人员编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "科室代码")
    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @ApiModelProperty(value = "科室名称")
    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "体检结果时间")
    @TableField("HC_RESULT_DATE")
    @JsonProperty("HC_RESULT_DATE")
    private Date hcResultDate;

    @ApiModelProperty(value = "病史")
    @TableField("MEDICAL_HISTORY")
    @JsonProperty("MEDICAL_HISTORY")
    private String medicalHistory;

    @ApiModelProperty(value = "检查描述")
    @TableField("CONCLUSION_TEXT")
    @JsonProperty("CONCLUSION_TEXT")
    private String conclusionText;

    @ApiModelProperty(value = "科室建议")
    @TableField("SUGGEST_TEXT")
    @JsonProperty("SUGGEST_TEXT")
    private String suggestText;

    @ApiModelProperty(value = "分科病史是否在分科报告中出现")
    @TableField("MED_IN_DEPT_REPORT")
    @JsonProperty("MED_IN_DEPT_REPORT")
    private String medInDeptReport;

    @ApiModelProperty(value = "医生代码")
    @TableField("DOCTOR")
    @JsonProperty("DOCTOR")
    private String doctor;

    @ApiModelProperty(value = "医生姓名")
    @TableField("DOCTOR_NAME")
    @JsonProperty("DOCTOR_NAME")
    private String doctorName;

    @ApiModelProperty(value = "操作员代码")
    @TableField("OPERATOR")
    @JsonProperty("OPERATOR")
    private String operator;

    @ApiModelProperty(value = "操作员姓名")
    @TableField("OPERATOR_NAME")
    @JsonProperty("OPERATOR_NAME")
    private String operatorName;

    @ApiModelProperty(value = "判定结果对本次体检结果的评定，采用代码。见体检判定结果字典。")
    @TableField("JUDGEMENT")
    @JsonProperty("JUDGEMENT")
    private String judgement;

    @ApiModelProperty(value = "汇总标志 1：已汇总0：为汇总")
    @TableField("CHIEF_SUM_FLAG")
    @JsonProperty("CHIEF_SUM_FLAG")
    private String chiefSumFlag;


}
