package com.healt.cloud.checkup.service.ws.his.costDetailReturn;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-09-04 8:38
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chargeItemList", propOrder = {
        "chargeItem"
})
@Data
public class ChargeItemList implements Serializable {

    @XmlElement(name = "ChargeItem")
    protected List<ChargeItem> chargeItem;

}
