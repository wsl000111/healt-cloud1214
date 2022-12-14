
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>regLockResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="regLockResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LockInfo" type="{http://wegohis.com}regLockInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "regLockResponse", propOrder = {
    "lockInfo"
})
public class RegLockResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "LockInfo")
    protected RegLockInfo lockInfo;

    /**
     * 获取lockInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RegLockInfo }
     *     
     */
    public RegLockInfo getLockInfo() {
        return lockInfo;
    }

    /**
     * 设置lockInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RegLockInfo }
     *     
     */
    public void setLockInfo(RegLockInfo value) {
        this.lockInfo = value;
    }

}
