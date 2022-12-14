
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>orderReserveResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="orderReserveResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReserveList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Reserve" type="{http://wegohis.com}reserveInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "orderReserveResponse", propOrder = {
    "reserveList"
})
public class OrderReserveResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "ReserveList")
    protected ReserveList reserveList;

    /**
     * 获取reserveList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReserveList }
     *     
     */
    public ReserveList getReserveList() {
        return reserveList;
    }

    /**
     * 设置reserveList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReserveList }
     *     
     */
    public void setReserveList(ReserveList value) {
        this.reserveList = value;
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
     *         &lt;element name="Reserve" type="{http://wegohis.com}reserveInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "reserve"
    })
    public static class ReserveList {

        @XmlElement(name = "Reserve")
        protected List<ReserveInfo> reserve;

        /**
         * Gets the value of the reserve property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the reserve property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReserve().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ReserveInfo }
         * 
         * 
         */
        public List<ReserveInfo> getReserve() {
            if (reserve == null) {
                reserve = new ArrayList<ReserveInfo>();
            }
            return this.reserve;
        }

    }

}
