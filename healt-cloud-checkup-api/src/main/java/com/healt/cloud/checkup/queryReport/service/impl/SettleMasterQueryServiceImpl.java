package com.healt.cloud.checkup.queryReport.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.SettleMasterQueryMapper;
import com.healt.cloud.checkup.queryReport.service.SettleMasterQueryService;
import com.healt.cloud.checkup.queryReport.vo.SettleMasterQueryDictVo;
import com.healt.cloud.checkup.queryReport.vo.SettleMasterQueryNewVo;
import com.healt.cloud.checkup.queryReport.vo.SettleMasterQueryVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-31 9:28
 */
@Service
@AllArgsConstructor
public class SettleMasterQueryServiceImpl implements SettleMasterQueryService {

    private SettleMasterQueryMapper settleMasterQueryMapper;

    @Override
    public List<SettleMasterQueryVo> findSettleMasterQuery(SettleMasterQueryDictVo settleMasterQueryDictVo) {
        List<SettleMasterQueryVo> list = settleMasterQueryMapper.findSettleMasterQuery(settleMasterQueryDictVo);
        if (list.size() == 0) {
            list.add(new SettleMasterQueryVo());
        }
        return list;
    }

    @Override
    public List<SettleMasterQueryNewVo> findSettleMasterQueryNew(SettleMasterQueryDictVo settleMasterQueryDictVo) {
        List<SettleMasterQueryNewVo> list = settleMasterQueryMapper.findSettleMasterQueryNew(settleMasterQueryDictVo);
        if (list.size() == 0) {
            list.add(new SettleMasterQueryNewVo());
        }
        return list;
    }
}
