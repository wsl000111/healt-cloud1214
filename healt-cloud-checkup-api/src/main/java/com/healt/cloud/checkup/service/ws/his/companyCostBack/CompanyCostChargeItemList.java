package com.healt.cloud.checkup.service.ws.his.companyCostBack;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-09-02 20:23
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chargeItemList", propOrder = {
        "chargeItem"
})
@Data
public class CompanyCostChargeItemList implements Serializable {

    @XmlElement(name = "ChargeItem")
    protected List<CompanyCostChargeItem> chargeItem;

}
