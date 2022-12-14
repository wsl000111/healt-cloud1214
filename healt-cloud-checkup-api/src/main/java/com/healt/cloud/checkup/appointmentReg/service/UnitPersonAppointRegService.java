package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.entity.HcPersonAppregItems;
import com.healt.cloud.checkup.entity.HcUnitGroup;
import com.healt.cloud.checkup.entity.HcUnitVisitInfo;
import com.healt.cloud.checkup.entity.VHcItemPackDict;
import com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg.*;
import com.healt.cloud.checkup.vo.settlement.PersonsInfoDictVo;
import com.healt.cloud.checkup.vo.settlement.PersonsInfoVo;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-08 0:03
 * @description: TODO
 */
public interface UnitPersonAppointRegService {

    List<HcUnitVisitInfo> findDtUnitVisit(String hospitalId, String unitId);

    List<HcUnitVisitInfo> findDtUnitVisit(String hospitalId, String unitId, String visitId);

    List<HcUnitGroup> findDtUnitGroup(String hospitalId, String unitId, String unitVisitId);

    List<DtUnitGroupItemsVo> findDtUnitGroupItems(String hospitalId, String unitId, String unitVisitId, String groupCode);

    List<HcPersonAppregItems> findDtPersonItems(String hospitalId, String personId, String personVisitId);

    List<VHcItemPackDict> findDtItemPackEffectiveFlag(String hospitalId);

    List<HcPersonInfoVo> findDtUnitPersons(String hospitalId, String unitId);

    Integer findMaxPersonVisitId(String hospitalId, String personId);

    List<DtUnitPersonsVisitVo> findDtUnitPersonsVisit(String hospital, String unitId, String visitId);

    String findSetSex(String hospitalId, String setName);

    void batchAddItems(BatchAddItemsVo batchAddItems);

    List<BatchUnitPersonsDeleteItemsVo> selectBatchDelItems(SelectBatchDelItemsListVo selectBatchDelItemsListVo);

    void batchUnitPersonsDeleteItems(BatchUnitPersonsDeleteItemsListVo batchDeleteItems);

    List<PersonsInfoVo> findPersonsInfo(String hospitalId, String unitId);

    List<PersonsInfoVo> findPersonsInfoByTime(PersonsInfoDictVo personsInfoDictVo);
}
