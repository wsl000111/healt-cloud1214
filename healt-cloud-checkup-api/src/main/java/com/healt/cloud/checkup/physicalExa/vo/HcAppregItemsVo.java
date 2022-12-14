package com.healt.cloud.checkup.physicalExa.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-05-24 9:13
 */
@Data
public class HcAppregItemsVo implements Serializable {

    private static final long serialVersionUID=1L;

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

    @ApiModelProperty(value = "预约日期")
    @TableField("APPOINTS_DATE")
    @JsonProperty("APPOINTS_DATE")
    private Date appointsDate;

    @ApiModelProperty(value = "项目编码")
    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @ApiModelProperty(value = "检查检验申请号")
    @TableField("APPLY_NO")
    @JsonProperty("APPLY_NO")
    private String applyNo;

    @ApiModelProperty(value = "完成标志")
    @TableField("FINISHED_SIGN")
    @JsonProperty("FINISHED_SIGN")
    private String finishedSign;

    @TableField("FINISHED_DATE")
    @JsonProperty("FINISHED_DATE")
    private Date finishedDate;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @TableField("DOCTOR_ID")
    @JsonProperty("DOCTOR_ID")
    private String doctorId;

    @TableField("DOCTOR_NAME")
    @JsonProperty("DOCTOR_NAME")
    private String doctorName;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @TableField("DEPT_NAME")
    @JsonProperty("HIS_DEPART_NAME")
    private String hisDepartName;

    @TableField("RESULT_HANDLE")
    @JsonProperty("RESULT_HANDLE")
    private String resultHandle;

    @TableField("HIS_DEPART_CODE")
    @JsonProperty("HIS_DEPART_CODE")
    private String hisDepartCode;

    @TableField("APPLY_SENDTO")
    @JsonProperty("APPLY_SENDTO")
    private String applySendto;

    @TableField("RESULT_RECIEVED")
    @JsonProperty("RESULT_RECIEVED")
    private String resultRecieved;

    @TableField("DEPT_ID")
    @JsonProperty("HC_DEPT_CODE")
    private String hcDeptCode;

    @TableField("HIS_DEPART_CODE")
    @JsonProperty("HC_DEPT_CODE1")
    private String hcDeptCode1;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME1")
    private String deptName1;

    @TableField("CLASS_NAME")
    @JsonProperty("CLASS_NAME")
    private String className;

}
