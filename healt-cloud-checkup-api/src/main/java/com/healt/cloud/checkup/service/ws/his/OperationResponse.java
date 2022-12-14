
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>operationResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="operationResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OperationDictList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="OperationDict" type="{http://wegohis.com}operationEntity" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "operationResponse", propOrder = {
    "operationDictList"
})
public class OperationResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "OperationDictList")
    protected OperationDictList operationDictList;

    /**
     * 获取operationDictList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OperationDictList }
     *     
     */
    public OperationDictList getOperationDictList() {
        return operationDictList;
    }

    /**
     * 设置operationDictList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OperationDictList }
     *     
     */
    public void setOperationDictList(OperationDictList value) {
        this.operationDictList = value;
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
     *         &lt;element name="OperationDict" type="{http://wegohis.com}operationEntity" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "operationDict"
    })
    public static class OperationDictList {

        @XmlElement(name = "OperationDict")
        protected List<OperationEntity> operationDict;

        /**
         * Gets the value of the operationDict property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the operationDict property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOperationDict().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OperationEntity }
         * 
         * 
         */
        public List<OperationEntity> getOperationDict() {
            if (operationDict == null) {
                operationDict = new ArrayList<OperationEntity>();
            }
            return this.operationDict;
        }

    }

}
