package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcMemberTrans;
import com.healt.cloud.checkup.mapper.HcMemberTransMapper;
import com.healt.cloud.checkup.service.HcMemberTransService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员卡交易记录 服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-04-26
 */
@Service
public class HcMemberTransServiceImpl extends ServiceImpl<HcMemberTransMapper, HcMemberTrans> implements HcMemberTransService {

	private static final long serialVersionUID = 1L;
}
