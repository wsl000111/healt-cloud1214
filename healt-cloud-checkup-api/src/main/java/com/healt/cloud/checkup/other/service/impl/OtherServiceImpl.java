package com.healt.cloud.checkup.other.service.impl;

import com.healt.cloud.checkup.entity.CostDetailBilling;
import com.healt.cloud.checkup.other.mapper.OtherMapper;
import com.healt.cloud.checkup.other.service.OtherService;
import com.healt.cloud.checkup.other.vo.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-08-26 18:43
 * @description: TODO
 */
@Service
public class OtherServiceImpl implements OtherService {

    @Autowired
    private OtherMapper otherMapper;

    @Override
    public List<HclabResultByPVVo> findHclabResultByPV(String personId, String personVisitId) {

        return otherMapper.findHclabResultByPV(personId, personVisitId);
    }

    @Override
    public List<HcResultDictOtherVo> findHcResultDict(String deptId, String personId, String personVisitId) {
        return otherMapper.findHcResultDict(deptId,personId, personVisitId);
    }

    @Override
    public void updateDeptResultItems(String hospitalId, String personId, String personVisitId, String contentClass, String content) {
        if(StringUtils.isNotEmpty(content)){
            content = content.trim();
        }
        otherMapper.updateDeptResultItems(hospitalId,personId,personVisitId,contentClass,content);
    }

    @Override
    public List<CostDetailBilling> findCostDetailBilling(String personId, String personVisitId) {
        return otherMapper.findCostDetailBilling(personId, personVisitId);
    }

    @Override
    public List<FinidPathologyApplyVo> findPathologyApply(String personId, String personVisitId) {
        List<FinidPathologyApplyVo> list = otherMapper.findPathologyApply(personId, personVisitId);
        if (list.size() == 0){
            list.add(new FinidPathologyApplyVo());
        }
        return list;
    }

    @Override
    public List<CostDetailBillingByTimeVo> findCostDetailBillingByTime(String beginDate, String endDate) {
        return otherMapper.findCostDetailBillingByTime(beginDate, endDate);
    }

    @Override
    public void updatePersonVisitInfo(String unitId, String unitVisitId, String unitName, String personId, String personVisitId) {
        otherMapper.updatePersonVisitInfo(unitId,unitVisitId,unitName,personId,personVisitId);
    }

    @Override
    public List<PersonUnitInfoVo> findPersonUnitInfo(PersonUnitInfoDictVo personUnitInfoDictVo) {
        if (StringUtils.isEmpty(personUnitInfoDictVo.getUnitId())) {
            personUnitInfoDictVo.setUnitId(null);
        }
        if (StringUtils.isEmpty(personUnitInfoDictVo.getUnitVisitId())) {
            personUnitInfoDictVo.setUnitVisitId(null);
        }
        return otherMapper.findPersonUnitInfo(personUnitInfoDictVo);
    }

    @Override
    public List<TjShouRuTongJi> findTjtj(String tbegindate, String tenddate) {
        return otherMapper.findTjtj(tbegindate, tenddate);
    }

    @Override
    public List<TjtjDept> findTjtjDept(String tbegindate, String tenddate) {
        return otherMapper.findTjtjDept(tbegindate, tenddate);
    }


}
