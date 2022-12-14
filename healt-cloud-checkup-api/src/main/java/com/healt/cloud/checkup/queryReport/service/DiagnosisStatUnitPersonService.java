package com.healt.cloud.checkup.queryReport.service;

import com.healt.cloud.checkup.queryReport.vo.AbnormalResults1Vo;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResults2Vo;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsPersonDictVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-30 13:31
 */
public interface DiagnosisStatUnitPersonService {

    public List<AbnormalResults1Vo> findAbnormalResults1(AbnormalResultsPersonDictVo abnormalResultsPersonDictVo);

    public List<AbnormalResults2Vo> findAbnormalResults2(AbnormalResultsPersonDictVo abnormalResultsPersonDictVo);

    public List<AbnormalResults1Vo> findAbnormalResults1ByTime(AbnormalResultsPersonDictVo abnormalResultsPersonDictVo);

    public List<AbnormalResults2Vo> findAbnormalResults2ByTime(AbnormalResultsPersonDictVo abnormalResultsPersonDictVo);
}
