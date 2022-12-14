package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.VClinicItems;
import com.healt.cloud.checkup.mapper.VClinicItemsMapper;
import com.healt.cloud.checkup.service.VClinicItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-03-16
 */
@Service
public class VClinicItemsServiceImpl extends ServiceImpl<VClinicItemsMapper, VClinicItems> implements VClinicItemsService {

	private static final long serialVersionUID = 1L;
}
