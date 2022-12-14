package com.healt.cloud.checkup.triage.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-06-20 11:28
 */
@Data
public class UpdateCallPatientVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String hospitalId;
    private String queueNo;
    private String roomCode;
    private String queueDate;
    private String personId;
    private String personVisitId;

    @JsonProperty("HC_QUEUE_CODE")
    private String hcQueueCode;
    @JsonProperty("END_TIME")
    private String endTime;
    @JsonProperty("QUEUE_INDICATOR")
    private String queueIndicator;
}
