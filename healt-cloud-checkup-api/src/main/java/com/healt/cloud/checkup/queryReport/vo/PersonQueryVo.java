package com.healt.cloud.checkup.queryReport.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-05-26 10:34
 */
@Data
public class PersonQueryVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "人员编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "单位名称")
    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

    @ApiModelProperty(value = "人员名称")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "民族")
    @TableField("NATION")
    @JsonProperty("NATION")
    private String nation;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "身份证号")
    @TableField("ID_NO")
    @JsonProperty("ID_NO")
    private String idNo;

    @ApiModelProperty(value = "出生日期")
    @TableField("BARTHDAY")
    @JsonProperty("BARTHDAY")
    private Date barthday;

    @ApiModelProperty(value = "婚姻状况")
    @TableField("MARITAL_STATUS")
    @JsonProperty("MARITAL_STATUS")
    private String maritalStatus;

    @ApiModelProperty(value = "分组编号")
    @TableField("GROUP_ID")
    @JsonProperty("GROUP_ID")
    private String groupId;

    @ApiModelProperty(value = "年龄")
    @TableField("AGE")
    @JsonProperty("AGE")
    private Integer age;

    @ApiModelProperty(value = "级别")
    @TableField("PERSON_LEVEL")
    @JsonProperty("PERSON_LEVEL")
    private String personLevel;

    @ApiModelProperty(value = "联系电话")
    @TableField("PHONE_NUMBER")
    @JsonProperty("PHONE_NUMBER")
    private String phoneNumber;

    @ApiModelProperty(value = "联系地址")
    @TableField("ADDRESS")
    @JsonProperty("ADDRESS")
    private String address;

}
