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
 * 体检检查室字典
 * </p>
 *
 * @author linklee
 * @since 2022-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_ROOM_DICT")
@ApiModel(value="HcRoomDict对象", description="体检检查室字典")
public class HcRoomDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "检查房间代码")
    @TableId(value = "ROOM_CODE")
    @JsonProperty("ROOM_CODE")
    private String roomCode;

    @ApiModelProperty(value = "检查房间名称")
    @TableField("ROOM_NAME")
    @JsonProperty("ROOM_NAME")
    private String roomName;

    @ApiModelProperty(value = "体检科室代码")
    @TableField("HC_DEPT_CODE")
    @JsonProperty("HC_DEPT_CODE")
    private String hcDeptCode;

    @ApiModelProperty(value = "检查状态 0－正常；1－停用；2－挂起")
    @TableField("ROOM_STATUS")
    @JsonProperty("ROOM_STATUS")
    private Integer roomStatus;

    @ApiModelProperty(value = "房间别名")
    @TableField("SIMPLE_NAME")
    @JsonProperty("SIMPLE_NAME")
    private String simpleName;

    @ApiModelProperty(value = "计算机名")
    @TableField("COMPUTER_NAME")
    @JsonProperty("COMPUTER_NAME")
    private String computerName;

    @ApiModelProperty(value = "计算机地址")
    @TableField("COMPUTER_ADDR")
    @JsonProperty("COMPUTER_ADDR")
    private String computerAddr;

    @ApiModelProperty(value = "分诊台")
    @TableField("COUNSEL_NO")
    @JsonProperty("COUNSEL_NO")
    private String counselNo;

    @ApiModelProperty(value = "小屏名称")
    @TableField("SCREEN_NAME")
    @JsonProperty("SCREEN_NAME")
    private String screenName;

    @ApiModelProperty(value = "小屏IP地址")
    @TableField("SCREEN_ADDR")
    @JsonProperty("SCREEN_ADDR")
    private String screenAddr;

    @ApiModelProperty(value = "大屏名称")
    @TableField("SCREENBIG_NAME")
    @JsonProperty("SCREENBIG_NAME")
    private String screenbigName;

    @ApiModelProperty(value = "大屏IP地址")
    @TableField("SCREENBIG_ADDR")
    @JsonProperty("SCREENBIG_ADDR")
    private String screenbigAddr;

    @ApiModelProperty(value = "房间排序")
    @TableField("ROOM_SORT")
    @JsonProperty("ROOM_SORT")
    private String roomSort;

    @ApiModelProperty(value = "上屏体检人员")
    @TableField("SPPID")
    @JsonProperty("SPPID")
    private String sppid;

    @ApiModelProperty(value = "上屏体检人员序号")
    @TableField("SPPIDXH")
    @JsonProperty("SPPIDXH")
    private String sppidxh;

    @ApiModelProperty(value = "机构编号")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "性别限制，男，女，不限")
    @TableField("ROOM_SEX")
    @JsonProperty("ROOM_SEX")
    private String roomSex;


}
