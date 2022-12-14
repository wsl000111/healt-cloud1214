package com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-01 9:47
 * @description: TODO
 */
@Data
public class ChiefPersonVisitInfoVo implements Serializable {
    @JsonProperty("PERSON_ID")
    private String PERSON_ID;
    @JsonProperty("NAME")
    private String NAME;
    @JsonProperty("SEX")
    private String SEX;
    @JsonProperty("UNIT_NAME")
    private String UNIT_NAME;
    @JsonProperty("UNIT_ID")
    private String UNIT_ID;
    @JsonProperty("PERSON_VISIT_ID")
    private String PERSON_VISIT_ID;
    @JsonProperty("UNIT_VISIT_ID")
    private String UNIT_VISIT_ID;
    @JsonProperty("AGE")
    private String AGE;
    @JsonProperty("MARITAL_STATUS")
    private String MARITAL_STATUS;
    @JsonProperty("BEFORE_DATE")
    private String BEFORE_DATE;
    @JsonProperty("APPOINTS_DATE")
    private String APPOINTS_DATE;
    @JsonProperty("RESULT_STATUS")
    private String RESULT_STATUS;
    @JsonProperty("PRINT_FLAG")
    private String PRINT_FLAG;

}
