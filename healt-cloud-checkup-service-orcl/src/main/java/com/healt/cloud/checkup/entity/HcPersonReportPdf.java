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
 * 
 * </p>
 *
 * @author GuYue
 * @since 2022-09-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_PERSON_REPORT_PDF")
@ApiModel(value="HcPersonReportPdf对象", description="")
public class HcPersonReportPdf implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "人员编号")
    @TableField("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    private String personVisitId;

    @ApiModelProperty(value = "检前签到时间")
    @TableField("BEFORE_DATE")
    private Date beforeDate;

    @ApiModelProperty(value = "pdf文件路径")
    @TableField("PDF_URL")
    private String pdfUrl;


    @ApiModelProperty(value = "插入日期")
    @TableField("INSERT_DATE")
    private Date insertDate;

    @ApiModelProperty(value = "id")
    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "体检类型")
    @TableField(value = "PERSON_TYPE")
    private String personType;
}
