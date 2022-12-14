
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>phamLocationResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="phamLocationResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PhamInfoList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PhamInfo" type="{http://wegohis.com}phamLocationPO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "phamLocationResponse", propOrder = {
    "phamInfoList"
})
public class PhamLocationResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "PhamInfoList")
    protected PhamInfoList phamInfoList;

    /**
     * 获取phamInfoList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PhamInfoList }
     *     
     */
    public PhamInfoList getPhamInfoList() {
        return phamInfoList;
    }

    /**
     * 设置phamInfoList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PhamInfoList }
     *     
     */
    public void setPhamInfoList(PhamInfoList value) {
        this.phamInfoList = value;
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
     *         &lt;element name="PhamInfo" type="{http://wegohis.com}phamLocationPO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "phamInfo"
    })
    public static class PhamInfoList {

        @XmlElement(name = "PhamInfo")
        protected List<PhamLocationPO> phamInfo;

        /**
         * Gets the value of the phamInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the phamInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPhamInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PhamLocationPO }
         * 
         * 
         */
        public List<PhamLocationPO> getPhamInfo() {
            if (phamInfo == null) {
                phamInfo = new ArrayList<PhamLocationPO>();
            }
            return this.phamInfo;
        }

    }

}
