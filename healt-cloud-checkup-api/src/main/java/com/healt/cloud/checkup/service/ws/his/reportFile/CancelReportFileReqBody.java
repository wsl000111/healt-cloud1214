package com.healt.cloud.checkup.service.ws.his.reportFile;

import com.healt.cloud.checkup.service.ws.server.vo.SoapBody;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author linklee
 * @create 2022-08-03 10:16
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name = "Body")
@XmlType(name = "body", namespace = "com.healt.cloud.checkup.service.ws.his.reportFile.CancelReportFileReqBody")
public class CancelReportFileReqBody extends SoapBody {

    @XmlElement(name = "ReportInfo")
    private CancelReportFileReportInfo reportInfo;

    public CancelReportFileReportInfo getReportInfo() {
        return reportInfo;
    }

    public void setReportInfo(CancelReportFileReportInfo reportInfo) {
        this.reportInfo = reportInfo;
    }

    @Override
    public String toString() {
        return "CancelReportFileReqBody{" +
                "reportInfo=" + reportInfo +
                '}';
    }
}
