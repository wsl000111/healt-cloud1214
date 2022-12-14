package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcResultDict;
import com.healt.cloud.checkup.mapper.HcResultDictMapper;
import com.healt.cloud.checkup.service.HcResultDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 体检项目结果记录 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-05-23
 */
@Service
public class HcResultDictServiceImpl extends ServiceImpl<HcResultDictMapper, HcResultDict> implements HcResultDictService {

	private static final long serialVersionUID = 1L;
}
