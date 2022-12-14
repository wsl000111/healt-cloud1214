package com.healt.cloud.checkup.autoUpdate.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-10 9:41
 * @description: TODO
 */
@Data
public class HealtUpdateParaVo implements Serializable {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "FTP参数代码")
    @TableField("CODE")
    @JsonProperty("CODE")
    private String code;

    @ApiModelProperty(value = "FTP参数名称")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "FTP参数值")
    @TableField("VALUE")
    @JsonProperty("VALUE")
    private String value;

    @TableField("HIS_UNIT_CODE")
    @JsonProperty("HIS_UNIT_CODE")
    private String hisUnitCode;
}
