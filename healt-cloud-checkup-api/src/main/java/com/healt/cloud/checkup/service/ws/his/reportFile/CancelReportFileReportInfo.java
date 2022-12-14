package com.healt.cloud.checkup.service.ws.his.reportFile;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author linklee
 * @create 2022-08-03 10:16
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publishReportFileReportInfo", propOrder = {
        "patientId",
        "visitId",
        "patientType",
        "areaCode",
        "patientName",
        "reportNo",
        "reportBelongType",
        "reportType",
        "reportName",
        "publishDate",
        "applyNo",
        "descn",
        "flag",
        "imageNo",
        "pageOrention",
        "pageSize",
        "pageCount",
        "printAddr"
})
@Data
public class CancelReportFileReportInfo {

    @XmlElement(name = "PatientId")
    private String patientId;
    @XmlElement(name = "VisitId")
    private String visitId;
    @XmlElement(name = "PatientType")
    private String patientType;
    @XmlElement(name = "AreaCode")
    private String areaCode;
    @XmlElement(name = "PatientName")
    private String patientName;
    @XmlElement(name = "ReportNo")
    private String reportNo;
    @XmlElement(name = "ReportBelongType")
    private String reportBelongType;
    @XmlElement(name = "ReportType")
    private String reportType;
    @XmlElement(name = "ReportName")
    private String reportName;
    @XmlElement(name = "PublishDate")
    private String publishDate;
    @XmlElement(name = "ApplyNo")
    private String applyNo;
    @XmlElement(name = "Descn")
    private String descn;
    @XmlElement(name = "Flag")
    private String flag;
    @XmlElement(name = "ImageNo")
    private String imageNo;
    @XmlElement(name = "PageOrention")
    private String pageOrention;
    @XmlElement(name = "PageSize")
    private String pageSize;
    @XmlElement(name = "PageCount")
    private String pageCount;
    @XmlElement(name = "PrintAddr")
    private String printAddr;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getReportBelongType() {
        return reportBelongType;
    }

    public void setReportBelongType(String reportBelongType) {
        this.reportBelongType = reportBelongType;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getImageNo() {
        return imageNo;
    }

    public void setImageNo(String imageNo) {
        this.imageNo = imageNo;
    }

    public String getPageOrention() {
        return pageOrention;
    }

    public void setPageOrention(String pageOrention) {
        this.pageOrention = pageOrention;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getPrintAddr() {
        return printAddr;
    }

    public void setPrintAddr(String printAddr) {
        this.printAddr = printAddr;
    }

    @Override
    public String toString() {
        return "CancelReportFileReportInfo{" +
                "patientId='" + patientId + '\'' +
                ", visitId='" + visitId + '\'' +
                ", patientType='" + patientType + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", patientName='" + patientName + '\'' +
                ", reportNo='" + reportNo + '\'' +
                ", reportBelongType='" + reportBelongType + '\'' +
                ", reportType='" + reportType + '\'' +
                ", reportName='" + reportName + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", applyNo='" + applyNo + '\'' +
                ", descn='" + descn + '\'' +
                ", flag='" + flag + '\'' +
                ", imageNo='" + imageNo + '\'' +
                ", pageOrention='" + pageOrention + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", pageCount='" + pageCount + '\'' +
                ", printAddr='" + printAddr + '\'' +
                '}';
    }
}
