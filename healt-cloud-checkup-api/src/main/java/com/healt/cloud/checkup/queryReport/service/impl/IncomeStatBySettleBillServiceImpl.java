package com.healt.cloud.checkup.queryReport.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.IncomeStatBySettleBillMapper;
import com.healt.cloud.checkup.queryReport.service.IncomeStatBySettleBillService;
import com.healt.cloud.checkup.queryReport.vo.SettleBillDictVo;
import com.healt.cloud.checkup.queryReport.vo.SettleBillVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-02 16:48
 */
@Service
@AllArgsConstructor
public class IncomeStatBySettleBillServiceImpl implements IncomeStatBySettleBillService {

    private IncomeStatBySettleBillMapper incomeStatBySettleBillMapper;

    @Override
    public List<SettleBillVo> findSettleBill(SettleBillDictVo settleBillDictVo) {
        List<SettleBillVo> list = incomeStatBySettleBillMapper.findSettleBill(settleBillDictVo);
        if (list.size() == 0) {
            list.add(new SettleBillVo());
        }
        return list;
    }
}
