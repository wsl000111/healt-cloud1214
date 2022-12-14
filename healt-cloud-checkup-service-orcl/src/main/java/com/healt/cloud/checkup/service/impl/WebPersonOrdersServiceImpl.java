package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.WebPersonOrders;
import com.healt.cloud.checkup.service.WebPersonOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.WebPersonOrdersMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-09-24
 */
@Service
public class WebPersonOrdersServiceImpl extends ServiceImpl<WebPersonOrdersMapper, WebPersonOrders> implements WebPersonOrdersService {

	private static final long serialVersionUID = 1L;
}
