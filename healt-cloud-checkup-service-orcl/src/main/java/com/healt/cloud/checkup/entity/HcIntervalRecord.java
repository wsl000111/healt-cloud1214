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
 * 体检时间间隔记录 本表记录了与体检人员有关的检查室以及进出检查室的时间
 * </p>
 *
 * @author linklee
 * @since 2022-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_INTERVAL_RECORD")
@ApiModel(value="HcIntervalRecord对象", description="体检时间间隔记录 本表记录了与体检人员有关的检查室以及进出检查室的时间")
public class HcIntervalRecord implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "体检人员ID")
    @TableId(value = "PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "检查室代码")
    @TableField("ROOM_CODE")
    @JsonProperty("ROOM_CODE")
    private String roomCode;

    @ApiModelProperty(value = "开始时间")
    @TableField("BEGIN_TIME")
    @JsonProperty("BEGIN_TIME")
    private Date beginTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("END_TIME")
    @JsonProperty("END_TIME")
    private Date endTime;

    @ApiModelProperty(value = "医生")
    @TableField("DOCTOR")
    @JsonProperty("DOCTOR")
    private String doctor;

    @ApiModelProperty(value = "操作员")
    @TableField("OPERATOR")
    @JsonProperty("OPERATOR")
    private String operator;

    @ApiModelProperty(value = "导检标识0－未进入检查室 1－已进入检查室 2－已离开检查室")
    @TableField("QUEUE_INDICATOR")
    @JsonProperty("QUEUE_INDICATOR")
    private String queueIndicator;

    @ApiModelProperty(value = "机构ID")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "体检人姓名")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "体检排队唯一号")
    @TableField("QUEUE_NO")
    @JsonProperty("QUEUE_NO")
    private Integer queueNo;

    @ApiModelProperty(value = "流水号对应体检日期 yyyy-MM-dd")
    @TableField("QUEUE_DATE")
    @JsonProperty("QUEUE_DATE")
    private Date queueDate;


}
