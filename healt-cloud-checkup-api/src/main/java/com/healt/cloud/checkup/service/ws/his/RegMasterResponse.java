
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>regMasterResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="regMasterResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RegMasterList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="RegMaster" type="{http://wegohis.com}regMaster" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "regMasterResponse", propOrder = {
    "regMasterList"
})
public class RegMasterResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "RegMasterList")
    protected RegMasterList regMasterList;

    /**
     * 获取regMasterList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RegMasterList }
     *     
     */
    public RegMasterList getRegMasterList() {
        return regMasterList;
    }

    /**
     * 设置regMasterList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RegMasterList }
     *     
     */
    public void setRegMasterList(RegMasterList value) {
        this.regMasterList = value;
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
     *         &lt;element name="RegMaster" type="{http://wegohis.com}regMaster" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "regMaster"
    })
    public static class RegMasterList {

        @XmlElement(name = "RegMaster")
        protected List<RegMaster> regMaster;

        /**
         * Gets the value of the regMaster property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the regMaster property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRegMaster().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RegMaster }
         * 
         * 
         */
        public List<RegMaster> getRegMaster() {
            if (regMaster == null) {
                regMaster = new ArrayList<RegMaster>();
            }
            return this.regMaster;
        }

    }

}
