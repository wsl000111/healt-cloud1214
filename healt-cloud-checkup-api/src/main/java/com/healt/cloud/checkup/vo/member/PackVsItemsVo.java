package com.healt.cloud.checkup.vo.member;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author linklee
 * @create 2022-05-23 15:06
 */
@Data
public class PackVsItemsVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "组合")
    @TableId(value = "ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "项目")
    @TableField("ITEM_CODE")
    @JsonProperty("ITEM_CODE")
    private String itemCode;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @TableField("ITEM_NAME")
    @JsonProperty("ITEM_NAME")
    private String itemName;

    @TableField("HC_DEPT_CODE")
    @JsonProperty("HC_DEPT_CODE")
    private String hcDeptCode;

    @TableField("INPUT_TYPE")
    @JsonProperty("INPUT_TYPE")
    private String inputType;

    @TableField("RESULT_TYPE")
    @JsonProperty("RESULT_TYPE")
    private String resultType;

    @TableField("UNIT")
    @JsonProperty("UNIT")
    private String unit;

    @TableField("TOP_LIMIT")
    @JsonProperty("TOP_LIMIT")
    private BigDecimal topLimit;

    @TableField("BOTTOM_LIMIT")
    @JsonProperty("BOTTOM_LIMIT")
    private BigDecimal bottomLimit;

    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @TableField("FMTOP_LIMIT")
    @JsonProperty("FMTOP_LIMIT")
    private BigDecimal fmtopLimit;

    @TableField("FMBOTTOM_LIMIT")
    @JsonProperty("FMBOTTOM_LIMIT")
    private BigDecimal fmbottomLimit;

    @TableField("NORMAL_VALUE")
    @JsonProperty("NORMAL_VALUE")
    private String normalValue;

}
