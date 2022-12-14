package com.healt.cloud.checkup.service.ws.his.costChargeState.response;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * @author GuYue
 * @date 2022-07-23 10:24
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "costChargeStateResBody", namespace = "com.healt.cloud.checkup.service.ws.his.costChargeState.costChargeStateResBody",propOrder = {
        "result"
})
@Data
public class CostChargeStateResBody{
    @XmlElement(name = "Result")
    private Result result;
}
