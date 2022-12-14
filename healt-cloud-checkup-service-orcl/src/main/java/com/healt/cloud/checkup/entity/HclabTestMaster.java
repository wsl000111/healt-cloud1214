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
 * 检验主记录
 * </p>
 *
 * @author GuYue
 * @since 2022-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HCLAB_TEST_MASTER")
@ApiModel(value="HclabTestMaster对象", description="检验主记录")
public class HclabTestMaster implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "申请序号")
    @TableId(value = "TEST_NO", type = IdType.ASSIGN_ID)
    @JsonProperty("TEST_NO")
    private String testNo;

    @ApiModelProperty(value = "优先标志")
    @TableField("PRIORITY_INDICATOR")
    @JsonProperty("PRIORITY_INDICATOR")
    private Integer priorityIndicator;

    @ApiModelProperty(value = "病人标识号")
    @TableField("PATIENT_ID")
    @JsonProperty("PATIENT_ID")
    private String patientId;

    @ApiModelProperty(value = "本次住院标识")
    @TableField("VISIT_ID")
    @JsonProperty("VISIT_ID")
    private Integer visitId;

    @ApiModelProperty(value = "工作单号")
    @TableField("WORKING_ID")
    @JsonProperty("WORKING_ID")
    private String workingId;

    @ApiModelProperty(value = "计划执行日期")
    @TableField("EXECUTE_DATE")
    @JsonProperty("EXECUTE_DATE")
    private Date executeDate;

    @ApiModelProperty(value = "姓名")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "姓名拼音")
    @TableField("NAME_PHONETIC")
    @JsonProperty("NAME_PHONETIC")
    private String namePhonetic;

    @ApiModelProperty(value = "费别")
    @TableField("CHARGE_TYPE")
    @JsonProperty("CHARGE_TYPE")
    private String chargeType;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "年龄")
    @TableField("AGE")
    @JsonProperty("AGE")
    private Integer age;

    @ApiModelProperty(value = "检验目的")
    @TableField("TEST_CAUSE")
    @JsonProperty("TEST_CAUSE")
    private String testCause;

    @ApiModelProperty(value = "临床诊断")
    @TableField("RELEVANT_CLINIC_DIAG")
    @JsonProperty("RELEVANT_CLINIC_DIAG")
    private String relevantClinicDiag;

    @ApiModelProperty(value = "标本")
    @TableField("SPECIMEN")
    @JsonProperty("SPECIMEN")
    private String specimen;

    @ApiModelProperty(value = "标本说明")
    @TableField("NOTES_FOR_SPCM")
    @JsonProperty("NOTES_FOR_SPCM")
    private String notesForSpcm;

    @ApiModelProperty(value = "标本采样日期及时间")
    @TableField("SPCM_RECEIVED_DATE_TIME")
    @JsonProperty("SPCM_RECEIVED_DATE_TIME")
    private Date spcmReceivedDateTime;

    @ApiModelProperty(value = "标本收到日期及时间")
    @TableField("SPCM_SAMPLE_DATE_TIME")
    @JsonProperty("SPCM_SAMPLE_DATE_TIME")
    private Date spcmSampleDateTime;

    @ApiModelProperty(value = "申请日期及时间")
    @TableField("REQUESTED_DATE_TIME")
    @JsonProperty("REQUESTED_DATE_TIME")
    private Date requestedDateTime;

    @ApiModelProperty(value = "申请科室")
    @TableField("ORDERING_DEPT")
    @JsonProperty("ORDERING_DEPT")
    private String orderingDept;

    @ApiModelProperty(value = "申请医生")
    @TableField("ORDERING_PROVIDER")
    @JsonProperty("ORDERING_PROVIDER")
    private String orderingProvider;

    @ApiModelProperty(value = "执行科室")
    @TableField("PERFORMED_BY")
    @JsonProperty("PERFORMED_BY")
    private String performedBy;

    @ApiModelProperty(value = "结果状态  1已发送 4大家已审核")
    @TableField("RESULT_STATUS")
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

    @ApiModelProperty(value = "报告日期及时间")
    @TableField("RESULTS_RPT_DATE_TIME")
    @JsonProperty("RESULTS_RPT_DATE_TIME")
    private Date resultsRptDateTime;

    @ApiModelProperty(value = "报告者")
    @TableField("TRANSCRIPTIONIST")
    @JsonProperty("TRANSCRIPTIONIST")
    private String transcriptionist;

    @ApiModelProperty(value = "校对者")
    @TableField("VERIFIED_BY")
    @JsonProperty("VERIFIED_BY")
    private String verifiedBy;

    @ApiModelProperty(value = "费用")
    @TableField("COSTS")
    @JsonProperty("COSTS")
    private BigDecimal costs;

    @ApiModelProperty(value = "应收费用")
    @TableField("CHARGES")
    @JsonProperty("CHARGES")
    private BigDecimal charges;

    @ApiModelProperty(value = "计价标志")
    @TableField("BILLING_INDICATOR")
    @JsonProperty("BILLING_INDICATOR")
    private Integer billingIndicator;

    @ApiModelProperty(value = "打印标志")
    @TableField("PRINT_INDICATOR")
    @JsonProperty("PRINT_INDICATOR")
    private Integer printIndicator;

    @ApiModelProperty(value = "检验标签主题")
    @TableField("SUBJECT")
    @JsonProperty("SUBJECT")
    private String subject;

    @ApiModelProperty(value = "送检的容器或载体编号")
    @TableField("CONTAINER_CARRIER")
    @JsonProperty("CONTAINER_CARRIER")
    private String containerCarrier;

    @ApiModelProperty(value = "检验状态 1医生申请 4审核报告 5生成条码")
    @TableField("STATUS")
    @JsonProperty("STATUS")
    private String status;

    @ApiModelProperty(value = "标本代码")
    @TableField("SPECIMEN_CODE")
    @JsonProperty("SPECIMEN_CODE")
    private String specimenCode;

    @ApiModelProperty(value = "标本采样科室")
    @TableField("SPCM_SAMPLE_DEPT")
    @JsonProperty("SPCM_SAMPLE_DEPT")
    private String spcmSampleDept;

    @ApiModelProperty(value = "采样地点描述")
    @TableField("SPCM_SAMPLE_POSITION")
    @JsonProperty("SPCM_SAMPLE_POSITION")
    private String spcmSamplePosition;

    @ApiModelProperty(value = "标本采样容器")
    @TableField("VESSEL_NAME")
    @JsonProperty("VESSEL_NAME")
    private String vesselName;

    @ApiModelProperty(value = "采样参考间隔时间")
    @TableField("INTERVALS_AFTER")
    @JsonProperty("INTERVALS_AFTER")
    private BigDecimal intervalsAfter;

    @ApiModelProperty(value = "电子签章序号")
    @TableField("SIGNATURE_NO")
    @JsonProperty("SIGNATURE_NO")
    private Integer signatureNo;

    @ApiModelProperty(value = "审核通过标志,1通过")
    @TableField("EVALUATE_PASS_FALG")
    @JsonProperty("EVALUATE_PASS_FALG")
    private String evaluatePassFalg;

    @ApiModelProperty(value = "申请")
    @TableField("REQUISITION")
    @JsonProperty("REQUISITION")
    private Integer requisition;

    @ApiModelProperty(value = "操作者")
    @TableField("OPER_ID")
    @JsonProperty("OPER_ID")
    private String operId;

    @ApiModelProperty(value = "报告日期")
    @TableField("REPORTTIME")
    @JsonProperty("REPORTTIME")
    private Date reporttime;

    @ApiModelProperty(value = "床标号")
    @TableField("BED_LABEL")
    @JsonProperty("BED_LABEL")
    private String bedLabel;

    @ApiModelProperty(value = "更新标记")
    @TableField("UPDATA_INDICATOR")
    @JsonProperty("UPDATA_INDICATOR")
    private String updataIndicator;

    @ApiModelProperty(value = "标本采集地点描述")
    @TableField("SPECIMEN_LOCATION")
    @JsonProperty("SPECIMEN_LOCATION")
    private String specimenLocation;

    @ApiModelProperty(value = "病人本次留观标识")
    @TableField("OB_VISIT_NO")
    @JsonProperty("OB_VISIT_NO")
    private String obVisitNo;

    @ApiModelProperty(value = "收据号")
    @TableField("RCPT_NO")
    @JsonProperty("RCPT_NO")
    private String rcptNo;

    @ApiModelProperty(value = "NW(新医嘱)|CA(删除取消检体核收)|SC|(检体核收)CR(检体拒收)")
    @TableField("XY_STATUS")
    @JsonProperty("XY_STATUS")
    private String xyStatus;

    @ApiModelProperty(value = "检验报告打印标识'0'是未打印 '1'是打印")
    @TableField("PRINT_STATUS")
    @JsonProperty("PRINT_STATUS")
    private String printStatus;

    @ApiModelProperty(value = "加急标志")
    @TableField("EMERGENCY_FLAG")
    @JsonProperty("EMERGENCY_FLAG")
    private String emergencyFlag;

    @ApiModelProperty(value = "打印科室")
    @TableField("PRINT_DEPT")
    @JsonProperty("PRINT_DEPT")
    private String printDept;

    @ApiModelProperty(value = "打印人")
    @TableField("PRINT_OPER")
    @JsonProperty("PRINT_OPER")
    private String printOper;

    @ApiModelProperty(value = "打印时间")
    @TableField("PRINT_DATETIME")
    @JsonProperty("PRINT_DATETIME")
    private Date printDatetime;

    @ApiModelProperty(value = "住院医是否打印过次检验结果标志：1已打印")
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
