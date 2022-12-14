package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HealtUpdateLog;
import com.healt.cloud.checkup.mapper.HealtUpdateLogMapper;
import com.healt.cloud.checkup.service.HealtUpdateLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 模块上传下载日志 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-06-10
 */
@Service
public class HealtUpdateLogServiceImpl extends ServiceImpl<HealtUpdateLogMapper, HealtUpdateLog> implements HealtUpdateLogService {

	private static final long serialVersionUID = 1L;
}
