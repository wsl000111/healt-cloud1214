package com.healt.cloud.checkup.service.ws.his.reportFile;

import com.healt.cloud.checkup.service.ws.server.vo.SoapBody;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author linklee
 * @create 2022-08-03 9:04
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name = "Body")
@XmlType(name = "body", namespace = "com.healt.cloud.checkup.service.ws.his.reportFile.PublishReportFileReqBody")
public class PublishReportFileReqBody extends SoapBody {

    @XmlElement(name = "ReportInfo")
    private PublishReportFileReportInfo reportInfo;

    public PublishReportFileReportInfo getReportInfo() {
        return reportInfo;
    }

    public void setReportInfo(PublishReportFileReportInfo reportInfo) {
        this.reportInfo = reportInfo;
    }

    @Override
    public String toString() {
        return "PublishReportFileReqBody{" +
                "reportInfo=" + reportInfo +
                '}';
    }
}
