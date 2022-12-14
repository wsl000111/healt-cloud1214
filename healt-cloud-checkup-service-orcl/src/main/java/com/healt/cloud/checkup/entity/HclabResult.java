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
 * 检验结果
 * </p>
 *
 * @author GuYue
 * @since 2022-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HCLAB_RESULT")
@ApiModel(value="HclabResult对象", description="检验结果")
public class HclabResult implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "申请序号")
    @TableId(value = "TEST_NO", type = IdType.ASSIGN_ID)
    @JsonProperty("TEST_NO")
    private String testNo;

    @ApiModelProperty(value = "项目序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "打印序号")
    @TableField("PRINT_ORDER")
    @JsonProperty("PRINT_ORDER")
    private Integer printOrder;

    @ApiModelProperty(value = "检验报告项目名称")
    @TableField("REPORT_ITEM_NAME")
    @JsonProperty("REPORT_ITEM_NAME")
    private String reportItemName;

    @ApiModelProperty(value = "检验报告项目代码")
    @TableField("REPORT_ITEM_CODE")
    @JsonProperty("REPORT_ITEM_CODE")
    private String reportItemCode;

    @ApiModelProperty(value = "检验结果值")
    @TableField("RESULT")
    @JsonProperty("RESULT")
    private String result;

    @ApiModelProperty(value = "检验结果单位")
    @TableField("UNITS")
    @JsonProperty("UNITS")
    private String units;

    @ApiModelProperty(value = "结果正常标志")
    @TableField("ABNORMAL_INDICATOR")
    @JsonProperty("ABNORMAL_INDICATOR")
    private String abnormalIndicator;

    @ApiModelProperty(value = "仪器编号")
    @TableField("INSTRUMENT_ID")
    @JsonProperty("INSTRUMENT_ID")
    private String instrumentId;

    @ApiModelProperty(value = "检验日期及时间")
    @TableField("RESULT_DATE_TIME")
    @JsonProperty("RESULT_DATE_TIME")
    private Date resultDateTime;

    @ApiModelProperty(value = "打印内容")
    @TableField("PRINT_CONTEXT")
    @JsonProperty("PRINT_CONTEXT")
    private String printContext;

    @ApiModelProperty(value = "结果范围")
    @TableField("RESULT_RANGE")
    @JsonProperty("RESULT_RANGE")
    private String resultRange;

    @ApiModelProperty(value = "样品代码")
    @TableField("SAMPLE_CODE")
    @JsonProperty("SAMPLE_CODE")
    private String sampleCode;

    @ApiModelProperty(value = "样品器皿ID")
    @TableField("SPECIMAN_ID")
    @JsonProperty("SPECIMAN_ID")
    private String specimanId;

    @ApiModelProperty(value = "新加的诊疗代码")
    @TableField("ITEM_CODE")
    @JsonProperty("ITEM_CODE")
    private String itemCode;

    @ApiModelProperty(value = "新加字段诊疗项目名称")
    @TableField("ITEM_NAME")
    @JsonProperty("ITEM_NAME")
    private String itemName;

    @ApiModelProperty(value = "检验危机值")
    @TableField("CRITICAL_VALUES")
    @JsonProperty("CRITICAL_VALUES")
    private String criticalValues;

    @ApiModelProperty(value = "护士确认危急值时间")
    @TableField("SURE_DATE_TIME")
    @JsonProperty("SURE_DATE_TIME")
    private Date sureDateTime;

    @ApiModelProperty(value = "护士确认人")
    @TableField("SURE_NURSE")
    @JsonProperty("SURE_NURSE")
    private String sureNurse;

    @ApiModelProperty(value = "医生确认危急值时间")
    @TableField("SURE_DATE_TIME1")
    @JsonProperty("SURE_DATE_TIME1")
    private Date sureDateTime1;

    @ApiModelProperty(value = "医生确认人")
    @TableField("SURE_DOCTOR")
    @JsonProperty("SURE_DOCTOR")
    private String sureDoctor;

    @ApiModelProperty(value = "处理意见")
    @TableField("ADVICE")
    @JsonProperty("ADVICE")
    private String advice;

    @ApiModelProperty(value = "临床意义")
    @TableField("CLINICREF")
    @JsonProperty("CLINICREF")
    private String clinicref;


}
