package com.healt.cloud.checkup.service.ws.his.login;

import com.healt.cloud.checkup.service.ws.his.costDetailReturn.ChargeItem;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-08-20 21:19
 * @description: TODO
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class SSOLoginRequestBody {

    @XmlElement(name = "ST")
    private String ST;

    @XmlElement(name = "Url")
    private String url;

    @XmlElement(name = "SysUri")
    private String sysUri;

}
