package com.healt.cloud.checkup.service.pubComm.impl;

import lombok.Data;

/**
 * @author GuYue
 * @date 2022-07-25 16:39
 * @description: TODO
 */
@Data
public class ViewClinicParts {
    //clinic_item_code clinicItemCode, clinic_item_name clinicItemName,parts_value partsValue, parts_name partsName
    private String clinicItemCode;
    private String clinicItemName;
    private String partsValue;
    private String partsName;
}
