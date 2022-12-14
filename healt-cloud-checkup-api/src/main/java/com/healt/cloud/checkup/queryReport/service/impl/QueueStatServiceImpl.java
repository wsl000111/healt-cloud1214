package com.healt.cloud.checkup.queryReport.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.QueueStatMapper;
import com.healt.cloud.checkup.queryReport.service.QueueStatService;
import com.healt.cloud.checkup.queryReport.vo.PersonListVo;
import com.healt.cloud.checkup.queryReport.vo.StrWherePageVo;
import com.healt.cloud.checkup.queryReport.vo.SumItemsVo;
import com.healt.cloud.common.pages.PageResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-26 13:51
 */
@Service
@AllArgsConstructor
public class QueueStatServiceImpl implements QueueStatService {

    private QueueStatMapper queueStatMapper;

    @Override
    public PageResult findPersonList(StrWherePageVo strWherePageVo) {
//        List<PersonListVo> listTotal = queueStatMapper.findPersonListTotal(strWherePageVo);
//        int totalSize = listTotal.size();

        List<PersonListVo> list = queueStatMapper.findPersonList(strWherePageVo);
        if (list.size() == 0) {
            list.add(new PersonListVo());
        }
        //int totalPages = totalSize%strWherePageVo.getPageSize() == 0 ? totalSize / strWherePageVo.getPageSize() : totalSize / strWherePageVo.getPageSize() + 1;
        PageResult result = new PageResult<PersonListVo>(strWherePageVo.getPageNum(), strWherePageVo.getPageSize(), list.size(), 1, list);
        return result;
    }

    @Override
    public PageResult findSumItems(StrWherePageVo strWherePageVo) {
        List<SumItemsVo> listTotal = queueStatMapper.findSumItemsTotal(strWherePageVo);
        int totalSize = listTotal.size();

        List<SumItemsVo> list = queueStatMapper.findSumItems(strWherePageVo);
        if (list.size() == 0) {
            list.add(new SumItemsVo());
        }
        int totalPages = totalSize%strWherePageVo.getPageSize() == 0 ? totalSize / strWherePageVo.getPageSize() : totalSize / strWherePageVo.getPageSize() + 1;
        PageResult result = new PageResult<SumItemsVo>(strWherePageVo.getPageNum(), strWherePageVo.getPageSize(), totalSize, totalPages, list);
        return result;
    }

    @Override
    public BigDecimal findSumCharges(StrWherePageVo strWherePageVo) {
        String moneyStr = queueStatMapper.findSumCharges(strWherePageVo);
        BigDecimal money;
        if (moneyStr == null) {
            money = new BigDecimal(0);
        }else{
            money = new BigDecimal(moneyStr);
        }
        return money;
    }

    @Override
    public BigDecimal findSumChargesNew(StrWherePageVo strWherePageVo) {
        String moneyStr = queueStatMapper.findSumChargesNew(strWherePageVo);
        BigDecimal money;
        if (moneyStr == null) {
            money = new BigDecimal(0);
        }else{
            money = new BigDecimal(moneyStr);
        }
        return money;
    }
}
