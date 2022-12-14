package com.healt.cloud.checkup.service.sysDict.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.RoleDict;
import com.healt.cloud.checkup.entity.RoleMenu;
import com.healt.cloud.checkup.mapper.RoleMapper;
import com.healt.cloud.checkup.service.RoleDictService;
import com.healt.cloud.checkup.service.RoleMenuService;
import com.healt.cloud.checkup.vo.HospitalVo;
import com.healt.cloud.checkup.vo.sys.role.*;
import com.healt.cloud.checkup.service.sysDict.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-05 14:17
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleMapper roleMapper;

    private RoleDictService roleDictService;

    private RoleMenuService roleMenuService;

    @Override
    public List<RoleDict> findRoleDict(HospitalVo hospitalVo) {
        QueryWrapper<RoleDict> queryWarpper = new QueryWrapper<>();
        queryWarpper.eq("hospital_id", hospitalVo.getHospitalCode());
        List<RoleDict> list = roleDictService.list(queryWarpper);
        if(list.size() == 0){
            list.add(new RoleDict());
        }
        return list;
    }

    @Override
    public List<MaxRoleCode> createRoleCode(HospitalVo hospitalVo) {
        RoleDict roleDict = roleDictService.getOne(new QueryWrapper<RoleDict>().eq("HOSPITAL_ID", hospitalVo.getHospitalCode()).eq("rownum", 1).orderByDesc("ROLE_ID"));
        MaxRoleCode maxRoleCode = new MaxRoleCode();
        if (roleDict != null) {
            maxRoleCode.setRoleId(roleDict.getRoleId());
        } else {
            maxRoleCode.setRoleId("0");
        }
        List<MaxRoleCode> list = new ArrayList<>();
        list.add(maxRoleCode);
        return list;
    }

    @Override
    @Transactional
    public void saveRoleDict(SaveRoleDictListVo saveRoleDictListVo) {
        for(RoleDictVo roleDictVo : saveRoleDictListVo.getRoleDictList()){
            switch (roleDictVo.getStat()){
                case "delete" :
                    for(RoleDict roleDict : roleDictVo.getRoleDict()){
                        QueryWrapper<RoleDict> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("ROLE_ID", roleDict.getRoleId());
                        queryWrapper.eq("HOSPITAL_ID", roleDict.getHospitalId());
                        roleDictService.remove(queryWrapper);
                    }
                    break;
                case "add":
                    roleDictService.saveBatch(roleDictVo.getRoleDict());
                    break;
                case "update":
                    for(RoleDict roleDict : roleDictVo.getRoleDict()){
                        UpdateWrapper<RoleDict> updateWrapper= new UpdateWrapper<>();
                        updateWrapper.eq("ROLE_ID", roleDict.getRoleId());
                        updateWrapper.eq("HOSPITAL_ID", roleDict.getHospitalId());
                        roleDictService.update(roleDict, updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public List<RoleMenuVoResult> findUnallocatedMenuList(RoleVsMenuVo roleVsMenuVo) {
        List<RoleMenuVoResult> list = roleMapper.findUnallocatedMenuList(roleVsMenuVo);
        if(list.size() == 0){
            list.add(new RoleMenuVoResult());
        }
        return list;
    }

    @Override
    public List<RoleMenuVoResult> findAlreadyMenuList(RoleVsMenuVo roleVsMenuVo) {
        List<RoleMenuVoResult> list = roleMapper.findAlreadyMenuList(roleVsMenuVo);
        if(list.size() == 0){
            list.add(new RoleMenuVoResult());
        }
        return list;
    }

    @Override
    @Transactional
    public void saveRoleMenu(SaveRoleMenuListVo saveRoleMenuListVo) {
        for(RoleMenuVo roleMenuVo : saveRoleMenuListVo.getRoleMenuList()){
            switch (roleMenuVo.getStat()){
                case "delete" :
                    for(RoleMenu roleMenu : roleMenuVo.getRoleMenu()){
                        QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("ROLE_ID", roleMenu.getRoleId());
                        queryWrapper.eq("MENU_CODE", roleMenu.getMenuCode());
                        queryWrapper.eq("HOSPITAL_ID", roleMenu.getHospitalId());
                        roleMenuService.remove(queryWrapper);
                    }
                    break;
                case "add":
                    roleMenuService.saveBatch(roleMenuVo.getRoleMenu());
                    break;
                case "update":
                    for(RoleMenu roleMenu : roleMenuVo.getRoleMenu()){
                        UpdateWrapper<RoleMenu> updateWrapper= new UpdateWrapper<>();
                        updateWrapper.eq("ROLE_ID", roleMenu.getRoleId());
                        updateWrapper.eq("MENU_CODE", roleMenu.getMenuCode());
                        updateWrapper.eq("HOSPITAL_ID", roleMenu.getHospitalId());
                        roleMenuService.update(roleMenu, updateWrapper);
                    }
                    break;
            }
        }
    }

}
