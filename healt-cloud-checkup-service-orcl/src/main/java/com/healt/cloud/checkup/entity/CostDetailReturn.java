package com.healt.cloud.checkup.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
//import com.fasterxml.jackson.annotation.JsonInclude;//不返回null值字段
import com.fasterxml.jackson.annotation.JsonProperty;//前端传值有下划线
import org.apache.ibatis.type.JdbcType;

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
@TableName("COST_DETAIL_RETURN")
@ApiModel(value="CostDetailReturn对象", description="体检传HIS收费临时表")
public class CostDetailReturn implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "平台ID")
    @TableField(value = "PATIENTID", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("PATIENTID")
    private String patientid;

    @ApiModelProperty(value = "人员编号")
    @TableId(value = "PERSON_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField(value = "PERSON_VISIT_ID", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.INTEGER)
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "单位编码")
    @TableField(value = "UNIT_ID", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "单位次数")
    @TableField(value = "UNIT_VISIT_ID", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.INTEGER)
    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId;

    @ApiModelProperty(value = "HIS人员姓名")
    @TableField(value = "PATIENTNAME", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("PATIENTNAME")
    private String patientname;

    @ApiModelProperty(value = "患者类型3 体检患者")
    @TableField(value = "PATIENTTYPE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("PATIENTTYPE")
    private String patienttype;

    @ApiModelProperty(value = "HIS就诊次数")
    @TableField(value = "VISITID", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.INTEGER)
    @JsonProperty("VISITID")
    private Integer visitid;

    @ApiModelProperty(value = "单次就诊流水号 体检号_体检次数")
    @TableField(value = "PAIVISITID", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("PAIVISITID")
    private String paivisitid;

    @ApiModelProperty(value = "体检类别 1个人体检 2单位体检")
    @TableField(value = "EXAMTYPE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("EXAMTYPE")
    private String examtype;

    @ApiModelProperty(value = "体检单位编号")
    @TableField(value = "EXAMCOMPANYNO", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("EXAMCOMPANYNO")
    private String examcompanyno;

    @ApiModelProperty(value = "体检单位名称")
    @TableField(value = "EXAMCOMPANYNAME", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("EXAMCOMPANYNAME")
    private String examcompanyname;

    @ApiModelProperty(value = "当前科室")
    @TableField(value = "CURRENTORGDCODE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("CURRENTORGDCODE")
    private String currentorgdcode;

    @ApiModelProperty(value = "当前病区")
    @TableField(value = "CURRENTWARDCODE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("CURRENTWARDCODE")
    private String currentwardcode;

    @ApiModelProperty(value = "医嘱ID 体检可不传,体检保存作为序号主键")
    @TableField(value = "ORDERID", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("ORDERID")
    private String orderid;

    @ApiModelProperty(value = "申请单号 体检空")
    @TableField(value = "APPLYNO", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("APPLYNO")
    private String applyno;

    @ApiModelProperty(value = "诊疗项目分类")
    @TableField(value = "CLINICTYPE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("CLINICTYPE")
    private String clinictype;

    @ApiModelProperty(value = "项目分类")
    @TableField(value = "FEEITEMCLASS", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("FEEITEMCLASS")
    private String feeitemclass;

    @ApiModelProperty(value = "诊疗项目ID")
    @TableField(value = "CLINICITEMID", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("CLINICITEMID")
    private String clinicitemid;

    @ApiModelProperty(value = "诊疗项目名称")
    @TableField(value = "CLINICITEMNAME", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("CLINICITEMNAME")
    private String clinicitemname;

    @ApiModelProperty(value = "物价项目分类")
    @TableField(value = "ITEMTYPE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("ITEMTYPE")
    private String itemtype;

    @ApiModelProperty(value = "项目明细编码")
    @TableField(value = "FEEITEMID", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("FEEITEMID")
    private String feeitemid;

    @ApiModelProperty(value = "项目明细名称")
    @TableField(value = "FEEITEMNAME", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("FEEITEMNAME")
    private String feeitemname;

    @ApiModelProperty(value = "项目明细规格")
    @TableField(value = "DRUGSPEC", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("DRUGSPEC")
    private String drugspec;

    @ApiModelProperty(value = "厂家/产地名称")
    @TableField(value = "PHARMACYFACTORYNAME", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("PHARMACYFACTORYNAME")
    private String pharmacyfactoryname;

    @ApiModelProperty(value = "数量")
    @TableField(value = "NUM", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.DECIMAL)
    @JsonProperty("NUM")
    private BigDecimal num;

    @ApiModelProperty(value = "数量单位")
    @TableField(value = "UNIT", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("UNIT")
    private String unit;

    @ApiModelProperty(value = "单价")
    @TableField(value = "UNITPRICE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.DECIMAL)
    @JsonProperty("UNITPRICE")
    private BigDecimal unitprice;

    @ApiModelProperty(value = "数量单位和基本单位的换算系数")
    @TableField(value = "UNITCOEFF", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.DECIMAL)
    @JsonProperty("UNITCOEFF")
    private BigDecimal unitcoeff;

    @ApiModelProperty(value = "金额")
    @TableField(value = "TOTALPRICE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.DECIMAL)
    @JsonProperty("TOTALPRICE")
    private BigDecimal totalprice;

    @ApiModelProperty(value = "实际收费用")
    @TableField(value = "CHARGES", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.DECIMAL)
    @JsonProperty("CHARGES")
    private BigDecimal charges;

    @ApiModelProperty(value = "收据类别")
    @TableField(value = "CLASSONRCPT", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("CLASSONRCPT")
    private String classonrcpt;

    @ApiModelProperty(value = "申请医生编码")
    @TableField(value = "APPLYDOCTORCODE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("APPLYDOCTORCODE")
    private String applydoctorcode;

    @ApiModelProperty(value = "申请医生名称")
    @TableField(value = "APPLYDOCTORNAME", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("APPLYDOCTORNAME")
    private String applydoctorname;

    @ApiModelProperty(value = "申请科室编码")
    @TableField(value = "APPLYORGCODE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("APPLYORGCODE")
    private String applyorgcode;

    @ApiModelProperty(value = "申请科室名称")
    @TableField(value = "APPLYORGNAME", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("APPLYORGNAME")
    private String applyorgname;

    @ApiModelProperty(value = "执行科室编码")
    @TableField(value = "EXECORGCODE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("EXECORGCODE")
    private String execorgcode;

    @ApiModelProperty(value = "执行科室名称")
    @TableField(value = "EXECORGNAME", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("EXECORGNAME")
    private String execorgname;

    @ApiModelProperty(value = "费用发生日期YYYYMMDDHHMISS")
    @TableField(value = "CHARGEDATE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("CHARGEDATE")
    private String chargedate;

    @ApiModelProperty(value = "费用录入日期YYYYMMDDHHMISS")
    @TableField(value = "ENTERDATE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("ENTERDATE")
    private String enterdate;

    @ApiModelProperty(value = "机构ID")
    @TableField(value = "HOSPITAL_ID", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "体检组合项目")
    @TableField(value = "ITEM_PACK_CODE", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "人员预约项目序号")
    @TableField(value = "HC_ITEM_NO", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.INTEGER)
    @JsonProperty("HC_ITEM_NO")
    private Integer hcItemNo;

    @ApiModelProperty(value = "要退费的收据号，是入参")
    @TableField(value = "OLD_REKID", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("OLD_REKID")
    private String oldRekid;

    @ApiModelProperty(value = "退费原因")
    @TableField(value = "CANCREASON", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("CANCREASON")
    private String cancreason;

    @ApiModelProperty(value = "作废总金额")
    @TableField(value = "TOTALREFUNDMONEY", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.DECIMAL)
    @JsonProperty("TOTALREFUNDMONEY")
    private BigDecimal totalrefundmoney;

    @ApiModelProperty(value = "作废或退费成功后状态回传更新的收据号")
    @TableField(value = "REKID", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    @JsonProperty("REKID")
    private String rekid;


}
