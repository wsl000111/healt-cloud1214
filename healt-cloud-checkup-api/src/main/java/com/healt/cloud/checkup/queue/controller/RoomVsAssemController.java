package com.healt.cloud.checkup.queue.controller;

import com.healt.cloud.checkup.entity.HcRoomVsAssem;
import com.healt.cloud.checkup.queue.service.RoomVsAssemService;
import com.healt.cloud.checkup.queue.vo.SaveRoomVsAssemListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 16:06
 */
@RestController
@AllArgsConstructor
@Api(tags = "检查室与项目组合对照表接口API")
@RequestMapping("/roomVsAssem")
public class RoomVsAssemController {

    private RoomVsAssemService roomVsAssemService;

    /**
     * 获取检查室与项目组合对照表
     * @param hospitalId,roomCode,itemAssemNo
     * @return list
     */
    @ApiOperation(value = "获取检查室与项目组合对照表")
    @GetMapping("/findRoomVsAssem/{hospitalId}/{roomCode}/{itemAssemNo}")
    public List<HcRoomVsAssem> findRoomVsAssem(@PathVariable String hospitalId,
                                               @PathVariable String roomCode,
                                               @PathVariable String itemAssemNo){
        return roomVsAssemService.findRoomVsAssem(hospitalId,roomCode,itemAssemNo);
    }

    /**
     * 保存、删除和更新检查室与项目组合对照表
     * @param saveRoomVsAssemList
     * @return
     */
    @ApiOperation(value = "保存、删除和更新检查室与项目组合对照表")
    @PostMapping("/saveRoomVsAssem")
    public void saveRoomVsAssem(@RequestBody SaveRoomVsAssemListVo saveRoomVsAssemList){
        roomVsAssemService.saveRoomVsAssem(saveRoomVsAssemList);
    }

}
