
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>medNumGrnResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="medNumGrnResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MedInfo" type="{http://wegohis.com}medInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "medNumGrnResponse", propOrder = {
    "medInfo"
})
public class MedNumGrnResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "MedInfo")
    protected MedInfo medInfo;

    /**
     * 获取medInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MedInfo }
     *     
     */
    public MedInfo getMedInfo() {
        return medInfo;
    }

    /**
     * 设置medInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MedInfo }
     *     
     */
    public void setMedInfo(MedInfo value) {
        this.medInfo = value;
    }

}
