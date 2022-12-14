
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>accountInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="accountInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TotalChargeAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TotalRefundAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoundingAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TotalAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PayableCash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BeginInvNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EndInvNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TotalInvNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TotalOperNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccountDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OperSettleId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TerminalNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InOutFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountInfo", propOrder = {
    "totalChargeAmount",
    "totalRefundAmount",
    "roundingAmount",
    "totalAmount",
    "payableCash",
    "beginInvNo",
    "endInvNo",
    "totalInvNum",
    "totalOperNum",
    "accountDate",
    "operSettleId",
    "terminalNo",
    "inOutFlag"
})
public class AccountInfo {

    @XmlElement(name = "TotalChargeAmount")
    protected String totalChargeAmount;
    @XmlElement(name = "TotalRefundAmount")
    protected String totalRefundAmount;
    @XmlElement(name = "RoundingAmount")
    protected String roundingAmount;
    @XmlElement(name = "TotalAmount")
    protected String totalAmount;
    @XmlElement(name = "PayableCash")
    protected String payableCash;
    @XmlElement(name = "BeginInvNo")
    protected String beginInvNo;
    @XmlElement(name = "EndInvNo")
    protected String endInvNo;
    @XmlElement(name = "TotalInvNum")
    protected String totalInvNum;
    @XmlElement(name = "TotalOperNum")
    protected String totalOperNum;
    @XmlElement(name = "AccountDate")
    protected String accountDate;
    @XmlElement(name = "OperSettleId")
    protected String operSettleId;
    @XmlElement(name = "TerminalNo")
    protected String terminalNo;
    @XmlElement(name = "InOutFlag")
    protected String inOutFlag;

    /**
     * 获取totalChargeAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalChargeAmount() {
        return totalChargeAmount;
    }

    /**
     * 设置totalChargeAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalChargeAmount(String value) {
        this.totalChargeAmount = value;
    }

    /**
     * 获取totalRefundAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalRefundAmount() {
        return totalRefundAmount;
    }

    /**
     * 设置totalRefundAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalRefundAmount(String value) {
        this.totalRefundAmount = value;
    }

    /**
     * 获取roundingAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoundingAmount() {
        return roundingAmount;
    }

    /**
     * 设置roundingAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoundingAmount(String value) {
        this.roundingAmount = value;
    }

    /**
     * 获取totalAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置totalAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalAmount(String value) {
        this.totalAmount = value;
    }

    /**
     * 获取payableCash属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayableCash() {
        return payableCash;
    }

    /**
     * 设置payableCash属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayableCash(String value) {
        this.payableCash = value;
    }

    /**
     * 获取beginInvNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginInvNo() {
        return beginInvNo;
    }

    /**
     * 设置beginInvNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginInvNo(String value) {
        this.beginInvNo = value;
    }

    /**
     * 获取endInvNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndInvNo() {
        return endInvNo;
    }

    /**
     * 设置endInvNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndInvNo(String value) {
        this.endInvNo = value;
    }

    /**
     * 获取totalInvNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalInvNum() {
        return totalInvNum;
    }

    /**
     * 设置totalInvNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalInvNum(String value) {
        this.totalInvNum = value;
    }

    /**
     * 获取totalOperNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalOperNum() {
        return totalOperNum;
    }

    /**
     * 设置totalOperNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalOperNum(String value) {
        this.totalOperNum = value;
    }

    /**
     * 获取accountDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountDate() {
        return accountDate;
    }

    /**
     * 设置accountDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountDate(String value) {
        this.accountDate = value;
    }

    /**
     * 获取operSettleId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperSettleId() {
        return operSettleId;
    }

    /**
     * 设置operSettleId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperSettleId(String value) {
        this.operSettleId = value;
    }

    /**
     * 获取terminalNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalNo() {
        return terminalNo;
    }

    /**
     * 设置terminalNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalNo(String value) {
        this.terminalNo = value;
    }

    /**
     * 获取inOutFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInOutFlag() {
        return inOutFlag;
    }

    /**
     * 设置inOutFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInOutFlag(String value) {
        this.inOutFlag = value;
    }

}
