package com.healt.cloud.checkup.controller.businessDict;

import com.healt.cloud.checkup.entity.CompanyCostBack;
import com.healt.cloud.checkup.service.business.HcCostDetailBillingService;
import com.healt.cloud.checkup.vo.companyCostCharge.CompanyCostChargeStateVoList;
import com.healt.cloud.checkup.vo.saveCostDetailReturn.SaveCostDetailReturnVo;
import com.healt.cloud.checkup.vo.busniess.costDetail.CostDetailBillingDictVo;
import com.healt.cloud.checkup.vo.busniess.costDetail.SaveCostDetailBillingListVo;
import com.healt.cloud.checkup.entity.CostDetailBilling;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-07-14 12:26
 * @description: TODO
 */

@Api(tags = "体检传HIS收费临时表")
@RestController
@RequestMapping("/costDetailBilling")
public class CostDetailBillingController {

    @Autowired
    private HcCostDetailBillingService hcCostDetailBillingService;

    @ApiOperation("查询体检传HIS收费临时表")
    @GetMapping("/findCostDetailBilling/{hospitalId}/{personId}/{/personVisitId}")
    public List<CostDetailBilling> findCostDetailBilling(@PathVariable String hospitalId,
                                                         @PathVariable String personId,
                                                         @PathVariable String personVisitId){
        return hcCostDetailBillingService.findCostDetailBilling(hospitalId, personId, personVisitId);
    }

    @ApiOperation("保存体检传HIS收费临时表")
    @PostMapping("/saveCostDetailBillingList")
    public void saveCostDetailBillingList(@RequestBody SaveCostDetailBillingListVo saveCostDetailBillingList){
        hcCostDetailBillingService.saveCostDetailBillingList(saveCostDetailBillingList);
    }

    @ApiOperation("查询体检传HIS收费临时表(过滤查询)")
    @PostMapping("/findCostDetailBillingFilter")
    public List<CostDetailBilling> findCostDetailBillingFilter(@RequestBody CostDetailBillingDictVo costDetailBillingDictVo){
        return hcCostDetailBillingService.findCostDetailBillingFilter(costDetailBillingDictVo);
    }

    @ApiOperation("退费,明细作废作为退费接口")
    @PostMapping("/saveCostDetailReturn")
    public void saveCostDetailReturn(@RequestBody SaveCostDetailReturnVo saveCostDetailReturnVo){
        hcCostDetailBillingService.saveCostDetailReturn(saveCostDetailReturnVo);
    }

    @ApiOperation("明细作废作接口")
    @PostMapping("/cancelCostDetailBillingList")
    public void cancelCostDetailBillingList(@RequestBody SaveCostDetailBillingListVo saveCostDetailBillingList){
        hcCostDetailBillingService.cancelCostDetailBillingList(saveCostDetailBillingList);
    }

    @ApiOperation("团检收费接口")
    @PostMapping("/companyCostBack")
    public void companyCostBack(@RequestBody CompanyCostChargeStateVoList companyCostChargeStateVoList){
        hcCostDetailBillingService.companyCostBack(companyCostChargeStateVoList);
    }

    @ApiOperation("查询单位收费状态")
    @GetMapping("/findCompanyCostBacks/{unitId}/{unitVisitId}/{canctype}")
    public List<CompanyCostBack> findCompanyCostBacks(@PathVariable String unitId,@PathVariable String unitVisitId,@PathVariable String canctype){
        return hcCostDetailBillingService.findCompanyCostBacks(unitId, unitVisitId, canctype);
    }
}
