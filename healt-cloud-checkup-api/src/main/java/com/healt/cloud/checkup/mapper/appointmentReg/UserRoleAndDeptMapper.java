package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.entity.UserRole;
import com.healt.cloud.checkup.sysDict.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-27 13:33
 */
@Mapper
public interface UserRoleAndDeptMapper {

    String findRoleId(@Param("hospitalId") String hospitalId,@Param("userId") String userId,@Param("roleId") String roleId);

    String findDeptId(@Param("hospitalId") String hospitalId,@Param("userId") String userId,@Param("deptId") String deptId);

    List<AllocatedRolesVo> findAllocatedRoles(@Param("hospitalId") String hospitalId, @Param("userId") String userId);

    List<UnallocatedRolesVo> findUnallocatedRoles(@Param("hospitalId") String hospitalId, @Param("userId") String userId);

    List<AllocatedDeptVo> findAllocatedDept(@Param("hospitalId") String hospitalId, @Param("userId") String userId);

    List<UnAllocatedDeptVo> findUnAllocatedDept(@Param("hospitalId") String hospitalId, @Param("userId") String userId);

    void deleteUserRole(UserRole userRole);

    void addUserRole(UserRole userRole);

    List<UserListVo> findUserList(@Param("hospitalId") String hospitalId);
}
