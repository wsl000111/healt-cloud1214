
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getTicketInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getTicketInfoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TicketInfoList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TicketInfo" type="{http://wegohis.com}getTicketInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "getTicketInfoResponse", propOrder = {
    "ticketInfoList"
})
public class GetTicketInfoResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "TicketInfoList")
    protected TicketInfoList ticketInfoList;

    /**
     * 获取ticketInfoList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TicketInfoList }
     *     
     */
    public TicketInfoList getTicketInfoList() {
        return ticketInfoList;
    }

    /**
     * 设置ticketInfoList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TicketInfoList }
     *     
     */
    public void setTicketInfoList(TicketInfoList value) {
        this.ticketInfoList = value;
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
     *         &lt;element name="TicketInfo" type="{http://wegohis.com}getTicketInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "ticketInfo"
    })
    public static class TicketInfoList {

        @XmlElement(name = "TicketInfo")
        protected List<GetTicketInfo> ticketInfo;

        /**
         * Gets the value of the ticketInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ticketInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTicketInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetTicketInfo }
         * 
         * 
         */
        public List<GetTicketInfo> getTicketInfo() {
            if (ticketInfo == null) {
                ticketInfo = new ArrayList<GetTicketInfo>();
            }
            return this.ticketInfo;
        }

    }

}
