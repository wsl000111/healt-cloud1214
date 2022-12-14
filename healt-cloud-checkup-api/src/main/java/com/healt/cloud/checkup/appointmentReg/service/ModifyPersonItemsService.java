package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.vo.appointmentReg.modifyPersonItems.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-15 14:38
 */
public interface ModifyPersonItemsService {

    List<ModifySelectedItemsVo> findModifySelectedItems(String hospitalId, String personId, Integer personVisitId);

    List<SelectedPackSetVo> findSelectedPackSetVo(String hospitalId, String personId, Integer personVisitId);

    List<PublicDictVo> findPublicDict(String dictType);

    List<UnitPersonsVo> findUnitPersons(String hospitalId, String unitId);

    List<ModifyPersonVisitInfoVo> findModifyPersonVisitInfoVo(String hospitalId, String personId);

    List<ModifyPersonVisitInfoVo> findModifyPersonVisitInfoVoTwo(String hospitalId, String personId, String personVisitId);

    String findItemClass(String hospitalId, String itemPackCode);

    String findApplySendto(String itemPackCode);

    String saveModifyPersonItemList(SaveModifyPersonItemsListVo saveModifyPersonItemsListVo);
}
