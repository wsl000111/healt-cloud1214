package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
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
 * 检查主记录 
 * </p>
 *
 * @author GuYue
 * @since 2022-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_EXAM_MASTER")
@ApiModel(value="HcExamMaster对象", description="检查主记录 ")
public class HcExamMaster implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "申请序号")
    @TableId(value = "EXAM_NO", type = IdType.ASSIGN_ID)
    @JsonProperty("EXAM_NO")
    private String examNo;

    @ApiModelProperty(value = "检查号类别")
    @TableField("LOCAL_ID_CLASS")
    @JsonProperty("LOCAL_ID_CLASS")
    private String localIdClass;

    @ApiModelProperty(value = "检查标识号")
    @TableField("PATIENT_LOCAL_ID")
    @JsonProperty("PATIENT_LOCAL_ID")
    private String patientLocalId;

    @ApiModelProperty(value = "病人标识号")
    @TableField("PATIENT_ID")
    @JsonProperty("PATIENT_ID")
    private String patientId;

    @ApiModelProperty(value = "病人本次住院标识")
    @TableField("VISIT_ID")
    @JsonProperty("VISIT_ID")
    private Integer visitId;

    @ApiModelProperty(value = "姓名")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "出生日期")
    @TableField("DATE_OF_BIRTH")
    @JsonProperty("DATE_OF_BIRTH")
    private Date dateOfBirth;

    @ApiModelProperty(value = "检查类别")
    @TableField("EXAM_CLASS")
    @JsonProperty("EXAM_CLASS")
    private String examClass;

    @ApiModelProperty(value = "检查子类")
    @TableField("EXAM_SUB_CLASS")
    @JsonProperty("EXAM_SUB_CLASS")
    private String examSubClass;

    @ApiModelProperty(value = "标本收到日期及时间")
    @TableField("SPM_RECVED_DATE")
    @JsonProperty("SPM_RECVED_DATE")
    private Date spmRecvedDate;

    @ApiModelProperty(value = "临床症状")
    @TableField("CLIN_SYMP")
    @JsonProperty("CLIN_SYMP")
    private String clinSymp;

    @ApiModelProperty(value = "体征")
    @TableField("PHYS_SIGN")
    @JsonProperty("PHYS_SIGN")
    private String physSign;

    @ApiModelProperty(value = "相关化验结果")
    @TableField("RELEVANT_LAB_TEST")
    @JsonProperty("RELEVANT_LAB_TEST")
    private String relevantLabTest;

    @ApiModelProperty(value = "其他诊断")
    @TableField("RELEVANT_DIAG")
    @JsonProperty("RELEVANT_DIAG")
    private String relevantDiag;

    @ApiModelProperty(value = "临床诊断")
    @TableField("CLIN_DIAG")
    @JsonProperty("CLIN_DIAG")
    private String clinDiag;

    @ApiModelProperty(value = "检查方式")
    @TableField("EXAM_MODE")
    @JsonProperty("EXAM_MODE")
    private String examMode;

    @ApiModelProperty(value = "检查分组")
    @TableField("EXAM_GROUP")
    @JsonProperty("EXAM_GROUP")
    private String examGroup;

    @ApiModelProperty(value = "使用仪器")
    @TableField("DEVICE")
    @JsonProperty("DEVICE")
    private String device;

    @ApiModelProperty(value = "执行科室")
    @TableField("PERFORMED_BY")
    @JsonProperty("PERFORMED_BY")
    private String performedBy;

    @ApiModelProperty(value = "病人来源")
    @TableField("PATIENT_SOURCE")
    @JsonProperty("PATIENT_SOURCE")
    private String patientSource;

    @ApiModelProperty(value = "外来医疗单位名称")
    @TableField("FACILITY")
    @JsonProperty("FACILITY")
    private String facility;

    @ApiModelProperty(value = "申请日期及时间")
    @TableField("REQ_DATE_TIME")
    @JsonProperty("REQ_DATE_TIME")
    private Date reqDateTime;

    @ApiModelProperty(value = "申请科室")
    @TableField("REQ_DEPT")
    @JsonProperty("REQ_DEPT")
    private String reqDept;

    @ApiModelProperty(value = "申请医生姓名")
    @TableField("REQ_PHYSICIAN")
    @JsonProperty("REQ_PHYSICIAN")
    private String reqPhysician;

    @ApiModelProperty(value = "申请备注")
    @TableField("REQ_MEMO")
    @JsonProperty("REQ_MEMO")
    private String reqMemo;

    @ApiModelProperty(value = "预约日期及时间")
    @TableField("SCHEDULED_DATE_TIME")
    @JsonProperty("SCHEDULED_DATE_TIME")
    private Date scheduledDateTime;

    @ApiModelProperty(value = "注意事项")
    @TableField("NOTICE")
    @JsonProperty("NOTICE")
    private String notice;

    @ApiModelProperty(value = "检查日期及时间")
    @TableField("EXAM_DATE_TIME")
    @JsonProperty("EXAM_DATE_TIME")
    private Date examDateTime;

    @ApiModelProperty(value = "报告日期及时间")
    @TableField("REPORT_DATE_TIME")
    @JsonProperty("REPORT_DATE_TIME")
    private Date reportDateTime;

    @ApiModelProperty(value = "操作者")
    @TableField("TECHNICIAN")
    @JsonProperty("TECHNICIAN")
    private String technician;

    @ApiModelProperty(value = "报告者")
    @TableField("REPORTER")
    @JsonProperty("REPORTER")
    private String reporter;

    @ApiModelProperty(value = "检查结果状态")
    @TableField("RESULT_STATUS")
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

    @ApiModelProperty(value = "费用")
    @TableField("COSTS")
    @JsonProperty("COSTS")
    private BigDecimal costs;

    @ApiModelProperty(value = "应收费用")
    @TableField("CHARGES")
    @JsonProperty("CHARGES")
    private BigDecimal charges;

    @ApiModelProperty(value = "计价标志")
    @TableField("CHARGE_INDICATOR")
    @JsonProperty("CHARGE_INDICATOR")
    private Integer chargeIndicator;

    @ApiModelProperty(value = "病人费用类别")
    @TableField("CHARGE_TYPE")
    @JsonProperty("CHARGE_TYPE")
    private String chargeType;

    @ApiModelProperty(value = "身份")
    @TableField("IDENTITY")
    @JsonProperty("IDENTITY")
    private String identity;

    @ApiModelProperty(value = "报告状态")
    @TableField("RPTSTATUS")
    @JsonProperty("RPTSTATUS")
    private String rptstatus;

    @ApiModelProperty(value = "打印状态")
    @TableField("PRINT_STATUS")
    @JsonProperty("PRINT_STATUS")
    private String printStatus;

    @ApiModelProperty(value = "检查子科室")
    @TableField("EXAM_SUBDEPT")
    @JsonProperty("EXAM_SUBDEPT")
    private String examSubdept;

    @ApiModelProperty(value = "确认")
    @TableField("CONFIRM_DOCT")
    @JsonProperty("CONFIRM_DOCT")
    private String confirmDoct;

    @ApiModelProperty(value = "学习者")
    @TableField("STUDY_UID")
    @JsonProperty("STUDY_UID")
    private String studyUid;

    @ApiModelProperty(value = "照片状态")
    @TableField("PHOTO_STATUS")
    @JsonProperty("PHOTO_STATUS")
    private String photoStatus;

    @ApiModelProperty(value = "确认日期")
    @TableField("CONFIRM_DATE_TIME")
    @JsonProperty("CONFIRM_DATE_TIME")
    private Date confirmDateTime;

    @ApiModelProperty(value = "分诊排队序号")
    @TableField("QUEUE_NO")
    @JsonProperty("QUEUE_NO")
    private String queueNo;

    @ApiModelProperty(value = "检查原因")
    @TableField("EXAM_REASON")
    @JsonProperty("EXAM_REASON")
    private String examReason;

    @ApiModelProperty(value = "是否优先")
    @TableField("PRIORITY_INDICATOR")
    @JsonProperty("PRIORITY_INDICATOR")
    private String priorityIndicator;

    @ApiModelProperty(value = "出生地")
    @TableField("BIRTH_PLACE")
    @JsonProperty("BIRTH_PLACE")
    private String birthPlace;

    @ApiModelProperty(value = "电话")
    @TableField("PHONE_NUMBER")
    @JsonProperty("PHONE_NUMBER")
    private String phoneNumber;

    @ApiModelProperty(value = "邮编")
    @TableField("ZIP_CODE")
    @JsonProperty("ZIP_CODE")
    private String zipCode;

    @ApiModelProperty(value = "通信地址")
    @TableField("MAILING_ADDRESS")
    @JsonProperty("MAILING_ADDRESS")
    private String mailingAddress;

    @ApiModelProperty(value = "姓名拼音")
    @TableField("NAME_PHONETIC")
    @JsonProperty("NAME_PHONETIC")
    private String namePhonetic;

    @ApiModelProperty(value = "申请医生用户名(staff_dict.user_name)")
    @TableField("DOCTOR_USER")
    @JsonProperty("DOCTOR_USER")
    private String doctorUser;

    @ApiModelProperty(value = "电子签章序号")
    @TableField("SIGNATURE_NO")
    @JsonProperty("SIGNATURE_NO")
    private Integer signatureNo;

    @ApiModelProperty(value = "审核通过标志,1通过")
    @TableField("EVALUATE_PASS_FALG")
    @JsonProperty("EVALUATE_PASS_FALG")
    private String evaluatePassFalg;

    @ApiModelProperty(value = "核实者(staff_dict.user_name)")
    @TableField("VERIFIER")
    @JsonProperty("VERIFIER")
    private String verifier;

    @ApiModelProperty(value = "审计者(staff_dict.user_name)")
    @TableField("AUDITING_DOCT")
    @JsonProperty("AUDITING_DOCT")
    private String auditingDoct;

    @ApiModelProperty(value = "审计日期")
    @TableField("AUDITING_DATE_TIME")
    @JsonProperty("AUDITING_DATE_TIME")
    private Date auditingDateTime;

    @ApiModelProperty(value = "预约日期")
    @TableField("SCHEDULED_DATE")
    @JsonProperty("SCHEDULED_DATE")
    private Date scheduledDate;

    @ApiModelProperty(value = "取消者(staff_dict.user_name)")
    @TableField("CANCEL_OPER")
    @JsonProperty("CANCEL_OPER")
    private String cancelOper;

    @ApiModelProperty(value = "取消日期")
    @TableField("CANCEL_DATETIME")
    @JsonProperty("CANCEL_DATETIME")
    private Date cancelDatetime;

    @ApiModelProperty(value = "病人本次留观标识")
    @TableField("OB_VISIT_NO")
    @JsonProperty("OB_VISIT_NO")
    private String obVisitNo;

    @ApiModelProperty(value = " PACS撤销操作员")
    @TableField("XY_CANCEL_OPER")
    @JsonProperty("XY_CANCEL_OPER")
    private String xyCancelOper;

    @ApiModelProperty(value = " PACS撤销操作时间")
    @TableField("XY_CANCEL_DATETIME")
    @JsonProperty("XY_CANCEL_DATETIME")
    private Date xyCancelDatetime;

    @ApiModelProperty(value = " 申请单状态 SC已登记、已预约 CA已取消 IP检查开始 CM检查完成 P报告提交 F报告审核完成")
    @TableField("XY_STATUS")
    @JsonProperty("XY_STATUS")
    private String xyStatus;

    @TableField("ILLNESS_DESC")
    @JsonProperty("ILLNESS_DESC")
    private String illnessDesc;

    @ApiModelProperty(value = "收据号")
    @TableField("RCPT_NO")
    @JsonProperty("RCPT_NO")
    private String rcptNo;

    @TableField("HIS_UNIT_CODE")
    @JsonProperty("HIS_UNIT_CODE")
    private String hisUnitCode;


}
