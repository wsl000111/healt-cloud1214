package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
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
 * @since 2022-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_DEPART_DICT")
@ApiModel(value="VDepartDict对象", description="")
public class VDepartDict implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private BigDecimal sortNo;

    @TableField("SEND_SERVER")
    @JsonProperty("SEND_SERVER")
    private String sendServer;

    @TableField("RECEIVE_SERVER")
    @JsonProperty("RECEIVE_SERVER")
    private String receiveServer;

    @TableField("REPORT_FLAG")
    @JsonProperty("REPORT_FLAG")
    private String reportFlag;

    @TableField("CLASS_NAME")
    @JsonProperty("CLASS_NAME")
    private String className;


}
