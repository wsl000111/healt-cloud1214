package com.healt.cloud.checkup.other.service;

import com.healt.cloud.checkup.entity.CostDetailBilling;
import com.healt.cloud.checkup.entity.HcPersonInfoErrlog;
import com.healt.cloud.checkup.other.vo.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-08-26 18:42
 * @description: TODO
 */
public interface OtherService {
    List<HclabResultByPVVo> findHclabResultByPV(String personId, String personVisitId);

    List<HcResultDictOtherVo> findHcResultDict(String deptId, String personId, String personVisitId);

    void updateDeptResultItems(String hospitalId, String personId, String personVisitId, String contentClass, String content);

    List<CostDetailBilling> findCostDetailBilling(String personId, String personVisitId);

    List<FinidPathologyApplyVo> findPathologyApply(String personId, String personVisitId);

    List<CostDetailBillingByTimeVo> findCostDetailBillingByTime(String beginDate, String endDate);
    void updatePersonVisitInfo(String unitId, String unitVisitId, String unitName, String personId, String personVisitId);

    List<PersonUnitInfoVo> findPersonUnitInfo(PersonUnitInfoDictVo personUnitInfoDictVo);

    List<TjShouRuTongJi> findTjtj(String tbegindate, String tenddate);

    List<TjtjDept> findTjtjDept(String tbegindate, String tenddate);
}
