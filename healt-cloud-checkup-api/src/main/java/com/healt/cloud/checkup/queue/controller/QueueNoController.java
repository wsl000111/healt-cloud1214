package com.healt.cloud.checkup.queue.controller;

import com.healt.cloud.checkup.entity.HcQueueNo;
import com.healt.cloud.checkup.queue.service.QueueNoService;
import com.healt.cloud.checkup.queue.vo.*;
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
@Api(tags = "体检人员报到顺序号信息接口API")
@RequestMapping("/queueNo")
public class QueueNoController {

    private QueueNoService queueNoService;

    /**
     * 获取体检人员报到顺序号信息(HC_QUEUE_CODE为0和2)
     * @param queueNoDictVo
     * @return list
     */
    @ApiOperation(value = "获取体检人员报到顺序号信息(HC_QUEUE_CODE为0和2)")
    @PostMapping("/findQueueNo")
    public List<HcQueueNo> findQueueNo(@RequestBody QueueNoDictVo queueNoDictVo){
        return queueNoService.findQueueNo(queueNoDictVo);
    }

    /**
     * 保存、删除和更新体检人员报到顺序号信息
     * @param saveQueueNoList
     * @return
     */
    @ApiOperation(value = "保存、删除和更新体检人员报到顺序号信息")
    @PostMapping("/saveQueueNo")
    public void saveQueueNo(@RequestBody SaveQueueNoListVo saveQueueNoList){
        queueNoService.saveQueueNo(saveQueueNoList);
    }

    /**
     * 大屏排队
     * @param hospitalId,counselNo,queueDate
     * @return list
     */
    @ApiOperation(value = "大屏排队")
    @GetMapping("/findQueueBigScreen/{hospitalId}/{counselNo}/{queueDate}")
    public List<QueueBigScreenVo> findQueueBigScreen(@PathVariable String hospitalId,
                                                     @PathVariable String counselNo,
                                                     @PathVariable String queueDate){
        return queueNoService.findQueueBigScreen(hospitalId,counselNo,queueDate);
    }

    /**
     * 大屏排队
     * @param hospitalId,counselNo,queueDate
     * @return list
     */
    @ApiOperation(value = "大屏排队,新方法")
    @GetMapping("/findQueueBigScreenNew/{hospitalId}/{counselNo}/{queueDate}")
    public List<QueueBigScreenVoNew> findQueueBigScreenNew(@PathVariable String hospitalId,
                                                           @PathVariable String counselNo,
                                                           @PathVariable String queueDate){
        return queueNoService.findQueueBigScreenNew(hospitalId,counselNo,queueDate);
    }

    /**
     * 大屏呼叫
     * @param hospitalId,counselNo
     * @return list
     */
    @ApiOperation(value = "大屏呼叫")
    @GetMapping("/findCallBigScreen/{hospitalId}/{counselNo}")
    public List<CallBigScreenVo> findCallBigScreen(@PathVariable String hospitalId,
                                                   @PathVariable String counselNo){
        return queueNoService.findCallBigScreen(hospitalId,counselNo);
    }
}
