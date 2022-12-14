package com.healt.cloud.checkup.service.ws.his.costDetailBilling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author linklee
 * @create 2022-07-06 14:28
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patientInfo", propOrder = {
        "patientId",
        "patientName",
        "patientType",
        "identityType",
        "identityNum",
        "visitId",
        "medInstCode",
        "areaCode",
        "exzamFlag",
        "operator",
        "paiVisitId",
        "examType",
        "examCompanyNo",
        "examCompanyName",
        "currentOrgdCode",
        "currentWardCode"
})
public class CostDetailBillingPatientInfo {

    @XmlElement(name = "PatientId")
    protected String patientId;
    @XmlElement(name = "PatientName")
    protected String patientName;
    @XmlElement(name = "PatientType")
    protected String patientType;
    @XmlElement(name = "IdentityType")
    protected String identityType;
    @XmlElement(name = "IdentityNum")
    protected String identityNum;
    @XmlElement(name = "VisitId")
    protected String visitId;
    @XmlElement(name = "MedInstCode")
    protected String medInstCode;
    @XmlElement(name = "AreaCode")
    protected String areaCode;
    @XmlElement(name = "ExzamFlag")
    protected String exzamFlag;
    @XmlElement(name = "Operator")
    protected String operator;
    @XmlElement(name = "PaiVisitId")
    protected String paiVisitId;
    @XmlElement(name = "ExamType")
    protected String examType;
    @XmlElement(name = "ExamCompanyNo")
    protected String examCompanyNo;
    @XmlElement(name = "ExamCompanyName")
    protected String examCompanyName;
    @XmlElement(name = "CurrentOrgdCode")
    protected String currentOrgdCode;
    @XmlElement(name = "CurrentWardCode")
    protected String currentWardCode;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getMedInstCode() {
        return medInstCode;
    }

    public void setMedInstCode(String medInstCode) {
        this.medInstCode = medInstCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getExzamFlag() {
        return exzamFlag;
    }

    public void setExzamFlag(String exzamFlag) {
        this.exzamFlag = exzamFlag;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPaiVisitId() {
        return paiVisitId;
    }

    public void setPaiVisitId(String paiVisitId) {
        this.paiVisitId = paiVisitId;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getExamCompanyNo() {
        return examCompanyNo;
    }

    public void setExamCompanyNo(String examCompanyNo) {
        this.examCompanyNo = examCompanyNo;
    }

    public String getExamCompanyName() {
        return examCompanyName;
    }

    public void setExamCompanyName(String examCompanyName) {
        this.examCompanyName = examCompanyName;
    }

    public String getCurrentOrgdCode() {
        return currentOrgdCode;
    }

    public void setCurrentOrgdCode(String currentOrgdCode) {
        this.currentOrgdCode = currentOrgdCode;
    }

    public String getCurrentWardCode() {
        return currentWardCode;
    }

    public void setCurrentWardCode(String currentWardCode) {
        this.currentWardCode = currentWardCode;
    }

    @Override
    public String toString() {
        return "PatientInfo{" +
                "patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientType='" + patientType + '\'' +
                ", identityType='" + identityType + '\'' +
                ", identityNum='" + identityNum + '\'' +
                ", visitId='" + visitId + '\'' +
                ", medInstCode='" + medInstCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", exzamFlag='" + exzamFlag + '\'' +
                ", operator='" + operator + '\'' +
                ", paiVisitId='" + paiVisitId + '\'' +
                ", examType='" + examType + '\'' +
                ", examCompanyNo='" + examCompanyNo + '\'' +
                ", examCompanyName='" + examCompanyName + '\'' +
                ", currentOrgdCode='" + currentOrgdCode + '\'' +
                ", currentWardCode='" + currentWardCode + '\'' +
                '}';
    }
}
