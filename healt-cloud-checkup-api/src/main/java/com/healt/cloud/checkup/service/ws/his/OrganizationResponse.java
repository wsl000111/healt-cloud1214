
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>organizationResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="organizationResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrganizationList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Organization" type="{http://wegohis.com}org" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "organizationResponse", propOrder = {
    "organizationList"
})
public class OrganizationResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "OrganizationList")
    protected OrganizationList organizationList;

    /**
     * 获取organizationList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OrganizationList }
     *     
     */
    public OrganizationList getOrganizationList() {
        return organizationList;
    }

    /**
     * 设置organizationList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationList }
     *     
     */
    public void setOrganizationList(OrganizationList value) {
        this.organizationList = value;
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
     *         &lt;element name="Organization" type="{http://wegohis.com}org" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "organization"
    })
    public static class OrganizationList {

        @XmlElement(name = "Organization")
        protected List<Org> organization;

        /**
         * Gets the value of the organization property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the organization property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOrganization().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Org }
         * 
         * 
         */
        public List<Org> getOrganization() {
            if (organization == null) {
                organization = new ArrayList<Org>();
            }
            return this.organization;
        }

    }

}
