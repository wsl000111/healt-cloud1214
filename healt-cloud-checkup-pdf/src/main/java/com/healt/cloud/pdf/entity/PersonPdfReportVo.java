package com.healt.cloud.pdf.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-09-16 10:00
 * @description: TODO
 */
@Data
public class PersonPdfReportVo implements Serializable {

    @JsonProperty("PERSON_ID")
    private String personId;

    @JsonProperty("INSERT_DATE")
    private String insertDate;

    @JsonProperty("PERSON_VISIT_ID")
    private String personVisitId;

    @JsonProperty("EXAM_NO")
    private String ExamNo;

    @JsonProperty("REPORT_URL")
    private String reportUrl;

}
