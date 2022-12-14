package com.healt.cloud.checkup.questionnaire.controller;

import com.healt.cloud.checkup.entity.HcInvestType;
import com.healt.cloud.checkup.questionnaire.service.InvestTypeService;
import com.healt.cloud.checkup.questionnaire.vo.SaveInvestTypeListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 9:48
 */
@RestController
@AllArgsConstructor
@Api(tags = "健康问卷名称字典接口API")
@RequestMapping("/investType")
public class InvestTypeController {

    private InvestTypeService investTypeService;

    /**
     * 获取健康问卷名称字典
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "获取健康问卷名称字典")
    @GetMapping("/findInvestType/{hospitalId}")
    public List<HcInvestType> findInvestType(@PathVariable String hospitalId){
        return investTypeService.findInvestType(hospitalId);
    }

    /**
     * 保存、删除和更新健康问卷名称字典
     * @param saveInvestTypeList
     * @return
     */
    @ApiOperation(value = "保存、删除和更新健康问卷名称字典")
    @PostMapping("/saveInvestType")
    public void saveInvestType(@RequestBody SaveInvestTypeListVo saveInvestTypeList){
        investTypeService.saveInvestType(saveInvestTypeList);
    }

    /**
     * 获取健康问卷名称字典(Web用)
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "获取健康问卷名称字典(Web用)")
    @GetMapping("/findInvestTypeWeb/{hospitalId}")
    public List<HcInvestType> findInvestTypeWeb(@PathVariable String hospitalId){
        return investTypeService.findInvestTypeWeb(hospitalId);
    }
}
