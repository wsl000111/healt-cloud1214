package com.healt.cloud.checkup.other.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liyongfei
 * @date 2022-09-06 8:52
 */
@Data
public class UpdatePersonVisitInfo implements Serializable {

    @JsonProperty("UNIT_ID")
    private String unitId;

    @JsonProperty("UNIT_VISIT_ID")
    private String unitVisitId;

    @JsonProperty("UNIT_NAME")
    private String unitName;

    @JsonProperty("PERSON_ID")
    private String personId;

    @JsonProperty("PERSON_VISIT_ID")
    private String personVisitId;
}
