package com.healt.cloud.checkup.questionnaire.controller;

import com.healt.cloud.checkup.entity.HcAnswerDict;
import com.healt.cloud.checkup.questionnaire.service.AnswerDictService;
import com.healt.cloud.checkup.questionnaire.vo.SaveAnswerListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-10 13:38
 */
@RestController
@AllArgsConstructor
@Api(tags = "问卷信息答案维护接口API")
@RequestMapping("/answerDict")
public class AnswerDictController {

    private AnswerDictService answerDictService;

    /**
     * 获取问卷答案
     * @param hospitalId,investCode,questionCode
     * @return list
     */
    @ApiOperation(value = "获取问卷答案")
    @GetMapping("/findAnswer/{hospitalId}/{investCode}/{questionCode}")
    public List<HcAnswerDict> findAnswer(@PathVariable String hospitalId,
                                         @PathVariable String investCode,
                                         @PathVariable String questionCode){
        return answerDictService.findAnswer(hospitalId,investCode,questionCode);
    }

    /**
     * 保存、删除和更新问卷答案
     * @param saveAnswerList
     * @return
     */
    @ApiOperation(value = "保存、删除和更新问卷答案")
    @PostMapping("/saveAnswer")
    public void saveAnswer(@RequestBody SaveAnswerListVo saveAnswerList){
        answerDictService.saveAnswer(saveAnswerList);
    }
}
