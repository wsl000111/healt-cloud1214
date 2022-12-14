package com.healt.cloud.checkup.queryReport.controller;

import com.healt.cloud.checkup.queryReport.service.DiagnosisStatUnitService;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsDictVo;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
@author linklee
@create 2022-05-29 14:52
*/
@RestController
@AllArgsConstructor
@Api(tags = "单位疾病和阳性统计接口API")
@RequestMapping("/diagnosisStatUnit")
public class DiagnosisStatUnitController {

    private DiagnosisStatUnitService diagnosisStatUnitService;

    /**
     * 查询登记总人数
     * @param hospitalId,unitId,unitVisitId
     * @return list
     */
    @ApiOperation(value = "查询登记总人数，原sButtionSearch_Click的第一个方法")
    @GetMapping("/findTotalCount/{hospitalId}/{unitId}/{unitVisitId}")
    public List findTotalCount(@PathVariable String hospitalId,@PathVariable String unitId,
                               @PathVariable String unitVisitId){
        return diagnosisStatUnitService.findTotalCount(hospitalId,unitId,unitVisitId);
    }

    /**
     * 查询登记男人数
     * @param hospitalId,unitId,unitVisitId
     * @return list
     */
    @ApiOperation(value = "查询登记男人数，原sButtionSearch_Click的第二个方法")
    @GetMapping("/findManCount/{hospitalId}/{unitId}/{unitVisitId}")
    public List findManCount(@PathVariable String hospitalId,@PathVariable String unitId,
                               @PathVariable String unitVisitId){
        return diagnosisStatUnitService.findManCount(hospitalId,unitId,unitVisitId);
    }

    /**
     * 查询登记女人数
     * @param hospitalId,unitId,unitVisitId
     * @return list
     */
    @ApiOperation(value = "查询登记女人数，原sButtionSearch_Click的第三个方法")
    @GetMapping("/findWomanCount/{hospitalId}/{unitId}/{unitVisitId}")
    public List findWomanCount(@PathVariable String hospitalId,@PathVariable String unitId,
                             @PathVariable String unitVisitId){
        return diagnosisStatUnitService.findWomanCount(hospitalId,unitId,unitVisitId);
    }

    /**
     * 查询参检总人数
     * @param hospitalId,unitId,unitVisitId
     * @return list
     */
    @ApiOperation(value = "查询参检总人数，原sButtionSearch_Click的第四个方法")
    @GetMapping("/findBeforeSignTotalCount/{hospitalId}/{unitId}/{unitVisitId}")
    public List findBeforeSignTotalCount(@PathVariable String hospitalId,@PathVariable String unitId,
                               @PathVariable String unitVisitId){
        return diagnosisStatUnitService.findBeforeSignTotalCount(hospitalId,unitId,unitVisitId);
    }

    /**
     * 查询参检男人数
     * @param hospitalId,unitId,unitVisitId
     * @return list
     */
    @ApiOperation(value = "查询参检男人数，原sButtionSearch_Click的第五个方法")
    @GetMapping("/findBeforeSignManCount/{hospitalId}/{unitId}/{unitVisitId}")
    public List findBeforeSignManCount(@PathVariable String hospitalId,@PathVariable String unitId,
                             @PathVariable String unitVisitId){
        return diagnosisStatUnitService.findBeforeSignManCount(hospitalId,unitId,unitVisitId);
    }

    /**
     * 查询参检女人数
     * @param hospitalId,unitId,unitVisitId
     * @return list
     */
    @ApiOperation(value = "查询参检女人数，原sButtionSearch_Click的第六个方法")
    @GetMapping("/findBeforeSignWomanCount/{hospitalId}/{unitId}/{unitVisitId}")
    public List findBeforeSignWomanCount(@PathVariable String hospitalId,@PathVariable String unitId,
                                       @PathVariable String unitVisitId){
        return diagnosisStatUnitService.findBeforeSignWomanCount(hospitalId,unitId,unitVisitId);
    }

    /**
     * 体检异常结果检出统计
     * @param abnormalResultsDictVo
     * @return list
     */
    @ApiOperation(value = "体检异常结果检出统计，原sButtionSearch_Click的第七个方法")
    @PostMapping("/findAbnormalResults")
    public List<AbnormalResultsVo> findAbnormalResults(@RequestBody AbnormalResultsDictVo abnormalResultsDictVo){
        return diagnosisStatUnitService.findAbnormalResults(abnormalResultsDictVo);
    }
}
