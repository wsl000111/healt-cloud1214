package com.healt.cloud.checkup.physicalExa.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-05-20 16:06
 */
@Data
public class LabTestMasterVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String itemName;

    @TableField("SPECIMEN")
    @JsonProperty("SPECIMEN")
    private String specimen;

    @TableField("REQUESTED_DATE_TIME")
    @JsonProperty("REQUESTED_DATE_TIME")
    private Date requestedDateTime;

    @TableField("ORDERING_PROVIDER")
    @JsonProperty("ORDERING_PROVIDER")
    private String orderingProvider;

    @TableField("RESULT_STATUS")
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

    @TableField("RESULTS_RPT_DATE_TIME")
    @JsonProperty("RESULTS_RPT_DATE_TIME")
    private Date resultsRptDateTime;

    @TableField("TRANSCRIPTIONIST")
    @JsonProperty("TRANSCRIPTIONIST")
    private String transcriptionist;

    @TableField("TEST_NO")
    @JsonProperty("TEST_NO")
    private String testNo;

    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @TableField("VERIFIED_BY")
    @JsonProperty("VERIFIED_BY")
    private String verifiedBy;
}
