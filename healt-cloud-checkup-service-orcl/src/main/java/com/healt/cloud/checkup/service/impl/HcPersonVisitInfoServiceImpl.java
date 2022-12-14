package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcPersonVisitInfo;
import com.healt.cloud.checkup.mapper.HcPersonVisitInfoMapper;
import com.healt.cloud.checkup.service.HcPersonVisitInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 个人体检信息 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-07-14
 */
@Service
public class HcPersonVisitInfoServiceImpl extends ServiceImpl<HcPersonVisitInfoMapper, HcPersonVisitInfo> implements HcPersonVisitInfoService {

	private static final long serialVersionUID = 1L;
}
