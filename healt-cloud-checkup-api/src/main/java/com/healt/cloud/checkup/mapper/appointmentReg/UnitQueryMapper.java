package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.queryReport.vo.UnitQueryDictVo;
import com.healt.cloud.checkup.queryReport.vo.UnitQueryVo;
import com.healt.cloud.checkup.vo.appointmentReg.unitPersons.DtUnitVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-19 13:53
 */
@Mapper
public interface UnitQueryMapper {

    List<DtUnitVo> findDtUnit(@Param("hospitalId") String hospitalId,
                              @Param("unitId") String unitId);

    List<UnitQueryVo> findUnitQuery(UnitQueryDictVo unitQueryDictVo);

}
