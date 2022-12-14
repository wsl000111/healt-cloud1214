package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.CompanyCostBack;
import com.healt.cloud.checkup.service.CompanyCostBackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.CompanyCostBackMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 体检单位传HIS收费临时表 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-09-02
 */
@Service
public class CompanyCostBackServiceImpl extends ServiceImpl<CompanyCostBackMapper, CompanyCostBack> implements CompanyCostBackService {

	private static final long serialVersionUID = 1L;
}
