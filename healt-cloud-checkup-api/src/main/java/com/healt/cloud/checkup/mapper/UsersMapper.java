package com.healt.cloud.checkup.mapper;

import com.healt.cloud.checkup.vo.UserMenuRightVoResult;
import com.healt.cloud.checkup.vo.sys.user.UsersVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-05 14:14
 * @description: 自定义用户Mapper
 */
@Mapper
public interface UsersMapper {
    List<UserMenuRightVoResult> findUserMenuRight(UsersVo usersVo);
}
