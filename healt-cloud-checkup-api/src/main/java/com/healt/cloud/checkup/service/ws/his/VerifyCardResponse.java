
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>verifyCardResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="verifyCardResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PatientInfo" type="{http://wegohis.com}verifyCardPatientInfoVO" minOccurs="0"/&gt;
 *         &lt;element name="AccountInfo" type="{http://wegohis.com}verifyCardAccountInfoVO" minOccurs="0"/&gt;
 *         &lt;element name="VerifyCardInfoVO" type="{http://wegohis.com}verifyCardInfoVO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifyCardResponse", propOrder = {
    "patientInfo",
    "accountInfo",
    "verifyCardInfoVO"
})
public class VerifyCardResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "PatientInfo")
    protected VerifyCardPatientInfoVO patientInfo;
    @XmlElement(name = "AccountInfo")
    protected VerifyCardAccountInfoVO accountInfo;
    @XmlElement(name = "VerifyCardInfoVO")
    protected VerifyCardInfoVO verifyCardInfoVO;

    /**
     * 获取patientInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VerifyCardPatientInfoVO }
     *     
     */
    public VerifyCardPatientInfoVO getPatientInfo() {
        return patientInfo;
    }

    /**
     * 设置patientInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VerifyCardPatientInfoVO }
     *     
     */
    public void setPatientInfo(VerifyCardPatientInfoVO value) {
        this.patientInfo = value;
    }

    /**
     * 获取accountInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VerifyCardAccountInfoVO }
     *     
     */
    public VerifyCardAccountInfoVO getAccountInfo() {
        return accountInfo;
    }

    /**
     * 设置accountInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VerifyCardAccountInfoVO }
     *     
     */
    public void setAccountInfo(VerifyCardAccountInfoVO value) {
        this.accountInfo = value;
    }

    /**
     * 获取verifyCardInfoVO属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VerifyCardInfoVO }
     *     
     */
    public VerifyCardInfoVO getVerifyCardInfoVO() {
        return verifyCardInfoVO;
    }

    /**
     * 设置verifyCardInfoVO属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VerifyCardInfoVO }
     *     
     */
    public void setVerifyCardInfoVO(VerifyCardInfoVO value) {
        this.verifyCardInfoVO = value;
    }

}
