package com.healt.cloud.checkup.vo.busniess.clinicPrice;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-07-14 12:02
 * @description: TODO
 */
@Data
public class ClinicItemPrice implements Serializable {
    private String itemClass;
    private String itemClassName;
    private String itemCode;
    private String itemName;
    private String itemUnit;
    private String priceMoney;
    private String latestEnableTime;
    private String isEnable;
    private String pyCode;
}
