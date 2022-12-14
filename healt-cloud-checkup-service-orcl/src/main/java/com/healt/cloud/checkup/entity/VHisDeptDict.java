package com.healt.cloud.checkup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2022-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_HIS_DEPT_DICT")
@ApiModel(value="VHisDeptDict对象", description="")
public class VHisDeptDict implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("SERIAL_NO")
    @JsonProperty("SERIAL_NO")
    private Integer serialNo;

    @TableField("DEPT_CODE")
    @JsonProperty("DEPT_CODE")
    private String deptCode;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @TableField("CLINIC_ATTR")
    @JsonProperty("CLINIC_ATTR")
    private Integer clinicAttr;

    @TableField("OUTP_OR_INP")
    @JsonProperty("OUTP_OR_INP")
    private Integer outpOrInp;

    @TableField("POSITION")
    @JsonProperty("POSITION")
    private String position;


}
