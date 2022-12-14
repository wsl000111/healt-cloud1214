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
 * 组合项目指引单分组字典
 * </p>
 *
 * @author GuYue
 * @since 2022-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ITEM_PACK_GUIDEGROUP_DICT")
@ApiModel(value="ItemPackGuidegroupDict对象", description="组合项目指引单分组字典")
public class ItemPackGuidegroupDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @ApiModelProperty(value = "分组编码")
    @TableField("GUIDEGROUP_CODE")
    @JsonProperty("GUIDEGROUP_CODE")
    private String guidegroupCode;

    @ApiModelProperty(value = "分组名称")
    @TableField("GUIDEGROUP_NAME")
    @JsonProperty("GUIDEGROUP_NAME")
    private String guidegroupName;

    @ApiModelProperty(value = "备注")
    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
