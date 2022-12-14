package com.healt.cloud.checkup.service.ws.his.mdmClinicpriceQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author GuYue
 * @date 2022-07-14 11:16
 * @description: TODO
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class ClinicpriceQueryReqBody {

    @XmlElement(name = "ItemClass")
    private String itemClass;

    @XmlElement(name = "AreaCode")
    private String areaCode;

    @XmlElement(name = "MedInstCode")
    private String medInstCode;

    @XmlElement(name = "ItemCode")
    private String ItemCode;

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

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    @Override
    public String toString() {
        return "ClinicpriceQueryReqBody{" +
                "itemClass='" + itemClass + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", medInstCode='" + medInstCode + '\'' +
                ", ItemCode='" + ItemCode + '\'' +
                '}';
    }
}
