package com.healt.cloud.checkup.queryReport.controller;

import com.healt.cloud.checkup.queryReport.service.QueueStatService;
import com.healt.cloud.checkup.queryReport.vo.StrWherePageVo;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author linklee
 * @create 2022-05-26 13:49
 */
@RestController
@AllArgsConstructor
@Api(tags = "体检人员签到情况查询接口API")
@RequestMapping("/queueStat")
public class QueueStatController {

    private QueueStatService queueStatService;

    /**
     * 取人员并分页
     * @param strWherePageVo
     * @return list
     */
    @ApiOperation(value = "取人员并分页，原GetPersonList方法")
    @PostMapping("/findPersonList")
    public PageResult findPersonList(@RequestBody StrWherePageVo strWherePageVo){
        return queueStatService.findPersonList(strWherePageVo);
    }

    /**
     * 取项目 同BeforeSignInController里面方法
     * @param
     * @return list
     */
//    @ApiOperation(value = "取项目，原GetPersonItems方法")
//    @PostMapping("/findPersonItems/{hospitalId}/{personId}/{personVisitId}")
//    public List<PersonItemsVo> findPersonItems(@PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
//                                               @PathVariable("personVisitId") Integer personVisitId){
//        return queueStatService.findPersonItems(hospitalId,personId,personVisitId);
//    }

    /**
     * 取完成情况汇总并分页
     * @param strWherePageVo
     * @return list
     */
    @ApiOperation(value = "取完成情况汇总并分页，原GetSumItems方法")
    @PostMapping("/findSumItems")
    public PageResult findSumItems(@RequestBody StrWherePageVo strWherePageVo){
        return queueStatService.findSumItems(strWherePageVo);
    }

    @ApiOperation(value = "取总费用")
    @PostMapping("/findSumCharges")
    public BigDecimal findSumCharges(@RequestBody StrWherePageVo strWherePageVo){
        return queueStatService.findSumCharges(strWherePageVo);
    }

    @ApiOperation(value = "取总费用(新)")
    @PostMapping("/findSumChargesNew")
    public BigDecimal findSumChargesNew(@RequestBody StrWherePageVo strWherePageVo){
        return queueStatService.findSumChargesNew(strWherePageVo);
    }
}
