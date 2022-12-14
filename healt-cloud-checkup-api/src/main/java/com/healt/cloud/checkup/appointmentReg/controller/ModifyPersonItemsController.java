package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.appointmentReg.service.PersonAppointRegService;
import com.healt.cloud.checkup.vo.appointmentReg.modifyPersonItems.*;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.*;
import com.healt.cloud.checkup.appointmentReg.service.ModifyPersonItemsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-15 14:27
 */
@RestController
@AllArgsConstructor
@Api(tags = "个人预约项目修改接口API")
@RequestMapping("/modifyPersonItems")
public class ModifyPersonItemsController {

    private ModifyPersonItemsService modifyPersonItemsService;

    private PersonAppointRegService personAppointRegService;

    /**
     * 取套餐
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "取套餐，原GetPackSetDict方法")
    @GetMapping("/findPackSetDict/{hospitalId}")
    public List<PackSetDictVo> findPackSetDict(@PathVariable("hospitalId") String hospitalId){
        return personAppointRegService.findPackSetDict(hospitalId);
    }

    /**
     * 取项目组合
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "取项目组合，原GetPackItemDict方法")
    @GetMapping("/findPackItemDict/{hospitalId}")
    public List<PackItemDictVo> findPackItemDict(@PathVariable("hospitalId") String hospitalId){
        return personAppointRegService.findPackItemDict(hospitalId);
    }

    /**
     * 取套餐中的项目 setCode 需要组合成符合in的字符串不包括括号
     * @param hospitalId,setCode
     * @return list
     */
    @ApiOperation(value = "取套餐中的项目，原GetSetItemList方法")
    @GetMapping("/findSetItemList/{hospitalId}/{setCode}")
    public List<SetItemListVo> findSetItemList(@PathVariable("hospitalId") String hospitalId, @PathVariable("setCode") String setCode){
        return personAppointRegService.findSetItemList(hospitalId,setCode);
    }

    /**
     * 取套餐中的项目 setCode 需要组合成符合in的字符串不包括括号
     * @param hospitalId,setCode
     * @return list
     */
    @ApiOperation(value = "取套餐中的项目，原GetSetItemList方法")
    @GetMapping("/findSetItemListWeb/{hospitalId}/{setCode}")
    public List<SetItemListVo> findSetItemListWeb(@PathVariable("hospitalId") String hospitalId, @PathVariable("setCode") String setCode){
        return personAppointRegService.findSetItemListWeb(hospitalId,setCode);
    }

    /**
     * 取已选项目组合结构
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "取已选项目组合结构，原GetSelectedItems方法")
    @GetMapping("/findModifySelectedItems/{hospitalId}/{personId}/{personVisitId}")
    public List<ModifySelectedItemsVo> findModifySelectedItems(@PathVariable("hospitalId") String hospitalId,
                                                               @PathVariable("personId") String personId,
                                                               @PathVariable("personVisitId") Integer personVisitId){
        return modifyPersonItemsService.findModifySelectedItems(hospitalId,personId,personVisitId);
    }

    /**
     * 取已选套餐
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "取已选套餐，原GetSelectedPackSet方法")
    @GetMapping("/findSelectedPackSetVo/{hospitalId}/{personId}/{personVisitId}")
    public List<SelectedPackSetVo> findSelectedPackSetVo(@PathVariable("hospitalId") String hospitalId,
                                                         @PathVariable("personId") String personId,
                                                         @PathVariable("personVisitId") Integer personVisitId){
        return modifyPersonItemsService.findSelectedPackSetVo(hospitalId,personId,personVisitId);
    }

    /**
     * 取费别及类别数据
     * @param dictType
     * @return list
     */
    @ApiOperation(value = "取费别及类别数据，原SetDataSource方法")
    @GetMapping("/findPublicDict/{dictType}")
    public List<PublicDictVo> findPublicDict(@PathVariable("dictType") String dictType){
        return modifyPersonItemsService.findPublicDict(dictType);
    }

    /**
     * 取单位信息
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "取单位信息，原GetUnitList方法")
    @GetMapping("/findUnitList/{hospitalId}")
    public List<UnitListVo> findUnitList(@PathVariable("hospitalId") String hospitalId){
        return personAppointRegService.findUnitList(hospitalId);
    }

    /**
     * 先判断是否预约，再判断是否体检完成，体检未完成取人员信息
     * @param hospitalId,unitId
     * @return list
     */
    @ApiOperation(value = "先判断是否预约，再判断是否体检完成，体检未完成取人员信息，原GetUnitPersons方法")
    @GetMapping("/findUnitPersons/{hospitalId}/{unitId}")
    public List<UnitPersonsVo> findUnitPersons(@PathVariable("hospitalId") String hospitalId,
                                               @PathVariable("unitId") String unitId){
        return modifyPersonItemsService.findUnitPersons(hospitalId,unitId);
    }

    @ApiOperation(value = "取体检次数判断是否完成,抛出提示信息,条件都不满足则返回查询值,原InspectDataAndGetItems第一个select方法")
    @GetMapping("/findModifyPersonVisitInfoVo/{hospitalId}/{personId}")
    public List<ModifyPersonVisitInfoVo> findModifyPersonVisitInfoVo(@PathVariable("hospitalId") String hospitalId,
                                                                     @PathVariable("personId") String personId){
        return modifyPersonItemsService.findModifyPersonVisitInfoVo(hospitalId,personId);
    }

    @ApiOperation(value = "")
    @GetMapping("/findModifyPersonVisitInfoVoTwo/{hospitalId}/{personId}/{personVisitId}")
    public List<ModifyPersonVisitInfoVo> findModifyPersonVisitInfoVoTwo(@PathVariable("hospitalId") String hospitalId,
                                                                     @PathVariable("personId") String personId,
                                                                     @PathVariable("personVisitId") String personVisitId){
        return modifyPersonItemsService.findModifyPersonVisitInfoVoTwo(hospitalId, personId, personVisitId);
    }


    @ApiOperation(value = "取基本信息，原InspectDataAndGetItems第二个select方法")
    @GetMapping("/findPersonInfo/{hospitalId}/{personId}")
    public List<PersonInfoVo> findPersonInfo(@PathVariable("hospitalId") String hospitalId,
                                             @PathVariable("personId") String personId){
        return personAppointRegService.findPersonInfo(hospitalId,personId);
    }

    /**
     * 根据组合编码取组合类别
     * @param hospitalId,itemPackCode
     * @return list
     */
    @ApiOperation(value = "根据组合编码取组合类别，原GetItemClass方法")
    @GetMapping("/findItemClass/{hospitalId}/{itemPackCode}")
    public String findItemClass(@PathVariable("hospitalId") String hospitalId,
                                          @PathVariable("itemPackCode") String itemPackCode){
        return modifyPersonItemsService.findItemClass(hospitalId,itemPackCode);
    }

//    /**
//     * 取申请号
//     * @param itemPackCode
//     * @return string
//     */
//    @ApiOperation(value = "取申请号，原barLargeButtonItem2_ItemClick方法")
//    @GetMapping("/findApplySendto/{itemPackCode}")
//    public String findApplySendto(@PathVariable("itemPackCode") String itemPackCode) {
//        return modifyPersonItemsService.findApplySendto(itemPackCode);
//    }

    @ApiOperation(value = "保存")
    @PostMapping("/saveModifyPersonItemList")
    public String saveModifyPersonItemList(@RequestBody SaveModifyPersonItemsListVo saveModifyPersonItemsListVo){
        return modifyPersonItemsService.saveModifyPersonItemList(saveModifyPersonItemsListVo);
    }

}
