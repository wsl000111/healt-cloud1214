package com.healt.cloud.checkup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.sql.Blob;
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
 * 
 * </p>
 *
 * @author GuYue
 * @since 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_USERS_DICT")
@ApiModel(value="VUsersDict对象", description="")
public class VUsersDict implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("USER_ID")
    @JsonProperty("USER_ID")
    private String userId;

    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @TableField("PWD")
    @JsonProperty("PWD")
    private String pwd;

    @TableField("BARTHDAY")
    @JsonProperty("BARTHDAY")
    private Date barthday;

    @TableField("TEL")
    @JsonProperty("TEL")
    private String tel;

    @TableField("ADDR")
    @JsonProperty("ADDR")
    private String addr;

    @TableField("ID_NO")
    @JsonProperty("ID_NO")
    private String idNo;

    @TableField("IS_DOCTOR")
    @JsonProperty("IS_DOCTOR")
    private String isDoctor;

    @TableField("DOCTOR_IMG")
    @JsonProperty("DOCTOR_IMG")
    private Blob doctorImg;

    @TableField("CREATE_DATE")
    @JsonProperty("CREATE_DATE")
    private Date createDate;

    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;


}
