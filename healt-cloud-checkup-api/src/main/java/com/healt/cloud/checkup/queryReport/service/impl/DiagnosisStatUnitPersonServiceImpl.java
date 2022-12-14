package com.healt.cloud.checkup.queryReport.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.DiagnosisStatUnitPersonMapper;
import com.healt.cloud.checkup.queryReport.service.DiagnosisStatUnitPersonService;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResults1Vo;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResults2Vo;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsPersonDictVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-30 13:35
 */
@Service
@AllArgsConstructor
public class DiagnosisStatUnitPersonServiceImpl implements DiagnosisStatUnitPersonService {

    private DiagnosisStatUnitPersonMapper diagnosisStatUnitPersonMapper;

    @Override
    public List<AbnormalResults1Vo> findAbnormalResults1(AbnormalResultsPersonDictVo abnormalResultsPersonDictVo) {
        List<AbnormalResults1Vo> list = diagnosisStatUnitPersonMapper.findAbnormalResults1(abnormalResultsPersonDictVo);
        if (list.size() == 0) {
            list.add(new AbnormalResults1Vo());
        }
        return list;
    }

    @Override
    public List<AbnormalResults2Vo> findAbnormalResults2(AbnormalResultsPersonDictVo abnormalResultsPersonDictVo) {
        List<AbnormalResults2Vo> list = diagnosisStatUnitPersonMapper.findAbnormalResults2(abnormalResultsPersonDictVo);
        if (list.size() == 0) {
            list.add(new AbnormalResults2Vo());
        }
        return list;
    }

    @Override
    public List<AbnormalResults1Vo> findAbnormalResults1ByTime(AbnormalResultsPersonDictVo abnormalResultsPersonDictVo) {
        List<AbnormalResults1Vo> list = diagnosisStatUnitPersonMapper.findAbnormalResults1ByTime(abnormalResultsPersonDictVo);
        if (list.size() == 0) {
            list.add(new AbnormalResults1Vo());
        }
        return list;
    }

    @Override
    public List<AbnormalResults2Vo> findAbnormalResults2ByTime(AbnormalResultsPersonDictVo abnormalResultsPersonDictVo) {
        List<AbnormalResults2Vo> list = diagnosisStatUnitPersonMapper.findAbnormalResults2ByTime(abnormalResultsPersonDictVo);
        if (list.size() == 0) {
            list.add(new AbnormalResults2Vo());
        }
        return list;
    }

}
