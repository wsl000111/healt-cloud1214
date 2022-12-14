package com.healt.cloud.checkup.queryReport.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.IncomStatByMoneyTypeMapper;
import com.healt.cloud.checkup.queryReport.service.IncomStatByMoneyTypeService;
import com.healt.cloud.checkup.queryReport.vo.MoneyTypeVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-31 17:18
 */
@Service
@AllArgsConstructor
public class IncomStatByMoneyTypeServiceImpl implements IncomStatByMoneyTypeService {

    private IncomStatByMoneyTypeMapper incomStatByMoneyTypeMapper;

    @Override
    public List<MoneyTypeVo> findMoneyType(String beginDate, String endDate) {
        List<MoneyTypeVo> list = incomStatByMoneyTypeMapper.findMoneyType(beginDate,endDate);
        if (list.size() == 0) {
            list.add(new MoneyTypeVo());
        }
        return list;
    }
}
