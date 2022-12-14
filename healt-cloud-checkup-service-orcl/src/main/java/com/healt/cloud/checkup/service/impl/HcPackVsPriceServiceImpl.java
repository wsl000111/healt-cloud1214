package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.mapper.HcPackVsPriceMapper;
import com.healt.cloud.checkup.service.HcPackVsPriceService;
import com.healt.cloud.checkup.entity.HcPackVsPrice;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 体检组合项目对照HIS价表项目 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-07-14
 */
@Service
public class HcPackVsPriceServiceImpl extends ServiceImpl<HcPackVsPriceMapper, HcPackVsPrice> implements HcPackVsPriceService {

	private static final long serialVersionUID = 1L;
}
