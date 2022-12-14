package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect.SuggestDepartDictVo;
import com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect.SuggestDictVo;
import com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect.SuggestVDepartDictVo;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-31 15:52
 * @description: TODO
 */
public interface SuggestItemSelectService {
    List<SuggestDepartDictVo> loadDepartDict();

    List<SuggestVDepartDictVo> loadVDepartDict(String hospitalId);

    List<SuggestDictVo> loadSuggestDict(String hospitalId, String deptId);
}
