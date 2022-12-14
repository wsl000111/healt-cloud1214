
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bdClinicpriceQueryVO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bdClinicpriceQueryVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PriceId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ItemClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PriceMoney" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LatestEnableTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WbCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StandardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StandardName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OperationLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegulatoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TreatmentClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NationStdCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ProvinceStdCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Descn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bdClinicpriceQueryVO", propOrder = {
    "priceId",
    "itemClass",
    "itemClassName",
    "itemCode",
    "itemName",
    "itemUnit",
    "priceMoney",
    "latestEnableTime",
    "isEnable",
    "pyCode",
    "wbCode",
    "standardCode",
    "standardName",
    "operationLevel",
    "regulatoryCode",
    "treatmentClass",
    "nationStdCode",
    "provinceStdCode",
    "areaCode",
    "medInstCode",
    "descn"
})
public class BdClinicpriceQueryVO {

    @XmlElement(name = "PriceId")
    protected Integer priceId;
    @XmlElement(name = "ItemClass")
    protected String itemClass;
    @XmlElement(name = "ItemClassName")
    protected String itemClassName;
    @XmlElement(name = "ItemCode")
    protected String itemCode;
    @XmlElement(name = "ItemName")
    protected String itemName;
    @XmlElement(name = "ItemUnit")
    protected String itemUnit;
    @XmlElement(name = "PriceMoney")
    protected String priceMoney;
    @XmlElement(name = "LatestEnableTime")
    protected String latestEnableTime;
    @XmlElement(name = "IsEnable")
    protected String isEnable;
    @XmlElement(name = "PyCode")
    protected String pyCode;
    @XmlElement(name = "WbCode")
    protected String wbCode;
    @XmlElement(name = "StandardCode")
    protected String standardCode;
    @XmlElement(name = "StandardName")
    protected String standardName;
    @XmlElement(name = "OperationLevel")
    protected String operationLevel;
    @XmlElement(name = "RegulatoryCode")
    protected String regulatoryCode;
    @XmlElement(name = "TreatmentClass")
    protected String treatmentClass;
    @XmlElement(name = "NationStdCode")
    protected String nationStdCode;
    @XmlElement(name = "ProvinceStdCode")
    protected String provinceStdCode;
    @XmlElement(name = "AreaCode")
    protected String areaCode;
    @XmlElement(name = "MedInstCode")
    protected Integer medInstCode;
    @XmlElement(name = "Descn")
    protected String descn;

    /**
     * 获取priceId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPriceId() {
        return priceId;
    }

    /**
     * 设置priceId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPriceId(Integer value) {
        this.priceId = value;
    }

    /**
     * 获取itemClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemClass() {
        return itemClass;
    }

    /**
     * 设置itemClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemClass(String value) {
        this.itemClass = value;
    }

    /**
     * 获取itemClassName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemClassName() {
        return itemClassName;
    }

    /**
     * 设置itemClassName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemClassName(String value) {
        this.itemClassName = value;
    }

    /**
     * 获取itemCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * 设置itemCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemCode(String value) {
        this.itemCode = value;
    }

    /**
     * 获取itemName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置itemName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemName(String value) {
        this.itemName = value;
    }

    /**
     * 获取itemUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemUnit() {
        return itemUnit;
    }

    /**
     * 设置itemUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemUnit(String value) {
        this.itemUnit = value;
    }

    /**
     * 获取priceMoney属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriceMoney() {
        return priceMoney;
    }

    /**
     * 设置priceMoney属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceMoney(String value) {
        this.priceMoney = value;
    }

    /**
     * 获取latestEnableTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatestEnableTime() {
        return latestEnableTime;
    }

    /**
     * 设置latestEnableTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatestEnableTime(String value) {
        this.latestEnableTime = value;
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
     * 获取standardCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandardCode() {
        return standardCode;
    }

    /**
     * 设置standardCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandardCode(String value) {
        this.standardCode = value;
    }

    /**
     * 获取standardName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandardName() {
        return standardName;
    }

    /**
     * 设置standardName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandardName(String value) {
        this.standardName = value;
    }

    /**
     * 获取operationLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationLevel() {
        return operationLevel;
    }

    /**
     * 设置operationLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationLevel(String value) {
        this.operationLevel = value;
    }

    /**
     * 获取regulatoryCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegulatoryCode() {
        return regulatoryCode;
    }

    /**
     * 设置regulatoryCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegulatoryCode(String value) {
        this.regulatoryCode = value;
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
     * 获取nationStdCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationStdCode() {
        return nationStdCode;
    }

    /**
     * 设置nationStdCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationStdCode(String value) {
        this.nationStdCode = value;
    }

    /**
     * 获取provinceStdCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvinceStdCode() {
        return provinceStdCode;
    }

    /**
     * 设置provinceStdCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvinceStdCode(String value) {
        this.provinceStdCode = value;
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
     * 获取medInstCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMedInstCode() {
        return medInstCode;
    }

    /**
     * 设置medInstCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMedInstCode(Integer value) {
        this.medInstCode = value;
    }

    /**
     * 获取descn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescn() {
        return descn;
    }

    /**
     * 设置descn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescn(String value) {
        this.descn = value;
    }

}
