package com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-04-19 10:44
 * @description: TODO
 */
@Data
public class UpdateHcUnitInfo implements Serializable {

    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @JsonProperty("UNIT_ID")
    private String unitId;

    @JsonProperty("VALUES")
    private String values;

}
