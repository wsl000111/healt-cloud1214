package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcInvestResult;
import com.healt.cloud.checkup.mapper.HcInvestResultMapper;
import com.healt.cloud.checkup.service.HcInvestResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 体检人员问卷结果表 服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-06-13
 */
@Service
public class HcInvestResultServiceImpl extends ServiceImpl<HcInvestResultMapper, HcInvestResult> implements HcInvestResultService {

	private static final long serialVersionUID = 1L;
}
