package com.healt.cloud.checkup.vo.settlement;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-04 10:52
 */
@Data
public class DtxmHZVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("COST_CLASS_NAME")
    @JsonProperty("COST_CLASS_NAME")
    private String costClassName;

    @TableField("COSTS")
    @JsonProperty("COSTS")
    private String costs;

    @TableField("CHARGES")
    @JsonProperty("CHARGES")
    private String charges;
}
