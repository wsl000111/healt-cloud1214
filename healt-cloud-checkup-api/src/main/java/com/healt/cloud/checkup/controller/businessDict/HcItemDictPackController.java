package com.healt.cloud.checkup.controller.businessDict;

import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.vo.HospitalVo;
import com.healt.cloud.checkup.vo.busniess.itemPack.*;
import com.healt.cloud.checkup.service.business.ItemDictPackService;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-11 9:25
 * @description: 组合设置
 */
@RestController
@AllArgsConstructor
@Api(tags = "组合设置接口API")
@RequestMapping("/business")
public class HcItemDictPackController {

    private ItemDictPackService itemDictPackService;

    @PostMapping("/findDtItemPack")
    public List<HcItemPackDict> findDtItemPack(@RequestBody HcItemPackDictVo hcItemPackDictVo){
        return itemDictPackService.findDtItemPack(hcItemPackDictVo);
    }

    @PostMapping("/findDtItemPackPage")
    public PageResult<HcItemPackDict> findDtItemPackPage(@RequestBody HcItemPackDictVo hcItemPackDictVo){
        return itemDictPackService.findDtItemPackPage(hcItemPackDictVo);
    }

    @PostMapping("/findtDtPackVsItem")
    public List<HcPackVsItemDictVoResult> findtDtPackVsItem(@RequestBody HcPackVsItemDictVo hcPackVsItemDictVo){
        return itemDictPackService.findtDtPackVsItem(hcPackVsItemDictVo);
    }

    @PostMapping("/findDtExamClassDict")
    public List<VExamClassDict> findDtExamClassDict(@RequestBody HospitalVo hospitalVo){
        return itemDictPackService.findDtExamClassDict(hospitalVo);
    }

    @PostMapping("/findDtExamSubClassDict")
    public List<VExamSubclassDict> findDtExamSubClassDict(@RequestBody HospitalVo hospitalVo){
        return itemDictPackService.findDtExamSubClassDict(hospitalVo);
    }

    @PostMapping("/findDtPackClass")
    public List<VItemPackClassDict> findDtPackClass(@RequestBody HospitalVo hospitalVo){
        return itemDictPackService.findDtPackClass(hospitalVo);
    }

    @PostMapping("/findDtGuideGroup")
    public List<VPackGuidegroupDict> findDtGuideGroup(@RequestBody HospitalVo hospitalVo){
        return itemDictPackService.findDtGuideGroup(hospitalVo);
    }

    @PostMapping("/findDtTestTube")
    public List<VTestTubeDict> findDtTestTube(@RequestBody HospitalVo hospitalVo){
        return itemDictPackService.findDtTestTube(hospitalVo);
    }

    @PostMapping("/findDtSpecimanName")
    public List<VPackSpecimanDict> findDtSpecimanName(@RequestBody HospitalVo hospitalVo){
        return itemDictPackService.findDtSpecimanName(hospitalVo);
    }

    @PostMapping("/findDtCostClassDict")
    public List<VCostclassDict> findDtCostClassDict(@RequestBody HospitalVo hospitalVo){
        return itemDictPackService.findDtCostClassDict(hospitalVo);
    }

    @PostMapping("/findDtResultHandle")
    public List<VResultHandleDict> findDtResultHandle(@RequestBody HospitalVo hospitalVo){
        return itemDictPackService.findDtResultHandle(hospitalVo);
    }

    @PostMapping("/findDtInterfaceSource")
    public List<VInterfaceSource> findDtInterfaceSource(@RequestBody HospitalVo hospitalVo){
        return itemDictPackService.findDtInterfaceSource(hospitalVo);
    }

    @PostMapping("/saveHcItemPackDictList")
    public void saveHcItemPackDict(@RequestBody SaveHcItemPackDictListVo saveHcItemPackDictListVo){
        itemDictPackService.saveHcItemPackDict(saveHcItemPackDictListVo);
    }

    @PostMapping("/savePackVsItemDict")
    public void savePackVsItemDict(@RequestBody SavePackVsItemDictVo savePackVsItemDictVo){
        itemDictPackService.savePackVsItemDict(savePackVsItemDictVo);
    }

    /**
     * 获取HcItemPackDict对象
     * @param hospitalId,itemPackCode
     * @return list
     */
    @ApiOperation(value = "获取HcItemPackDict对象")
    @GetMapping("/findItemPackDict/{hospitalId}/{itemPackCode}")
    private List<HcItemPackDict> findItemPackDict(@PathVariable String hospitalId,
                                                   @PathVariable String itemPackCode){
        return itemDictPackService.findItemPackDict(hospitalId,itemPackCode);
    }
}
