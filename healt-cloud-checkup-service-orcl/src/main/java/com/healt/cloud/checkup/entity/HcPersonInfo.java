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
 * 人员信息表
 * </p>
 *
 * @author GuYue
 * @since 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_PERSON_INFO")
@ApiModel(value="HcPersonInfo对象", description="人员信息表")
public class HcPersonInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonProperty("ISAWAY")
    @TableField(exist = false)
    private String isaway = "0";

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "人员编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "人员名称")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "单位名称")
    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

    @ApiModelProperty(value = "身份证号")
    @TableField("ID_NO")
    @JsonProperty("ID_NO")
    private String idNo;

    @ApiModelProperty(value = "出生日期")
    @TableField("BARTHDAY")
    @JsonProperty("BARTHDAY")
    private Date barthday;

    @ApiModelProperty(value = "拼音简码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @ApiModelProperty(value = "婚姻状况")
    @TableField("MARITAL_STATUS")
    @JsonProperty("MARITAL_STATUS")
    private String maritalStatus;

    @ApiModelProperty(value = "国家")
    @TableField("COUNTRY")
    @JsonProperty("COUNTRY")
    private String country;

    @ApiModelProperty(value = "区域")
    @TableField("AREA")
    @JsonProperty("AREA")
    private String area;

    @ApiModelProperty(value = "密码")
    @TableField("PWD")
    @JsonProperty("PWD")
    private String pwd;

    @ApiModelProperty(value = "民族")
    @TableField("NATION")
    @JsonProperty("NATION")
    private String nation;

    @ApiModelProperty(value = "联系地址")
    @TableField("ADDRESS")
    @JsonProperty("ADDRESS")
    private String address;

    @ApiModelProperty(value = "邮政编码")
    @TableField("POSTCODE")
    @JsonProperty("POSTCODE")
    private String postcode;

    @ApiModelProperty(value = "联系电话")
    @TableField("PHONE_NUMBER")
    @JsonProperty("PHONE_NUMBER")
    private String phoneNumber;

    @ApiModelProperty(value = "手机")
    @TableField("MOBILE")
    @JsonProperty("MOBILE")
    private String mobile;

    @ApiModelProperty(value = "电子邮箱")
    @TableField("EMAIL")
    @JsonProperty("EMAIL")
    private String email;

    @ApiModelProperty(value = "来源（app 互联网）")
    @TableField("SOURCE")
    @JsonProperty("SOURCE")
    private String source;

    @ApiModelProperty(value = "职业")
    @TableField("JOB")
    @JsonProperty("JOB")
    private String job;

    @ApiModelProperty(value = "检查类别")
    @TableField("EXAM_CLASS")
    @JsonProperty("EXAM_CLASS")
    private String examClass;

    @ApiModelProperty(value = "级别")
    @TableField("PERSON_LEVEL")
    @JsonProperty("PERSON_LEVEL")
    private String personLevel;

    @ApiModelProperty(value = "部门")
    @TableField("DEPARTMENT")
    @JsonProperty("DEPARTMENT")
    private String department;

    @ApiModelProperty(value = "费别")
    @TableField("CHARGE_TYPE")
    @JsonProperty("CHARGE_TYPE")
    private String chargeType;

    @ApiModelProperty(value = "体检费别")
    @TableField("PERSON_CHARGE")
    @JsonProperty("PERSON_CHARGE")
    private String personCharge;

    @ApiModelProperty(value = "身份")
    @TableField("IDENTITY")
    @JsonProperty("IDENTITY")
    private String identity;

    @ApiModelProperty(value = "建档时间")
    @TableField("BUILD_DATE")
    @JsonProperty("BUILD_DATE")
    private Date buildDate;

    @ApiModelProperty(value = "建档人")
    @TableField("USER_ID")
    @JsonProperty("USER_ID")
    private String userId;

    @ApiModelProperty(value = "建档人姓名")
    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "备注")
    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;

    @ApiModelProperty(value = "加密盐,app登录时使用")
    @TableField("SALT")
    @JsonProperty("SALT")
    private String salt;

    @ApiModelProperty(value = "平台或HIS患者ID")
    @TableField("PATIENT_ID")
    @JsonProperty("PATIENT_ID")
    private String patientId;


}
