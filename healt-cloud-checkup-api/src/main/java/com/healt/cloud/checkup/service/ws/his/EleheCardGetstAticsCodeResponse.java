
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>eleheCardGetstAticsCodeResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="eleheCardGetstAticsCodeResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReturnInfo" type="{http://wegohis.com}eleheCardGetstAticsCodeEntity" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eleheCardGetstAticsCodeResponse", propOrder = {
    "returnInfo"
})
public class EleheCardGetstAticsCodeResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "ReturnInfo")
    protected List<EleheCardGetstAticsCodeEntity> returnInfo;

    /**
     * Gets the value of the returnInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the returnInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReturnInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EleheCardGetstAticsCodeEntity }
     * 
     * 
     */
    public List<EleheCardGetstAticsCodeEntity> getReturnInfo() {
        if (returnInfo == null) {
            returnInfo = new ArrayList<EleheCardGetstAticsCodeEntity>();
        }
        return this.returnInfo;
    }

}
