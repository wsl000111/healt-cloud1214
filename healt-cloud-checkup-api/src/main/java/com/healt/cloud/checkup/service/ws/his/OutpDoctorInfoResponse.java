
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>outpDoctorInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="outpDoctorInfoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DoctorInfoList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="DoctorInfo" type="{http://wegohis.com}outDoctorInfoVO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "outpDoctorInfoResponse", propOrder = {
    "doctorInfoList"
})
public class OutpDoctorInfoResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "DoctorInfoList")
    protected DoctorInfoList doctorInfoList;

    /**
     * 获取doctorInfoList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DoctorInfoList }
     *     
     */
    public DoctorInfoList getDoctorInfoList() {
        return doctorInfoList;
    }

    /**
     * 设置doctorInfoList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DoctorInfoList }
     *     
     */
    public void setDoctorInfoList(DoctorInfoList value) {
        this.doctorInfoList = value;
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
     *         &lt;element name="DoctorInfo" type="{http://wegohis.com}outDoctorInfoVO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "doctorInfo"
    })
    public static class DoctorInfoList {

        @XmlElement(name = "DoctorInfo")
        protected List<OutDoctorInfoVO> doctorInfo;

        /**
         * Gets the value of the doctorInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the doctorInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDoctorInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OutDoctorInfoVO }
         * 
         * 
         */
        public List<OutDoctorInfoVO> getDoctorInfo() {
            if (doctorInfo == null) {
                doctorInfo = new ArrayList<OutDoctorInfoVO>();
            }
            return this.doctorInfo;
        }

    }

}
