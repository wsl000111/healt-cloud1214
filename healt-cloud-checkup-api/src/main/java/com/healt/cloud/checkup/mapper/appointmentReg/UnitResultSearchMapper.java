package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.queryReport.vo.PersonListVo;
import com.healt.cloud.checkup.queryReport.vo.PersonTztListDictVo;
import com.healt.cloud.checkup.queryReport.vo.UnitInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-26 16:23
 */
@Mapper
public interface UnitResultSearchMapper {

    List<UnitInfoVo> findUnitInfo(@Param("hospitalId") String hospitalId, @Param("unitId") String unitId);

    List<PersonListVo> findPersonListTotal(PersonTztListDictVo personTztListDictVo);

    List<PersonListVo> findPersonList(PersonTztListDictVo personTztListDictVo);
}
