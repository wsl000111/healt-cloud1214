package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.CommonDict;
import com.healt.cloud.checkup.mapper.CommonDictMapper;
import com.healt.cloud.checkup.service.CommonDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公共字典 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-03-09
 */
@Service
public class CommonDictServiceImpl extends ServiceImpl<CommonDictMapper, CommonDict> implements CommonDictService {

	private static final long serialVersionUID = 1L;
}
