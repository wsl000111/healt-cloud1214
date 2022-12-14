package com.healt.cloud.checkup.controller.sysDict;

import com.healt.cloud.checkup.entity.RoleDict;
import com.healt.cloud.checkup.service.sysDict.RoleService;
import com.healt.cloud.checkup.vo.HospitalVo;
import com.healt.cloud.checkup.vo.sys.role.*;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-06 13:27
 * @description: TODO
 */
@RestController
@Api(tags = "角色管理接口API")
@AllArgsConstructor
@RequestMapping("/role")
public class RoleDictController {

    private RoleService roleService;

    @PostMapping("/getRoleRecord")
    private List<RoleDict> getRoleRecord(@RequestBody HospitalVo hospitalVo){
        return roleService.findRoleDict(hospitalVo);
    }
    @PostMapping("/createRoleCode")
    private List<MaxRoleCode> createRoleCode(@RequestBody HospitalVo hospitalVo){
        return roleService.createRoleCode(hospitalVo);
    }

    @PostMapping("/saveRoleDict")
    private void saveRoleDict(@RequestBody SaveRoleDictListVo saveRoleDictListVo){
        roleService.saveRoleDict(saveRoleDictListVo);
    }

    @PostMapping("/getUnallocatedMenuList")
    private List<RoleMenuVoResult> getUnallocatedMenuList(@RequestBody RoleVsMenuVo roleVsMenuVo){
        return roleService.findUnallocatedMenuList(roleVsMenuVo);
    }

    @PostMapping("/getAlreadyMenuList")
    private List<RoleMenuVoResult> getAlreadyMenuList(@RequestBody RoleVsMenuVo roleVsMenuVo){
        return roleService.findAlreadyMenuList(roleVsMenuVo);
    }

    @PostMapping("/saveRoleMenu")
    private void saveRoleMenu(@RequestBody SaveRoleMenuListVo saveRoleMenuListVo){
        roleService.saveRoleMenu(saveRoleMenuListVo);
    }

}
