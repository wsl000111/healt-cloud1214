package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.CostChargeStateMaster;
import com.healt.cloud.checkup.service.CostChargeStateMasterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.CostChargeStateMasterMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * HIS计费返回的收费状态主表 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-08-11
 */
@Service
public class CostChargeStateMasterServiceImpl extends ServiceImpl<CostChargeStateMasterMapper, CostChargeStateMaster> implements CostChargeStateMasterService {

	private static final long serialVersionUID = 1L;
}
