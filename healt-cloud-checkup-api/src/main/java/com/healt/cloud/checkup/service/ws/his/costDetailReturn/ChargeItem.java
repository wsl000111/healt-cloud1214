package com.healt.cloud.checkup.service.ws.his.costDetailReturn;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author linklee
 * @create 2022-07-06 14:45
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chargeItem", propOrder = {
        "orderId",
        "clinicItemId",
        "clinicItemName",
        "itemType",
        "feeItemId",
        "drugSpec",
        "num",
        "unit",
        "unitPrice",
        "unitCoeff",
        "totalPrice",
        "applyDoctorCode",
        "applyDoctorName",
        "applyOrgCode",
        "applyOrgName",
        "execOrgCode",
        "execOrgName",
        "cancReason"
})
@Data
public class ChargeItem {

    @XmlElement(name = "OrderId")
    protected String orderId;
    @XmlElement(name = "ClinicItemId")
    protected String clinicItemId;
    @XmlElement(name = "ClinicItemName")
    protected String clinicItemName;
    @XmlElement(name = "ItemType")
    protected String itemType;
    @XmlElement(name = "FeeItemId")
    protected String feeItemId;
    @XmlElement(name = "DrugSpec")
    protected String drugSpec;
    @XmlElement(name = "Num")
    protected String num;
    @XmlElement(name = "Unit")
    protected String unit;
    @XmlElement(name = "UnitPrice")
    protected String unitPrice;
    @XmlElement(name = "UnitCoeff")
    protected String unitCoeff;
    @XmlElement(name = "TotalPrice")
    protected String totalPrice;
    @XmlElement(name = "ApplyDoctorCode")
    protected String applyDoctorCode;
    @XmlElement(name = "ApplyDoctorName")
    protected String applyDoctorName;
    @XmlElement(name = "ApplyOrgCode")
    protected String applyOrgCode;
    @XmlElement(name = "ApplyOrgName")
    protected String applyOrgName;
    @XmlElement(name = "ExecOrgCode")
    protected String execOrgCode;
    @XmlElement(name = "ExecOrgName")
    protected String execOrgName;
    @XmlElement(name = "CancReason")
    protected String cancReason;

}
