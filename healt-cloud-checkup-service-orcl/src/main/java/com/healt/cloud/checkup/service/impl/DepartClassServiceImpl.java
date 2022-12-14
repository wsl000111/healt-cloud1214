package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.DepartClass;
import com.healt.cloud.checkup.mapper.DepartClassMapper;
import com.healt.cloud.checkup.service.DepartClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 科室类别 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-03-06
 */
@Service
public class DepartClassServiceImpl extends ServiceImpl<DepartClassMapper, DepartClass> implements DepartClassService {

	private static final long serialVersionUID = 1L;
}
