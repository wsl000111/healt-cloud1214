package com.healt.cloud.checkup.service.ws.his.costChargeState;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author linklee
 * @create 2022-07-06 16:13
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chargeState", propOrder = {
        "examType",
        "examNo",
        "examCompanyNo",
        "examCompanyName",
        "patientId",
        "visitId",
        "feeStatus",
        "operator",
        "operateTime",
        "rekId",
        "invoiceId",
        "applyDoctorCode",
        "applyDoctorName",
        "applyOrgCode",
        "applyOrgName",
        "execOrgCode",
        "execOrgName",
        "execFlag",
        "areaCode",
        "itemListVo"
})
@Data
public class ChargeState {

    @XmlElement(name = "ExamType")
    protected String examType;
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
    @XmlElement(name = "FeeStatus")
    protected String feeStatus;
    @XmlElement(name = "Operator")
    protected String operator;
    @XmlElement(name = "OperateTime")
    protected String operateTime;
    @XmlElement(name = "RekId")
    protected String rekId;
    @XmlElement(name = "InvoiceId")
    protected String invoiceId;
    @XmlElement(name = "ApplyDoctorCode")
    protected String applyDoctorCode;
    @XmlElement(name = "ApplyDoctorName")
    protected String applyDoctorName;
    @XmlElement(name = "ApplyOrgCode")
    protected String applyOrgCode;
    @XmlElement(name = "ApplyOrgName")
    protected String applyOrgName;
    @XmlElement(name = "ExecOrgCode")
    protected String execOrgCode;
    @XmlElement(name = "ExecOrgName")
    protected String execOrgName;
    @XmlElement(name = "ExecFlag")
    protected String execFlag;
    @XmlElement(name = "AreaCode")
    protected String areaCode;

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
