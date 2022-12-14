package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.appointmentReg.service.UnitModifyLastAuditService;
import com.healt.cloud.checkup.appointmentReg.vo.unitModifyLastAudit.UnitBasePersonInfoVo;
import com.healt.cloud.checkup.appointmentReg.vo.unitModifyLastAudit.UnitBaseVo;
import com.healt.cloud.checkup.appointmentReg.vo.unitModifyLastAudit.UpdateUnitModifyLastAuditListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-24 17:15
 */
@RestController
@AllArgsConstructor
@Api(tags = "单位完成状态设置接口API")
@RequestMapping("/unitModifyLastAudit")
public class UnitModifyLastAuditController {

    private UnitModifyLastAuditService unitModifyLastAuditService;

    @ApiOperation(value = "提取单位基本信息,unitId为*取全部数据")
    @GetMapping("/unitModifyLastAuditBase/{hospitalId}/{unitId}")
    public List<UnitBaseVo> unitModifyLastAuditBase(@PathVariable String hospitalId,@PathVariable String unitId){
        return unitModifyLastAuditService.unitModifyLastAuditBase(hospitalId, unitId);
    }

    @ApiOperation(value = "提取单位人员信息")
    @GetMapping("/unitModifyLastAuditPersonInfo/{hospitalId}/{unitId}/{unitVisitId}")
    public List<UnitBasePersonInfoVo> unitModifyLastAuditPersonInfo(@PathVariable String hospitalId,@PathVariable String unitId,
                                                                    @PathVariable String unitVisitId){
        return unitModifyLastAuditService.unitModifyLastAuditPersonInfo(hospitalId, unitId, unitVisitId);
    }

    @ApiOperation(value = "更新hc_person_visit_info的result_status状态和单位主记录")
    @PostMapping("/updateUnitModifyLastAudit")
    public void updateUnitModifyLastAudit(@RequestBody UpdateUnitModifyLastAuditListVo updateUnitModifyLastAuditList){
        unitModifyLastAuditService.updateUnitModifyLastAudit(updateUnitModifyLastAuditList);
    }
}
