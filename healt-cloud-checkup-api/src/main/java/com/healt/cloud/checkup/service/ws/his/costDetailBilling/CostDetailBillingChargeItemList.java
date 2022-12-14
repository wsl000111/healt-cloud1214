package com.healt.cloud.checkup.service.ws.his.costDetailBilling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-07-22 11:43
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "chargeItem"
})
public class CostDetailBillingChargeItemList {

    @XmlElement(name = "ChargeItem")
    private List<CostDetailBillingChargeItem> chargeItem;

    public List<CostDetailBillingChargeItem> getChargeItem() {
        return chargeItem;
    }

    public void setChargeItem(List<CostDetailBillingChargeItem> chargeItem) {
        this.chargeItem = chargeItem;
    }

    @Override
    public String toString() {
        return "CostDetailBillingChargeItemList{" +
                "chargeItem=" + chargeItem +
                '}';
    }
}
