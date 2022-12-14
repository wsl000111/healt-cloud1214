
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>eleheCardGetqrInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="eleheCardGetqrInfoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PatientQrInfo" type="{http://wegohis.com}eleheCardGetqrInfoEntity" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eleheCardGetqrInfoResponse", propOrder = {
    "patientQrInfo"
})
public class EleheCardGetqrInfoResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "PatientQrInfo")
    protected List<EleheCardGetqrInfoEntity> patientQrInfo;

    /**
     * Gets the value of the patientQrInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the patientQrInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPatientQrInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EleheCardGetqrInfoEntity }
     * 
     * 
     */
    public List<EleheCardGetqrInfoEntity> getPatientQrInfo() {
        if (patientQrInfo == null) {
            patientQrInfo = new ArrayList<EleheCardGetqrInfoEntity>();
        }
        return this.patientQrInfo;
    }

}
