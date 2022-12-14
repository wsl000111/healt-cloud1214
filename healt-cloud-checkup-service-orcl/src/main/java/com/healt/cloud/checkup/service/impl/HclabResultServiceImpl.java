package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.service.HclabResultService;
import com.healt.cloud.checkup.entity.HclabResult;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.HclabResultMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 检验结果 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-07-02
 */
@Service
public class HclabResultServiceImpl extends ServiceImpl<HclabResultMapper, HclabResult> implements HclabResultService {

	private static final long serialVersionUID = 1L;
}
