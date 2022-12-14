package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.DepartDict;
import com.healt.cloud.checkup.mapper.DepartDictMapper;
import com.healt.cloud.checkup.service.DepartDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 科室定义 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-03-06
 */
@Service
public class DepartDictServiceImpl extends ServiceImpl<DepartDictMapper, DepartDict> implements DepartDictService {

	private static final long serialVersionUID = 1L;
}
