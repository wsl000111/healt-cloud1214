package com.healt.cloud.checkup.service.ws.his.mdmClinicitemQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author GuYue
 * @date 2022-07-01 11:03
 * @description: TODO
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class ClinicItemQueryReqBody {

    @XmlElement(name = "ItemClass")
    private String itemClass;

    @XmlElement(name = "AreaCode")
    private String areaCode;

    @XmlElement(name = "MedInstCode")
    private String medInstCode;

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

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
        return "ClinicItemQueryReqBody{" +
                "itemClass='" + itemClass + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", medInstCode='" + medInstCode + '\'' +
                '}';
    }

}
