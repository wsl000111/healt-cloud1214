
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>diagnosisDictResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="diagnosisDictResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DiagnosisList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Diagnosis" type="{http://wegohis.com}diagnosisDict" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "diagnosisDictResponse", propOrder = {
    "diagnosisList"
})
public class DiagnosisDictResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "DiagnosisList")
    protected DiagnosisList diagnosisList;

    /**
     * 获取diagnosisList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DiagnosisList }
     *     
     */
    public DiagnosisList getDiagnosisList() {
        return diagnosisList;
    }

    /**
     * 设置diagnosisList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DiagnosisList }
     *     
     */
    public void setDiagnosisList(DiagnosisList value) {
        this.diagnosisList = value;
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
     *         &lt;element name="Diagnosis" type="{http://wegohis.com}diagnosisDict" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "diagnosis"
    })
    public static class DiagnosisList {

        @XmlElement(name = "Diagnosis")
        protected List<DiagnosisDict> diagnosis;

        /**
         * Gets the value of the diagnosis property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the diagnosis property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDiagnosis().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DiagnosisDict }
         * 
         * 
         */
        public List<DiagnosisDict> getDiagnosis() {
            if (diagnosis == null) {
                diagnosis = new ArrayList<DiagnosisDict>();
            }
            return this.diagnosis;
        }

    }

}
