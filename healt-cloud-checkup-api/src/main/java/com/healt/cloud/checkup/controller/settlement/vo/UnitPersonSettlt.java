package com.healt.cloud.checkup.controller.settlement.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-08-28 1:18
 * @description: TODO
 */
@Data
public class UnitPersonSettlt implements Serializable {
    private String hospitalId;
    private String unitId;
    private Integer unitVisitId;
    private String personIdStr;
}
