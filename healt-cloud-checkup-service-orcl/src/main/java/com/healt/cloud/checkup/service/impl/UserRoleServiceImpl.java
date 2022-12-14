package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.UserRole;
import com.healt.cloud.checkup.mapper.UserRoleMapper;
import com.healt.cloud.checkup.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员角色 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-03-05
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

	private static final long serialVersionUID = 1L;
}
