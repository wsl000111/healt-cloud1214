
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>phamItem complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="phamItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DrugFactCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugNationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugAliasName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugGeneraName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WbCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugSpec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PhamUnitDesp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoseUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DoseUnitDesp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DosePerUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PackageUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PackageUnitDesp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PackageFactor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RetailPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TradePrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PurchasePrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PhamPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PharmacyFactoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PharmacyFactoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugValua" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ToxicologyProperty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ToxicologyPropertyDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugCodeYl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugCodeYlName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugDosageFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugDosageFromDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DefUsageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DefFreqCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DefPerDose" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DefPerQuan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DefCourse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ManageLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HighRiskLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PhamSimilar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugAntimiType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsOral" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PivasFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AntiTumour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LargeVolumeLiquidFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LargePackSmallDoseFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpecialSeparableFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GmpFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InjectionDrugFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BasicPham" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SkinTestFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutProportion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InpProportion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InsurLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugOiSign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "phamItem", propOrder = {
    "drugFactCode",
    "drugTypeCode",
    "drugTypeName",
    "drugNationCode",
    "drugName",
    "drugAliasName",
    "drugGeneraName",
    "pyCode",
    "wbCode",
    "drugSpec",
    "drugUnit",
    "phamUnitDesp",
    "doseUnit",
    "doseUnitDesp",
    "dosePerUnit",
    "packageUnit",
    "packageUnitDesp",
    "packageFactor",
    "retailPrice",
    "tradePrice",
    "purchasePrice",
    "phamPrice",
    "pharmacyFactoryCode",
    "pharmacyFactoryName",
    "drugValua",
    "toxicologyProperty",
    "toxicologyPropertyDesc",
    "drugCodeYl",
    "drugCodeYlName",
    "drugDosageFrom",
    "drugDosageFromDesc",
    "defUsageCode",
    "defFreqCode",
    "defPerDose",
    "defPerQuan",
    "defCourse",
    "manageLevel",
    "highRiskLevel",
    "phamSimilar",
    "drugAntimiType",
    "isOral",
    "pivasFlag",
    "antiTumour",
    "largeVolumeLiquidFlag",
    "largePackSmallDoseFlag",
    "specialSeparableFlag",
    "gmpFlag",
    "injectionDrugFlag",
    "basicPham",
    "skinTestFlag",
    "isEnable",
    "outProportion",
    "inpProportion",
    "insurLevelCode",
    "drugOiSign",
    "medInstCode",
    "areaCode"
})
public class PhamItem {

    @XmlElement(name = "DrugFactCode")
    protected String drugFactCode;
    @XmlElement(name = "DrugTypeCode")
    protected String drugTypeCode;
    @XmlElement(name = "DrugTypeName")
    protected String drugTypeName;
    @XmlElement(name = "DrugNationCode")
    protected String drugNationCode;
    @XmlElement(name = "DrugName")
    protected String drugName;
    @XmlElement(name = "DrugAliasName")
    protected String drugAliasName;
    @XmlElement(name = "DrugGeneraName")
    protected String drugGeneraName;
    @XmlElement(name = "PyCode")
    protected String pyCode;
    @XmlElement(name = "WbCode")
    protected String wbCode;
    @XmlElement(name = "DrugSpec")
    protected String drugSpec;
    @XmlElement(name = "DrugUnit")
    protected String drugUnit;
    @XmlElement(name = "PhamUnitDesp")
    protected String phamUnitDesp;
    @XmlElement(name = "DoseUnit")
    protected String doseUnit;
    @XmlElement(name = "DoseUnitDesp")
    protected String doseUnitDesp;
    @XmlElement(name = "DosePerUnit")
    protected String dosePerUnit;
    @XmlElement(name = "PackageUnit")
    protected String packageUnit;
    @XmlElement(name = "PackageUnitDesp")
    protected String packageUnitDesp;
    @XmlElement(name = "PackageFactor")
    protected String packageFactor;
    @XmlElement(name = "RetailPrice")
    protected String retailPrice;
    @XmlElement(name = "TradePrice")
    protected String tradePrice;
    @XmlElement(name = "PurchasePrice")
    protected String purchasePrice;
    @XmlElement(name = "PhamPrice")
    protected String phamPrice;
    @XmlElement(name = "PharmacyFactoryCode")
    protected String pharmacyFactoryCode;
    @XmlElement(name = "PharmacyFactoryName")
    protected String pharmacyFactoryName;
    @XmlElement(name = "DrugValua")
    protected String drugValua;
    @XmlElement(name = "ToxicologyProperty")
    protected String toxicologyProperty;
    @XmlElement(name = "ToxicologyPropertyDesc")
    protected String toxicologyPropertyDesc;
    @XmlElement(name = "DrugCodeYl")
    protected String drugCodeYl;
    @XmlElement(name = "DrugCodeYlName")
    protected String drugCodeYlName;
    @XmlElement(name = "DrugDosageFrom")
    protected String drugDosageFrom;
    @XmlElement(name = "DrugDosageFromDesc")
    protected String drugDosageFromDesc;
    @XmlElement(name = "DefUsageCode")
    protected String defUsageCode;
    @XmlElement(name = "DefFreqCode")
    protected String defFreqCode;
    @XmlElement(name = "DefPerDose")
    protected String defPerDose;
    @XmlElement(name = "DefPerQuan")
    protected String defPerQuan;
    @XmlElement(name = "DefCourse")
    protected String defCourse;
    @XmlElement(name = "ManageLevel")
    protected String manageLevel;
    @XmlElement(name = "HighRiskLevel")
    protected String highRiskLevel;
    @XmlElement(name = "PhamSimilar")
    protected String phamSimilar;
    @XmlElement(name = "DrugAntimiType")
    protected String drugAntimiType;
    @XmlElement(name = "IsOral")
    protected String isOral;
    @XmlElement(name = "PivasFlag")
    protected String pivasFlag;
    @XmlElement(name = "AntiTumour")
    protected String antiTumour;
    @XmlElement(name = "LargeVolumeLiquidFlag")
    protected String largeVolumeLiquidFlag;
    @XmlElement(name = "LargePackSmallDoseFlag")
    protected String largePackSmallDoseFlag;
    @XmlElement(name = "SpecialSeparableFlag")
    protected String specialSeparableFlag;
    @XmlElement(name = "GmpFlag")
    protected String gmpFlag;
    @XmlElement(name = "InjectionDrugFlag")
    protected String injectionDrugFlag;
    @XmlElement(name = "BasicPham")
    protected String basicPham;
    @XmlElement(name = "SkinTestFlag")
    protected String skinTestFlag;
    @XmlElement(name = "IsEnable")
    protected String isEnable;
    @XmlElement(name = "OutProportion")
    protected String outProportion;
    @XmlElement(name = "InpProportion")
    protected String inpProportion;
    @XmlElement(name = "InsurLevelCode")
    protected String insurLevelCode;
    @XmlElement(name = "DrugOiSign")
    protected String drugOiSign;
    @XmlElement(name = "MedInstCode")
    protected String medInstCode;
    @XmlElement(name = "AreaCode")
    protected String areaCode;

    /**
     * 获取drugFactCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugFactCode() {
        return drugFactCode;
    }

    /**
     * 设置drugFactCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugFactCode(String value) {
        this.drugFactCode = value;
    }

    /**
     * 获取drugTypeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugTypeCode() {
        return drugTypeCode;
    }

    /**
     * 设置drugTypeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugTypeCode(String value) {
        this.drugTypeCode = value;
    }

    /**
     * 获取drugTypeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugTypeName() {
        return drugTypeName;
    }

    /**
     * 设置drugTypeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugTypeName(String value) {
        this.drugTypeName = value;
    }

    /**
     * 获取drugNationCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugNationCode() {
        return drugNationCode;
    }

    /**
     * 设置drugNationCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugNationCode(String value) {
        this.drugNationCode = value;
    }

    /**
     * 获取drugName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugName() {
        return drugName;
    }

    /**
     * 设置drugName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugName(String value) {
        this.drugName = value;
    }

    /**
     * 获取drugAliasName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugAliasName() {
        return drugAliasName;
    }

    /**
     * 设置drugAliasName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugAliasName(String value) {
        this.drugAliasName = value;
    }

    /**
     * 获取drugGeneraName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugGeneraName() {
        return drugGeneraName;
    }

    /**
     * 设置drugGeneraName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugGeneraName(String value) {
        this.drugGeneraName = value;
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
     * 获取phamUnitDesp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhamUnitDesp() {
        return phamUnitDesp;
    }

    /**
     * 设置phamUnitDesp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhamUnitDesp(String value) {
        this.phamUnitDesp = value;
    }

    /**
     * 获取doseUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoseUnit() {
        return doseUnit;
    }

    /**
     * 设置doseUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoseUnit(String value) {
        this.doseUnit = value;
    }

    /**
     * 获取doseUnitDesp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoseUnitDesp() {
        return doseUnitDesp;
    }

    /**
     * 设置doseUnitDesp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoseUnitDesp(String value) {
        this.doseUnitDesp = value;
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
     * 获取packageUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageUnit() {
        return packageUnit;
    }

    /**
     * 设置packageUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageUnit(String value) {
        this.packageUnit = value;
    }

    /**
     * 获取packageUnitDesp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageUnitDesp() {
        return packageUnitDesp;
    }

    /**
     * 设置packageUnitDesp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageUnitDesp(String value) {
        this.packageUnitDesp = value;
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
     * 获取retailPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetailPrice() {
        return retailPrice;
    }

    /**
     * 设置retailPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetailPrice(String value) {
        this.retailPrice = value;
    }

    /**
     * 获取tradePrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradePrice() {
        return tradePrice;
    }

    /**
     * 设置tradePrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradePrice(String value) {
        this.tradePrice = value;
    }

    /**
     * 获取purchasePrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * 设置purchasePrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchasePrice(String value) {
        this.purchasePrice = value;
    }

    /**
     * 获取phamPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhamPrice() {
        return phamPrice;
    }

    /**
     * 设置phamPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhamPrice(String value) {
        this.phamPrice = value;
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
     * 获取drugValua属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugValua() {
        return drugValua;
    }

    /**
     * 设置drugValua属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugValua(String value) {
        this.drugValua = value;
    }

    /**
     * 获取toxicologyProperty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToxicologyProperty() {
        return toxicologyProperty;
    }

    /**
     * 设置toxicologyProperty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToxicologyProperty(String value) {
        this.toxicologyProperty = value;
    }

    /**
     * 获取toxicologyPropertyDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToxicologyPropertyDesc() {
        return toxicologyPropertyDesc;
    }

    /**
     * 设置toxicologyPropertyDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToxicologyPropertyDesc(String value) {
        this.toxicologyPropertyDesc = value;
    }

    /**
     * 获取drugCodeYl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugCodeYl() {
        return drugCodeYl;
    }

    /**
     * 设置drugCodeYl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugCodeYl(String value) {
        this.drugCodeYl = value;
    }

    /**
     * 获取drugCodeYlName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugCodeYlName() {
        return drugCodeYlName;
    }

    /**
     * 设置drugCodeYlName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugCodeYlName(String value) {
        this.drugCodeYlName = value;
    }

    /**
     * 获取drugDosageFrom属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugDosageFrom() {
        return drugDosageFrom;
    }

    /**
     * 设置drugDosageFrom属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugDosageFrom(String value) {
        this.drugDosageFrom = value;
    }

    /**
     * 获取drugDosageFromDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugDosageFromDesc() {
        return drugDosageFromDesc;
    }

    /**
     * 设置drugDosageFromDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugDosageFromDesc(String value) {
        this.drugDosageFromDesc = value;
    }

    /**
     * 获取defUsageCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefUsageCode() {
        return defUsageCode;
    }

    /**
     * 设置defUsageCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefUsageCode(String value) {
        this.defUsageCode = value;
    }

    /**
     * 获取defFreqCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefFreqCode() {
        return defFreqCode;
    }

    /**
     * 设置defFreqCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefFreqCode(String value) {
        this.defFreqCode = value;
    }

    /**
     * 获取defPerDose属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefPerDose() {
        return defPerDose;
    }

    /**
     * 设置defPerDose属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefPerDose(String value) {
        this.defPerDose = value;
    }

    /**
     * 获取defPerQuan属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefPerQuan() {
        return defPerQuan;
    }

    /**
     * 设置defPerQuan属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefPerQuan(String value) {
        this.defPerQuan = value;
    }

    /**
     * 获取defCourse属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefCourse() {
        return defCourse;
    }

    /**
     * 设置defCourse属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefCourse(String value) {
        this.defCourse = value;
    }

    /**
     * 获取manageLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManageLevel() {
        return manageLevel;
    }

    /**
     * 设置manageLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManageLevel(String value) {
        this.manageLevel = value;
    }

    /**
     * 获取highRiskLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHighRiskLevel() {
        return highRiskLevel;
    }

    /**
     * 设置highRiskLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHighRiskLevel(String value) {
        this.highRiskLevel = value;
    }

    /**
     * 获取phamSimilar属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhamSimilar() {
        return phamSimilar;
    }

    /**
     * 设置phamSimilar属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhamSimilar(String value) {
        this.phamSimilar = value;
    }

    /**
     * 获取drugAntimiType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugAntimiType() {
        return drugAntimiType;
    }

    /**
     * 设置drugAntimiType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugAntimiType(String value) {
        this.drugAntimiType = value;
    }

    /**
     * 获取isOral属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsOral() {
        return isOral;
    }

    /**
     * 设置isOral属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsOral(String value) {
        this.isOral = value;
    }

    /**
     * 获取pivasFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPivasFlag() {
        return pivasFlag;
    }

    /**
     * 设置pivasFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPivasFlag(String value) {
        this.pivasFlag = value;
    }

    /**
     * 获取antiTumour属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAntiTumour() {
        return antiTumour;
    }

    /**
     * 设置antiTumour属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAntiTumour(String value) {
        this.antiTumour = value;
    }

    /**
     * 获取largeVolumeLiquidFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLargeVolumeLiquidFlag() {
        return largeVolumeLiquidFlag;
    }

    /**
     * 设置largeVolumeLiquidFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLargeVolumeLiquidFlag(String value) {
        this.largeVolumeLiquidFlag = value;
    }

    /**
     * 获取largePackSmallDoseFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLargePackSmallDoseFlag() {
        return largePackSmallDoseFlag;
    }

    /**
     * 设置largePackSmallDoseFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLargePackSmallDoseFlag(String value) {
        this.largePackSmallDoseFlag = value;
    }

    /**
     * 获取specialSeparableFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialSeparableFlag() {
        return specialSeparableFlag;
    }

    /**
     * 设置specialSeparableFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialSeparableFlag(String value) {
        this.specialSeparableFlag = value;
    }

    /**
     * 获取gmpFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGmpFlag() {
        return gmpFlag;
    }

    /**
     * 设置gmpFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGmpFlag(String value) {
        this.gmpFlag = value;
    }

    /**
     * 获取injectionDrugFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInjectionDrugFlag() {
        return injectionDrugFlag;
    }

    /**
     * 设置injectionDrugFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInjectionDrugFlag(String value) {
        this.injectionDrugFlag = value;
    }

    /**
     * 获取basicPham属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasicPham() {
        return basicPham;
    }

    /**
     * 设置basicPham属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasicPham(String value) {
        this.basicPham = value;
    }

    /**
     * 获取skinTestFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinTestFlag() {
        return skinTestFlag;
    }

    /**
     * 设置skinTestFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinTestFlag(String value) {
        this.skinTestFlag = value;
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
     * 获取outProportion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutProportion() {
        return outProportion;
    }

    /**
     * 设置outProportion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutProportion(String value) {
        this.outProportion = value;
    }

    /**
     * 获取inpProportion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInpProportion() {
        return inpProportion;
    }

    /**
     * 设置inpProportion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInpProportion(String value) {
        this.inpProportion = value;
    }

    /**
     * 获取insurLevelCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsurLevelCode() {
        return insurLevelCode;
    }

    /**
     * 设置insurLevelCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsurLevelCode(String value) {
        this.insurLevelCode = value;
    }

    /**
     * 获取drugOiSign属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugOiSign() {
        return drugOiSign;
    }

    /**
     * 设置drugOiSign属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugOiSign(String value) {
        this.drugOiSign = value;
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

}
