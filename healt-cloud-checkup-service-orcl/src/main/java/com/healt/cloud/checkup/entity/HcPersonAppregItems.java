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
 * 人员预约项目表
 * </p>
 *
 * @author GuYue
 * @since 2022-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_PERSON_APPREG_ITEMS")
@ApiModel(value="HcPersonAppregItems对象", description="人员预约项目表")
public class HcPersonAppregItems implements Serializable {

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

    @ApiModelProperty(value = "项目编码")
    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @ApiModelProperty(value = "预约日期")
    @TableField("REGISTER_DATE")
    @JsonProperty("REGISTER_DATE")
    private Date registerDate;

    @ApiModelProperty(value = "预约人编码")
    @TableField("REGISTER")
    @JsonProperty("REGISTER")
    private String register;

    @ApiModelProperty(value = "预约人姓名")
    @TableField("REGISTER_NAME")
    @JsonProperty("REGISTER_NAME")
    private String registerName;

    @ApiModelProperty(value = "是否加项")
    @TableField("ADD_ITEM")
    @JsonProperty("ADD_ITEM")
    private String addItem;

    @ApiModelProperty(value = "指引单分组代码")
    @TableField("CHART_CODE")
    @JsonProperty("CHART_CODE")
    private String chartCode;

    @ApiModelProperty(value = "检查检验申请号")
    @TableField("APPLY_NO")
    @JsonProperty("APPLY_NO")
    private String applyNo;

    @TableField("SUBMIT_APPLY")
    @JsonProperty("SUBMIT_APPLY")
    private String submitApply;

    @ApiModelProperty(value = "打印标签标志")
    @TableField("APPLY_NO_PRINT")
    @JsonProperty("APPLY_NO_PRINT")
    private String applyNoPrint;

    @ApiModelProperty(value = "应收")
    @TableField("COSTS")
    @JsonProperty("COSTS")
    private BigDecimal costs;

    @ApiModelProperty(value = "实收")
    @TableField("CHARGES")
    @JsonProperty("CHARGES")
    private BigDecimal charges;

    @ApiModelProperty(value = "缴费标志")
    @TableField("BILL_INDICATOR")
    @JsonProperty("BILL_INDICATOR")
    private String billIndicator;

    @ApiModelProperty(value = "完成标志")
    @TableField("FINISHED_SIGN")
    @JsonProperty("FINISHED_SIGN")
    private String finishedSign;

    @ApiModelProperty(value = "数量")
    @TableField("NUM")
    @JsonProperty("NUM")
    private BigDecimal num;

    @ApiModelProperty(value = "套餐编码")
    @TableField("SET_CODE")
    @JsonProperty("SET_CODE")
    private String setCode;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "完成时间")
    @TableField("FINISHED_DATE")
    @JsonProperty("FINISHED_DATE")
    private Date finishedDate;

    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @TableField("DOCTOR_ID")
    @JsonProperty("DOCTOR_ID")
    private String doctorId;

    @TableField("DOCTOR_NAME")
    @JsonProperty("DOCTOR_NAME")
    private String doctorName;

    @TableField("EDITER_ID")
    @JsonProperty("EDITER_ID")
    private String editerId;

    @TableField("EDITER_NAME")
    @JsonProperty("EDITER_NAME")
    private String editerName;

    @TableField("AUTO_FINISHED")
    @JsonProperty("AUTO_FINISHED")
    private String autoFinished;

    @TableField("FUTURE_CONTINUE")
    @JsonProperty("FUTURE_CONTINUE")
    private String futureContinue;

    @TableField("IMAGEPATH")
    @JsonProperty("IMAGEPATH")
    private String imagepath;

    @TableField("DOUBLE_DOCTOR_NAME")
    @JsonProperty("DOUBLE_DOCTOR_NAME")
    private String doubleDoctorName;

    @TableField("HB_PRINT_FLAG")
    @JsonProperty("HB_PRINT_FLAG")
    private String hbPrintFlag;

    @TableField("HB_PRINT_DATE")
    @JsonProperty("HB_PRINT_DATE")
    private Date hbPrintDate;

    @ApiModelProperty(value = "上传HIS收费标记，上传后更为1")
    @TableField("UPLOAD_FLAG")
    @JsonProperty("UPLOAD_FLAG")
    private String uploadFlag;

    @ApiModelProperty(value = "上传HIS收费的医嘱ID ")
    @TableField("ORDER_ID")
    @JsonProperty("ORDER_ID")
    private String orderId;

    @ApiModelProperty(value = "团检上传HIS收费的ID")
    @TableField("TJ_ORDER_ID")
    @JsonProperty("TJ_ORDER_ID")
    private String tjOrderId;


}
