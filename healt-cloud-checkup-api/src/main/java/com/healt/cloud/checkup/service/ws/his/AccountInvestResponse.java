
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>accountInvestResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="accountInvestResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RechargeInfo" type="{http://wegohis.com}accountInvestRechargeInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountInvestResponse", propOrder = {
    "rechargeInfo"
})
public class AccountInvestResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "RechargeInfo")
    protected AccountInvestRechargeInfo rechargeInfo;

    /**
     * 获取rechargeInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AccountInvestRechargeInfo }
     *     
     */
    public AccountInvestRechargeInfo getRechargeInfo() {
        return rechargeInfo;
    }

    /**
     * 设置rechargeInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AccountInvestRechargeInfo }
     *     
     */
    public void setRechargeInfo(AccountInvestRechargeInfo value) {
        this.rechargeInfo = value;
    }

}
