package com.healt.cloud.checkup.service.ws.server.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author GuYue
 * @date 2022-07-31 11:48
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "header", propOrder = {
        "sender",
        "receiver",
        "sendDate",
        "serviceCode",
        "msgId",
        "authCode",
        "version",
})
@Data
public class SoapHeader {

    @XmlElement(name = "Sender")
    protected String sender;
    @XmlElement(name = "Receiver")
    protected String receiver;
    @XmlElement(name = "SendDate")
    protected String sendDate;
    @XmlElement(name = "ServiceCode")
    protected String serviceCode;
    @XmlElement(name = "MsgId")
    protected String msgId;
    @XmlElement(name = "AuthCode")
    protected String authCode;
    @XmlElement(name = "Version")
    protected String version;
}
