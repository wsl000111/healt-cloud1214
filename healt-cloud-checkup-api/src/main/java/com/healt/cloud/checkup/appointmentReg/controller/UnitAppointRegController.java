package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.entity.HcUnitInfo;
import com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg.*;
import com.healt.cloud.checkup.appointmentReg.service.UnitAppointRegService;
import com.healt.cloud.checkup.appointmentReg.service.UnitDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-07 23:46
 * @description: TODO
 */
@RestController
@AllArgsConstructor
@Api(tags = "单位预约接口API")
@RequestMapping("/appointment")
public class UnitAppointRegController {

    private UnitDictService unitDictService;

    private UnitAppointRegService unitAppointRegService;

    @ApiOperation(value = "原findDtPackClass方法")
    @GetMapping("/findDtPackClass/{hospitalId}")
    public List<DtPackClassVo> findDtPackClass(@PathVariable String hospitalId){
        return unitAppointRegService.findDtPackClass(hospitalId);
    }

    @ApiOperation(value = "原GetDtPackItems方法，EFFECTIVE_FLAG = '1'")
    @GetMapping("/findDtPackItems/{hospitalId}")
    public List<DtPackItemsVo> findDtPackItems(@PathVariable String hospitalId){
        return unitAppointRegService.findDtPackItems(hospitalId);
    }

    @ApiOperation(value = "GetDtSets方法，EFFECTIVE_FLAG=1")
    @GetMapping("/findDtSets/{hospitalId}")
    public List<DtSetsVo> findDtSets(@PathVariable String hospitalId){
        return unitAppointRegService.findDtSets(hospitalId);
    }

    @ApiOperation(value = "GetDtUNIT_TYPE方法，USE_FLAG='1'")
    @GetMapping("/findDtUnitType/{hospitalId}")
    public List<DtUnitTypeVo> findDtUnitType(@PathVariable String hospitalId){
        return unitAppointRegService.findDtUnitType(hospitalId);
    }

    @ApiOperation(value = "GetDtParentUnit方法，unit_id<>'0000'")
    @GetMapping("/findDtParentUnit/{hospitalId}")
    public List<DtParentUnitVo> findDtParentUnit(@PathVariable String hospitalId){
        return unitAppointRegService.findDtParentUnit(hospitalId);
    }

    @ApiOperation(value = "页面文件FrmUnitAppointReg.GetDtUnitGroupItems方法，因为与FrmUnitPersonAppointReg.GetDtUnitGroupItems方法名相同，但sql语句不同，所以名称加2")
    @GetMapping("/findDtUnitGroupItems2/{hospitalId}/{unitId}/{unitVisitId}")
    public List<DtUnitGroupItemsVo2> findDtUnitGroupItems2(@PathVariable String hospitalId, @PathVariable String unitId, @PathVariable String unitVisitId){
        return unitAppointRegService.findDtUnitGroupItems2(hospitalId, unitId, unitVisitId);
    }

    @ApiOperation(value = "原GetDtUnit方法，获取所有单位信息，排除unit_id<>0000")
    @GetMapping("/findDtUnit/{hospitalId}")
    public List<HcUnitInfo> findDtUnit(@PathVariable String hospitalId){
        return unitDictService.findDtUnit(hospitalId);
    }

    @ApiOperation(value = "查询参加体检的人的数量, GetPatCount方法")
    @GetMapping("/findPatCount/{hospitalId}/{unitId}/{visitId}")
    public Integer findPatCount(@PathVariable String hospitalId, @PathVariable String unitId, @PathVariable String visitId){
        return unitAppointRegService.findPatCount(hospitalId, unitId, visitId);
    }

    @ApiOperation(value = "原GetNewUnitId方法")
    @GetMapping("/GetNewUnitId")
    public String findNewUnitId(){
        return unitAppointRegService.findNewUnitId();
    }

    @ApiOperation(value = "查询单位最大体检次数，GetMaxVisitId方法")
    @GetMapping("/findMaxVisitId/{hospitalId}/{unitId}")
    public Integer findMaxVisitId(@PathVariable String hospitalId, @PathVariable String unitId){
        return unitAppointRegService.findMaxVisitId(hospitalId, unitId);
    }

    @ApiOperation(value = "查询单位体检完成标志，Is_Finished_Sign方法")
    @GetMapping("/findFinishedSign/{hospitalId}/{unitId}/{visitId}")
    public Integer findFinishedSign(@PathVariable String hospitalId, @PathVariable String unitId, @PathVariable String visitId){
        return unitAppointRegService.findFinishedSign(hospitalId, unitId, visitId);
    }

    @ApiOperation(value = "获取套餐组合, FrmUnitAppointReg.GetSetPacks方法")
    @GetMapping("/findSetPacks/{hospitalId}/{setCode}")
    public List<SetPacksVo> findSetPacks(@PathVariable String hospitalId, @PathVariable String setCode){
        return unitAppointRegService.findSetPacks(hospitalId, setCode);
    }

    @ApiOperation(value = "保存按钮方法")
    @PostMapping("/saveHcUnitGroupList")
    public void saveHcUnitGroupList(@RequestBody SaveHcUnitGroupListVo saveHcUnitGroupListVo){
        unitAppointRegService.saveHcUnitGroupList(saveHcUnitGroupListVo);
    }

    @ApiOperation(value = "预约体检方法，新增，删除")
    @PostMapping("/saveHcUnitVisitGroupList")
    public void saveHcUnitVisitGroupList(@RequestBody SaveHcUnitVisitGroupListVo saveHcUnitVisitGroupListVo){
        unitAppointRegService.saveHcUnitVisitGroupList(saveHcUnitVisitGroupListVo);
    }

    @ApiOperation(value = "删除预约")
    @PostMapping("/deleteHcUnitVisitGroupList")
    public void deleteHcUnitVisitGroupList(@RequestBody SaveHcUnitVisitGroupListVo saveHcUnitVisitGroupListVo){
        unitAppointRegService.deleteHcUnitVisitGroupList(saveHcUnitVisitGroupListVo);
    }
}
