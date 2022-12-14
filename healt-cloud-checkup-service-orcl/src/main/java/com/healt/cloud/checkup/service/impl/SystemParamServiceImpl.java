package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.SystemParam;
import com.healt.cloud.checkup.mapper.SystemParamMapper;
import com.healt.cloud.checkup.service.SystemParamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统参数表 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-04-07
 */
@Service
public class SystemParamServiceImpl extends ServiceImpl<SystemParamMapper, SystemParam> implements SystemParamService {

	private static final long serialVersionUID = 1L;
}
