package com.healt.cloud.checkup.queue.service;

import com.healt.cloud.checkup.entity.HcRoomVsAssem;
import com.healt.cloud.checkup.queue.vo.SaveRoomVsAssemListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 16:08
 */
public interface RoomVsAssemService {

    public List<HcRoomVsAssem> findRoomVsAssem(String hospitalId, String roomCode, String itemAssemNo);

    public void saveRoomVsAssem(SaveRoomVsAssemListVo saveRoomVsAssemList);
}
