package com.healt.cloud.checkup.queue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcRoomQueue;
import com.healt.cloud.checkup.queue.mapper.RoomQueueMapper;
import com.healt.cloud.checkup.queue.service.RoomQueueService;
import com.healt.cloud.checkup.queue.vo.SaveRoomQueueListVo;
import com.healt.cloud.checkup.queue.vo.SaveRoomQueueVo;
import com.healt.cloud.checkup.service.HcRoomQueueService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 15:23
 */
@Service
@AllArgsConstructor
public class RoomQueueServiceImpl implements RoomQueueService {

    private RoomQueueMapper roomQueueMapper;

    private HcRoomQueueService hcRoomQueueService;

    @Override
    public List<HcRoomQueue> findRoomQueue(String hospitalId, String roomCode, String roomQueueNo) {
        QueryWrapper<HcRoomQueue> wrapper = new QueryWrapper<>();
        wrapper.eq("HOSPITAL_ID",hospitalId);
        wrapper.eq("ROOM_CODE",roomCode);
        wrapper.eq("ROOM_QUEUE_NO",roomQueueNo);
        List<HcRoomQueue> list = hcRoomQueueService.list(wrapper);
        if (list.size() == 0) {
            list.add(new HcRoomQueue());
        }
        return list;
    }

    @Transactional
    @Override
    public void saveRoomQueue(SaveRoomQueueListVo saveRoomQueueList) {
        for (SaveRoomQueueVo saveRoomQueueVo : saveRoomQueueList.getSaveRoomQueue()) {
            switch (saveRoomQueueVo.getStat()) {
                case "delete" :
                    for (HcRoomQueue hcRoomQueue : saveRoomQueueVo.getHcRoomQueue()) {
                        QueryWrapper<HcRoomQueue> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("ROOM_CODE",hcRoomQueue.getRoomCode());
                        queryWrapper.eq("ROOM_QUEUE_NO",hcRoomQueue.getRoomQueueNo());
                        queryWrapper.eq("HOSPITAL_ID",hcRoomQueue.getHospitalId());
                        hcRoomQueueService.remove(queryWrapper);
                    }
                    break;
                case "add" :
//                    String hospitalId = saveQuestionVo.getHcQuestionDict().get(0).getHospitalId();
//                    String investCode = saveQuestionVo.getHcQuestionDict().get(0).getInvestCode();
//                    Integer max = questionDictMapper.findMaxQuestionCode(hospitalId,investCode);
//                    if (max == null) {
//                        max = 0;
//                    }
//                    for (HcQuestionDict hcQuestionDict : saveQuestionVo.getHcQuestionDict()) {
//                        max += 1;
//                        String questionCode = String.format("%04d", max);
//                        hcQuestionDict.setQuestionCode(questionCode);
//                        hcQuestionDictService.save(hcQuestionDict);
//                    }
                    hcRoomQueueService.saveBatch(saveRoomQueueVo.getHcRoomQueue());
                    break;
                case "update" :
                    for (HcRoomQueue hcRoomQueue : saveRoomQueueVo.getHcRoomQueue()) {
                        UpdateWrapper<HcRoomQueue> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("ROOM_CODE",hcRoomQueue.getRoomCode());
                        updateWrapper.eq("ROOM_QUEUE_NO",hcRoomQueue.getRoomQueueNo());
                        updateWrapper.eq("HOSPITAL_ID",hcRoomQueue.getHospitalId());
                        hcRoomQueueService.update(hcRoomQueue,updateWrapper);
                    }
                    break;
            }
        }
    }
}
