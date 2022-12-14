package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.WebUserInfoBind;
import com.healt.cloud.checkup.service.WebUserInfoBindService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.healt.cloud.checkup.mapper.WebUserInfoBindMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 体检人绑定关系表 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-10-16
 */
@Service
public class WebUserInfoBindServiceImpl extends ServiceImpl<WebUserInfoBindMapper, WebUserInfoBind> implements WebUserInfoBindService {

	private static final long serialVersionUID = 1L;
}
