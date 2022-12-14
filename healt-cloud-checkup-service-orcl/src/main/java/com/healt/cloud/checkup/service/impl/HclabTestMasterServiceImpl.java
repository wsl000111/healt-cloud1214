package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.service.HclabTestMasterService;
import com.healt.cloud.checkup.entity.HclabTestMaster;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.HclabTestMasterMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 检验主记录 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-07-02
 */
@Service
public class HclabTestMasterServiceImpl extends ServiceImpl<HclabTestMasterMapper, HclabTestMaster> implements HclabTestMasterService {

	private static final long serialVersionUID = 1L;
}
