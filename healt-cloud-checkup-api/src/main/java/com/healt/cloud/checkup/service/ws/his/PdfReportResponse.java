
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>pdfReportResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="pdfReportResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReportList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ReportInfo" type="{http://wegohis.com}pdfReport" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pdfReportResponse", propOrder = {
    "reportList"
})
public class PdfReportResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "ReportList")
    protected ReportList reportList;

    /**
     * 获取reportList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReportList }
     *     
     */
    public ReportList getReportList() {
        return reportList;
    }

    /**
     * 设置reportList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReportList }
     *     
     */
    public void setReportList(ReportList value) {
        this.reportList = value;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ReportInfo" type="{http://wegohis.com}pdfReport" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "reportInfo"
    })
    public static class ReportList {

        @XmlElement(name = "ReportInfo")
        protected List<PdfReport> reportInfo;

        /**
         * Gets the value of the reportInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the reportInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReportInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PdfReport }
         * 
         * 
         */
        public List<PdfReport> getReportInfo() {
            if (reportInfo == null) {
                reportInfo = new ArrayList<PdfReport>();
            }
            return this.reportInfo;
        }

    }

}
