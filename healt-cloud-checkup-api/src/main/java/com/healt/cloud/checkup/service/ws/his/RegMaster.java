
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>regMaster complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="regMaster"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MasterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpSpecialId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TitleCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TitleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorSpecial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorPhoto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorSummary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpDurationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpDurationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegistrationLimit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentLimit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AppointmentLimits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AppointmentCurrentLimits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegFeeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClinicFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClinicSpec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AtimeFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MasterStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SortNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegMasterAtimeList" type="{http://wegohis.com}regMasterAtime" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "regMaster", propOrder = {
    "masterId",
    "areaCode",
    "outpDate",
    "outpSpecialId",
    "titleCode",
    "titleName",
    "doctorCode",
    "doctorName",
    "doctorSpecial",
    "doctorPhoto",
    "doctorSummary",
    "outpTypeCode",
    "outpTypeName",
    "outpDurationCode",
    "outpDurationName",
    "registrationLimit",
    "currentLimit",
    "appointmentLimits",
    "appointmentCurrentLimits",
    "regFeeName",
    "regFee",
    "clinicFee",
    "clinicSpec",
    "atimeFlag",
    "masterStatus",
    "currentNo",
    "sortNo",
    "regMasterAtimeList"
})
public class RegMaster {

    @XmlElement(name = "MasterId")
    protected String masterId;
    @XmlElement(name = "AreaCode")
    protected String areaCode;
    @XmlElement(name = "OutpDate")
    protected String outpDate;
    @XmlElement(name = "OutpSpecialId")
    protected String outpSpecialId;
    @XmlElement(name = "TitleCode")
    protected String titleCode;
    @XmlElement(name = "TitleName")
    protected String titleName;
    @XmlElement(name = "DoctorCode")
    protected String doctorCode;
    @XmlElement(name = "DoctorName")
    protected String doctorName;
    @XmlElement(name = "DoctorSpecial")
    protected String doctorSpecial;
    @XmlElement(name = "DoctorPhoto")
    protected String doctorPhoto;
    @XmlElement(name = "DoctorSummary")
    protected String doctorSummary;
    @XmlElement(name = "OutpTypeCode")
    protected String outpTypeCode;
    @XmlElement(name = "OutpTypeName")
    protected String outpTypeName;
    @XmlElement(name = "OutpDurationCode")
    protected String outpDurationCode;
    @XmlElement(name = "OutpDurationName")
    protected String outpDurationName;
    @XmlElement(name = "RegistrationLimit")
    protected String registrationLimit;
    @XmlElement(name = "CurrentLimit")
    protected String currentLimit;
    @XmlElement(name = "AppointmentLimits")
    protected String appointmentLimits;
    @XmlElement(name = "AppointmentCurrentLimits")
    protected String appointmentCurrentLimits;
    @XmlElement(name = "RegFeeName")
    protected String regFeeName;
    @XmlElement(name = "RegFee")
    protected String regFee;
    @XmlElement(name = "ClinicFee")
    protected String clinicFee;
    @XmlElement(name = "ClinicSpec")
    protected String clinicSpec;
    @XmlElement(name = "AtimeFlag")
    protected String atimeFlag;
    @XmlElement(name = "MasterStatus")
    protected String masterStatus;
    @XmlElement(name = "CurrentNo")
    protected String currentNo;
    @XmlElement(name = "SortNo")
    protected String sortNo;
    @XmlElement(name = "RegMasterAtimeList")
    protected List<RegMasterAtime> regMasterAtimeList;

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
     * 获取areaCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置areaCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaCode(String value) {
        this.areaCode = value;
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
     * 获取registrationLimit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationLimit() {
        return registrationLimit;
    }

    /**
     * 设置registrationLimit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationLimit(String value) {
        this.registrationLimit = value;
    }

    /**
     * 获取currentLimit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentLimit() {
        return currentLimit;
    }

    /**
     * 设置currentLimit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentLimit(String value) {
        this.currentLimit = value;
    }

    /**
     * 获取appointmentLimits属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppointmentLimits() {
        return appointmentLimits;
    }

    /**
     * 设置appointmentLimits属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppointmentLimits(String value) {
        this.appointmentLimits = value;
    }

    /**
     * 获取appointmentCurrentLimits属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppointmentCurrentLimits() {
        return appointmentCurrentLimits;
    }

    /**
     * 设置appointmentCurrentLimits属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppointmentCurrentLimits(String value) {
        this.appointmentCurrentLimits = value;
    }

    /**
     * 获取regFeeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegFeeName() {
        return regFeeName;
    }

    /**
     * 设置regFeeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegFeeName(String value) {
        this.regFeeName = value;
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
     * 获取clinicFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClinicFee() {
        return clinicFee;
    }

    /**
     * 设置clinicFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClinicFee(String value) {
        this.clinicFee = value;
    }

    /**
     * 获取clinicSpec属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClinicSpec() {
        return clinicSpec;
    }

    /**
     * 设置clinicSpec属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClinicSpec(String value) {
        this.clinicSpec = value;
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
     * 获取masterStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterStatus() {
        return masterStatus;
    }

    /**
     * 设置masterStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterStatus(String value) {
        this.masterStatus = value;
    }

    /**
     * 获取currentNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentNo() {
        return currentNo;
    }

    /**
     * 设置currentNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentNo(String value) {
        this.currentNo = value;
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
     * Gets the value of the regMasterAtimeList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regMasterAtimeList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegMasterAtimeList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegMasterAtime }
     * 
     * 
     */
    public List<RegMasterAtime> getRegMasterAtimeList() {
        if (regMasterAtimeList == null) {
            regMasterAtimeList = new ArrayList<RegMasterAtime>();
        }
        return this.regMasterAtimeList;
    }

}
