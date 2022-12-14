package com.healt.cloud.checkup.frmDivDocDepart.controller;

import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.frmDivDocDepart.vo.*;
import com.healt.cloud.checkup.frmDivDocDepart.service.DivDocDepartServer;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-22 17:29
 * @description: TODO
 */
@RestController
@AllArgsConstructor
@Api(tags = "科室检查接口API,FrmDivDocDepart")
@RequestMapping("/divDocDepart")
public class DivDocDepartController {

    private DivDocDepartServer divDocDepartServer;

    @ApiOperation(value = "查询医生权限", responseReference = "[{DEPTNAME=CT, DEPTID=17, CLASSNAME=检查}]")
    @GetMapping("/validateRight/{hospitalId}/{userId}")
    public List<ValidateRightVo> validateRight(@PathVariable("hospitalId") String hospitalId,
                                               @PathVariable("userId") String userId){
        return divDocDepartServer.validateRight(hospitalId, userId);
    }

    @ApiOperation(value = "保存分科检查")
    @PostMapping("/saveDivDocDepart")
    public String saveDivDocDepart(@RequestBody SaveDivDocDepartVo saveDivDocDeprtVo){
        return divDocDepartServer.saveDivDocDepart(saveDivDocDeprtVo);
    }

    @ApiOperation(value = "个人报到预约信息")
    @PostMapping("/getPerson")
    public PageResult<FrmGetPersonVoRsp> getPerson(@RequestBody FrmGetPersonVo frmGetPersonVo){
        return divDocDepartServer.findPerson(frmGetPersonVo);
    }

    @ApiOperation(value = "GetUnitPerson")
    @PostMapping("/getUnitPerson")
    public PageResult<FrmGetUnitPersonVoRsp> getUnitPerson(@RequestBody FrmGetUnitPersonVo frmGetUnitPersonVo){
        return divDocDepartServer.findUnitPerson(frmGetUnitPersonVo);
    }

    @ApiOperation(value = "GetPersonHistory")
    @GetMapping("/getPersonHistory/{hospitalId}/{personId}/{deptId}")
    public List<FrmGetPersonVoRsp> getPersonHistory(@PathVariable("hospitalId") String hospitalId,
                                                       @PathVariable("personId") String personId,
                                                       @PathVariable("deptId") String deptId){
        return divDocDepartServer.findGetPersonHistory(hospitalId, personId, deptId);
    }

    @ApiOperation(value = "GetWorkInfo, value1=FINISHED_DATE/APPOINTS_DATE, value2=完成/未完成"  )
    @GetMapping("/getWorkInfo/{deptId}/{value1}/{value2}")
    public String getWorkInfo(@PathVariable("deptId") String deptId,
                                 @PathVariable("value1") String value1,
                                 @PathVariable("value2") String value2){
        return divDocDepartServer.findWorkInfo(deptId, value1, value2);
    }

    @ApiOperation(value = "GetPackVsItems")
    @GetMapping("/getPackVsItems/{hospitalId}/{itemPackCode}")
    public List<FrmPackVsItems> getPackVsItems(@PathVariable("hospitalId") String hospitalId,
                                                  @PathVariable("itemPackCode") String itemPackCode){
        return divDocDepartServer.findPackVsItems(hospitalId, itemPackCode);
    }

    @ApiOperation(value = "GetPackItems")
    @GetMapping("/getPackItems/{hospitalId}")
    public List<FrmPackItems> getPackItems(@PathVariable("hospitalId") String hospitalId){
        return divDocDepartServer.findPackItems(hospitalId);
    }

    @ApiOperation(value = "GetItemVsExternal 项目与检验项目代码对照")
    @GetMapping("/getItemVsExternal/{hospitalId}/{itemCode}")
    public List<FrmItemVsExternal> getItemVsExternal(@PathVariable("hospitalId") String hospitalId,
                                    @PathVariable("itemCode") String itemCode){
        return divDocDepartServer.findItemVsExternal(hospitalId, itemCode);
    }

    @ApiOperation(value = "GetLab_Result HIS中的某检验申请号")
    @GetMapping("/getLabResult/{testNoList}")
    public List<FrmLabResultVo> getLabResult(@PathVariable("testNoList") String testNoList){
        return divDocDepartServer.findLabResult(testNoList);
    }

    @ApiOperation(value = "GetLab_Result HIS中的某检验申请号")
    @GetMapping("/getLabResultOut/{sourceId}/{testNoList}")
    public List<FrmLabResultVo> getLabResultOut(@PathVariable("hospitalId") String hospitalId,
                                                @PathVariable("sourceId") String sourceId,
                                                @PathVariable("testNoList") String testNoList){
        return divDocDepartServer.findLabResultOut(hospitalId, sourceId, testNoList);
    }

    @ApiOperation(value = "GetHc_Dept_ResultItems 组合编号关系relation 0默认等于，*不等于")
    @GetMapping("/getHcDeptResultItems/{hospitalId}/{personId}/{personVisitId}/{deptId}/{packCode}/{relation}")
    public List<HcDeptResultItems> getHcDeptResultItems(@PathVariable("hospitalId") String hospitalId,
                                                        @PathVariable("personId") String personId,
                                                        @PathVariable("personVisitId") String personVisitId,
                                                        @PathVariable("deptId") String deptId,
                                                        @PathVariable("packCode") String packCode,
                                                        @PathVariable("relation") String relation){
        return divDocDepartServer.findHcDeptResultItems(hospitalId, personId, personVisitId, deptId, packCode, relation);
    }

    @ApiOperation(value = "GetHisConnStr")
    @GetMapping("/getHisConnStr/{hospitalId}")
    public List<InterfaceSource> getHisConnStr(@PathVariable("hospitalId") String hospitalId){
        return divDocDepartServer.getHisConnStr(hospitalId);
    }

    @ApiOperation(value = "GetHc_Dept_Result  dept_id为null传*")
    @GetMapping("/getHcDeptResult/{hospitalId}/{personId}/{personVisitId}/{deptId}")
    public List<HcDeptResultDict> getHcDeptResult(@PathVariable("hospitalId") String hospitalId,
                                                  @PathVariable("personId") String personId,
                                                  @PathVariable("personVisitId") String personVisitId,
                                                  @PathVariable("deptId") String deptId){
        return divDocDepartServer.findHcDeptResult(hospitalId, personId, personVisitId, deptId);
    }


    @ApiOperation(value = "GetDeptResultItems 组合编号关系relation 0默认等于，*不等于")
    @GetMapping("/getDeptResultItems/{hospitalId}/{personId}/{personVisitId}/{deptId}")
    public List<HcDeptResultItems> getDeptResultItems(@PathVariable("hospitalId") String hospitalId,
                                                      @PathVariable("personId") String personId,
                                                      @PathVariable("personVisitId") String personVisitId,
                                                      @PathVariable("deptId") String deptId){
        return divDocDepartServer.findDeptResultItems(hospitalId, personId, personVisitId, deptId);
    }

    @ApiOperation(value = "条件查询HcPersonAppregItems数量，返回1或者2")
    @GetMapping("/countHcPersonAppregItems/{personId}/{personVisitId}/{finishedSign}")
    public int countHcPersonAppregItems(@PathVariable("personId") String personId,
                                        @PathVariable("personVisitId") String personVisitId,
                                        @PathVariable("finishedSign") String finishedSign){
        return divDocDepartServer.countHcPersonAppregItems(personId, personVisitId, finishedSign);
    }

    @ApiOperation(value = "GetHc_Appreg_Item 更新某体检人的某个项目组合")
    @GetMapping("/getHcAppregItem/{hospitalId}/{personId}/{personVisitId}/{packCode}")
    public List<FrmGetHcAppregItem> getHcAppregItem(@PathVariable("hospitalId") String hospitalId,
                                  @PathVariable("personId") String personId,
                                  @PathVariable("personVisitId") String personVisitId,
                                  @PathVariable("packCode") String packCode){
        return divDocDepartServer.findHcAppregItem(hospitalId, personId, personVisitId, packCode);
    }

    @ApiOperation(value = "查询部门名称集合 ")
    @GetMapping("/getDeptNameList/{hospitalId}/{deptId}")
    public List<DeptNameListVo> getDeptNameList(@PathVariable("hospitalId") String hospitalId,
                                                @PathVariable("deptId") String deptId){
        return divDocDepartServer.findDeptNameList(hospitalId, deptId);
    }

    @ApiOperation(value = "查询结果状态集合 ")
    @GetMapping("/getResultStatusList/{personId}/{personVisitId}")
    public List<ResultStatusListVo> getResultStatusList(@PathVariable("personId") String personId,
                                                @PathVariable("personVisitId") String personVisitId){
        return divDocDepartServer.findResultStatusList(personId, personVisitId);
    }

    @ApiOperation(value = "initDept ")
    @GetMapping("/initDept/{userName}")
    public List<InitDeptVo> initDept(@PathVariable("userName") String userName){
        return divDocDepartServer.initDept(userName);
    }

    @ApiOperation(value = "initDoctor")
    @GetMapping("/initDoctor/{hospitalId}/{deptId}")
    public List<InitDoctorVo> initDoctor(@PathVariable("hospitalId") String hospitalId,
                             @PathVariable("deptId") String deptId){
        return divDocDepartServer.initDoctor(hospitalId, deptId);
    }

    @ApiOperation(value = "setDivSource")
    @GetMapping("/setDivSource/{hospitalId}/{deptId}/{personId}/{visitId}")
    public List<FrmSetDivSourceVoRes> setDivSource(@PathVariable("hospitalId") String hospitalId,
                                                   @PathVariable("deptId") String deptId,
                                                   @PathVariable("personId") String personId,
                                                   @PathVariable("visitId") String visitId){

        return divDocDepartServer.setDivSource(hospitalId, deptId, personId, visitId);
    }

    //InitStart
    @ApiOperation(value = "getResultStatus 得到体检者的状态")
    @GetMapping("/getResultStatus/{hospitalId}/{personId}/{visitId}")
    public String getResultStatus(@PathVariable("hospitalId") String hospitalId,
                                  @PathVariable("personId") String personId,
                                  @PathVariable("visitId") String visitId){
        return divDocDepartServer.findResultStatus(hospitalId, personId, visitId);
    }

    @ApiOperation(value = "判断是否已经报到")
    @GetMapping("/getBeforeDate/{hospitalId}/{personId}/{visitId}")
    public Date getBeforeDate(@PathVariable("hospitalId") String hospitalId,
                              @PathVariable("personId") String personId,
                              @PathVariable("visitId") String visitId){
        return divDocDepartServer.findBeforeDate(hospitalId, personId, visitId);
    }

    @ApiOperation(value = "判断是否选择了本科的项目")
        @GetMapping("/getItemsCount/{hospitalId}/{personId}/{visitId}/{deptCode}")
    public int getItemsCount(@PathVariable("hospitalId") String hospitalId,
                             @PathVariable("personId") String personId,
                             @PathVariable("visitId") String visitId,
                             @PathVariable("deptCode") String deptCode){
        return divDocDepartServer.findItemsCount(hospitalId, personId, visitId, deptCode);
    }

    @ApiOperation(value = "判断是否是否收费")
    @GetMapping("/getCountSettle/{hospitalId}/{personId}/{visitId}/{deptCode}")
    public int getCountSettle(@PathVariable("hospitalId") String hospitalId,
                              @PathVariable("personId") String personId,
                              @PathVariable("visitId") String visitId,
                              @PathVariable("deptCode") String deptCode){
        return divDocDepartServer.findCountSettle(hospitalId, personId, visitId, deptCode);
    }

    @ApiOperation(value = "得到体检人的基本信息")
    @GetMapping("/getHcPersonVisitInfo/{hospitalId}/{personId}/{visitId}")
    public List<HcPersonVisitInfo> getHcPersonVisitInfo(@PathVariable("hospitalId") String hospitalId,
                                                        @PathVariable("personId") String personId,
                                                        @PathVariable("visitId") String visitId){
        return divDocDepartServer.findHcPersonVisitInfo(hospitalId, personId, visitId);
    }

    @ApiOperation(value = "SEX得到体检人性别")
    @GetMapping("/getHcPersonInfo/{hospitalId}/{personId}")
    public List<HcPersonInfo> getHcPersonInfo(@PathVariable("hospitalId") String hospitalId,
                                              @PathVariable("personId") String personId){
        return divDocDepartServer.findHcPersonInfo(hospitalId, personId);
    }

    @ApiOperation(value = "CLASS_NAME获取检验科室类别")
    @GetMapping("/getClassName/{hospitalId}/{deptId}")
    public String getClassName(@PathVariable("hospitalId") String hospitalId,
                               @PathVariable("deptId") String deptId){
        return divDocDepartServer.findClassName(hospitalId, deptId);
    }

    @ApiOperation(value = "count_Apply获取预约项目总数")
    @GetMapping("/getCountApply/{hospitalId}/{deptId}/{personId}/{visitId}")
    public int getCountApply(@PathVariable("hospitalId") String hospitalId,
                             @PathVariable("deptId") String deptId,
                             @PathVariable("personId") String personId,
                             @PathVariable("visitId") String visitId){
        return divDocDepartServer.findCountApply(hospitalId, deptId, personId, visitId);
    }

    @ApiOperation(value ="SetPersonInfo")
    @GetMapping("/setPersonInfo/{hospitalId}/{personId}/{visitId}")
    public List<SetPersonInfoVo> setPersonInfo(@PathVariable("hospitalId") String hospitalId,
                                               @PathVariable("personId") String personId,
                                               @PathVariable("visitId") String visitId){
        return divDocDepartServer.findSetPersonInfo(hospitalId, personId, visitId);
    }

    @ApiOperation(value = "GetDeptResult")
    @GetMapping("/getDeptResult/{personId}/{visitId}/{deptId}")
    public List<HcDeptResultDict> getDeptResult(@PathVariable("personId") String personId,
                                @PathVariable("visitId") String visitId,
                                @PathVariable("deptId") String deptId){
        return divDocDepartServer.findDeptResult(personId, visitId, deptId);
    }

    @ApiOperation(value = "GetHc_Result, packCode和deptId如果为空传*符号")
    @GetMapping("/getHcResult/{hospitalId}/{personId}/{visitId}/{packCode}/{deptId}")
    public List<GetHcResultVo> getHcResult(@PathVariable("hospitalId") String hospitalId,
                                           @PathVariable("personId") String personId,
                                           @PathVariable("visitId") String visitId,
                                           @PathVariable("packCode") String packCode,
                                           @PathVariable("deptId") String deptId){
        return divDocDepartServer.findHcResult(hospitalId, personId, visitId, packCode, deptId);
    }

    @ApiOperation(value = "GetHc_Appreg_Items, 某体检人的所有项目组合")
    @GetMapping("/getHcAppregItems/{hospitalId}/{personId}/{visitId}/{deptClass}")
    public List<HcAppregItemsVo> getHcAppregItems(@PathVariable("hospitalId") String hospitalId,
                                                  @PathVariable("personId") String personId,
                                                  @PathVariable("visitId") String visitId,
                                                  @PathVariable("deptClass") String deptClass){
        return divDocDepartServer.findHcAppregItems(hospitalId, personId, visitId, deptClass);
    }

    @ApiOperation(value = "取检验医生、标注说明")
    @GetMapping("/getVLabTestMaster")
    public List<VLabTestMaster> getVLabTestMaster(@PathVariable("testNo") String testNo){
        return divDocDepartServer.findVLabTestMaster(testNo);
    }

    @ApiOperation(value = "获取RESULT_HANDLE,获得项目组合代码处理阳性体征的方法")
    @GetMapping("/getResultHandle/{hospitalId}/{itemPackCode}")
    public String getResultHandle(@PathVariable("hospitalId") String hospitalId,
                                  @PathVariable("itemPackCode") String itemPackCode){
        return divDocDepartServer.findResultHandle(hospitalId, itemPackCode);
    }

    @ApiOperation(value = "UpdateConclusion, 查询 conclusion_text")
    @GetMapping("/getUpdateConclusion/{hospitalId}/{hcDeptCode}")
    public String getUpdateConclusion(@PathVariable("hospitalId") String hospitalId,
                                      @PathVariable("hcDeptCode") String hcDeptCode){
        return divDocDepartServer.findUpdateConclusion(hospitalId, hcDeptCode);
    }

//    @ApiOperation(value = "获取单位代码和单位体检次数, 使用pubComm/findPersonInfo方法")
//    @GetMapping("/hc_person_visit_info")

    @ApiOperation(value = "导入一个体检检验项目结果 string apply_no, string personid, string person_visit_id, string item_pack_code, string doctor_name")
    @GetMapping("/importLabResult")

    public int importLabResult(@PathVariable("hospitalId") String hospitalId,
                                  @PathVariable("applyNo") String applyNo,
                                  @PathVariable("personId") String personId,
                                  @PathVariable("personVisitId") String personVisitId,
                                  @PathVariable("itemPackCode") String itemPackCode,
                                  @PathVariable("doctorName") String doctorName,
                                  @PathVariable("ext_sys_code") String ext_sys_code){
        return divDocDepartServer.importLabResult(hospitalId, applyNo, personId, Integer.parseInt(personVisitId), itemPackCode, doctorName, ext_sys_code);
    }

    @ApiOperation("导入体检检验项目结果LoadImport_Lab_Result")
    @PostMapping("/loadImportLabResult")
    public String loadImportLabResult(@RequestBody LoadLabVo loadLabVo){
        return divDocDepartServer.loadImportLabResult(loadLabVo);
    }

    @ApiOperation("导入体检检查项目结果LoadImport_exam_Result")
    @PostMapping("/loadImportExamResult")
    public String loadImportExamResult(@RequestBody LoadExamVo loadExamVo){
        return divDocDepartServer.loadImportExamResult(loadExamVo);
    }

    @ApiOperation("LoadDeptDict方法")
    @GetMapping("/loadDeptDict/{hospitalId}")
    public List<LoadDeptDictVo> loadDeptDict(@PathVariable("hospitalId") String hospitalId){
        return divDocDepartServer.loadDeptDict(hospitalId);
    }

    @ApiOperation("科室疾病分组 汇总")
    @GetMapping("/getDeptDiseaseGroup/{hospitalId}/{deptId}")
    public List<DeptDiseaseGroupVo> getDeptDiseaseGroup(@PathVariable("hospitalId") String hospitalId, @PathVariable("deptId") String deptId){
        return divDocDepartServer.getDeptDiseaseGroup(hospitalId, deptId);
    }

    @ApiOperation("科室疾病明细")
    @GetMapping("/getHcDiseaseDict/{hospitalId}/{diseaseCode}/{deptId}")
    public List<HcDiseaseDict> getHcDiseaseDict(@PathVariable("hospitalId") String hospitalId,
                                                @PathVariable("diseaseCode") String diseaseCode,
                                                @PathVariable("deptId") String deptId){
        return divDocDepartServer.getHcDiseaseDict(hospitalId, diseaseCode, deptId);
    }


}
