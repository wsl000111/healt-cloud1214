
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>materialClassPO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="materialClassPO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MaterialClassId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialClassCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DeleteFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "materialClassPO", propOrder = {
    "materialClassId",
    "materialClassCode",
    "materialClassName",
    "pyCode",
    "medInstId",
    "isEnable",
    "deleteFlag"
})
public class MaterialClassPO {

    @XmlElement(name = "MaterialClassId")
    protected String materialClassId;
    @XmlElement(name = "MaterialClassCode")
    protected String materialClassCode;
    @XmlElement(name = "MaterialClassName")
    protected String materialClassName;
    @XmlElement(name = "PyCode")
    protected String pyCode;
    @XmlElement(name = "MedInstId")
    protected String medInstId;
    @XmlElement(name = "IsEnable")
    protected String isEnable;
    @XmlElement(name = "DeleteFlag")
    protected String deleteFlag;

    /**
     * 获取materialClassId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialClassId() {
        return materialClassId;
    }

    /**
     * 设置materialClassId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialClassId(String value) {
        this.materialClassId = value;
    }

    /**
     * 获取materialClassCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialClassCode() {
        return materialClassCode;
    }

    /**
     * 设置materialClassCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialClassCode(String value) {
        this.materialClassCode = value;
    }

    /**
     * 获取materialClassName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialClassName() {
        return materialClassName;
    }

    /**
     * 设置materialClassName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialClassName(String value) {
        this.materialClassName = value;
    }

    /**
     * 获取pyCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPyCode() {
        return pyCode;
    }

    /**
     * 设置pyCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPyCode(String value) {
        this.pyCode = value;
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
     * 获取isEnable属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 设置isEnable属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsEnable(String value) {
        this.isEnable = value;
    }

    /**
     * 获取deleteFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置deleteFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeleteFlag(String value) {
        this.deleteFlag = value;
    }

}
