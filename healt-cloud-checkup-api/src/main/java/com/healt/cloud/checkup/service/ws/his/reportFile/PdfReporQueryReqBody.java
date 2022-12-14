package com.healt.cloud.checkup.service.ws.his.reportFile;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author GuYue
 * @date 2022-08-20 21:52
 * @description: TODO
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class PdfReporQueryReqBody {

    @XmlElement(name = "ReportInfo")
    private PdfReporQueryReportInfo reportInfo;
}
