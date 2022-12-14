
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>queryPatientVisitInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="queryPatientVisitInfoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RegVisitList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="RegVisit" type="{http://wegohis.com}queryPatientVisitEntity" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "queryPatientVisitInfoResponse", propOrder = {
    "regVisitList"
})
public class QueryPatientVisitInfoResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "RegVisitList")
    protected RegVisitList regVisitList;

    /**
     * 获取regVisitList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RegVisitList }
     *     
     */
    public RegVisitList getRegVisitList() {
        return regVisitList;
    }

    /**
     * 设置regVisitList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RegVisitList }
     *     
     */
    public void setRegVisitList(RegVisitList value) {
        this.regVisitList = value;
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
     *         &lt;element name="RegVisit" type="{http://wegohis.com}queryPatientVisitEntity" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "regVisit"
    })
    public static class RegVisitList {

        @XmlElement(name = "RegVisit")
        protected List<QueryPatientVisitEntity> regVisit;

        /**
         * Gets the value of the regVisit property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the regVisit property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRegVisit().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link QueryPatientVisitEntity }
         * 
         * 
         */
        public List<QueryPatientVisitEntity> getRegVisit() {
            if (regVisit == null) {
                regVisit = new ArrayList<QueryPatientVisitEntity>();
            }
            return this.regVisit;
        }

    }

}
