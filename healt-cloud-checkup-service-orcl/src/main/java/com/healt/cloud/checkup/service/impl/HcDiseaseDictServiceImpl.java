package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcDiseaseDict;
import com.healt.cloud.checkup.mapper.HcDiseaseDictMapper;
import com.healt.cloud.checkup.service.HcDiseaseDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 体检疾病诊断字典 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-05-30
 */
@Service
public class HcDiseaseDictServiceImpl extends ServiceImpl<HcDiseaseDictMapper, HcDiseaseDict> implements HcDiseaseDictService {

	private static final long serialVersionUID = 1L;
}
