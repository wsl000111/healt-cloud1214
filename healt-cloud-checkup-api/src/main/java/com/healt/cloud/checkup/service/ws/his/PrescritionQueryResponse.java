
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>prescritionQueryResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="prescritionQueryResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PrescriptionList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Prescription" type="{http://wegohis.com}prescriptionPO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "prescritionQueryResponse", propOrder = {
    "prescriptionList"
})
public class PrescritionQueryResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "PrescriptionList")
    protected PrescriptionList prescriptionList;

    /**
     * 获取prescriptionList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PrescriptionList }
     *     
     */
    public PrescriptionList getPrescriptionList() {
        return prescriptionList;
    }

    /**
     * 设置prescriptionList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PrescriptionList }
     *     
     */
    public void setPrescriptionList(PrescriptionList value) {
        this.prescriptionList = value;
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
     *         &lt;element name="Prescription" type="{http://wegohis.com}prescriptionPO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "prescription"
    })
    public static class PrescriptionList {

        @XmlElement(name = "Prescription")
        protected List<PrescriptionPO> prescription;

        /**
         * Gets the value of the prescription property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the prescription property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPrescription().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PrescriptionPO }
         * 
         * 
         */
        public List<PrescriptionPO> getPrescription() {
            if (prescription == null) {
                prescription = new ArrayList<PrescriptionPO>();
            }
            return this.prescription;
        }

    }

}
