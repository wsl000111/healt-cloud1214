package com.healt.cloud.checkup.controller.sysDict;

import com.healt.cloud.checkup.entity.VUsersDict;
import com.healt.cloud.checkup.service.UserService;
import com.healt.cloud.checkup.vo.sys.user.SaveUsersDictListVo;
import com.healt.cloud.checkup.vo.sys.user.UsersVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-06 13:27
 * @description: TODO
 */
@RestController
@Api(tags = "用户管理接口API")
@AllArgsConstructor
@RequestMapping("/users")
public class UserDictController {

    private UserService userService;

    @PostMapping("/findUsersDict")
    private List<VUsersDict> findUsersDict(@RequestBody UsersVo usersVo){
        return userService.findUsersDict(usersVo);
    }

    @GetMapping("/getVUsersDict/{userId}")
    private List<VUsersDict> getVUsersDict(@PathVariable("userId") String userId){
        return userService.getVUsersDict(userId);
    }

    @PostMapping("/saveUsersDict")
    private void saveUsersDict(@RequestBody SaveUsersDictListVo saveUsersDictListVo){
        userService.saveUsersDict(saveUsersDictListVo);
    }

    @GetMapping("/updateUsersDict/{userId}/{password}")
    private void updateUsersDict(@PathVariable("userId") String userId,
                                 @PathVariable("password") String password){
        userService.updatePassword(userId, password);
    }

    @ApiOperation("更新用户表, deptName=*时更新全部科室用户")
    @GetMapping("/reloadUsersDict/{deptName}")
    public void reloadUsersDict(@PathVariable String deptName){
        userService.reloadUsersDict(deptName);
    }

}
