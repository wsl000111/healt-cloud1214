
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>orderReserveMasterResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="orderReserveMasterResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RegReserve" type="{http://wegohis.com}orderReserveMaster" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderReserveMasterResponse", propOrder = {
    "regReserve"
})
public class OrderReserveMasterResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "RegReserve")
    protected OrderReserveMaster regReserve;

    /**
     * 获取regReserve属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OrderReserveMaster }
     *     
     */
    public OrderReserveMaster getRegReserve() {
        return regReserve;
    }

    /**
     * 设置regReserve属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OrderReserveMaster }
     *     
     */
    public void setRegReserve(OrderReserveMaster value) {
        this.regReserve = value;
    }

}
