package com.healt.cloud.checkup.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.entity.WebUserInfo;
import com.healt.cloud.checkup.mapper.WebUserInfoMapper;
import com.healt.cloud.checkup.service.WebUserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-09-27
 */
@Service
public class WebUserInfoServiceImpl extends ServiceImpl<WebUserInfoMapper, WebUserInfo> implements WebUserInfoService {

	private static final long serialVersionUID = 1L;
}
