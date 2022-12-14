package com.healt.cloud.checkup.vo.appointmentReg.modifyPersonItems;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-24 11:04
 * @description: TODO
 */
@Data
public class SaveModifyPersonItemsListVo implements Serializable {

    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @JsonProperty("PERSON_ID")
    private String personId;

    @JsonProperty("PERSON_VISIT_ID")
    private String personVisitId;

    @JsonProperty("BEFORE_SIGN")
    private String beforeSign;

    @JsonProperty("USER_NAME")
    private String userName;

    private List<SaveModifyPersonItemsVo> saveModifyPersonItemList;
}
