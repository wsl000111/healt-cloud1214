package com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-04-22 15:18
 * @description: TODO
 */
@Data
public class SelectUnitPersonVo implements Serializable {

    @JsonProperty("PERSON_ID")
    private String personId;

    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

    //private String birthday;
}
