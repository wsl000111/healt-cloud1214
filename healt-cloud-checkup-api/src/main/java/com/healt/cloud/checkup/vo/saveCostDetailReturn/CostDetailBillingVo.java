package com.healt.cloud.checkup.vo.saveCostDetailReturn;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-08-23 1:49
 * @description: TODO
 */
@Data
public class CostDetailBillingVo implements Serializable {
    @JsonProperty("ITEM_PACK_CODE")
    private String ITEM_PACK_CODE;
    @JsonProperty("HC_ITEM_NO")
    private String HC_ITEM_NO;
    @JsonProperty("ORDERID")
    private String ORDERID;
    @JsonProperty("APPLYNO")
    private String APPLYNO;
    @JsonProperty("CLINICTYPE")
    private String CLINICTYPE;
    @JsonProperty("FEEITEMCLASS")
    private String FEEITEMCLASS;
    @JsonProperty("CLINICITEMID")
    private String CLINICITEMID;
    @JsonProperty("CLINICITEMNAME")
    private String CLINICITEMNAME;
    @JsonProperty("ITEMTYPE")
    private String ITEMTYPE;
    @JsonProperty("FEEITEMID")
    private String FEEITEMID;
    @JsonProperty("FEEITEMNAME")
    private String FEEITEMNAME;
    @JsonProperty("DRUGSPEC")
    private String DRUGSPEC;
    @JsonProperty("PHARMACYFACTORYNAME")
    private String PHARMACYFACTORYNAME;
    @JsonProperty("NUM")
    private String NUM;
    @JsonProperty("UNIT")
    private String UNIT;
    @JsonProperty("UNITPRICE")
    private String UNITPRICE;
    @JsonProperty("UNITCOEFF")
    private String UNITCOEFF;
    @JsonProperty("TOTALPRICE")
    private String TOTALPRICE;
    @JsonProperty("CHARGES")
    private String CHARGES;
    @JsonProperty("CLASSONRCPT")
    private String CLASSONRCPT;
    @JsonProperty("APPLYDOCTORCODE")
    private String APPLYDOCTORCODE;
    @JsonProperty("APPLYDOCTORNAME")
    private String APPLYDOCTORNAME;
    @JsonProperty("APPLYORGCODE")
    private String APPLYORGCODE;
    @JsonProperty("APPLYORGNAME")
    private String APPLYORGNAME;
    @JsonProperty("EXECORGCODE")
    private String EXECORGCODE;
    @JsonProperty("EXECORGNAME")
    private String EXECORGNAME;
    @JsonProperty("CHARGEDATE")
    private String CHARGEDATE;
    @JsonProperty("ENTERDATE")
    private String ENTERDATE;
    @JsonProperty("HOSPITAL_ID")
    private String HOSPITAL_ID;
}
