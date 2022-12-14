package com.healt.cloud.checkup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 项目组合与诊疗对照
 * </p>
 *
 * @author GuYue
 * @since 2022-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_PACK_VS_CLINIC")
@ApiModel(value="HcPackVsClinic对象", description="项目组合与诊疗对照")
public class HcPackVsClinic implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "组合编码")
    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "诊疗类别")
    @TableField("ITEM_CLASS")
    @JsonProperty("ITEM_CLASS")
    private String itemClass;

    @ApiModelProperty(value = "诊疗项目编码")
    @TableField("ITEM_CODE")
    @JsonProperty("ITEM_CODE")
    private String itemCode;

    @ApiModelProperty(value = "诊疗项目名称")
    @TableField("ITEM_NAME")
    @JsonProperty("ITEM_NAME")
    private String itemName;

    @ApiModelProperty(value = "机构编码")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
