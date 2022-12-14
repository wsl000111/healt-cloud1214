package com.healt.cloud.checkup.service.impl;

import com.healt.cloud.checkup.entity.UsersDict;
import com.healt.cloud.checkup.mapper.UsersDictMapper;
import com.healt.cloud.checkup.service.UsersDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户信息 服务实现类
 * </p>
 *
 * @author GuYue
 * @since 2022-03-07
 */
@Service
public class UsersDictServiceImpl extends ServiceImpl<UsersDictMapper, UsersDict> implements UsersDictService {

	private static final long serialVersionUID = 1L;
}
