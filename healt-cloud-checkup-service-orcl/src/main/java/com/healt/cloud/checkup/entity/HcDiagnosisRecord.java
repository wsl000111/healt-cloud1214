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
 * 体检诊断记录
 * </p>
 *
 * @author linklee
 * @since 2022-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_DIAGNOSIS_RECORD")
@ApiModel(value="HcDiagnosisRecord对象", description="体检诊断记录")
public class HcDiagnosisRecord implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID")
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

    @ApiModelProperty(value = "1－疾病诊断 2－阳性发现 3职业")
    @TableField("REC_CLASS")
    @JsonProperty("REC_CLASS")
    private String recClass;

    @ApiModelProperty(value = "疾病或阳性体征的名称")
    @TableField("REC_CONTENT")
    @JsonProperty("REC_CONTENT")
    private String recContent;

    @ApiModelProperty(value = "对应指导建议")
    @TableField("GUIDE_CONTENT")
    @JsonProperty("GUIDE_CONTENT")
    private String guideContent;

    @ApiModelProperty(value = "序号")
    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @ApiModelProperty(value = "科室编号")
    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @ApiModelProperty(value = "模板编号")
    @TableField("KNOWLEDGE_CODE")
    @JsonProperty("KNOWLEDGE_CODE")
    private String knowledgeCode;


}
