package com.healt.cloud.checkup.controller.sysDict;

import com.healt.cloud.checkup.entity.HospitalDict;
import com.healt.cloud.checkup.entity.VHospitalDict;
import com.healt.cloud.checkup.vo.UserMenuRightVoResult;
import com.healt.cloud.checkup.vo.sys.HospitalVo1;
import com.healt.cloud.checkup.vo.sys.user.UsersVo;
import com.healt.cloud.checkup.service.sysDict.SysService;
import com.healt.cloud.common.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-06 13:27
 * @description: TODO
 */
@RestController
@Api(tags = "系统服务接口API")
@AllArgsConstructor
@RequestMapping("/sys")
public class SysDictController {

    private SysService sysService;

    @PostMapping("/findHospitalDict")
    @ApiOperation("查询医院信息")
    public List<VHospitalDict> findHospitalDict(@RequestBody HospitalVo1 hospitalVo1){
        List<VHospitalDict> list = sysService.findHospitalDict(hospitalVo1);
        return list;
    }

    @ApiOperation("查询医院信息")
    @GetMapping("/getHospitalDict/{hospitalId}")
    public List<HospitalDict> getHospitalDict(@PathVariable("hospitalId") String hospitalId){
        return sysService.getHospitalDict(hospitalId);
    }

    @PostMapping("/getUserMenuRight")
    public List<UserMenuRightVoResult> getUserMenuRight(@RequestBody UsersVo usersVo){
        return sysService.findUserMenuRight(usersVo);
    }

    @GetMapping("/getSystemDate")
    public String getSystemDate(){
        return DateUtils.praseDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

}
