package com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-01 16:46
 * @description: TODO
 */
@Data
public class ChiemItemStatusVo implements Serializable {

    @JsonProperty("ITEM_PACK_NAME")
    private String ITEM_PACK_NAME;

    @JsonProperty("DEPT_NAME")
    private String DEPT_NAME;

    @JsonProperty("FINISHED_SIGN")
    private String FINISHED_SIGN;

    @JsonProperty("REGISTER_DATE")
    private String REGISTER_DATE;

    @JsonProperty("DOCTOR_ID")
    private String DOCTOR_ID;

    @JsonProperty("DOCTOR_NAME")
    private String DOCTOR_NAME;

}
