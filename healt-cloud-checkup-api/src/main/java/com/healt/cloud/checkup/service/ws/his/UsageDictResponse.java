
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>usageDictResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="usageDictResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UsageDictList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="UsageDict" type="{http://wegohis.com}usageDict" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "usageDictResponse", propOrder = {
    "usageDictList"
})
public class UsageDictResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "UsageDictList")
    protected UsageDictList usageDictList;

    /**
     * 获取usageDictList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link UsageDictList }
     *     
     */
    public UsageDictList getUsageDictList() {
        return usageDictList;
    }

    /**
     * 设置usageDictList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link UsageDictList }
     *     
     */
    public void setUsageDictList(UsageDictList value) {
        this.usageDictList = value;
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
     *         &lt;element name="UsageDict" type="{http://wegohis.com}usageDict" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "usageDict"
    })
    public static class UsageDictList {

        @XmlElement(name = "UsageDict")
        protected List<UsageDict> usageDict;

        /**
         * Gets the value of the usageDict property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the usageDict property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUsageDict().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link UsageDict }
         * 
         * 
         */
        public List<UsageDict> getUsageDict() {
            if (usageDict == null) {
                usageDict = new ArrayList<UsageDict>();
            }
            return this.usageDict;
        }

    }

}
