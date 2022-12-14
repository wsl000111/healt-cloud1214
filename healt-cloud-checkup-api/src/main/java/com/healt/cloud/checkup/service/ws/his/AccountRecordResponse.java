
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>accountRecordResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="accountRecordResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BalanceDetailList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="BalanceDetail" type="{http://wegohis.com}balanceDetail" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "accountRecordResponse", propOrder = {
    "balanceDetailList"
})
public class AccountRecordResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "BalanceDetailList")
    protected BalanceDetailList balanceDetailList;

    /**
     * 获取balanceDetailList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BalanceDetailList }
     *     
     */
    public BalanceDetailList getBalanceDetailList() {
        return balanceDetailList;
    }

    /**
     * 设置balanceDetailList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceDetailList }
     *     
     */
    public void setBalanceDetailList(BalanceDetailList value) {
        this.balanceDetailList = value;
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
     *         &lt;element name="BalanceDetail" type="{http://wegohis.com}balanceDetail" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "balanceDetail"
    })
    public static class BalanceDetailList {

        @XmlElement(name = "BalanceDetail")
        protected List<BalanceDetail> balanceDetail;

        /**
         * Gets the value of the balanceDetail property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the balanceDetail property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBalanceDetail().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BalanceDetail }
         * 
         * 
         */
        public List<BalanceDetail> getBalanceDetail() {
            if (balanceDetail == null) {
                balanceDetail = new ArrayList<BalanceDetail>();
            }
            return this.balanceDetail;
        }

    }

}
