
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>payDetailQuery complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="payDetailQuery"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BillId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClinicType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeItemClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClinicItemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClinicItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeItemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugSpec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PharmacyFactoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UnitPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UnitCoeff" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TotalPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Charges" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClassOnRcpt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClinicPropertyClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ApplyDoctorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ApplyDoctorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ApplyOrgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ApplyOrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentOrgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentOrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWardName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExecOrgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Occupation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RefundFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RelRefundId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ChargeDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EnterDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InvoicePrintFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AddFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InsurLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExzamFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payDetailQuery", propOrder = {
    "orderId",
    "billId",
    "clinicType",
    "feeItemClass",
    "clinicItemId",
    "clinicItemName",
    "itemType",
    "feeItemId",
    "feeItemName",
    "drugSpec",
    "pharmacyFactoryName",
    "num",
    "unit",
    "unitPrice",
    "unitCoeff",
    "totalPrice",
    "charges",
    "classOnRcpt",
    "clinicPropertyClass",
    "applyDoctorCode",
    "applyDoctorName",
    "applyOrgCode",
    "applyOrgName",
    "currentOrgCode",
    "currentOrgName",
    "currentWardCode",
    "currentWardName",
    "execOrgCode",
    "occupation",
    "refundFlag",
    "relRefundId",
    "chargeDate",
    "enterDate",
    "invoicePrintFlag",
    "orderType",
    "addFlag",
    "insurLevelCode",
    "exzamFlag"
})
public class PayDetailQuery {

    @XmlElement(name = "OrderId")
    protected String orderId;
    @XmlElement(name = "BillId")
    protected String billId;
    @XmlElement(name = "ClinicType")
    protected String clinicType;
    @XmlElement(name = "FeeItemClass")
    protected String feeItemClass;
    @XmlElement(name = "ClinicItemId")
    protected String clinicItemId;
    @XmlElement(name = "ClinicItemName")
    protected String clinicItemName;
    @XmlElement(name = "ItemType")
    protected String itemType;
    @XmlElement(name = "FeeItemId")
    protected String feeItemId;
    @XmlElement(name = "FeeItemName")
    protected String feeItemName;
    @XmlElement(name = "DrugSpec")
    protected String drugSpec;
    @XmlElement(name = "PharmacyFactoryName")
    protected String pharmacyFactoryName;
    @XmlElement(name = "Num")
    protected String num;
    @XmlElement(name = "Unit")
    protected String unit;
    @XmlElement(name = "UnitPrice")
    protected String unitPrice;
    @XmlElement(name = "UnitCoeff")
    protected String unitCoeff;
    @XmlElement(name = "TotalPrice")
    protected String totalPrice;
    @XmlElement(name = "Charges")
    protected String charges;
    @XmlElement(name = "ClassOnRcpt")
    protected String classOnRcpt;
    @XmlElement(name = "ClinicPropertyClass")
    protected String clinicPropertyClass;
    @XmlElement(name = "ApplyDoctorCode")
    protected String applyDoctorCode;
    @XmlElement(name = "ApplyDoctorName")
    protected String applyDoctorName;
    @XmlElement(name = "ApplyOrgCode")
    protected String applyOrgCode;
    @XmlElement(name = "ApplyOrgName")
    protected String applyOrgName;
    @XmlElement(name = "CurrentOrgCode")
    protected String currentOrgCode;
    @XmlElement(name = "CurrentOrgName")
    protected String currentOrgName;
    @XmlElement(name = "CurrentWardCode")
    protected String currentWardCode;
    @XmlElement(name = "CurrentWardName")
    protected String currentWardName;
    @XmlElement(name = "ExecOrgCode")
    protected String execOrgCode;
    @XmlElement(name = "Occupation")
    protected String occupation;
    @XmlElement(name = "RefundFlag")
    protected String refundFlag;
    @XmlElement(name = "RelRefundId")
    protected String relRefundId;
    @XmlElement(name = "ChargeDate")
    protected String chargeDate;
    @XmlElement(name = "EnterDate")
    protected String enterDate;
    @XmlElement(name = "InvoicePrintFlag")
    protected String invoicePrintFlag;
    @XmlElement(name = "OrderType")
    protected String orderType;
    @XmlElement(name = "AddFlag")
    protected String addFlag;
    @XmlElement(name = "InsurLevelCode")
    protected String insurLevelCode;
    @XmlElement(name = "ExzamFlag")
    protected String exzamFlag;

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
     * 获取billId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillId() {
        return billId;
    }

    /**
     * 设置billId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillId(String value) {
        this.billId = value;
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
     * 获取feeItemClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeItemClass() {
        return feeItemClass;
    }

    /**
     * 设置feeItemClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeItemClass(String value) {
        this.feeItemClass = value;
    }

    /**
     * 获取clinicItemId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClinicItemId() {
        return clinicItemId;
    }

    /**
     * 设置clinicItemId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClinicItemId(String value) {
        this.clinicItemId = value;
    }

    /**
     * 获取clinicItemName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClinicItemName() {
        return clinicItemName;
    }

    /**
     * 设置clinicItemName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClinicItemName(String value) {
        this.clinicItemName = value;
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
     * 获取feeItemId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeItemId() {
        return feeItemId;
    }

    /**
     * 设置feeItemId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeItemId(String value) {
        this.feeItemId = value;
    }

    /**
     * 获取feeItemName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeItemName() {
        return feeItemName;
    }

    /**
     * 设置feeItemName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeItemName(String value) {
        this.feeItemName = value;
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
     * 获取num属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置num属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNum(String value) {
        this.num = value;
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
     * 获取unitPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitPrice() {
        return unitPrice;
    }

    /**
     * 设置unitPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitPrice(String value) {
        this.unitPrice = value;
    }

    /**
     * 获取unitCoeff属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitCoeff() {
        return unitCoeff;
    }

    /**
     * 设置unitCoeff属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitCoeff(String value) {
        this.unitCoeff = value;
    }

    /**
     * 获取totalPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置totalPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalPrice(String value) {
        this.totalPrice = value;
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
     * 获取classOnRcpt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassOnRcpt() {
        return classOnRcpt;
    }

    /**
     * 设置classOnRcpt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassOnRcpt(String value) {
        this.classOnRcpt = value;
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
     * 获取applyDoctorCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyDoctorCode() {
        return applyDoctorCode;
    }

    /**
     * 设置applyDoctorCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyDoctorCode(String value) {
        this.applyDoctorCode = value;
    }

    /**
     * 获取applyDoctorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyDoctorName() {
        return applyDoctorName;
    }

    /**
     * 设置applyDoctorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyDoctorName(String value) {
        this.applyDoctorName = value;
    }

    /**
     * 获取applyOrgCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyOrgCode() {
        return applyOrgCode;
    }

    /**
     * 设置applyOrgCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyOrgCode(String value) {
        this.applyOrgCode = value;
    }

    /**
     * 获取applyOrgName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyOrgName() {
        return applyOrgName;
    }

    /**
     * 设置applyOrgName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyOrgName(String value) {
        this.applyOrgName = value;
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
     * 获取currentOrgName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentOrgName() {
        return currentOrgName;
    }

    /**
     * 设置currentOrgName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentOrgName(String value) {
        this.currentOrgName = value;
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
     * 获取currentWardName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentWardName() {
        return currentWardName;
    }

    /**
     * 设置currentWardName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentWardName(String value) {
        this.currentWardName = value;
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
     * 获取occupation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * 设置occupation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccupation(String value) {
        this.occupation = value;
    }

    /**
     * 获取refundFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundFlag() {
        return refundFlag;
    }

    /**
     * 设置refundFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundFlag(String value) {
        this.refundFlag = value;
    }

    /**
     * 获取relRefundId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelRefundId() {
        return relRefundId;
    }

    /**
     * 设置relRefundId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelRefundId(String value) {
        this.relRefundId = value;
    }

    /**
     * 获取chargeDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeDate() {
        return chargeDate;
    }

    /**
     * 设置chargeDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeDate(String value) {
        this.chargeDate = value;
    }

    /**
     * 获取enterDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnterDate() {
        return enterDate;
    }

    /**
     * 设置enterDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnterDate(String value) {
        this.enterDate = value;
    }

    /**
     * 获取invoicePrintFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoicePrintFlag() {
        return invoicePrintFlag;
    }

    /**
     * 设置invoicePrintFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoicePrintFlag(String value) {
        this.invoicePrintFlag = value;
    }

    /**
     * 获取orderType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * 设置orderType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderType(String value) {
        this.orderType = value;
    }

    /**
     * 获取addFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddFlag() {
        return addFlag;
    }

    /**
     * 设置addFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddFlag(String value) {
        this.addFlag = value;
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
     * 获取exzamFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExzamFlag() {
        return exzamFlag;
    }

    /**
     * 设置exzamFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExzamFlag(String value) {
        this.exzamFlag = value;
    }

}
