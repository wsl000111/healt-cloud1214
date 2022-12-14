package com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-31 16:24
 * @description: TODO
 */
@Data
public class SuggestDictVo implements Serializable {

    @JsonProperty("HOSPITAL_ID")
    private String HOSPITAL_ID;

    @JsonProperty("SUGGEST_CODE")
    private String SUGGEST_CODE;

    @JsonProperty("SUGGEST_NAME")
    private String SUGGEST_NAME;

    @JsonProperty("REC_CLASS")
    private String REC_CLASS;

    @JsonProperty("DEPT_ID")
    private String DEPT_ID;

    @JsonProperty("SUGGEST_TEXT")
    private String SUGGEST_TEXT;

    @JsonProperty("KNOWLEDGE_TEXT")
    private String KNOWLEDGE_TEXT;

    @JsonProperty("INPUT_CODE")
    private String INPUT_CODE;

}
