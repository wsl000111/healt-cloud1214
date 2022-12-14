
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>codeTableResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="codeTableResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StandardList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Standard" type="{http://wegohis.com}codeTable" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "codeTableResponse", propOrder = {
    "standardList"
})
public class CodeTableResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "StandardList")
    protected StandardList standardList;

    /**
     * 获取standardList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link StandardList }
     *     
     */
    public StandardList getStandardList() {
        return standardList;
    }

    /**
     * 设置standardList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StandardList }
     *     
     */
    public void setStandardList(StandardList value) {
        this.standardList = value;
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
     *         &lt;element name="Standard" type="{http://wegohis.com}codeTable" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "standard"
    })
    public static class StandardList {

        @XmlElement(name = "Standard")
        protected List<CodeTable> standard;

        /**
         * Gets the value of the standard property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the standard property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStandard().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CodeTable }
         * 
         * 
         */
        public List<CodeTable> getStandard() {
            if (standard == null) {
                standard = new ArrayList<CodeTable>();
            }
            return this.standard;
        }

    }

    @Override
    public String toString() {
        return "CodeTableResponse{" +
                "standardList=" + standardList +
                ", result=" + result +
                '}';
    }
}
