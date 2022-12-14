
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bdAreaQueryResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bdAreaQueryResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AreaList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Area" type="{http://wegohis.com}bdAreaQueryVO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "bdAreaQueryResponse", propOrder = {
    "areaList"
})
public class BdAreaQueryResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "AreaList")
    protected AreaList areaList;

    /**
     * 获取areaList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AreaList }
     *     
     */
    public AreaList getAreaList() {
        return areaList;
    }

    /**
     * 设置areaList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AreaList }
     *     
     */
    public void setAreaList(AreaList value) {
        this.areaList = value;
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
     *         &lt;element name="Area" type="{http://wegohis.com}bdAreaQueryVO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "area"
    })
    public static class AreaList {

        @XmlElement(name = "Area")
        protected List<BdAreaQueryVO> area;

        /**
         * Gets the value of the area property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the area property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getArea().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BdAreaQueryVO }
         * 
         * 
         */
        public List<BdAreaQueryVO> getArea() {
            if (area == null) {
                area = new ArrayList<BdAreaQueryVO>();
            }
            return this.area;
        }

    }

}
