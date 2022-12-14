package com.healt.cloud.checkup.service.ws.his.costChargeState;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * @author GuYue
 * @date 2022-07-22 10:15
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "costChargeHeader", propOrder = {
        "sender",
        "receiver",
        "sendDate",
        "serviceCode",
        "msgId",
        "authCode",
        "version",
})
@Data
public class CostChargeHeader {

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
