package com.healt.cloud.checkup.queue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcRoomVsAssem;
import com.healt.cloud.checkup.queue.mapper.RoomVsAssemMapper;
import com.healt.cloud.checkup.queue.service.RoomVsAssemService;
import com.healt.cloud.checkup.queue.vo.SaveRoomVsAssemListVo;
import com.healt.cloud.checkup.queue.vo.SaveRoomVsAssemVo;
import com.healt.cloud.checkup.service.HcRoomVsAssemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 16:08
 */
@Service
@AllArgsConstructor
public class RoomVsAssemServiceImpl implements RoomVsAssemService {

    private RoomVsAssemMapper roomVsAssemMapper;

    private HcRoomVsAssemService hcRoomVsAssemService;

    @Override
    public List<HcRoomVsAssem> findRoomVsAssem(String hospitalId, String roomCode, String itemAssemNo) {
        QueryWrapper<HcRoomVsAssem> wrapper = new QueryWrapper<>();
        wrapper.eq("HOSPITAL_ID",hospitalId);
        wrapper.eq("ROOM_CODE",roomCode);
        if (!itemAssemNo.equals("*")) {
            wrapper.eq("ITEM_ASSEM_NO",itemAssemNo);
        }
        List<HcRoomVsAssem> list = hcRoomVsAssemService.list(wrapper);
        if (list.size() == 0) {
            list.add(new HcRoomVsAssem());
        }
        return list;
    }

    @Transactional
    @Override
    public void saveRoomVsAssem(SaveRoomVsAssemListVo saveRoomVsAssemList) {
        for (SaveRoomVsAssemVo saveRoomVsAssemVo : saveRoomVsAssemList.getSaveRoomVsAssem()) {
            switch (saveRoomVsAssemVo.getStat()) {
                case "delete" :
                    for (HcRoomVsAssem hcRoomVsAssem : saveRoomVsAssemVo.getHcRoomVsAssem()) {
                        QueryWrapper<HcRoomVsAssem> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID",hcRoomVsAssem.getHospitalId());
                        queryWrapper.eq("ROOM_CODE",hcRoomVsAssem.getRoomCode());
                        queryWrapper.eq("ITEM_ASSEM_NO",hcRoomVsAssem.getItemAssemNo());
                        hcRoomVsAssemService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    hcRoomVsAssemService.saveBatch(saveRoomVsAssemVo.getHcRoomVsAssem());
                    break;
                case "update" :
                    for (HcRoomVsAssem hcRoomVsAssem : saveRoomVsAssemVo.getHcRoomVsAssem()) {
                        UpdateWrapper<HcRoomVsAssem> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID",hcRoomVsAssem.getHospitalId());
                        updateWrapper.eq("ROOM_CODE",hcRoomVsAssem.getRoomCode());
                        updateWrapper.eq("ITEM_ASSEM_NO",hcRoomVsAssem.getItemAssemNo());
                        hcRoomVsAssemService.update(hcRoomVsAssem,updateWrapper);
                    }
                    break;
            }
        }
    }
}
