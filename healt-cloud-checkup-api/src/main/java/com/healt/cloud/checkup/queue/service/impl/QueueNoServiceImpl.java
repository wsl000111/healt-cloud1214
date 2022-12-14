package com.healt.cloud.checkup.queue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcQueueNo;
import com.healt.cloud.checkup.queue.mapper.QueueNoMapper;
import com.healt.cloud.checkup.queue.service.QueueNoService;
import com.healt.cloud.checkup.queue.vo.*;
import com.healt.cloud.checkup.service.HcQueueNoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 15:01
 */
@Service
@AllArgsConstructor
public class QueueNoServiceImpl implements QueueNoService {

    private QueueNoMapper queueNoMapper;

    private HcQueueNoService hcQueueNoService;

    @Override
    public List<HcQueueNo> findQueueNo(QueueNoDictVo queueNoDictVo) {
//        List<HcQueueNo> listAll = new ArrayList<>();
//        for (HcQueueCode queueNoDictVo : queueNoDictVo.getHcQueueCode()) {
//            List<HcQueueNo> list = queueNoMapper.findQueueNo(queueNoDictVo);
//            if (list.size() != 0) {
//                listAll.addAll(list);
//            }
//        }
        List<HcQueueNo> list = queueNoMapper.findQueueNo(queueNoDictVo);
        if (list.size() == 0) {
            list.add(new HcQueueNo());
        }
        return list;
    }

    @Transactional
    @Override
    public void saveQueueNo(SaveQueueNoListVo saveQueueNoList) {
        for (SaveQueueNoVo saveQueueNoVo : saveQueueNoList.getSaveQueueNo()) {
            switch (saveQueueNoVo.getStat()) {
                case "delete" :
                    for (HcQueueNo hcQueueNo : saveQueueNoVo.getHcQueueNo()) {
                        QueryWrapper<HcQueueNo> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("QUEUE_NO",hcQueueNo.getQueueNo());
                        queryWrapper.eq("HOSPITAL_ID",hcQueueNo.getHospitalId());
                        queryWrapper.eq("QUEUE_DATE",hcQueueNo.getQueueDate());
                        queryWrapper.eq("ROOM_CODE",hcQueueNo.getRoomCode());
                        hcQueueNoService.remove(queryWrapper);
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
                    hcQueueNoService.saveBatch(saveQueueNoVo.getHcQueueNo());
                    break;
                case "update" :
                    for (HcQueueNo hcQueueNo : saveQueueNoVo.getHcQueueNo()) {
                        UpdateWrapper<HcQueueNo> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("QUEUE_NO",hcQueueNo.getQueueNo());
                        updateWrapper.eq("HOSPITAL_ID",hcQueueNo.getHospitalId());
                        updateWrapper.eq("QUEUE_DATE",hcQueueNo.getQueueDate());
                        updateWrapper.eq("ROOM_CODE",hcQueueNo.getRoomCode());
                        hcQueueNoService.update(hcQueueNo,updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public List<QueueBigScreenVo> findQueueBigScreen(String hospitalId, String counselNo, String queueDate) {
        List<QueueBigScreenVo> list = queueNoMapper.findQueueBigScreen(hospitalId,counselNo,queueDate);
        if (list.size() == 0) {
            list.add(new QueueBigScreenVo());
        }
        return list;
    }

    @Override
    public List<CallBigScreenVo> findCallBigScreen(String hospitalId, String counselNo) {
        List<CallBigScreenVo> list = queueNoMapper.findCallBigScreen(hospitalId,counselNo);
        if (list.size() == 0) {
            list.add(new CallBigScreenVo());
        }
        return list;
    }

    @Override
    public List<QueueBigScreenVoNew> findQueueBigScreenNew(String hospitalId, String counselNo, String queueDate) {
        List<QueueBigScreenVoNew> list = queueNoMapper.findQueueBigScreenNew(hospitalId,counselNo,queueDate);
        if (list.size() == 0) {
            list.add(new QueueBigScreenVoNew());
        }
        return list;
    }
}
