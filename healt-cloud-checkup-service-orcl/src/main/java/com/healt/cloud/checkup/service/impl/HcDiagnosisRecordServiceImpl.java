package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcDiagnosisRecord;
import com.healt.cloud.checkup.mapper.HcDiagnosisRecordMapper;
import com.healt.cloud.checkup.service.HcDiagnosisRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 体检诊断记录 服务实现类
 * </p>
 *
 * @author linklee
 * @since 2022-05-29
 */
@Service
public class HcDiagnosisRecordServiceImpl extends ServiceImpl<HcDiagnosisRecordMapper, HcDiagnosisRecord> implements HcDiagnosisRecordService {

	private static final long serialVersionUID = 1L;
}
