package com.healt.cloud.checkup.queue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcIntervalRecord;
import com.healt.cloud.checkup.queue.mapper.IntervalRecordMapper;
import com.healt.cloud.checkup.queue.service.IntervalRecordService;
import com.healt.cloud.checkup.queue.vo.IntervalRecordDictVo;
import com.healt.cloud.checkup.queue.vo.SaveIntervalRecordListVo;
import com.healt.cloud.checkup.queue.vo.SaveIntervalRecordVo;
import com.healt.cloud.checkup.service.HcIntervalRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 17:22
 */
@Service
@AllArgsConstructor
public class IntervalRecordServiceImpl implements IntervalRecordService {

    private IntervalRecordMapper intervalRecordMapper;

    private HcIntervalRecordService hcIntervalRecordService;

    @Override
    public List<HcIntervalRecord> findIntervalRecord(IntervalRecordDictVo intervalRecordDictVo) {
        List<HcIntervalRecord> list = intervalRecordMapper.findIntervalRecord(intervalRecordDictVo);
        if (list.size() == 0) {
            list.add(new HcIntervalRecord());
        }
        return list;
    }

    @Transactional
    @Override
    public void saveIntervalRecord(SaveIntervalRecordListVo saveIntervalRecordList) {
        for (SaveIntervalRecordVo saveIntervalRecordVo : saveIntervalRecordList.getSaveIntervalRecord()) {
            switch (saveIntervalRecordVo.getStat()) {
                case "delete" :
                    for (HcIntervalRecord hcIntervalRecord : saveIntervalRecordVo.getHcIntervalRecord()) {
                        QueryWrapper<HcIntervalRecord> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID",hcIntervalRecord.getHospitalId());
                        queryWrapper.eq("ROOM_CODE",hcIntervalRecord.getRoomCode());
                        queryWrapper.eq("PERSON_ID",hcIntervalRecord.getPersonId());
                        queryWrapper.eq("PERSON_VISIT_ID",hcIntervalRecord.getPersonVisitId());
                        queryWrapper.eq("QUEUE_NO",hcIntervalRecord.getQueueNo());
                        hcIntervalRecordService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    hcIntervalRecordService.saveBatch(saveIntervalRecordVo.getHcIntervalRecord());
                    break;
                case "update" :
                    for (HcIntervalRecord hcIntervalRecord : saveIntervalRecordVo.getHcIntervalRecord()) {
                        UpdateWrapper<HcIntervalRecord> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID",hcIntervalRecord.getHospitalId());
                        updateWrapper.eq("ROOM_CODE",hcIntervalRecord.getRoomCode());
                        updateWrapper.eq("PERSON_ID",hcIntervalRecord.getPersonId());
                        updateWrapper.eq("PERSON_VISIT_ID",hcIntervalRecord.getPersonVisitId());
                        updateWrapper.eq("QUEUE_NO",hcIntervalRecord.getQueueNo());
                        hcIntervalRecordService.update(hcIntervalRecord,updateWrapper);
                    }
                    break;
            }
        }
    }
}
