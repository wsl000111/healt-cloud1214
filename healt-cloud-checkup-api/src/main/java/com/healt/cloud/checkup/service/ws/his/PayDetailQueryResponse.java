
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>payDetailQueryResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="payDetailQueryResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PatientInfo" type="{http://wegohis.com}notpayDetailQueryPatientInfoVO" minOccurs="0"/&gt;
 *         &lt;element name="ChargeItemList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ChargeItem" type="{http://wegohis.com}payDetailQuery" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "payDetailQueryResponse", propOrder = {
    "patientInfo",
    "chargeItemList"
})
public class PayDetailQueryResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "PatientInfo")
    protected NotpayDetailQueryPatientInfoVO patientInfo;
    @XmlElement(name = "ChargeItemList")
    protected ChargeItemList chargeItemList;

    /**
     * 获取patientInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link NotpayDetailQueryPatientInfoVO }
     *     
     */
    public NotpayDetailQueryPatientInfoVO getPatientInfo() {
        return patientInfo;
    }

    /**
     * 设置patientInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NotpayDetailQueryPatientInfoVO }
     *     
     */
    public void setPatientInfo(NotpayDetailQueryPatientInfoVO value) {
        this.patientInfo = value;
    }

    /**
     * 获取chargeItemList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ChargeItemList }
     *     
     */
    public ChargeItemList getChargeItemList() {
        return chargeItemList;
    }

    /**
     * 设置chargeItemList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeItemList }
     *     
     */
    public void setChargeItemList(ChargeItemList value) {
        this.chargeItemList = value;
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
     *         &lt;element name="ChargeItem" type="{http://wegohis.com}payDetailQuery" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "chargeItem"
    })
    public static class ChargeItemList {

        @XmlElement(name = "ChargeItem")
        protected List<PayDetailQuery> chargeItem;

        /**
         * Gets the value of the chargeItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the chargeItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getChargeItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PayDetailQuery }
         * 
         * 
         */
        public List<PayDetailQuery> getChargeItem() {
            if (chargeItem == null) {
                chargeItem = new ArrayList<PayDetailQuery>();
            }
            return this.chargeItem;
        }

    }

}
