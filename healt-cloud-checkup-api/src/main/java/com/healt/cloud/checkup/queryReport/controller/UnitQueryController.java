package com.healt.cloud.checkup.queryReport.controller;

import com.healt.cloud.checkup.queryReport.service.UnitQueryService;
import com.healt.cloud.checkup.vo.appointmentReg.unitPersons.DtUnitVo;
import com.healt.cloud.checkup.queryReport.vo.DtUnitDictVo;
import com.healt.cloud.checkup.queryReport.vo.UnitQueryDictVo;
import com.healt.cloud.checkup.queryReport.vo.UnitQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-19 13:47
 */
@RestController
@AllArgsConstructor
@Api(tags = "单位基本信息查询接口API")
@RequestMapping("/unitQuery")
public class UnitQueryController {

    private UnitQueryService unitQueryService;

    /**
     * 获得单位信息
     * @param dtUnitDictVo
     * @return list
     */
    @ApiOperation(value = "获得单位信息，原GetDtUnit方法")
    @PostMapping("/findDtUnit")
    public List<DtUnitVo> findDtUnit(@RequestBody DtUnitDictVo dtUnitDictVo){
        return unitQueryService.findDtUnit(dtUnitDictVo);
    }

    /**
     * 获取单位体检信息
     * @param unitQueryDictVo
     * @return list
     */
    @ApiOperation(value = "获取单位体检信息，原bQuery_ItemClick方法")
    @PostMapping("/findUnitQuery")
    public List<UnitQueryVo> findUnitQuery(@RequestBody UnitQueryDictVo unitQueryDictVo){
        return unitQueryService.findUnitQuery(unitQueryDictVo);
    }
}
