package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.UsersDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 系统用户信息 Mapper 接口
 * </p>
 *
 * @author GuYue
 * @since 2022-03-07
 */
@Mapper
public interface UsersDictMapper extends BaseMapper<UsersDict> {

}
