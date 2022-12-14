package com.healt.cloud.checkup.service.ws.his.costDetailReturn;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-07-06 15:38
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class CostDetailReturnReqBody implements Serializable {

    @XmlElement(name = "PatientInfo")
    private PatientInfo patientInfo;

    @XmlElement(name = "ChargeItemList")
    private ChargeItemList chargeItemList;

    @XmlElement(name = "TotalMoney")
    private TotalMoney TotalRefundMoney;

}
