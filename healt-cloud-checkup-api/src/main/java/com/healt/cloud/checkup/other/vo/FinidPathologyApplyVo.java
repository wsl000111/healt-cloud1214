package com.healt.cloud.checkup.other.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuYue
 * @date 2022-08-31 11:26
 * @description: TODO
 */
@Data
public class FinidPathologyApplyVo implements Serializable {

    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @JsonProperty("APPLY_NO")
    private String applyNo;

    @JsonProperty("NAME")
    private String name;

    @JsonProperty("SEX")
    private String SEX;

    @JsonProperty("PERSON_ID")
    private String personId;

    @JsonProperty("PATIENT_ID")
    private String patientId;

    @JsonProperty("ID_NO")
    private String idNo;

    @JsonProperty("UNIT_NAME")
    private String unitName;

    @JsonProperty("PERSON_VISIT_ID")
    private String personVisitId;

    @JsonProperty("REQ_DATE_TIME")
    private Date reqDateTime;

    @JsonProperty("REQ_DEPT")
    private String reqDept;

    @JsonProperty("REQ_PHYSICIAN")
    private String reqPhysician;

}
