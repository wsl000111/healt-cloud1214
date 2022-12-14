
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>leavePatientInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="leavePatientInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PatientId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PatientType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VisitId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedRecordNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CredentialsType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CredentialsNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PatientName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PatientSex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PatientAge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BirthDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaritalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CitizenshipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeAddrProvinceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeAddrCityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeAddrCountyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeAddrStreetCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeAddrVillageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeAddrDetailed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeAddrZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RelationshipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ContactsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ContactsCredentialsType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ContactsIdNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ContactsPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ContactsZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ContactsOfficeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdmOrgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdmWardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdmTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdmPurpose" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdmRoute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdmCase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentOrgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentAreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DischargeTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Archiving" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ArchivingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TeamId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TeamName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "leavePatientInfo", propOrder = {
    "patientId",
    "patientType",
    "visitId",
    "medRecordNum",
    "credentialsType",
    "credentialsNo",
    "patientName",
    "patientSex",
    "patientAge",
    "birthDate",
    "maritalCode",
    "citizenshipCode",
    "nationCode",
    "homeAddrProvinceCode",
    "homeAddrCityCode",
    "homeAddrCountyCode",
    "homeAddrStreetCode",
    "homeAddrVillageCode",
    "homeAddrDetailed",
    "homeAddrZipCode",
    "relationshipCode",
    "contactsName",
    "contactsCredentialsType",
    "contactsIdNo",
    "contactsPhone",
    "contactsZip",
    "contactsOfficeName",
    "admOrgCode",
    "admWardCode",
    "admTime",
    "admPurpose",
    "admRoute",
    "admCase",
    "currentOrgCode",
    "currentWardCode",
    "currentAreaCode",
    "dischargeTime",
    "archiving",
    "archivingName",
    "teamId",
    "teamName"
})
public class LeavePatientInfo {

    @XmlElement(name = "PatientId")
    protected String patientId;
    @XmlElement(name = "PatientType")
    protected String patientType;
    @XmlElement(name = "VisitId")
    protected String visitId;
    @XmlElement(name = "MedRecordNum")
    protected String medRecordNum;
    @XmlElement(name = "CredentialsType")
    protected String credentialsType;
    @XmlElement(name = "CredentialsNo")
    protected String credentialsNo;
    @XmlElement(name = "PatientName")
    protected String patientName;
    @XmlElement(name = "PatientSex")
    protected String patientSex;
    @XmlElement(name = "PatientAge")
    protected String patientAge;
    @XmlElement(name = "BirthDate")
    protected String birthDate;
    @XmlElement(name = "MaritalCode")
    protected String maritalCode;
    @XmlElement(name = "CitizenshipCode")
    protected String citizenshipCode;
    @XmlElement(name = "NationCode")
    protected String nationCode;
    @XmlElement(name = "HomeAddrProvinceCode")
    protected String homeAddrProvinceCode;
    @XmlElement(name = "HomeAddrCityCode")
    protected String homeAddrCityCode;
    @XmlElement(name = "HomeAddrCountyCode")
    protected String homeAddrCountyCode;
    @XmlElement(name = "HomeAddrStreetCode")
    protected String homeAddrStreetCode;
    @XmlElement(name = "HomeAddrVillageCode")
    protected String homeAddrVillageCode;
    @XmlElement(name = "HomeAddrDetailed")
    protected String homeAddrDetailed;
    @XmlElement(name = "HomeAddrZipCode")
    protected String homeAddrZipCode;
    @XmlElement(name = "RelationshipCode")
    protected String relationshipCode;
    @XmlElement(name = "ContactsName")
    protected String contactsName;
    @XmlElement(name = "ContactsCredentialsType")
    protected String contactsCredentialsType;
    @XmlElement(name = "ContactsIdNo")
    protected String contactsIdNo;
    @XmlElement(name = "ContactsPhone")
    protected String contactsPhone;
    @XmlElement(name = "ContactsZip")
    protected String contactsZip;
    @XmlElement(name = "ContactsOfficeName")
    protected String contactsOfficeName;
    @XmlElement(name = "AdmOrgCode")
    protected String admOrgCode;
    @XmlElement(name = "AdmWardCode")
    protected String admWardCode;
    @XmlElement(name = "AdmTime")
    protected String admTime;
    @XmlElement(name = "AdmPurpose")
    protected String admPurpose;
    @XmlElement(name = "AdmRoute")
    protected String admRoute;
    @XmlElement(name = "AdmCase")
    protected String admCase;
    @XmlElement(name = "CurrentOrgCode")
    protected String currentOrgCode;
    @XmlElement(name = "CurrentWardCode")
    protected String currentWardCode;
    @XmlElement(name = "CurrentAreaCode")
    protected String currentAreaCode;
    @XmlElement(name = "DischargeTime")
    protected String dischargeTime;
    @XmlElement(name = "Archiving")
    protected String archiving;
    @XmlElement(name = "ArchivingName")
    protected String archivingName;
    @XmlElement(name = "TeamId")
    protected String teamId;
    @XmlElement(name = "TeamName")
    protected String teamName;

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
     * 获取patientType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientType() {
        return patientType;
    }

    /**
     * 设置patientType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientType(String value) {
        this.patientType = value;
    }

    /**
     * 获取visitId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisitId() {
        return visitId;
    }

    /**
     * 设置visitId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisitId(String value) {
        this.visitId = value;
    }

    /**
     * 获取medRecordNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedRecordNum() {
        return medRecordNum;
    }

    /**
     * 设置medRecordNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedRecordNum(String value) {
        this.medRecordNum = value;
    }

    /**
     * 获取credentialsType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCredentialsType() {
        return credentialsType;
    }

    /**
     * 设置credentialsType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCredentialsType(String value) {
        this.credentialsType = value;
    }

    /**
     * 获取credentialsNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCredentialsNo() {
        return credentialsNo;
    }

    /**
     * 设置credentialsNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCredentialsNo(String value) {
        this.credentialsNo = value;
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
     * 获取patientSex属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientSex() {
        return patientSex;
    }

    /**
     * 设置patientSex属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientSex(String value) {
        this.patientSex = value;
    }

    /**
     * 获取patientAge属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientAge() {
        return patientAge;
    }

    /**
     * 设置patientAge属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientAge(String value) {
        this.patientAge = value;
    }

    /**
     * 获取birthDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * 设置birthDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthDate(String value) {
        this.birthDate = value;
    }

    /**
     * 获取maritalCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaritalCode() {
        return maritalCode;
    }

    /**
     * 设置maritalCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaritalCode(String value) {
        this.maritalCode = value;
    }

    /**
     * 获取citizenshipCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    /**
     * 设置citizenshipCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCitizenshipCode(String value) {
        this.citizenshipCode = value;
    }

    /**
     * 获取nationCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationCode() {
        return nationCode;
    }

    /**
     * 设置nationCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationCode(String value) {
        this.nationCode = value;
    }

    /**
     * 获取homeAddrProvinceCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeAddrProvinceCode() {
        return homeAddrProvinceCode;
    }

    /**
     * 设置homeAddrProvinceCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeAddrProvinceCode(String value) {
        this.homeAddrProvinceCode = value;
    }

    /**
     * 获取homeAddrCityCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeAddrCityCode() {
        return homeAddrCityCode;
    }

    /**
     * 设置homeAddrCityCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeAddrCityCode(String value) {
        this.homeAddrCityCode = value;
    }

    /**
     * 获取homeAddrCountyCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeAddrCountyCode() {
        return homeAddrCountyCode;
    }

    /**
     * 设置homeAddrCountyCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeAddrCountyCode(String value) {
        this.homeAddrCountyCode = value;
    }

    /**
     * 获取homeAddrStreetCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeAddrStreetCode() {
        return homeAddrStreetCode;
    }

    /**
     * 设置homeAddrStreetCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeAddrStreetCode(String value) {
        this.homeAddrStreetCode = value;
    }

    /**
     * 获取homeAddrVillageCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeAddrVillageCode() {
        return homeAddrVillageCode;
    }

    /**
     * 设置homeAddrVillageCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeAddrVillageCode(String value) {
        this.homeAddrVillageCode = value;
    }

    /**
     * 获取homeAddrDetailed属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeAddrDetailed() {
        return homeAddrDetailed;
    }

    /**
     * 设置homeAddrDetailed属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeAddrDetailed(String value) {
        this.homeAddrDetailed = value;
    }

    /**
     * 获取homeAddrZipCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeAddrZipCode() {
        return homeAddrZipCode;
    }

    /**
     * 设置homeAddrZipCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeAddrZipCode(String value) {
        this.homeAddrZipCode = value;
    }

    /**
     * 获取relationshipCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationshipCode() {
        return relationshipCode;
    }

    /**
     * 设置relationshipCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationshipCode(String value) {
        this.relationshipCode = value;
    }

    /**
     * 获取contactsName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactsName() {
        return contactsName;
    }

    /**
     * 设置contactsName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactsName(String value) {
        this.contactsName = value;
    }

    /**
     * 获取contactsCredentialsType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactsCredentialsType() {
        return contactsCredentialsType;
    }

    /**
     * 设置contactsCredentialsType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactsCredentialsType(String value) {
        this.contactsCredentialsType = value;
    }

    /**
     * 获取contactsIdNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactsIdNo() {
        return contactsIdNo;
    }

    /**
     * 设置contactsIdNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactsIdNo(String value) {
        this.contactsIdNo = value;
    }

    /**
     * 获取contactsPhone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactsPhone() {
        return contactsPhone;
    }

    /**
     * 设置contactsPhone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactsPhone(String value) {
        this.contactsPhone = value;
    }

    /**
     * 获取contactsZip属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactsZip() {
        return contactsZip;
    }

    /**
     * 设置contactsZip属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactsZip(String value) {
        this.contactsZip = value;
    }

    /**
     * 获取contactsOfficeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactsOfficeName() {
        return contactsOfficeName;
    }

    /**
     * 设置contactsOfficeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactsOfficeName(String value) {
        this.contactsOfficeName = value;
    }

    /**
     * 获取admOrgCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmOrgCode() {
        return admOrgCode;
    }

    /**
     * 设置admOrgCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmOrgCode(String value) {
        this.admOrgCode = value;
    }

    /**
     * 获取admWardCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmWardCode() {
        return admWardCode;
    }

    /**
     * 设置admWardCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmWardCode(String value) {
        this.admWardCode = value;
    }

    /**
     * 获取admTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmTime() {
        return admTime;
    }

    /**
     * 设置admTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmTime(String value) {
        this.admTime = value;
    }

    /**
     * 获取admPurpose属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmPurpose() {
        return admPurpose;
    }

    /**
     * 设置admPurpose属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmPurpose(String value) {
        this.admPurpose = value;
    }

    /**
     * 获取admRoute属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmRoute() {
        return admRoute;
    }

    /**
     * 设置admRoute属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmRoute(String value) {
        this.admRoute = value;
    }

    /**
     * 获取admCase属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmCase() {
        return admCase;
    }

    /**
     * 设置admCase属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmCase(String value) {
        this.admCase = value;
    }

    /**
     * 获取currentOrgCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentOrgCode() {
        return currentOrgCode;
    }

    /**
     * 设置currentOrgCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentOrgCode(String value) {
        this.currentOrgCode = value;
    }

    /**
     * 获取currentWardCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentWardCode() {
        return currentWardCode;
    }

    /**
     * 设置currentWardCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentWardCode(String value) {
        this.currentWardCode = value;
    }

    /**
     * 获取currentAreaCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentAreaCode() {
        return currentAreaCode;
    }

    /**
     * 设置currentAreaCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentAreaCode(String value) {
        this.currentAreaCode = value;
    }

    /**
     * 获取dischargeTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDischargeTime() {
        return dischargeTime;
    }

    /**
     * 设置dischargeTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDischargeTime(String value) {
        this.dischargeTime = value;
    }

    /**
     * 获取archiving属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchiving() {
        return archiving;
    }

    /**
     * 设置archiving属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchiving(String value) {
        this.archiving = value;
    }

    /**
     * 获取archivingName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchivingName() {
        return archivingName;
    }

    /**
     * 设置archivingName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchivingName(String value) {
        this.archivingName = value;
    }

    /**
     * 获取teamId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     * 设置teamId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeamId(String value) {
        this.teamId = value;
    }

    /**
     * 获取teamName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * 设置teamName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeamName(String value) {
        this.teamName = value;
    }

}
