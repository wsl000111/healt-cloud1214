package com.healt.cloud.checkup.controller.businessDict;

import com.healt.cloud.checkup.controller.settlement.vo.UnitPersonSettlt;
import com.healt.cloud.checkup.entity.HcPackVsPrice;
import com.healt.cloud.checkup.service.business.MyHcPackVsPriceService;
import com.healt.cloud.checkup.vo.busniess.clinicPrice.HcPersonPriceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-07-14 16:05
 * @description: TODO
 */
@Api(tags = "组合项目vs诊疗项目vs价表项目")
@RestController
@RequestMapping("/packVsPrice")
public class HcPackVsPriceController {

    @Autowired
    private MyHcPackVsPriceService myHcPackVsPriceService;

    @ApiOperation("根据组合项目编码查询对照价表项目")
    @GetMapping("/findPackVsPriceList/{itemPackCode}/{hospitalId}")
    public List<HcPackVsPrice> findPackVsPriceList(@PathVariable String itemPackCode,
                                                   @PathVariable String hospitalId){
        return myHcPackVsPriceService.findPackVsPriceList(itemPackCode, hospitalId);
    }

    @ApiOperation("根据组合项目查询对照价表项目并保存")
    @GetMapping("/findAndSaveHcPackVsPrice/{hospitalId}/{itemPackCode}/{clinicItemCode}/{clinicItemName}")
    public void findAndSaveHcPackVsPrice(@PathVariable String hospitalId,
                                         @PathVariable String itemPackCode,
                                         @PathVariable String clinicItemCode,
                                         @PathVariable String clinicItemName){
        myHcPackVsPriceService.findAndSaveHcPackVsPrice(hospitalId, itemPackCode, clinicItemCode, clinicItemName);
    }

    @ApiOperation("查询单位体检人体检项目及价表信息")
    @GetMapping("/findHcPersonPriceByUnit/{hospitalId}/{unitId}/{unitVisitId}")
    public List<HcPersonPriceVo> findHcPersonPriceByUnit(@PathVariable String hospitalId,
                                        @PathVariable String unitId,
                                        @PathVariable String unitVisitId){
        return myHcPackVsPriceService.findHcPersonPriceByUnit(hospitalId, unitId, unitVisitId);
    }

    @ApiOperation("查询单位体检人体检项目及价表信息")
    @PostMapping("/findHcPersonPriceByUnitPerson")
    public List<HcPersonPriceVo> findHcPersonPriceByUnitPerson(@RequestBody UnitPersonSettlt unitPersonSettlt){
        return myHcPackVsPriceService.findHcPersonPriceByUnitPerson(unitPersonSettlt.getHospitalId(),
                unitPersonSettlt.getUnitId(), unitPersonSettlt.getUnitVisitId().toString(), unitPersonSettlt.getPersonIdStr());
    }

    @ApiOperation("查询个人体检体检项目及价表信息")
    @GetMapping("/findHcPersonPriceByPerson/{hospitalId}/{personId}/{personVisitId}")
    public List<HcPersonPriceVo> findHcPersonPriceByPerson(@PathVariable String hospitalId,
                                                           @PathVariable String personId,
                                                           @PathVariable String personVisitId){
        return myHcPackVsPriceService.findHcPersonPriceByPerson(hospitalId, personId, personVisitId);
    }

}
