package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.appointmentReg.service.PersonAppointRegService;
import com.healt.cloud.checkup.appointmentReg.vo.mobile.SavePersonAppointVo;
import com.healt.cloud.checkup.entity.ItemPackClassDict;
import com.healt.cloud.checkup.appointmentReg.vo.mobile.PersonAppointVo;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.*;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.vo.SaveHcPersonVisitInfoListVo;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-03-29 17:00
 */

@RestController
@AllArgsConstructor
@Api(tags = "个人预约接口API")
@RequestMapping("/personAppoint")
public class PersonAppointRegController {

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

    @ApiOperation(value = "分页查询套餐集合")
    @PostMapping("/findPackSetDictPage")
    public PageResult findPackSetDictPage(@RequestBody PersonAppointVo personAppointVo){
        return personAppointRegService.findPackSetDictPage(personAppointVo);
    }

    @ApiOperation(value = "分页查询组合集合")
    @PostMapping("/loadPackItemListPage")
    public PageResult loadPackItemListPage(@RequestBody PersonAppointVo personAppointVo){
        return personAppointRegService.loadPackItemListPage(personAppointVo);
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
     * 取已选项目组合结构
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "取已选项目组合结构，原GetSelectedItems方法")
    @GetMapping("/findSelectedItems/{hospitalId}/{personId}/{personVisitId}")
    public List<SelectedItemsVo> findSelectedItems(@PathVariable("hospitalId") String hospitalId,
                                                   @PathVariable("personId") String personId,
                                                   @PathVariable("personVisitId") Integer personVisitId){
        return personAppointRegService.findSelectedItems(hospitalId,personId,personVisitId);
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
     * 先判断是否预约，再判断是否体检完成，体检未完成取分组信息
     * @param hospitalId,unitId
     * @return list
     */
    @ApiOperation(value = "先判断是否预约，再判断是否体检完成，体检未完成取分组信息，原GetUnitGroup方法")
    @GetMapping("/findUnitGroup/{hospitalId}/{unitId}")
    public List<UnitGroupVo> findUnitGroup(@PathVariable("hospitalId") String hospitalId,
                                            @PathVariable("unitId") String unitId){
        return personAppointRegService.findUnitGroup(hospitalId,unitId);
    }

    /**
    @ApiOperation(value = "取体检次数 判断是否完成：未完成改成完成标志finished_sign = '1'同时visitId+1，完成则visitId+1，空值则取基本信息,visitId=1")
    @GetMapping("/finishedSignFlag/{hospitalId}/{personId}")
    public List<PersonInfoVo> finishedSignFlag(@PathVariable("hospitalId") String hospitalId,
                                                @PathVariable("personId") String personId){
        return personAppointRegService.finishedSignFlag(hospitalId,personId);
    }
     */

    @ApiOperation(value = "取体检次数,原tePersonId_KeyDown第一个select方法")
    @GetMapping("/findPersonVisitInfo/{hospitalId}/{personId}")
    public List<PersonVisitInfoVo> findPersonVisitInfo(@PathVariable("hospitalId") String hospitalId,
                                                       @PathVariable("personId") String personId){
        return personAppointRegService.findPersonVisitInfo(hospitalId,personId);
    }

    @ApiOperation(value = "取基本信息，原tePersonId_KeyDown第二个select方法")
    @GetMapping("/findPersonInfo/{hospitalId}/{personId}")
    public List<PersonInfoVo> findPersonInfo(@PathVariable("hospitalId") String hospitalId,
                                             @PathVariable("personId") String personId){
        return personAppointRegService.findPersonInfo(hospitalId,personId);
    }

    @ApiOperation(value = "将hc_person_visit_info表完成标志打上，原tePersonId_KeyDown的update方法")
    @GetMapping("/updateFinishedSign/{hospitalId}/{personId}/{personVisitId}")
    public void updateFinishedSign(@PathVariable("hospitalId") String hospitalId,
                                              @PathVariable("personId") String personId,@PathVariable("personVisitId") Integer personVisitId){
        personAppointRegService.updateFinishedSign(hospitalId,personId,personVisitId);
    }

    /**
     * 取分组信息
     * @param hospitalId,groupCode,unitId,unitVisitId
     * @return list
     */
    @ApiOperation(value = "取分组信息，原bEItemGroup_EditValueChanged方法")
    @GetMapping("/findItemsByGroup/{hospitalId}/{groupCode}/{unitId}/{unitVisitId}")
    public List<UnitGroupListVo> findItemsByGroup(@PathVariable("hospitalId") String hospitalId, @PathVariable("groupCode") String groupCode,
                                                  @PathVariable("unitId") String unitId, @PathVariable("unitVisitId") Integer unitVisitId){
        return personAppointRegService.findItemsByGroup(hospitalId,groupCode,unitId,unitVisitId);
    }

    /**
     * 写入体检次数表
     * @param saveHcPersonVisitInfoList
     * @return null
     */
    @ApiOperation(value = "写入体检次数表,原barLargeButtonItem2_ItemClick方法")
    @PostMapping("/savePersonVisitInfo")
    public void savePersonVisitInfo(@RequestBody SaveHcPersonVisitInfoListVo saveHcPersonVisitInfoList){
        personAppointRegService.savePersonVisitInfo(saveHcPersonVisitInfoList);
    }

    /**
     * 更新hc_person_appreg_items的apply_no_print值为1
     * @param hospitalId,applyNo
     * @return null
     */
    @ApiOperation(value = "更新hc_person_appreg_items的apply_no_print值为1 ")
    @GetMapping("/updateApplyNoPrint/{hospitalId}/{applyNo}")
    public void updateApplyNoPrint(@PathVariable("hospitalId") String hospitalId,
                                   @PathVariable("applyNo") String applyNo){
        personAppointRegService.updateApplyNoPrint(hospitalId,applyNo);
    }

    @ApiOperation(value = "查询项目组合类别字典")
    @GetMapping("/findItemPackClassList/{hospitalId}")
    public List<ItemPackClassDict> findItemPackClassList(@PathVariable("hospitalId") String hospitalId){
        return personAppointRegService.findItemPackClassList(hospitalId);
    }

    @ApiOperation(value = "个人预约Web")
    @PostMapping("/savePersonAppoint")
    public String savePersonAppoint(@RequestBody SavePersonAppointVo savePersonAppointVo){
//        return personAppointRegService.savePersonAppoint(savePersonAppointVo);
        return "ok";
    }
}
