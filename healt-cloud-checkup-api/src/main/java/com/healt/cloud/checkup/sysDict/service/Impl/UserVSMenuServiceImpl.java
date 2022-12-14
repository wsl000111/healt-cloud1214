package com.healt.cloud.checkup.sysDict.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.UserRightModels;
import com.healt.cloud.checkup.service.UserRightModelsService;
import com.healt.cloud.checkup.mapper.appointmentReg.UserVSMenuMapper;
import com.healt.cloud.checkup.sysDict.service.UserVSMenuService;
import com.healt.cloud.checkup.sysDict.vo.MenuListVo;
import com.healt.cloud.checkup.sysDict.vo.SaveUserRightModelsListVo;
import com.healt.cloud.checkup.sysDict.vo.SaveUserRightModelsVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-27 17:08
 */
@Service
@AllArgsConstructor
public class UserVSMenuServiceImpl implements UserVSMenuService {

    private UserVSMenuMapper userVSMenuMapper;

    private UserRightModelsService userRightModelsService;

    @Override
    public List<MenuListVo> findAlreadyMenuList(String hospitalId, String userId) {
        List<MenuListVo> list = userVSMenuMapper.findAlreadyMenuList(hospitalId,userId);
        if (list.size() == 0) {
            list.add(new MenuListVo());
        }
        return list;
    }

    @Override
    public List<MenuListVo> findUnallocatedMenuList(String hospitalId, String userId) {
        List<MenuListVo> list = userVSMenuMapper.findUnallocatedMenuList(hospitalId,userId);
        if (list.size() == 0) {
            list.add(new MenuListVo());
        }
        return list;
    }

    @Override
    @Transactional
    public void saveUserRightModels(SaveUserRightModelsListVo saveUserRightModelsList) {
        for (SaveUserRightModelsVo saveUserRightModelsVo : saveUserRightModelsList.getSaveUserRightModels()) {
            switch (saveUserRightModelsVo.getStat()) {
                case "delete" :
                    for (UserRightModels userRightModels : saveUserRightModelsVo.getUserRightModels()) {
                        QueryWrapper<UserRightModels> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID", userRightModels.getHospitalId());
                        queryWrapper.eq("USER_ID", userRightModels.getUserId());
                        queryWrapper.eq("MENU_CODE", userRightModels.getMenuCode());
                        userRightModelsService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    userRightModelsService.saveBatch(saveUserRightModelsVo.getUserRightModels());
                    break;
                case "update" :
                    for (UserRightModels userRightModels : saveUserRightModelsVo.getUserRightModels()) {
                        UpdateWrapper<UserRightModels> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID", userRightModels.getHospitalId());
                        updateWrapper.eq("USER_ID", userRightModels.getUserId());
                        updateWrapper.eq("MENU_CODE", userRightModels.getMenuCode());
                        userRightModelsService.update(userRightModels,updateWrapper);
                    }
                    break;
            }
        }
    }

}
