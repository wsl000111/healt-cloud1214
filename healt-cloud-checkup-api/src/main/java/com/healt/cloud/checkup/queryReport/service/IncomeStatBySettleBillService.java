package com.healt.cloud.checkup.queryReport.service;

import com.healt.cloud.checkup.queryReport.vo.SettleBillDictVo;
import com.healt.cloud.checkup.queryReport.vo.SettleBillVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-02 16:48
 */
public interface IncomeStatBySettleBillService {

    public List<SettleBillVo> findSettleBill(SettleBillDictVo settleBillDictVo);
}
