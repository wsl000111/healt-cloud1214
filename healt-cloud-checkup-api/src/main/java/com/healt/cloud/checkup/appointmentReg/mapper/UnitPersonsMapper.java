package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.vo.appointmentReg.unitPersons.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-02 13:27
 */
@Mapper
public interface UnitPersonsMapper {

    List<DtUnitVo> findDtUnit(@Param("hospitalId") String hospitalId);

    List<DtClassTypeVo> findDtClassType(@Param("hospitalId") String hospitalId);

    List<DtCountryVo> findDtCountry(@Param("hospitalId") String hospitalId);

    List<DtAreaVo> findDtArea(@Param("hospitalId") String hospitalId);

    List<DtNationVo> findDtNation(@Param("hospitalId") String hospitalId);

    List<DtJobVo> findDtJob(@Param("hospitalId") String hospitalId);

    List<DtMaritalStatusVo> findDtMaritalStatus(@Param("hospitalId") String hospitalId);

    List<DtChargeTypeVo> findDtChargeType(@Param("hospitalId") String hospitalId);

    List<DtIdentityVo> findDtIdentity(@Param("hospitalId") String hospitalId);

    List<DtPersonInfoVo> findDtPersonInfo(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId);
}
