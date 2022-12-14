package com.healt.cloud.checkup.service.ws.his.companyCostBack;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-09-01 16:55
 * @description: TODO
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class CompanyCostBackReqBody implements Serializable {

    @XmlElement(name = "ChargeState")
    protected CompanyCostChargeState chargeState;

}
