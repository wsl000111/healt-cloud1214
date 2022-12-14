
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>prescriptionPO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="prescriptionPO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AuditStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SkinTestResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StockNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StockInstruction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="execOrgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="drugFactCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="factor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="totalNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="drugFactName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prescriptionPO", propOrder = {
    "orderCode",
    "auditStatus",
    "skinTestResult",
    "stockNum",
    "stockInstruction",
    "execOrgCode",
    "drugFactCode",
    "factor",
    "totalNum",
    "orderId",
    "drugFactName"
})
public class PrescriptionPO {

    @XmlElement(name = "OrderCode")
    protected String orderCode;
    @XmlElement(name = "AuditStatus")
    protected String auditStatus;
    @XmlElement(name = "SkinTestResult")
    protected String skinTestResult;
    @XmlElement(name = "StockNum")
    protected String stockNum;
    @XmlElement(name = "StockInstruction")
    protected String stockInstruction;
    protected String execOrgCode;
    protected String drugFactCode;
    protected String factor;
    protected String totalNum;
    protected String orderId;
    protected String drugFactName;

    /**
     * 获取orderCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 设置orderCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderCode(String value) {
        this.orderCode = value;
    }

    /**
     * 获取auditStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置auditStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditStatus(String value) {
        this.auditStatus = value;
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
     * 获取stockInstruction属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStockInstruction() {
        return stockInstruction;
    }

    /**
     * 设置stockInstruction属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStockInstruction(String value) {
        this.stockInstruction = value;
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
     * 获取drugFactName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugFactName() {
        return drugFactName;
    }

    /**
     * 设置drugFactName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugFactName(String value) {
        this.drugFactName = value;
    }

}
