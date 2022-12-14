
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>applyCardResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="applyCardResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PatientInfo" type="{http://wegohis.com}applyCardPatientInfoVO" minOccurs="0"/&gt;
 *         &lt;element name="AccountInfo" type="{http://wegohis.com}createArchiveAccountInfoVO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "applyCardResponse", propOrder = {
    "patientInfo",
    "accountInfo"
})
public class ApplyCardResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "PatientInfo")
    protected ApplyCardPatientInfoVO patientInfo;
    @XmlElement(name = "AccountInfo")
    protected CreateArchiveAccountInfoVO accountInfo;

    /**
     * 获取patientInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ApplyCardPatientInfoVO }
     *     
     */
    public ApplyCardPatientInfoVO getPatientInfo() {
        return patientInfo;
    }

    /**
     * 设置patientInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ApplyCardPatientInfoVO }
     *     
     */
    public void setPatientInfo(ApplyCardPatientInfoVO value) {
        this.patientInfo = value;
    }

    /**
     * 获取accountInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreateArchiveAccountInfoVO }
     *     
     */
    public CreateArchiveAccountInfoVO getAccountInfo() {
        return accountInfo;
    }

    /**
     * 设置accountInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreateArchiveAccountInfoVO }
     *     
     */
    public void setAccountInfo(CreateArchiveAccountInfoVO value) {
        this.accountInfo = value;
    }

}
