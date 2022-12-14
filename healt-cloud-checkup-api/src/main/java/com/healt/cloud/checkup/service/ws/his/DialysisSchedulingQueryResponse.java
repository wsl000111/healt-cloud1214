
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>dialysisSchedulingQueryResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="dialysisSchedulingQueryResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DialysisSchedulingList" type="{http://wegohis.com}queryDialysisScheduling" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dialysisSchedulingQueryResponse", propOrder = {
    "dialysisSchedulingList"
})
public class DialysisSchedulingQueryResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "DialysisSchedulingList")
    protected List<QueryDialysisScheduling> dialysisSchedulingList;

    /**
     * Gets the value of the dialysisSchedulingList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dialysisSchedulingList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDialysisSchedulingList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QueryDialysisScheduling }
     * 
     * 
     */
    public List<QueryDialysisScheduling> getDialysisSchedulingList() {
        if (dialysisSchedulingList == null) {
            dialysisSchedulingList = new ArrayList<QueryDialysisScheduling>();
        }
        return this.dialysisSchedulingList;
    }

}
