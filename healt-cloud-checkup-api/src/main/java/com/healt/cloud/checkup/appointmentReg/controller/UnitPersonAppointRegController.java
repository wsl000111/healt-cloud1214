package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.entity.HcPersonAppregItems;
import com.healt.cloud.checkup.entity.HcUnitGroup;
import com.healt.cloud.checkup.entity.HcUnitVisitInfo;
import com.healt.cloud.checkup.entity.VHcItemPackDict;
import com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg.*;
import com.healt.cloud.checkup.appointmentReg.service.UnitPersonAppointRegService;
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
@Api(tags = "单位人员预约接口API")
@RequestMapping("/appointment")
public class UnitPersonAppointRegController {

    private UnitPersonAppointRegService unitPersonAppointRegService;



    @ApiOperation(value = "全部单位体检次数，原GetDtUnitVisit（unitId）方法")
    @GetMapping("/findDtUnitVisit/{hospitalId}/{unitId}")
    public List<HcUnitVisitInfo> findDtUnitVisit(@PathVariable String hospitalId, @PathVariable String unitId){
        return unitPersonAppointRegService.findDtUnitVisit(hospitalId, unitId);
    }

    @ApiOperation(value = "某单位体检次数，原GetDtUnitVisit（unitId，visitId）方法")
    @GetMapping("/findDtUnitVisit2/{hospitalId}/{unitId}/{visitId}")
    public List<HcUnitVisitInfo> findDtUnitVisit2(@PathVariable String hospitalId, @PathVariable String unitId, @PathVariable String visitId){
        return unitPersonAppointRegService.findDtUnitVisit(hospitalId, unitId, visitId);
    }

    @ApiOperation(value = "原GetDtUnitGroup方法")
    @GetMapping("/findDtUnitGroup/{hospitalId}/{unitId}/{unitVisitId}")
    public List<HcUnitGroup> findDtUnitGroup(@PathVariable String hospitalId, @PathVariable String unitId, @PathVariable String unitVisitId){
        return unitPersonAppointRegService.findDtUnitGroup(hospitalId, unitId, unitVisitId);
    }

    @ApiOperation(value = "原GetDtUnitGroupItems方法，取组内项目")
    @GetMapping("/findDtUnitGroupItems/{hospitalId}/{unitId}/{unitVisitId}/{groupCode}")
    public List<DtUnitGroupItemsVo> findDtUnitGroupItems(@PathVariable String hospitalId, @PathVariable String unitId,
                                                         @PathVariable String unitVisitId, @PathVariable String groupCode){
        return unitPersonAppointRegService.findDtUnitGroupItems(hospitalId, unitId, unitVisitId, groupCode);
    }

    @ApiOperation(value = "原GetDtPersonItems方法")
    @GetMapping("/findDtPersonItems/{hospitalId}/{personId}/{personVisitId}")
    public List<HcPersonAppregItems> findDtPersonItems(@PathVariable String hospitalId, @PathVariable String personId, @PathVariable String personVisitId){
        return unitPersonAppointRegService.findDtPersonItems(hospitalId, personId, personVisitId);
    }

    @ApiOperation(value = "原FrmUnitPersonAppointReg中GetDtItemPack方法")
    @GetMapping("/findDtItemPackEffectiveFlag/{hospitalId}")
    public List<VHcItemPackDict> findDtItemPackEffectiveFlag(@PathVariable String hospitalId){
        return unitPersonAppointRegService.findDtItemPackEffectiveFlag(hospitalId);
    }

    @ApiOperation(value = "原GetDtUnitPersons方法")
    @GetMapping("/findDtUnitPersons/{hospitalId}/{unitId}")
    public List<HcPersonInfoVo> findDtUnitPersons(@PathVariable String hospitalId, @PathVariable String unitId){
        return unitPersonAppointRegService.findDtUnitPersons(hospitalId, unitId);
    }

    @ApiOperation(value = "当前个人体检次数, 原GetMaxPersonId方法")
    @GetMapping("/findMaxPersonVisitId/{hospitalId}/{personId}")
    public Integer findMaxPersonVisitId(@PathVariable String hospitalId, @PathVariable String personId){
        return unitPersonAppointRegService.findMaxPersonVisitId(hospitalId, personId);
    }

    @ApiOperation(value = "原GetDtUnitPersonsVisit方法")
    @GetMapping("/findDtUnitPersonsVisit/{hospitalId}/{unitId}/{visitId}")
    public List<DtUnitPersonsVisitVo> findDtUnitPersonsVisit(@PathVariable String hospitalId, @PathVariable String unitId, @PathVariable String visitId){
        return unitPersonAppointRegService.findDtUnitPersonsVisit(hospitalId, unitId, visitId);
    }

    @ApiOperation(value = "原GetSetSex方法， 查询套餐性别限制")
    @GetMapping("/findSetSex/{hospitalId}/{setName}")
    public String findSetSex(@PathVariable String hospitalId, @PathVariable String setName){
        return unitPersonAppointRegService.findSetSex(hospitalId, setName);
    }

    @ApiOperation(value = "批量增加项目，btnBatchAdd_ItemClick方法")
    @PostMapping("/batchAddItems")
    public void batchAddItems(@RequestBody BatchAddItemsVo batchAddItems){
        unitPersonAppointRegService.batchAddItems(batchAddItems);
    }

    @ApiOperation(value = "判断项目删除数量，项目数量超过1，是否全部删除，是，全部删除，否，删除序号最大的")
    @PostMapping("/selectBatchDelItems")
    public List<BatchUnitPersonsDeleteItemsVo> selectBatchDelItems(@RequestBody SelectBatchDelItemsListVo selectBatchDelItemsListVo){
        return unitPersonAppointRegService.selectBatchDelItems(selectBatchDelItemsListVo);
    }

    @ApiOperation(value = "批量删除项目，btnBatchDel_ItemClick方法")
    @PostMapping("/batchUnitPersonsDeleteItems")
    public void batchUnitPersonsDeleteItems(@RequestBody BatchUnitPersonsDeleteItemsListVo batchUnitPersonsDeleteItemsListVo){
        unitPersonAppointRegService.batchUnitPersonsDeleteItems(batchUnitPersonsDeleteItemsListVo);
    }

}
