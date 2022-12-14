package com.healt.cloud.checkup.printReport.service;

import com.healt.cloud.checkup.printReport.vo.UnitQueryReportDictVo;
import com.healt.cloud.checkup.printReport.vo.UnitQueryReportVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-02 8:47
 */
public interface UnitReportService {

    public List<UnitQueryReportVo> findUnitQueryReport(UnitQueryReportDictVo unitQueryReportDictVo);

    public List findUnitReport(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);

    List findUnitDepartment(String unitId, String unitVisitId);

    List findUnitLevel(String unitId, String unitVisitId);
}
