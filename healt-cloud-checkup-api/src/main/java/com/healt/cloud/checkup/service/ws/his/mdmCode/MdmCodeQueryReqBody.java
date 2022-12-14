package com.healt.cloud.checkup.service.ws.his.mdmCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author GuYue
 * @date 2022-07-03 11:38
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class MdmCodeQueryReqBody {

    @XmlElement(name = "StandardCode")
    private String standardCode;

    public String getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode;
    }

    @Override
    public String toString() {
        return "MdmCodeQueryReqBody{" +
                "standardCode='" + standardCode + '\'' +
                '}';
    }
}
