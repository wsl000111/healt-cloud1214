
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bdMedInsResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bdMedInsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MedInsList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="MedIns" type="{http://wegohis.com}bdMedInsQueryVO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "bdMedInsResponse", propOrder = {
    "medInsList"
})
public class BdMedInsResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "MedInsList")
    protected MedInsList medInsList;

    /**
     * 获取medInsList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MedInsList }
     *     
     */
    public MedInsList getMedInsList() {
        return medInsList;
    }

    /**
     * 设置medInsList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MedInsList }
     *     
     */
    public void setMedInsList(MedInsList value) {
        this.medInsList = value;
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
     *         &lt;element name="MedIns" type="{http://wegohis.com}bdMedInsQueryVO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "medIns"
    })
    public static class MedInsList {

        @XmlElement(name = "MedIns")
        protected List<BdMedInsQueryVO> medIns;

        /**
         * Gets the value of the medIns property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the medIns property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMedIns().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BdMedInsQueryVO }
         * 
         * 
         */
        public List<BdMedInsQueryVO> getMedIns() {
            if (medIns == null) {
                medIns = new ArrayList<BdMedInsQueryVO>();
            }
            return this.medIns;
        }

    }

}
