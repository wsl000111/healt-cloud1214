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
 * 
 * </p>
 *
 * @author GuYue
 * @since 2022-03-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_PACK_GUIDEGROUP_DICT")
@ApiModel(value="VPackGuidegroupDict对象", description="")
public class VPackGuidegroupDict implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @TableField("GUIDEGROUP_CODE")
    @JsonProperty("GUIDEGROUP_CODE")
    private String guidegroupCode;

    @TableField("GUIDEGROUP_NAME")
    @JsonProperty("GUIDEGROUP_NAME")
    private String guidegroupName;

    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;


}
