package com.healt.cloud.checkup.service.business;

import com.healt.cloud.checkup.entity.HcPackSetDict;
import com.healt.cloud.checkup.vo.busniess.packClinic.SaveHcPackSetDictListVo;
import com.healt.cloud.checkup.vo.busniess.packSet.HcSetVsPackDictVo;
import com.healt.cloud.checkup.vo.busniess.packSet.PackSetNewVo;
import com.healt.cloud.checkup.vo.busniess.packSet.SaveHcSetVsPackDictVo;
import com.healt.cloud.checkup.vo.busniess.packSet.VHcItemPackDictVo;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-17 11:05
 * @description: 套餐service
 */
public interface PackSetDictService {

    List<HcPackSetDict> findDtPackSetDict(String hospitalId);

    List<HcSetVsPackDictVo> findDtSetVsPack(String hospitalId, String setCode);

    List<VHcItemPackDictVo> findDtItemPackDict(String hospitalId);

    void saveHcSetVsPackDictList(SaveHcSetVsPackDictVo saveHcSetVsPackDictVo);

    void saveHcPackSetDictList(SaveHcPackSetDictListVo saveHcPackSetDictListVo);

    List<PackSetNewVo> findPackSetNew();
}
