package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
//import com.fasterxml.jackson.annotation.JsonInclude;//不返回null值字段
import com.fasterxml.jackson.annotation.JsonProperty;//前端传值有下划线
import org.apache.ibatis.type.JdbcType;

/**
 * <p>
 * 个人体检信息
 * </p>
 *
 * @author GuYue
 * @since 2022-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_PERSON_VISIT_INFO")
@ApiModel(value="HcPersonVisitInfo对象", description="个人体检信息")
public class HcPersonVisitInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
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

    @ApiModelProperty(value = "预约日期")
    @TableField("APPOINTS_DATE")
    @JsonProperty("APPOINTS_DATE")
    private Date appointsDate;

    @ApiModelProperty(value = "预约完成日期")
    @TableField("APPOINTS_END_DATE")
    @JsonProperty("APPOINTS_END_DATE")
    private Date appointsEndDate;

    @ApiModelProperty(value = "检完签到")
    @TableField("FINISHED_SIGN")
    @JsonProperty("FINISHED_SIGN")
    private String finishedSign;

    @ApiModelProperty(value = "检完时间")
    @TableField("FINISHED_DATE")
    @JsonProperty("FINISHED_DATE")
    private Date finishedDate;

    @ApiModelProperty(value = "检完系统用户")
    @TableField("FINISHED_ID")
    @JsonProperty("FINISHED_ID")
    private String finishedId;

    @ApiModelProperty(value = "系统用户名称")
    @TableField("FINISHED_NAME")
    @JsonProperty("FINISHED_NAME")
    private String finishedName;

    @ApiModelProperty(value = "分组编号")
    @TableField("GROUP_ID")
    @JsonProperty("GROUP_ID")
    private String groupId;

    @ApiModelProperty(value = "部门")
    @TableField("DEPARTMENT")
    @JsonProperty("DEPARTMENT")
    private String department;

    @ApiModelProperty(value = "体检费别")
    @TableField("PERSON_CHARGE")
    @JsonProperty("PERSON_CHARGE")
    private String personCharge;

    @ApiModelProperty(value = "年龄")
    @TableField("AGE")
    @JsonProperty("AGE")
    private Integer age;

    @ApiModelProperty(value = "职业")
    @TableField("JOB")
    @JsonProperty("JOB")
    private String job;

    @ApiModelProperty(value = "婚姻状况")
    @TableField("MARITAL_STATUS")
    @JsonProperty("MARITAL_STATUS")
    private String maritalStatus;

    @ApiModelProperty(value = "来源")
    @TableField("SOURCE")
    @JsonProperty("SOURCE")
    private String source;

    @ApiModelProperty(value = "检查类别")
    @TableField("EXAM_CLASS")
    @JsonProperty("EXAM_CLASS")
    private String examClass;

    @ApiModelProperty(value = "级别")
    @TableField("PERSON_LEVEL")
    @JsonProperty("PERSON_LEVEL")
    private String personLevel;

    @ApiModelProperty(value = "检查状态 0-已预约 1-已执行2-待审核 7-已初审 9-已终审")
    @TableField("RESULT_STATUS")
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

    @ApiModelProperty(value = "折扣")
    @TableField("DISCOUNT")
    @JsonProperty("DISCOUNT")
    private BigDecimal discount;

    @ApiModelProperty(value = "建档时间")
    @TableField("BUILD_DATE")
    @JsonProperty("BUILD_DATE")
    private Date buildDate;

    @ApiModelProperty(value = "建档人")
    @TableField("USER_ID")
    @JsonProperty("USER_ID")
    private String userId;

    @ApiModelProperty(value = "建档人姓名")
    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "检前签到标志")
    @TableField("BEFORE_SIGN")
    @JsonProperty("BEFORE_SIGN")
    private String beforeSign;

    @ApiModelProperty(value = "检前签到时间")
    @TableField("BEFORE_DATE")
    @JsonProperty("BEFORE_DATE")
    private Date beforeDate;

    @ApiModelProperty(value = "检前系统用户")
    @TableField("BEFORE_ID")
    @JsonProperty("BEFORE_ID")
    private String beforeId;

    @ApiModelProperty(value = "检前系统用户名称")
    @TableField("BEFORE_NAME")
    @JsonProperty("BEFORE_NAME")
    private String beforeName;

    @ApiModelProperty(value = "抽血标志")
    @TableField("BLOOD_SIGN")
    @JsonProperty("BLOOD_SIGN")
    private String bloodSign;

    @ApiModelProperty(value = "抽血时间")
    @TableField("BLOOD_DATE")
    @JsonProperty("BLOOD_DATE")
    private Date bloodDate;

    @ApiModelProperty(value = "抽血系统用户")
    @TableField("BLOOD_ID")
    @JsonProperty("BLOOD_ID")
    private String bloodId;

    @ApiModelProperty(value = "抽血系统用户名称")
    @TableField("BLOOD_NAME")
    @JsonProperty("BLOOD_NAME")
    private String bloodName;

    @ApiModelProperty(value = "报告打印标志")
    @TableField("PRINT_SIGN")
    @JsonProperty("PRINT_SIGN")
    private String printSign;

    @ApiModelProperty(value = "报告打印时间")
    @TableField("PRINT_DATE")
    @JsonProperty("PRINT_DATE")
    private Date printDate;

    @ApiModelProperty(value = "报告打印系统用户")
    @TableField("PRINT_ID")
    @JsonProperty("PRINT_ID")
    private String printId;

    @ApiModelProperty(value = "报告打印用户名称")
    @TableField("PRINT_NAME")
    @JsonProperty("PRINT_NAME")
    private String printName;

    @ApiModelProperty(value = "类型 互联网 app")
    @TableField("PRINT_TYPE")
    @JsonProperty("PRINT_TYPE")
    private String printType;

    @ApiModelProperty(value = "提取报告标志")
    @TableField("RETRIEVE_SIGN")
    @JsonProperty("RETRIEVE_SIGN")
    private String retrieveSign;

    @ApiModelProperty(value = "提取报告时间")
    @TableField("RETRIEVE_DATE")
    @JsonProperty("RETRIEVE_DATE")
    private Date retrieveDate;

    @ApiModelProperty(value = "提取报告系统用户")
    @TableField("RETRIEVE_ID")
    @JsonProperty("RETRIEVE_ID")
    private String retrieveId;

    @ApiModelProperty(value = "提取报告用户名称")
    @TableField("RETRIEVE_NAME")
    @JsonProperty("RETRIEVE_NAME")
    private String retrieveName;

    @ApiModelProperty(value = "终审医生")
    @TableField("FINAL_DOCOTER")
    @JsonProperty("FINAL_DOCOTER")
    private String finalDocoter;

    @ApiModelProperty(value = "终审时间")
    @TableField(value = "FINAL_DATE")
    @JsonProperty("FINAL_DATE")
    private Date finalDate;

    @ApiModelProperty(value = "终审医生名称")
    @TableField("FINAL_NAME")
    @JsonProperty("FINAL_NAME")
    private String finalName;

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

    @ApiModelProperty(value = "imgurl")
    @TableField("IMAGE_PATH")
    @JsonProperty("IMAGE_PATH")
    private String imagePath;

    @TableField("CARD_NO")
    @JsonProperty("CARD_NO")
    private String cardNo;

    @TableField("BEFORE_PRINT_NO")
    @JsonProperty("BEFORE_PRINT_NO")
    private String beforePrintNo;

    @TableField("FIRST_FLAG")
    @JsonProperty("FIRST_FLAG")
    private String firstFlag;

    @TableField("REPAIR_EXAM_FLAG")
    @JsonProperty("REPAIR_EXAM_FLAG")
    private String repairExamFlag;

    @TableField("REPAIR_EXAM_DATE")
    @JsonProperty("REPAIR_EXAM_DATE")
    private Date repairExamDate;

    @TableField("REPAIR_EXAM_USER")
    @JsonProperty("REPAIR_EXAM_USER")
    private String repairExamUser;

    @TableField("GET_REPORT_TYPE")
    @JsonProperty("GET_REPORT_TYPE")
    private String getReportType;

    @TableField("MAILING_ADDRESS")
    @JsonProperty("MAILING_ADDRESS")
    private String mailingAddress;

    @ApiModelProperty(value = "平台或HIS患者ID")
    @TableField("PATIENT_ID")
    @JsonProperty("PATIENT_ID")
    private String patientId;


}
