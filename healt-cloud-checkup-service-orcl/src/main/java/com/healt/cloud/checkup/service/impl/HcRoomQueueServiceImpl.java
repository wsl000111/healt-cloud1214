package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcRoomQueue;
import com.healt.cloud.checkup.mapper.HcRoomQueueMapper;
import com.healt.cloud.checkup.service.HcRoomQueueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 检查室排队队列 本表记录了检查室对应的排队人员，本表只保存当天的记录 服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-06-18
 */
@Service
public class HcRoomQueueServiceImpl extends ServiceImpl<HcRoomQueueMapper, HcRoomQueue> implements HcRoomQueueService {

	private static final long serialVersionUID = 1L;
}
