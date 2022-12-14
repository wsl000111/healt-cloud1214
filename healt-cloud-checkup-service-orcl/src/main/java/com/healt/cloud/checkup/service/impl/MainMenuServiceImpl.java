package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.MainMenu;
import com.healt.cloud.checkup.mapper.MainMenuMapper;
import com.healt.cloud.checkup.service.MainMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 主菜单 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-03-05
 */
@Service
public class MainMenuServiceImpl extends ServiceImpl<MainMenuMapper, MainMenu> implements MainMenuService {

	private static final long serialVersionUID = 1L;
}
