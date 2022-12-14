package com.healt.cloud.checkup.service.ws.his.organization;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * @author linklee
 * @create 2022-07-01 11:22
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class OrganizationRequestBody {

    @XmlElement(name = "AreaCode")
    protected String areaCode;
    @XmlElement(name = "MedInstCode")
    protected String medInstCode;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getMedInstCode() {
        return medInstCode;
    }

    public void setMedInstCode(String medInstCode) {
        this.medInstCode = medInstCode;
    }

    @Override
    public String toString() {
        return "OrganizationRequestBody{" +
                "areaCode='" + areaCode + '\'' +
                ", medInstCode='" + medInstCode + '\'' +
                '}';
    }
}
