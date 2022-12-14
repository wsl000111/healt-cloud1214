
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>notPayDetailQuery complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="notPayDetailQuery"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OutpItemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderItemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TreatmentNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PrescrType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeItemClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClinicItemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClinicItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClinicType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeItemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DrugSpec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PharmacyFactoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UnitPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UnitCoeff" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TotalPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Descn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SettId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccurOperator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccurOperatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccurTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OldOutpItemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ChargeFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExecFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AddFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExzamFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="patientId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="visitId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="areaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notPayDetailQuery", propOrder = {
    "outpItemId",
    "orderId",
    "orderItemId",
    "treatmentNo",
    "orderType",
    "prescrType",
    "feeItemClass",
    "clinicItemId",
    "clinicItemName",
    "clinicType",
    "feeItemId",
    "feeItemName",
    "drugSpec",
    "pharmacyFactoryName",
    "num",
    "unit",
    "unitPrice",
    "unitCoeff",
    "totalPrice",
    "descn",
    "settId",
    "accurOperator",
    "accurOperatorName",
    "accurTime",
    "oldOutpItemId",
    "orderSource",
    "chargeFlag",
    "execFlag",
    "addFlag",
    "itemType",
    "exzamFlag",
    "patientId",
    "visitId",
    "areaCode",
    "startDate",
    "endDate"
})
public class NotPayDetailQuery {

    @XmlElement(name = "OutpItemId")
    protected String outpItemId;
    @XmlElement(name = "OrderId")
    protected String orderId;
    @XmlElement(name = "OrderItemId")
    protected String orderItemId;
    @XmlElement(name = "TreatmentNo")
    protected String treatmentNo;
    @XmlElement(name = "OrderType")
    protected String orderType;
    @XmlElement(name = "PrescrType")
    protected String prescrType;
    @XmlElement(name = "FeeItemClass")
    protected String feeItemClass;
    @XmlElement(name = "ClinicItemId")
    protected String clinicItemId;
    @XmlElement(name = "ClinicItemName")
    protected String clinicItemName;
    @XmlElement(name = "ClinicType")
    protected String clinicType;
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
    @XmlElement(name = "Descn")
    protected String descn;
    @XmlElement(name = "SettId")
    protected String settId;
    @XmlElement(name = "AccurOperator")
    protected String accurOperator;
    @XmlElement(name = "AccurOperatorName")
    protected String accurOperatorName;
    @XmlElement(name = "AccurTime")
    protected String accurTime;
    @XmlElement(name = "OldOutpItemId")
    protected String oldOutpItemId;
    @XmlElement(name = "OrderSource")
    protected String orderSource;
    @XmlElement(name = "ChargeFlag")
    protected String chargeFlag;
    @XmlElement(name = "ExecFlag")
    protected String execFlag;
    @XmlElement(name = "AddFlag")
    protected String addFlag;
    @XmlElement(name = "ItemType")
    protected String itemType;
    @XmlElement(name = "ExzamFlag")
    protected String exzamFlag;
    protected String patientId;
    protected String visitId;
    protected String areaCode;
    protected String startDate;
    protected String endDate;

    /**
     * 获取outpItemId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpItemId() {
        return outpItemId;
    }

    /**
     * 设置outpItemId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpItemId(String value) {
        this.outpItemId = value;
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
     * 获取treatmentNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTreatmentNo() {
        return treatmentNo;
    }

    /**
     * 设置treatmentNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTreatmentNo(String value) {
        this.treatmentNo = value;
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
     * 获取settId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettId() {
        return settId;
    }

    /**
     * 设置settId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettId(String value) {
        this.settId = value;
    }

    /**
     * 获取accurOperator属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccurOperator() {
        return accurOperator;
    }

    /**
     * 设置accurOperator属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccurOperator(String value) {
        this.accurOperator = value;
    }

    /**
     * 获取accurOperatorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccurOperatorName() {
        return accurOperatorName;
    }

    /**
     * 设置accurOperatorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccurOperatorName(String value) {
        this.accurOperatorName = value;
    }

    /**
     * 获取accurTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccurTime() {
        return accurTime;
    }

    /**
     * 设置accurTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccurTime(String value) {
        this.accurTime = value;
    }

    /**
     * 获取oldOutpItemId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldOutpItemId() {
        return oldOutpItemId;
    }

    /**
     * 设置oldOutpItemId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldOutpItemId(String value) {
        this.oldOutpItemId = value;
    }

    /**
     * 获取orderSource属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderSource() {
        return orderSource;
    }

    /**
     * 设置orderSource属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderSource(String value) {
        this.orderSource = value;
    }

    /**
     * 获取chargeFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeFlag() {
        return chargeFlag;
    }

    /**
     * 设置chargeFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeFlag(String value) {
        this.chargeFlag = value;
    }

    /**
     * 获取execFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecFlag() {
        return execFlag;
    }

    /**
     * 设置execFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecFlag(String value) {
        this.execFlag = value;
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
     * 获取startDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 设置startDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * 获取endDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 设置endDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

}
