package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.appointmentReg.vo.unitModifyLastAudit.UnitBasePersonInfoVo;
import com.healt.cloud.checkup.appointmentReg.vo.unitModifyLastAudit.UnitBaseVo;
import com.healt.cloud.checkup.appointmentReg.vo.unitModifyLastAudit.UpdateUnitModifyLastAuditListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-24 17:15
 */
public interface UnitModifyLastAuditService {

    public List<UnitBaseVo> unitModifyLastAuditBase(String hospitalId, String unitId);

    public List<UnitBasePersonInfoVo> unitModifyLastAuditPersonInfo(String hospitalId, String unitId, String unitVisitId);

    public void updateUnitModifyLastAudit(UpdateUnitModifyLastAuditListVo updateUnitModifyLastAuditList);
}
