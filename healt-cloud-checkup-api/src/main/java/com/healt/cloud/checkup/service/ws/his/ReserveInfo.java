
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>reserveInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="reserveInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReserveId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MasterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AtimeFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TimeQuantum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MasterDetailId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MasterAtimeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegPoolId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SortNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BusinessType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PatientId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PatientName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResideDeptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResideDeptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpSpecialId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpecialClinicName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpecialInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorSummary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorPhoto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SocietyPost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorSpecial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpDurationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpDurationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TitleCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TitleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CredentialsType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CredentialsNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PhoneNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PlatformNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PlatformCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReserveStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegResource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserveInfo", propOrder = {
    "reserveId",
    "masterId",
    "atimeFlag",
    "timeQuantum",
    "masterDetailId",
    "masterAtimeId",
    "regPoolId",
    "sortNo",
    "businessType",
    "patientId",
    "patientName",
    "outpTypeCode",
    "outpTypeName",
    "resideDeptCode",
    "resideDeptName",
    "outpSpecialId",
    "specialClinicName",
    "specialInfo",
    "doctorSummary",
    "doctorPhoto",
    "societyPost",
    "doctorSpecial",
    "regFee",
    "outpDurationCode",
    "outpDurationName",
    "doctorCode",
    "doctorName",
    "titleCode",
    "titleName",
    "credentialsType",
    "credentialsNo",
    "phoneNo",
    "platformNo",
    "platformCode",
    "reserveStatus",
    "regResource",
    "outpTime"
})
public class ReserveInfo {

    @XmlElement(name = "ReserveId")
    protected String reserveId;
    @XmlElement(name = "MasterId")
    protected String masterId;
    @XmlElement(name = "AtimeFlag")
    protected String atimeFlag;
    @XmlElement(name = "TimeQuantum")
    protected String timeQuantum;
    @XmlElement(name = "MasterDetailId")
    protected String masterDetailId;
    @XmlElement(name = "MasterAtimeId")
    protected String masterAtimeId;
    @XmlElement(name = "RegPoolId")
    protected String regPoolId;
    @XmlElement(name = "SortNo")
    protected String sortNo;
    @XmlElement(name = "BusinessType")
    protected String businessType;
    @XmlElement(name = "PatientId")
    protected String patientId;
    @XmlElement(name = "PatientName")
    protected String patientName;
    @XmlElement(name = "OutpTypeCode")
    protected String outpTypeCode;
    @XmlElement(name = "OutpTypeName")
    protected String outpTypeName;
    @XmlElement(name = "ResideDeptCode")
    protected String resideDeptCode;
    @XmlElement(name = "ResideDeptName")
    protected String resideDeptName;
    @XmlElement(name = "OutpSpecialId")
    protected String outpSpecialId;
    @XmlElement(name = "SpecialClinicName")
    protected String specialClinicName;
    @XmlElement(name = "SpecialInfo")
    protected String specialInfo;
    @XmlElement(name = "DoctorSummary")
    protected String doctorSummary;
    @XmlElement(name = "DoctorPhoto")
    protected String doctorPhoto;
    @XmlElement(name = "SocietyPost")
    protected String societyPost;
    @XmlElement(name = "DoctorSpecial")
    protected String doctorSpecial;
    @XmlElement(name = "RegFee")
    protected String regFee;
    @XmlElement(name = "OutpDurationCode")
    protected String outpDurationCode;
    @XmlElement(name = "OutpDurationName")
    protected String outpDurationName;
    @XmlElement(name = "DoctorCode")
    protected String doctorCode;
    @XmlElement(name = "DoctorName")
    protected String doctorName;
    @XmlElement(name = "TitleCode")
    protected String titleCode;
    @XmlElement(name = "TitleName")
    protected String titleName;
    @XmlElement(name = "CredentialsType")
    protected String credentialsType;
    @XmlElement(name = "CredentialsNo")
    protected String credentialsNo;
    @XmlElement(name = "PhoneNo")
    protected String phoneNo;
    @XmlElement(name = "PlatformNo")
    protected String platformNo;
    @XmlElement(name = "PlatformCode")
    protected String platformCode;
    @XmlElement(name = "ReserveStatus")
    protected String reserveStatus;
    @XmlElement(name = "RegResource")
    protected String regResource;
    @XmlElement(name = "OutpTime")
    protected String outpTime;

    /**
     * 获取reserveId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserveId() {
        return reserveId;
    }

    /**
     * 设置reserveId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserveId(String value) {
        this.reserveId = value;
    }

    /**
     * 获取masterId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterId() {
        return masterId;
    }

    /**
     * 设置masterId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterId(String value) {
        this.masterId = value;
    }

    /**
     * 获取atimeFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAtimeFlag() {
        return atimeFlag;
    }

    /**
     * 设置atimeFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAtimeFlag(String value) {
        this.atimeFlag = value;
    }

    /**
     * 获取timeQuantum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeQuantum() {
        return timeQuantum;
    }

    /**
     * 设置timeQuantum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeQuantum(String value) {
        this.timeQuantum = value;
    }

    /**
     * 获取masterDetailId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterDetailId() {
        return masterDetailId;
    }

    /**
     * 设置masterDetailId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterDetailId(String value) {
        this.masterDetailId = value;
    }

    /**
     * 获取masterAtimeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterAtimeId() {
        return masterAtimeId;
    }

    /**
     * 设置masterAtimeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterAtimeId(String value) {
        this.masterAtimeId = value;
    }

    /**
     * 获取regPoolId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegPoolId() {
        return regPoolId;
    }

    /**
     * 设置regPoolId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegPoolId(String value) {
        this.regPoolId = value;
    }

    /**
     * 获取sortNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortNo() {
        return sortNo;
    }

    /**
     * 设置sortNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortNo(String value) {
        this.sortNo = value;
    }

    /**
     * 获取businessType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 设置businessType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessType(String value) {
        this.businessType = value;
    }

    /**
     * 获取patientId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * 设置patientId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientId(String value) {
        this.patientId = value;
    }

    /**
     * 获取patientName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * 设置patientName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientName(String value) {
        this.patientName = value;
    }

    /**
     * 获取outpTypeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpTypeCode() {
        return outpTypeCode;
    }

    /**
     * 设置outpTypeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpTypeCode(String value) {
        this.outpTypeCode = value;
    }

    /**
     * 获取outpTypeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpTypeName() {
        return outpTypeName;
    }

    /**
     * 设置outpTypeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpTypeName(String value) {
        this.outpTypeName = value;
    }

    /**
     * 获取resideDeptCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResideDeptCode() {
        return resideDeptCode;
    }

    /**
     * 设置resideDeptCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResideDeptCode(String value) {
        this.resideDeptCode = value;
    }

    /**
     * 获取resideDeptName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResideDeptName() {
        return resideDeptName;
    }

    /**
     * 设置resideDeptName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResideDeptName(String value) {
        this.resideDeptName = value;
    }

    /**
     * 获取outpSpecialId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpSpecialId() {
        return outpSpecialId;
    }

    /**
     * 设置outpSpecialId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpSpecialId(String value) {
        this.outpSpecialId = value;
    }

    /**
     * 获取specialClinicName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialClinicName() {
        return specialClinicName;
    }

    /**
     * 设置specialClinicName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialClinicName(String value) {
        this.specialClinicName = value;
    }

    /**
     * 获取specialInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialInfo() {
        return specialInfo;
    }

    /**
     * 设置specialInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialInfo(String value) {
        this.specialInfo = value;
    }

    /**
     * 获取doctorSummary属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoctorSummary() {
        return doctorSummary;
    }

    /**
     * 设置doctorSummary属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoctorSummary(String value) {
        this.doctorSummary = value;
    }

    /**
     * 获取doctorPhoto属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoctorPhoto() {
        return doctorPhoto;
    }

    /**
     * 设置doctorPhoto属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoctorPhoto(String value) {
        this.doctorPhoto = value;
    }

    /**
     * 获取societyPost属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSocietyPost() {
        return societyPost;
    }

    /**
     * 设置societyPost属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSocietyPost(String value) {
        this.societyPost = value;
    }

    /**
     * 获取doctorSpecial属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoctorSpecial() {
        return doctorSpecial;
    }

    /**
     * 设置doctorSpecial属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoctorSpecial(String value) {
        this.doctorSpecial = value;
    }

    /**
     * 获取regFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegFee() {
        return regFee;
    }

    /**
     * 设置regFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegFee(String value) {
        this.regFee = value;
    }

    /**
     * 获取outpDurationCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpDurationCode() {
        return outpDurationCode;
    }

    /**
     * 设置outpDurationCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpDurationCode(String value) {
        this.outpDurationCode = value;
    }

    /**
     * 获取outpDurationName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpDurationName() {
        return outpDurationName;
    }

    /**
     * 设置outpDurationName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpDurationName(String value) {
        this.outpDurationName = value;
    }

    /**
     * 获取doctorCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoctorCode() {
        return doctorCode;
    }

    /**
     * 设置doctorCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoctorCode(String value) {
        this.doctorCode = value;
    }

    /**
     * 获取doctorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * 设置doctorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoctorName(String value) {
        this.doctorName = value;
    }

    /**
     * 获取titleCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitleCode() {
        return titleCode;
    }

    /**
     * 设置titleCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitleCode(String value) {
        this.titleCode = value;
    }

    /**
     * 获取titleName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitleName() {
        return titleName;
    }

    /**
     * 设置titleName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitleName(String value) {
        this.titleName = value;
    }

    /**
     * 获取credentialsType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCredentialsType() {
        return credentialsType;
    }

    /**
     * 设置credentialsType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCredentialsType(String value) {
        this.credentialsType = value;
    }

    /**
     * 获取credentialsNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCredentialsNo() {
        return credentialsNo;
    }

    /**
     * 设置credentialsNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCredentialsNo(String value) {
        this.credentialsNo = value;
    }

    /**
     * 获取phoneNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 设置phoneNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNo(String value) {
        this.phoneNo = value;
    }

    /**
     * 获取platformNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatformNo() {
        return platformNo;
    }

    /**
     * 设置platformNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatformNo(String value) {
        this.platformNo = value;
    }

    /**
     * 获取platformCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatformCode() {
        return platformCode;
    }

    /**
     * 设置platformCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatformCode(String value) {
        this.platformCode = value;
    }

    /**
     * 获取reserveStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserveStatus() {
        return reserveStatus;
    }

    /**
     * 设置reserveStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserveStatus(String value) {
        this.reserveStatus = value;
    }

    /**
     * 获取regResource属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegResource() {
        return regResource;
    }

    /**
     * 设置regResource属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegResource(String value) {
        this.regResource = value;
    }

    /**
     * 获取outpTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpTime() {
        return outpTime;
    }

    /**
     * 设置outpTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpTime(String value) {
        this.outpTime = value;
    }

}
