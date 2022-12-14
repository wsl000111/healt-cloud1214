package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcRcptPay;
import com.healt.cloud.checkup.mapper.HcRcptPayMapper;
import com.healt.cloud.checkup.service.HcRcptPayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付表 服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-04-24
 */
@Service
public class HcRcptPayServiceImpl extends ServiceImpl<HcRcptPayMapper, HcRcptPay> implements HcRcptPayService {

	private static final long serialVersionUID = 1L;
}
