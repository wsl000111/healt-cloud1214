package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcIntervalRecord;
import com.healt.cloud.checkup.mapper.HcIntervalRecordMapper;
import com.healt.cloud.checkup.service.HcIntervalRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 体检时间间隔记录 本表记录了与体检人员有关的检查室以及进出检查室的时间 服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-06-20
 */
@Service
public class HcIntervalRecordServiceImpl extends ServiceImpl<HcIntervalRecordMapper, HcIntervalRecord> implements HcIntervalRecordService {

	private static final long serialVersionUID = 1L;
}
