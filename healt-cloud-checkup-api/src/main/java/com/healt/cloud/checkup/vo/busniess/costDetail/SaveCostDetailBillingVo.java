package com.healt.cloud.checkup.vo.busniess.costDetail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-07-14 12:57
 * @description: TODO
 */
@Data
public class SaveCostDetailBillingVo implements Serializable {
    @JsonProperty("PATIENTID")
    private String patientId; //   VARCHAR2(100)   N 平台ID

    @JsonProperty("PERSON_ID")
    private String personId; //   VARCHAR2(20)    N 人员编号

    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId; //  NUMBER(3)   N 体检次数

    @JsonProperty("UNIT_ID")
    private String unitId; // VARCHAR2(10)    Y 单位编码

    @JsonProperty("UNIT_VISIT_ID")
    private Integer unitVisitId; //   NUMBER(3)   Y 单位次数

    @JsonProperty("PATIENTNAME")
    private String patientName; //  VARCHAR2(100)   Y HIS人员姓名

    @JsonProperty("PATIENTTYPE")
    private String patientType; //   VARCHAR2(10)    Y 患者类型3 体检患者

    @JsonProperty("VISITID")
    private Integer visitId; //NUMBER(3)   Y HIS就诊次数

    @JsonProperty("PAIVISITID")
    private String paiVisitId; //  VARCHAR2(100)   Y 单次就诊流水号 体检号_体检次数

    @JsonProperty("EXAMTYPE")
    private String examType; //VARCHAR2(10)    Y 体检类别 1个人体检 2单位体检

    @JsonProperty("EXAMCOMPANYNO")
    private String examCompanyNo; // VARCHAR2(10)    Y 体检单位编号

    @JsonProperty("EXAMCOMPANYNAME")
    private String examCompanyName; //   VARCHAR2(200)   Y 体检单位名称

    @JsonProperty("CURRENTORGDCODE")
    private String currentOrgdCode; //   VARCHAR2(20)    Y 当前科室

    @JsonProperty("CURRENTWARDCODE")
    private String currentWardCode; //  VARCHAR2(50)    Y 当前病区

    private List<CostDetailBillingVo> costDetailBilling;
}
