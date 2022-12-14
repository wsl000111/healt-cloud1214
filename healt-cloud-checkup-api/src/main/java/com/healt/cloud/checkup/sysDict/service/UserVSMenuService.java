package com.healt.cloud.checkup.sysDict.service;

import com.healt.cloud.checkup.sysDict.vo.MenuListVo;
import com.healt.cloud.checkup.sysDict.vo.SaveUserRightModelsListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-27 17:08
 */
public interface UserVSMenuService {

    public List<MenuListVo> findAlreadyMenuList(String hospitalId, String userId);

    public List<MenuListVo> findUnallocatedMenuList(String hospitalId, String userId);

    public void saveUserRightModels(SaveUserRightModelsListVo saveUserRightModelsList);
}
