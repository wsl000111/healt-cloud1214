package com.healt.cloud.pdf.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HcPersonInfoVo implements Serializable {
    @ApiModelProperty(value = "机构编号")
    @TableId("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "人员编号")
    @TableField("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "人员名称")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    private String sex;

    @ApiModelProperty(value = "单位名称")
    @TableField("UNIT_NAME")
    private String unitName;

    @ApiModelProperty(value = "身份证号")
    @TableField("ID_NO")
    private String idNo;

    @ApiModelProperty(value = "出生日期")
    @TableField("BARTHDAY")
    private Date barthday;

    @ApiModelProperty(value = "拼音简码")
    @TableField("INPUT_CODE")
    private String inputCode;

    @ApiModelProperty(value = "婚姻状况")
    @TableField("MARITAL_STATUS")
    private String maritalStatus;

    @ApiModelProperty(value = "国家")
    @TableField("COUNTRY")
    private String country;

    @ApiModelProperty(value = "区域")
    @TableField("AREA")
    private String area;

    @ApiModelProperty(value = "密码")
    @TableField("PWD")
    private String pwd;

    @ApiModelProperty(value = "民族")
    @TableField("NATION")
    private String nation;

    @ApiModelProperty(value = "联系地址")
    @TableField("ADDRESS")
    private String address;

    @ApiModelProperty(value = "邮政编码")
    @TableField("POSTCODE")
    private String postcode;

    @ApiModelProperty(value = "联系电话")
    @TableField("PHONE_NUMBER")
    private String phoneNumber;

    @ApiModelProperty(value = "手机")
    @TableField("MOBILE")
    private String mobile;

    @ApiModelProperty(value = "电子邮箱")
    @TableField("EMAIL")
    private String email;

    @ApiModelProperty(value = "来源（app 互联网）")
    @TableField("SOURCE")
    private String source;

    @ApiModelProperty(value = "职业")
    @TableField("JOB")
    private String job;

    @ApiModelProperty(value = "检查类别")
    @TableField("EXAM_CLASS")
    private String examClass;

    @ApiModelProperty(value = "级别")
    @TableField("PERSON_LEVEL")
    private String personLevel;

    @ApiModelProperty(value = "部门")
    @TableField("DEPARTMENT")
    private String department;

    @ApiModelProperty(value = "费别")
    @TableField("CHARGE_TYPE")
    private String chargeType;

    @ApiModelProperty(value = "体检费别")
    @TableField("PERSON_CHARGE")
    private String personCharge;

    @ApiModelProperty(value = "身份")
    @TableField("IDENTITY")
    private String identity;

    @ApiModelProperty(value = "建档时间")
    @TableField("BUILD_DATE")
    private Date buildDate;

    @ApiModelProperty(value = "建档人")
    @TableField("USER_ID")
    private String userId;

    @ApiModelProperty(value = "建档人姓名")
    @TableField("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "备注")
    @TableField("NOTE")
    private String note;

    @ApiModelProperty(value = "加密盐,app登录时使用")
    @TableField("SALT")
    private String salt;

    @ApiModelProperty(value = "平台或HIS患者ID")
    @TableField("PATIENT_ID")
    private String patientId;

    private String code;
}
