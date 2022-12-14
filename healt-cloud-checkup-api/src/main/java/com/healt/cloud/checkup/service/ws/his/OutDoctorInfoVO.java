
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>outDoctorInfoVO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="outDoctorInfoVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpcecialClinicCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpcecialClinicName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TitleCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TitleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorSpecial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorSummary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpDurationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpDurationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorPhoto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpClinicFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "outDoctorInfoVO", propOrder = {
    "areaCode",
    "medInstCode",
    "spcecialClinicCode",
    "spcecialClinicName",
    "titleCode",
    "titleName",
    "doctorCode",
    "doctorName",
    "doctorSpecial",
    "doctorSummary",
    "outpTypeCode",
    "outpTypeName",
    "outpDurationCode",
    "outpDurationName",
    "doctorPhoto",
    "outpClinicFee",
    "isEnable"
})
public class OutDoctorInfoVO {

    @XmlElement(name = "AreaCode")
    protected String areaCode;
    @XmlElement(name = "MedInstCode")
    protected String medInstCode;
    @XmlElement(name = "SpcecialClinicCode")
    protected String spcecialClinicCode;
    @XmlElement(name = "SpcecialClinicName")
    protected String spcecialClinicName;
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
    @XmlElement(name = "DoctorPhoto")
    protected String doctorPhoto;
    @XmlElement(name = "OutpClinicFee")
    protected String outpClinicFee;
    @XmlElement(name = "IsEnable")
    protected String isEnable;

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
     * 获取medInstCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstCode() {
        return medInstCode;
    }

    /**
     * 设置medInstCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstCode(String value) {
        this.medInstCode = value;
    }

    /**
     * 获取spcecialClinicCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpcecialClinicCode() {
        return spcecialClinicCode;
    }

    /**
     * 设置spcecialClinicCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpcecialClinicCode(String value) {
        this.spcecialClinicCode = value;
    }

    /**
     * 获取spcecialClinicName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpcecialClinicName() {
        return spcecialClinicName;
    }

    /**
     * 设置spcecialClinicName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpcecialClinicName(String value) {
        this.spcecialClinicName = value;
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
     * 获取outpClinicFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpClinicFee() {
        return outpClinicFee;
    }

    /**
     * 设置outpClinicFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpClinicFee(String value) {
        this.outpClinicFee = value;
    }

    /**
     * 获取isEnable属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 设置isEnable属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsEnable(String value) {
        this.isEnable = value;
    }

}
