package com.healt.cloud.checkup.vo.companyCostCharge;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-09-02 11:02
 * @description: TODO
 */
@Data
public class CompanyCostChargeStateVo implements Serializable {

    private String examCompanyID;
    
    private String examCompanyNo;

    private String examCompanyName;

    private String applyOrgCode;

    private String applyOrgName;

    private String execOrgCode;

    private String execOrgName;

    private String applyDate;

    private String areaCode;

    private String medInstId;

    private String cancType;

    private String unitId;

    private String unitVisitId;

    private List<CompanyCostChargeItemVo> chargeItem;

    private List<CompanyCostChargePatientInfo> patientInfos;
}
