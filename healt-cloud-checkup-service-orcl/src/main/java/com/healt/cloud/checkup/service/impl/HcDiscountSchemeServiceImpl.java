package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcDiscountScheme;
import com.healt.cloud.checkup.mapper.HcDiscountSchemeMapper;
import com.healt.cloud.checkup.service.HcDiscountSchemeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 打折方案主表 服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-05-03
 */
@Service
public class HcDiscountSchemeServiceImpl extends ServiceImpl<HcDiscountSchemeMapper, HcDiscountScheme> implements HcDiscountSchemeService {

	private static final long serialVersionUID = 1L;
}
