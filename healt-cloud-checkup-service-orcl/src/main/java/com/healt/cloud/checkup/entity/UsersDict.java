package com.healt.cloud.checkup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
//import com.fasterxml.jackson.annotation.JsonInclude;//不返回null值字段
import com.fasterxml.jackson.annotation.JsonProperty;//前端传值有下划线
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 系统用户信息
 * </p>
 *
 * @author GuYue
 * @since 2022-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("USERS_DICT")
@ApiModel(value="UsersDict对象", description="系统用户信息")
public class UsersDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户编码")
    @TableId(value = "USER_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("USER_ID")
    private String userId;

    @ApiModelProperty(value = "科室编号")
    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @ApiModelProperty(value = "机构编号")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "科室名称")
    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "用户名称")
    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "拼音简码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "密码")
    @TableField("PWD")
    @JsonProperty("PWD")
    private String pwd;

    @ApiModelProperty(value = "出生日期")
    @TableField("BARTHDAY")
    @JsonProperty("BARTHDAY")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date barthday;

    @ApiModelProperty(value = "联系电话")
    @TableField("TEL")
    @JsonProperty("TEL")
    private String tel;

    @ApiModelProperty(value = "联系地址")
    @TableField("ADDR")
    @JsonProperty("ADDR")
    private String addr;

    @ApiModelProperty(value = "身份证号")
    @TableField("ID_NO")
    @JsonProperty("ID_NO")
    private String idNo;

    @ApiModelProperty(value = "是否医生")
    @TableField("IS_DOCTOR")
    @JsonProperty("IS_DOCTOR")
    private String isDoctor;

    @ApiModelProperty(value = "签名图片")
    @TableField("DOCTOR_IMG")
    @JsonProperty("DOCTOR_IMG")
    private byte[] doctorImg;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_DATE")
    @JsonProperty("CREATE_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @ApiModelProperty(value = "备注")
    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;


}
