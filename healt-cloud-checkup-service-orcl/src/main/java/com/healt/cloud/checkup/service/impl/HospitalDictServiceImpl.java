package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HospitalDict;
import com.healt.cloud.checkup.mapper.HospitalDictMapper;
import com.healt.cloud.checkup.service.HospitalDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 机构代码表 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-03-05
 */
@Service
public class HospitalDictServiceImpl extends ServiceImpl<HospitalDictMapper, HospitalDict> implements HospitalDictService {

	private static final long serialVersionUID = 1L;
}
