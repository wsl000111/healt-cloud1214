package com.healt.cloud.checkup.vo.settlement;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-03 13:58
 */
@Data
public class DiscountSchemeVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "打折方案名")
    @TableField("SCHEME_NAME")
    @JsonProperty("SCHEME_NAME")
    private String schemeName;

    @ApiModelProperty(value = "打折方案编码")
    @TableField("SCHEME_CODE")
    @JsonProperty("SCHEME_CODE")
    private String schemeCode;

}
