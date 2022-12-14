package com.healt.cloud.checkup.vo.saveCostDetailReturn;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-08-23 1:42
 * @description: TODO
 */
@Data
public class SaveCostDetailReturn implements Serializable {

    @JsonProperty("PATIENTID")
    private String PATIENTID;
    @JsonProperty("PERSON_ID")
    private String PERSON_ID;
    @JsonProperty("PERSON_VISIT_ID")
    private String PERSON_VISIT_ID;
    @JsonProperty("UNIT_ID")
    private String UNIT_ID;
    @JsonProperty("UNIT_VISIT_ID")
    private String UNIT_VISIT_ID;
    @JsonProperty("PATIENTNAME")
    private String PATIENTNAME;
    @JsonProperty("PATIENTTYPE")
    private String PATIENTTYPE;
    @JsonProperty("VISITID")
    private String VISITID;
    @JsonProperty("PAIVISITID")
    private String PAIVISITID;
    @JsonProperty("EXAMTYPE")
    private String EXAMTYPE;
    @JsonProperty("EXAMCOMPANYNO")
    private String EXAMCOMPANYNO;
    @JsonProperty("EXAMCOMPANYNAME")
    private String EXAMCOMPANYNAME;
    @JsonProperty("CURRENTORGDCODE")
    private String CURRENTORGDCODE;
    @JsonProperty("CURRENTWARDCODE")
    private String CURRENTWARDCODE;
    @JsonProperty("TOTALREFUNDMONEY")
    private String TOTALREFUNDMONEY;
    @JsonProperty("REKID")
    private String REKID;
    @JsonProperty("CANCREASON")
    private String CANCREASON;
    @JsonProperty("costDetailBilling")
    private List<CostDetailBillingVo> costDetailBilling;
}
