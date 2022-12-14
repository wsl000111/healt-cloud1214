package com.healt.cloud.checkup.service;

import com.healt.cloud.checkup.entity.HcRoomQueue;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 检查室排队队列 本表记录了检查室对应的排队人员，本表只保存当天的记录 服务类
 * </p>
 *
 * @author linklee
 * @since 2022-06-18
 */
public interface HcRoomQueueService extends IService<HcRoomQueue> {

}
