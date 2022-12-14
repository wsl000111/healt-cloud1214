
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bdMedInsQueryVO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bdMedInsQueryVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MedInstId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstAdd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstPost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstCont" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstContPh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstProp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstDescn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bdMedInsQueryVO", propOrder = {
    "medInstId",
    "medInstCode",
    "medInstName",
    "medInstAdd",
    "medInstPost",
    "medInstCont",
    "medInstContPh",
    "medInstLevel",
    "medInstType",
    "medInstProp",
    "medInstDescn",
    "medInstStatus"
})
public class BdMedInsQueryVO {

    @XmlElement(name = "MedInstId")
    protected String medInstId;
    @XmlElement(name = "MedInstCode")
    protected String medInstCode;
    @XmlElement(name = "MedInstName")
    protected String medInstName;
    @XmlElement(name = "MedInstAdd")
    protected String medInstAdd;
    @XmlElement(name = "MedInstPost")
    protected String medInstPost;
    @XmlElement(name = "MedInstCont")
    protected String medInstCont;
    @XmlElement(name = "MedInstContPh")
    protected String medInstContPh;
    @XmlElement(name = "MedInstLevel")
    protected String medInstLevel;
    @XmlElement(name = "MedInstType")
    protected String medInstType;
    @XmlElement(name = "MedInstProp")
    protected String medInstProp;
    @XmlElement(name = "MedInstDescn")
    protected String medInstDescn;
    @XmlElement(name = "MedInstStatus")
    protected String medInstStatus;

    /**
     * 获取medInstId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstId() {
        return medInstId;
    }

    /**
     * 设置medInstId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstId(String value) {
        this.medInstId = value;
    }

    /**
     * 获取medInstCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstCode() {
        return medInstCode;
    }

    /**
     * 设置medInstCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstCode(String value) {
        this.medInstCode = value;
    }

    /**
     * 获取medInstName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstName() {
        return medInstName;
    }

    /**
     * 设置medInstName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstName(String value) {
        this.medInstName = value;
    }

    /**
     * 获取medInstAdd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstAdd() {
        return medInstAdd;
    }

    /**
     * 设置medInstAdd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstAdd(String value) {
        this.medInstAdd = value;
    }

    /**
     * 获取medInstPost属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstPost() {
        return medInstPost;
    }

    /**
     * 设置medInstPost属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstPost(String value) {
        this.medInstPost = value;
    }

    /**
     * 获取medInstCont属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstCont() {
        return medInstCont;
    }

    /**
     * 设置medInstCont属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstCont(String value) {
        this.medInstCont = value;
    }

    /**
     * 获取medInstContPh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstContPh() {
        return medInstContPh;
    }

    /**
     * 设置medInstContPh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstContPh(String value) {
        this.medInstContPh = value;
    }

    /**
     * 获取medInstLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstLevel() {
        return medInstLevel;
    }

    /**
     * 设置medInstLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstLevel(String value) {
        this.medInstLevel = value;
    }

    /**
     * 获取medInstType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstType() {
        return medInstType;
    }

    /**
     * 设置medInstType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstType(String value) {
        this.medInstType = value;
    }

    /**
     * 获取medInstProp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstProp() {
        return medInstProp;
    }

    /**
     * 设置medInstProp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstProp(String value) {
        this.medInstProp = value;
    }

    /**
     * 获取medInstDescn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstDescn() {
        return medInstDescn;
    }

    /**
     * 设置medInstDescn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstDescn(String value) {
        this.medInstDescn = value;
    }

    /**
     * 获取medInstStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstStatus() {
        return medInstStatus;
    }

    /**
     * 设置medInstStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstStatus(String value) {
        this.medInstStatus = value;
    }

}
