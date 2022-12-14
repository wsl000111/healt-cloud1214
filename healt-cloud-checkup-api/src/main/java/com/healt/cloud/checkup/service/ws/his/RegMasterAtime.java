
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>regMasterAtime complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="regMasterAtime"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MasterAtimeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MasterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SortNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TimeQuantumValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TimeLimits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AppointmentLimits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentTimeLimits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentAppointmentLimits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReserveLimits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentReserveLimits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TimeStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegMasterDetailList" type="{http://wegohis.com}regMasterDetail" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "regMasterAtime", propOrder = {
    "masterAtimeId",
    "masterId",
    "sortNo",
    "timeQuantumValue",
    "timeLimits",
    "appointmentLimits",
    "currentTimeLimits",
    "currentAppointmentLimits",
    "reserveLimits",
    "currentReserveLimits",
    "timeStatus",
    "regMasterDetailList"
})
public class RegMasterAtime {

    @XmlElement(name = "MasterAtimeId")
    protected String masterAtimeId;
    @XmlElement(name = "MasterId")
    protected String masterId;
    @XmlElement(name = "SortNo")
    protected String sortNo;
    @XmlElement(name = "TimeQuantumValue")
    protected String timeQuantumValue;
    @XmlElement(name = "TimeLimits")
    protected String timeLimits;
    @XmlElement(name = "AppointmentLimits")
    protected String appointmentLimits;
    @XmlElement(name = "CurrentTimeLimits")
    protected String currentTimeLimits;
    @XmlElement(name = "CurrentAppointmentLimits")
    protected String currentAppointmentLimits;
    @XmlElement(name = "ReserveLimits")
    protected String reserveLimits;
    @XmlElement(name = "CurrentReserveLimits")
    protected String currentReserveLimits;
    @XmlElement(name = "TimeStatus")
    protected String timeStatus;
    @XmlElement(name = "RegMasterDetailList")
    protected List<RegMasterDetail> regMasterDetailList;

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
     * 获取timeQuantumValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeQuantumValue() {
        return timeQuantumValue;
    }

    /**
     * 设置timeQuantumValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeQuantumValue(String value) {
        this.timeQuantumValue = value;
    }

    /**
     * 获取timeLimits属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeLimits() {
        return timeLimits;
    }

    /**
     * 设置timeLimits属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeLimits(String value) {
        this.timeLimits = value;
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
     * 获取currentTimeLimits属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentTimeLimits() {
        return currentTimeLimits;
    }

    /**
     * 设置currentTimeLimits属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentTimeLimits(String value) {
        this.currentTimeLimits = value;
    }

    /**
     * 获取currentAppointmentLimits属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentAppointmentLimits() {
        return currentAppointmentLimits;
    }

    /**
     * 设置currentAppointmentLimits属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentAppointmentLimits(String value) {
        this.currentAppointmentLimits = value;
    }

    /**
     * 获取reserveLimits属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserveLimits() {
        return reserveLimits;
    }

    /**
     * 设置reserveLimits属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserveLimits(String value) {
        this.reserveLimits = value;
    }

    /**
     * 获取currentReserveLimits属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentReserveLimits() {
        return currentReserveLimits;
    }

    /**
     * 设置currentReserveLimits属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentReserveLimits(String value) {
        this.currentReserveLimits = value;
    }

    /**
     * 获取timeStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStatus() {
        return timeStatus;
    }

    /**
     * 设置timeStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStatus(String value) {
        this.timeStatus = value;
    }

    /**
     * Gets the value of the regMasterDetailList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regMasterDetailList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegMasterDetailList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegMasterDetail }
     * 
     * 
     */
    public List<RegMasterDetail> getRegMasterDetailList() {
        if (regMasterDetailList == null) {
            regMasterDetailList = new ArrayList<RegMasterDetail>();
        }
        return this.regMasterDetailList;
    }

}
