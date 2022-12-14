package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcPersonInfo;
import com.healt.cloud.checkup.mapper.HcPersonInfoMapper;
import com.healt.cloud.checkup.service.HcPersonInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员信息表 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-07-13
 */
@Service
public class HcPersonInfoServiceImpl extends ServiceImpl<HcPersonInfoMapper, HcPersonInfo> implements HcPersonInfoService {

	private static final long serialVersionUID = 1L;
}
