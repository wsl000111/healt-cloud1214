package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcRoomQueue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 检查室排队队列 本表记录了检查室对应的排队人员，本表只保存当天的记录 Mapper 接口
 * </p>
 *
 * @author linklee
 * @since 2022-06-18
 */
@Mapper
public interface HcRoomQueueMapper extends BaseMapper<HcRoomQueue> {

}
