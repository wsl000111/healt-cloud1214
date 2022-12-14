package com.healt.cloud.checkup.queryReport.service;

import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsDictVo;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-29 14:54
 */
public interface DiagnosisStatUnitService {

    public List findTotalCount(String hospitalId, String unitId, String unitVisitId);

    public List findManCount(String hospitalId, String unitId, String unitVisitId);

    public List findWomanCount(String hospitalId, String unitId, String unitVisitId);

    public List findBeforeSignTotalCount(String hospitalId, String unitId, String unitVisitId);

    public List findBeforeSignManCount(String hospitalId, String unitId, String unitVisitId);

    public List findBeforeSignWomanCount(String hospitalId, String unitId, String unitVisitId);

    public List<AbnormalResultsVo> findAbnormalResults(AbnormalResultsDictVo abnormalResultsDictVo);

    List findTotalCount(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);

    List findManCount(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);

    List findWomanCount(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);

    List findBeforeSignTotalCount(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);

    List findBeforeSignManCount(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);

    List findBeforeSignWomanCount(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);
}
