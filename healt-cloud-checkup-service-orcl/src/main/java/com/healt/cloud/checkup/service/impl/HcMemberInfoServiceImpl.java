package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcMemberInfo;
import com.healt.cloud.checkup.mapper.HcMemberInfoMapper;
import com.healt.cloud.checkup.service.HcMemberInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员卡 服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-04-09
 */
@Service
public class HcMemberInfoServiceImpl extends ServiceImpl<HcMemberInfoMapper, HcMemberInfo> implements HcMemberInfoService {

	private static final long serialVersionUID = 1L;
}
