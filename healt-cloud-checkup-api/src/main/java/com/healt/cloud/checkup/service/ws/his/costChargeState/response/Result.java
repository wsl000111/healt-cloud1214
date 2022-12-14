package com.healt.cloud.checkup.service.ws.his.costChargeState.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author GuYue
 * @date 2022-07-23 10:26
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "result", propOrder = {
        "code",
        "desc"
})
@Data
public class Result {
    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "Desc")
    protected String desc;
}
