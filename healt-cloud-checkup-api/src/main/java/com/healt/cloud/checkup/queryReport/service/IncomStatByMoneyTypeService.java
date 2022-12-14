package com.healt.cloud.checkup.queryReport.service;

import com.healt.cloud.checkup.queryReport.vo.MoneyTypeVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-31 17:18
 */
public interface IncomStatByMoneyTypeService {

    public List<MoneyTypeVo> findMoneyType(String beginDate, String endDate);
}
