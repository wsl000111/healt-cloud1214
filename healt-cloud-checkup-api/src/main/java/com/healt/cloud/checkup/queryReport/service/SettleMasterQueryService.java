package com.healt.cloud.checkup.queryReport.service;

import com.healt.cloud.checkup.queryReport.vo.SettleMasterQueryDictVo;
import com.healt.cloud.checkup.queryReport.vo.SettleMasterQueryNewVo;
import com.healt.cloud.checkup.queryReport.vo.SettleMasterQueryVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-31 9:28
 */
public interface SettleMasterQueryService {

    public List<SettleMasterQueryVo> findSettleMasterQuery(SettleMasterQueryDictVo settleMasterQueryDictVo);

    public List<SettleMasterQueryNewVo> findSettleMasterQueryNew(SettleMasterQueryDictVo settleMasterQueryDictVo);
}
