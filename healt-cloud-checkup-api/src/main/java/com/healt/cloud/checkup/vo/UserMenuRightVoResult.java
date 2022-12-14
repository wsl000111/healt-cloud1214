package com.healt.cloud.checkup.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author GuYue
 * @date 2022-03-05 15:08
 * @description: TODO
 */
@Data
@ApiModel(value="MainMenuVO对象", description="主菜单")
public class UserMenuRightVoResult implements Serializable {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "窗口显示标题")
    private String DISPLAY_TEXT;
    @ApiModelProperty(value = "节点标题")
    private String MENU_TITLE;
    @ApiModelProperty(value = "节点编码")
    private String MENU_CODE;
    @ApiModelProperty(value = "父节点编码")
    private String PARENT_MENU_CODE;
    @ApiModelProperty(value = "序号")
    private Integer SERIAL_NO;
    @ApiModelProperty(value = "窗体ID")
    private String FORM_ID;
    @ApiModelProperty(value = "图标文件")
    private String ICON_FILE;
    @ApiModelProperty(value = "文件名")
    private String FILE_NAME;
}
