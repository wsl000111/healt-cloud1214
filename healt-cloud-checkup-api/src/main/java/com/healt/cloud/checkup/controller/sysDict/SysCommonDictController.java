package com.healt.cloud.checkup.controller.sysDict;

import com.healt.cloud.checkup.service.sysDict.SysCommonDictService;
import com.healt.cloud.checkup.vo.sys.common.*;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-08 15:43
 * @description: TODO
 */
@RestController
@Api(tags = "字典管理接口API")
@AllArgsConstructor
@RequestMapping("/sysCommon")
public class SysCommonDictController {

    private SysCommonDictService commonDictService;

    @PostMapping("/loadDtTable")
    private List<DtTableVoResult> loadDtTable(@RequestBody DtTableVo dtTableVo){
        return commonDictService.findDtTable(dtTableVo);
    }

    @PostMapping("/getDictColumns")
    private List<DictColumnsVoResult> getDictColumns(@RequestBody DictColumnsVo dictColumnsVo){
        return commonDictService.findDictColumns(dictColumnsVo);
    }

    @PostMapping("/loadDtDict")
    private Object loadDtDict(@RequestBody DtDictVo dtDictVo){
        return commonDictService.loadDtDict(dtDictVo);
    }

    @PostMapping("/saveCommonTable")
    private void saveCommonTable(@RequestBody SaveCommonTableVo saveCommonTableVo){
        commonDictService.saveCommonTable(saveCommonTableVo);
    }

    @GetMapping("/findPublicDict/{dictType}")
    private List<CommonDictVoResult> findPublicDict(@PathVariable String dictType){
        return commonDictService.findPublicDict(dictType);
    }

    @GetMapping("/findPublicDict1/{dictType}")
    private List<CommonDictVoResult1> findPublicDict1(@PathVariable String dictType){
        return commonDictService.findPublicDict1(dictType);
    }

}
