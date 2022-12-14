package com.healt.cloud.checkup.service.ws.his.costChargeState.response;

import com.healt.cloud.checkup.service.ws.his.costChargeState.CostChargeHeader;
import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * @author GuYue
 * @date 2022-07-22 11:07
 * @description: TODO
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Response")
public class CostChargeStateResponse {

    @XmlElement(name = "CostChargeHeader")
    private CostChargeHeader costChargeHeader;

//    @XmlElement(name = "Body")
//    private MessageBody body;

    @XmlElement(name = "CostChargeStateResBody")
    private CostChargeStateResBody costChargeStateResBody;

}
