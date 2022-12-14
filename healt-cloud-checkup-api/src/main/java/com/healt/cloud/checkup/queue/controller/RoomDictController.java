package com.healt.cloud.checkup.queue.controller;

import com.healt.cloud.checkup.entity.HcRoomDict;
import com.healt.cloud.checkup.queue.service.RoomDictService;
import com.healt.cloud.checkup.queue.vo.SaveRoomDictListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 15:45
 */
@RestController
@AllArgsConstructor
@Api(tags = "体检检查室字典接口API")
@RequestMapping("/roomDict")
public class RoomDictController {

    private RoomDictService roomDictService;

    /**
     * 获取体检人员报到顺序号信息
     * @param hospitalId,roomCode
     * @return list
     */
    @ApiOperation(value = "获取体检人员报到顺序号信息")
    @GetMapping("/findRoomDict/{hospitalId}/{roomCode}")
    public List<HcRoomDict> findRoomDict(@PathVariable String hospitalId,
                                         @PathVariable String roomCode){
        return roomDictService.findRoomDict(hospitalId,roomCode);
    }

    /**
     * 保存、删除和更新体检人员报到顺序号信息
     * @param saveRoomDictList
     * @return
     */
    @ApiOperation(value = "保存、删除和更新体检人员报到顺序号信息")
    @PostMapping("/saveRoomDict")
    public void saveRoomDict(@RequestBody SaveRoomDictListVo saveRoomDictList){
        roomDictService.saveRoomDict(saveRoomDictList);
    }
}
