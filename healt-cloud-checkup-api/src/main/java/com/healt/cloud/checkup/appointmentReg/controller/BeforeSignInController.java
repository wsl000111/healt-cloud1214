package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.appointmentReg.service.BeforeSignInService;
import com.healt.cloud.checkup.appointmentReg.vo.beforeSignIn.CancelBeforeSignListVo;
import com.healt.cloud.checkup.appointmentReg.vo.beforeSignIn.SaveBeforeSignInListVo;
import com.healt.cloud.checkup.appointmentReg.vo.beforeSignIn.XRGuidanceSheetVo;
import com.healt.cloud.checkup.vo.appointmentReg.beforSign.PersonAndVisitVo;
import com.healt.cloud.checkup.vo.appointmentReg.beforSign.PersonByWherePageVo;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.PersonItemsVo;
import com.healt.cloud.checkup.vo.appointmentReg.unitPersons.DtUnitVo;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-15 15:35
 */
@RestController
@AllArgsConstructor
@Api(tags = "检前签到接口API")
@RequestMapping("/beforeSignIn")
public class BeforeSignInController {

    private BeforeSignInService beforeSignInService;

    /**
     * 获取单位信息
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "获取单位信息，原GetDtUnit的select方法")
    @GetMapping("/findDtUnit/{hospitalId}")
    public List<DtUnitVo> findDtUnit(@PathVariable("hospitalId") String hospitalId){
        return beforeSignInService.findDtUnit(hospitalId);
    }

    /**
     * 取人员
     * @param
     * @return list
     */
    @ApiOperation(value = "取人员，FrmBeforeSignIn检前签到GetPersonList方法")
    @PostMapping("/findPersonByWherePage")
    public PageResult<PersonAndVisitVo> findPersonByWherePage(@RequestBody PersonByWherePageVo personByWherePageVo) {
        return beforeSignInService.selectPersonAndVisit(personByWherePageVo);
    }

    @ApiOperation(value = "未打印查询")
    @PostMapping("/findPersonPrintNullByWherePage")
    public PageResult<PersonAndVisitVo> findPersonPrintNullByWherePage(@RequestBody PersonByWherePageVo personByWherePageVo) {
        return beforeSignInService.selectPersonAndVisitPrintNUll(personByWherePageVo);
    }

    @ApiOperation(value = "已打印查询")
    @PostMapping("/findPersonPrintNotNullByWherePage")
    public PageResult<PersonAndVisitVo> findPersonPrintNotNullByWherePage(@RequestBody PersonByWherePageVo personByWherePageVo) {
        return beforeSignInService.selectPersonAndVisitPrintNotNull(personByWherePageVo);
    }

    @ApiOperation(value = "未打印查询不分页")
    @PostMapping("/selectPersonAndVisitPrintNullNoPage")
    public PageResult<PersonAndVisitVo> selectPersonAndVisitPrintNullNoPage(@RequestBody PersonByWherePageVo personByWherePageVo){
        return beforeSignInService.selectPersonAndVisitPrintNullNoPage(personByWherePageVo);
    }

    @ApiOperation(value = "已打印查询不分页")
    @PostMapping("/selectPersonAndVisitPrintNotNullNoPage")
    public PageResult<PersonAndVisitVo> selectPersonAndVisitPrintNotNullNoPage(@RequestBody PersonByWherePageVo personByWherePageVo){
        return beforeSignInService.selectPersonAndVisitPrintNotNullNoPage(personByWherePageVo);
    }

    /**
     * 签到
     */
    @ApiOperation(value = "检前签到")
    @PostMapping("/beforeSignIn")
    public String beforeSignIn(@RequestBody SaveBeforeSignInListVo saveBeforeSignInListVo){
        return beforeSignInService.beforeSignIn(saveBeforeSignInListVo);
    }

    /**
     * 取项目
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "取项目，GetPersonItems的select方法")
    @GetMapping("/selectPersonItems/{hospitalId}/{personId}/{personVisitId}")
    public List<PersonItemsVo> selectPersonItems(@PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
                                                  @PathVariable("personVisitId") Integer personVisitId) {
        return beforeSignInService.selectPersonItems(hospitalId,personId,personVisitId);
    }


    @ApiOperation(value = "取项目，GetPersonItems的select方法")
    @GetMapping("/selectPersonItemsNew/{hospitalId}/{personId}/{personVisitId}")
    public List<PersonItemsVo> selectPersonItemsNew(@PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
                                                 @PathVariable("personVisitId") Integer personVisitId) {
        return beforeSignInService.selectPersonItemsNew(hospitalId,personId,personVisitId);
    }

    /**
     * 更新项目发送标志
     * @param applyNo,itemPackCode,hospitalId,personId,personVisitId,itemNo
     * @return null
     */
    @ApiOperation(value = "更新项目发送标志，原barLargeButtonItem4_ItemClick的第一个update方法")
    @GetMapping("/updateSubmitApplyNo/{applyNo}/{itemPackCode}/{hospitalId}/{personId}/{personVisitId}/{itemNo}")
    public void updateSubmitApplyNo(@PathVariable("applyNo") String applyNo,@PathVariable("itemPackCode") String itemPackCode,
                                     @PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
                                     @PathVariable("personVisitId") Integer personVisitId, @PathVariable("itemNo") Integer itemNo) {
        beforeSignInService.updateSubmitApplyNo(applyNo,itemPackCode,hospitalId,personId,personVisitId,itemNo);
    }

    /**
     * 修改个人体检记录
     * @param beforeId,beforeName,hospitalId,personId,personVisitId
     * @return null
     */
    @ApiOperation(value = "修改个人体检记录，原barLargeButtonItem4_ItemClick的第二个update方法")
    @GetMapping("/updatePersonVisitInfo/{beforeId}/{beforeName}/{hospitalId}/{personId}/{personVisitId}")
    public void updatePersonVisitInfo(@PathVariable("beforeId") String beforeId,@PathVariable("beforeName") String beforeName,
                                       @PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
                                       @PathVariable("personVisitId") Integer personVisitId) {
        beforeSignInService.updatePersonVisitInfo(beforeId,beforeName,hospitalId,personId,personVisitId);
    }

    /**
     * 取完成项目
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "取完成项目，barLargeButtonItem5_ItemClick的select方法")
    @GetMapping("/selectFinishedItemPackName/{hospitalId}/{personId}/{personVisitId}")
    public List<String> selectFinishedItemPackName(@PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
                                            @PathVariable("personVisitId") Integer personVisitId) {
        return beforeSignInService.selectFinishedItemPackName(hospitalId,personId,personVisitId);
    }

    /**
     * 取消签到
     * @param hospitalId,personId,personVisitId
     * @return null
     */
    @ApiOperation(value = "取消签到，barLargeButtonItem5_ItemClick的update方法")
    @GetMapping("/updateBeforeSign/{hospitalId}/{personId}/{personVisitId}")
    public void updateBeforeSign(@PathVariable("hospitalId") String hospitalId,
                                 @PathVariable("personId") String personId,
                                 @PathVariable("personVisitId") Integer personVisitId) {
        beforeSignInService.updateBeforeSign(hospitalId,personId,personVisitId);
    }

    @ApiOperation(value = "批量取消签到，barLargeButtonItem5_ItemClick方法")
    @PostMapping("/cancelBeforeSign")
    public String cancelBeforeSign(@RequestBody CancelBeforeSignListVo cancelBeforeSignListVo){
        return beforeSignInService.cancelBeforeSign(cancelBeforeSignListVo);
    }

    @ApiOperation("/签到指引单")
    @GetMapping("/xRGuidanceSheet/{hospitalId}/{personId}/{personVisitId}")
    public List<XRGuidanceSheetVo> xRGuidanceSheet(@PathVariable("hospitalId") String hospitalId,
                                                   @PathVariable("personId") String personId,
                                                   @PathVariable("personVisitId") String personVisitId){
        return beforeSignInService.xRGuidanceSheet(hospitalId, personId, personVisitId);
    }
}
