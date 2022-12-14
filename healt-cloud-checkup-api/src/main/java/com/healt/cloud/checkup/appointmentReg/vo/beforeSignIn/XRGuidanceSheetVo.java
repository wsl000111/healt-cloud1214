package com.healt.cloud.checkup.appointmentReg.vo.beforeSignIn;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-02 17:02
 * @description: TODO
 */
@Data
public class XRGuidanceSheetVo implements Serializable {
    @JsonProperty("PERSON_ID")
    private String person_id;
    @JsonProperty("PERSON_VISIT_ID")
    private String person_visit_id;
    @JsonProperty("PATIENT_ID")
    private String patient_id;
    @JsonProperty("NAME")
    private String name;
    @JsonProperty("BARTHDAY")
    private String barthday;
    @JsonProperty("SEX")
    private String SEX;
    @JsonProperty("ITEM_PACK_NAME")
    private String item_pack_name;
    @JsonProperty("UNIT_NAME")
    private String unit_name;
    @JsonProperty("GUIDEGROUP_NAME")
    private String GUIDEGROUP_NAME;
    @JsonProperty("BEFORE_DATE")
    private String before_date;
    @JsonProperty("HC_DEPT_CODE")
    private String HC_DEPT_CODE;
    @JsonProperty("GUIDEGROUP_CODE")
    private String GUIDEGROUP_CODE;
    @JsonProperty("SORT_NO")
    private String SORT_NO;
    @JsonProperty("APPLY_NO")
    private String APPLY_NO;
    @JsonProperty("AGE")
    private String AGE;
    @JsonProperty("DEPARTMENT")
    private String DEPARTMENT;
    @JsonProperty("GUIDE_TIP")
    private String GUIDE_TIP;
    @JsonProperty("NOTE")
    private String NOTE;

}
