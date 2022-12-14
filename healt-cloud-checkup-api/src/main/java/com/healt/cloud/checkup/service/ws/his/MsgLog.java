
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>msgLog complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="msgLog"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TerminalNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PlatformCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IpAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RequestWay" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "msgLog", propOrder = {
    "terminalNo",
    "userId",
    "platformCode",
    "ipAddr",
    "requestWay"
})
public class MsgLog {

    @XmlElement(name = "TerminalNo", required = true)
    protected String terminalNo;
    @XmlElement(name = "UserId")
    protected String userId;
    @XmlElement(name = "PlatformCode")
    protected String platformCode;
    @XmlElement(name = "IpAddr")
    protected String ipAddr;
    @XmlElement(name = "RequestWay", required = true)
    protected String requestWay;

    /**
     * 获取terminalNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalNo() {
        return terminalNo;
    }

    /**
     * 设置terminalNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalNo(String value) {
        this.terminalNo = value;
    }

    /**
     * 获取userId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置userId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * 获取platformCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatformCode() {
        return platformCode;
    }

    /**
     * 设置platformCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatformCode(String value) {
        this.platformCode = value;
    }

    /**
     * 获取ipAddr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpAddr() {
        return ipAddr;
    }

    /**
     * 设置ipAddr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpAddr(String value) {
        this.ipAddr = value;
    }

    /**
     * 获取requestWay属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestWay() {
        return requestWay;
    }

    /**
     * 设置requestWay属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestWay(String value) {
        this.requestWay = value;
    }

    @Override
    public String toString() {
        return "MsgLog{" +
                "terminalNo='" + terminalNo + '\'' +
                ", userId='" + userId + '\'' +
                ", platformCode='" + platformCode + '\'' +
                ", ipAddr='" + ipAddr + '\'' +
                ", requestWay='" + requestWay + '\'' +
                '}';
    }
}
