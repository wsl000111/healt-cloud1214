
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>unpaidAccountQueryResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="unpaidAccountQueryResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccountInfoList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AccountInfo" type="{http://wegohis.com}unpaidAccountInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unpaidAccountQueryResponse", propOrder = {
    "accountInfoList"
})
public class UnpaidAccountQueryResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "AccountInfoList")
    protected AccountInfoList accountInfoList;

    /**
     * 获取accountInfoList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AccountInfoList }
     *     
     */
    public AccountInfoList getAccountInfoList() {
        return accountInfoList;
    }

    /**
     * 设置accountInfoList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AccountInfoList }
     *     
     */
    public void setAccountInfoList(AccountInfoList value) {
        this.accountInfoList = value;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="AccountInfo" type="{http://wegohis.com}unpaidAccountInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "accountInfo"
    })
    public static class AccountInfoList {

        @XmlElement(name = "AccountInfo")
        protected List<UnpaidAccountInfo> accountInfo;

        /**
         * Gets the value of the accountInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the accountInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAccountInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link UnpaidAccountInfo }
         * 
         * 
         */
        public List<UnpaidAccountInfo> getAccountInfo() {
            if (accountInfo == null) {
                accountInfo = new ArrayList<UnpaidAccountInfo>();
            }
            return this.accountInfo;
        }

    }

}
