
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>accountInvestRechargeInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="accountInvestRechargeInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RechargeAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OperateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AccountBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdvanceRecordId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountInvestRechargeInfo", propOrder = {
    "rechargeAmount",
    "operateTime",
    "accountBalance",
    "advanceRecordId"
})
public class AccountInvestRechargeInfo {

    @XmlElement(name = "RechargeAmount")
    protected String rechargeAmount;
    @XmlElement(name = "OperateTime")
    protected String operateTime;
    @XmlElement(name = "AccountBalance")
    protected String accountBalance;
    @XmlElement(name = "AdvanceRecordId")
    protected String advanceRecordId;

    /**
     * 获取rechargeAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRechargeAmount() {
        return rechargeAmount;
    }

    /**
     * 设置rechargeAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRechargeAmount(String value) {
        this.rechargeAmount = value;
    }

    /**
     * 获取operateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperateTime() {
        return operateTime;
    }

    /**
     * 设置operateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperateTime(String value) {
        this.operateTime = value;
    }

    /**
     * 获取accountBalance属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountBalance() {
        return accountBalance;
    }

    /**
     * 设置accountBalance属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountBalance(String value) {
        this.accountBalance = value;
    }

    /**
     * 获取advanceRecordId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvanceRecordId() {
        return advanceRecordId;
    }

    /**
     * 设置advanceRecordId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvanceRecordId(String value) {
        this.advanceRecordId = value;
    }

}
