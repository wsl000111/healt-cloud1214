
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>categoryDetailDefinition complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="categoryDetailDefinition"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DefinitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="ItemType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DetailCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SubjClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReckoningClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpRcptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InpRcptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MrClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HqmsClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpEInvoiceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InpEInvoiceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "categoryDetailDefinition", propOrder = {
    "definitionId",
    "itemType",
    "detailCode",
    "subjClass",
    "reckoningClass",
    "outpRcptCode",
    "inpRcptCode",
    "mrClass",
    "hqmsClass",
    "outpEInvoiceType",
    "inpEInvoiceType",
    "areaCode"
})
public class CategoryDetailDefinition {

    @XmlElement(name = "DefinitionId")
    protected Long definitionId;
    @XmlElement(name = "ItemType")
    protected String itemType;
    @XmlElement(name = "DetailCode")
    protected String detailCode;
    @XmlElement(name = "SubjClass")
    protected String subjClass;
    @XmlElement(name = "ReckoningClass")
    protected String reckoningClass;
    @XmlElement(name = "OutpRcptCode")
    protected String outpRcptCode;
    @XmlElement(name = "InpRcptCode")
    protected String inpRcptCode;
    @XmlElement(name = "MrClass")
    protected String mrClass;
    @XmlElement(name = "HqmsClass")
    protected String hqmsClass;
    @XmlElement(name = "OutpEInvoiceType")
    protected String outpEInvoiceType;
    @XmlElement(name = "InpEInvoiceType")
    protected String inpEInvoiceType;
    @XmlElement(name = "AreaCode")
    protected String areaCode;

    /**
     * 获取definitionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDefinitionId() {
        return definitionId;
    }

    /**
     * 设置definitionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDefinitionId(Long value) {
        this.definitionId = value;
    }

    /**
     * 获取itemType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * 设置itemType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemType(String value) {
        this.itemType = value;
    }

    /**
     * 获取detailCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetailCode() {
        return detailCode;
    }

    /**
     * 设置detailCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetailCode(String value) {
        this.detailCode = value;
    }

    /**
     * 获取subjClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjClass() {
        return subjClass;
    }

    /**
     * 设置subjClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjClass(String value) {
        this.subjClass = value;
    }

    /**
     * 获取reckoningClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReckoningClass() {
        return reckoningClass;
    }

    /**
     * 设置reckoningClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReckoningClass(String value) {
        this.reckoningClass = value;
    }

    /**
     * 获取outpRcptCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpRcptCode() {
        return outpRcptCode;
    }

    /**
     * 设置outpRcptCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpRcptCode(String value) {
        this.outpRcptCode = value;
    }

    /**
     * 获取inpRcptCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInpRcptCode() {
        return inpRcptCode;
    }

    /**
     * 设置inpRcptCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInpRcptCode(String value) {
        this.inpRcptCode = value;
    }

    /**
     * 获取mrClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMrClass() {
        return mrClass;
    }

    /**
     * 设置mrClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMrClass(String value) {
        this.mrClass = value;
    }

    /**
     * 获取hqmsClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHqmsClass() {
        return hqmsClass;
    }

    /**
     * 设置hqmsClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHqmsClass(String value) {
        this.hqmsClass = value;
    }

    /**
     * 获取outpEInvoiceType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpEInvoiceType() {
        return outpEInvoiceType;
    }

    /**
     * 设置outpEInvoiceType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpEInvoiceType(String value) {
        this.outpEInvoiceType = value;
    }

    /**
     * 获取inpEInvoiceType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInpEInvoiceType() {
        return inpEInvoiceType;
    }

    /**
     * 设置inpEInvoiceType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInpEInvoiceType(String value) {
        this.inpEInvoiceType = value;
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

}
