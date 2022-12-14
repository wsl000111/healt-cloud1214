package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.ClinicItemEntity;
import com.healt.cloud.checkup.service.ClinicItemEntityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.ClinicItemEntityMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * HIS诊疗项目信息查询 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-07-03
 */
@Service
public class ClinicItemEntityServiceImpl extends ServiceImpl<ClinicItemEntityMapper, ClinicItemEntity> implements ClinicItemEntityService {

	private static final long serialVersionUID = 1L;
}
