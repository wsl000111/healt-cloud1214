package com.healt.cloud.checkup.triage.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.healt.cloud.checkup.entity.HcCounselRequestInfo;
import com.healt.cloud.checkup.entity.HcIntervalRecord;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-19 12:51
 */
@Data
public class SaveCallPatientVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String hospitalId;
    @JsonProperty("queueo")
    private String queueNo;
    @JsonProperty("HC_QUEUE_CODE")
    private String hcQueueCode;
    private String queueDate;

    @JsonProperty("ROOM_CODE")
    private String roomCode;
    @JsonProperty("SPPID")
    private String sppid;
    @JsonProperty("SPPIDXH")
    private String sppidxh;

    private List<HcIntervalRecord> hcIntervalRecord;
    private List<HcCounselRequestInfo> hcCounselRequestInfo;


}
//    public List<SaveCallPatient> saveCallPatient { get; set; }
//
//public class SaveCallPatient //呼叫保存
//{
//    //修改  HC_QUEUE_NO  的  HC_QUEUE_CODE 值为 1 导检中
//    // 插入 HC_INTERVAL_RECORD
//    // 插入 HC_COUNSEL_REQUEST_INFO 呼叫系统
//    //修改 HC_ROOM_DICT 的 SPPID 与SPPIDXH 条件是 HOSPITAL_ID 与 ROOM_CODE
//    public string hospitalId { get; set; }
//    public string queueo { get; set; }
//    public string HC_QUEUE_CODE { get; set; }
//
//    public string ROOM_CODE { get; set; } // HC_ROOM_DICT
//    public string SPPID { get; set; } //
//    public string SPPIDXH { get; set; } //
//    public List<HC_INTERVAL_RECORD> hcIntervalRecord { get; set; }
//    public List<HC_COUNSEL_REQUEST_INFO> hcCounselRequestInfo { get; set; }