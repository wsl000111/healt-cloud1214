package com.healt.cloud.checkup.queue.controller;

import com.healt.cloud.checkup.entity.HcRoomQueue;
import com.healt.cloud.checkup.queue.service.RoomQueueService;
import com.healt.cloud.checkup.queue.vo.SaveRoomQueueListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 15:21
 */
@RestController
@AllArgsConstructor
@Api(tags = "检查室排队队列信息接口API")
@RequestMapping("/roomQueue")
public class RoomQueueController {

    private RoomQueueService roomQueueService;

    /**
     * 获取检查室排队队列信息
     * @param hospitalId,roomCode,roomQueueNo
     * @return list
     */
    @ApiOperation(value = "获取检查室排队队列信息")
    @GetMapping("/findRoomQueue/{hospitalId}/{roomCode}/{roomQueueNo}")
    public List<HcRoomQueue> findRoomQueue(@PathVariable String hospitalId,
                                           @PathVariable String roomCode,
                                           @PathVariable String roomQueueNo){
        return roomQueueService.findRoomQueue(hospitalId,roomCode,roomQueueNo);
    }

    /**
     * 保存、删除和更新检查室排队队列信息
     * @param saveRoomQueueList
     * @return
     */
    @ApiOperation(value = "保存、删除和更新检查室排队队列信息")
    @PostMapping("/saveRoomQueue")
    public void saveRoomQueue(@RequestBody SaveRoomQueueListVo saveRoomQueueList){
        roomQueueService.saveRoomQueue(saveRoomQueueList);
    }
}
