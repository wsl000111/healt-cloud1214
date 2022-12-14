package com.healt.cloud.checkup.queue.mapper;

import com.healt.cloud.checkup.entity.HcIntervalRecord;
import com.healt.cloud.checkup.queue.vo.IntervalRecordDictVo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 17:22
 */
@Mapper
public interface IntervalRecordMapper {

    List<HcIntervalRecord> findIntervalRecord(IntervalRecordDictVo intervalRecordDictVo);
}
