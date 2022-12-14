package com.healt.cloud.checkup.queue.service;

import com.healt.cloud.checkup.entity.HcIntervalRecord;
import com.healt.cloud.checkup.queue.vo.IntervalRecordDictVo;
import com.healt.cloud.checkup.queue.vo.SaveIntervalRecordListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 17:21
 */
public interface IntervalRecordService {

    public List<HcIntervalRecord> findIntervalRecord(IntervalRecordDictVo intervalRecordDictVo);

    public void saveIntervalRecord(SaveIntervalRecordListVo saveIntervalRecordList);

}
