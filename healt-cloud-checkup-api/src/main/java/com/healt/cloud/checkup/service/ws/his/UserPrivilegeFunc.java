
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>userPrivilegeFunc complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="userPrivilegeFunc"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FunctionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FunctionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FunctionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SystemFunctionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SystemFunctionValueDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userPrivilegeFunc", propOrder = {
    "functionCode",
    "functionName",
    "functionType",
    "systemFunctionValue",
    "systemFunctionValueDesc"
})
public class UserPrivilegeFunc {

    @XmlElement(name = "FunctionCode")
    protected String functionCode;
    @XmlElement(name = "FunctionName")
    protected String functionName;
    @XmlElement(name = "FunctionType")
    protected String functionType;
    @XmlElement(name = "SystemFunctionValue")
    protected String systemFunctionValue;
    @XmlElement(name = "SystemFunctionValueDesc")
    protected String systemFunctionValueDesc;

    /**
     * 获取functionCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionCode() {
        return functionCode;
    }

    /**
     * 设置functionCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionCode(String value) {
        this.functionCode = value;
    }

    /**
     * 获取functionName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     * 设置functionName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionName(String value) {
        this.functionName = value;
    }

    /**
     * 获取functionType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionType() {
        return functionType;
    }

    /**
     * 设置functionType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionType(String value) {
        this.functionType = value;
    }

    /**
     * 获取systemFunctionValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemFunctionValue() {
        return systemFunctionValue;
    }

    /**
     * 设置systemFunctionValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemFunctionValue(String value) {
        this.systemFunctionValue = value;
    }

    /**
     * 获取systemFunctionValueDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemFunctionValueDesc() {
        return systemFunctionValueDesc;
    }

    /**
     * 设置systemFunctionValueDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemFunctionValueDesc(String value) {
        this.systemFunctionValueDesc = value;
    }

    @Override
    public String toString() {
        return "UserPrivilegeFunc{" +
                "functionCode='" + functionCode + '\'' +
                ", functionName='" + functionName + '\'' +
                ", functionType='" + functionType + '\'' +
                ", systemFunctionValue='" + systemFunctionValue + '\'' +
                ", systemFunctionValueDesc='" + systemFunctionValueDesc + '\'' +
                '}';
    }
}
