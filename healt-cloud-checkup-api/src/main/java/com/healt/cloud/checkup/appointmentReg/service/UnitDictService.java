package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.entity.HcUnitInfo;
import com.healt.cloud.checkup.vo.appointmentReg.hcUintDict.SaveHcUnitDictListVo;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-28 9:34
 * @description: TODO
 */
public interface UnitDictService {

    List<HcUnitInfo> findUnitList(String hospitalCode);

    List<HcUnitInfo> findDtUnit(String hospitalId);

    List<HcUnitInfo> findDtUnit(String hospitalId, String unitId);

    void saveUnitDictList(SaveHcUnitDictListVo saveHcUnitDictListVo);
}
