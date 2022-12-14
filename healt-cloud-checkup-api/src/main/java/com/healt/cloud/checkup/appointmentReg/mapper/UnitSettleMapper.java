package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.vo.settlement.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-03 10:56
 */
@Mapper
public interface UnitSettleMapper {

    List<UnitInfoVo> findUnitInfo(@Param("hospitalId") String hospitalId);

    List<DiscountSchemeVo> findDiscountScheme();

    List<HcUnitGroupVo> findDtUnitGroup(@Param("hospitalId") String hospitalId, @Param("unitId") String unitId, @Param("unitVisitId") Integer unitVisitId);

    List<DtxmmxVo> findDtxmmx(@Param("hospitalId") String hospitalId, @Param("unitId") String unitId, @Param("unitVisitId") Integer unitVisitId);

    List<DtxmHZVo> findDtxmHZ(@Param("hospitalId") String hospitalId, @Param("unitId") String unitId, @Param("unitVisitId") Integer unitVisitId);

    List<SbYyVo> findSbYy(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") Integer unitVisitId,@Param("schemeCode") String schemeCode);

    List<DtxmmxVo> findDtxmmxPerson(String hospitalId, String unitId, Integer unitVisitId, String personIdStrWhe);

    List<DtxmHZVo> findDtxmHZPerson(String hospitalId, String unitId, Integer unitVisitId, String personIdStrWhe);
}
