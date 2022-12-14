package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
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
 * 科室定义
 * </p>
 *
 * @author GuYue
 * @since 2022-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DEPART_DICT")
@ApiModel(value="DepartDict对象", description="科室定义")
public class DepartDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "科室编号")
    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "科室类别编号")
    @TableField("CLASS_ID")
    @JsonProperty("CLASS_ID")
    private String classId;

    @ApiModelProperty(value = "科室名称")
    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "拼音简码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @ApiModelProperty(value = "排序号码")
    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private BigDecimal sortNo;

    @ApiModelProperty(value = "发送到数据库")
    @TableField("SEND_SERVER")
    @JsonProperty("SEND_SERVER")
    private String sendServer;

    @ApiModelProperty(value = "接收数据库")
    @TableField("RECEIVE_SERVER")
    @JsonProperty("RECEIVE_SERVER")
    private String receiveServer;

    @ApiModelProperty(value = "报告是否体现")
    @TableField("REPORT_FLAG")
    @JsonProperty("REPORT_FLAG")
    private String reportFlag;

    @ApiModelProperty(value = "备注")
    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;


}
