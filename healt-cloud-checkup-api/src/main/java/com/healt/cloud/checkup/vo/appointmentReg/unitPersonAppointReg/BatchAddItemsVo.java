package com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-22 15:16
 * @description: TODO
 */
@Data
public class BatchAddItemsVo implements Serializable {

    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @JsonProperty("USER_NAME")
    private String userName;

    @JsonProperty("USER_REAL_NAME")
    private String userRealName;

    @JsonProperty("UNIT_ID")
    private String unitId;

    @JsonProperty("UNIT_NAME")
    private String unitName;

    @JsonProperty("VISIT_ID")
    private String visitId;

    @JsonProperty("GROUP_ITEM_TEXT")
    private String groupItemText;

    @JsonProperty("GROUP_CODE")
    private String groupCode;

    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    private List<SelectUnitPersonVo> selectUnitPersons;
}
