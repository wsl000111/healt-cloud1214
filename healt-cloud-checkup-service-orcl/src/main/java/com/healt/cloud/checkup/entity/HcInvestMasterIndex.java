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
 * 问卷调查主索引
 * </p>
 *
 * @author linklee
 * @since 2022-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_INVEST_MASTER_INDEX")
@ApiModel(value="HcInvestMasterIndex对象", description="问卷调查主索引")
public class HcInvestMasterIndex implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "问卷主键 问卷id")
    @TableId(value = "INVEST_ID")
    @JsonProperty("INVEST_ID")
    private String investId;

    @ApiModelProperty(value = "问卷属性 生活1 中医2")
    @TableField("INVEST_TYPE")
    @JsonProperty("INVEST_TYPE")
    private String investType;

    @ApiModelProperty(value = "体检号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "结果状态 1是初始状态 2是审核")
    @TableField("RESULT_STATUS")
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

    @ApiModelProperty(value = "结果日期")
    @TableField("RESULT_DATE")
    @JsonProperty("RESULT_DATE")
    private Date resultDate;

    @ApiModelProperty(value = "问卷信息")
    @TableField("RESULT_DETAIL")
    @JsonProperty("RESULT_DETAIL")
    private String resultDetail;

    @ApiModelProperty(value = "操作人员")
    @TableField("OPERATOR")
    @JsonProperty("OPERATOR")
    private String operator;

    @ApiModelProperty(value = "操作人员姓名")
    @TableField("OPERATOR_NAME")
    @JsonProperty("OPERATOR_NAME")
    private String operatorName;

    @ApiModelProperty(value = "先预留,报告是否显示问卷信息")
    @TableField("CHIEF_SHOW")
    @JsonProperty("CHIEF_SHOW")
    private String chiefShow;

    @ApiModelProperty(value = "机构编号")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
