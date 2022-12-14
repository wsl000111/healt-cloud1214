
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>userPrivilegeSysCtlAuth complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="userPrivilegeSysCtlAuth"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AuthorityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AuthorityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AuthorityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SystemCtlAuthorityValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SystemCtlAuthorityValueDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userPrivilegeSysCtlAuth", propOrder = {
    "authorityCode",
    "authorityName",
    "authorityType",
    "systemCtlAuthorityValue",
    "systemCtlAuthorityValueDesc"
})
public class UserPrivilegeSysCtlAuth {

    @XmlElement(name = "AuthorityCode")
    protected String authorityCode;
    @XmlElement(name = "AuthorityName")
    protected String authorityName;
    @XmlElement(name = "AuthorityType")
    protected String authorityType;
    @XmlElement(name = "SystemCtlAuthorityValue")
    protected String systemCtlAuthorityValue;
    @XmlElement(name = "SystemCtlAuthorityValueDesc")
    protected String systemCtlAuthorityValueDesc;

    /**
     * 获取authorityCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorityCode() {
        return authorityCode;
    }

    /**
     * 设置authorityCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorityCode(String value) {
        this.authorityCode = value;
    }

    /**
     * 获取authorityName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * 设置authorityName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorityName(String value) {
        this.authorityName = value;
    }

    /**
     * 获取authorityType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorityType() {
        return authorityType;
    }

    /**
     * 设置authorityType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorityType(String value) {
        this.authorityType = value;
    }

    /**
     * 获取systemCtlAuthorityValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemCtlAuthorityValue() {
        return systemCtlAuthorityValue;
    }

    /**
     * 设置systemCtlAuthorityValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemCtlAuthorityValue(String value) {
        this.systemCtlAuthorityValue = value;
    }

    /**
     * 获取systemCtlAuthorityValueDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemCtlAuthorityValueDesc() {
        return systemCtlAuthorityValueDesc;
    }

    /**
     * 设置systemCtlAuthorityValueDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemCtlAuthorityValueDesc(String value) {
        this.systemCtlAuthorityValueDesc = value;
    }

    @Override
    public String toString() {
        return "UserPrivilegeSysCtlAuth{" +
                "authorityCode='" + authorityCode + '\'' +
                ", authorityName='" + authorityName + '\'' +
                ", authorityType='" + authorityType + '\'' +
                ", systemCtlAuthorityValue='" + systemCtlAuthorityValue + '\'' +
                ", systemCtlAuthorityValueDesc='" + systemCtlAuthorityValueDesc + '\'' +
                '}';
    }
}
