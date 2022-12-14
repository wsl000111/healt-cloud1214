package com.healt.cloud.checkup.printReport.controller;

import com.healt.cloud.checkup.printReport.service.PersonReportService;
import com.healt.cloud.checkup.printReport.vo.PrintPersonDictVo;
import com.healt.cloud.checkup.printReport.vo.mobile.HcReportVo;
import com.healt.cloud.checkup.printReport.vo.mobile.QueryReportListVo;
import com.healt.cloud.checkup.printReport.vo.mobile.ReportListVo;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-01 8:55
 */
@RestController
@AllArgsConstructor
@Api(tags = "个人体检报告接口API")
@RequestMapping("/personReport")
public class PersonReportController {

    private PersonReportService personReportService;

    // GetDtUnit方法是UnitQueryController里面的findDtUnit方法
    // GetDtUnitVisit方法是UnitPersonAppointRegController里面的findDtUnitVisit方法
    // tEPersonID_EditValueChanged方法是PersonResultSearchController里面的findPersonVisitCount方法
    // searchLookUpEditUnitView_RowClick方法是StatNoauditAllController里面的findUnitCount方法

    /**
     * 获取人员并分页
     * @param printPersonDictVo
     * @return list
     */
    @ApiOperation(value = "获取人员并分页，原sBperson_Click的方法")
    @PostMapping("/findPrintPerson")
    public PageResult findPrintPerson(@RequestBody PrintPersonDictVo printPersonDictVo){
        return personReportService.findPrintPerson(printPersonDictVo);
    }

    /**
     *
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "原persionload的方法")
    @GetMapping("/findPersonReport/{hospitalId}/{personId}/{personVisitId}")
    public List findPersonReport(@PathVariable String hospitalId,@PathVariable String personId,
                                 @PathVariable String personVisitId){
        return personReportService.findPersonReport(hospitalId,personId,personVisitId);
    }

    /**
     * 更新打印标记
     * @param hospitalId,personId,personVisitId,userName,userRealName
     * @return list
     */
    @ApiOperation(value = "更新打印标记,原savedict的方法")
    @GetMapping("/updatePrint/{hospitalId}/{personId}/{personVisitId}/{userName}/{userRealName}")
    public void updatePrint(@PathVariable String hospitalId,@PathVariable String personId,
                            @PathVariable String personVisitId,@PathVariable String userName,
                            @PathVariable String userRealName){
        personReportService.updatePrint(hospitalId,personId,personVisitId,userName,userRealName);
    }

    @ApiOperation(value = "查询体检报告列表")
    @PostMapping("/loadPersonReportList")
    public List<ReportListVo> loadPersonReportList(@RequestBody QueryReportListVo queryReportListVo){
        return personReportService.loadPersonReportList(queryReportListVo);
    }

    @ApiOperation(value = "查询体检报告明细")
    @GetMapping("/loadPersonReportInfo/{hospitalId}/{personId}/{personVisitId}")
    public HcReportVo loadPersonReportInfo(@PathVariable String hospitalId,
                                           @PathVariable String personId,
                                           @PathVariable String personVisitId){
        return personReportService.loadPersonReportInfo(hospitalId,personId,personVisitId);
    }
}
