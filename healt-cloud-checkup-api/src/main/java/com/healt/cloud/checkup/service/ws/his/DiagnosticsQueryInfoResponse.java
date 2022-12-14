
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>diagnosticsQueryInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="diagnosticsQueryInfoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PatientVisitList" type="{http://wegohis.com}diagnosticsQueryPatientInfoVO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diagnosticsQueryInfoResponse", propOrder = {
    "patientVisitList"
})
public class DiagnosticsQueryInfoResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "PatientVisitList")
    protected List<DiagnosticsQueryPatientInfoVO> patientVisitList;

    /**
     * Gets the value of the patientVisitList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the patientVisitList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPatientVisitList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DiagnosticsQueryPatientInfoVO }
     * 
     * 
     */
    public List<DiagnosticsQueryPatientInfoVO> getPatientVisitList() {
        if (patientVisitList == null) {
            patientVisitList = new ArrayList<DiagnosticsQueryPatientInfoVO>();
        }
        return this.patientVisitList;
    }

}
