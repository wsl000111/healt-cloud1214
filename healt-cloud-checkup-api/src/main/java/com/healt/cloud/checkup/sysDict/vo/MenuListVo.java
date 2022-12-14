package com.healt.cloud.checkup.sysDict.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-27 17:18
 */
@Data
public class MenuListVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "节点编码")
    @TableId(value = "MENU_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("MENU_CODE")
    private String menuCode;

    @ApiModelProperty(value = "窗口显示标题")
    @TableField("DISPLAY_TEXT")
    @JsonProperty("DISPLAY_TEXT")
    private String displayText;

    @ApiModelProperty(value = "父节点编码")
    @TableField("PARENT_MENU_CODE")
    @JsonProperty("PARENT_MENU_CODE")
    private String parentMenuCode;
}
