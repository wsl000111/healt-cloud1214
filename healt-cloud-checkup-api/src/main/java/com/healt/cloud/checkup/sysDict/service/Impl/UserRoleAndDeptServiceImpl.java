package com.healt.cloud.checkup.sysDict.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.DoctorDepartRight;
import com.healt.cloud.checkup.entity.UserRole;
import com.healt.cloud.checkup.service.DoctorDepartRightService;
import com.healt.cloud.checkup.service.UserRoleService;
import com.healt.cloud.checkup.mapper.appointmentReg.UserRoleAndDeptMapper;
import com.healt.cloud.checkup.sysDict.service.UserRoleAndDeptService;
import com.healt.cloud.checkup.sysDict.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linklee
 * @create 2022-05-27 13:29
 */
@Service
@AllArgsConstructor
public class UserRoleAndDeptServiceImpl implements UserRoleAndDeptService {

    private UserRoleAndDeptMapper userRoleAndDeptMapper;

    private UserRoleService userRoleService;

    private DoctorDepartRightService doctorDepartRightService;

    @Override
    public List findRoleId(String hospitalId, String userId, String roleId) {
        String str = userRoleAndDeptMapper.findRoleId(hospitalId,userId,roleId);
        if (str == null) {
            str = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("role_id",str);
        list.add(map);
        return list;
    }

    @Override
    @Transactional
    public void saveUserRole(SaveUserRoleListVo saveUserRoleList) {
        for (SaveUserRoleVo saveUserRoleVo : saveUserRoleList.getSaveUserRole()) {
            switch (saveUserRoleVo.getStat()) {
                case "delete" :
                    for (UserRole userRole : saveUserRoleVo.getUserRole()) {
                        userRoleAndDeptMapper.deleteUserRole(userRole);
                    }
                    break;
                case "add" :
                    for (UserRole userRole : saveUserRoleVo.getUserRole()) {
                        userRoleAndDeptMapper.addUserRole(userRole);
                    }
                    break;
                case "update" :
                    for (UserRole userRole : saveUserRoleVo.getUserRole()) {
                        UpdateWrapper<UserRole> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID", userRole.getHospitalId());
                        updateWrapper.eq("USER_ID", userRole.getUserId());
                        updateWrapper.eq("ROLE_ID", userRole.getRoleId());
                        userRoleService.update(userRole,updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public List findDeptId(String hospitalId, String userId, String deptId) {
        String str = userRoleAndDeptMapper.findDeptId(hospitalId,userId,deptId);
        if (str == null) {
            str = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("dept_id",str);
        list.add(map);
        return list;
    }

    @Override
    @Transactional
    public void saveDoctorDepartRight(SaveDoctorDepartRightListVo saveDoctorDepartRightList) {
        for (SaveDoctorDepartRightVo saveDoctorDepartRightVo : saveDoctorDepartRightList.getSaveDoctorDepartRight()) {
            switch (saveDoctorDepartRightVo.getStat()) {
                case "delete" :
                    for (DoctorDepartRight doctorDepartRight : saveDoctorDepartRightVo.getDoctorDepartRight()) {
                        QueryWrapper<DoctorDepartRight> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID", doctorDepartRight.getHospitalId());
                        queryWrapper.eq("USER_ID", doctorDepartRight.getUserId());
                        queryWrapper.eq("DEPT_ID", doctorDepartRight.getDeptId());
                        doctorDepartRightService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    doctorDepartRightService.saveBatch(saveDoctorDepartRightVo.getDoctorDepartRight());
                    break;
                case "update" :
                    for (DoctorDepartRight doctorDepartRight : saveDoctorDepartRightVo.getDoctorDepartRight()) {
                        UpdateWrapper<DoctorDepartRight> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID", doctorDepartRight.getHospitalId());
                        updateWrapper.eq("USER_ID", doctorDepartRight.getUserId());
                        updateWrapper.eq("DEPT_ID", doctorDepartRight.getDeptId());
                        doctorDepartRightService.update(doctorDepartRight,updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public List<AllocatedRolesVo> findAllocatedRoles(String hospitalId, String userId) {
        List<AllocatedRolesVo> list = userRoleAndDeptMapper.findAllocatedRoles(hospitalId,userId);
        if (list.size() == 0) {
            list.add(new AllocatedRolesVo());
        }
        return list;
    }

    @Override
    public List<UnallocatedRolesVo> findUnallocatedRoles(String hospitalId, String userId) {
        List<UnallocatedRolesVo> list = userRoleAndDeptMapper.findUnallocatedRoles(hospitalId,userId);
        if (list.size() == 0) {
            list.add(new UnallocatedRolesVo());
        }
        return list;
    }

    @Override
    public List<AllocatedDeptVo> findAllocatedDept(String hospitalId, String userId) {
        List<AllocatedDeptVo> list = userRoleAndDeptMapper.findAllocatedDept(hospitalId,userId);
        if (list.size() == 0) {
            list.add(new AllocatedDeptVo());
        }
        return list;
    }

    @Override
    public List<UnAllocatedDeptVo> findUnAllocatedDept(String hospitalId, String userId) {
        List<UnAllocatedDeptVo> list = userRoleAndDeptMapper.findUnAllocatedDept(hospitalId,userId);
        if (list.size() == 0) {
            list.add(new UnAllocatedDeptVo());
        }
        return list;
    }

    @Override
    public List<UserListVo> findUserList(String hospitalId) {
        List<UserListVo> list = userRoleAndDeptMapper.findUserList(hospitalId);
        if (list.size() == 0) {
            list.add(new UserListVo());
        }
        return list;
    }
}
