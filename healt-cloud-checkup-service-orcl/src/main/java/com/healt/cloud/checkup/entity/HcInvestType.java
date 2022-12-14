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
 * 健康问卷名称字典
 * </p>
 *
 * @author linklee
 * @since 2022-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_INVEST_TYPE")
@ApiModel(value="HcInvestType对象", description="健康问卷名称字典")
public class HcInvestType implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "问卷代码")
    @TableId(value = "INVEST_CODE")
    @JsonProperty("INVEST_CODE")
    private String investCode;

    @ApiModelProperty(value = "问卷名称")
    @TableField("INVEST_NAME")
    @JsonProperty("INVEST_NAME")
    private String investName;

    @ApiModelProperty(value = "序号")
    @TableField("INVEST_SORT")
    @JsonProperty("INVEST_SORT")
    private Integer investSort;

    @ApiModelProperty(value = "有效否 有效1 无效0")
    @TableField("EFFECTIVE")
    @JsonProperty("EFFECTIVE")
    private String effective;

    @ApiModelProperty(value = "健康问卷0  中医问卷2")
    @TableField("INVEST_TYPE")
    @JsonProperty("INVEST_TYPE")
    private String investType;

    @ApiModelProperty(value = "备注")
    @TableField("NOTE")
    @JsonProperty("NOTE")
    private String note;

    @ApiModelProperty(value = "机构ID")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;


}
