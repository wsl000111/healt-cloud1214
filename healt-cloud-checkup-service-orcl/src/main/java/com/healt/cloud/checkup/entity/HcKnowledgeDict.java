package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
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
 * 知识库模板表
 * </p>
 *
 * @author GuYue
 * @since 2022-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_KNOWLEDGE_DICT")
@ApiModel(value="HcKnowledgeDict对象", description="知识库模板表")
public class HcKnowledgeDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "模板编号")
    @TableField("KNOWLEDGE_CODE")
    @JsonProperty("KNOWLEDGE_CODE")
    private String knowledgeCode;

    @ApiModelProperty(value = "模板描述")
    @TableField("KNOWLEDGE_NAME")
    @JsonProperty("KNOWLEDGE_NAME")
    private String knowledgeName;

    @ApiModelProperty(value = "通用 项目 分科 汇总")
    @TableField("KNOWLEDGE_TYPE")
    @JsonProperty("KNOWLEDGE_TYPE")
    private String knowledgeType;

    @ApiModelProperty(value = "项目编码")
    @TableField("ITEM_CODE")
    @JsonProperty("ITEM_CODE")
    private String itemCode;

    @ApiModelProperty(value = "科室编码")
    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @ApiModelProperty(value = "正常 轻度 中度 重度")
    @TableField("POSITIVE_INDICATOR")
    @JsonProperty("POSITIVE_INDICATOR")
    private String positiveIndicator;

    @ApiModelProperty(value = "指导建议")
    @TableField("GUIDE_SUGGEST")
    @JsonProperty("GUIDE_SUGGEST")
    private String guideSuggest;

    @ApiModelProperty(value = "输入代码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @ApiModelProperty(value = "疾病代码")
    @TableField("DISEASE_CODE")
    @JsonProperty("DISEASE_CODE")
    private String diseaseCode;

    @ApiModelProperty(value = "医学科普")
    @TableField("POPULAR_SCIENCE")
    @JsonProperty("POPULAR_SCIENCE")
    private String popularScience;

    @ApiModelProperty(value = "参考值下限")
    @TableField("BOTTOM_LIMIT")
    @JsonProperty("BOTTOM_LIMIT")
    private BigDecimal bottomLimit;

    @ApiModelProperty(value = "参考值上限")
    @TableField("TOP_LIMIT")
    @JsonProperty("TOP_LIMIT")
    private BigDecimal topLimit;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "年龄")
    @TableField("AGE_TOP")
    @JsonProperty("AGE_TOP")
    private BigDecimal ageTop;

    @ApiModelProperty(value = "项目结果")
    @TableField("ITEM_RESULT")
    @JsonProperty("ITEM_RESULT")
    private String itemResult;

    @ApiModelProperty(value = "组合异常 必须写入科室 按科室分类")
    @TableField("ITEM_PACK")
    @JsonProperty("ITEM_PACK")
    private String itemPack;

    @TableField("AGE_BOTTOM")
    @JsonProperty("AGE_BOTTOM")
    private BigDecimal ageBottom;

    @ApiModelProperty(value = "包含 相等 去掉空格后包含 去掉空格后相等")
    @TableField("ITEM_DETERMINE")
    @JsonProperty("ITEM_DETERMINE")
    private String itemDetermine;

    @ApiModelProperty(value = "排序号码")
    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private BigDecimal sortNo;

    @TableField("UNIT_REPORT_SHOW")
    @JsonProperty("UNIT_REPORT_SHOW")
    private String unitReportShow;

    @TableField("ITEM_NAME_FLAG")
    @JsonProperty("ITEM_NAME_FLAG")
    private String itemNameFlag;
}
