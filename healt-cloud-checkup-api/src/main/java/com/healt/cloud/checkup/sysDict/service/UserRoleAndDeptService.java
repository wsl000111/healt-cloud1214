package com.healt.cloud.checkup.sysDict.service;

import com.healt.cloud.checkup.sysDict.vo.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-27 13:29
 */
public interface UserRoleAndDeptService {

    public List findRoleId(String hospitalId, String userId, String roleId);

    public void saveUserRole(SaveUserRoleListVo saveUserRoleList);

    public List findDeptId(String hospitalId, String userId, String deptId);

    public void saveDoctorDepartRight(SaveDoctorDepartRightListVo saveDoctorDepartRightList);

    public List<AllocatedRolesVo> findAllocatedRoles(String hospitalId, String userId);

    public List<UnallocatedRolesVo> findUnallocatedRoles(String hospitalId, String userId);

    public List<AllocatedDeptVo> findAllocatedDept(String hospitalId, String userId);

    public List<UnAllocatedDeptVo> findUnAllocatedDept(String hospitalId, String userId);

    public List<UserListVo> findUserList(String hospitalId);
}
