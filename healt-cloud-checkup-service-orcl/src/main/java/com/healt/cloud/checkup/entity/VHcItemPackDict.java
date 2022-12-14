package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * 
 * </p>
 *
 * @author linklee
 * @since 2022-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_HC_ITEM_PACK_DICT")
@ApiModel(value="VHcItemPackDict对象", description="")
public class VHcItemPackDict implements Serializable {

    private static final long serialVersionUID=1L;

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

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @TableField("DEPT_ID")
    @JsonProperty("DEPT_ID")
    private String deptId;


}
