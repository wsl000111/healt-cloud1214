
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>pharmQrResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="pharmQrResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PdaItem" type="{http://wegohis.com}pdaItem" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pharmQrResponse", propOrder = {
    "pdaItem"
})
public class PharmQrResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "PdaItem")
    protected PdaItem pdaItem;

    /**
     * 获取pdaItem属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PdaItem }
     *     
     */
    public PdaItem getPdaItem() {
        return pdaItem;
    }

    /**
     * 设置pdaItem属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PdaItem }
     *     
     */
    public void setPdaItem(PdaItem value) {
        this.pdaItem = value;
    }

}
