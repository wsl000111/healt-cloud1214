package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcDeptResultItems;
import com.healt.cloud.checkup.mapper.HcDeptResultItemsMapper;
import com.healt.cloud.checkup.service.HcDeptResultItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 体检分科结果明细记录 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-05-23
 */
@Service
public class HcDeptResultItemsServiceImpl extends ServiceImpl<HcDeptResultItemsMapper, HcDeptResultItems> implements HcDeptResultItemsService {

	private static final long serialVersionUID = 1L;
}
