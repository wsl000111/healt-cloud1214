
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>medInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="medInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MedRecordNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedRecordNumTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "medInfo", propOrder = {
    "medRecordNum",
    "medRecordNumTime"
})
public class MedInfo
    extends SoapBaseResponse
{

    @XmlElement(name = "MedRecordNum")
    protected String medRecordNum;
    @XmlElement(name = "MedRecordNumTime")
    protected String medRecordNumTime;

    /**
     * 获取medRecordNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedRecordNum() {
        return medRecordNum;
    }

    /**
     * 设置medRecordNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedRecordNum(String value) {
        this.medRecordNum = value;
    }

    /**
     * 获取medRecordNumTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedRecordNumTime() {
        return medRecordNumTime;
    }

    /**
     * 设置medRecordNumTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedRecordNumTime(String value) {
        this.medRecordNumTime = value;
    }

}
