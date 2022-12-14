package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcExamItems;
import com.healt.cloud.checkup.mapper.HcExamItemsMapper;
import com.healt.cloud.checkup.service.HcExamItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 检查项目记录 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-07-02
 */
@Service
public class HcExamItemsServiceImpl extends ServiceImpl<HcExamItemsMapper, HcExamItems> implements HcExamItemsService {

	private static final long serialVersionUID = 1L;
}
