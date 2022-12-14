
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>specialClinicResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="specialClinicResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SpecialClinicInfoList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="SpecialClinicInfo" type="{http://wegohis.com}specialClinic" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "specialClinicResponse", propOrder = {
    "specialClinicInfoList"
})
public class SpecialClinicResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "SpecialClinicInfoList")
    protected SpecialClinicInfoList specialClinicInfoList;

    /**
     * 获取specialClinicInfoList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SpecialClinicInfoList }
     *     
     */
    public SpecialClinicInfoList getSpecialClinicInfoList() {
        return specialClinicInfoList;
    }

    /**
     * 设置specialClinicInfoList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialClinicInfoList }
     *     
     */
    public void setSpecialClinicInfoList(SpecialClinicInfoList value) {
        this.specialClinicInfoList = value;
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
     *         &lt;element name="SpecialClinicInfo" type="{http://wegohis.com}specialClinic" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "specialClinicInfo"
    })
    public static class SpecialClinicInfoList {

        @XmlElement(name = "SpecialClinicInfo")
        protected List<SpecialClinic> specialClinicInfo;

        /**
         * Gets the value of the specialClinicInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the specialClinicInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSpecialClinicInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SpecialClinic }
         * 
         * 
         */
        public List<SpecialClinic> getSpecialClinicInfo() {
            if (specialClinicInfo == null) {
                specialClinicInfo = new ArrayList<SpecialClinic>();
            }
            return this.specialClinicInfo;
        }

    }

}
