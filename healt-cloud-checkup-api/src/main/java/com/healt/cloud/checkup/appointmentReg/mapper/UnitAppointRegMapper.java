package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-15 12:54
 * @description: TODO
 */
@Mapper
public interface UnitAppointRegMapper {

    List<DtPackClassVo> findDtPackClass(@Param("hospitalId") String hospitalId);

    List<DtPackItemsVo> findDtPackItems(@Param("hospitalId") String hospitalId);

    List<DtSetsVo> findDtSets(@Param("hospitalId") String hospitalId);

    List<DtUnitTypeVo> findDtUnitType(@Param("hospitalId") String hospitalId);

    List<DtParentUnitVo> findDtParentUnit(@Param("hospitalId") String hospitalId);

    List<DtUnitGroupItemsVo2> findDtUnitGroupItems2(@Param("hospitalId") String hospitalId, @Param("unitId") String unitId, @Param("unitVisitId") String unitVisitId);

    String findNewUnitId();

    Integer findMaxVisitId(@Param("hospitalId") String hospitalId, @Param("unitId") String unitId);

    Integer findFinishedSign(@Param("hospitalId") String hospitalId, @Param("unitId") String unitId, @Param("unitVisitId") String unitVisitId);

    List<SetPacksVo> findSetPacks(@Param("hospitalId") String hospitalId, @Param("setCode") String setCode);

    void updateHcUnitInfo(@Param("hospitalId") String hospitalId, @Param("unitId") String unitId, @Param("values") String values);
}
