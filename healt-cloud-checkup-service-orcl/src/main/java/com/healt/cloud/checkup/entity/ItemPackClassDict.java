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
 * 项目组合类别字典
 * </p>
 *
 * @author GuYue
 * @since 2022-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ITEM_PACK_CLASS_DICT")
@ApiModel(value="ItemPackClassDict对象", description="项目组合类别字典")
public class ItemPackClassDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @ApiModelProperty(value = "类别编码")
    @TableField("CLASS_CODE")
    @JsonProperty("CLASS_CODE")
    private String classCode;

    @ApiModelProperty(value = "类别名称")
    @TableField("CLASS_NAME")
    @JsonProperty("CLASS_NAME")
    private String className;

    @ApiModelProperty(value = "备注")
    @TableField("CLASS_NOTE")
    @JsonProperty("CLASS_NOTE")
    private String classNote;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
