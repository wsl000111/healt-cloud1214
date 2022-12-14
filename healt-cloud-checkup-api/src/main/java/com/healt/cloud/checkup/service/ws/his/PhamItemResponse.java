
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>phamItemResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="phamItemResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PhamItemList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PhamItem" type="{http://wegohis.com}phamItem" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "phamItemResponse", propOrder = {
    "phamItemList"
})
public class PhamItemResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "PhamItemList")
    protected PhamItemList phamItemList;

    /**
     * 获取phamItemList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PhamItemList }
     *     
     */
    public PhamItemList getPhamItemList() {
        return phamItemList;
    }

    /**
     * 设置phamItemList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PhamItemList }
     *     
     */
    public void setPhamItemList(PhamItemList value) {
        this.phamItemList = value;
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
     *         &lt;element name="PhamItem" type="{http://wegohis.com}phamItem" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "phamItem"
    })
    public static class PhamItemList {

        @XmlElement(name = "PhamItem")
        protected List<PhamItem> phamItem;

        /**
         * Gets the value of the phamItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the phamItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPhamItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PhamItem }
         * 
         * 
         */
        public List<PhamItem> getPhamItem() {
            if (phamItem == null) {
                phamItem = new ArrayList<PhamItem>();
            }
            return this.phamItem;
        }

    }

}
