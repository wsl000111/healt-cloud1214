
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>searchArchiveResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="searchArchiveResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PatientInfo" type="{http://wegohis.com}searchArchivePatientInfoVO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchArchiveResponse", propOrder = {
    "patientInfo"
})
public class SearchArchiveResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "PatientInfo")
    protected SearchArchivePatientInfoVO patientInfo;

    /**
     * 获取patientInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SearchArchivePatientInfoVO }
     *     
     */
    public SearchArchivePatientInfoVO getPatientInfo() {
        return patientInfo;
    }

    /**
     * 设置patientInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SearchArchivePatientInfoVO }
     *     
     */
    public void setPatientInfo(SearchArchivePatientInfoVO value) {
        this.patientInfo = value;
    }

    @Override
    public String toString() {
        return "SearchArchiveResponse{" +
                "patientInfo=" + patientInfo +
                '}';
    }
}
