
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>queryDialysisScheduling complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="queryDialysisScheduling"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PatientInfo" type="{http://wegohis.com}dialysisPatientInfo" minOccurs="0"/&gt;
 *         &lt;element name="Schedulings" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Scheduling" type="{http://wegohis.com}queryScheduling" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryDialysisScheduling", propOrder = {
    "patientInfo",
    "schedulings"
})
public class QueryDialysisScheduling {

    @XmlElement(name = "PatientInfo")
    protected DialysisPatientInfo patientInfo;
    @XmlElement(name = "Schedulings")
    protected Schedulings schedulings;

    /**
     * 获取patientInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DialysisPatientInfo }
     *     
     */
    public DialysisPatientInfo getPatientInfo() {
        return patientInfo;
    }

    /**
     * 设置patientInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DialysisPatientInfo }
     *     
     */
    public void setPatientInfo(DialysisPatientInfo value) {
        this.patientInfo = value;
    }

    /**
     * 获取schedulings属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Schedulings }
     *     
     */
    public Schedulings getSchedulings() {
        return schedulings;
    }

    /**
     * 设置schedulings属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Schedulings }
     *     
     */
    public void setSchedulings(Schedulings value) {
        this.schedulings = value;
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
     *         &lt;element name="Scheduling" type="{http://wegohis.com}queryScheduling" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "scheduling"
    })
    public static class Schedulings {

        @XmlElement(name = "Scheduling")
        protected List<QueryScheduling> scheduling;

        /**
         * Gets the value of the scheduling property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the scheduling property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getScheduling().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link QueryScheduling }
         * 
         * 
         */
        public List<QueryScheduling> getScheduling() {
            if (scheduling == null) {
                scheduling = new ArrayList<QueryScheduling>();
            }
            return this.scheduling;
        }

    }

}
