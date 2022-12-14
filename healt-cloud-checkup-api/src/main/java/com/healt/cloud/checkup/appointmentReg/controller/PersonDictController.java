package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.entity.HcPersonInfo;
import com.healt.cloud.checkup.appointmentReg.service.PersionInfoService;
import com.healt.cloud.checkup.vo.appointmentReg.hcPersonDict.HcPersonInfoVo;
import com.healt.cloud.checkup.vo.appointmentReg.hcPersonDict.SaveHcPersonDictListVo;
import com.healt.cloud.common.pages.PageResult;
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
@Api(tags = "人员信息接口API")
@RequestMapping("/appointment")
public class PersonDictController {

    private PersionInfoService persionInfoService;

    @GetMapping("/findPersonList/{hospitalCode}")
    public List<HcPersonInfo> findPersonList(@PathVariable String hospitalCode){
        return persionInfoService.findPersonList(hospitalCode);
    }

    @GetMapping("/findPersonListTwo/{hospitalCode}/{unitId}")
    public List<HcPersonInfo> findPersonListTwo(@PathVariable String hospitalCode, @PathVariable String unitId){
        return persionInfoService.findPersonList(hospitalCode, unitId);
    }

    @PostMapping("/findPersonListPage")
    @ApiOperation(value = "条件分页查询人员信息")
    public PageResult<HcPersonInfo> findPersonListPage(@RequestBody HcPersonInfoVo hcPersonInfoVo){
        return persionInfoService.findPersonListPage(hcPersonInfoVo);
    }

    @GetMapping("/findPeId/{hospitalCode}")
    public String findPeId(@PathVariable String hospitalCode){
        return persionInfoService.findPeId(hospitalCode);
    }

    @PostMapping("/savePersonDictList")
    public void savePersonDictList(@RequestBody SaveHcPersonDictListVo saveHcPersonDictListVo){
        persionInfoService.savePersonDictList(saveHcPersonDictListVo);
    }

    @ApiOperation("查询His系统患者是否已经建档")
    @GetMapping("/findPersonInfoWS/{medInstCode}/{areaCode}/{idCard}/{patientName}")
    public String findPersonInfoWS(@PathVariable String medInstCode, @PathVariable String areaCode, @PathVariable String idCard, @PathVariable String patientName){
        return persionInfoService.findPersonInfoWS(medInstCode, areaCode, idCard, patientName);
    }

}
