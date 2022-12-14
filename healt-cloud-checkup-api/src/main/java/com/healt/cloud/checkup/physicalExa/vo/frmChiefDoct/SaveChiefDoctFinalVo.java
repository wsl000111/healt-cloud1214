package com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-27 9:29
 * @description: TODO
 */
@Data
public class SaveChiefDoctFinalVo implements Serializable {

    @JsonProperty("HOSPITAL_ID")
    public String hospitalId;

    @JsonProperty("PERSON_ID")
    public String personId;// 人员编号

    @JsonProperty("PERSON_VISIT_ID")
    public String personVisitId;// 体检次数

    @JsonProperty("RESULT_STATUS")
    public String resultStatus; // 体检审核 检查状态 0-已预约 1-已执行2-待审核 7-已初审 9-已终审

    @JsonProperty("FINAL_DOCOTER")
    public String finalDocoter;  //初步审核医生代码

    @JsonProperty("FINAL_DATE")
    public String finalDate; //初步审核时间

    @JsonProperty("FINAL_NAME")
    public String finalName; //初步审核医生名称

    private List<SaveHcAppendResult> saveHcAppendResult;

    public List<SaveHcDiagnosisRecord> saveHcDiagnosisRecord;
}
