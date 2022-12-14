package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.RoleMenu;
import com.healt.cloud.checkup.mapper.RoleMenuMapper;
import com.healt.cloud.checkup.service.RoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色菜单 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-03-05
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

	private static final long serialVersionUID = 1L;
}
