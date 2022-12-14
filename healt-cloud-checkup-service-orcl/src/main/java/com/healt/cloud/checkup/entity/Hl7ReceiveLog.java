package com.healt.cloud.checkup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
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
 * @since 2022-08-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HL7_RECEIVE_LOG")
@ApiModel(value="Hl7ReceiveLog对象", description="")
public class Hl7ReceiveLog implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "日志插入日期")
    @TableField("INSERT_DATE")
    @JsonProperty("INSERT_DATE")
    private Date insertDate;

    @ApiModelProperty(value = "hl7参数值")
    @TableField("HL7_DATA")
    @JsonProperty("HL7_DATA")
    private String hl7Data;

    @ApiModelProperty(value = "接收/响应")
    @TableField("DATA_TYPE")
    @JsonProperty("DATA_TYPE")
    private String dataType;

    @ApiModelProperty(value = "调用的方法说明")
    @TableField("METHOD")
    @JsonProperty("METHOD")
    private String method;

    @ApiModelProperty(value = "同一组入参出参uuid相同")
    @TableField("UUID")
    @JsonProperty("UUID")
    private String uuid;

    @ApiModelProperty(value = "his编号")
    @TableField("PATIENT_ID")
    @JsonProperty("PATIENT_ID")
    private String patientId;

    @ApiModelProperty(value = "体检编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("VISIT_ID")
    @JsonProperty("VISIT_ID")
    private String visitId;

    @ApiModelProperty(value = "请求单号")
    @TableField("APPLY_NO")
    @JsonProperty("APPLY_NO")
    private String applyNo;

    @ApiModelProperty(value = "引导介质编码")
    @TableField("CODE")
    @JsonProperty("CODE")
    private String code;

    @ApiModelProperty(value = "引导介质类型")
    @TableField("TYPE")
    @JsonProperty("TYPE")
    private String type;

    @ApiModelProperty(value = "患者姓名")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "执行科室名称")
    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;


}
