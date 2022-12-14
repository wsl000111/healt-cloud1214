package com.healt.cloud.checkup.queue.service;

import com.healt.cloud.checkup.entity.HcRoomQueue;
import com.healt.cloud.checkup.queue.vo.SaveRoomQueueListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 15:22
 */
public interface RoomQueueService {

    public List<HcRoomQueue> findRoomQueue(String hospitalId, String roomCode, String roomQueueNo);

    public void saveRoomQueue(SaveRoomQueueListVo saveRoomQueueList);

}
