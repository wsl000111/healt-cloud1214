package com.healt.cloud.checkup.controller.settlement;

import com.healt.cloud.checkup.service.settlement.PersonSettleService;
import com.healt.cloud.checkup.vo.settlement.*;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcSettleListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author linklee
 * @create 2022-04-09 13:55
 */
@RestController
@AllArgsConstructor
@Api(tags = "个人缴费接口API")
@RequestMapping("/personSettle")
public class PersonSettleController {

    private PersonSettleService personSettleService;

    /**
     * 取收费项目列表
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "取收费项目列表，原GetSettleItemList方法")
    @GetMapping("/findSettleItemList/{hospitalId}/{personId}/{personVisitId}")
    private List<SettleItemListVo> findSettleItemList(@PathVariable("hospitalId") String hospitalId,
                                                      @PathVariable("personId") String personId,
                                                      @PathVariable("personVisitId") Integer personVisitId) {
        return personSettleService.findSettleItemList(hospitalId,personId,personVisitId);
    }

    /**
     * 取支付方式列表
     * @param
     * @return list
     */
    @ApiOperation(value = "取支付方式列表，原GetSettlePayList方法")
    @GetMapping("/findSettlePayList")
    private List<SettlePayListVo> findSettlePayList() {
        return personSettleService.findSettlePayList();
    }

    /**
     * 取体检次数和基本信息
     * @param hospitalId,personId
     * @return list
     */
    @ApiOperation(value = "取体检次数和基本信息，原tePersonId_KeyDown方法")
    @GetMapping("/findPersonVisitAndInfo/{hospitalId}/{personId}")
    private List<PersonVisitAndInfoVo> findPersonVisitAndInfo(@PathVariable("hospitalId") String hospitalId,
                                                              @PathVariable("personId") String personId) {
        return personSettleService.findPersonVisitAndInfo(hospitalId,personId);
    }

    /**
     * 取会员卡余额
     * @param hospitalId,cardNo
     * @return BigDecimal
     */
    @ApiOperation(value = "取会员卡余额，cardNo错误则提示卡号不存在，原textEdit5_KeyDown方法")
    @GetMapping("/findMoneyInCard/{hospitalId}/{cardNo}")
    private BigDecimal findMoneyInCard(@PathVariable("hospitalId") String hospitalId,
                                   @PathVariable("cardNo") String cardNo) {
        return personSettleService.findMoneyInCard(hospitalId,cardNo);
    }

    /**
     * 取机构记录
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "取机构记录，原barLargeButtonItem1_ItemClick方法的第一个sql")
    @GetMapping("/findHospitalDict/{hospitalId}")
    private List<HospitalDictVo> findHospitalDict(@PathVariable("hospitalId") String hospitalId) {
        return personSettleService.findHospitalDict(hospitalId);
    }

//    /**
//     * 更新减掉卡里金额
//     * @param hospitalId,cardNo,paymentMoney
//     * @return null
//     */
//    @ApiOperation(value = "更新减掉卡里金额，cardNo错误提示卡号不存在，余额不足提示未完成扣费，原barLargeButtonItem1_ItemClick方法的第二个sql")
//    @GetMapping("/updateMoneyInCard/{hospitalId}/{cardNo}/{paymentMoney}")
//    private void updateMoneyInCard(@PathVariable("hospitalId") String hospitalId,
//                                   @PathVariable("cardNo") String cardNo,
//                                   @PathVariable("paymentMoney") BigDecimal paymentMoney) {
//        personSettleService.updateMoneyInCard(hospitalId,cardNo,paymentMoney);
//    }
//
//    /**
//     * 保存主表
//     * @param saveHcSettleMasterListVo
//     * @return null
//     */
//    @ApiOperation(value = "保存主表，原barLargeButtonItem1_ItemClick方法的第三个sql")
//    @PostMapping("/saveSettleMaster")
//    private void saveSettleMaster(@RequestBody SaveHcSettleMasterListVo saveHcSettleMasterListVo) {
//        personSettleService.saveSettleMaster(saveHcSettleMasterListVo);
//    }
//
//    /**
//     * 回写机构下一个单号
//     * @param hospitalId
//     * @return null
//     */
//    @ApiOperation(value = "回写机构下一个单号，原barLargeButtonItem1_ItemClick方法的第四个sql")
//    @GetMapping("/updateNextChargeNo/{hospitalId}")
//    private void updateNextChargeNo(@PathVariable("hospitalId") String hospitalId) {
//        personSettleService.updateNextChargeNo(hospitalId);
//    }
//
//    /**
//     * 写预约表收费标志
//     * @param hospitalId,personId,personVisitId
//     * @return null
//     */
//    @ApiOperation(value = "写预约表收费标志，原barLargeButtonItem1_ItemClick方法的第五个sql")
//    @GetMapping("/updateBillIndicator/{hospitalId}/{personId}/{personVisitId}")
//    private void updateBillIndicator(@PathVariable("hospitalId") String hospitalId,
//                                     @PathVariable("personId") String personId,
//                                     @PathVariable("personVisitId") Integer personVisitId) {
//        personSettleService.updateBillIndicator(hospitalId,personId,personVisitId);
//    }

    /**
     * 收费主表细表支付方式
     * @param saveHcSettleList
     * @return null
     */
    @ApiOperation(value = "收费主表细表支付方式，原barLargeButtonItem1_ItemClick方法")
    @PostMapping("/saveHcSettleList")
    private void saveHcSettleList(@RequestBody SaveHcSettleListVo saveHcSettleList) {
        personSettleService.saveHcSettleList(saveHcSettleList);
    }

    @ApiOperation(value = "原SbYy_Click的select方法")
    @GetMapping("/findSbYy/{hospitalId}/{unitId}/{unitVisitId}/{schemeCode}")
    public List<SbYyVo> findSbYy(@PathVariable String hospitalId, @PathVariable String unitId,
                                 @PathVariable Integer unitVisitId, @PathVariable String schemeCode){
        return personSettleService.findSbYy(hospitalId, unitId, unitVisitId, schemeCode);
    }
}
