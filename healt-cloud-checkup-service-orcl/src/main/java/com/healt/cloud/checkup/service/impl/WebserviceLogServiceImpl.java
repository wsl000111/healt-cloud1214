package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.mapper.WebserviceLogMapper;
import com.healt.cloud.checkup.entity.WebserviceLog;
import com.healt.cloud.checkup.service.WebserviceLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-07-05
 */
@Service
public class WebserviceLogServiceImpl extends ServiceImpl<WebserviceLogMapper, WebserviceLog> implements WebserviceLogService {

	private static final long serialVersionUID = 1L;
}
