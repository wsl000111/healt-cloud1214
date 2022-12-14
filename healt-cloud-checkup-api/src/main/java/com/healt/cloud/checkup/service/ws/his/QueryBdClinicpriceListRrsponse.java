
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>queryBdClinicpriceListRrsponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="queryBdClinicpriceListRrsponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ClinicPriceList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ClinicPrice" type="{http://wegohis.com}bdClinicpriceQueryVO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "queryBdClinicpriceListRrsponse", propOrder = {
    "clinicPriceList"
})
public class QueryBdClinicpriceListRrsponse
    extends SoapBaseResponse
{

    @XmlElement(name = "ClinicPriceList")
    protected ClinicPriceList clinicPriceList;

    /**
     * 获取clinicPriceList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ClinicPriceList }
     *     
     */
    public ClinicPriceList getClinicPriceList() {
        return clinicPriceList;
    }

    /**
     * 设置clinicPriceList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ClinicPriceList }
     *     
     */
    public void setClinicPriceList(ClinicPriceList value) {
        this.clinicPriceList = value;
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
     *         &lt;element name="ClinicPrice" type="{http://wegohis.com}bdClinicpriceQueryVO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "clinicPrice"
    })
    public static class ClinicPriceList {

        @XmlElement(name = "ClinicPrice")
        protected List<BdClinicpriceQueryVO> clinicPrice;

        /**
         * Gets the value of the clinicPrice property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the clinicPrice property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getClinicPrice().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BdClinicpriceQueryVO }
         * 
         * 
         */
        public List<BdClinicpriceQueryVO> getClinicPrice() {
            if (clinicPrice == null) {
                clinicPrice = new ArrayList<BdClinicpriceQueryVO>();
            }
            return this.clinicPrice;
        }

    }

}
