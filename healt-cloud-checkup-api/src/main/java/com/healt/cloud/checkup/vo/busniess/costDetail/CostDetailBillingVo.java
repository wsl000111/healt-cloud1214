package com.healt.cloud.checkup.vo.busniess.costDetail;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author GuYue
 * @date 2022-07-14 12:59
 * @description: TODO
 */

@Data
public class CostDetailBillingVo implements Serializable {
    @JsonProperty("ORDERID")
    private String orderId; //   VARCHAR2(50)    N 医嘱ID 体检可不传,体检保存作为序号主键

    @JsonProperty("APPLYNO")
    private String applyNo; // VARCHAR2(50)    Y 申请单号 体检空

    @JsonProperty("CLINICTYPE")
    private String clinicType; // VARCHAR2(50)    Y 诊疗项目分类

    @JsonProperty("FEEITEMCLASS")
    private String feeItemClass; //   VARCHAR2(50)    Y 项目分类

    @JsonProperty("CLINICITEMID")
    private String clinicItemId; //   VARCHAR2(50)    Y 诊疗项目ID

    @JsonProperty("CLINICITEMNAME")
    private String clinicItemName; //   VARCHAR2(300)   Y 诊疗项目名称

    @JsonProperty("ITEMTYPE")
    private String itemType; //   VARCHAR2(50)    Y 物价项目分类

    @JsonProperty("FEEITEMID")
    private String FeeItemId; //   VARCHAR2(50)    Y 项目明细编码

    @JsonProperty("FEEITEMNAME")
    private String feeItemName; //  VARCHAR2(50)    Y 项目明细名称

    @JsonProperty("DRUGSPEC")
    private String drugSpec; //   VARCHAR2(50)    Y 项目明细规格

    @JsonProperty("PHARMACYFACTORYNAME")
    private String pharmacyFactoryName; //  VARCHAR2(50)    Y 厂家/产地名称

    @JsonProperty("NUM")
    private BigDecimal num; // NUMBER(8,2) Y 数量

    @JsonProperty("UNIT")
    private String unit; //   VARCHAR2(50)    Y 数量单位

    @JsonProperty("UNITPRICE")
    private BigDecimal unitPrice; //   NUMBER(12,4)    Y 单价

    @JsonProperty("UNITCOEFF")
    private BigDecimal unitCoeff; //   NUMBER(12,4)    Y			"数量单位和基本单位的换算系数"

    @JsonProperty("TOTALPRICE")
    private BigDecimal totalPrice; //   NUMBER(12,4)    Y 金额

    @JsonProperty("CHARGES")
    private BigDecimal charges; //   NUMBER(12,4)    Y 实际收费用

    @JsonProperty("CLASSONRCPT")
    private String classOnRcpt; //   VARCHAR2(50)    Y 收据类别

    @JsonProperty("APPLYDOCTORCODE")
    private String applyDoctorCode; //  VARCHAR2(50)    Y 申请医生编码

    @JsonProperty("APPLYDOCTORNAME")
    private String applyDoctorName; //   VARCHAR2(50)    Y 申请医生名称

    @JsonProperty("APPLYORGCODE")
    private String applyOrgCode; //   VARCHAR2(50)    Y 申请科室编码

    @JsonProperty("APPLYORGNAME")
    private String applyOrgName; //  VARCHAR2(300)   Y 申请科室名称

    @JsonProperty("EXECORGCODE")
    private String execOrgCode; //  VARCHAR2(50)    Y 执行科室编码

    @JsonProperty("EXECORGNAME")
    private String execOrgName; //  VARCHAR2(300)   Y 执行科室名称

    @JsonProperty("CHARGEDATE")
    private String chargeDate; //   VARCHAR2(18)    Y 费用发生日期YYYYMMDDHHMISS

    @JsonProperty("ENTERDATE")
    private String enterDate; //   VARCHAR2(18)    Y 费用录入日期YYYYMMDDHHMISS

    @JsonProperty("HOSPITAL_ID")
    private String hospitalId; //   VARCHAR2(20)    N 机构ID

    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;//体检组合项目

    @JsonProperty("HC_ITEM_NO")
    private Integer hcItemNo;//人员预约项目序号
}
