package com.healt.cloud.checkup.service.ws.his.reportFile;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author GuYue
 * @date 2022-08-20 21:54
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reportInfo", propOrder = {
        "patientId",
        "patientType",
        "applyNo"
})
@Data
public class PdfReporQueryReportInfo {

    @XmlElement(name = "PatientId")
    protected String patientId;
    @XmlElement(name = "PatientType")
    protected String patientType;
    @XmlElement(name = "ApplyNo")
    protected String applyNo;
}
