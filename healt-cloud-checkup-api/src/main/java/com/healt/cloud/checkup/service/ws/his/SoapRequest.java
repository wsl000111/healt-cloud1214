
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.*;


/**
 * <p>soapRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="soapRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Header" type="{http://wegohis.com}soapHeader" minOccurs="0"/&gt;
 *         &lt;element name="Body" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapRequest", propOrder = {
    "header",
    "body"
})
/*@XmlSeeAlso({
        ApplyRequestBody.class,
        ClinicItemQueryReqBody.class,
        OrganizationRequestBody.class,
        UserInfoRequestBody.class,
        UserListRequestBody.class
})*/
public class SoapRequest {

    @XmlElement(name = "Header")
    protected SoapHeader header;
    @XmlElement(name = "Body")
    protected Object body;

    /**
     * 获取header属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SoapHeader }
     *     
     */
    public SoapHeader getHeader() {
        return header;
    }

    /**
     * 设置header属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SoapHeader }
     *     
     */
    public void setHeader(SoapHeader value) {
        this.header = value;
    }

    /**
     * 获取body属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getBody() {
        return body;
    }

    /**
     * 设置body属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setBody(Object value) {
        this.body = value;
    }

    @Override
    public String toString() {
        return "SoapRequest{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
