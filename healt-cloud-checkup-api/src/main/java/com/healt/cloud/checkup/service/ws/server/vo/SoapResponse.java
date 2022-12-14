package com.healt.cloud.checkup.service.ws.server.vo;

import com.healt.cloud.checkup.service.ws.his.costChargeState.CostChargeHeader;
import com.healt.cloud.checkup.service.ws.his.costChargeState.response.CostChargeStateResBody;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author GuYue
 * @date 2022-07-31 11:49
 * @description: TODO
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Response")
public class SoapResponse {
    @XmlElement(name = "Header")
    private SoapHeader header;

//    @XmlElement(name = "Body")
//    private MessageBody body;

    @XmlElement(name = "Body")
    private Object body;
}
