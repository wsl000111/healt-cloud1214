package com.healt.cloud.checkup.queryReport.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.UnitQueryMapper;
import com.healt.cloud.checkup.queryReport.service.UnitQueryService;
import com.healt.cloud.checkup.vo.appointmentReg.unitPersons.DtUnitVo;
import com.healt.cloud.checkup.queryReport.vo.DtUnitDictVo;
import com.healt.cloud.checkup.queryReport.vo.UnitQueryDictVo;
import com.healt.cloud.checkup.queryReport.vo.UnitQueryVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-19 13:50
 */
@Service
@AllArgsConstructor
public class UnitQueryServiceImpl implements UnitQueryService {

    private UnitQueryMapper unitQueryMapper;

    @Override
    public List<DtUnitVo> findDtUnit(DtUnitDictVo dtUnitDictVo) {
        List<DtUnitVo> list = unitQueryMapper.findDtUnit(dtUnitDictVo.getHospitalId(),dtUnitDictVo.getUnitId());
        if (list.size() == 0) {
            list.add(new DtUnitVo());
        }
        return list;
    }

    @Override
    public List<UnitQueryVo> findUnitQuery(UnitQueryDictVo unitQueryDictVo) {
        List<UnitQueryVo> list = unitQueryMapper.findUnitQuery(unitQueryDictVo);
        if (list.size() == 0) {
            list.add(new UnitQueryVo());
        }
        return list;
    }

}
