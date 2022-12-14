
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>prepayBalanceResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="prepayBalanceResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccountBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RechargeAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TotalExpenses" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prepayBalanceResponse", propOrder = {
    "accountBalance",
    "rechargeAmount",
    "totalExpenses"
})
public class PrepayBalanceResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "AccountBalance")
    protected String accountBalance;
    @XmlElement(name = "RechargeAmount")
    protected String rechargeAmount;
    @XmlElement(name = "TotalExpenses")
    protected String totalExpenses;

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
     * 获取totalExpenses属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalExpenses() {
        return totalExpenses;
    }

    /**
     * 设置totalExpenses属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalExpenses(String value) {
        this.totalExpenses = value;
    }

}
