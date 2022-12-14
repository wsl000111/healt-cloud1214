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
 * 主检生活指导字典
 * </p>
 *
 * @author GuYue
 * @since 2022-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_CHIEF_GUIDE_DICT")
@ApiModel(value="HcChiefGuideDict对象", description="主检生活指导字典")
public class HcChiefGuideDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "生活指导分类")
    @TableField("GUIDE_CLASS")
    @JsonProperty("GUIDE_CLASS")
    private String guideClass;

    @ApiModelProperty(value = "生活指导内容")
    @TableId(value = "GUIDE_CONTENT", type = IdType.ASSIGN_ID)
    @JsonProperty("GUIDE_CONTENT")
    private String guideContent;

    @ApiModelProperty(value = "序号")
    @TableField("SERIAL_NO")
    @JsonProperty("SERIAL_NO")
    private Integer serialNo;


}
