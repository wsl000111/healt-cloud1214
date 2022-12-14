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
 * 换项日志表
 * </p>
 *
 * @author linklee
 * @since 2022-05-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_CHANGEITEM_LOG")
@ApiModel(value="HcChangeitemLog对象", description="换项日志表")
public class HcChangeitemLog implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "被兑换项目编码")
    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "兑换项目编码(多个项目时用|分割)")
    @TableField("CHANGE_ITEM_CODE")
    @JsonProperty("CHANGE_ITEM_CODE")
    private String changeItemCode;

    @ApiModelProperty(value = "被兑换项目名称")
    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @ApiModelProperty(value = "兑换项目名称(多个项目时用|分割)")
    @TableField("CHANGE_ITEM_NAME")
    @JsonProperty("CHANGE_ITEM_NAME")
    private String changeItemName;

    @ApiModelProperty(value = "产生时间")
    @TableField("OPER_DATE")
    @JsonProperty("OPER_DATE")
    private Date operDate;

    @ApiModelProperty(value = "操作人")
    @TableField("OPER_ID")
    @JsonProperty("OPER_ID")
    private String operId;

    @ApiModelProperty(value = "操作人姓名")
    @TableField("OPER_NAME")
    @JsonProperty("OPER_NAME")
    private String operName;

    @ApiModelProperty(value = "人员编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;


}
