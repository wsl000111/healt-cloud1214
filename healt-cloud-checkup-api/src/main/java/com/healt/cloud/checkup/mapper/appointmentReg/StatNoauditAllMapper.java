package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.queryReport.vo.PersonNotFinalListVo;
import com.healt.cloud.checkup.queryReport.vo.StrWherePageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-26 15:31
 */
@Mapper
public interface StatNoauditAllMapper {

    List<PersonNotFinalListVo> findPersonNotFinalListTotal(StrWherePageVo strWherePageVo);

    List<PersonNotFinalListVo> findPersonNotFinalList(StrWherePageVo strWherePageVo);

    String findUnitCount(@Param("unitId") String unitId);


}
