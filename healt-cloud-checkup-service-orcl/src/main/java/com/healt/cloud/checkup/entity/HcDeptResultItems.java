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
 * 体检分科结果明细记录
 * </p>
 *
 * @author GuYue
 * @since 2022-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_DEPT_RESULT_ITEMS")
@ApiModel(value="HcDeptResultItems对象", description="体检分科结果明细记录")
public class HcDeptResultItems implements Serializable {

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

    @ApiModelProperty(value = "科室ID")
    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @ApiModelProperty(value = "科室名称")
    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "内容分类 0－科室小结 1－阳性体征 2－异常结果 3－体检建议")
    @TableField("CONTENT_CLASS")
    @JsonProperty("CONTENT_CLASS")
    private String contentClass;

    @ApiModelProperty(value = "内容")
    @TableField("CONTENT")
    @JsonProperty("CONTENT")
    private String content;

    @ApiModelProperty(value = "附加描述")
    @TableField("DESCRIPTION")
    @JsonProperty("DESCRIPTION")
    private String description;

    @ApiModelProperty(value = "排序序号")
    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @ApiModelProperty(value = "组合编码")
    @TableField("ITEM_ASSEM_CODE")
    @JsonProperty("ITEM_ASSEM_CODE")
    private String itemAssemCode;

    @ApiModelProperty(value = "分科报告中 是否出现在分科体检报告中： 0－不出现 1－出现")
    @TableField("IN_DEPT_REPORT")
    @JsonProperty("IN_DEPT_REPORT")
    private String inDeptReport;

    @ApiModelProperty(value = "是否体现给主检医生： 0－不体现 1－体现")
    @TableField("IN_CHIEF_REPORT")
    @JsonProperty("IN_CHIEF_REPORT")
    private String inChiefReport;

    @ApiModelProperty(value = "对应指导建议")
    @TableField("GUIDE_CONTENT")
    @JsonProperty("GUIDE_CONTENT")
    private String guideContent;

    @ApiModelProperty(value = "小项编码")
    @TableField("HC_ITEM_CODE")
    @JsonProperty("HC_ITEM_CODE")
    private String hcItemCode;

    @ApiModelProperty(value = "模板编号")
    @TableField("KNOWLEDGE_CODE")
    @JsonProperty("KNOWLEDGE_CODE")
    private String knowledgeCode;


}
