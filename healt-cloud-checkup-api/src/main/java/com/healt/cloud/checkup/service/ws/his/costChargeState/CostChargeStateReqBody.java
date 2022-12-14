package com.healt.cloud.checkup.service.ws.his.costChargeState;

/**
 * @author GuYue
 * @date 2022-07-22 23:39
 * @description: TODO
 */

import com.healt.cloud.checkup.service.ws.server.vo.SoapBody;
import com.healt.cloud.checkup.service.ws.server.vo.SoapRequest;
import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "body",propOrder = {
        "chargeState"
})
@Data
public class CostChargeStateReqBody{
        @XmlElement(name = "ChargeState")
        private ChargeState chargeState;
}
