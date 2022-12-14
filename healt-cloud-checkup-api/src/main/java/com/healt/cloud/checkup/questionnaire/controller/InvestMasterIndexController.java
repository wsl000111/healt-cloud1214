package com.healt.cloud.checkup.questionnaire.controller;

import com.healt.cloud.checkup.entity.HcInvestMasterIndex;
import com.healt.cloud.checkup.questionnaire.service.InvestMasterIndexService;
import com.healt.cloud.checkup.questionnaire.vo.SaveInvestMasterIndexListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 13:43
 */
@RestController
@AllArgsConstructor
@Api(tags = "问卷调查主索引接口API")
@RequestMapping("/investMasterIndex")
public class InvestMasterIndexController {

    private InvestMasterIndexService investMasterIndexService;

    /**
     * 获取问卷调查主索引
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "获取问卷调查主索引")
    @GetMapping("/findInvestMasterIndex/{hospitalId}")
    public List<HcInvestMasterIndex> findInvestMasterIndex(@PathVariable String hospitalId){
        return investMasterIndexService.findInvestMasterIndex(hospitalId);
    }

    /**
     * 保存、删除和更新问卷调查主索引(Web用)
     * @param saveInvestMasterIndexList
     * @return
     */
    @ApiOperation(value = "保存、删除和更新问卷调查主索引(Web用)")
    @PostMapping("/saveInvestMasterIndexWeb")
    public void saveInvestMasterIndexWeb(@RequestBody SaveInvestMasterIndexListVo saveInvestMasterIndexList){
        investMasterIndexService.saveInvestMasterIndexWeb(saveInvestMasterIndexList);
    }
}
