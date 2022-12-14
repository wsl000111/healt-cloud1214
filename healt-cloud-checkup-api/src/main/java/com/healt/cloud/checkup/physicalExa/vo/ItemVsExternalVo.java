package com.healt.cloud.checkup.physicalExa.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-23 15:41
 */
@Data
public class ItemVsExternalVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "项目编码")
    @TableId(value = "HC_ITEM_CODE")
    @JsonProperty("HC_ITEM_CODE")
    private String hcItemCode;

    @ApiModelProperty(value = "序号")
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

    @ApiModelProperty(value = "对照码")
    @TableField("EXT_CODE")
    @JsonProperty("EXT_CODE")
    private String extCode;
}
