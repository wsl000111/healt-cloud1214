package com.healt.cloud.checkup.questionnaire.controller;

import com.healt.cloud.checkup.entity.HcQuestionDict;
import com.healt.cloud.checkup.questionnaire.service.QuestionDictService;
import com.healt.cloud.checkup.questionnaire.vo.HcQuestionDictVo;
import com.healt.cloud.checkup.questionnaire.vo.SaveQuestionListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-10 13:35
 */
@RestController
@AllArgsConstructor
@Api(tags = "健康问卷信息维护接口API")
@RequestMapping("/questionDict")
public class QuestionDictController {

    private QuestionDictService questionDictService;

    /**
     * 获取问卷信息
     * @param hospitalId,investCode
     * @return list
     */
    @ApiOperation(value = "获取问卷信息")
    @GetMapping("/findQuestion/{hospitalId}/{investCode}")
    public List<HcQuestionDict> findQuestion(@PathVariable String hospitalId,
                                             @PathVariable String investCode){
        return questionDictService.findQuestion(hospitalId,investCode);
    }

    /**
     * 保存、删除和更新问卷信息
     * @param saveQuestionList
     * @return
     */
    @ApiOperation(value = "保存、删除和更新问卷信息")
    @PostMapping("/saveQuestion")
    public void saveQuestion(@RequestBody SaveQuestionListVo saveQuestionList){
        questionDictService.saveQuestion(saveQuestionList);
    }

    /**
     * 获取问卷信息(Web用)
     * @param hospitalId,investCode
     * @return list
     */
    @ApiOperation(value = "获取问卷信息(Web用)")
    @GetMapping("/findQuestionWeb/{hospitalId}/{investCode}")
    public List<HcQuestionDict> findQuestionWeb(@PathVariable String hospitalId,
                                             @PathVariable String investCode){
        return questionDictService.findQuestionWeb(hospitalId,investCode);
    }

    /**
     * 获取问卷信息(Web用)
     * @param hospitalId,investCode
     * @return list
     */
    @ApiOperation(value = "获取问卷问题和答案(Web用)")
    @GetMapping("/findQuestionAndAnswerWeb/{hospitalId}/{investCode}")
    public List<HcQuestionDictVo> findQuestionAndAnswerWeb(@PathVariable String hospitalId,
                                                           @PathVariable String investCode){
        return questionDictService.findQuestionAndAnswerWeb(hospitalId,investCode);
    }
}
