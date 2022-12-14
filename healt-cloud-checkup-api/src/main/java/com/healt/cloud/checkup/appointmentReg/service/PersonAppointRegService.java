package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.appointmentReg.vo.mobile.SavePersonAppointVo;
import com.healt.cloud.checkup.entity.ItemPackClassDict;
import com.healt.cloud.checkup.appointmentReg.vo.mobile.PersonAppointVo;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.*;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.vo.SaveHcPersonVisitInfoListVo;
import com.healt.cloud.common.pages.PageResult;

import java.util.List;

/**
 * @author linklee
 * @create 2022-03-29 17:39
 */
public interface PersonAppointRegService {

    public List<PackSetDictVo> findPackSetDict(String hospitalId);

    public List<PackItemDictVo> findPackItemDict(String hospitalId);

    public List<SetItemListVo> findSetItemList(String hospitalId, String setCode);

    public List<SelectedItemsVo> findSelectedItems(String hospitalId, String personId, Integer personVisitId);

    public List<UnitListVo> findUnitList(String hospitalId);

    public List<UnitGroupVo> findUnitGroup(String hospitalId, String unitId);

    //public List<PersonInfoVo> finishedSignFlag(String hospitalId, String personId);

    public List<PersonVisitInfoVo> findPersonVisitInfo(String hospitalId, String personId);

    public List<PersonInfoVo> findPersonInfo(String hospitalId, String personId);

    public void updateFinishedSign(String hospitalId, String personId, Integer personVisitId);

    public List<UnitGroupListVo> findItemsByGroup(String hospitalId, String groupCode, String unitId, Integer unitVisitId);

    public void savePersonVisitInfo(SaveHcPersonVisitInfoListVo saveHcPersonVisitInfoList);

    public void updateApplyNoPrint(String hospitalId, String applyNo);

    List<ItemPackClassDict> findItemPackClassList(String hospitalId);

    PageResult findPackSetDictPage(PersonAppointVo personAppointVo);

    PageResult loadPackItemListPage(PersonAppointVo personAppointVo);

    List<SetItemListVo> findSetItemListWeb(String hospitalId, String setCode);

    String savePersonAppoint(SavePersonAppointVo savePersonAppointVo);
}
