package com.healt.cloud.checkup.triage.service;

import com.healt.cloud.checkup.entity.HcCounselRequestInfo;
import com.healt.cloud.checkup.triage.vo.CounselRequestInfoDictVo;
import com.healt.cloud.checkup.triage.vo.HcCounselRequestInfoListVo;
import com.healt.cloud.checkup.triage.vo.SaveCallPatientVo;
import com.healt.cloud.checkup.triage.vo.UpdateCallPatientVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-19 9:43
 */
public interface CounselRequestInfoService {

    public List<HcCounselRequestInfo> findCounselRequestInfo(CounselRequestInfoDictVo counselRequestInfoDictVo);

    public void deleteCounselRequestInfo(HcCounselRequestInfoListVo hcCounselRequestInfoList);

    public void saveCallPatient(SaveCallPatientVo saveCallPatient);

    public void updateCallPatient(UpdateCallPatientVo updateCallPatient);
}
