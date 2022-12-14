package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-15 12:49
 * @description: TODO
 */
public interface UnitAppointRegService {
    List<DtPackClassVo> findDtPackClass(String hospitalId);

    List<DtPackItemsVo> findDtPackItems(String hospitalId);

    List<DtSetsVo> findDtSets(String hospitalId);

    List<DtUnitTypeVo> findDtUnitType(String hospitalId);

    List<DtParentUnitVo> findDtParentUnit(String hospitalId);

    List<DtUnitGroupItemsVo2> findDtUnitGroupItems2(String hospitalId, String unitId, String unitVisitId);

    Integer findPatCount(String hospitalId, String unitId, String visitId);

    String findNewUnitId();

    Integer findMaxVisitId(String hospitalId, String unitId);

    Integer findFinishedSign(String hospitalId, String unitId, String visitId);

    List<SetPacksVo> findSetPacks(String hospitalId, String setCode);

    void saveHcUnitGroupList(SaveHcUnitGroupListVo saveHcUnitGroupListVo);

    void saveHcUnitVisitGroupList(SaveHcUnitVisitGroupListVo saveHcUnitVisitGroupListVo);

    void deleteHcUnitVisitGroupList(SaveHcUnitVisitGroupListVo saveHcUnitVisitGroupListVo);
}
