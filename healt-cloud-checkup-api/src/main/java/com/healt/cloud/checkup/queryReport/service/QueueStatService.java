package com.healt.cloud.checkup.queryReport.service;

import com.healt.cloud.checkup.queryReport.vo.StrWherePageVo;
import com.healt.cloud.common.pages.PageResult;

import java.math.BigDecimal;

/**
 * @author linklee
 * @create 2022-05-26 13:50
 */
public interface QueueStatService {

    public PageResult findPersonList(StrWherePageVo strWherePageVo);

    public PageResult findSumItems(StrWherePageVo strWherePageVo);

    BigDecimal findSumCharges(StrWherePageVo strWherePageVo);

    BigDecimal findSumChargesNew(StrWherePageVo strWherePageVo);
}
