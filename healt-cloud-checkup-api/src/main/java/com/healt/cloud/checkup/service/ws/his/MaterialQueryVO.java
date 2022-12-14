
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>materialQueryVO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="materialQueryVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MaterialInfoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialClassCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialAlias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpecificationValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ModelValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MeasureUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ManufacturersCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SupplyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Manufacturers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PlaceOrigin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CostPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SellPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TenderPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SupplyUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsDurable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialTexture" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PackagesName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialSite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GoodsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CertificateEnDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CertificateUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AbcType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BarcodeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CertificateNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GoodsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsCharge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsHighValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ImportSign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsSterilization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsDisposable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsImplantation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UseScope" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Creator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CreatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CreateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ModifierTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Modifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ModifierName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StopUseDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DeleteFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "materialQueryVO", propOrder = {
    "materialInfoId",
    "materialClassName",
    "materialClassCode",
    "materialCode",
    "materialName",
    "pyCode",
    "materialAlias",
    "specificationValue",
    "modelValue",
    "measureUnit",
    "manufacturersCode",
    "supplyName",
    "manufacturers",
    "placeOrigin",
    "costPrice",
    "sellPrice",
    "tenderPrice",
    "supplyUnit",
    "isDurable",
    "materialTexture",
    "packagesName",
    "materialSite",
    "goodsName",
    "certificateEnDate",
    "certificateUnit",
    "abcType",
    "isCode",
    "barcodeType",
    "certificateNo",
    "brandName",
    "goodsCode",
    "isCharge",
    "isHighValue",
    "importSign",
    "isSterilization",
    "isDisposable",
    "isImplantation",
    "useScope",
    "creator",
    "creatorName",
    "createTime",
    "modifierTime",
    "modifier",
    "modifierName",
    "isEnable",
    "stopUseDate",
    "deleteFlag",
    "descn"
})
public class MaterialQueryVO {

    @XmlElement(name = "MaterialInfoId")
    protected String materialInfoId;
    @XmlElement(name = "MaterialClassName")
    protected String materialClassName;
    @XmlElement(name = "MaterialClassCode")
    protected String materialClassCode;
    @XmlElement(name = "MaterialCode")
    protected String materialCode;
    @XmlElement(name = "MaterialName")
    protected String materialName;
    @XmlElement(name = "PyCode")
    protected String pyCode;
    @XmlElement(name = "MaterialAlias")
    protected String materialAlias;
    @XmlElement(name = "SpecificationValue")
    protected String specificationValue;
    @XmlElement(name = "ModelValue")
    protected String modelValue;
    @XmlElement(name = "MeasureUnit")
    protected String measureUnit;
    @XmlElement(name = "ManufacturersCode")
    protected String manufacturersCode;
    @XmlElement(name = "SupplyName")
    protected String supplyName;
    @XmlElement(name = "Manufacturers")
    protected String manufacturers;
    @XmlElement(name = "PlaceOrigin")
    protected String placeOrigin;
    @XmlElement(name = "CostPrice")
    protected String costPrice;
    @XmlElement(name = "SellPrice")
    protected String sellPrice;
    @XmlElement(name = "TenderPrice")
    protected String tenderPrice;
    @XmlElement(name = "SupplyUnit")
    protected String supplyUnit;
    @XmlElement(name = "IsDurable")
    protected String isDurable;
    @XmlElement(name = "MaterialTexture")
    protected String materialTexture;
    @XmlElement(name = "PackagesName")
    protected String packagesName;
    @XmlElement(name = "MaterialSite")
    protected String materialSite;
    @XmlElement(name = "GoodsName")
    protected String goodsName;
    @XmlElement(name = "CertificateEnDate")
    protected String certificateEnDate;
    @XmlElement(name = "CertificateUnit")
    protected String certificateUnit;
    @XmlElement(name = "AbcType")
    protected String abcType;
    @XmlElement(name = "IsCode")
    protected String isCode;
    @XmlElement(name = "BarcodeType")
    protected String barcodeType;
    @XmlElement(name = "CertificateNo")
    protected String certificateNo;
    @XmlElement(name = "BrandName")
    protected String brandName;
    @XmlElement(name = "GoodsCode")
    protected String goodsCode;
    @XmlElement(name = "IsCharge")
    protected String isCharge;
    @XmlElement(name = "IsHighValue")
    protected String isHighValue;
    @XmlElement(name = "ImportSign")
    protected String importSign;
    @XmlElement(name = "IsSterilization")
    protected String isSterilization;
    @XmlElement(name = "IsDisposable")
    protected String isDisposable;
    @XmlElement(name = "IsImplantation")
    protected String isImplantation;
    @XmlElement(name = "UseScope")
    protected String useScope;
    @XmlElement(name = "Creator")
    protected String creator;
    @XmlElement(name = "CreatorName")
    protected String creatorName;
    @XmlElement(name = "CreateTime")
    protected String createTime;
    @XmlElement(name = "ModifierTime")
    protected String modifierTime;
    @XmlElement(name = "Modifier")
    protected String modifier;
    @XmlElement(name = "ModifierName")
    protected String modifierName;
    @XmlElement(name = "IsEnable")
    protected String isEnable;
    @XmlElement(name = "StopUseDate")
    protected String stopUseDate;
    @XmlElement(name = "DeleteFlag")
    protected String deleteFlag;
    @XmlElement(name = "Descn")
    protected String descn;

    /**
     * 获取materialInfoId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialInfoId() {
        return materialInfoId;
    }

    /**
     * 设置materialInfoId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialInfoId(String value) {
        this.materialInfoId = value;
    }

    /**
     * 获取materialClassName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialClassName() {
        return materialClassName;
    }

    /**
     * 设置materialClassName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialClassName(String value) {
        this.materialClassName = value;
    }

    /**
     * 获取materialClassCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialClassCode() {
        return materialClassCode;
    }

    /**
     * 设置materialClassCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialClassCode(String value) {
        this.materialClassCode = value;
    }

    /**
     * 获取materialCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialCode() {
        return materialCode;
    }

    /**
     * 设置materialCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialCode(String value) {
        this.materialCode = value;
    }

    /**
     * 获取materialName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * 设置materialName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialName(String value) {
        this.materialName = value;
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
     * 获取materialAlias属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialAlias() {
        return materialAlias;
    }

    /**
     * 设置materialAlias属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialAlias(String value) {
        this.materialAlias = value;
    }

    /**
     * 获取specificationValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecificationValue() {
        return specificationValue;
    }

    /**
     * 设置specificationValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecificationValue(String value) {
        this.specificationValue = value;
    }

    /**
     * 获取modelValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelValue() {
        return modelValue;
    }

    /**
     * 设置modelValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelValue(String value) {
        this.modelValue = value;
    }

    /**
     * 获取measureUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasureUnit() {
        return measureUnit;
    }

    /**
     * 设置measureUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasureUnit(String value) {
        this.measureUnit = value;
    }

    /**
     * 获取manufacturersCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturersCode() {
        return manufacturersCode;
    }

    /**
     * 设置manufacturersCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturersCode(String value) {
        this.manufacturersCode = value;
    }

    /**
     * 获取supplyName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplyName() {
        return supplyName;
    }

    /**
     * 设置supplyName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplyName(String value) {
        this.supplyName = value;
    }

    /**
     * 获取manufacturers属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturers() {
        return manufacturers;
    }

    /**
     * 设置manufacturers属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturers(String value) {
        this.manufacturers = value;
    }

    /**
     * 获取placeOrigin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceOrigin() {
        return placeOrigin;
    }

    /**
     * 设置placeOrigin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceOrigin(String value) {
        this.placeOrigin = value;
    }

    /**
     * 获取costPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCostPrice() {
        return costPrice;
    }

    /**
     * 设置costPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCostPrice(String value) {
        this.costPrice = value;
    }

    /**
     * 获取sellPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellPrice() {
        return sellPrice;
    }

    /**
     * 设置sellPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellPrice(String value) {
        this.sellPrice = value;
    }

    /**
     * 获取tenderPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenderPrice() {
        return tenderPrice;
    }

    /**
     * 设置tenderPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenderPrice(String value) {
        this.tenderPrice = value;
    }

    /**
     * 获取supplyUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplyUnit() {
        return supplyUnit;
    }

    /**
     * 设置supplyUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplyUnit(String value) {
        this.supplyUnit = value;
    }

    /**
     * 获取isDurable属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsDurable() {
        return isDurable;
    }

    /**
     * 设置isDurable属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsDurable(String value) {
        this.isDurable = value;
    }

    /**
     * 获取materialTexture属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialTexture() {
        return materialTexture;
    }

    /**
     * 设置materialTexture属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialTexture(String value) {
        this.materialTexture = value;
    }

    /**
     * 获取packagesName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackagesName() {
        return packagesName;
    }

    /**
     * 设置packagesName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackagesName(String value) {
        this.packagesName = value;
    }

    /**
     * 获取materialSite属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialSite() {
        return materialSite;
    }

    /**
     * 设置materialSite属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialSite(String value) {
        this.materialSite = value;
    }

    /**
     * 获取goodsName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置goodsName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodsName(String value) {
        this.goodsName = value;
    }

    /**
     * 获取certificateEnDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateEnDate() {
        return certificateEnDate;
    }

    /**
     * 设置certificateEnDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateEnDate(String value) {
        this.certificateEnDate = value;
    }

    /**
     * 获取certificateUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateUnit() {
        return certificateUnit;
    }

    /**
     * 设置certificateUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateUnit(String value) {
        this.certificateUnit = value;
    }

    /**
     * 获取abcType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbcType() {
        return abcType;
    }

    /**
     * 设置abcType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbcType(String value) {
        this.abcType = value;
    }

    /**
     * 获取isCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsCode() {
        return isCode;
    }

    /**
     * 设置isCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsCode(String value) {
        this.isCode = value;
    }

    /**
     * 获取barcodeType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarcodeType() {
        return barcodeType;
    }

    /**
     * 设置barcodeType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarcodeType(String value) {
        this.barcodeType = value;
    }

    /**
     * 获取certificateNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateNo() {
        return certificateNo;
    }

    /**
     * 设置certificateNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateNo(String value) {
        this.certificateNo = value;
    }

    /**
     * 获取brandName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置brandName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrandName(String value) {
        this.brandName = value;
    }

    /**
     * 获取goodsCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodsCode() {
        return goodsCode;
    }

    /**
     * 设置goodsCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodsCode(String value) {
        this.goodsCode = value;
    }

    /**
     * 获取isCharge属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsCharge() {
        return isCharge;
    }

    /**
     * 设置isCharge属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsCharge(String value) {
        this.isCharge = value;
    }

    /**
     * 获取isHighValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsHighValue() {
        return isHighValue;
    }

    /**
     * 设置isHighValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsHighValue(String value) {
        this.isHighValue = value;
    }

    /**
     * 获取importSign属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportSign() {
        return importSign;
    }

    /**
     * 设置importSign属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportSign(String value) {
        this.importSign = value;
    }

    /**
     * 获取isSterilization属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsSterilization() {
        return isSterilization;
    }

    /**
     * 设置isSterilization属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsSterilization(String value) {
        this.isSterilization = value;
    }

    /**
     * 获取isDisposable属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsDisposable() {
        return isDisposable;
    }

    /**
     * 设置isDisposable属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsDisposable(String value) {
        this.isDisposable = value;
    }

    /**
     * 获取isImplantation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsImplantation() {
        return isImplantation;
    }

    /**
     * 设置isImplantation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsImplantation(String value) {
        this.isImplantation = value;
    }

    /**
     * 获取useScope属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUseScope() {
        return useScope;
    }

    /**
     * 设置useScope属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUseScope(String value) {
        this.useScope = value;
    }

    /**
     * 获取creator属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置creator属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreator(String value) {
        this.creator = value;
    }

    /**
     * 获取creatorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * 设置creatorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorName(String value) {
        this.creatorName = value;
    }

    /**
     * 获取createTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置createTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateTime(String value) {
        this.createTime = value;
    }

    /**
     * 获取modifierTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifierTime() {
        return modifierTime;
    }

    /**
     * 设置modifierTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifierTime(String value) {
        this.modifierTime = value;
    }

    /**
     * 获取modifier属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置modifier属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifier(String value) {
        this.modifier = value;
    }

    /**
     * 获取modifierName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifierName() {
        return modifierName;
    }

    /**
     * 设置modifierName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifierName(String value) {
        this.modifierName = value;
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
     * 获取stopUseDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopUseDate() {
        return stopUseDate;
    }

    /**
     * 设置stopUseDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopUseDate(String value) {
        this.stopUseDate = value;
    }

    /**
     * 获取deleteFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置deleteFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeleteFlag(String value) {
        this.deleteFlag = value;
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
