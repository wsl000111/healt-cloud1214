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
 * 体检传HIS收费临时表
 * </p>
 *
 * @author GuYue
 * @since 2022-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("COST_DETAIL_BILLING")
@ApiModel(value="CostDetailBilling对象", description="体检传HIS收费临时表")
public class CostDetailBilling implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "平台ID")
    @TableField("PATIENTID")
    @JsonProperty("PATIENTID")
    private String patientId;

    @ApiModelProperty(value = "人员编号")
    @TableId(value = "PERSON_ID", type = IdType.ASSIGN_ID)
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

    @ApiModelProperty(value = "单位次数")
    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "HIS人员姓名")
    @TableField("PATIENTNAME")
    @JsonProperty("PATIENTNAME")
    private String patientName;

    @ApiModelProperty(value = "患者类型3 体检患者")
    @TableField("PATIENTTYPE")
    @JsonProperty("PATIENTTYPE")
    private String patientType;

    @ApiModelProperty(value = "HIS就诊次数")
    @TableField("VISITID")
    @JsonProperty("VISITID")
    private Integer visitId;

    @ApiModelProperty(value = "单次就诊流水号 体检号_体检次数")
    @TableField("PAIVISITID")
    @JsonProperty("PAIVISITID")
    private String paiVisitId;

    @ApiModelProperty(value = "体检类别 1个人体检 2单位体检")
    @TableField("EXAMTYPE")
    @JsonProperty("EXAMTYPE")
    private String examType;

    @ApiModelProperty(value = "体检单位编号")
    @TableField("EXAMCOMPANYNO")
    @JsonProperty("EXAMCOMPANYNO")
    private String examCompanyNo;

    @ApiModelProperty(value = "体检单位名称")
    @TableField("EXAMCOMPANYNAME")
    @JsonProperty("EXAMCOMPANYNAME")
    private String examCompanyName;

    @ApiModelProperty(value = "当前科室")
    @TableField("CURRENTORGDCODE")
    @JsonProperty("CURRENTORGDCODE")
    private String currentOrgdCode;

    @ApiModelProperty(value = "当前病区")
    @TableField("CURRENTWARDCODE")
    @JsonProperty("CURRENTWARDCODE")
    private String currentWardCode;

    @ApiModelProperty(value = "医嘱ID 体检可不传,体检保存作为序号主键")
    @TableField("ORDERID")
    @JsonProperty("ORDERID")
    private String orderId;

    @ApiModelProperty(value = "申请单号 体检空")
    @TableField("APPLYNO")
    @JsonProperty("APPLYNO")
    private String applyNo;

    @ApiModelProperty(value = "诊疗项目分类")
    @TableField("CLINICTYPE")
    @JsonProperty("CLINICTYPE")
    private String clinicType;

    @ApiModelProperty(value = "项目分类")
    @TableField("FEEITEMCLASS")
    @JsonProperty("FEEITEMCLASS")
    private String feeItemClass;

    @ApiModelProperty(value = "诊疗项目ID")
    @TableField("CLINICITEMID")
    @JsonProperty("CLINICITEMID")
    private String clinicItemId;

    @ApiModelProperty(value = "诊疗项目名称")
    @TableField("CLINICITEMNAME")
    @JsonProperty("CLINICITEMNAME")
    private String clinicItemName;

    @ApiModelProperty(value = "物价项目分类")
    @TableField("ITEMTYPE")
    @JsonProperty("ITEMTYPE")
    private String itemType;

    @ApiModelProperty(value = "项目明细编码")
    @TableField("FEEITEMID")
    @JsonProperty("FEEITEMID")
    private String FeeItemId;

    @ApiModelProperty(value = "项目明细名称")
    @TableField("FEEITEMNAME")
    @JsonProperty("FEEITEMNAME")
    private String feeItemName;

    @ApiModelProperty(value = "项目明细规格")
    @TableField("DRUGSPEC")
    @JsonProperty("DRUGSPEC")
    private String drugSpec;

    @ApiModelProperty(value = "厂家/产地名称")
    @TableField("PHARMACYFACTORYNAME")
    @JsonProperty("PHARMACYFACTORYNAME")
    private String pharmacyFactoryName;

    @ApiModelProperty(value = "数量")
    @TableField("NUM")
    @JsonProperty("NUM")
    private BigDecimal num;

    @ApiModelProperty(value = "数量单位")
    @TableField("UNIT")
    @JsonProperty("UNIT")
    private String unit;

    @ApiModelProperty(value = "单价")
    @TableField("UNITPRICE")
    @JsonProperty("UNITPRICE")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "数量单位和基本单位的换算系数")
    @TableField("UNITCOEFF")
    @JsonProperty("UNITCOEFF")
    private BigDecimal unitCoeff;

    @ApiModelProperty(value = "金额")
    @TableField("TOTALPRICE")
    @JsonProperty("TOTALPRICE")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "实际收费用")
    @TableField("CHARGES")
    @JsonProperty("CHARGES")
    private BigDecimal charges;

    @ApiModelProperty(value = "收据类别")
    @TableField("CLASSONRCPT")
    @JsonProperty("CLASSONRCPT")
    private String classOnRcpt;

    @ApiModelProperty(value = "申请医生编码")
    @TableField("APPLYDOCTORCODE")
    @JsonProperty("APPLYDOCTORCODE")
    private String applyDoctorCode;

    @ApiModelProperty(value = "申请医生名称")
    @TableField("APPLYDOCTORNAME")
    @JsonProperty("APPLYDOCTORNAME")
    private String applyDoctorName;

    @ApiModelProperty(value = "申请科室编码")
    @TableField("APPLYORGCODE")
    @JsonProperty("APPLYORGCODE")
    private String applyOrgCode;

    @ApiModelProperty(value = "申请科室名称")
    @TableField("APPLYORGNAME")
    @JsonProperty("APPLYORGNAME")
    private String applyOrgName;

    @ApiModelProperty(value = "执行科室编码")
    @TableField("EXECORGCODE")
    @JsonProperty("EXECORGCODE")
    private String execOrgCode;

    @ApiModelProperty(value = "执行科室名称")
    @TableField("EXECORGNAME")
    @JsonProperty("EXECORGNAME")
    private String execOrgName;

    @ApiModelProperty(value = "费用发生日期YYYYMMDDHHMISS")
    @TableField("CHARGEDATE")
    @JsonProperty("CHARGEDATE")
    private String chargeDate;

    @ApiModelProperty(value = "费用录入日期YYYYMMDDHHMISS")
    @TableField("ENTERDATE")
    @JsonProperty("ENTERDATE")
    private String enterDate;

    @ApiModelProperty(value = "机构ID")
    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "体检组合项目")
    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "人员预约项目序号")
    @TableField("HC_ITEM_NO")
    @JsonProperty("HC_ITEM_NO")
    private Integer hcItemNo;

    @ApiModelProperty(value = "收费成功后 的状态回传 的收据号，状态回传后更新")
    @TableField("REKID")
    @JsonProperty("REKID")
    private String rekid;

    @ApiModelProperty(value = "如果 是退费 的更新退的收据号")
    @TableField("RETURN_REKID")
    @JsonProperty("RETURN_REKID")
    private String returnRekid;


}
