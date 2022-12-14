package com.healt.cloud.checkup.queryReport.controller;

import com.healt.cloud.checkup.queryReport.service.UnitResultSearchService;
import com.healt.cloud.checkup.queryReport.vo.PersonTztListDictVo;
import com.healt.cloud.checkup.queryReport.vo.UnitInfoVo;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-26 16:20
 */
@RestController
@AllArgsConstructor
@Api(tags = "单位体检信息查询接口API")
@RequestMapping("/unitResultSearch")
public class UnitResultSearchController {

    private UnitResultSearchService unitResultSearchService;

    /**
     * 查询单位信息
     * @param hospitalId,unitId
     * @return list
     */
    @ApiOperation(value = "查询单位信息，原sButtionSearch_Click的第一个方法")
    @GetMapping("/findUnitInfo/{hospitalId}/{unitId}")
    public List<UnitInfoVo> findUnitInfo(@PathVariable String hospitalId, @PathVariable String unitId){
        return unitResultSearchService.findUnitInfo(hospitalId,unitId);
    }

    /**
     * 取人员并分页
     * @param personTztListDictVo
     * @return list
     */
    @ApiOperation(value = "取人员并分页，原sButtionSearch_Click的第二个方法")
    @PostMapping("/findPersonList")
    public PageResult findPersonList(@RequestBody PersonTztListDictVo personTztListDictVo){
        return unitResultSearchService.findPersonList(personTztListDictVo);
    }
}
