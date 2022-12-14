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
 * 套餐模板项目
 * </p>
 *
 * @author GuYue
 * @since 2022-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_SET_VS_PACK_DICT")
@ApiModel(value="HcSetVsPackDict对象", description="套餐模板项目")
public class HcSetVsPackDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "套餐编码")
    @TableId(value = "SET_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("SET_CODE")
    private String setCode;

    @ApiModelProperty(value = "组合编码")
    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private String itemNo;

    @ApiModelProperty(value = "机构编码")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
