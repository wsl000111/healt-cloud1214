package com.healt.cloud.checkup.service;

import com.healt.cloud.checkup.entity.VUsersDict;
import com.healt.cloud.checkup.vo.sys.user.SaveUsersDictListVo;
import com.healt.cloud.checkup.vo.sys.user.UsersVo;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-05 14:17
 * @description: TODO
 */
public interface UserService {

    List<VUsersDict> findUsersDict(UsersVo usersVo);

    void saveUsersDict(SaveUsersDictListVo saveUsersDictListVo);

    List<VUsersDict> getVUsersDict(String userId);

    void updatePassword(String userId, String password);

    void reloadUsersDict(String deptName);
}
