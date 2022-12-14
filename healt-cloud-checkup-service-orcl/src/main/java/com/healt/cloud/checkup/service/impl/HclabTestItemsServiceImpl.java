package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HclabTestItems;
import com.healt.cloud.checkup.service.HclabTestItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.HclabTestItemsMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 检验项目 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-07-02
 */
@Service
public class HclabTestItemsServiceImpl extends ServiceImpl<HclabTestItemsMapper, HclabTestItems> implements HclabTestItemsService {

	private static final long serialVersionUID = 1L;
}
