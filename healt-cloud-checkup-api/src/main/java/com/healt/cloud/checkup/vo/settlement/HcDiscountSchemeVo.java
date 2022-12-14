package com.healt.cloud.checkup.vo.settlement;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-06 11:23
 */
@Data
public class HcDiscountSchemeVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    @ApiModelProperty(value = "打折方案名")
    @TableField("SCHEME_NAME")
    @JsonProperty("SCHEME_NAME")
    private String schemeName;

    @ApiModelProperty(value = "打折方案编码")
    @TableField("SCHEME_CODE")
    @JsonProperty("SCHEME_CODE")
    private String schemeCode;

    @ApiModelProperty(value = "是否有效 1有效 0无效")
    @TableField("EFFECTIVE_FLAG")
    @JsonProperty("EFFECTIVE_FLAG")
    private String effectiveFlag;

    @ApiModelProperty(value = "医院编号")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;
}
