
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>specialClinic complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="specialClinic"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResideDeptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResideDeptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpSpecialID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BillFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SortNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BelongDeptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BelongDeptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpecialClinicCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpecialClinicName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SelfRegisterFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WebFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpecialFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RealNameFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StopRegAM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StopRegPM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpecialInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorSummary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoctorPhoto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SocietyPost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "specialClinic", propOrder = {
    "resideDeptCode",
    "resideDeptName",
    "outpSpecialID",
    "location",
    "billFlag",
    "sortNo",
    "belongDeptCode",
    "belongDeptName",
    "specialClinicCode",
    "specialClinicName",
    "selfRegisterFlag",
    "areaCode",
    "webFlag",
    "specialFlag",
    "realNameFlag",
    "stopRegAM",
    "stopRegPM",
    "specialInfo",
    "doctorSummary",
    "doctorPhoto",
    "societyPost"
})
public class SpecialClinic {

    @XmlElement(name = "ResideDeptCode")
    protected String resideDeptCode;
    @XmlElement(name = "ResideDeptName")
    protected String resideDeptName;
    @XmlElement(name = "OutpSpecialID")
    protected String outpSpecialID;
    @XmlElement(name = "Location")
    protected String location;
    @XmlElement(name = "BillFlag")
    protected String billFlag;
    @XmlElement(name = "SortNo")
    protected String sortNo;
    @XmlElement(name = "BelongDeptCode")
    protected String belongDeptCode;
    @XmlElement(name = "BelongDeptName")
    protected String belongDeptName;
    @XmlElement(name = "SpecialClinicCode")
    protected String specialClinicCode;
    @XmlElement(name = "SpecialClinicName")
    protected String specialClinicName;
    @XmlElement(name = "SelfRegisterFlag")
    protected String selfRegisterFlag;
    @XmlElement(name = "AreaCode")
    protected String areaCode;
    @XmlElement(name = "WebFlag")
    protected String webFlag;
    @XmlElement(name = "SpecialFlag")
    protected String specialFlag;
    @XmlElement(name = "RealNameFlag")
    protected String realNameFlag;
    @XmlElement(name = "StopRegAM")
    protected String stopRegAM;
    @XmlElement(name = "StopRegPM")
    protected String stopRegPM;
    @XmlElement(name = "SpecialInfo")
    protected String specialInfo;
    @XmlElement(name = "DoctorSummary")
    protected String doctorSummary;
    @XmlElement(name = "DoctorPhoto")
    protected String doctorPhoto;
    @XmlElement(name = "SocietyPost")
    protected String societyPost;

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
     * 获取outpSpecialID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpSpecialID() {
        return outpSpecialID;
    }

    /**
     * 设置outpSpecialID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpSpecialID(String value) {
        this.outpSpecialID = value;
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
     * 获取billFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillFlag() {
        return billFlag;
    }

    /**
     * 设置billFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillFlag(String value) {
        this.billFlag = value;
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
     * 获取selfRegisterFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelfRegisterFlag() {
        return selfRegisterFlag;
    }

    /**
     * 设置selfRegisterFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelfRegisterFlag(String value) {
        this.selfRegisterFlag = value;
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
     * 获取webFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebFlag() {
        return webFlag;
    }

    /**
     * 设置webFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebFlag(String value) {
        this.webFlag = value;
    }

    /**
     * 获取specialFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialFlag() {
        return specialFlag;
    }

    /**
     * 设置specialFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialFlag(String value) {
        this.specialFlag = value;
    }

    /**
     * 获取realNameFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRealNameFlag() {
        return realNameFlag;
    }

    /**
     * 设置realNameFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRealNameFlag(String value) {
        this.realNameFlag = value;
    }

    /**
     * 获取stopRegAM属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopRegAM() {
        return stopRegAM;
    }

    /**
     * 设置stopRegAM属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopRegAM(String value) {
        this.stopRegAM = value;
    }

    /**
     * 获取stopRegPM属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopRegPM() {
        return stopRegPM;
    }

    /**
     * 设置stopRegPM属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopRegPM(String value) {
        this.stopRegPM = value;
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

}
