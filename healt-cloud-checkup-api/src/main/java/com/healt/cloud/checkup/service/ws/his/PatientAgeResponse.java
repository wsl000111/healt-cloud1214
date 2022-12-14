
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>patientAgeResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="patientAgeResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AgeInfo" type="{http://wegohis.com}patientAgeEntity" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patientAgeResponse", propOrder = {
    "ageInfo"
})
public class PatientAgeResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "AgeInfo")
    protected PatientAgeEntity ageInfo;

    /**
     * 获取ageInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PatientAgeEntity }
     *     
     */
    public PatientAgeEntity getAgeInfo() {
        return ageInfo;
    }

    /**
     * 设置ageInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PatientAgeEntity }
     *     
     */
    public void setAgeInfo(PatientAgeEntity value) {
        this.ageInfo = value;
    }

}
