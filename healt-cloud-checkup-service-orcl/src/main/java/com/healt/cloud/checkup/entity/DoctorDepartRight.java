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
 * 医生分科权限
 * </p>
 *
 * @author linklee
 * @since 2022-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DOCTOR_DEPART_RIGHT")
@ApiModel(value="DoctorDepartRight对象", description="医生分科权限")
public class DoctorDepartRight implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "用户编码")
    @TableField("USER_ID")
    @JsonProperty("USER_ID")
    private String userId;

    @ApiModelProperty(value = "科室编号")
    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @ApiModelProperty(value = "备注")
    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;


}
