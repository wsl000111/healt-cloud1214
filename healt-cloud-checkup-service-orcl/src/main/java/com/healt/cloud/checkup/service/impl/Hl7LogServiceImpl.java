package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.Hl7Log;
import com.healt.cloud.checkup.service.Hl7LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.Hl7LogMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-08-29
 */
@Service
public class Hl7LogServiceImpl extends ServiceImpl<Hl7LogMapper, Hl7Log> implements Hl7LogService {

	private static final long serialVersionUID = 1L;
}
