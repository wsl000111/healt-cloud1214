package com.healt.cloud.checkup.service.ws.his.costRefundApply;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author GuYue
 * @date 2022-08-19 20:31
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "item", propOrder = {
        "orderId",
        "clinicItemId",
        "clinicItemName",
        "feeItemId",
        "feeItemName",
        "drugSpec",
        "num",
        "unit",
        "unitPrice"
})
@Data
public class Item {
    @XmlElement(name = "OrderId")
    protected String orderId;
    @XmlElement(name = "ClinicItemId")
    protected String clinicItemId;
    @XmlElement(name = "ClinicItemName")
    protected String clinicItemName;
    @XmlElement(name = "FeeItemId")
    protected String feeItemId;
    @XmlElement(name = "FeeItemName")
    protected String feeItemName;
    @XmlElement(name = "DrugSpec")
    protected String drugSpec;
    @XmlElement(name = "Num")
    protected String num;
    @XmlElement(name = "Unit")
    protected String unit;
    @XmlElement(name = "UnitPrice")
    protected String unitPrice;
}
