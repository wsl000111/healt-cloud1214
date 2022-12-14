package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcChangeitemLog;
import com.healt.cloud.checkup.mapper.HcChangeitemLogMapper;
import com.healt.cloud.checkup.service.HcChangeitemLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 换项日志表 服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-05-16
 */
@Service
public class HcChangeitemLogServiceImpl extends ServiceImpl<HcChangeitemLogMapper, HcChangeitemLog> implements HcChangeitemLogService {

	private static final long serialVersionUID = 1L;
}
