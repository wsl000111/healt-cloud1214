
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>cancelRegResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="cancelRegResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RefundInfo" type="{http://wegohis.com}payInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelRegResponse", propOrder = {
    "refundInfo"
})
public class CancelRegResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "RefundInfo")
    protected PayInfo refundInfo;

    /**
     * 获取refundInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PayInfo }
     *     
     */
    public PayInfo getRefundInfo() {
        return refundInfo;
    }

    /**
     * 设置refundInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PayInfo }
     *     
     */
    public void setRefundInfo(PayInfo value) {
        this.refundInfo = value;
    }

}
