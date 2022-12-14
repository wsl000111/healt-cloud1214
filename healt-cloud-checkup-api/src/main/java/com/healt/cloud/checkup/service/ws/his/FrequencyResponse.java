
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>frequencyResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="frequencyResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FrequencyDictList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="FrequencyDict" type="{http://wegohis.com}frequencyEntity" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "frequencyResponse", propOrder = {
    "frequencyDictList"
})
public class FrequencyResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "FrequencyDictList")
    protected FrequencyDictList frequencyDictList;

    /**
     * 获取frequencyDictList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FrequencyDictList }
     *     
     */
    public FrequencyDictList getFrequencyDictList() {
        return frequencyDictList;
    }

    /**
     * 设置frequencyDictList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyDictList }
     *     
     */
    public void setFrequencyDictList(FrequencyDictList value) {
        this.frequencyDictList = value;
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
     *         &lt;element name="FrequencyDict" type="{http://wegohis.com}frequencyEntity" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "frequencyDict"
    })
    public static class FrequencyDictList {

        @XmlElement(name = "FrequencyDict")
        protected List<FrequencyEntity> frequencyDict;

        /**
         * Gets the value of the frequencyDict property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the frequencyDict property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFrequencyDict().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FrequencyEntity }
         * 
         * 
         */
        public List<FrequencyEntity> getFrequencyDict() {
            if (frequencyDict == null) {
                frequencyDict = new ArrayList<FrequencyEntity>();
            }
            return this.frequencyDict;
        }

    }

}
