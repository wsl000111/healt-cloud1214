
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bcsUumUser complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bcsUumUser"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PeopleClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PeopleClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PeopleIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PeopleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WorkDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WorkDeptName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="WorkPost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WorkPostName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WorkProfessional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WorkProfessionalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Mobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StatusName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Expires" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ModifyTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WbCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Duty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DutyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IdNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Employed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bcsUumUser", propOrder = {
    "userName",
    "peopleClass",
    "peopleClassName",
    "peopleIdentifier",
    "peopleName",
    "workDept",
    "workDeptName",
    "workPost",
    "workPostName",
    "workProfessional",
    "workProfessionalName",
    "mobile",
    "status",
    "statusName",
    "expires",
    "modifyTime",
    "pyCode",
    "wbCode",
    "duty",
    "dutyName",
    "idNo",
    "employed"
})
public class BcsUumUser {

    @XmlElement(name = "UserName")
    protected String userName;
    @XmlElement(name = "PeopleClass")
    protected String peopleClass;
    @XmlElement(name = "PeopleClassName")
    protected String peopleClassName;
    @XmlElement(name = "PeopleIdentifier")
    protected String peopleIdentifier;
    @XmlElement(name = "PeopleName")
    protected String peopleName;
    @XmlElement(name = "WorkDept")
    protected String workDept;
    @XmlElement(name = "WorkDeptName", required = true)
    protected String workDeptName;
    @XmlElement(name = "WorkPost")
    protected String workPost;
    @XmlElement(name = "WorkPostName")
    protected String workPostName;
    @XmlElement(name = "WorkProfessional")
    protected String workProfessional;
    @XmlElement(name = "WorkProfessionalName")
    protected String workProfessionalName;
    @XmlElement(name = "Mobile")
    protected String mobile;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "StatusName")
    protected String statusName;
    @XmlElement(name = "Expires")
    protected String expires;
    @XmlElement(name = "ModifyTime")
    protected String modifyTime;
    @XmlElement(name = "PyCode")
    protected String pyCode;
    @XmlElement(name = "WbCode")
    protected String wbCode;
    @XmlElement(name = "Duty")
    protected String duty;
    @XmlElement(name = "DutyName")
    protected String dutyName;
    @XmlElement(name = "IdNo")
    protected String idNo;
    @XmlElement(name = "Employed")
    protected String employed;

    /**
     * 获取userName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置userName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * 获取peopleClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeopleClass() {
        return peopleClass;
    }

    /**
     * 设置peopleClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeopleClass(String value) {
        this.peopleClass = value;
    }

    /**
     * 获取peopleClassName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeopleClassName() {
        return peopleClassName;
    }

    /**
     * 设置peopleClassName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeopleClassName(String value) {
        this.peopleClassName = value;
    }

    /**
     * 获取peopleIdentifier属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeopleIdentifier() {
        return peopleIdentifier;
    }

    /**
     * 设置peopleIdentifier属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeopleIdentifier(String value) {
        this.peopleIdentifier = value;
    }

    /**
     * 获取peopleName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeopleName() {
        return peopleName;
    }

    /**
     * 设置peopleName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeopleName(String value) {
        this.peopleName = value;
    }

    /**
     * 获取workDept属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkDept() {
        return workDept;
    }

    /**
     * 设置workDept属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkDept(String value) {
        this.workDept = value;
    }

    /**
     * 获取workDeptName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkDeptName() {
        return workDeptName;
    }

    /**
     * 设置workDeptName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkDeptName(String value) {
        this.workDeptName = value;
    }

    /**
     * 获取workPost属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkPost() {
        return workPost;
    }

    /**
     * 设置workPost属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkPost(String value) {
        this.workPost = value;
    }

    /**
     * 获取workPostName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkPostName() {
        return workPostName;
    }

    /**
     * 设置workPostName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkPostName(String value) {
        this.workPostName = value;
    }

    /**
     * 获取workProfessional属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkProfessional() {
        return workProfessional;
    }

    /**
     * 设置workProfessional属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkProfessional(String value) {
        this.workProfessional = value;
    }

    /**
     * 获取workProfessionalName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkProfessionalName() {
        return workProfessionalName;
    }

    /**
     * 设置workProfessionalName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkProfessionalName(String value) {
        this.workProfessionalName = value;
    }

    /**
     * 获取mobile属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置mobile属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * 获取statusName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusName() {
        return statusName;
    }

    /**
     * 设置statusName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusName(String value) {
        this.statusName = value;
    }

    /**
     * 获取expires属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpires() {
        return expires;
    }

    /**
     * 设置expires属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpires(String value) {
        this.expires = value;
    }

    /**
     * 获取modifyTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置modifyTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifyTime(String value) {
        this.modifyTime = value;
    }

    /**
     * 获取pyCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPyCode() {
        return pyCode;
    }

    /**
     * 设置pyCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPyCode(String value) {
        this.pyCode = value;
    }

    /**
     * 获取wbCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWbCode() {
        return wbCode;
    }

    /**
     * 设置wbCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWbCode(String value) {
        this.wbCode = value;
    }

    /**
     * 获取duty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuty() {
        return duty;
    }

    /**
     * 设置duty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuty(String value) {
        this.duty = value;
    }

    /**
     * 获取dutyName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDutyName() {
        return dutyName;
    }

    /**
     * 设置dutyName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDutyName(String value) {
        this.dutyName = value;
    }

    /**
     * 获取idNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * 设置idNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdNo(String value) {
        this.idNo = value;
    }

    /**
     * 获取employed属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployed() {
        return employed;
    }

    /**
     * 设置employed属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployed(String value) {
        this.employed = value;
    }

    @Override
    public String toString() {
        return "BcsUumUser{" +
                "userName='" + userName + '\'' +
                ", peopleClass='" + peopleClass + '\'' +
                ", peopleClassName='" + peopleClassName + '\'' +
                ", peopleIdentifier='" + peopleIdentifier + '\'' +
                ", peopleName='" + peopleName + '\'' +
                ", workDept='" + workDept + '\'' +
                ", workDeptName='" + workDeptName + '\'' +
                ", workPost='" + workPost + '\'' +
                ", workPostName='" + workPostName + '\'' +
                ", workProfessional='" + workProfessional + '\'' +
                ", workProfessionalName='" + workProfessionalName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status='" + status + '\'' +
                ", statusName='" + statusName + '\'' +
                ", expires='" + expires + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                ", pyCode='" + pyCode + '\'' +
                ", wbCode='" + wbCode + '\'' +
                ", duty='" + duty + '\'' +
                ", dutyName='" + dutyName + '\'' +
                ", idNo='" + idNo + '\'' +
                ", employed='" + employed + '\'' +
                '}';
    }
}
