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
 * 体检疾病诊断字典
 * </p>
 *
 * @author GuYue
 * @since 2022-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_DISEASE_DICT")
@ApiModel(value="HcDiseaseDict对象", description="体检疾病诊断字典")
public class HcDiseaseDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "医院编码")
    @JsonProperty("HOSPITAL_ID")
    private String HOSPITAL_ID;

    @ApiModelProperty(value = "疾病编码")
    @JsonProperty("DISEASE_CODE")
    private String DISEASE_CODE;

    @ApiModelProperty(value = "疾病名称")
    @JsonProperty("DISEASE_NAME")
    private String DISEASE_NAME;

    @ApiModelProperty(value = "建议内容")
    @JsonProperty("SUGGEST_TEXT")
    private String SUGGEST_TEXT;

    @ApiModelProperty(value = "告知内容")
    @JsonProperty("KNOWLEDGE_TEXT")
    private String KNOWLEDGE_TEXT;

    @ApiModelProperty(value = "输入码")
    @JsonProperty("INPUT_CODE")
    private String INPUT_CODE;

    @ApiModelProperty(value = "自定义输入码")
    @JsonProperty("INPUT_CODE_CUST")
    private String INPUT_CODE_CUST;

    @ApiModelProperty(value = "诊断使用地方")
    @JsonProperty("DIAG_WHERE")
    private String DIAG_WHERE;

    @ApiModelProperty(value = "诊断程度")
    @JsonProperty("DIAG_DEGREE")
    private String DIAG_DEGREE;

    @ApiModelProperty(value = "诊断级别")
    @JsonProperty("DIAG_CLASS")
    private String DIAG_CLASS;


}
