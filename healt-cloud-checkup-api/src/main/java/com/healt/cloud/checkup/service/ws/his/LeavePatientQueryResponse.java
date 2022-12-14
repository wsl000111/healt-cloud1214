
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>leavePatientQueryResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="leavePatientQueryResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PatientInfoList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PatientInfo" type="{http://wegohis.com}leavePatientInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "leavePatientQueryResponse", propOrder = {
    "patientInfoList"
})
public class LeavePatientQueryResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "PatientInfoList")
    protected PatientInfoList patientInfoList;

    /**
     * 获取patientInfoList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PatientInfoList }
     *     
     */
    public PatientInfoList getPatientInfoList() {
        return patientInfoList;
    }

    /**
     * 设置patientInfoList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PatientInfoList }
     *     
     */
    public void setPatientInfoList(PatientInfoList value) {
        this.patientInfoList = value;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="PatientInfo" type="{http://wegohis.com}leavePatientInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "patientInfo"
    })
    public static class PatientInfoList {

        @XmlElement(name = "PatientInfo")
        protected List<LeavePatientInfo> patientInfo;

        /**
         * Gets the value of the patientInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the patientInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPatientInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LeavePatientInfo }
         * 
         * 
         */
        public List<LeavePatientInfo> getPatientInfo() {
            if (patientInfo == null) {
                patientInfo = new ArrayList<LeavePatientInfo>();
            }
            return this.patientInfo;
        }

    }

}
