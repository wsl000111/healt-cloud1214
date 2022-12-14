package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.appointmentReg.vo.unitModifyLastAudit.UnitBasePersonInfoVo;
import com.healt.cloud.checkup.appointmentReg.vo.unitModifyLastAudit.UnitBaseVo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-24 17:26
 */
@Mapper
public interface UnitModifyLastAuditMapper {

    List<UnitBaseVo> unitModifyLastAuditBase(@Param("hospitalId") String hospitalId, @Param("unitId") String unitId);

    List<UnitBasePersonInfoVo> unitModifyLastAuditPersonInfo(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId);

    void updatePersonStatus(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId);

    Integer findPersonCount(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId);

    void updateUnitSign(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId,@Param("unitVisitId") String unitVisitId,@Param("tsl") String tsl);
}
