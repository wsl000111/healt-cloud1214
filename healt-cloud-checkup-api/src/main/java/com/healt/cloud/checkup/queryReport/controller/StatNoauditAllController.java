package com.healt.cloud.checkup.queryReport.controller;

import com.healt.cloud.checkup.queryReport.service.StatNoauditAllService;
import com.healt.cloud.checkup.queryReport.vo.StrWherePageVo;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-26 15:25
 */
@RestController
@AllArgsConstructor
@Api(tags = "体检人员未终审情况查询接口API")
@RequestMapping("/statNoauditAll")
public class StatNoauditAllController {

    private StatNoauditAllService statNoauditAllService;

    /**
     * 取未终审人员并分页
     * @param strWherePageVo
     * @return list
     */
    @ApiOperation(value = "取未终审人员并分页，原GetPersonList方法")
    @PostMapping("/findPersonNotFinalList")
    public PageResult findPersonNotFinalList(@RequestBody StrWherePageVo strWherePageVo){
        return statNoauditAllService.findPersonNotFinalList(strWherePageVo);
    }

    /**
     * 查询单位次数
     * @param unitId
     * @return list
     */
    @ApiOperation(value = "查询单位次数，原searchLookUpEditUnitView_RowClick方法")
    @GetMapping("/findUnitCount/{unitId}")
    public List findUnitCount(@PathVariable String unitId){
        return statNoauditAllService.findUnitCount(unitId);
    }
}
