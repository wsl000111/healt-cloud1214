package com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-04-11 15:56
 * @description: TODO
 */
@Data
public class DtUnitGroupItemsVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("GROUP_NAME")
    @JsonProperty("GROUP_NAME")
    private String groupName;

    @TableField("GROUP_CODE")
    @JsonProperty("GROUP_CODE")
    private String groupCode;

    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @TableField("SOURCE_NAME")
    @JsonProperty("SOURCE_NAME")
    private String sourceName;

    @TableField("HC_DEPT_CODE")
    @JsonProperty("HC_DEPT_CODE")
    private String hcDeptCode;

    @TableField("COST_CLASS_CODE")
    @JsonProperty("COST_CLASS_CODE")
    private String costClassCode;

    @TableField("GUIDEGROUP_CODE")
    @JsonProperty("GUIDEGROUP_CODE")
    private String guidegroupCode;

    @TableField("ITEM_PACK_PRICE")
    @JsonProperty("ITEM_PACK_PRICE")
    private String itemPackPrice;

    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private String itemNo;

    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;
}
