package com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-04-26 11:33
 * @description: TODO
 */
@Data
public class BatchUnitPersonsDeleteItemsVo  implements Serializable {

    @JsonProperty("PERSON_ID")
    private String personId; //  体检ID

    @JsonProperty("PERSON_VISIT_ID")
    private String personVisitId; //  体检次数

    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode; //  项目编码

    @JsonProperty("TCOUNT")
    @JsonIgnore(value = true)
    private String tcount;

    @JsonProperty("MAX_ITEM_NO")
    private String maxItemNo;

}
