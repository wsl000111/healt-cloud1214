
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>queryScheduling complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="queryScheduling"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ApplyNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AppointmentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AppointmentAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DialysisArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BedCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SchedulingType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SchedulingId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DialysisId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TreatmentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TreatmentClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TreatmentWeek" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DialysisScheme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DialyzerMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PurifierMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PlannedDuration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CoagulationDrugs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SchedulingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryScheduling", propOrder = {
    "applyNo",
    "appointmentDate",
    "appointmentAmount",
    "dialysisArea",
    "bedCode",
    "schedulingType",
    "schedulingId",
    "dialysisId",
    "treatmentDate",
    "treatmentClass",
    "treatmentWeek",
    "dialysisScheme",
    "dialyzerMode",
    "purifierMode",
    "plannedDuration",
    "coagulationDrugs",
    "doctorCode",
    "doctorName",
    "schedulingDate"
})
public class QueryScheduling {

    @XmlElement(name = "ApplyNo")
    protected String applyNo;
    @XmlElement(name = "AppointmentDate")
    protected String appointmentDate;
    @XmlElement(name = "AppointmentAmount")
    protected String appointmentAmount;
    @XmlElement(name = "DialysisArea")
    protected String dialysisArea;
    @XmlElement(name = "BedCode")
    protected String bedCode;
    @XmlElement(name = "SchedulingType")
    protected String schedulingType;
    @XmlElement(name = "SchedulingId")
    protected String schedulingId;
    @XmlElement(name = "DialysisId")
    protected String dialysisId;
    @XmlElement(name = "TreatmentDate")
    protected String treatmentDate;
    @XmlElement(name = "TreatmentClass")
    protected String treatmentClass;
    @XmlElement(name = "TreatmentWeek")
    protected String treatmentWeek;
    @XmlElement(name = "DialysisScheme")
    protected String dialysisScheme;
    @XmlElement(name = "DialyzerMode")
    protected String dialyzerMode;
    @XmlElement(name = "PurifierMode")
    protected String purifierMode;
    @XmlElement(name = "PlannedDuration")
    protected String plannedDuration;
    @XmlElement(name = "CoagulationDrugs")
    protected String coagulationDrugs;
    @XmlElement(name = "DoctorCode")
    protected String doctorCode;
    @XmlElement(name = "DoctorName")
    protected String doctorName;
    @XmlElement(name = "SchedulingDate")
    protected String schedulingDate;

    /**
     * 获取applyNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyNo() {
        return applyNo;
    }

    /**
     * 设置applyNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyNo(String value) {
        this.applyNo = value;
    }

    /**
     * 获取appointmentDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * 设置appointmentDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppointmentDate(String value) {
        this.appointmentDate = value;
    }

    /**
     * 获取appointmentAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppointmentAmount() {
        return appointmentAmount;
    }

    /**
     * 设置appointmentAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppointmentAmount(String value) {
        this.appointmentAmount = value;
    }

    /**
     * 获取dialysisArea属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDialysisArea() {
        return dialysisArea;
    }

    /**
     * 设置dialysisArea属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDialysisArea(String value) {
        this.dialysisArea = value;
    }

    /**
     * 获取bedCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedCode() {
        return bedCode;
    }

    /**
     * 设置bedCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedCode(String value) {
        this.bedCode = value;
    }

    /**
     * 获取schedulingType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchedulingType() {
        return schedulingType;
    }

    /**
     * 设置schedulingType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchedulingType(String value) {
        this.schedulingType = value;
    }

    /**
     * 获取schedulingId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchedulingId() {
        return schedulingId;
    }

    /**
     * 设置schedulingId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchedulingId(String value) {
        this.schedulingId = value;
    }

    /**
     * 获取dialysisId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDialysisId() {
        return dialysisId;
    }

    /**
     * 设置dialysisId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDialysisId(String value) {
        this.dialysisId = value;
    }

    /**
     * 获取treatmentDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTreatmentDate() {
        return treatmentDate;
    }

    /**
     * 设置treatmentDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTreatmentDate(String value) {
        this.treatmentDate = value;
    }

    /**
     * 获取treatmentClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTreatmentClass() {
        return treatmentClass;
    }

    /**
     * 设置treatmentClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTreatmentClass(String value) {
        this.treatmentClass = value;
    }

    /**
     * 获取treatmentWeek属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTreatmentWeek() {
        return treatmentWeek;
    }

    /**
     * 设置treatmentWeek属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTreatmentWeek(String value) {
        this.treatmentWeek = value;
    }

    /**
     * 获取dialysisScheme属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDialysisScheme() {
        return dialysisScheme;
    }

    /**
     * 设置dialysisScheme属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDialysisScheme(String value) {
        this.dialysisScheme = value;
    }

    /**
     * 获取dialyzerMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDialyzerMode() {
        return dialyzerMode;
    }

    /**
     * 设置dialyzerMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDialyzerMode(String value) {
        this.dialyzerMode = value;
    }

    /**
     * 获取purifierMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurifierMode() {
        return purifierMode;
    }

    /**
     * 设置purifierMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurifierMode(String value) {
        this.purifierMode = value;
    }

    /**
     * 获取plannedDuration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlannedDuration() {
        return plannedDuration;
    }

    /**
     * 设置plannedDuration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlannedDuration(String value) {
        this.plannedDuration = value;
    }

    /**
     * 获取coagulationDrugs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoagulationDrugs() {
        return coagulationDrugs;
    }

    /**
     * 设置coagulationDrugs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoagulationDrugs(String value) {
        this.coagulationDrugs = value;
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
     * 获取schedulingDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchedulingDate() {
        return schedulingDate;
    }

    /**
     * 设置schedulingDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchedulingDate(String value) {
        this.schedulingDate = value;
    }

}
