package com.healt.cloud.checkup.service.ws.his.costRefundApply;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author GuYue
 * @date 2022-08-19 15:39
 * @description: TODO
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class CostRefundApplyReqBody {

    @XmlElement(name = "ChargeState")
    private ChargeState chargeState;

}
