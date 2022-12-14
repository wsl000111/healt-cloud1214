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
 * 检查报告
 * </p>
 *
 * @author GuYue
 * @since 2022-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_EXAM_REPORT")
@ApiModel(value="HcExamReport对象", description="检查报告")
public class HcExamReport implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "申请序号")
    @TableId(value = "EXAM_NO", type = IdType.ASSIGN_ID)
    @JsonProperty("EXAM_NO")
    private String examNo;

    @ApiModelProperty(value = "检查参数")
    @TableField("EXAM_PARA")
    @JsonProperty("EXAM_PARA")
    private String examPara;

    @ApiModelProperty(value = "检查所见")
    @TableField("DESCRIPTION")
    @JsonProperty("DESCRIPTION")
    private String description;

    @ApiModelProperty(value = "印象")
    @TableField("IMPRESSION")
    @JsonProperty("IMPRESSION")
    private String impression;

    @ApiModelProperty(value = "建议")
    @TableField("RECOMMENDATION")
    @JsonProperty("RECOMMENDATION")
    private String recommendation;

    @ApiModelProperty(value = "是否阳性")
    @TableField("IS_ABNORMAL")
    @JsonProperty("IS_ABNORMAL")
    private String isAbnormal;

    @ApiModelProperty(value = "报告中图象编号")
    @TableField("USE_IMAGE")
    @JsonProperty("USE_IMAGE")
    private String useImage;

    @ApiModelProperty(value = "备注")
    @TableField("MEMO")
    @JsonProperty("MEMO")
    private String memo;

    @ApiModelProperty(value = "打印标志")
    @TableField("PRINT_FLAG")
    @JsonProperty("PRINT_FLAG")
    private Integer printFlag;

    @ApiModelProperty(value = "ie地址")
    @TableField("IE_ID")
    @JsonProperty("IE_ID")
    private String ieId;

    @ApiModelProperty(value = "报告写入日期")
    @TableField("INSERT_DATE")
    @JsonProperty("INSERT_DATE")
    private Date insertDate;

    @TableField("REPORT_DATE")
    @JsonProperty("REPORT_DATE")
    private Date reportDate;

    @TableField("DIAGNOSE")
    @JsonProperty("DIAGNOSE")
    private String diagnose;

    @ApiModelProperty(value = "报告危急值")
    @TableField("CRITICAL_VALUES")
    @JsonProperty("CRITICAL_VALUES")
    private String criticalValues;

    @TableField("HIS_UNIT_CODE")
    @JsonProperty("HIS_UNIT_CODE")
    private String hisUnitCode;

    @ApiModelProperty(value = "为了使用旧pacs加的")
    @TableField("REPORT_DATE_TIME")
    @JsonProperty("REPORT_DATE_TIME")
    private Date reportDateTime;

    @ApiModelProperty(value = "为了使用旧pacs加的")
    @TableField("REPORT_DATE_TIME_BACK")
    @JsonProperty("REPORT_DATE_TIME_BACK")
    private String reportDateTimeBack;

    @ApiModelProperty(value = "为了使用旧pacs加的")
    @TableField("REPORTER")
    @JsonProperty("REPORTER")
    private String reporter;

    @ApiModelProperty(value = "为了使用旧pacs加的")
    @TableField("YS_NAME")
    @JsonProperty("YS_NAME")
    private String ysName;


}
