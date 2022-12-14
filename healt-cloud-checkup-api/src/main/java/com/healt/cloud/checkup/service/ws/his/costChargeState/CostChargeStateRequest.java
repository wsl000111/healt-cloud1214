package com.healt.cloud.checkup.service.ws.his.costChargeState;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author GuYue
 * @date 2022-07-22 10:14
 * @description: TODO
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Request")
public class CostChargeStateRequest {

    @XmlElement(name = "Header")
    private CostChargeHeader header;

//    @XmlElement(name = "Body")
//    private MessageBody body;

    @XmlElement(name = "Body")
    private CostChargeStateReqBody body;


}

