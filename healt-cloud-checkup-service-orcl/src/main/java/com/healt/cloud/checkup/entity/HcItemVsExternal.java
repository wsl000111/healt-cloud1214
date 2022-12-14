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
 * 项目与检验项目结果对照
 * </p>
 *
 * @author GuYue
 * @since 2022-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_ITEM_VS_EXTERNAL")
@ApiModel(value="HcItemVsExternal对象", description="项目与检验项目结果对照")
public class HcItemVsExternal implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "项目编码")
    @TableId(value = "HC_ITEM_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("HC_ITEM_CODE")
    private String hcItemCode;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "对照码")
    @TableField("EXT_CODE")
    @JsonProperty("EXT_CODE")
    private String extCode;

    @ApiModelProperty(value = "对照名称")
    @TableField("EXT_NAME")
    @JsonProperty("EXT_NAME")
    private String extName;

    @ApiModelProperty(value = "机构编码")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
