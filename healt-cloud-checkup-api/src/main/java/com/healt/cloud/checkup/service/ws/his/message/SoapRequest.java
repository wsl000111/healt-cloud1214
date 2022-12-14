package com.healt.cloud.checkup.service.ws.his.message;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author GuYue
 * @date 2022-08-21 16:13
 * @description: TODO
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SoapRequest")
public class SoapRequest {

    @XmlElement(name = "ReqXml")
    protected String reqXml;

}
