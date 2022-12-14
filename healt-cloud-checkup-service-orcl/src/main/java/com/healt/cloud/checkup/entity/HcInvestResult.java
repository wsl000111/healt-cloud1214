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
 * 体检人员问卷结果表
 * </p>
 *
 * @author linklee
 * @since 2022-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_INVEST_RESULT")
@ApiModel(value="HcInvestResult对象", description="体检人员问卷结果表")
public class HcInvestResult implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "问卷主键 问卷id 与HC_INVEST_MASTER_INDEX 主索引 关联")
    @TableId(value = "INVEST_ID")
    @JsonProperty("INVEST_ID")
    private String investId;

    @ApiModelProperty(value = "问卷代码 与健康问卷信息维护模版 HC_QUESTION_DICT 关联")
    @TableField("INVEST_CODE")
    @JsonProperty("INVEST_CODE")
    private String investCode;

    @ApiModelProperty(value = "问卷名称")
    @TableField("INVEST_NAME")
    @JsonProperty("INVEST_NAME")
    private String investName;

    @ApiModelProperty(value = "问题编号")
    @TableField("QUESTION_CODE")
    @JsonProperty("QUESTION_CODE")
    private String questionCode;

    @ApiModelProperty(value = "问题内容")
    @TableField("QUESTION_NAME")
    @JsonProperty("QUESTION_NAME")
    private String questionName;

    @ApiModelProperty(value = "答案代码 HC_ANSWER_DICT 中的答案代码")
    @TableField("ANSWER_CODE")
    @JsonProperty("ANSWER_CODE")
    private String answerCode;

    @ApiModelProperty(value = "答案名称 HC_ANSWER_DICT 中的答案名称")
    @TableField("ANSWER_NAME")
    @JsonProperty("ANSWER_NAME")
    private String answerName;

    @ApiModelProperty(value = "类型 输入型1 单选2 多选3 复合型4")
    @TableField("QUESTION_TYPE")
    @JsonProperty("QUESTION_TYPE")
    private String questionType;

    @ApiModelProperty(value = "输入结果类型 数字1 字符串2 日期3")
    @TableField("RESULT_TYPE")
    @JsonProperty("RESULT_TYPE")
    private String resultType;

    @ApiModelProperty(value = "字符串结果")
    @TableField("RESULT_STRING")
    @JsonProperty("RESULT_STRING")
    private String resultString;

    @ApiModelProperty(value = "数字结果")
    @TableField("RESULT_DECIMAL")
    @JsonProperty("RESULT_DECIMAL")
    private BigDecimal resultDecimal;

    @ApiModelProperty(value = "结果时间")
    @TableField("RESULT_DATE")
    @JsonProperty("RESULT_DATE")
    private Date resultDate;

    @ApiModelProperty(value = "输入结果单位")
    @TableField("RESULT_UNIT")
    @JsonProperty("RESULT_UNIT")
    private String resultUnit;

    @ApiModelProperty(value = "机构ID")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
