package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcQuestionDict;
import com.healt.cloud.checkup.mapper.HcQuestionDictMapper;
import com.healt.cloud.checkup.service.HcQuestionDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 健康问卷信息维护 服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-06-10
 */
@Service
public class HcQuestionDictServiceImpl extends ServiceImpl<HcQuestionDictMapper, HcQuestionDict> implements HcQuestionDictService {

	private static final long serialVersionUID = 1L;
}
