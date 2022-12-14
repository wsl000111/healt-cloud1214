package com.healt.cloud.checkup.queue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcRoomDict;
import com.healt.cloud.checkup.queue.mapper.RoomDictMapper;
import com.healt.cloud.checkup.queue.service.RoomDictService;
import com.healt.cloud.checkup.queue.vo.SaveRoomDictListVo;
import com.healt.cloud.checkup.queue.vo.SaveRoomDictVo;
import com.healt.cloud.checkup.service.HcRoomDictService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 15:46
 */
@Service
@AllArgsConstructor
public class RoomDictServiceImpl implements RoomDictService {

    private RoomDictMapper roomDictMapper;

    private HcRoomDictService hcRoomDictService;

    @Override
    public List<HcRoomDict> findRoomDict(String hospitalId, String roomCode) {
        QueryWrapper<HcRoomDict> wrapper = new QueryWrapper<>();
        wrapper.eq("HOSPITAL_ID",hospitalId);
        if (!roomCode.equals("*")) {
            wrapper.eq("ROOM_CODE",roomCode);
        }
        List<HcRoomDict> list = hcRoomDictService.list(wrapper);
        if (list.size() == 0) {
            list.add(new HcRoomDict());
        }
        return list;
    }

    @Transactional
    @Override
    public void saveRoomDict(SaveRoomDictListVo saveRoomDictList) {
        for (SaveRoomDictVo saveRoomDictVo : saveRoomDictList.getSaveRoomDict()) {
            switch (saveRoomDictVo.getStat()) {
                case "delete" :
                    for (HcRoomDict hcRoomDict : saveRoomDictVo.getHcRoomDict()) {
                        QueryWrapper<HcRoomDict> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID",hcRoomDict.getHospitalId());
                        queryWrapper.eq("ROOM_CODE",hcRoomDict.getRoomCode());
                        hcRoomDictService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    hcRoomDictService.saveBatch(saveRoomDictVo.getHcRoomDict());
                    break;
                case "update" :
                    for (HcRoomDict hcRoomDict : saveRoomDictVo.getHcRoomDict()) {
                        UpdateWrapper<HcRoomDict> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID",hcRoomDict.getHospitalId());
                        updateWrapper.eq("ROOM_CODE",hcRoomDict.getRoomCode());
                        hcRoomDictService.update(hcRoomDict,updateWrapper);
                    }
                    break;
            }
        }
    }
}
