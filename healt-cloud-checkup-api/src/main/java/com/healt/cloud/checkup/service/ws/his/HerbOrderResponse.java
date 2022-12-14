
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>herbOrderResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="herbOrderResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MsgLog" type="{http://wegohis.com}baseMsgLog" minOccurs="0"/&gt;
 *         &lt;element name="PatientInfo" type="{http://wegohis.com}outpOrderPatientInfo" minOccurs="0"/&gt;
 *         &lt;element name="OutpOrderList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="OutpOrder" type="{http://wegohis.com}outpOrderInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "herbOrderResponse", propOrder = {
    "msgLog",
    "patientInfo",
    "outpOrderList"
})
public class HerbOrderResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "MsgLog")
    protected BaseMsgLog msgLog;
    @XmlElement(name = "PatientInfo")
    protected OutpOrderPatientInfo patientInfo;
    @XmlElement(name = "OutpOrderList")
    protected OutpOrderList outpOrderList;

    /**
     * 获取msgLog属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BaseMsgLog }
     *     
     */
    public BaseMsgLog getMsgLog() {
        return msgLog;
    }

    /**
     * 设置msgLog属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BaseMsgLog }
     *     
     */
    public void setMsgLog(BaseMsgLog value) {
        this.msgLog = value;
    }

    /**
     * 获取patientInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OutpOrderPatientInfo }
     *     
     */
    public OutpOrderPatientInfo getPatientInfo() {
        return patientInfo;
    }

    /**
     * 设置patientInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OutpOrderPatientInfo }
     *     
     */
    public void setPatientInfo(OutpOrderPatientInfo value) {
        this.patientInfo = value;
    }

    /**
     * 获取outpOrderList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OutpOrderList }
     *     
     */
    public OutpOrderList getOutpOrderList() {
        return outpOrderList;
    }

    /**
     * 设置outpOrderList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OutpOrderList }
     *     
     */
    public void setOutpOrderList(OutpOrderList value) {
        this.outpOrderList = value;
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
     *         &lt;element name="OutpOrder" type="{http://wegohis.com}outpOrderInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "outpOrder"
    })
    public static class OutpOrderList {

        @XmlElement(name = "OutpOrder")
        protected List<OutpOrderInfo> outpOrder;

        /**
         * Gets the value of the outpOrder property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the outpOrder property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOutpOrder().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OutpOrderInfo }
         * 
         * 
         */
        public List<OutpOrderInfo> getOutpOrder() {
            if (outpOrder == null) {
                outpOrder = new ArrayList<OutpOrderInfo>();
            }
            return this.outpOrder;
        }

    }

}
