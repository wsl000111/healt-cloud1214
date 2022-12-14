package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.appointmentReg.service.FinishedSignService;
import com.healt.cloud.checkup.appointmentReg.vo.finishedSign.FinishedSignPerson;
import com.healt.cloud.checkup.appointmentReg.vo.finishedSign.FinishedSignPersonByWherePageVo;
import com.healt.cloud.checkup.appointmentReg.vo.finishedSign.SaveFinishedSignListVo;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author linklee
 * @create 2022-04-18 9:00
 */
@RestController
@AllArgsConstructor
@Api(tags = "检完签到接口API")
@RequestMapping("/finishedSign")
public class FinishedSignController {

    private FinishedSignService finishedSignService;

    @ApiOperation(value = "分页查询人员信息，含有完成时间FINISHED_DATE，完成标志FINISHED_SIGN")
    @PostMapping("/findPersonByWherePage")
    public PageResult<FinishedSignPerson> findPersonByWherePage(@RequestBody FinishedSignPersonByWherePageVo finishedSignPersonByWherePageVo){
        return finishedSignService.findPersonByWherePage(finishedSignPersonByWherePageVo);
    }

    @ApiOperation(value = "检完签到, 取消签到")
    @PostMapping("/saveFinishedSignList")
    public void saveFinishedSignList(@RequestBody SaveFinishedSignListVo saveFinishedSignListVo){
        finishedSignService.saveFinishedSignList(saveFinishedSignListVo);
    }

    @ApiOperation(value = "检查状态")
    @GetMapping("/findResultStatus/{hospitalId}/{personId}/{personVisitId}")
    public String findResultStatus(@PathVariable("hospitalId") String hospitalId,
                                   @PathVariable String personId,
                                   @PathVariable String personVisitId){
        return finishedSignService.findResultStatus(hospitalId, personId, personVisitId);
    }

    @ApiOperation(value = "拒检")
    @GetMapping("/updateFinshedSignRefusal/{hospitalId}/{personId}/{personVisitId}/{itemPackCode}/{itemNo}/{editerId}/{editerName}")
    public void updateFinshedSignRefusal(@PathVariable String hospitalId,
                                         @PathVariable String personId,
                                         @PathVariable String personVisitId,
                                         @PathVariable String itemPackCode,
                                         @PathVariable String itemNo,
                                         @PathVariable String editerId,
                                         @PathVariable String editerName){
        finishedSignService.updateFinshedSignRefusal(hospitalId, personId, personVisitId, itemPackCode, itemNo, editerId, editerName);
    }

    @ApiOperation(value = "取消拒检")
    @GetMapping("/updateFinshedSignCancelRefusal/{hospitalId}/{personId}/{personVisitId}/{itemPackCode}/{itemNo}/{editerId}/{editerName}")
    public void updateFinshedSignCancelRefusal(@PathVariable String hospitaId,
                                               @PathVariable String personId,
                                               @PathVariable String personVisitId,
                                               @PathVariable String itemPackCode,
                                               @PathVariable String itemNo,
                                               @PathVariable String editerId,
                                               @PathVariable String editerName){
        finishedSignService.updateFinshedSignCancelRefusal(hospitaId, personId, personVisitId, itemPackCode, itemNo, editerId, editerName);
    }

}
