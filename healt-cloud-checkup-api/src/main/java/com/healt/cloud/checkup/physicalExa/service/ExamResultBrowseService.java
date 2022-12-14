package com.healt.cloud.checkup.physicalExa.service;

import com.healt.cloud.checkup.physicalExa.vo.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-25 11:25
 */
public interface ExamResultBrowseService {

    public List<HcDeptResultVo> findHcDeptResult(HcDeptResultDictVo hcDeptResultDictVo);

    public List findExamMasterCount(String examNo);

    public List findExamReportCount(String examNo);

    public List<ExamReportVo> findExamReport(String examNo);

    public List<ExamMasterReporterVo> findExamMasterReporter(String examNo);

    public List<ExamMasterVo> findExamMaster(String txzbl);

    public List<ExamReport1Vo> findExamReport1(String examNo);
}
