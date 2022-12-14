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
 * 检查室排队队列 本表记录了检查室对应的排队人员，本表只保存当天的记录
 * </p>
 *
 * @author linklee
 * @since 2022-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_ROOM_QUEUE")
@ApiModel(value="HcRoomQueue对象", description="检查室排队队列 本表记录了检查室对应的排队人员，本表只保存当天的记录")
public class HcRoomQueue implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "检查室代码")
    @TableId(value = "ROOM_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("ROOM_CODE")
    private String roomCode;

    @ApiModelProperty(value = "检查室名称")
    @TableField("ROOM_NAME")
    @JsonProperty("ROOM_NAME")
    private String roomName;

    @ApiModelProperty(value = "检查室排队序号检查室对应的排队序号，从1开始，0标识正在接受检查的人员")
    @TableField("ROOM_QUEUE_NO")
    @JsonProperty("ROOM_QUEUE_NO")
    private Integer roomQueueNo;

    @ApiModelProperty(value = "非空，见体检人员报到表")
    @TableField("QUEUE_NO")
    @JsonProperty("QUEUE_NO")
    private Integer queueNo;

    @ApiModelProperty(value = "排队状态 使用代码，取值： 0－正常；1－推后呼叫；2－呼叫挂起；")
    @TableField("QUEUE_STATUS")
    @JsonProperty("QUEUE_STATUS")
    private String queueStatus;

    @ApiModelProperty(value = "体检日期 对应的日期")
    @TableField("HC_QUEUE_DATE")
    @JsonProperty("HC_QUEUE_DATE")
    private Date hcQueueDate;

    @ApiModelProperty(value = "机构ID")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
