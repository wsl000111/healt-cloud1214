package com.healt.cloud.checkup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * 问卷信息答案维护
 * </p>
 *
 * @author linklee
 * @since 2022-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_ANSWER_DICT")
@ApiModel(value="HcAnswerDict对象", description="问卷信息答案维护")
public class HcAnswerDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "问卷代码")
    @TableId(value = "INVEST_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("INVEST_CODE")
    private String investCode;

    @ApiModelProperty(value = "问题编号")
    @TableField("QUESTION_CODE")
    @JsonProperty("QUESTION_CODE")
    private String questionCode;

    @ApiModelProperty(value = "答案选项代码")
    @TableField("ANSWER_CODE")
    @JsonProperty("ANSWER_CODE")
    private String answerCode;

    @ApiModelProperty(value = "答案选项内容")
    @TableField("ANSWER_NAME")
    @JsonProperty("ANSWER_NAME")
    private String answerName;

    @ApiModelProperty(value = "有效否 当前有效1 当前无效0")
    @TableField("EFFECTIVE")
    @JsonProperty("EFFECTIVE")
    private String effective;

    @ApiModelProperty(value = "答案结果类型 数字1 字符串2 日期3")
    @TableField("ANSWER_RESULT_TYPE")
    @JsonProperty("ANSWER_RESULT_TYPE")
    private String answerResultType;

    @ApiModelProperty(value = "答案结果单位")
    @TableField("ANSWER_RESULT_UNIT")
    @JsonProperty("ANSWER_RESULT_UNIT")
    private String answerResultUnit;

    @ApiModelProperty(value = "机构ID")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "答案类型 输入型1 选择型2")
    @TableField("ANSWER_TYPE")
    @JsonProperty("ANSWER_TYPE")
    private String answerType;


}
