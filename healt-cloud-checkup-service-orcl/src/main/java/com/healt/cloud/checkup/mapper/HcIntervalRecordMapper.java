package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcIntervalRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 体检时间间隔记录 本表记录了与体检人员有关的检查室以及进出检查室的时间 Mapper 接口
 * </p>
 *
 * @author linklee
 * @since 2022-06-20
 */
@Mapper
public interface HcIntervalRecordMapper extends BaseMapper<HcIntervalRecord> {

}
