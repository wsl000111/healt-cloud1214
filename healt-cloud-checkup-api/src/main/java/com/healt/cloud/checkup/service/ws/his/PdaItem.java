
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>pdaItem complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="pdaItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PouchCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InOrderExecId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pdaItem", propOrder = {
    "pouchCode",
    "inOrderExecId"
})
public class PdaItem {

    @XmlElement(name = "PouchCode")
    protected String pouchCode;
    @XmlElement(name = "InOrderExecId")
    protected String inOrderExecId;

    /**
     * 获取pouchCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPouchCode() {
        return pouchCode;
    }

    /**
     * 设置pouchCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPouchCode(String value) {
        this.pouchCode = value;
    }

    /**
     * 获取inOrderExecId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInOrderExecId() {
        return inOrderExecId;
    }

    /**
     * 设置inOrderExecId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInOrderExecId(String value) {
        this.inOrderExecId = value;
    }

}
