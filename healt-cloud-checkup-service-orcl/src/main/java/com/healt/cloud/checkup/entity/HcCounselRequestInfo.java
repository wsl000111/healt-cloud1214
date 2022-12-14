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
 * 体检分诊语音呼叫信息表
 * </p>
 *
 * @author linklee
 * @since 2022-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_COUNSEL_REQUEST_INFO")
@ApiModel(value="HcCounselRequestInfo对象", description="体检分诊语音呼叫信息表")
public class HcCounselRequestInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    @TableId(value = "SERIAL_NO")
    @JsonProperty("SERIAL_NO")
    private Integer serialNo;

    @ApiModelProperty(value = "分诊台编号")
    @TableField("COUNSEL_NO")
    @JsonProperty("COUNSEL_NO")
    private String counselNo;

    @ApiModelProperty(value = "信息类型")
    @TableField("REQUEST_TYPE")
    @JsonProperty("REQUEST_TYPE")
    private Integer requestType;

    @ApiModelProperty(value = "呼叫内容")
    @TableField("REQUEST_BODY")
    @JsonProperty("REQUEST_BODY")
    private String requestBody;

    @ApiModelProperty(value = "呼叫事件")
    @TableField("REQUEST_TIME")
    @JsonProperty("REQUEST_TIME")
    private Date requestTime;

    @ApiModelProperty(value = "医生编码")
    @TableField("DOCTOR_NO")
    @JsonProperty("DOCTOR_NO")
    private String doctorNo;

    @ApiModelProperty(value = "消息去向(1,分诊台发给医生站,2,医生站发给分诊台)")
    @TableField("MESSAGE_DIRECTION")
    @JsonProperty("MESSAGE_DIRECTION")
    private Integer messageDirection;

    @ApiModelProperty(value = "流水号对应的序列")
    @TableField("QUEUE_SEQ")
    @JsonProperty("QUEUE_SEQ")
    private Integer queueSeq;

    @ApiModelProperty(value = "体检ID")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "姓名")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "日期")
    @TableField("QUEUE_DATE")
    @JsonProperty("QUEUE_DATE")
    private Date queueDate;

    @ApiModelProperty(value = "体检排队的唯一号")
    @TableField("QUEUE_NO")
    @JsonProperty("QUEUE_NO")
    private String queueNo;

    @ApiModelProperty(value = "诊室名称")
    @TableField("ROOM_NAME")
    @JsonProperty("ROOM_NAME")
    private String roomName;

    @ApiModelProperty(value = "诊室代码")
    @TableField("ROOM_CODE")
    @JsonProperty("ROOM_CODE")
    private String roomCode;

    @ApiModelProperty(value = "机构ID")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
