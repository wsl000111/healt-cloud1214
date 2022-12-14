package com.healt.cloud.checkup.vo.appointmentReg.modifyPersonItems;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-04-21 10:28
 */
@Data
public class ModifySelectedItemsVo implements Serializable{

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "人员编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "体检次数")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "项目编码")
    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @ApiModelProperty(value = "预约日期")
    @TableField("REGISTER_DATE")
    @JsonProperty("REGISTER_DATE")
    private Date registerDate;

    @ApiModelProperty(value = "预约人编码")
    @TableField("REGISTER")
    @JsonProperty("REGISTER")
    private String register;

    @ApiModelProperty(value = "预约人姓名")
    @TableField("REGISTER_NAME")
    @JsonProperty("REGISTER_NAME")
    private String registerName;

    @ApiModelProperty(value = "是否加项")
    @TableField("ADD_ITEM")
    @JsonProperty("ADD_ITEM")
    private String addItem;

    @ApiModelProperty(value = "指引单分组代码")
    @TableField("CHART_CODE")
    @JsonProperty("CHART_CODE")
    private String chartCode;

    @ApiModelProperty(value = "检查检验申请号")
    @TableField("APPLY_NO")
    @JsonProperty("APPLY_NO")
    private String applyNo;

    @TableField("SUBMIT_APPLY")
    @JsonProperty("SUBMIT_APPLY")
    private String submitApply;

    @ApiModelProperty(value = "打印标签标志")
    @TableField("APPLY_NO_PRINT")
    @JsonProperty("APPLY_NO_PRINT")
    private String applyNoPrint;

    @ApiModelProperty(value = "应收")
    @TableField("COSTS")
    @JsonProperty("COSTS")
    private BigDecimal costs;

    @ApiModelProperty(value = "实收")
    @TableField("CHARGES")
    @JsonProperty("CHARGES")
    private BigDecimal charges;

    @ApiModelProperty(value = "缴费标志")
    @TableField("BILL_INDICATOR")
    @JsonProperty("BILL_INDICATOR")
    private String billIndicator;

    @ApiModelProperty(value = "完成标志")
    @TableField("FINISHED_SIGN")
    @JsonProperty("FINISHED_SIGN")
    private String finishedSign;

    @ApiModelProperty(value = "数量")
    @TableField("NUM")
    @JsonProperty("NUM")
    private BigDecimal num;

    @ApiModelProperty(value = "套餐编码")
    @TableField("SET_CODE")
    @JsonProperty("SET_CODE")
    private String setCode;

    @ApiModelProperty(value = "性别识别码")
    @TableField("IMG")
    @JsonProperty("IMG")
    private String img;

    @TableField("SPECIMAN_NAME")
    @JsonProperty("SPECIMAN_NAME")
    private String specimanName;

    @TableField("DRAW_BLOOD")
    @JsonProperty("DRAW_BLOOD")
    private String drawBlood;

    @TableField("TEST_TUBE_CODE")
    @JsonProperty("TEST_TUBE_CODE")
    private String testTubeCode;

    @TableField("APPLY_CLASS")
    @JsonProperty("APPLY_CLASS")
    private String applyClass;

    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private String itemNo;
}
