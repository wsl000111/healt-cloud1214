package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.HcExamReport;
import com.healt.cloud.checkup.mapper.HcExamReportMapper;
import com.healt.cloud.checkup.service.HcExamReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 检查报告 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-07-02
 */
@Service
public class HcExamReportServiceImpl extends ServiceImpl<HcExamReportMapper, HcExamReport> implements HcExamReportService {

	private static final long serialVersionUID = 1L;
}
