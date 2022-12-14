package com.healt.cloud.checkup.service.ws.his.companyCostBack;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-09-02 10:34
 * @description: TODO
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chargeItem", propOrder = {
        "orderId",
        "clinicType",
        "feeItemClass",
        "clinicItemId",
        "num",
        "unit",
        "unitPrice",
        "receivablePrice",
        "discountsPrice",
        "realPrice",
        "operator",
        "desc",
})
public class CompanyCostChargeItem implements Serializable {
    @XmlElement(name = "OrderId")
    protected String orderId;
    @XmlElement(name = "ClinicType")
    protected String clinicType;
    @XmlElement(name = "FeeItemClass")
    protected String feeItemClass;
    @XmlElement(name = "ClinicItemId")
    protected String clinicItemId;
    @XmlElement(name = "Num")
    protected String num;
    @XmlElement(name = "Unit")
    protected String unit;
    @XmlElement(name = "UnitPrice")
    protected String unitPrice;
    @XmlElement(name = "ReceivablePrice")
    protected String receivablePrice;
    @XmlElement(name = "DiscountsPrice")
    protected String discountsPrice;
    @XmlElement(name = "RealPrice")
    protected String realPrice;
    @XmlElement(name = "Operator")
    protected String operator;
    @XmlElement(name = "Desc")
    protected String desc;
}
