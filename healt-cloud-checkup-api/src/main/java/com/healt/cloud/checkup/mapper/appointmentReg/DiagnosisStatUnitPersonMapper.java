package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.queryReport.vo.AbnormalResults1Vo;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResults2Vo;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsPersonDictVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-30 13:37
 */
@Mapper
public interface DiagnosisStatUnitPersonMapper {

    List<AbnormalResults1Vo> findAbnormalResults1(AbnormalResultsPersonDictVo abnormalResultsPersonDictVo);

    List<AbnormalResults2Vo> findAbnormalResults2(AbnormalResultsPersonDictVo abnormalResultsPersonDictVo);

    List<AbnormalResults1Vo> findAbnormalResults1ByTime(AbnormalResultsPersonDictVo abnormalResultsPersonDictVo);

    List<AbnormalResults2Vo> findAbnormalResults2ByTime(AbnormalResultsPersonDictVo abnormalResultsPersonDictVo);
}
