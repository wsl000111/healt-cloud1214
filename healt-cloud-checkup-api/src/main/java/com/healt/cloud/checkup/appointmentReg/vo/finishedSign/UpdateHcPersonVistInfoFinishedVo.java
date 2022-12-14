package com.healt.cloud.checkup.appointmentReg.vo.finishedSign;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-20 16:32
 * @description: TODO
 */
@Data
public class UpdateHcPersonVistInfoFinishedVo implements Serializable {

    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @JsonProperty("PERSON_ID")
    private String personId;

    @JsonProperty("PERSON_VISIT_ID")
    private String personVisitId;

    @JsonProperty("VALUES")
    private String values;

    @JsonProperty("FINISHED_ID")
    private String finishedId;

    @JsonProperty("FINISHED_NAME")
    private String finishedName;


}
