package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
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
 * @author GuYue
 * @since 2022-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_LAB_TEST_MASTER")
@ApiModel(value="VLabTestMaster对象", description="")
public class VLabTestMaster implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("TEST_NO")
    @JsonProperty("TEST_NO")
    private String testNo;

    @TableField("PRIORITY_INDICATOR")
    @JsonProperty("PRIORITY_INDICATOR")
    private Integer priorityIndicator;

    @TableField("PATIENT_ID")
    @JsonProperty("PATIENT_ID")
    private String patientId;

    @TableField("VISIT_ID")
    @JsonProperty("VISIT_ID")
    private Integer visitId;

    @TableField("WORKING_ID")
    @JsonProperty("WORKING_ID")
    private String workingId;

    @TableField("EXECUTE_DATE")
    @JsonProperty("EXECUTE_DATE")
    private Date executeDate;

    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @TableField("NAME_PHONETIC")
    @JsonProperty("NAME_PHONETIC")
    private String namePhonetic;

    @TableField("CHARGE_TYPE")
    @JsonProperty("CHARGE_TYPE")
    private String chargeType;

    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @TableField("AGE")
    @JsonProperty("AGE")
    private Integer age;

    @TableField("TEST_CAUSE")
    @JsonProperty("TEST_CAUSE")
    private String testCause;

    @TableField("RELEVANT_CLINIC_DIAG")
    @JsonProperty("RELEVANT_CLINIC_DIAG")
    private String relevantClinicDiag;

    @TableField("SPECIMEN")
    @JsonProperty("SPECIMEN")
    private String specimen;

    @TableField("NOTES_FOR_SPCM")
    @JsonProperty("NOTES_FOR_SPCM")
    private String notesForSpcm;

    @TableField("SPCM_RECEIVED_DATE_TIME")
    @JsonProperty("SPCM_RECEIVED_DATE_TIME")
    private Date spcmReceivedDateTime;

    @TableField("SPCM_SAMPLE_DATE_TIME")
    @JsonProperty("SPCM_SAMPLE_DATE_TIME")
    private Date spcmSampleDateTime;

    @TableField("REQUESTED_DATE_TIME")
    @JsonProperty("REQUESTED_DATE_TIME")
    private Date requestedDateTime;

    @TableField("ORDERING_DEPT")
    @JsonProperty("ORDERING_DEPT")
    private String orderingDept;

    @TableField("ORDERING_PROVIDER")
    @JsonProperty("ORDERING_PROVIDER")
    private String orderingProvider;

    @TableField("PERFORMED_BY")
    @JsonProperty("PERFORMED_BY")
    private String performedBy;

    @TableField("RESULT_STATUS")
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

    @TableField("RESULTS_RPT_DATE_TIME")
    @JsonProperty("RESULTS_RPT_DATE_TIME")
    private Date resultsRptDateTime;

    @TableField("TRANSCRIPTIONIST")
    @JsonProperty("TRANSCRIPTIONIST")
    private String transcriptionist;

    @TableField("VERIFIED_BY")
    @JsonProperty("VERIFIED_BY")
    private String verifiedBy;

    @TableField("COSTS")
    @JsonProperty("COSTS")
    private BigDecimal costs;

    @TableField("CHARGES")
    @JsonProperty("CHARGES")
    private BigDecimal charges;

    @TableField("BILLING_INDICATOR")
    @JsonProperty("BILLING_INDICATOR")
    private Integer billingIndicator;

    @TableField("PRINT_INDICATOR")
    @JsonProperty("PRINT_INDICATOR")
    private Integer printIndicator;

    @TableField("SUBJECT")
    @JsonProperty("SUBJECT")
    private String subject;

    @TableField("CONTAINER_CARRIER")
    @JsonProperty("CONTAINER_CARRIER")
    private String containerCarrier;

    @TableField("STATUS")
    @JsonProperty("STATUS")
    private String status;

    @TableField("SPECIMEN_CODE")
    @JsonProperty("SPECIMEN_CODE")
    private String specimenCode;

    @TableField("SPCM_SAMPLE_DEPT")
    @JsonProperty("SPCM_SAMPLE_DEPT")
    private String spcmSampleDept;

    @TableField("SPCM_SAMPLE_POSITION")
    @JsonProperty("SPCM_SAMPLE_POSITION")
    private String spcmSamplePosition;

    @TableField("VESSEL_NAME")
    @JsonProperty("VESSEL_NAME")
    private String vesselName;

    @TableField("INTERVALS_AFTER")
    @JsonProperty("INTERVALS_AFTER")
    private BigDecimal intervalsAfter;

    @TableField("SIGNATURE_NO")
    @JsonProperty("SIGNATURE_NO")
    private Integer signatureNo;

    @TableField("EVALUATE_PASS_FALG")
    @JsonProperty("EVALUATE_PASS_FALG")
    private String evaluatePassFalg;

    @TableField("REQUISITION")
    @JsonProperty("REQUISITION")
    private Integer requisition;

    @TableField("OPER_ID")
    @JsonProperty("OPER_ID")
    private String operId;

    @TableField("REPORTTIME")
    @JsonProperty("REPORTTIME")
    private Date reporttime;

    @TableField("BED_LABEL")
    @JsonProperty("BED_LABEL")
    private String bedLabel;

    @TableField("UPDATA_INDICATOR")
    @JsonProperty("UPDATA_INDICATOR")
    private String updataIndicator;

    @TableField("SPECIMEN_LOCATION")
    @JsonProperty("SPECIMEN_LOCATION")
    private String specimenLocation;

    @TableField("OB_VISIT_NO")
    @JsonProperty("OB_VISIT_NO")
    private String obVisitNo;

    @TableField("RCPT_NO")
    @JsonProperty("RCPT_NO")
    private String rcptNo;

    @TableField("XY_STATUS")
    @JsonProperty("XY_STATUS")
    private String xyStatus;

    @TableField("PRINT_STATUS")
    @JsonProperty("PRINT_STATUS")
    private String printStatus;

    @TableField("EMERGENCY_FLAG")
    @JsonProperty("EMERGENCY_FLAG")
    private String emergencyFlag;

    @TableField("PRINT_DEPT")
    @JsonProperty("PRINT_DEPT")
    private String printDept;

    @TableField("PRINT_OPER")
    @JsonProperty("PRINT_OPER")
    private String printOper;

    @TableField("PRINT_DATETIME")
    @JsonProperty("PRINT_DATETIME")
    private Date printDatetime;

    @TableField("PRINT_PQ")
    @JsonProperty("PRINT_PQ")
    private String printPq;

    @TableField("HIS_UNIT_CODE")
    @JsonProperty("HIS_UNIT_CODE")
    private String hisUnitCode;

    @TableField("CLINIC_NO")
    @JsonProperty("CLINIC_NO")
    private String clinicNo;

    @TableField("DATA_SOURCE")
    @JsonProperty("DATA_SOURCE")
    private String dataSource;

    @TableField("MEMO")
    @JsonProperty("MEMO")
    private String memo;

    @TableField("ITEM_PRINT_NAME")
    @JsonProperty("ITEM_PRINT_NAME")
    private String itemPrintName;


}
