package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.InterfaceSource;
import com.healt.cloud.checkup.mapper.InterfaceSourceMapper;
import com.healt.cloud.checkup.service.InterfaceSourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 接口库定义 服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-05-03
 */
@Service
public class InterfaceSourceServiceImpl extends ServiceImpl<InterfaceSourceMapper, InterfaceSource> implements InterfaceSourceService {

	private static final long serialVersionUID = 1L;
}
