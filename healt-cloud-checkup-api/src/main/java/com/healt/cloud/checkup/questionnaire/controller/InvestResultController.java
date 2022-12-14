package com.healt.cloud.checkup.questionnaire.controller;

import com.healt.cloud.checkup.entity.HcInvestResult;
import com.healt.cloud.checkup.questionnaire.service.InvestResultService;
import com.healt.cloud.checkup.questionnaire.vo.SaveInvestResultListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 14:27
 */
@RestController
@AllArgsConstructor
@Api(tags = "体检人员问卷结果表接口API")
@RequestMapping("/investResult")
public class InvestResultController {

    private InvestResultService investResultService;

    /**
     * 获取体检人员问卷结果表
     * @param hospitalId,investCode
     * @return list
     */
    @ApiOperation(value = "获取体检人员问卷结果表")
    @GetMapping("/findInvestResult/{hospitalId}/{investCode}")
    public List<HcInvestResult> findInvestResult(@PathVariable String hospitalId,
                                                 @PathVariable String investCode){
        return investResultService.findInvestResult(hospitalId,investCode);
    }

    /**
     * 保存、删除和更新体检人员问卷结果表
     * @param saveInvestResultList
     * @return
     */
    @ApiOperation(value = "保存、删除和更新体检人员问卷结果表")
    @PostMapping("/saveInvestResult")
    public void saveInvestResult(@RequestBody SaveInvestResultListVo saveInvestResultList){
        investResultService.saveInvestResult(saveInvestResultList);
    }
}
