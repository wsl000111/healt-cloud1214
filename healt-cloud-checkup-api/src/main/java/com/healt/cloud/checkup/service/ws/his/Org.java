
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>org complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="org"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrgId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="ParentId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="ParentCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AliasName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrgCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="OrgType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WbCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Supervisor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SortNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="AreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedicalTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CicDetailType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccountUnitCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccountUnitName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsEmergency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsPaed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "org", propOrder = {
    "orgId",
    "parentId",
    "parentCode",
    "orgName",
    "aliasName",
    "orgCode",
    "orgType",
    "isEnable",
    "address",
    "phone",
    "pyCode",
    "wbCode",
    "supervisor",
    "sortNo",
    "areaCode",
    "medicalTypeCode",
    "cicDetailType",
    "accountUnitCode",
    "accountUnitName",
    "isEmergency",
    "isPaed"
})
public class Org {

    @XmlElement(name = "OrgId")
    protected long orgId;
    @XmlElement(name = "ParentId")
    protected Long parentId;
    @XmlElement(name = "ParentCode")
    protected String parentCode;
    @XmlElement(name = "OrgName")
    protected String orgName;
    @XmlElement(name = "AliasName")
    protected String aliasName;
    @XmlElement(name = "OrgCode", required = true)
    protected String orgCode;
    @XmlElement(name = "OrgType")
    protected String orgType;
    @XmlElement(name = "IsEnable")
    protected String isEnable;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "Phone")
    protected String phone;
    @XmlElement(name = "PyCode")
    protected String pyCode;
    @XmlElement(name = "WbCode")
    protected String wbCode;
    @XmlElement(name = "Supervisor")
    protected String supervisor;
    @XmlElement(name = "SortNo")
    protected Long sortNo;
    @XmlElement(name = "AreaCode")
    protected String areaCode;
    @XmlElement(name = "MedicalTypeCode")
    protected String medicalTypeCode;
    @XmlElement(name = "CicDetailType")
    protected String cicDetailType;
    @XmlElement(name = "AccountUnitCode")
    protected String accountUnitCode;
    @XmlElement(name = "AccountUnitName")
    protected String accountUnitName;
    @XmlElement(name = "IsEmergency")
    protected String isEmergency;
    @XmlElement(name = "IsPaed")
    protected String isPaed;

    /**
     * 获取orgId属性的值。
     * 
     */
    public long getOrgId() {
        return orgId;
    }

    /**
     * 设置orgId属性的值。
     * 
     */
    public void setOrgId(long value) {
        this.orgId = value;
    }

    /**
     * 获取parentId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置parentId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentId(Long value) {
        this.parentId = value;
    }

    /**
     * 获取parentCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * 设置parentCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentCode(String value) {
        this.parentCode = value;
    }

    /**
     * 获取orgName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置orgName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgName(String value) {
        this.orgName = value;
    }

    /**
     * 获取aliasName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasName() {
        return aliasName;
    }

    /**
     * 设置aliasName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasName(String value) {
        this.aliasName = value;
    }

    /**
     * 获取orgCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * 设置orgCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgCode(String value) {
        this.orgCode = value;
    }

    /**
     * 获取orgType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * 设置orgType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgType(String value) {
        this.orgType = value;
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

    /**
     * 获取address属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置address属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * 获取phone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置phone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
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
     * 获取supervisor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupervisor() {
        return supervisor;
    }

    /**
     * 设置supervisor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupervisor(String value) {
        this.supervisor = value;
    }

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
     * 获取medicalTypeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedicalTypeCode() {
        return medicalTypeCode;
    }

    /**
     * 设置medicalTypeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedicalTypeCode(String value) {
        this.medicalTypeCode = value;
    }

    /**
     * 获取cicDetailType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCicDetailType() {
        return cicDetailType;
    }

    /**
     * 设置cicDetailType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCicDetailType(String value) {
        this.cicDetailType = value;
    }

    /**
     * 获取accountUnitCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountUnitCode() {
        return accountUnitCode;
    }

    /**
     * 设置accountUnitCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountUnitCode(String value) {
        this.accountUnitCode = value;
    }

    /**
     * 获取accountUnitName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountUnitName() {
        return accountUnitName;
    }

    /**
     * 设置accountUnitName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountUnitName(String value) {
        this.accountUnitName = value;
    }

    /**
     * 获取isEmergency属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsEmergency() {
        return isEmergency;
    }

    /**
     * 设置isEmergency属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsEmergency(String value) {
        this.isEmergency = value;
    }

    /**
     * 获取isPaed属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsPaed() {
        return isPaed;
    }

    /**
     * 设置isPaed属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsPaed(String value) {
        this.isPaed = value;
    }

    @Override
    public String toString() {
        return "Org{" +
                "orgId=" + orgId +
                ", parentId=" + parentId +
                ", parentCode='" + parentCode + '\'' +
                ", orgName='" + orgName + '\'' +
                ", aliasName='" + aliasName + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", orgType='" + orgType + '\'' +
                ", isEnable='" + isEnable + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", pyCode='" + pyCode + '\'' +
                ", wbCode='" + wbCode + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", sortNo=" + sortNo +
                ", areaCode='" + areaCode + '\'' +
                ", medicalTypeCode='" + medicalTypeCode + '\'' +
                ", cicDetailType='" + cicDetailType + '\'' +
                ", accountUnitCode='" + accountUnitCode + '\'' +
                ", accountUnitName='" + accountUnitName + '\'' +
                ", isEmergency='" + isEmergency + '\'' +
                ", isPaed='" + isPaed + '\'' +
                '}';
    }
}
