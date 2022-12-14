package com.healt.cloud.checkup.physicalExa.controller;

import com.healt.cloud.checkup.entity.InterfaceSource;
import com.healt.cloud.checkup.physicalExa.vo.*;
import com.healt.cloud.checkup.queryReport.service.UnitQueryService;
import com.healt.cloud.checkup.queryReport.vo.DtUnitDictVo;
import com.healt.cloud.checkup.physicalExa.service.LabResultBrowseService;
import com.healt.cloud.checkup.vo.appointmentReg.unitPersons.DtUnitVo;
import com.healt.cloud.checkup.vo.member.PackVsItemsVo;
import com.healt.cloud.checkup.physicalExa.vo.saveVo.SaveHcDeptResultDictListVo;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-20 10:51
 */
@RestController
@AllArgsConstructor
@Api(tags = "检验结果浏览接口API")
@RequestMapping("/labResultBrowse")
public class LabResultBrowseController {

    private LabResultBrowseService labResultBrowseService;

    private UnitQueryService unitQueryService;

    /**
     * 获得接口库信息
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "获得接口库信息，原GetHisConnStr方法")
    @GetMapping("/findHisConnStr/{hospitalId}")
    public List<InterfaceSource> findHisConnStr(@PathVariable("hospitalId") String hospitalId){
        return labResultBrowseService.findHisConnStr(hospitalId);
    }

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
     * 获得体检人员列表并分页
     * @param personListDictVo
     * @return list
     */
    @ApiOperation(value = "获得体检人员列表并分页，原bSearch_ItemClick方法")
    @PostMapping("/findPersonListPage")
    public PageResult findPersonListPage(@RequestBody PersonListDictVo personListDictVo){
        return labResultBrowseService.findPersonListPage(personListDictVo);
    }

    /**
     * 获得检验主记录
     * @param txzbl
     * @return list
     */
    @ApiOperation(value = "获得检验主记录，原gridView1_SelectionChanged方法")
    @GetMapping("/findLabTestMaster/{txzbl}")
    public List<LabTestMasterVo> findLabTestMaster(@PathVariable("txzbl") String txzbl){
        return labResultBrowseService.findLabTestMaster(txzbl);
    }

    /**
     * 获取处理方法
     * @param hospitalId,itemPackCode
     * @return list
     */
    @ApiOperation(value = "获取处理方法，ImportLabResult的第一个select方法")
    @GetMapping("/findResultHandle/{hospitalId}/{itemPackCode}")
    public List findResultHandle(@PathVariable("hospitalId") String hospitalId,
                           @PathVariable("itemPackCode") String itemPackCode){
        return labResultBrowseService.findResultHandle(hospitalId,itemPackCode);
    }

    /**
     * 获取单位代码和单位体检次数
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "获取单位代码和单位体检次数，ImportLabResult的第二个select方法")
    @GetMapping("/findUnitVisit/{hospitalId}/{personId}/{personVisitId}")
    public List<UnitVisitVo> findUnitVisit(@PathVariable("hospitalId") String hospitalId,
                                           @PathVariable("personId") String personId,
                                           @PathVariable("personVisitId") Integer personVisitId){
        return labResultBrowseService.findUnitVisit(hospitalId,personId,personVisitId);
    }

    /**
     * 导入一个体检检验项目结果
     * @param saveLabResultVo
     * @return null
     */
//    @ApiOperation(value = "导入一个体检检验项目结果，ImportLabResult的方法")
//    @GetMapping("/saveLabResult")
//    public void saveLabResult(@RequestBody SaveLabResultListVo saveLabResultVo){
//        return labResultBrowseService.saveLabResult(saveLabResultVo);
//    }

    /**
     * 取检验医生、标注说明
     * @param testNo
     * @return list
     */
    @ApiOperation(value = "取检验医生、标注说明，LoadImport_Lab_Result的第一个select方法")
    @GetMapping("/findDoctorNote/{testNo}")
    public List<DoctorNoteVo> findDoctorNote(@PathVariable("testNo") String testNo){
        return labResultBrowseService.findDoctorNote(testNo);
    }

    /**
     * 先删除之前的分科体检结果，再重新更新插入，设置体检人员的体检状态
     * @param saveHcDeptResultDictList
     * @return null
     */
    @ApiOperation(value = "先删除之前的分科体检结果，再重新更新插入，设置体检人员的体检状态，LoadImport_Lab_Result的方法")
    @PostMapping("/saveDeptResultDict")
    public void saveDeptResultDict(@RequestBody SaveHcDeptResultDictListVo saveHcDeptResultDictList){
        labResultBrowseService.saveDeptResultDict(saveHcDeptResultDictList);
    }

    /**
     * 获得链接信息
     * @param testNo
     * @return list
     */
    @ApiOperation(value = "获得链接信息，原GetLab_Result(DataTable dtConn, string test_no_list)方法")
    @GetMapping("/findLabResult/{testNo}")
    public List<LabResultVo> findLabResult(@PathVariable("testNo") String testNo){
        return labResultBrowseService.findLabResult(testNo);
    }

    /**
     * 获取项目组合里的项目
     * @param hospitalId,itemPackCode
     * @return list
     */
    @ApiOperation(value = "获取项目组合里的项目，原GetPackVsItems方法")
    @GetMapping("/findPackVsItems/{hospitalId}/{itemPackCode}")
    public List<PackVsItemsVo> findPackVsItems(@PathVariable("hospitalId") String hospitalId,
                                               @PathVariable("itemPackCode") String itemPackCode){
        return labResultBrowseService.findPackVsItems(hospitalId,itemPackCode);
    }

    /**
     * 项目与检验项目代码对照
     * @param hospitalId,hcItemCode
     * @return list
     */
    @ApiOperation(value = "项目与检验项目代码对照，原GetItemVsExternal方法")
    @GetMapping("/findItemVsExternal/{hospitalId}/{hcItemCode}")
    public List<ItemVsExternalVo> findItemVsExternal(@PathVariable("hospitalId") String hospitalId,
                                               @PathVariable("hcItemCode") String hcItemCode){
        return labResultBrowseService.findItemVsExternal(hospitalId,hcItemCode);
    }

    /**
     * 获取HIS中的某检验申请号
     * @param testNo
     * @return list
     */
    @ApiOperation(value = "获取HIS中的某检验申请号，原GetLab_Result(string test_no_list)方法")
    @GetMapping("/findLabResult1/{testNo}")
    public List<LabResult1Vo> findLabResult1(@PathVariable("testNo") String testNo){
        return labResultBrowseService.findLabResult1(testNo);
    }

    /**
     * 获取存储科室体检项目结果
     * @param hcResultDictVo
     * @return list
     */
    @ApiOperation(value = "获取存储科室体检项目结果，原GetHc_Result方法")
    @PostMapping("/findHcResult")
    public List<HcResultVo> findHcResult(@RequestBody HcResultDictVo hcResultDictVo){
        return labResultBrowseService.findHcResult(hcResultDictVo);
    }

    /**
     * 获取存储科室阳性体征
     * @param personId,personVisitId,deptId,packCode
     * @return list
     */
    @ApiOperation(value = "获取存储科室阳性体征，原GetHc_Dept_ResultItems方法")
    @GetMapping("/findHcDeptResultItems/{hospitalId}/{personId}/{personVisitId}/{deptId}/{packCode}")
    public List<HcDeptResultItemsVo> findHcDeptResultItems(@PathVariable("hospitalId") String hospitalId,@PathVariable("personId") String personId, @PathVariable("personVisitId") Integer personVisitId,
                                                           @PathVariable("deptId") String deptId, @PathVariable("packCode") String packCode){
        return labResultBrowseService.findHcDeptResultItems(hospitalId,personId,personVisitId,deptId,packCode);
    }

    /**
     * 获取某体检人的所有项目组合
     * @param hospitalId,personId,personVisitId,className
     * @return list
     */
    @ApiOperation(value = "获取某体检人的所有项目组合，原GetHc_Appreg_Items(string person_id, string person_visit_id, string dept_class)方法")
    @GetMapping("/findHcAppregItems/{hospitalId}/{personId}/{personVisitId}/{className}")
    public List<HcAppregItemsVo> findHcAppregItems(@PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
                                                   @PathVariable("personVisitId") Integer personVisitId, @PathVariable("className") String className){
        return labResultBrowseService.findHcAppregItems(hospitalId,personId,personVisitId,className);
    }

    /**
     * 获取某体检人的某个项目组合
     * @param hospitalId,personId,personVisitId,itemPackCode
     * @return list
     */
    @ApiOperation(value = "获取某体检人的某个项目组合，原GetHc_Appreg_Items(string person_id, string person_visit_id, string item_pack_code)方法")
    @GetMapping("/findHcAppregItems1/{hospitalId}/{personId}/{personVisitId}/{itemPackCode}")
    public List<HcAppregItems1Vo> findHcAppregItems1(@PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
                                                     @PathVariable("personVisitId") Integer personVisitId, @PathVariable("itemPackCode") String itemPackCode){
        return labResultBrowseService.findHcAppregItems1(hospitalId,personId,personVisitId,itemPackCode);
    }

    /**
     *
     * @param personId,personVisitId,deptId
     * @return list
     */
    @ApiOperation(value = "原GetDeptResultItems方法")
    @GetMapping("/findDeptResultItems/{hospitalId}/{personId}/{personVisitId}/{deptId}")
    public List<DeptResultItemsVo> findDeptResultItems(@PathVariable("hospitalId") String hospitalId,@PathVariable("personId") String personId, @PathVariable("personVisitId") Integer personVisitId,
                                                       @PathVariable("deptId") String deptId){
        return labResultBrowseService.findDeptResultItems(hospitalId,personId,personVisitId,deptId);
    }

    /**
     * 获取检验结果记录
     * @param testNo
     * @return list
     */
    @ApiOperation(value = "获取检验结果记录,原gridView2_RowClick方法")
    @GetMapping("/findVLabResult/{testNo}")
    public List<VLabResultVo> findVLabResult(@PathVariable("testNo") String testNo){
        return labResultBrowseService.findVLabResult(testNo);
    }
}
