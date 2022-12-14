package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.AccountsChargeBack;
import com.healt.cloud.checkup.service.AccountsChargeBackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.AccountsChargeBackMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 团检收费状态回传表 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-09-03
 */
@Service
public class AccountsChargeBackServiceImpl extends ServiceImpl<AccountsChargeBackMapper, AccountsChargeBack> implements AccountsChargeBackService {

	private static final long serialVersionUID = 1L;
}
