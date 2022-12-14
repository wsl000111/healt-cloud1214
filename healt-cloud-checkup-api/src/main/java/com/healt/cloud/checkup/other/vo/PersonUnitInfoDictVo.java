package com.healt.cloud.checkup.other.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 李勇飞
 * @date 2022-09-15 11:29
 */
@Data
public class PersonUnitInfoDictVo implements Serializable {

    @JsonProperty("BEGIN_DATE")
    private String beginDate;

    @JsonProperty("END_DATE")
    private String endDate;

    @JsonProperty("UNIT_ID")
    private String unitId;

    @JsonProperty("UNIT_VISIT_ID")
    private String unitVisitId;

}
