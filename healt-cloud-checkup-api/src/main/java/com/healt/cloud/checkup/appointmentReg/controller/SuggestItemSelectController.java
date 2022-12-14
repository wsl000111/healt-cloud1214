package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.appointmentReg.service.SuggestItemSelectService;
import com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect.SuggestDepartDictVo;
import com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect.SuggestDictVo;
import com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect.SuggestVDepartDictVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-31 15:26
 * @description: TODO
 */
@RestController
@AllArgsConstructor
@Api(tags = "分科体检模版接口API")
@RequestMapping("/suggestItemSelect")
public class SuggestItemSelectController {

    private SuggestItemSelectService suggestItemSelectService;

    @ApiOperation("查询depart_dict")
    @GetMapping("/loadDepartDict")
    public List<SuggestDepartDictVo> loadDepartDict(){
        return suggestItemSelectService.loadDepartDict();
    }

    @ApiOperation("查询depart_dict")
    @GetMapping("/loadVDepartDict/{hospitalId}")
    public List<SuggestVDepartDictVo> loadVDepartDict(@PathVariable("hospitalId") String hospitalId){
        return suggestItemSelectService.loadVDepartDict(hospitalId);
    }

    @ApiOperation("knowledge_dict")
    @GetMapping("/loadSuggestDict/{hospitalId}/{deptId}")
    public List<SuggestDictVo> loadSuggestDict(@PathVariable("hospitalId") String hospitalId,
                                               @PathVariable("deptId") String deptId){
        return suggestItemSelectService.loadSuggestDict(hospitalId, deptId);
    }

}
