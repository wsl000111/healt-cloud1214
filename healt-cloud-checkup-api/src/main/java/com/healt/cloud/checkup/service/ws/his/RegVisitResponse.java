
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>regVisitResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="regVisitResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MasterInfo" type="{http://wegohis.com}regVisitVO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "regVisitResponse", propOrder = {
    "masterInfo"
})
public class RegVisitResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "MasterInfo")
    protected RegVisitVO masterInfo;

    /**
     * 获取masterInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RegVisitVO }
     *     
     */
    public RegVisitVO getMasterInfo() {
        return masterInfo;
    }

    /**
     * 设置masterInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RegVisitVO }
     *     
     */
    public void setMasterInfo(RegVisitVO value) {
        this.masterInfo = value;
    }

}
