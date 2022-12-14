package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsDictVo;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-29 14:56
 */
@Mapper
public interface DiagnosisStatUnitMapper {

    String findTotalCount(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId);

    String findManCount(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId);

    String findWomanCount(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId);

    String findBeforeSignTotalCount(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId);

    String findBeforeSignManCount(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId);

    String findBeforeSignWomanCount(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId);

    List<AbnormalResultsVo> findAbnormalResults(AbnormalResultsDictVo abnormalResultsDictVo);

    String findTotalCount1(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);

    String findManCount1(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);

    String findWomanCount1(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);

    String findBeforeSignTotalCount1(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);

    String findBeforeSignManCount1(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);

    String findBeforeSignWomanCount1(String hospitalId, String unitId, String unitVisitId, String department, String personLeve);
}
