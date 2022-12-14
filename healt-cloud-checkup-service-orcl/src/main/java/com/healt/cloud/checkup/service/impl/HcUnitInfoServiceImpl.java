package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcUnitInfo;
import com.healt.cloud.checkup.service.HcUnitInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.HcUnitInfoMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 单位信息 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-09-02
 */
@Service
public class HcUnitInfoServiceImpl extends ServiceImpl<HcUnitInfoMapper, HcUnitInfo> implements HcUnitInfoService {

	private static final long serialVersionUID = 1L;
}
