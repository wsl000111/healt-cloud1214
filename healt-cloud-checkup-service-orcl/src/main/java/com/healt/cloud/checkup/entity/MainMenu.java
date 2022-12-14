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
 * 主菜单
 * </p>
 *
 * @author GuYue
 * @since 2022-03-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("MAIN_MENU")
@ApiModel(value="MainMenu对象", description="主菜单")
public class MainMenu implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "节点编码")
    @TableId(value = "MENU_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("MENU_CODE")
    private String menuCode;

    @ApiModelProperty(value = "节点标题")
    @TableField("MENU_TITLE")
    @JsonProperty("MENU_TITLE")
    private String menuTitle;

    @ApiModelProperty(value = "节点类型 MENU菜单  MODULE模块")
    @TableField("MENU_TYPE")
    @JsonProperty("MENU_TYPE")
    private String menuType;

    @ApiModelProperty(value = "父节点编码")
    @TableField("PARENT_MENU_CODE")
    @JsonProperty("PARENT_MENU_CODE")
    private String parentMenuCode;

    @ApiModelProperty(value = "序号")
    @TableField("SERIAL_NO")
    @JsonProperty("SERIAL_NO")
    private Integer serialNo;

    @ApiModelProperty(value = "文件名")
    @TableField("FILE_NAME")
    @JsonProperty("FILE_NAME")
    private String fileName;

    @ApiModelProperty(value = "窗体ID")
    @TableField("FORM_ID")
    @JsonProperty("FORM_ID")
    private String formId;

    @ApiModelProperty(value = "图标文件")
    @TableField("ICON_FILE")
    @JsonProperty("ICON_FILE")
    private String iconFile;

    @ApiModelProperty(value = "状态 1 可用 0 不可用")
    @TableField("ISVISIBLE")
    @JsonProperty("ISVISIBLE")
    private Integer isvisible;

    @ApiModelProperty(value = "窗体打开方式")
    @TableField("WIN_OPEN_MODE")
    @JsonProperty("WIN_OPEN_MODE")
    private Integer winOpenMode;

    @ApiModelProperty(value = "备注")
    @TableField("MEMO")
    @JsonProperty("MEMO")
    private String memo;

    @ApiModelProperty(value = "窗口传入参数,多个参数以;分隔")
    @TableField("WIN_PARAMETER")
    @JsonProperty("WIN_PARAMETER")
    private String winParameter;

    @ApiModelProperty(value = "菜单所属控件(如果是窗体上面的主菜单，该字段为空，如果是窗体上控件右手键菜单，该字段保存窗口上控件名称)")
    @TableField("FORM_CONTROL")
    @JsonProperty("FORM_CONTROL")
    private String formControl;

    @ApiModelProperty(value = "菜单分组标识，右键菜单")
    @TableField("MENU_GROUP")
    @JsonProperty("MENU_GROUP")
    private String menuGroup;

    @ApiModelProperty(value = "大图标(保存本地图标文件的路径)")
    @TableField("LARGE_ICON")
    @JsonProperty("LARGE_ICON")
    private String largeIcon;

    @ApiModelProperty(value = "图标风格(1-显示大图标，2-显示小图标)")
    @TableField("ICON_STYLE")
    @JsonProperty("ICON_STYLE")
    private String iconStyle;

    @ApiModelProperty(value = "打开窗体是否有参数")
    @TableField("OPEN_PARAM")
    @JsonProperty("OPEN_PARAM")
    private Integer openParam;

    @ApiModelProperty(value = "窗口显示标题")
    @TableField("DISPLAY_TEXT")
    @JsonProperty("DISPLAY_TEXT")
    private String displayText;

    @ApiModelProperty(value = "机构编号")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "备份图标文件")
    @TableField("ICON_FILE_BF")
    @JsonProperty("ICON_FILE_BF")
    private String iconFileBf;


}
