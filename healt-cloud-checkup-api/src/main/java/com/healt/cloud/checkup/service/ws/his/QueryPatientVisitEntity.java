
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>queryPatientVisitEntity complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="queryPatientVisitEntity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PatientVisitId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="RekINo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="RekId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="RegSortNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="VisitId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="PatientId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PatientName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpSpecialId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="OutpSpecialName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResideDeptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResideDeptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpDurationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdmiDoctorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdmiDoctorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegResource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryPatientVisitEntity", propOrder = {
    "patientVisitId",
    "rekINo",
    "rekId",
    "regSortNo",
    "visitId",
    "patientId",
    "patientName",
    "outpDate",
    "outpSpecialId",
    "outpSpecialName",
    "resideDeptCode",
    "resideDeptName",
    "outpDurationCode",
    "doctorName",
    "outpTypeName",
    "regFlag",
    "regDate",
    "admiDoctorCode",
    "admiDoctorName",
    "regResource"
})
public class QueryPatientVisitEntity {

    @XmlElement(name = "PatientVisitId")
    protected Long patientVisitId;
    @XmlElement(name = "RekINo")
    protected Long rekINo;
    @XmlElement(name = "RekId")
    protected Long rekId;
    @XmlElement(name = "RegSortNo")
    protected Long regSortNo;
    @XmlElement(name = "VisitId")
    protected Long visitId;
    @XmlElement(name = "PatientId")
    protected String patientId;
    @XmlElement(name = "PatientName")
    protected String patientName;
    @XmlElement(name = "OutpDate")
    protected String outpDate;
    @XmlElement(name = "OutpSpecialId")
    protected Long outpSpecialId;
    @XmlElement(name = "OutpSpecialName")
    protected String outpSpecialName;
    @XmlElement(name = "ResideDeptCode")
    protected String resideDeptCode;
    @XmlElement(name = "ResideDeptName")
    protected String resideDeptName;
    @XmlElement(name = "OutpDurationCode")
    protected String outpDurationCode;
    @XmlElement(name = "DoctorName")
    protected String doctorName;
    @XmlElement(name = "OutpTypeName")
    protected String outpTypeName;
    @XmlElement(name = "RegFlag")
    protected String regFlag;
    @XmlElement(name = "RegDate")
    protected String regDate;
    @XmlElement(name = "AdmiDoctorCode")
    protected String admiDoctorCode;
    @XmlElement(name = "AdmiDoctorName")
    protected String admiDoctorName;
    @XmlElement(name = "RegResource")
    protected String regResource;

    /**
     * 获取patientVisitId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPatientVisitId() {
        return patientVisitId;
    }

    /**
     * 设置patientVisitId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPatientVisitId(Long value) {
        this.patientVisitId = value;
    }

    /**
     * 获取rekINo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRekINo() {
        return rekINo;
    }

    /**
     * 设置rekINo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRekINo(Long value) {
        this.rekINo = value;
    }

    /**
     * 获取rekId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRekId() {
        return rekId;
    }

    /**
     * 设置rekId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRekId(Long value) {
        this.rekId = value;
    }

    /**
     * 获取regSortNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRegSortNo() {
        return regSortNo;
    }

    /**
     * 设置regSortNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRegSortNo(Long value) {
        this.regSortNo = value;
    }

    /**
     * 获取visitId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVisitId() {
        return visitId;
    }

    /**
     * 设置visitId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVisitId(Long value) {
        this.visitId = value;
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
     * 获取outpDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpDate() {
        return outpDate;
    }

    /**
     * 设置outpDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpDate(String value) {
        this.outpDate = value;
    }

    /**
     * 获取outpSpecialId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOutpSpecialId() {
        return outpSpecialId;
    }

    /**
     * 设置outpSpecialId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOutpSpecialId(Long value) {
        this.outpSpecialId = value;
    }

    /**
     * 获取outpSpecialName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpSpecialName() {
        return outpSpecialName;
    }

    /**
     * 设置outpSpecialName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpSpecialName(String value) {
        this.outpSpecialName = value;
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
     * 获取regFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegFlag() {
        return regFlag;
    }

    /**
     * 设置regFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegFlag(String value) {
        this.regFlag = value;
    }

    /**
     * 获取regDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegDate() {
        return regDate;
    }

    /**
     * 设置regDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegDate(String value) {
        this.regDate = value;
    }

    /**
     * 获取admiDoctorCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmiDoctorCode() {
        return admiDoctorCode;
    }

    /**
     * 设置admiDoctorCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmiDoctorCode(String value) {
        this.admiDoctorCode = value;
    }

    /**
     * 获取admiDoctorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmiDoctorName() {
        return admiDoctorName;
    }

    /**
     * 设置admiDoctorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmiDoctorName(String value) {
        this.admiDoctorName = value;
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

}
