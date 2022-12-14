package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.appointmentReg.service.ModifyItemStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linklee
 * @create 2022-06-24 16:35
 */
@RestController
@AllArgsConstructor
@Api(tags = "修改项目状态接口API")
@RequestMapping("/modifyItemStatus")
public class ModifyItemStatusController {

    private ModifyItemStatusService modifyItemStatusService;

    @ApiOperation(value = "更新hc_person_appreg_items的FINISHED_SIGN为完成,FINISHED_DATE为系统时间,EDITER_ID为用户代码,EDITER_NAME为用户姓名")
    @GetMapping("/updateItemFinshedSign/{hospitalId}/{personId}/{personVisitId}/{itemPackCode}/{itemNo}/{editerId}/{editerName}")
    public void updateItemFinshedSign(@PathVariable String hospitalId,
                                      @PathVariable String personId,
                                      @PathVariable String personVisitId,
                                      @PathVariable String itemPackCode,
                                      @PathVariable String itemNo,
                                      @PathVariable String editerId,
                                      @PathVariable String editerName){
        modifyItemStatusService.updateItemFinshedSign(hospitalId, personId, personVisitId, itemPackCode, itemNo, editerId, editerName);
    }

    @ApiOperation(value = "更新hc_person_appreg_items的FINISHED_SIGN为未完成,FINISHED_DATE清空,EDITER_ID清空,EDITER_NAME为清空")
    @GetMapping("/updateItemFinshedSignToBeContinued/{hospitalId}/{personId}/{personVisitId}/{itemPackCode}/{itemNo}/{editerId}/{editerName}/{finishedSign}")
    public void updateItemFinshedSignToBeContinued(@PathVariable String hospitalId,
                                                   @PathVariable String personId,
                                                   @PathVariable String personVisitId,
                                                   @PathVariable String itemPackCode,
                                                   @PathVariable String itemNo,
                                                   @PathVariable String editerId,
                                                   @PathVariable String editerName,
                                                   @PathVariable String finishedSign){
        modifyItemStatusService.updateItemFinshedSignToBeContinued(hospitalId, personId, personVisitId, itemPackCode, itemNo, editerId, editerName);
    }

    @ApiOperation(value = "更新hc_person_appreg_items的FINISHED_SIGN为延期,其它字段不要更新")
    @GetMapping("/updateItemFinshedSignPostpone/{hospitalId}/{personId}/{personVisitId}/{itemPackCode}/{itemNo}/{editerId}/{editerName}")
    public void updateItemFinshedSignPostpone(@PathVariable String hospitalId,
                                              @PathVariable String personId,
                                              @PathVariable String personVisitId,
                                              @PathVariable String itemPackCode,
                                              @PathVariable String itemNo,
                                              @PathVariable String editerId,
                                              @PathVariable String editerName){
        modifyItemStatusService.updateItemFinshedSignPostpone(hospitalId, personId, personVisitId, itemPackCode, itemNo, editerId, editerName);
    }
}
