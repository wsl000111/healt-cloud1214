package com.healt.cloud.checkup.controller.pubComm;

import com.healt.cloud.checkup.entity.HcItemReportWriteDict;
import com.healt.cloud.checkup.service.pubComm.PubCommService;
import com.healt.cloud.checkup.vo.pubComm.InterfaceSourceVo;
import com.healt.cloud.checkup.vo.pubComm.PersonVisitAndInfoVo;
import com.healt.cloud.checkup.vo.pubComm.PublicDictVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-03 9:28
 */
@RestController
@AllArgsConstructor
@Api(tags = "公共通用接口API")
@RequestMapping("/pubComm")
public class PubCommController {

    private PubCommService pubCommService;

    /**
     * 取外部接口
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "取外部接口，原GetItemExternalInterface方法")
    @GetMapping("/findItemExternalInterface/{hospitalId}/{itemPackCode}")
    public List<InterfaceSourceVo> findItemExternalInterface(@PathVariable("hospitalId") String hospitalId,
                                                             @PathVariable("itemPackCode") String itemPackCode) {
        return pubCommService.findItemExternalInterface(hospitalId,itemPackCode);
    }

    /**
     * 获取指定类型的名称和输入码
     * @param dictType
     * @return list
     */
    @ApiOperation(value = "获取指定类型的名称和输入码，原GetPublicDict方法")
    @GetMapping("/findPublicDict/{dictType}")
    public List<PublicDictVo> findPublicDict(@PathVariable("dictType") String dictType){
        return pubCommService.findPublicDict(dictType);
    }

    @ApiOperation(value = "获取体检人信息，pubComm.GetPersonInfo方法")
    @GetMapping("/findPersonInfo/{hospitalId}/{personId}/{personVisitId}")
    public List<PersonVisitAndInfoVo> findPersonInfo(@PathVariable("hospitalId") String hospitalId,
                                                     @PathVariable("personId") String personId,
                                                     @PathVariable("personVisitId") String personVisitId){
        return pubCommService.findPersonInfo(hospitalId, personId, personVisitId);
    }

    @ApiOperation(value = "最后一次体检次数，pubComm.GetPersonMaxVisit方法")
    @GetMapping("/findPersonMaxVisit/{hospitalId}/{personId}")
    public String findPersonMaxVisit(@PathVariable("hospitalId") String hospitalId,@PathVariable("personId") String personId){
        return pubCommService.findPersonMaxVisit(hospitalId, personId);
    }

    @ApiOperation(value = "单位最后一次体检次数, pubComm.GetUnitMaxVisit方法")
    @GetMapping("/findUnitMaxVisit/{hospitalId}/{unitId}")
    public String findUnitMaxVisit(@PathVariable("hospitalId") String hospitalId,@PathVariable("unitId") String unitId){
        return pubCommService.findUnitMaxVisit(hospitalId, unitId);
    }

    @ApiOperation(value = "取检查申请号，pubComm.GetExamNoForItem方法")
    @GetMapping("/findExamNoForItem/{hospitalId}/{itemPackCode}")
    public String findExamNoForItem(@PathVariable("hospitalId") String hospitalId, @PathVariable("itemPackCode") String itemPackCode){
        return pubCommService.findExamNoForItem(hospitalId, itemPackCode);
    }

    @ApiOperation(value = "取检验申请号，pubComm.GetTestNoForItem方法")
    @GetMapping("/findTestNoForItem/{hospitalId}/{itemPackCode}")
    public String findTestNoForItem(@PathVariable("hospitalId") String hospitalId, @PathVariable("itemPackCode") String itemPackCode){
        return pubCommService.findTestNoForItem(null, hospitalId, itemPackCode);
    }

    @ApiOperation(value = "体检项目结果关键字模板通用查询")
    @PostMapping("/getHcItemReportWriteDict")
    public List<HcItemReportWriteDict> getHcItemReportWriteDict(@RequestBody HcItemReportWriteDict hcItemReportWriteDict){
        return pubCommService.findHcItemReportWriteDict(hcItemReportWriteDict);
    }

}
