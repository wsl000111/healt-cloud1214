package com.healt.cloud.checkup.queryReport.service;

import com.healt.cloud.checkup.vo.appointmentReg.unitPersons.DtUnitVo;
import com.healt.cloud.checkup.queryReport.vo.DtUnitDictVo;
import com.healt.cloud.checkup.queryReport.vo.UnitQueryDictVo;
import com.healt.cloud.checkup.queryReport.vo.UnitQueryVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-19 13:50
 */
public interface UnitQueryService {

    public List<DtUnitVo> findDtUnit(DtUnitDictVo dtUnitDictVo);

    public List<UnitQueryVo> findUnitQuery(UnitQueryDictVo unitQueryDictVo);

}
