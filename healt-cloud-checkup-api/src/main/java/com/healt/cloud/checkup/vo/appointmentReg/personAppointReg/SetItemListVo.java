package com.healt.cloud.checkup.vo.appointmentReg.personAppointReg;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author linklee
 * @create 2022-03-30 17:51
 */
@Data
public class SetItemListVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "套餐编码")
    @TableId(value = "SET_CODE")
    @JsonProperty("SET_CODE")
    private String setCode;

    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("HC_DEPT_CODE")
    @JsonProperty("HC_DEPT_CODE")
    private String hcDeptCode;

    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @TableField("PACK_CLASS")
    @JsonProperty("PACK_CLASS")
    private String packClass;

    @TableField("CLINICAL_SIGNIFICANCE")
    @JsonProperty("CLINICAL_SIGNIFICANCE")
    private String clinicalSignificance;

    @TableField("GUIDEGROUP_CODE")
    @JsonProperty("GUIDEGROUP_CODE")
    private String guidegroupCode;

    @TableField("GUIDE_TIP")
    @JsonProperty("GUIDE_TIP")
    private String guideTip;

    @TableField("APPLY_SENDTO")
    @JsonProperty("APPLY_SENDTO")
    private String applySendto;

    @TableField("RESULT_RECIEVED")
    @JsonProperty("RESULT_RECIEVED")
    private String resultRecieved;

    @TableField("HIS_DEPART_CODE")
    @JsonProperty("HIS_DEPART_CODE")
    private String hisDepartCode;

    @TableField("HIS_DEPART_NAME")
    @JsonProperty("HIS_DEPART_NAME")
    private String hisDepartName;

    @TableField("DRAW_BLOOD")
    @JsonProperty("DRAW_BLOOD")
    private String drawBlood;

    @TableField("TEST_TUBE_CODE")
    @JsonProperty("TEST_TUBE_CODE")
    private String testTubeCode;

    @TableField("SPECIMAN_NAME")
    @JsonProperty("SPECIMAN_NAME")
    private String specimanName;

    @TableField("EXAM_CLASS")
    @JsonProperty("EXAM_CLASS")
    private String examClass;

    @TableField("EXAM_SUB_CLASS")
    @JsonProperty("EXAM_SUB_CLASS")
    private String examSubClass;

    @TableField("COST_CLASS_CODE")
    @JsonProperty("COST_CLASS_CODE")
    private String costClassCode;

    @TableField("IS_DISCOUNT")
    @JsonProperty("IS_DISCOUNT")
    private String isDiscount;

    @TableField("ITEM_PACK_PRICE")
    @JsonProperty("ITEM_PACK_PRICE")
    private BigDecimal itemPackPrice;

    @TableField("ITEM_PACK_DISCOUNT_PRICE")
    @JsonProperty("ITEM_PACK_DISCOUNT_PRICE")
    private BigDecimal itemPackDiscountPrice;

    @TableField("AUTO_FINISHED")
    @JsonProperty("AUTO_FINISHED")
    private String autoFinished;

    @TableField("REPORT_FLAG")
    @JsonProperty("REPORT_FLAG")
    private String reportFlag;

    @TableField("RESULT_HANDLE")
    @JsonProperty("RESULT_HANDLE")
    private String resultHandle;

    @TableField("EFFECTIVE_FLAG")
    @JsonProperty("EFFECTIVE_FLAG")
    private String effectiveFlag;

    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "类别名称")
    @TableField("CLASS_NAME")
    @JsonProperty("CLASS_NAME")
    private String className;

    @ApiModelProperty(value = "性别识别码")
    @TableField("IMG")
    @JsonProperty("IMG")
    private String img;
}
