package com.healt.cloud.checkup.queue.service;

import com.healt.cloud.checkup.entity.HcRoomDict;
import com.healt.cloud.checkup.queue.vo.SaveRoomDictListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 15:46
 */
public interface RoomDictService {

    public List<HcRoomDict> findRoomDict(String hospitalId, String roomCode);

    public void saveRoomDict(SaveRoomDictListVo saveRoomDictList);
}
