package com.healt.cloud.checkup.controller.sysDict;

import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.service.sysDict.DepartService;
import com.healt.cloud.checkup.vo.HospitalVo;
import com.healt.cloud.checkup.vo.sys.depart.SaveDepartDictListVo;
import com.healt.cloud.checkup.vo.sys.depart.VHisDeptDictVo;
import com.healt.cloud.checkup.service.sysDict.SysService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-06 13:27
 * @description: TODO
 */
@RestController
@Api(tags = "部门管理接口API")
@AllArgsConstructor
@RequestMapping("/depart")
public class DepartDictController {

    private DepartService departService;
    private SysService sysService;

    @PostMapping("/getDtINTERFACE_SOURCE")
    public List<VInterfaceSource> getDtINTERFACE_SOURCE(@RequestBody HospitalVo hospitalVo){
        return departService.findDtInoerfaceSource(hospitalVo);
    }

    @PostMapping("/getDtDepart_Class")
    public List<DepartClass> getDtDepart_Class(@RequestBody HospitalVo hospitalVo){
        return departService.findDtDepartClass(hospitalVo);
    }

    @PostMapping("/getDtHospital")
    public List<VHospitalDict> getDtHospital(){
        return sysService.findHospitalDict();
    }

    @PostMapping("/getDtHISDepart")
    public List<VHisDeptDictVo> getDtHISDepart(@RequestBody HospitalVo hospitalVo){
        return departService.findDtHisDepart(hospitalVo);
    }

    @PostMapping("/getDtDepart")
    public List<DepartDict> getDtDepart(@RequestBody HospitalVo hospitalVo){
        return departService.findDtDepart(hospitalVo);
    }

    @PostMapping("/getDtVDepart")
    public List<VDepartDict> getDtVDepart(@RequestBody HospitalVo hospitalVo){
        return departService.findVDtDepart(hospitalVo);
    }

    @GetMapping("/findDeptList/{hospitalCode}")
    public List<VHisDeptDictVo> findDeptList(@PathVariable String hospitalCode){
        return departService.findDeptList(hospitalCode);
    }

    @PostMapping("/saveDepartDict")
    public void saveDepartDict(@RequestBody SaveDepartDictListVo saveDepartDictListVo){
        departService.saveDepartDict(saveDepartDictListVo);
    }

}
