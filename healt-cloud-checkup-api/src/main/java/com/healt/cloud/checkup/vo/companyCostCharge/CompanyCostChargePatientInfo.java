package com.healt.cloud.checkup.vo.companyCostCharge;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-09-02 12:04
 * @description: TODO
 */
@Data
public class CompanyCostChargePatientInfo implements Serializable {

    private String personId;
    private String personVisitId;
    private String itemPackCode;
    private String itemNo;
    private String charges;

}
