package com.healt.cloud.checkup.vo.busniess.packSet;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author GuYue
 * @date 2022-03-17 10:09
 * @description: TODO
 */
public class VHcItemPackDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "科室类别名称")
    @TableField("CLASS_NAME")
    @JsonProperty("CLASS_NAME")
    private String className;

    @ApiModelProperty(value = "科室名称")
    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "排序号码")
    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private BigDecimal sortNo;

    @ApiModelProperty(value = "项目编码")
    @TableId(value = "ITEM_PACK_CODE", type = IdType.ASSIGN_ID)
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;
}
