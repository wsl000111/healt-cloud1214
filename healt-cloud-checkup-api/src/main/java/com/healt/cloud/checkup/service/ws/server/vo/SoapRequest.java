package com.healt.cloud.checkup.service.ws.server.vo;

import com.healt.cloud.checkup.service.ws.his.costChargeState.CostChargeHeader;
import com.healt.cloud.checkup.service.ws.his.costChargeState.CostChargeStateReqBody;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.Map;

/**
 * @author GuYue
 * @date 2022-07-31 11:47
 * @description: TODO
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Request")
public class SoapRequest {

    @XmlElement(name = "Header")
    private SoapHeader header;

//    @XmlElement(name = "Body")
//    private MessageBody body;

    @XmlElement(name = "Body")
    private SoapBody body;
}
