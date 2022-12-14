package com.healt.cloud.checkup.service.ws.his.costRefundApply;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-08-19 20:19
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chargeState", propOrder = {
        "examType",
        "patientType",
        "examNo",
        "examCompanyNo",
        "examCompanyName",
        "patientId",
        "visitId",
        "applyDoctorCode",
        "applyDoctorName",
        "applyOrgCode",
        "applyOrgName",
        "applyDate",
        "areaCode",
        "cancReason",
        "cancType",
        "itemListVo"
})
@Data
public class ChargeState {
    @XmlElement(name = "ExamType")
    protected String examType;
    @XmlElement(name = "PatientType")
    protected String patientType;
    @XmlElement(name = "ExamNo")
    protected String examNo;
    @XmlElement(name = "ExamCompanyNo")
    protected String examCompanyNo;
    @XmlElement(name = "ExamCompanyName")
    protected String examCompanyName;
    @XmlElement(name = "PatientId")
    protected String patientId;
    @XmlElement(name = "VisitId")
    protected String visitId;
    @XmlElement(name = "ApplyDoctorCode")
    protected String applyDoctorCode;
    @XmlElement(name = "ApplyDoctorName")
    protected String applyDoctorName;
    @XmlElement(name = "ApplyOrgCode")
    protected String applyOrgCode;
    @XmlElement(name = "ApplyOrgName")
    protected String applyOrgName;
    @XmlElement(name = "ApplyDate")
    protected String applyDate;
    @XmlElement(name = "AreaCode")
    protected String areaCode;
    @XmlElement(name = "CancReason")
    protected String cancReason;
    @XmlElement(name = "CancType")
    protected String cancType;

    @XmlElement(name = "ItemList")
    protected ItemListVo itemListVo;

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "itemListVo", propOrder = {
            "item"
    })
    @Data
    public static class ItemListVo{
        @XmlElement(name = "Item")
        private List<Item> item;
    }

}
