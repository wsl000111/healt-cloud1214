package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcQueueNo;
import com.healt.cloud.checkup.mapper.HcQueueNoMapper;
import com.healt.cloud.checkup.service.HcQueueNoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 本表记录体检人员报到的顺序号，唯一对应一个体检人员。 服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-06-18
 */
@Service
public class HcQueueNoServiceImpl extends ServiceImpl<HcQueueNoMapper, HcQueueNo> implements HcQueueNoService {

	private static final long serialVersionUID = 1L;
}
