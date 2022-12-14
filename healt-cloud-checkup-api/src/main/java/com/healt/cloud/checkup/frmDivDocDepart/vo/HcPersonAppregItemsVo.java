package com.healt.cloud.checkup.frmDivDocDepart.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-01 15:08
 * @description: TODO
 */
@Data
public class HcPersonAppregItemsVo implements Serializable {

    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @JsonProperty("PERSON_ID")
    private String personId;

    @JsonProperty("PERSON_VISIT_ID")
    private String personVisitId;

    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @JsonProperty("ITEM_NO")
    private String itemNo;

    @JsonProperty("APPLY_CLASS")
    private String applyClass;

    @JsonProperty("APPLY_SENDTO")
    private String applySendto;

    @JsonProperty("VALUES")
    private String values;
}
