package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.entity.HcUnitInfo;
import com.healt.cloud.checkup.vo.appointmentReg.hcUintDict.SaveHcUnitDictListVo;
import com.healt.cloud.checkup.appointmentReg.service.UnitDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-22 8:53
 * @description: TODO
 */
@RestController
@AllArgsConstructor
@Api(tags = "单位信息接口API")
@RequestMapping("/appointment")
public class UnitDictController {

    private UnitDictService unitDictService;

    @ApiOperation(value = "取单位列表, GetUnitList方法")
    @GetMapping("/findUnitList/{hospitalCode}")
    public List<HcUnitInfo> findUnitList(@PathVariable String hospitalCode){
        return unitDictService.findUnitList(hospitalCode);
    }

//    @ApiOperation(value = "原GetDtUnit方法，查询某单位信息")
//    @GetMapping("/findDtUnit2/{hospitalId}/{unitId}")
//    public List<HcUnitInfo> findDtUnit2(@PathVariable String hospitalId, @PathVariable String unitId){
//        return unitDictService.findDtUnit(hospitalId, unitId);
//    }

    @PostMapping("/saveUnitDictList")
    public void saveUnitDictList(@RequestBody SaveHcUnitDictListVo saveHcUnitDictListVo){
        unitDictService.saveUnitDictList(saveHcUnitDictListVo);
    }
}
