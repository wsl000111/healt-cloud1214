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
 * 主检判定结果字典
 * </p>
 *
 * @author GuYue
 * @since 2022-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_JUDGEMENT_DICT")
@ApiModel(value="HcJudgementDict对象", description="主检判定结果字典")
public class HcJudgementDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "医院编码")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "判定编码")
    @TableField("JUDGEMENT_CODE")
    @JsonProperty("JUDGEMENT_CODE")
    private String judgementCode;

    @ApiModelProperty(value = "判断说明")
    @TableField("JUDGEMENT_DESC")
    @JsonProperty("JUDGEMENT_DESC")
    private String judgementDesc;

    @ApiModelProperty(value = "序号")
    @TableField("SERIAL_NO")
    @JsonProperty("SERIAL_NO")
    private Integer serialNo;

    @ApiModelProperty(value = "有效标志")
    @TableField("EFFECTIVE_FLAG")
    @JsonProperty("EFFECTIVE_FLAG")
    private String effectiveFlag;


}
