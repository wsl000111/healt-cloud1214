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
 * 健康问卷信息维护
 * </p>
 *
 * @author linklee
 * @since 2022-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_QUESTION_DICT")
@ApiModel(value="HcQuestionDict对象", description="健康问卷信息维护")
public class HcQuestionDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "问卷代码")
    @TableId(value = "INVEST_CODE")
    @JsonProperty("INVEST_CODE")
    private String investCode;

    @ApiModelProperty(value = "问题编号")
    @TableField("QUESTION_CODE")
    @JsonProperty("QUESTION_CODE")
    private String questionCode;

    @ApiModelProperty(value = "问题内容")
    @TableField("QUESTION_NAME")
    @JsonProperty("QUESTION_NAME")
    private String questionName;

    @ApiModelProperty(value = "排序")
    @TableField("QUESTION_SORT")
    @JsonProperty("QUESTION_SORT")
    private Integer questionSort;

    @ApiModelProperty(value = "有效否  当前有效1 当前无效0")
    @TableField("EFFECTIVE")
    @JsonProperty("EFFECTIVE")
    private String effective;

    @ApiModelProperty(value = "类型 输入型1 单选2 多选3 复合型4 ")
    @TableField("QUESTION_TYPE")
    @JsonProperty("QUESTION_TYPE")
    private String questionType;

    @ApiModelProperty(value = "是否必填 必须填写  1/不是必须  0/")
    @TableField("MUST_INPUT")
    @JsonProperty("MUST_INPUT")
    private String mustInput;

    @ApiModelProperty(value = "输入结果类型 数字1 字符串2 日期3")
    @TableField("RESULT_TYPE")
    @JsonProperty("RESULT_TYPE")
    private String resultType;

    @ApiModelProperty(value = "结果单位")
    @TableField("RESULT_UNIT")
    @JsonProperty("RESULT_UNIT")
    private String resultUnit;

    @ApiModelProperty(value = "机构ID")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
