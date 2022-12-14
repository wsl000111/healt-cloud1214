package com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-04-19 10:48
 * @description: TODO
 */
@Data
public class UpdateHcUnitVisitInfo implements Serializable {

    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @JsonProperty("UNIT_ID")
    private String unitId;

    @JsonProperty("UNIT_VISIT_ID")
    private String unitVisitId;

    @JsonProperty("VALUES")
    private String values;

}
