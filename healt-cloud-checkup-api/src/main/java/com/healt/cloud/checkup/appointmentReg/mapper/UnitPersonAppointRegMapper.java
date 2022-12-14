package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg.*;
import com.healt.cloud.checkup.vo.settlement.PersonsInfoDictVo;
import com.healt.cloud.checkup.vo.settlement.PersonsInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-11 19:08
 * @description: TODO
 */
@Mapper
public interface UnitPersonAppointRegMapper {

    List<DtUnitGroupItemsVo> findDtUnitGroupItems(@Param("hospitalId") String hospitalId,
                                                  @Param("unitId") String unitId,
                                                  @Param("unitVisitId") String unitVisitId,
                                                  @Param("groupCode") String groupCode);

    List<HcPersonInfoVo> findDtUnitPersons(@Param("hospitalId") String hospitalId,
                                           @Param("unitId") String unitId);

    Integer findMaxPersonVisitId(@Param("hospitalId") String hospitalId,
                                 @Param("personId") String personId);

    List<DtUnitPersonsVisitVo> findDtUnitPersonsVisit(@Param("hospitalId") String hospitalId,
                                                      @Param("unitId") String unitId,
                                                      @Param("visitId") String visitId);

    BatchUnitPersonsDeleteItemsVo selectBatchDelItems(SelectBatchDelItemsVo selectBatchDelItemsVo);

    List<PersonsInfoVo> findPersonsInfo(@Param("hospitalId") String hospitalId,@Param("unitId") String unitId);

    List<PersonsInfoVo> findPersonsInfoByTime(PersonsInfoDictVo personsInfoDictVo);
}
