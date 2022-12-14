package com.healt.cloud.checkup.other;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.healt.cloud.checkup.entity.CostDetailBilling;
import com.healt.cloud.checkup.entity.HcPersonInfoErrlog;
import com.healt.cloud.checkup.other.service.OtherService;
import com.healt.cloud.checkup.other.vo.*;
import com.healt.cloud.checkup.service.HcPersonInfoErrlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-08-26 18:25
 * @description: TODO
 */
@RestController
@AllArgsConstructor
@Api(tags = "新增未分类接口API")
@RequestMapping("/other")
public class OtherController {

    private OtherService otherService;

    @ApiOperation(value = "")
    @GetMapping("/findHclabResultByPV/{personId}/{personVisitId}")
    public List<HclabResultByPVVo> findHclabResultByPV(@PathVariable String personId, @PathVariable String personVisitId){
        List<HclabResultByPVVo> list = otherService.findHclabResultByPV(personId, personVisitId);
        if(list.size() == 0){
            list.add(new HclabResultByPVVo());
        }
        return list;
    }

    @ApiOperation(value = "")
    @GetMapping("/findHcResultDict/{deptId}/{personId}/{personVisitId}")
    public List<HcResultDictOtherVo> findHcResultDict(@PathVariable String deptId,@PathVariable String personId, @PathVariable String personVisitId){
        List<HcResultDictOtherVo> list = otherService.findHcResultDict(deptId,personId, personVisitId);
        if(list.size() == 0){
            list.add(new HcResultDictOtherVo());
        }
        return list;
    }

//    update hc_dept_result_items a set a.in_chief_report ='1'
//    where a.hospital_id ='0001' and a.person_id = '103704'
//    and a.person_visit_id ='1' and a.content_class ='1' and  a.content = '白球比偏低' ;
    @ApiOperation(value = "修改hc_dept_result_items表")
    @PostMapping("/updateDeptResultItems")
    public void updateDeptResultItems(@RequestBody UpdateDeptResultItems updateDeptResultItems){
        otherService.updateDeptResultItems(updateDeptResultItems.getHospitalId(),
                updateDeptResultItems.getPersonId(),updateDeptResultItems.getPersonVisitId(),
                updateDeptResultItems.getContentClass(),updateDeptResultItems.getContent());
    }

    @ApiOperation(value = "查询病理申请单")
    @GetMapping("/findPathologyApply/{personId}/{personVisitId}")
    public List<FinidPathologyApplyVo> findPathologyApply(@PathVariable String personId, @PathVariable String personVisitId){
        return otherService.findPathologyApply(personId, personVisitId);
    }

    @ApiOperation(value = "")
    @GetMapping("/findCostDetailBilling/{personId}/{personVisitId}")
    public List<CostDetailBilling> findCostDetailBilling(@PathVariable String personId, @PathVariable String personVisitId){
        List<CostDetailBilling> list = otherService.findCostDetailBilling(personId, personVisitId);
        if(list.size() == 0){
            list.add(new CostDetailBilling());
        }
        return list;
    }

    @ApiOperation(value = "")
    @GetMapping("/findCostDetailBillingByTime/{beginDate}/{endDate}")
    public List<CostDetailBillingByTimeVo> findCostDetailBillingByTime(@PathVariable String beginDate, @PathVariable String endDate){
        List<CostDetailBillingByTimeVo> list = otherService.findCostDetailBillingByTime(beginDate, endDate);
        if(list.size() == 0){
            list.add(new CostDetailBillingByTimeVo());
        }
        return list;
    }


    @Autowired
    HcPersonInfoErrlogService hcPersonInfoErrlogService;

    @ApiOperation(value = "查询注册错误数据")
    @GetMapping("/findHcPersonInfoErrlog/{unitId}")
    public List<HcPersonInfoErrlog> findHcPersonInfoErrlog(@PathVariable String unitId){
        LambdaQueryWrapper<HcPersonInfoErrlog> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(HcPersonInfoErrlog::getUnitId, unitId);
        List<HcPersonInfoErrlog> list = hcPersonInfoErrlogService.list(queryWrapper);
        if(list.size()==0){
            list.add(new HcPersonInfoErrlog());
        }
        return list;
    }

//    update hc_person_visit_info a set a.unit_id = '变量1' ,a.unit_visit_id ='变量2'
//    ,a.unit_name = '变量3' where a.person_id ='入参1' and a.person_visit_id ='入参2'
    @ApiOperation(value = "修改hc_person_visit_info表")
    @PostMapping("/updatePersonVisitInfo")
    public void updatePersonVisitInfo(@RequestBody UpdatePersonVisitInfo updatePersonVisitInfo){
        otherService.updatePersonVisitInfo(updatePersonVisitInfo.getUnitId(),
                updatePersonVisitInfo.getUnitVisitId(),updatePersonVisitInfo.getUnitName(),
                updatePersonVisitInfo.getPersonId(),updatePersonVisitInfo.getPersonVisitId());
    }

    @ApiOperation(value = "")
    @PostMapping("/findPersonUnitInfo")
    public List<PersonUnitInfoVo> findPersonUnitInfo(@RequestBody PersonUnitInfoDictVo personUnitInfoDictVo){
        List<PersonUnitInfoVo> list = otherService.findPersonUnitInfo(personUnitInfoDictVo);
        if(list.size() == 0){
            list.add(new PersonUnitInfoVo());
        }
        return list;
    }

    @ApiOperation(value = " 体检收入统计")
    @GetMapping("/findTjtj/{tbegindate}/{tenddate}")
    public List<TjShouRuTongJi> findTjtj(@PathVariable String tbegindate, @PathVariable String tenddate){
        List<TjShouRuTongJi> list = otherService.findTjtj(tbegindate, tenddate);
        if(list.size() == 0){
            list.add(new TjShouRuTongJi());
        }
        return list;
    }

    @ApiOperation(value = "时间段内结算信息")
    @GetMapping("/findTjtjDept/{tbegindate}/{tenddate}")
    public List<TjtjDept> findTjtjDept(@PathVariable String tbegindate, @PathVariable String tenddate){
        List<TjtjDept> list = otherService.findTjtjDept(tbegindate, tenddate);
        if(list.size() == 0){
            list.add(new TjtjDept());
        }
        return list;
    }

}
