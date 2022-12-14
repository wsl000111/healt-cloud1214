package com.healt.cloud.checkup.service.ws.his.companyArchive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-09-01 8:22
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "companyInfo", propOrder = {
        "examCompanyNo",
        "examCompanyName",
        "areaCode",
        "invoiceName",
        "dutyParagraph",
        "address",
        "cardNo",
        "bankName"
})
@Data
public class CompanyInfo implements Serializable {

    @XmlElement(name = "ExamCompanyNo")
    private String examCompanyNo;

    @XmlElement(name = "ExamCompanyName")
    private String examCompanyName;

    @XmlElement(name = "AreaCode")
    private String areaCode;

    @XmlElement(name = "InvoiceName")
    private String invoiceName;

    @XmlElement(name = "DutyParagraph")
    private String dutyParagraph;

    @XmlElement(name = "Address")
    private String address;

    @XmlElement(name = "CardNo")
    private String cardNo;

    @XmlElement(name = "BankName")
    private String bankName;
}
