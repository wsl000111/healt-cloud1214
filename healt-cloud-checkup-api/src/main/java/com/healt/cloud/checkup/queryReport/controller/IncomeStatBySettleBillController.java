package com.healt.cloud.checkup.queryReport.controller;

import com.healt.cloud.checkup.queryReport.service.IncomeStatBySettleBillService;
import com.healt.cloud.checkup.queryReport.vo.SettleBillDictVo;
import com.healt.cloud.checkup.queryReport.vo.SettleBillVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
@author linklee
@create 2022-06-02 16:34
*/
@RestController
@AllArgsConstructor
@Api(tags = "已结算费用分类统计接口API")
@RequestMapping("/incomStatBySettleBill")
public class IncomeStatBySettleBillController {

    private IncomeStatBySettleBillService incomeStatBySettleBillService;

    /**
     * 已结算费用分类统计
     * @param settleBillDictVo
     * @return list
     */
    @ApiOperation(value = "已结算费用分类统计,原sBperson_Click的select方法")
    @PostMapping("/findSettleBill")
    public List<SettleBillVo> findSettleBill(@RequestBody SettleBillDictVo settleBillDictVo){
        return incomeStatBySettleBillService.findSettleBill(settleBillDictVo);
    }
}
