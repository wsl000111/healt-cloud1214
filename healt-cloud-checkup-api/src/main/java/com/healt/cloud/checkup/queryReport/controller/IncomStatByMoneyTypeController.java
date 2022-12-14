package com.healt.cloud.checkup.queryReport.controller;

import com.healt.cloud.checkup.queryReport.service.IncomStatByMoneyTypeService;
import com.healt.cloud.checkup.queryReport.vo.MoneyTypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-31 17:17
 */
@RestController
@AllArgsConstructor
@Api(tags = "已结算支付方式统计接口API")
@RequestMapping("/incomStatByMoneyType")
public class IncomStatByMoneyTypeController {

    private IncomStatByMoneyTypeService incomStatByMoneyTypeService;

    /**
     * 已结算支付方式统计
     * @param beginDate,endDate
     * @return list
     */
    @ApiOperation(value = "已结算支付方式统计,原bSearch_ItemClick的select方法")
    @GetMapping("/findMoneyType/{beginDate}/{endDate}")
    public List<MoneyTypeVo> findMoneyType(@PathVariable String beginDate, @PathVariable String endDate){
        return incomStatByMoneyTypeService.findMoneyType(beginDate,endDate);
    }

}
