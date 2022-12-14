
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>clinicItemEntity complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="clinicItemEntity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ClinicId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PriceStdCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NationStdCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ProvinceStdCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PropertyClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PropertyClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Descn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WbCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExecOrgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DefaultQuantity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SalesPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Charges" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Spec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clinicItemEntity", propOrder = {
    "clinicId",
    "itemCode",
    "itemName",
    "itemClass",
    "itemClassName",
    "priceStdCode",
    "areaCode",
    "nationStdCode",
    "provinceStdCode",
    "medInstCode",
    "isEnable",
    "propertyClass",
    "propertyClassName",
    "descn",
    "pyCode",
    "wbCode",
    "itemUnit",
    "execOrgCode",
    "defaultQuantity",
    "salesPrice",
    "charges",
    "spec"
})
public class ClinicItemEntity {

    @XmlElement(name = "ClinicId")
    protected String clinicId;
    @XmlElement(name = "ItemCode")
    protected String itemCode;
    @XmlElement(name = "ItemName")
    protected String itemName;
    @XmlElement(name = "ItemClass")
    protected String itemClass;
    @XmlElement(name = "ItemClassName")
    protected String itemClassName;
    @XmlElement(name = "PriceStdCode")
    protected String priceStdCode;
    @XmlElement(name = "AreaCode")
    protected String areaCode;
    @XmlElement(name = "NationStdCode")
    protected String nationStdCode;
    @XmlElement(name = "ProvinceStdCode")
    protected String provinceStdCode;
    @XmlElement(name = "MedInstCode")
    protected String medInstCode;
    @XmlElement(name = "IsEnable")
    protected String isEnable;
    @XmlElement(name = "PropertyClass")
    protected String propertyClass;
    @XmlElement(name = "PropertyClassName")
    protected String propertyClassName;
    @XmlElement(name = "Descn")
    protected String descn;
    @XmlElement(name = "PyCode")
    protected String pyCode;
    @XmlElement(name = "WbCode")
    protected String wbCode;
    @XmlElement(name = "ItemUnit")
    protected String itemUnit;
    @XmlElement(name = "ExecOrgCode")
    protected String execOrgCode;
    @XmlElement(name = "DefaultQuantity")
    protected String defaultQuantity;
    @XmlElement(name = "SalesPrice")
    protected String salesPrice;
    @XmlElement(name = "Charges")
    protected String charges;
    @XmlElement(name = "Spec")
    protected String spec;

    /**
     * 获取clinicId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClinicId() {
        return clinicId;
    }

    /**
     * 设置clinicId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClinicId(String value) {
        this.clinicId = value;
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
     * 获取priceStdCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriceStdCode() {
        return priceStdCode;
    }

    /**
     * 设置priceStdCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceStdCode(String value) {
        this.priceStdCode = value;
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
     * 获取propertyClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyClass() {
        return propertyClass;
    }

    /**
     * 设置propertyClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyClass(String value) {
        this.propertyClass = value;
    }

    /**
     * 获取propertyClassName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyClassName() {
        return propertyClassName;
    }

    /**
     * 设置propertyClassName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyClassName(String value) {
        this.propertyClassName = value;
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
     * 获取execOrgCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecOrgCode() {
        return execOrgCode;
    }

    /**
     * 设置execOrgCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecOrgCode(String value) {
        this.execOrgCode = value;
    }

    /**
     * 获取defaultQuantity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultQuantity() {
        return defaultQuantity;
    }

    /**
     * 设置defaultQuantity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultQuantity(String value) {
        this.defaultQuantity = value;
    }

    /**
     * 获取salesPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesPrice() {
        return salesPrice;
    }

    /**
     * 设置salesPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesPrice(String value) {
        this.salesPrice = value;
    }

    /**
     * 获取charges属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharges() {
        return charges;
    }

    /**
     * 设置charges属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharges(String value) {
        this.charges = value;
    }

    /**
     * 获取spec属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpec() {
        return spec;
    }

    /**
     * 设置spec属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpec(String value) {
        this.spec = value;
    }

}
