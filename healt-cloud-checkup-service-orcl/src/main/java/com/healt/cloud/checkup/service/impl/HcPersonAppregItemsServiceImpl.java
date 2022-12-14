package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcPersonAppregItems;
import com.healt.cloud.checkup.service.HcPersonAppregItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.HcPersonAppregItemsMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员预约项目表 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-09-02
 */
@Service
public class HcPersonAppregItemsServiceImpl extends ServiceImpl<HcPersonAppregItemsMapper, HcPersonAppregItems> implements HcPersonAppregItemsService {

	private static final long serialVersionUID = 1L;
}
