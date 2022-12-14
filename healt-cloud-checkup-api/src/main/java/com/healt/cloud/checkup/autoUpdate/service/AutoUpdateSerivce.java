package com.healt.cloud.checkup.autoUpdate.service;

import com.healt.cloud.checkup.autoUpdate.vo.AppParsVo;
import com.healt.cloud.checkup.autoUpdate.vo.ApplicationsParaVo;
import com.healt.cloud.checkup.autoUpdate.vo.HealtUpdateLogListVo;
import com.healt.cloud.checkup.autoUpdate.vo.SaveHealtUpdateParaListVo;
import com.healt.cloud.checkup.entity.HealtUpdatePara;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-06-07 17:45
 * @description: TODO
 */
public interface AutoUpdateSerivce {

    String lastUpLoadTime(ApplicationsParaVo applicationsParaVo);

    String lastUpLoadTime(String code);

    List<AppParsVo> getAppPars(String isdownload);

    String getFtpValue(String hospitalId, String code);

    List<HealtUpdatePara> getUpdatePara(String hospitalId, String bz);

    void saveHealtUpdatePara(SaveHealtUpdateParaListVo saveHealtUpdateParaListVo);

    String getRemotepath(String hospitalId, String code);

    void updateLastuploadtime(String hospitalId, String code);

    void saveHealtUpdateLog(HealtUpdateLogListVo healtUpdateLogListVo);
}
