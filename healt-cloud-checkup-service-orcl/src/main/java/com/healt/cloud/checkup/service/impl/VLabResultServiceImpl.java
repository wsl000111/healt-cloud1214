package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.VLabResult;
import com.healt.cloud.checkup.mapper.VLabResultMapper;
import com.healt.cloud.checkup.service.VLabResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-05-23
 */
@Service
public class VLabResultServiceImpl extends ServiceImpl<VLabResultMapper, VLabResult> implements VLabResultService {

	private static final long serialVersionUID = 1L;
}
