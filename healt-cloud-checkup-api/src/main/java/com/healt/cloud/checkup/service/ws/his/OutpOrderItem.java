
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>outpOrderItem complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="outpOrderItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrderItemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GroupNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SortNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugSpec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PrescrType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClinicType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PharmacyFactoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SkinFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SkinOrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SkinTestResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SkinTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="FreqCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FreqNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FreqTimeDescn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UsePharmactDays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UsageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SignDoseNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SignDoseUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DosePerUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugUnitNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="TotalNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TotalUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TotalUnitPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TotalUnitCoeff" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RetailCoeff" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RefPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Dirps" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugPurpose" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClinicPropertyClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TisaMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Descn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CreateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="IsOwn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsTake" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsSkinTestSolu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "outpOrderItem", propOrder = {
    "orderItemId",
    "orderId",
    "groupNo",
    "isGroup",
    "sortNo",
    "itemId",
    "itemName",
    "drugSpec",
    "prescrType",
    "itemType",
    "clinicType",
    "pharmacyFactoryCode",
    "skinFlag",
    "skinOrderId",
    "skinTestResult",
    "skinTime",
    "freqCode",
    "freqNum",
    "freqTimeDescn",
    "usePharmactDays",
    "usageCode",
    "signDoseNum",
    "signDoseUnit",
    "dosePerUnit",
    "drugUnit",
    "drugUnitNum",
    "totalNum",
    "totalUnit",
    "totalUnitPrice",
    "totalUnitCoeff",
    "retailCoeff",
    "refPrice",
    "dirps",
    "drugPurpose",
    "clinicPropertyClass",
    "tisaMethod",
    "descn",
    "createTime",
    "isOwn",
    "isTake",
    "isSkinTestSolu"
})
public class OutpOrderItem {

    @XmlElement(name = "OrderItemId")
    protected String orderItemId;
    @XmlElement(name = "OrderId")
    protected String orderId;
    @XmlElement(name = "GroupNo")
    protected String groupNo;
    @XmlElement(name = "IsGroup")
    protected String isGroup;
    @XmlElement(name = "SortNo")
    protected String sortNo;
    @XmlElement(name = "ItemId")
    protected String itemId;
    @XmlElement(name = "ItemName")
    protected String itemName;
    @XmlElement(name = "DrugSpec")
    protected String drugSpec;
    @XmlElement(name = "PrescrType")
    protected String prescrType;
    @XmlElement(name = "ItemType")
    protected String itemType;
    @XmlElement(name = "ClinicType")
    protected String clinicType;
    @XmlElement(name = "PharmacyFactoryCode")
    protected String pharmacyFactoryCode;
    @XmlElement(name = "SkinFlag")
    protected String skinFlag;
    @XmlElement(name = "SkinOrderId")
    protected String skinOrderId;
    @XmlElement(name = "SkinTestResult")
    protected String skinTestResult;
    @XmlElement(name = "SkinTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar skinTime;
    @XmlElement(name = "FreqCode")
    protected String freqCode;
    @XmlElement(name = "FreqNum")
    protected String freqNum;
    @XmlElement(name = "FreqTimeDescn")
    protected String freqTimeDescn;
    @XmlElement(name = "UsePharmactDays")
    protected String usePharmactDays;
    @XmlElement(name = "UsageCode")
    protected String usageCode;
    @XmlElement(name = "SignDoseNum")
    protected String signDoseNum;
    @XmlElement(name = "SignDoseUnit")
    protected String signDoseUnit;
    @XmlElement(name = "DosePerUnit")
    protected String dosePerUnit;
    @XmlElement(name = "DrugUnit")
    protected String drugUnit;
    @XmlElement(name = "DrugUnitNum")
    protected Long drugUnitNum;
    @XmlElement(name = "TotalNum")
    protected String totalNum;
    @XmlElement(name = "TotalUnit")
    protected String totalUnit;
    @XmlElement(name = "TotalUnitPrice")
    protected String totalUnitPrice;
    @XmlElement(name = "TotalUnitCoeff")
    protected String totalUnitCoeff;
    @XmlElement(name = "RetailCoeff")
    protected String retailCoeff;
    @XmlElement(name = "RefPrice")
    protected String refPrice;
    @XmlElement(name = "Dirps")
    protected String dirps;
    @XmlElement(name = "DrugPurpose")
    protected String drugPurpose;
    @XmlElement(name = "ClinicPropertyClass")
    protected String clinicPropertyClass;
    @XmlElement(name = "TisaMethod")
    protected String tisaMethod;
    @XmlElement(name = "Descn")
    protected String descn;
    @XmlElement(name = "CreateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    @XmlElement(name = "IsOwn")
    protected String isOwn;
    @XmlElement(name = "IsTake")
    protected String isTake;
    @XmlElement(name = "IsSkinTestSolu")
    protected String isSkinTestSolu;

    /**
     * 获取orderItemId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderItemId() {
        return orderItemId;
    }

    /**
     * 设置orderItemId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderItemId(String value) {
        this.orderItemId = value;
    }

    /**
     * 获取orderId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置orderId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderId(String value) {
        this.orderId = value;
    }

    /**
     * 获取groupNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupNo() {
        return groupNo;
    }

    /**
     * 设置groupNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupNo(String value) {
        this.groupNo = value;
    }

    /**
     * 获取isGroup属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsGroup() {
        return isGroup;
    }

    /**
     * 设置isGroup属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsGroup(String value) {
        this.isGroup = value;
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
     * 获取itemId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 设置itemId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemId(String value) {
        this.itemId = value;
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
     * 获取drugSpec属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugSpec() {
        return drugSpec;
    }

    /**
     * 设置drugSpec属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugSpec(String value) {
        this.drugSpec = value;
    }

    /**
     * 获取prescrType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrescrType() {
        return prescrType;
    }

    /**
     * 设置prescrType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrescrType(String value) {
        this.prescrType = value;
    }

    /**
     * 获取itemType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * 设置itemType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemType(String value) {
        this.itemType = value;
    }

    /**
     * 获取clinicType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClinicType() {
        return clinicType;
    }

    /**
     * 设置clinicType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClinicType(String value) {
        this.clinicType = value;
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
     * 获取skinFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinFlag() {
        return skinFlag;
    }

    /**
     * 设置skinFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinFlag(String value) {
        this.skinFlag = value;
    }

    /**
     * 获取skinOrderId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinOrderId() {
        return skinOrderId;
    }

    /**
     * 设置skinOrderId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinOrderId(String value) {
        this.skinOrderId = value;
    }

    /**
     * 获取skinTestResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinTestResult() {
        return skinTestResult;
    }

    /**
     * 设置skinTestResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinTestResult(String value) {
        this.skinTestResult = value;
    }

    /**
     * 获取skinTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSkinTime() {
        return skinTime;
    }

    /**
     * 设置skinTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSkinTime(XMLGregorianCalendar value) {
        this.skinTime = value;
    }

    /**
     * 获取freqCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreqCode() {
        return freqCode;
    }

    /**
     * 设置freqCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreqCode(String value) {
        this.freqCode = value;
    }

    /**
     * 获取freqNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreqNum() {
        return freqNum;
    }

    /**
     * 设置freqNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreqNum(String value) {
        this.freqNum = value;
    }

    /**
     * 获取freqTimeDescn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreqTimeDescn() {
        return freqTimeDescn;
    }

    /**
     * 设置freqTimeDescn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreqTimeDescn(String value) {
        this.freqTimeDescn = value;
    }

    /**
     * 获取usePharmactDays属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsePharmactDays() {
        return usePharmactDays;
    }

    /**
     * 设置usePharmactDays属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsePharmactDays(String value) {
        this.usePharmactDays = value;
    }

    /**
     * 获取usageCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsageCode() {
        return usageCode;
    }

    /**
     * 设置usageCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsageCode(String value) {
        this.usageCode = value;
    }

    /**
     * 获取signDoseNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignDoseNum() {
        return signDoseNum;
    }

    /**
     * 设置signDoseNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignDoseNum(String value) {
        this.signDoseNum = value;
    }

    /**
     * 获取signDoseUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignDoseUnit() {
        return signDoseUnit;
    }

    /**
     * 设置signDoseUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignDoseUnit(String value) {
        this.signDoseUnit = value;
    }

    /**
     * 获取dosePerUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDosePerUnit() {
        return dosePerUnit;
    }

    /**
     * 设置dosePerUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDosePerUnit(String value) {
        this.dosePerUnit = value;
    }

    /**
     * 获取drugUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugUnit() {
        return drugUnit;
    }

    /**
     * 设置drugUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugUnit(String value) {
        this.drugUnit = value;
    }

    /**
     * 获取drugUnitNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDrugUnitNum() {
        return drugUnitNum;
    }

    /**
     * 设置drugUnitNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDrugUnitNum(Long value) {
        this.drugUnitNum = value;
    }

    /**
     * 获取totalNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalNum() {
        return totalNum;
    }

    /**
     * 设置totalNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalNum(String value) {
        this.totalNum = value;
    }

    /**
     * 获取totalUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalUnit() {
        return totalUnit;
    }

    /**
     * 设置totalUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalUnit(String value) {
        this.totalUnit = value;
    }

    /**
     * 获取totalUnitPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalUnitPrice() {
        return totalUnitPrice;
    }

    /**
     * 设置totalUnitPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalUnitPrice(String value) {
        this.totalUnitPrice = value;
    }

    /**
     * 获取totalUnitCoeff属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalUnitCoeff() {
        return totalUnitCoeff;
    }

    /**
     * 设置totalUnitCoeff属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalUnitCoeff(String value) {
        this.totalUnitCoeff = value;
    }

    /**
     * 获取retailCoeff属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetailCoeff() {
        return retailCoeff;
    }

    /**
     * 设置retailCoeff属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetailCoeff(String value) {
        this.retailCoeff = value;
    }

    /**
     * 获取refPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefPrice() {
        return refPrice;
    }

    /**
     * 设置refPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefPrice(String value) {
        this.refPrice = value;
    }

    /**
     * 获取dirps属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirps() {
        return dirps;
    }

    /**
     * 设置dirps属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirps(String value) {
        this.dirps = value;
    }

    /**
     * 获取drugPurpose属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugPurpose() {
        return drugPurpose;
    }

    /**
     * 设置drugPurpose属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugPurpose(String value) {
        this.drugPurpose = value;
    }

    /**
     * 获取clinicPropertyClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClinicPropertyClass() {
        return clinicPropertyClass;
    }

    /**
     * 设置clinicPropertyClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClinicPropertyClass(String value) {
        this.clinicPropertyClass = value;
    }

    /**
     * 获取tisaMethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTisaMethod() {
        return tisaMethod;
    }

    /**
     * 设置tisaMethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTisaMethod(String value) {
        this.tisaMethod = value;
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
     * 获取createTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateTime() {
        return createTime;
    }

    /**
     * 设置createTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateTime(XMLGregorianCalendar value) {
        this.createTime = value;
    }

    /**
     * 获取isOwn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsOwn() {
        return isOwn;
    }

    /**
     * 设置isOwn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsOwn(String value) {
        this.isOwn = value;
    }

    /**
     * 获取isTake属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsTake() {
        return isTake;
    }

    /**
     * 设置isTake属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsTake(String value) {
        this.isTake = value;
    }

    /**
     * 获取isSkinTestSolu属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsSkinTestSolu() {
        return isSkinTestSolu;
    }

    /**
     * 设置isSkinTestSolu属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsSkinTestSolu(String value) {
        this.isSkinTestSolu = value;
    }

}
