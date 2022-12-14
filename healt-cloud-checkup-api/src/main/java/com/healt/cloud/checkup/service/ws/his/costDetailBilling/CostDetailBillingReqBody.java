package com.healt.cloud.checkup.service.ws.his.costDetailBilling;

import com.healt.cloud.checkup.service.ws.server.vo.SoapBody;
import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * @author linklee
 * @create 2022-07-06 14:23
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
@XmlType(name = "body", namespace = "com.healt.cloud.checkup.service.ws.his.costDetailBilling.CostDetailBillingReqBody")
public class CostDetailBillingReqBody{

    @XmlElement(name = "PatientInfo")
    private CostDetailBillingPatientInfo patientInfo;

//    @XmlElement(name = "ChargeItemList")
//    private List<CostDetailBillingChargeItem> chargeItemList;

    @XmlElement(name = "ChargeItemList")
    private CostDetailBillingChargeItemList chargeItemList;

    public CostDetailBillingPatientInfo getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(CostDetailBillingPatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }

//    public List<CostDetailBillingChargeItem> getChargeItemList() {
//        return chargeItemList;
//    }
//
//    public void setChargeItemList(List<CostDetailBillingChargeItem> chargeItemList) {
//        this.chargeItemList = chargeItemList;
//    }


    public CostDetailBillingChargeItemList getChargeItemList() {
        return chargeItemList;
    }

    public void setChargeItemList(CostDetailBillingChargeItemList chargeItemList) {
        this.chargeItemList = chargeItemList;
    }

    @Override
    public String toString() {
        return "CostDetailBillingReqBody{" +
                "patientInfo=" + patientInfo +
                ", chargeItemList=" + chargeItemList +
                '}';
    }
}
