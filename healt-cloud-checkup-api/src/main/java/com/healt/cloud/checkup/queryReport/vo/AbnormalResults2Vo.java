package com.healt.cloud.checkup.queryReport.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-30 17:22
 */
@Data
public class AbnormalResults2Vo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("rownum")
    @JsonProperty("XH")
    private String xh;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "人员编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "人员名称")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "年龄")
    @TableField("AGE")
    @JsonProperty("AGE")
    private Integer age;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "电话号码")
    @TableField("PHONE_NUMBER")
    @JsonProperty("PHONE_NUMBER")
    private String phoneNumber;

    @ApiModelProperty(value = "疾病或阳性体征的名称")
    @TableField("CONTENT")
    @JsonProperty("CONTENT")
    private String content;
}
