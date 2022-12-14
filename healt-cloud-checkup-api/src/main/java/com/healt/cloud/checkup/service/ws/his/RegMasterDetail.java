
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>regMasterDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="regMasterDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MasterDetailId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MasterAtimeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Sortno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AppointmentFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "regMasterDetail", propOrder = {
    "masterDetailId",
    "masterAtimeId",
    "sortno",
    "regFlag",
    "appointmentFlag"
})
public class RegMasterDetail {

    @XmlElement(name = "MasterDetailId")
    protected String masterDetailId;
    @XmlElement(name = "MasterAtimeId")
    protected String masterAtimeId;
    @XmlElement(name = "Sortno")
    protected String sortno;
    @XmlElement(name = "RegFlag")
    protected String regFlag;
    @XmlElement(name = "AppointmentFlag")
    protected String appointmentFlag;

    /**
     * 获取masterDetailId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterDetailId() {
        return masterDetailId;
    }

    /**
     * 设置masterDetailId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterDetailId(String value) {
        this.masterDetailId = value;
    }

    /**
     * 获取masterAtimeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterAtimeId() {
        return masterAtimeId;
    }

    /**
     * 设置masterAtimeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterAtimeId(String value) {
        this.masterAtimeId = value;
    }

    /**
     * 获取sortno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortno() {
        return sortno;
    }

    /**
     * 设置sortno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortno(String value) {
        this.sortno = value;
    }

    /**
     * 获取regFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegFlag() {
        return regFlag;
    }

    /**
     * 设置regFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegFlag(String value) {
        this.regFlag = value;
    }

    /**
     * 获取appointmentFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppointmentFlag() {
        return appointmentFlag;
    }

    /**
     * 设置appointmentFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppointmentFlag(String value) {
        this.appointmentFlag = value;
    }

}
