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
 * 本表记录体检人员报到的顺序号，唯一对应一个体检人员。
 * </p>
 *
 * @author linklee
 * @since 2022-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_QUEUE_NO")
@ApiModel(value="HcQueueNo对象", description="本表记录体检人员报到的顺序号，唯一对应一个体检人员。")
public class HcQueueNo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "非空，用于体检排队的唯一号")
    @TableId(value = "QUEUE_NO")
    @JsonProperty("QUEUE_NO")
    private Integer queueNo;

    @ApiModelProperty(value = "非空人员ID")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "非空体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "姓名")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "0－普通；1－VIP；2－特别")
    @TableField("QUEUE_LEVEL")
    @JsonProperty("QUEUE_LEVEL")
    private String queueLevel;

    @ApiModelProperty(value = "流水号对应日期")
    @TableField("QUEUE_DATE")
    @JsonProperty("QUEUE_DATE")
    private Date queueDate;

    @ApiModelProperty(value = "体检科室")
    @TableField("HC_DEPT_CODE")
    @JsonProperty("HC_DEPT_CODE")
    private String hcDeptCode;

    @ApiModelProperty(value = "0－未进入导检 1－导检中 2－暂脱离导检 3－已完成导检")
    @TableField("HC_QUEUE_CODE")
    @JsonProperty("HC_QUEUE_CODE")
    private String hcQueueCode;

    @ApiModelProperty(value = "流水号对应的序列")
    @TableField("HC_SEQ")
    @JsonProperty("HC_SEQ")
    private Long hcSeq;

    @ApiModelProperty(value = "检查室")
    @TableField("ROOM_CODE")
    @JsonProperty("ROOM_CODE")
    private String roomCode;

    @ApiModelProperty(value = "机构ID")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
