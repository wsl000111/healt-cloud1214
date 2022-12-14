
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>consultingRoomEntity complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="consultingRoomEntity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResideDeptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResideDeptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BelongDeptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BelongDeptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpecialClinicCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpecialClinicName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ConsultingRoom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Floor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultingRoomEntity", propOrder = {
    "resideDeptCode",
    "resideDeptName",
    "belongDeptCode",
    "belongDeptName",
    "specialClinicCode",
    "specialClinicName",
    "location",
    "doctorCode",
    "doctorName",
    "consultingRoom",
    "floor"
})
public class ConsultingRoomEntity {

    @XmlElement(name = "ResideDeptCode")
    protected String resideDeptCode;
    @XmlElement(name = "ResideDeptName")
    protected String resideDeptName;
    @XmlElement(name = "BelongDeptCode")
    protected String belongDeptCode;
    @XmlElement(name = "BelongDeptName")
    protected String belongDeptName;
    @XmlElement(name = "SpecialClinicCode")
    protected String specialClinicCode;
    @XmlElement(name = "SpecialClinicName")
    protected String specialClinicName;
    @XmlElement(name = "Location")
    protected String location;
    @XmlElement(name = "DoctorCode")
    protected String doctorCode;
    @XmlElement(name = "DoctorName")
    protected String doctorName;
    @XmlElement(name = "ConsultingRoom")
    protected String consultingRoom;
    @XmlElement(name = "Floor")
    protected String floor;

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
     * 获取belongDeptCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBelongDeptCode() {
        return belongDeptCode;
    }

    /**
     * 设置belongDeptCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBelongDeptCode(String value) {
        this.belongDeptCode = value;
    }

    /**
     * 获取belongDeptName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBelongDeptName() {
        return belongDeptName;
    }

    /**
     * 设置belongDeptName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBelongDeptName(String value) {
        this.belongDeptName = value;
    }

    /**
     * 获取specialClinicCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialClinicCode() {
        return specialClinicCode;
    }

    /**
     * 设置specialClinicCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialClinicCode(String value) {
        this.specialClinicCode = value;
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
     * 获取location属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置location属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
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
     * 获取consultingRoom属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsultingRoom() {
        return consultingRoom;
    }

    /**
     * 设置consultingRoom属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsultingRoom(String value) {
        this.consultingRoom = value;
    }

    /**
     * 获取floor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFloor() {
        return floor;
    }

    /**
     * 设置floor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFloor(String value) {
        this.floor = value;
    }

}
