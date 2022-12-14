package com.healt.cloud.checkup.frmDivDocDepart.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-23 20:21
 * @description: TODO
 */
@Data
public class SaveDivDocDepartVo implements Serializable {
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;// 机构编号
    @JsonProperty("PERSON_ID")
    private String personId;// 人员编号
    @JsonProperty("PERSON_VISIT_ID")
    private String personVisitId;//  体检次数
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;//  更新HC_PERSON_VISIT_INFO 检查状态 0-已预约 1-已执行2-待审核 7-已初审 9-已终审
    @JsonProperty("SELECT_DOCTOR")
    private String selectDoctor; //体检医生
    @JsonProperty("SELECT_DOCTOR_NAME")
    private String selectDoctorName; //体检医生

    @JsonProperty("DEPT_CODE")
    private String deptCode; //体检医生

    private List<HcPersonAppregItemsVo> updateHcPersonAppregItems; //更新hc_person_appreg_items有变化更新 空不更新
    private List<SaveHcDeptResultDict> saveHcDeptResultDict; //根据主键判断新增还是修改 体检分科主记录
    private List<SaveHcDeptResultItems> saveHcDeptResultItems;//根据主键判断新增还是修改 体检分科结果明细记录
    private List<SaveHcResultDict> saveHcResultDict; //保存 体检项目结果记录
}
