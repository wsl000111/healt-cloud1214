package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.appointmentReg.service.PersonModifyResultStatusService;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.PersonCheckInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-16 17:23
 */
@RestController
@AllArgsConstructor
@Api(tags = "个人终审状态修改接口API")
@RequestMapping("/personModifyResultStatus")
public class PersonModifyResultStatusController {

    private PersonModifyResultStatusService personModifyResultStatusService;

    /**
     * 取患者名字
     * @param hospitalId,personId
     * @return string
     */
    @ApiOperation(value = "取患者名字，原bserach_ItemClick的第一个select方法")
    @GetMapping("/selectPersonName/{hospitalId}/{personId}")
    public String selectPersonName(@PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId) {
        return personModifyResultStatusService.selectPersonName(hospitalId,personId);
    }

    /**
     * 提取体检结果状态
     * @param hospitalId,personId,personVisitId
     * @return string
     */
    @ApiOperation(value = "提取体检结果状态，原bserach_ItemClick的第二个select方法")
    @GetMapping("/selectResultStatus/{hospitalId}/{personId}/{personVisitId}")
    public String selectResultStatus(@PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
                                      @PathVariable("personVisitId") Integer personVisitId) {
        return personModifyResultStatusService.selectResultStatus(hospitalId,personId,personVisitId);
    }

    /**
     * 提取患者体检信息
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "提取患者体检信息，原bserach_ItemClick的第三个select方法")
    @GetMapping("/selectPersonCheckInfo/{hospitalId}/{personId}/{personVisitId}")
    public List<PersonCheckInfoVo> selectPersonCheckInfo(@PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
                                                             @PathVariable("personVisitId") Integer personVisitId) {
        return personModifyResultStatusService.selectPersonCheckInfo(hospitalId,personId,personVisitId);
    }

//    /**
//     * 设置主检标志为初始状态
//     * @param hospitalId,personId,personVisitId
//     * @return null
//     */
//    @ApiOperation(value = "设置主检标志为初始状态，原bCancelFinal_ItemClick的第一个方法")
//    @GetMapping("/updateInChiefReport/{hospitalId}/{personId}/{personVisitId}")
//    public void updateInChiefReport(@PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
//                                                          @PathVariable("personVisitId") Integer personVisitId) {
//        personModifyResultStatusService.updateInChiefReport(hospitalId,personId,personVisitId);
//    }
//
//    /**
//     * 删除hc_diagnosis_record
//     * @param personId,personVisitId
//     * @return null
//     */
//    @ApiOperation(value = "删除hc_diagnosis_record，原bCancelFinal_ItemClick的第二个方法")
//    @GetMapping("/deleteDiagnosisRecord/{personId}/{personVisitId}")
//    public void deleteDiagnosisRecord(@PathVariable("personId") String personId,
//                                     @PathVariable("personVisitId") Integer personVisitId) {
//        personModifyResultStatusService.deleteDiagnosisRecord(personId,personVisitId);
//    }
//
//    /**
//     * 设置result_status ='2',终审为空
//     * @param hospitalId,personId,personVisitId
//     * @return null
//     */
//    @ApiOperation(value = "设置result_status ='2',终审为空，原bCancelFinal_ItemClick的第三个方法")
//    @GetMapping("/updateResultStatus/{hospitalId}/{personId}/{personVisitId}")
//    public void updateResultStatus(@PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
//                                     @PathVariable("personVisitId") Integer personVisitId) {
//        personModifyResultStatusService.updateResultStatus(hospitalId,personId,personVisitId);
//    }

    /**
     * 设置主检标志为初始状态,删除hc_diagnosis_record,设置result_status ='2',终审为空
     * @param hospitalId,personId,personVisitId
     * @return null
     */
    @ApiOperation(value = "设置主检标志为初始状态，删除hc_diagnosis_record,设置result_status ='2',终审为空；以事务执行原bCancelFinal_ItemClick的三个sql方法")
    @GetMapping("/cancelFinalItemClick/{hospitalId}/{personId}/{personVisitId}")
    public String cancelFinalItemClick(@PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
                                                          @PathVariable("personVisitId") Integer personVisitId) {
        return personModifyResultStatusService.cancelFinalItemClick(hospitalId,personId,personVisitId);
    }

    /**
     * 设置result_status ='9',终审为传入值
     * @param hospitalId,personId,personVisitId,finalDocoter,finalName
     * @return null
     */
    @ApiOperation(value = "设置result_status ='9',终审为传入值，原bFinal_ItemClick的update方法")
    @GetMapping("/updateResultStatusFinal/{hospitalId}/{personId}/{personVisitId}/{finalDocoter}/{finalName}")
    public void updateResultStatusFinal(@PathVariable("hospitalId") String hospitalId, @PathVariable("personId") String personId,
                                         @PathVariable("personVisitId") Integer personVisitId,@PathVariable("finalDocoter") String finalDocoter,
                                         @PathVariable("finalName") String finalName) {
        personModifyResultStatusService.updateResultStatusFinal(hospitalId,personId,personVisitId,finalDocoter,finalName);
    }
}
