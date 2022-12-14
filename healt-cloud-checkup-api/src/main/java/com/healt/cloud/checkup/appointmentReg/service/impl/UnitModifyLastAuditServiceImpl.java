package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.healt.cloud.checkup.appointmentReg.mapper.UnitModifyLastAuditMapper;
import com.healt.cloud.checkup.appointmentReg.service.UnitModifyLastAuditService;
import com.healt.cloud.checkup.appointmentReg.vo.unitModifyLastAudit.UnitBasePersonInfoVo;
import com.healt.cloud.checkup.appointmentReg.vo.unitModifyLastAudit.UnitBaseVo;
import com.healt.cloud.checkup.appointmentReg.vo.unitModifyLastAudit.UpdateUnitModifyLastAuditListVo;
import com.healt.cloud.checkup.appointmentReg.vo.unitModifyLastAudit.UpdateUnitModifyLastAuditVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-24 17:15
 */
@Service
@AllArgsConstructor
public class UnitModifyLastAuditServiceImpl implements UnitModifyLastAuditService {

    private UnitModifyLastAuditMapper modifyLastAuditMapper;

    @Override
    public List<UnitBaseVo> unitModifyLastAuditBase(String hospitalId, String unitId) {
        List<UnitBaseVo> list = modifyLastAuditMapper.unitModifyLastAuditBase(hospitalId, unitId);
        if (list.size() == 0) {
            list.add(new UnitBaseVo());
        }
        return list;
    }

    @Override
    public List<UnitBasePersonInfoVo> unitModifyLastAuditPersonInfo(String hospitalId, String unitId, String unitVisitId) {
        List<UnitBasePersonInfoVo> list = modifyLastAuditMapper.unitModifyLastAuditPersonInfo(hospitalId, unitId, unitVisitId);
        if (list.size() == 0) {
            list.add(new UnitBasePersonInfoVo());
        }
        return list;
    }

    @Transactional
    @Override
    public void updateUnitModifyLastAudit(UpdateUnitModifyLastAuditListVo updateUnitModifyLastAuditList) {
        for (UpdateUnitModifyLastAuditVo updateUnitModifyLastAudit: updateUnitModifyLastAuditList.getUpdateUnitModifyLastAudit()) {
            String hospitalId = updateUnitModifyLastAudit.getHospitalId();
            String unitId = updateUnitModifyLastAudit.getUnitId();
            String unitVisitId = updateUnitModifyLastAudit.getUnitVisitId();

            modifyLastAuditMapper.updatePersonStatus(hospitalId,unitId,unitVisitId);
            Integer tsl = modifyLastAuditMapper.findPersonCount(hospitalId,unitId,unitVisitId);
            modifyLastAuditMapper.updateUnitSign(hospitalId,unitId,unitVisitId,tsl.toString());

        }
    }
}
