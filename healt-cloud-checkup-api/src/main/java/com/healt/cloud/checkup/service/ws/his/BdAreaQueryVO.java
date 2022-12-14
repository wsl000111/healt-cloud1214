
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bdAreaQueryVO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bdAreaQueryVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AreaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaAdd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaPost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaCont" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaContPh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaDescn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bdAreaQueryVO", propOrder = {
    "areaId",
    "areaCode",
    "areaName",
    "medInstId",
    "medInstCode",
    "medInstName",
    "areaAdd",
    "areaPost",
    "areaCont",
    "areaContPh",
    "areaDescn"
})
public class BdAreaQueryVO {

    @XmlElement(name = "AreaId")
    protected String areaId;
    @XmlElement(name = "AreaCode")
    protected String areaCode;
    @XmlElement(name = "AreaName")
    protected String areaName;
    @XmlElement(name = "MedInstId")
    protected String medInstId;
    @XmlElement(name = "MedInstCode")
    protected String medInstCode;
    @XmlElement(name = "MedInstName")
    protected String medInstName;
    @XmlElement(name = "AreaAdd")
    protected String areaAdd;
    @XmlElement(name = "AreaPost")
    protected String areaPost;
    @XmlElement(name = "AreaCont")
    protected String areaCont;
    @XmlElement(name = "AreaContPh")
    protected String areaContPh;
    @XmlElement(name = "AreaDescn")
    protected String areaDescn;

    /**
     * 获取areaId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 设置areaId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaId(String value) {
        this.areaId = value;
    }

    /**
     * 获取areaCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置areaCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaCode(String value) {
        this.areaCode = value;
    }

    /**
     * 获取areaName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置areaName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaName(String value) {
        this.areaName = value;
    }

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
     * 获取areaAdd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaAdd() {
        return areaAdd;
    }

    /**
     * 设置areaAdd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaAdd(String value) {
        this.areaAdd = value;
    }

    /**
     * 获取areaPost属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaPost() {
        return areaPost;
    }

    /**
     * 设置areaPost属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaPost(String value) {
        this.areaPost = value;
    }

    /**
     * 获取areaCont属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaCont() {
        return areaCont;
    }

    /**
     * 设置areaCont属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaCont(String value) {
        this.areaCont = value;
    }

    /**
     * 获取areaContPh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaContPh() {
        return areaContPh;
    }

    /**
     * 设置areaContPh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaContPh(String value) {
        this.areaContPh = value;
    }

    /**
     * 获取areaDescn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaDescn() {
        return areaDescn;
    }

    /**
     * 设置areaDescn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaDescn(String value) {
        this.areaDescn = value;
    }

}
