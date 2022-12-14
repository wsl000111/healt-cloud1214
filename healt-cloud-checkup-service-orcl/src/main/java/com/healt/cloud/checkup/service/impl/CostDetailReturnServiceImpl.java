package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.CostDetailReturn;
import com.healt.cloud.checkup.service.CostDetailReturnService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.CostDetailReturnMapper;
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
public class CostDetailReturnServiceImpl extends ServiceImpl<CostDetailReturnMapper, CostDetailReturn> implements CostDetailReturnService {

	private static final long serialVersionUID = 1L;
}
