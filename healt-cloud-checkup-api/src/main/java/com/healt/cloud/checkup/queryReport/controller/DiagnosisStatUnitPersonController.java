package com.healt.cloud.checkup.queryReport.controller;

import com.healt.cloud.checkup.queryReport.service.DiagnosisStatUnitPersonService;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResults1Vo;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResults2Vo;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsPersonDictVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-30 13:30
 */
@RestController
@AllArgsConstructor
@Api(tags = "单位疾病和阳性明细接口API")
@RequestMapping("/diagnosisStatUnitPerson")
public class DiagnosisStatUnitPersonController {

    private DiagnosisStatUnitPersonService diagnosisStatUnitPersonService;

    /**
     * 体检异常结果检出统计1
     * @param abnormalResultsPersonDictVo
     * @return list
     */
    @ApiOperation(value = "体检异常结果检出统计1，原sButtionSearch_Click的select方法")
    @PostMapping("/findAbnormalResults1")
    public List<AbnormalResults1Vo> findAbnormalResults1(@RequestBody AbnormalResultsPersonDictVo abnormalResultsPersonDictVo){
        return diagnosisStatUnitPersonService.findAbnormalResults1(abnormalResultsPersonDictVo);
    }

    /**
     * 体检异常结果检出统计2
     * @param abnormalResultsPersonDictVo
     * @return list
     */
    @ApiOperation(value = "体检异常结果检出统计2，原sButtionSearch_Click的select方法")
    @PostMapping("/findAbnormalResults2")
    public List<AbnormalResults2Vo> findAbnormalResults2(@RequestBody AbnormalResultsPersonDictVo abnormalResultsPersonDictVo){
        return diagnosisStatUnitPersonService.findAbnormalResults2(abnormalResultsPersonDictVo);
    }

    @ApiOperation(value = "体检异常结果检出统计1(时间范围)")
    @PostMapping("/findAbnormalResults1ByTime")
    public List<AbnormalResults1Vo> findAbnormalResults1ByTime(@RequestBody AbnormalResultsPersonDictVo abnormalResultsPersonDictVo){
        return diagnosisStatUnitPersonService.findAbnormalResults1ByTime(abnormalResultsPersonDictVo);
    }

    @ApiOperation(value = "体检异常结果检出统计2(时间范围)")
    @PostMapping("/findAbnormalResults2ByTime")
    public List<AbnormalResults2Vo> findAbnormalResults2ByTime(@RequestBody AbnormalResultsPersonDictVo abnormalResultsPersonDictVo){
        return diagnosisStatUnitPersonService.findAbnormalResults2ByTime(abnormalResultsPersonDictVo);
    }

}
