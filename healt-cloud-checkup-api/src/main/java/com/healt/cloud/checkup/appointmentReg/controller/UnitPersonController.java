package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.appointmentReg.service.UnitPersonService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-22 8:53
 * @description: TODO
 */
@RestController
@AllArgsConstructor
@Api(tags = "单位人员维护接口API")
@RequestMapping("/appointment")
public class UnitPersonController {

    private UnitPersonService unitPersonService;

    @GetMapping("/findDtClassType/{hospitalId}")
    public List<VHcClassDict> findDtClassType(@PathVariable String hospitalId){
        return unitPersonService.findDtClassType(hospitalId);
    }

    @GetMapping("/findDtCountry/{hospitalId}")
    public List<VCountryDict> findDtCountry(@PathVariable String hospitalId){
        return unitPersonService.findDtCountry(hospitalId);
    }

    @GetMapping("/findDtArea/{hospitalId}")
    public List<VAreaDict> findDtArea(@PathVariable String hospitalId){
        return unitPersonService.findDtArea(hospitalId);
    }

    @GetMapping("/findDtNation/{hospitalId}")
    public List<VNationDict> findDtNation(@PathVariable String hospitalId){
        return unitPersonService.findDtNation(hospitalId);
    }

    @GetMapping("/findDtJob/{hospitalId}")
    public List<VOccupationDict> findDtJob(@PathVariable String hospitalId){
        return unitPersonService.findDtJob(hospitalId);
    }

    @GetMapping("/findDtMaritalStatus/{hospitalId}")
    public List<VMaritalStatusDict> findDtMaritalStatus(@PathVariable String hospitalId){
        return unitPersonService.findDtMaritalStatus(hospitalId);
    }

    @GetMapping("/findDtChargeType/{hospitalId}")
    public List<VCostclassDict> findDtChargeType(@PathVariable String hospitalId){
        return unitPersonService.findDtChargeType(hospitalId);
    }

    @GetMapping("/findDtIdentity/{hospitalId}")
    public List<VIdentityDict> findDtIdentity(@PathVariable String hospitalId){
        return unitPersonService.findDtIdentity(hospitalId);
    }

}
