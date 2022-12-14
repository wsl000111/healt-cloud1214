
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>diagnosticsQueryEntity complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="diagnosticsQueryEntity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SortNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="DiagIcd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DiagName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DiagTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DiagDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DiagEmpCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DiagEmpName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrgIdInput" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrgNameInput" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DiagAttri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MainDiag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TcmSyndromeTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TcmSyndromeTypeCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="AdmissionCond" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DischargeStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DiagClassTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MorbidityDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReturnVisit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diagnosticsQueryEntity", propOrder = {
    "sortNo",
    "diagIcd",
    "diagName",
    "diagTypeCode",
    "diagDate",
    "diagEmpCode",
    "diagEmpName",
    "orgIdInput",
    "orgNameInput",
    "diagAttri",
    "mainDiag",
    "tcmSyndromeTypeName",
    "tcmSyndromeTypeCode",
    "admissionCond",
    "dischargeStatus",
    "diagClassTypeCode",
    "morbidityDate",
    "returnVisit"
})
public class DiagnosticsQueryEntity {

    @XmlElement(name = "SortNo")
    protected Long sortNo;
    @XmlElement(name = "DiagIcd")
    protected String diagIcd;
    @XmlElement(name = "DiagName")
    protected String diagName;
    @XmlElement(name = "DiagTypeCode")
    protected String diagTypeCode;
    @XmlElement(name = "DiagDate")
    protected String diagDate;
    @XmlElement(name = "DiagEmpCode")
    protected String diagEmpCode;
    @XmlElement(name = "DiagEmpName")
    protected String diagEmpName;
    @XmlElement(name = "OrgIdInput")
    protected String orgIdInput;
    @XmlElement(name = "OrgNameInput")
    protected String orgNameInput;
    @XmlElement(name = "DiagAttri")
    protected String diagAttri;
    @XmlElement(name = "MainDiag")
    protected String mainDiag;
    @XmlElement(name = "TcmSyndromeTypeName")
    protected String tcmSyndromeTypeName;
    @XmlElement(name = "TcmSyndromeTypeCode")
    protected Long tcmSyndromeTypeCode;
    @XmlElement(name = "AdmissionCond")
    protected String admissionCond;
    @XmlElement(name = "DischargeStatus")
    protected String dischargeStatus;
    @XmlElement(name = "DiagClassTypeCode")
    protected String diagClassTypeCode;
    @XmlElement(name = "MorbidityDate")
    protected String morbidityDate;
    @XmlElement(name = "ReturnVisit")
    protected String returnVisit;

    /**
     * 获取sortNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSortNo() {
        return sortNo;
    }

    /**
     * 设置sortNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSortNo(Long value) {
        this.sortNo = value;
    }

    /**
     * 获取diagIcd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagIcd() {
        return diagIcd;
    }

    /**
     * 设置diagIcd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagIcd(String value) {
        this.diagIcd = value;
    }

    /**
     * 获取diagName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagName() {
        return diagName;
    }

    /**
     * 设置diagName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagName(String value) {
        this.diagName = value;
    }

    /**
     * 获取diagTypeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagTypeCode() {
        return diagTypeCode;
    }

    /**
     * 设置diagTypeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagTypeCode(String value) {
        this.diagTypeCode = value;
    }

    /**
     * 获取diagDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagDate() {
        return diagDate;
    }

    /**
     * 设置diagDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagDate(String value) {
        this.diagDate = value;
    }

    /**
     * 获取diagEmpCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagEmpCode() {
        return diagEmpCode;
    }

    /**
     * 设置diagEmpCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagEmpCode(String value) {
        this.diagEmpCode = value;
    }

    /**
     * 获取diagEmpName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagEmpName() {
        return diagEmpName;
    }

    /**
     * 设置diagEmpName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagEmpName(String value) {
        this.diagEmpName = value;
    }

    /**
     * 获取orgIdInput属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgIdInput() {
        return orgIdInput;
    }

    /**
     * 设置orgIdInput属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgIdInput(String value) {
        this.orgIdInput = value;
    }

    /**
     * 获取orgNameInput属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgNameInput() {
        return orgNameInput;
    }

    /**
     * 设置orgNameInput属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgNameInput(String value) {
        this.orgNameInput = value;
    }

    /**
     * 获取diagAttri属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagAttri() {
        return diagAttri;
    }

    /**
     * 设置diagAttri属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagAttri(String value) {
        this.diagAttri = value;
    }

    /**
     * 获取mainDiag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainDiag() {
        return mainDiag;
    }

    /**
     * 设置mainDiag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainDiag(String value) {
        this.mainDiag = value;
    }

    /**
     * 获取tcmSyndromeTypeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTcmSyndromeTypeName() {
        return tcmSyndromeTypeName;
    }

    /**
     * 设置tcmSyndromeTypeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTcmSyndromeTypeName(String value) {
        this.tcmSyndromeTypeName = value;
    }

    /**
     * 获取tcmSyndromeTypeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTcmSyndromeTypeCode() {
        return tcmSyndromeTypeCode;
    }

    /**
     * 设置tcmSyndromeTypeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTcmSyndromeTypeCode(Long value) {
        this.tcmSyndromeTypeCode = value;
    }

    /**
     * 获取admissionCond属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmissionCond() {
        return admissionCond;
    }

    /**
     * 设置admissionCond属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmissionCond(String value) {
        this.admissionCond = value;
    }

    /**
     * 获取dischargeStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDischargeStatus() {
        return dischargeStatus;
    }

    /**
     * 设置dischargeStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDischargeStatus(String value) {
        this.dischargeStatus = value;
    }

    /**
     * 获取diagClassTypeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagClassTypeCode() {
        return diagClassTypeCode;
    }

    /**
     * 设置diagClassTypeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagClassTypeCode(String value) {
        this.diagClassTypeCode = value;
    }

    /**
     * 获取morbidityDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMorbidityDate() {
        return morbidityDate;
    }

    /**
     * 设置morbidityDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMorbidityDate(String value) {
        this.morbidityDate = value;
    }

    /**
     * 获取returnVisit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnVisit() {
        return returnVisit;
    }

    /**
     * 设置returnVisit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnVisit(String value) {
        this.returnVisit = value;
    }

}
