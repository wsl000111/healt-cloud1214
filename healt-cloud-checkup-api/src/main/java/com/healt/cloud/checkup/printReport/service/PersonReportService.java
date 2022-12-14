package com.healt.cloud.checkup.printReport.service;

import com.healt.cloud.checkup.printReport.vo.PrintPersonDictVo;
import com.healt.cloud.checkup.printReport.vo.mobile.HcReportVo;
import com.healt.cloud.checkup.printReport.vo.mobile.QueryReportListVo;
import com.healt.cloud.checkup.printReport.vo.mobile.ReportListVo;
import com.healt.cloud.common.pages.PageResult;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-01 8:56
 */
public interface PersonReportService {

    public PageResult findPrintPerson(PrintPersonDictVo printPersonDictVo);

    public List findPersonReport(String hospitalId, String personId, String personVisitId);

    public void updatePrint(String hospitalId, String personId, String personVisitId, String userName, String userRealName);

    List<ReportListVo> loadPersonReportList(QueryReportListVo queryReportListVo);

    HcReportVo loadPersonReportInfo(String hospitalId, String personId, String personVisitId);
}
