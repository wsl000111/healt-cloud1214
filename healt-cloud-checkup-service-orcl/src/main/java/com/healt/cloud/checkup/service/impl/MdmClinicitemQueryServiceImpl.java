package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.MdmClinicitemQuery;
import com.healt.cloud.checkup.service.MdmClinicitemQueryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.MdmClinicitemQueryMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * HIS诊疗项目信息查询 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-07-03
 */
@Service
public class MdmClinicitemQueryServiceImpl extends ServiceImpl<MdmClinicitemQueryMapper, MdmClinicitemQuery> implements MdmClinicitemQueryService {

	private static final long serialVersionUID = 1L;
}
