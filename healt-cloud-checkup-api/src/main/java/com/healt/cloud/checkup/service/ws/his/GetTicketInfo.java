
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getTicketInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getTicketInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="InvNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InvCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InvCheckCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="invDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InvQRCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pdfUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PdfPreviewUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTicketInfo", propOrder = {
    "invNo",
    "invCode",
    "invCheckCode",
    "invDate",
    "invQRCode",
    "pdfUrl",
    "pdfPreviewUrl"
})
public class GetTicketInfo {

    @XmlElement(name = "InvNo")
    protected String invNo;
    @XmlElement(name = "InvCode")
    protected String invCode;
    @XmlElement(name = "InvCheckCode")
    protected String invCheckCode;
    protected String invDate;
    @XmlElement(name = "InvQRCode")
    protected String invQRCode;
    protected String pdfUrl;
    @XmlElement(name = "PdfPreviewUrl")
    protected String pdfPreviewUrl;

    /**
     * 获取invNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvNo() {
        return invNo;
    }

    /**
     * 设置invNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvNo(String value) {
        this.invNo = value;
    }

    /**
     * 获取invCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvCode() {
        return invCode;
    }

    /**
     * 设置invCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvCode(String value) {
        this.invCode = value;
    }

    /**
     * 获取invCheckCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvCheckCode() {
        return invCheckCode;
    }

    /**
     * 设置invCheckCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvCheckCode(String value) {
        this.invCheckCode = value;
    }

    /**
     * 获取invDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvDate() {
        return invDate;
    }

    /**
     * 设置invDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvDate(String value) {
        this.invDate = value;
    }

    /**
     * 获取invQRCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvQRCode() {
        return invQRCode;
    }

    /**
     * 设置invQRCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvQRCode(String value) {
        this.invQRCode = value;
    }

    /**
     * 获取pdfUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPdfUrl() {
        return pdfUrl;
    }

    /**
     * 设置pdfUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPdfUrl(String value) {
        this.pdfUrl = value;
    }

    /**
     * 获取pdfPreviewUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPdfPreviewUrl() {
        return pdfPreviewUrl;
    }

    /**
     * 设置pdfPreviewUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPdfPreviewUrl(String value) {
        this.pdfPreviewUrl = value;
    }

}
