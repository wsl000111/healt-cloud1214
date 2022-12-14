package com.healt.cloud.checkup.queryReport.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-08-20 22:31
 * @description: TODO
 */
@Data
public class PersonPdfReportVo implements Serializable {

    @JsonProperty("PERSON_ID")
    private String personId;

    @JsonProperty("PERSON_VISIT_ID")
    private String personVisitId;

    @JsonProperty("EXAM_NO")
    private String ExamNo;

    @JsonProperty("REPORT_URL")
    private String reportUrl;

}
