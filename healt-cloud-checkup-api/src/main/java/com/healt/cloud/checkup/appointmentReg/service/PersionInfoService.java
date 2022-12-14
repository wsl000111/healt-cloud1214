package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.entity.HcPersonInfo;
import com.healt.cloud.checkup.service.ws.his.CreateArchiveResponse;
import com.healt.cloud.checkup.vo.appointmentReg.hcPersonDict.HcPersonInfoVo;
import com.healt.cloud.checkup.vo.appointmentReg.hcPersonDict.SaveHcPersonDictListVo;
import com.healt.cloud.common.pages.PageResult;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-22 8:59
 * @description: TODO
 */
public interface PersionInfoService {

    List<HcPersonInfo> findPersonList(String hospitalCode);

    List<HcPersonInfo> findPersonList(String hospitalCode, String unitId);

    void savePersonDictList(SaveHcPersonDictListVo saveHcPersonDictListVo);

    String findPeId(String hospitalCode);

    PageResult<HcPersonInfo> findPersonListPage(HcPersonInfoVo hcPersonInfoVo);

    HcPersonInfo findPersonInfoWeb(HcPersonInfo hcPersonInfo);

    String findPersonInfoWS(String medInstCode, String areaCode, String idCard, String patientName);

    CreateArchiveResponse archiveCreate(HcPersonInfo hcPersonInfo, String methodName);
}
