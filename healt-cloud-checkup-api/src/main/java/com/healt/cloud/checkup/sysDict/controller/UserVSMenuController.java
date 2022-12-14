package com.healt.cloud.checkup.sysDict.controller;

import com.healt.cloud.checkup.sysDict.service.UserVSMenuService;
import com.healt.cloud.checkup.sysDict.vo.MenuListVo;
import com.healt.cloud.checkup.sysDict.vo.SaveUserRightModelsListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-27 17:07
 */
@RestController
@AllArgsConstructor
@Api(tags = "用户菜单权限接口API")
@RequestMapping("/userVSMenu")
public class UserVSMenuController {

    private UserVSMenuService userVSMenuService;

    /**
     * 查询已分配菜单
     * @param hospitalId,userId
     * @return list
     */
    @ApiOperation(value = "查询已分配菜单，原GetAlreadyMenuList的方法")
    @GetMapping("/findAlreadyMenuList/{hospitalId}/{userId}")
    public List<MenuListVo> findAlreadyMenuList(@PathVariable String hospitalId, @PathVariable String userId){
        return userVSMenuService.findAlreadyMenuList(hospitalId,userId);
    }

    /**
     * 查询未分配列表
     * @param hospitalId,userId
     * @return list
     */
    @ApiOperation(value = "查询未分配列表，原GetUnallocatedMenuList的方法")
    @GetMapping("/findUnallocatedMenuList/{hospitalId}/{userId}")
    public List<MenuListVo> findUnallocatedMenuList(@PathVariable String hospitalId, @PathVariable String userId){
        return userVSMenuService.findUnallocatedMenuList(hospitalId,userId);
    }

    /**
     * 插入、删除人员权限菜单
     * @param saveUserRightModelsList
     * @return null
     */
    @ApiOperation(value = "插入、删除人员权限菜单，原simpleButton1_Click方法")
    @PostMapping("/saveUserRightModels")
    public void saveUserRightModels(@RequestBody SaveUserRightModelsListVo saveUserRightModelsList){
        userVSMenuService.saveUserRightModels(saveUserRightModelsList);
    }
}
