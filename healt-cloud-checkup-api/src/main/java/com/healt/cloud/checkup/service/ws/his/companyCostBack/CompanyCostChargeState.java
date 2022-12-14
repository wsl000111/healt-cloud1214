package com.healt.cloud.checkup.service.ws.his.companyCostBack;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-09-01 16:58
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chargeState", propOrder = {
        "examCompanyID",
        "examCompanyNo",
        "examCompanyName",
        "applyOrgCode",
        "applyOrgName",
        "execOrgCode",
        "execOrgName",
        "applyDate",
        "areaCode",
        "medInstId",
        "cancType",
        "chargeItemList"
})
@Data
public class CompanyCostChargeState implements Serializable {
    @XmlElement(name = "ExamCompanyID")
    protected String examCompanyID;

    @XmlElement(name = "ExamCompanyNo")
    protected String examCompanyNo;

    @XmlElement(name = "ExamCompanyName")
    protected String examCompanyName;

    @XmlElement(name = "ApplyOrgCode")
    protected String applyOrgCode;

    @XmlElement(name = "ApplyOrgName")
    protected String applyOrgName;

    @XmlElement(name = "ExecOrgCode")
    protected String execOrgCode;

    @XmlElement(name = "ExecOrgName")
    protected String execOrgName;

    @XmlElement(name = "ApplyDate")
    protected String applyDate;

    @XmlElement(name = "AreaCode")
    protected String areaCode;

    @XmlElement(name = "MedInstId")
    protected String medInstId;

    @XmlElement(name = "CancType")
    protected String cancType;

    @XmlElement(name = "ChargeItemList")
    protected CompanyCostChargeItemList chargeItemList;

}
