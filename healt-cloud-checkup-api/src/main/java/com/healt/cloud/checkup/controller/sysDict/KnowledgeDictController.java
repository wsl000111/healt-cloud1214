package com.healt.cloud.checkup.controller.sysDict;

import com.healt.cloud.checkup.entity.HcDiseaseDict;
import com.healt.cloud.checkup.entity.HcKnowledgeDict;
import com.healt.cloud.checkup.service.sysDict.KnowledgeDictService;
import com.healt.cloud.checkup.vo.sys.knowledge.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-21 11:14
 * @description: TODO
 */
@RestController
@Api(tags = "词条维护接口API")
@AllArgsConstructor
@RequestMapping("/knowledge")
public class KnowledgeDictController {

    private KnowledgeDictService knowledgeDictService;

    @PostMapping("/findKnowledgeList")
    public List<HcKnowledgeDict> findKnowledgeList(@RequestBody HcKnowledgeDictVo hcKnowledgeDictVo){
        return knowledgeDictService.findKnowledgeList(hcKnowledgeDictVo);
    }

    @ApiOperation(value = "条件关联查询hc_knowledge_dict，disease")
    @PostMapping("/getknowledgeDict")
    public List<HcKnowledgeDictVoRsp> getknowledgeDict(@RequestBody HcKnowledgeDictVoReq hcKnowledgeDictVoRes){
        return knowledgeDictService.findKnowledgeDict(hcKnowledgeDictVoRes);
    }

    @GetMapping("/findDiseaseList/{hospitalId}")
    public List<HcDiseaseDict> findDiseaseList(@PathVariable String hospitalId){
        return knowledgeDictService.findDiseaseList(hospitalId);
    }

    @GetMapping("/findItemsDepartListLoad")
    public List<ItemsDepartListVo> findItemsDepartList(){
        return knowledgeDictService.findItemsDepartList();
    }

    @PostMapping("/saveHcKnowledgeDictList")
    public void saveHcKnowledgeDictList(@RequestBody SaveHcKnowledgeDictListVo saveHcKnowledgeDictListVo){
        knowledgeDictService.saveHcKnowledgeDictListVo(saveHcKnowledgeDictListVo);
    }

}
