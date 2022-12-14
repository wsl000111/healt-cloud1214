package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;
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
 * 
 * </p>
 *
 * @author GuYue
 * @since 2022-03-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("HC_ITEM_PACK_DICT")
@ApiModel(value="HcItemPackDict对象", description="组合字典")
public class HcItemPackDict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    @TableField("SORT_NO")
    @JsonProperty("SORT_NO")
    private Integer sortNo;

    @ApiModelProperty(value = "项目编码")
    @TableId(value = "ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @ApiModelProperty(value = "输入码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @ApiModelProperty(value = "机构编码")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "体检科室")
    @TableField("HC_DEPT_CODE")
    @JsonProperty("HC_DEPT_CODE")
    private String hcDeptCode;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @ApiModelProperty(value = "组合类型")
    @TableField("PACK_CLASS")
    @JsonProperty("PACK_CLASS")
    private String packClass;

    @ApiModelProperty(value = "临床意义")
    @TableField("CLINICAL_SIGNIFICANCE")
    @JsonProperty("CLINICAL_SIGNIFICANCE")
    private String clinicalSignificance;

    @ApiModelProperty(value = "指引单分组")
    @TableField("GUIDEGROUP_CODE")
    @JsonProperty("GUIDEGROUP_CODE")
    private String guidegroupCode;

    @ApiModelProperty(value = "指引单提示")
    @TableField("GUIDE_TIP")
    @JsonProperty("GUIDE_TIP")
    private String guideTip;

    @ApiModelProperty(value = "申请发往")
    @TableField("APPLY_SENDTO")
    @JsonProperty("APPLY_SENDTO")
    private String applySendto;

    @ApiModelProperty(value = "结果所在")
    @TableField("RESULT_RECIEVED")
    @JsonProperty("RESULT_RECIEVED")
    private String resultRecieved;

    @ApiModelProperty(value = "对应his科室编码")
    @TableField("HIS_DEPART_CODE")
    @JsonProperty("HIS_DEPART_CODE")
    private String hisDepartCode;

    @ApiModelProperty(value = "对应his科室名称")
    @TableField("HIS_DEPART_NAME")
    @JsonProperty("HIS_DEPART_NAME")
    private String hisDepartName;

    @ApiModelProperty(value = "是否抽血")
    @TableField("DRAW_BLOOD")
    @JsonProperty("DRAW_BLOOD")
    private String drawBlood;

    @ApiModelProperty(value = "试管代码")
    @TableField("TEST_TUBE_CODE")
    @JsonProperty("TEST_TUBE_CODE")
    private String testTubeCode;

    @ApiModelProperty(value = "标本名称")
    @TableField("SPECIMAN_NAME")
    @JsonProperty("SPECIMAN_NAME")
    private String specimanName;

    @ApiModelProperty(value = "检查类别")
    @TableField("EXAM_CLASS")
    @JsonProperty("EXAM_CLASS")
    private String examClass;

    @ApiModelProperty(value = "检查子类")
    @TableField("EXAM_SUB_CLASS")
    @JsonProperty("EXAM_SUB_CLASS")
    private String examSubClass;

    @ApiModelProperty(value = "费用类别")
    @TableField("COST_CLASS_CODE")
    @JsonProperty("COST_CLASS_CODE")
    private String costClassCode;

    @ApiModelProperty(value = "是否折扣")
    @TableField("IS_DISCOUNT")
    @JsonProperty("IS_DISCOUNT")
    private String isDiscount;

    @ApiModelProperty(value = "组合价格")
    @TableField("ITEM_PACK_PRICE")
    @JsonProperty("ITEM_PACK_PRICE")
    private BigDecimal itemPackPrice;

    @ApiModelProperty(value = "组合折扣价格")
    @TableField("ITEM_PACK_DISCOUNT_PRICE")
    @JsonProperty("ITEM_PACK_DISCOUNT_PRICE")
    private BigDecimal itemPackDiscountPrice;

    @ApiModelProperty(value = "是否自动完成")
    @TableField("AUTO_FINISHED")
    @JsonProperty("AUTO_FINISHED")
    private String autoFinished;

    @ApiModelProperty(value = "是否报告")
    @TableField("REPORT_FLAG")
    @JsonProperty("REPORT_FLAG")
    private String reportFlag;

    @ApiModelProperty(value = "结果处理方法")
    @TableField("RESULT_HANDLE")
    @JsonProperty("RESULT_HANDLE")
    private String resultHandle;

    @ApiModelProperty(value = "有效标志")
    @TableField("EFFECTIVE_FLAG")
    @JsonProperty("EFFECTIVE_FLAG")
    private String effectiveFlag;


}
