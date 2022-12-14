package com.healt.cloud.checkup.sysDict.controller;

import com.healt.cloud.checkup.sysDict.service.UserRoleAndDeptService;
import com.healt.cloud.checkup.sysDict.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-27 13:27
 */
@RestController
@AllArgsConstructor
@Api(tags = "用户角色及分科接口API")
@RequestMapping("/userRoleAndDept")
public class UserRoleAndDeptController {

    private UserRoleAndDeptService userRoleAndDeptService;

    /**
     * 查找已分配中是否存在(人员角色表)
     * @param hospitalId,userId,roleId
     * @return list
     */
    @ApiOperation(value = "查找已分配中是否存在(人员角色表)，原gridView3_DoubleClick的select方法")
    @GetMapping("/findRoleId/{hospitalId}/{userId}/{roleId}")
    public List findRoleId(@PathVariable String hospitalId,@PathVariable String userId,
                            @PathVariable String roleId){
        return userRoleAndDeptService.findRoleId(hospitalId,userId,roleId);
    }

    /**
     * 插入、删除人员角色表
     * @param saveUserRoleList
     * @return null
     */
    @ApiOperation(value = "插入、删除人员角色表，原gridView3_DoubleClick的insert方法")
    @PostMapping("/saveUserRole")
    public void saveUserRole(@RequestBody SaveUserRoleListVo saveUserRoleList){
        userRoleAndDeptService.saveUserRole(saveUserRoleList);
    }

    /**
     * 查找已分配中是否存在(分科权限表)
     * @param hospitalId,userId,deptId
     * @return list
     */
    @ApiOperation(value = "查找已分配中是否存在(分科权限表)，原gridView5_DoubleClick的select方法")
    @GetMapping("/findDeptId/{hospitalId}/{userId}/{deptId}")
    public List findDeptId(@PathVariable String hospitalId,@PathVariable String userId,
                           @PathVariable String deptId){
        return userRoleAndDeptService.findDeptId(hospitalId,userId,deptId);
    }

    /**
     * 插入、删除医生分科权限表
     * @param saveDoctorDepartRightList
     * @return null
     */
    @ApiOperation(value = "插入、删除医生分科权限表，原gridView5_DoubleClick的select方法")
    @PostMapping("/saveDoctorDepartRight")
    public void saveDoctorDepartRight(@RequestBody SaveDoctorDepartRightListVo saveDoctorDepartRightList){
        userRoleAndDeptService.saveDoctorDepartRight(saveDoctorDepartRightList);
    }

    /**
     * 查询已分配角色
     * @param hospitalId,userId
     * @return list
     */
    @ApiOperation(value = "查询已分配角色，原GetAllocatedRoles的方法")
    @GetMapping("/findAllocatedRoles/{hospitalId}/{userId}")
    public List<AllocatedRolesVo> findAllocatedRoles(@PathVariable String hospitalId, @PathVariable String userId){
        return userRoleAndDeptService.findAllocatedRoles(hospitalId,userId);
    }

    /**
     * 查询未分配角色
     * @param hospitalId,userId
     * @return list
     */
    @ApiOperation(value = "查询未分配角色，原GetUnallocatedRole的方法")
    @GetMapping("/findUnallocatedRoles/{hospitalId}/{userId}")
    public List<UnallocatedRolesVo> findUnallocatedRoles(@PathVariable String hospitalId, @PathVariable String userId){
        return userRoleAndDeptService.findUnallocatedRoles(hospitalId,userId);
    }

    /**
     * 查询已分配科室权限
     * @param hospitalId,userId
     * @return list
     */
    @ApiOperation(value = "查询已分配科室权限，原GetAllocatedDept的方法")
    @GetMapping("/findAllocatedDept/{hospitalId}/{userId}")
    public List<AllocatedDeptVo> findAllocatedDept(@PathVariable String hospitalId, @PathVariable String userId){
        return userRoleAndDeptService.findAllocatedDept(hospitalId,userId);
    }

    /**
     * 查询未分配科室权限
     * @param hospitalId,userId
     * @return list
     */
    @ApiOperation(value = "查询未分配科室权限，原GetUnAllocatedDept的方法")
    @GetMapping("/findUnAllocatedDept/{hospitalId}/{userId}")
    public List<UnAllocatedDeptVo> findUnAllocatedDept(@PathVariable String hospitalId, @PathVariable String userId){
        return userRoleAndDeptService.findUnAllocatedDept(hospitalId,userId);
    }

    /**
     * 取用户列表
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "取用户列表，原GetUserList的方法")
    @GetMapping("/findUserList/{hospitalId}")
    public List<UserListVo> findUserList(@PathVariable String hospitalId){
        return userRoleAndDeptService.findUserList(hospitalId);
    }
}
