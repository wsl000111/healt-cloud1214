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
 * 检查室与项目组合对照表
 * </p>
 *
 * @author linklee
 * @since 2022-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_ROOM_VS_ASSEM")
@ApiModel(value="HcRoomVsAssem对象", description="检查室与项目组合对照表")
public class HcRoomVsAssem implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "检查室代码")
    @TableId(value = "ROOM_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("ROOM_CODE")
    private String roomCode;

    @ApiModelProperty(value = "项目组合序号")
    @TableField("ITEM_ASSEM_NO")
    @JsonProperty("ITEM_ASSEM_NO")
    private Integer itemAssemNo;

    @ApiModelProperty(value = "项目组合代码")
    @TableField("ITEM_ASSEM_CODE")
    @JsonProperty("ITEM_ASSEM_CODE")
    private String itemAssemCode;

    @ApiModelProperty(value = "机构ID")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
