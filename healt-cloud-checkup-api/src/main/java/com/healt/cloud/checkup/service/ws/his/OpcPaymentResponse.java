
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>opcPaymentResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="opcPaymentResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SettleInfo" type="{http://wegohis.com}settleInfoEntity" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "opcPaymentResponse", propOrder = {
    "settleInfo"
})
public class OpcPaymentResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "SettleInfo")
    protected SettleInfoEntity settleInfo;

    /**
     * 获取settleInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SettleInfoEntity }
     *     
     */
    public SettleInfoEntity getSettleInfo() {
        return settleInfo;
    }

    /**
     * 设置settleInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SettleInfoEntity }
     *     
     */
    public void setSettleInfo(SettleInfoEntity value) {
        this.settleInfo = value;
    }

}
