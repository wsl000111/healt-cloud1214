
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bedDictResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bedDictResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BedInfoList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="BedInfo" type="{http://wegohis.com}bedDictVO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "bedDictResponse", propOrder = {
    "bedInfoList"
})
public class BedDictResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "BedInfoList")
    protected BedInfoList bedInfoList;

    /**
     * 获取bedInfoList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BedInfoList }
     *     
     */
    public BedInfoList getBedInfoList() {
        return bedInfoList;
    }

    /**
     * 设置bedInfoList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BedInfoList }
     *     
     */
    public void setBedInfoList(BedInfoList value) {
        this.bedInfoList = value;
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
     *         &lt;element name="BedInfo" type="{http://wegohis.com}bedDictVO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "bedInfo"
    })
    public static class BedInfoList {

        @XmlElement(name = "BedInfo")
        protected List<BedDictVO> bedInfo;

        /**
         * Gets the value of the bedInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bedInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBedInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BedDictVO }
         * 
         * 
         */
        public List<BedDictVO> getBedInfo() {
            if (bedInfo == null) {
                bedInfo = new ArrayList<BedDictVO>();
            }
            return this.bedInfo;
        }

    }

}
