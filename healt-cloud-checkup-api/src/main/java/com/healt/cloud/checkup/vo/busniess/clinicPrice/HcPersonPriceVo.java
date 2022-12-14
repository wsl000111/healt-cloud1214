package com.healt.cloud.checkup.vo.busniess.clinicPrice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-07-14 17:18
 * @description: TODO
 */
@Data
public class HcPersonPriceVo implements Serializable {
    @JsonProperty("PERSON_ID")
    private String PERSON_ID;
    @JsonProperty("PERSON_VISIT_ID")
    private String PERSON_VISIT_ID;
    @JsonProperty("ITEM_CLASS")
    private String ITEM_CLASS;
    @JsonProperty("UNIT_ID")
    private String UNIT_ID;
    @JsonProperty("UNIT_NAME")
    private String UNIT_NAME;
    @JsonProperty("ITEM_PACK_CODE")
    private String ITEM_PACK_CODE;
    @JsonProperty("NAME")
    private String NAME;
    @JsonProperty("SEX")
    private String SEX;
    @JsonProperty("ITEM_PACK_NAME")
    private String ITEM_PACK_NAME;
    @JsonProperty("NUM")
    private String NUM;
    @JsonProperty("ITEM_NO")
    private String ITEM_NO;
    @JsonProperty("BILL_INDICATOR")
    private String BILL_INDICATOR;
    @JsonProperty("DISCOUNT_RATE")
    private int DISCOUNT_RATE = 1;
    @JsonProperty("FINISHED_SIGN")
    private String FINISHED_SIGN;
    @JsonProperty("ADD_ITEM")
    private String ADD_ITEM;
    @JsonProperty("SET_CODE")
    private String SET_CODE;
    @JsonProperty("COSTS")
    private String COSTS;
    @JsonProperty("CHARGES")
    private String CHARGES;
    @JsonProperty("ORDER_ID")
    private String ORDER_ID;
    @JsonProperty("CLINIC_ITEM_CODE")
    private String CLINIC_ITEM_CODE;
    @JsonProperty("CLINIC_ITEM_NAME")
    private String CLINIC_ITEM_NAME;
    @JsonProperty("CHARGE_ITEM_CODE")
    private String CHARGE_ITEM_CODE;
    @JsonProperty("CHARGE_ITEM_NAME")
    private String CHARGE_ITEM_NAME;
    @JsonProperty("CHARGE_ITEM_CLASS")
    private String CHARGE_ITEM_CLASS;
    @JsonProperty("CHARGE_PRICEMONEY")
    private String CHARGE_PRICEMONEY;
    @JsonProperty("ITEM_UNIT")
    private String ITEM_UNIT;
    @JsonProperty("HISCOSTS")
    private String HISCOSTS;
    @JsonProperty("HISCHARGES")
    private String HISCHARGES;
    @JsonProperty("HIS_DEPART_CODE")
    private String HIS_DEPART_CODE;
    @JsonProperty("HIS_DEPART_NAME")
    private String HIS_DEPART_NAME;
    @JsonProperty("IS_DISCOUNT")
    private String IS_DISCOUNT;
    @JsonProperty("OUTP_RCPT_CODE")
    private String OUTP_RCPT_CODE;
}
