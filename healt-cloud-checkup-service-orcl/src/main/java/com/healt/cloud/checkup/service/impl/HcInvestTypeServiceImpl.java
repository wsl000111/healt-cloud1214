package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcInvestType;
import com.healt.cloud.checkup.mapper.HcInvestTypeMapper;
import com.healt.cloud.checkup.service.HcInvestTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 健康问卷名称字典 服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-06-13
 */
@Service
public class HcInvestTypeServiceImpl extends ServiceImpl<HcInvestTypeMapper, HcInvestType> implements HcInvestTypeService {

	private static final long serialVersionUID = 1L;
}
