package com.healt.cloud.checkup.printReport.controller;

import com.healt.cloud.checkup.printReport.service.UnitReportService;
import com.healt.cloud.checkup.printReport.vo.UnitQueryReportDictVo;
import com.healt.cloud.checkup.printReport.vo.UnitQueryReportVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-01 17:29
 */
@RestController
@AllArgsConstructor
@Api(tags = "单位体检报告接口API")
@RequestMapping("/unitReport")
public class UnitReportController {

    private UnitReportService unitReportService;

    /**
     * 获取单位体检信息
     * @param unitQueryReportDictVo
     * @return list
     */
    @ApiOperation(value = "获取单位体检信息，原sBperson_Click方法")
    @PostMapping("/findUnitQueryReport")
    public List<UnitQueryReportVo> findUnitQueryReport(@RequestBody UnitQueryReportDictVo unitQueryReportDictVo){
        return unitReportService.findUnitQueryReport(unitQueryReportDictVo);
    }

    /**
     * 获取报告主体内容
     * @param hospitalId,unitId,unitVisitId
     * @return list
     */
    @ApiOperation(value = "获取报告主体内容，原unitload方法")
    @GetMapping("/findUnitReport/{hospitalId}/{unitId}/{unitVisitId}/{department}/{personLeve}")
    public List findUnitReport(@PathVariable String hospitalId,
                               @PathVariable String unitId,
                               @PathVariable String unitVisitId,
                               @PathVariable String department,
                               @PathVariable String personLeve){
        return unitReportService.findUnitReport(hospitalId,unitId,unitVisitId,department,personLeve);
    }

    @ApiOperation(value = "获取单位部门")
    @GetMapping("/findUnitDepartment/{unitId}/{unitVisitId}")
    public List findUnitDepartment(@PathVariable String unitId,
                                   @PathVariable String unitVisitId){
        return unitReportService.findUnitDepartment(unitId, unitVisitId);
    }

    @ApiOperation(value = "获取单位职位")
    @GetMapping("/findUnitLevel/{unitId}/{unitVisitId}")
    public List findUnitLevel(@PathVariable String unitId,
                              @PathVariable String unitVisitId){
        return unitReportService.findUnitLevel(unitId, unitVisitId);
    }

}
