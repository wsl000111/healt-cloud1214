
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>phamLocationPO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="phamLocationPO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MedInstId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DispensaryOrgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugChickState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GoodsNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Factor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugSpecCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugSpecName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PharmacyFactoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PharmacyFactoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StockNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PackageFactor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugBatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugBatchNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugVaildity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "phamLocationPO", propOrder = {
    "medInstId",
    "dispensaryOrgCode",
    "drugChickState",
    "goodsNo",
    "unit",
    "factor",
    "drugSpecCode",
    "drugSpecName",
    "pharmacyFactoryCode",
    "pharmacyFactoryName",
    "stockNum",
    "packageFactor",
    "drugBatch",
    "drugBatchNum",
    "drugVaildity"
})
public class PhamLocationPO {

    @XmlElement(name = "MedInstId")
    protected String medInstId;
    @XmlElement(name = "DispensaryOrgCode")
    protected String dispensaryOrgCode;
    @XmlElement(name = "DrugChickState")
    protected String drugChickState;
    @XmlElement(name = "GoodsNo")
    protected String goodsNo;
    @XmlElement(name = "Unit")
    protected String unit;
    @XmlElement(name = "Factor")
    protected String factor;
    @XmlElement(name = "DrugSpecCode")
    protected String drugSpecCode;
    @XmlElement(name = "DrugSpecName")
    protected String drugSpecName;
    @XmlElement(name = "PharmacyFactoryCode")
    protected String pharmacyFactoryCode;
    @XmlElement(name = "PharmacyFactoryName")
    protected String pharmacyFactoryName;
    @XmlElement(name = "StockNum")
    protected String stockNum;
    @XmlElement(name = "PackageFactor")
    protected String packageFactor;
    @XmlElement(name = "DrugBatch")
    protected String drugBatch;
    @XmlElement(name = "DrugBatchNum")
    protected String drugBatchNum;
    @XmlElement(name = "DrugVaildity")
    protected String drugVaildity;

    /**
     * 获取medInstId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstId() {
        return medInstId;
    }

    /**
     * 设置medInstId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstId(String value) {
        this.medInstId = value;
    }

    /**
     * 获取dispensaryOrgCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispensaryOrgCode() {
        return dispensaryOrgCode;
    }

    /**
     * 设置dispensaryOrgCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispensaryOrgCode(String value) {
        this.dispensaryOrgCode = value;
    }

    /**
     * 获取drugChickState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugChickState() {
        return drugChickState;
    }

    /**
     * 设置drugChickState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugChickState(String value) {
        this.drugChickState = value;
    }

    /**
     * 获取goodsNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodsNo() {
        return goodsNo;
    }

    /**
     * 设置goodsNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodsNo(String value) {
        this.goodsNo = value;
    }

    /**
     * 获取unit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置unit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * 获取factor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactor() {
        return factor;
    }

    /**
     * 设置factor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactor(String value) {
        this.factor = value;
    }

    /**
     * 获取drugSpecCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugSpecCode() {
        return drugSpecCode;
    }

    /**
     * 设置drugSpecCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugSpecCode(String value) {
        this.drugSpecCode = value;
    }

    /**
     * 获取drugSpecName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugSpecName() {
        return drugSpecName;
    }

    /**
     * 设置drugSpecName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugSpecName(String value) {
        this.drugSpecName = value;
    }

    /**
     * 获取pharmacyFactoryCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPharmacyFactoryCode() {
        return pharmacyFactoryCode;
    }

    /**
     * 设置pharmacyFactoryCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPharmacyFactoryCode(String value) {
        this.pharmacyFactoryCode = value;
    }

    /**
     * 获取pharmacyFactoryName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPharmacyFactoryName() {
        return pharmacyFactoryName;
    }

    /**
     * 设置pharmacyFactoryName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPharmacyFactoryName(String value) {
        this.pharmacyFactoryName = value;
    }

    /**
     * 获取stockNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStockNum() {
        return stockNum;
    }

    /**
     * 设置stockNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStockNum(String value) {
        this.stockNum = value;
    }

    /**
     * 获取packageFactor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageFactor() {
        return packageFactor;
    }

    /**
     * 设置packageFactor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageFactor(String value) {
        this.packageFactor = value;
    }

    /**
     * 获取drugBatch属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugBatch() {
        return drugBatch;
    }

    /**
     * 设置drugBatch属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugBatch(String value) {
        this.drugBatch = value;
    }

    /**
     * 获取drugBatchNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugBatchNum() {
        return drugBatchNum;
    }

    /**
     * 设置drugBatchNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugBatchNum(String value) {
        this.drugBatchNum = value;
    }

    /**
     * 获取drugVaildity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugVaildity() {
        return drugVaildity;
    }

    /**
     * 设置drugVaildity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugVaildity(String value) {
        this.drugVaildity = value;
    }

}
