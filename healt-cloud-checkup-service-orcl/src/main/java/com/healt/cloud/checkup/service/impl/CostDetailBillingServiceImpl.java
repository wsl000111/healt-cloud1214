package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.CostDetailBilling;
import com.healt.cloud.checkup.service.CostDetailBillingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.CostDetailBillingMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 体检传HIS收费临时表 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-08-01
 */
@Service
public class CostDetailBillingServiceImpl extends ServiceImpl<CostDetailBillingMapper, CostDetailBilling> implements CostDetailBillingService {

	private static final long serialVersionUID = 1L;
}
