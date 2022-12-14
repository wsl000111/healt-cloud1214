package com.healt.cloud.checkup.appointmentReg.vo.beforeSignIn;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-05 15:34
 * @description: TODO
 */
@Data
public class UpdateHcPersonVistInfoVo implements Serializable {

    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @JsonProperty("PERSON_ID")
    private String personId;

    @JsonProperty("PERSON_VISIT_ID")
    private String personVisitId;

    @JsonProperty("NAME")
    private String name;

    @JsonProperty("VALUES")
    private String values;

    @JsonProperty("USER_NAME")
    private String userName;

    @JsonProperty("USER_REAL_NAME")
    private String userRealName;

    public List<UpdateHcPersonAppregItemsVo> updateHcPersonAppregItems;

}
