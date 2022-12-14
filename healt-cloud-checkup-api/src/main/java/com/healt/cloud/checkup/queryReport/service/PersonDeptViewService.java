package com.healt.cloud.checkup.queryReport.service;

import com.healt.cloud.checkup.queryReport.vo.DiagnosisRecordVo;
import com.healt.cloud.checkup.queryReport.vo.PersonDeptInfoDictVo;
import com.healt.cloud.common.pages.PageResult;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-29 9:15
 */
public interface PersonDeptViewService {

    public PageResult findPersonDeptInfo(PersonDeptInfoDictVo personDeptInfoDictVo);

    public List<DiagnosisRecordVo> findDiagnosisRecord(String hospitalId, String personId, String personVisitId);
}
