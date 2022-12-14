package com.healt.cloud.checkup.controller.settlement;

import com.healt.cloud.checkup.entity.HcSettleMaster;
import com.healt.cloud.checkup.service.settlement.PersonSettleReturnService;
import com.healt.cloud.checkup.service.settlement.PersonSettleService;
import com.healt.cloud.checkup.vo.settlement.HospitalDictVo;
import com.healt.cloud.checkup.vo.settlement.SettleReturnItemListVo;
import com.healt.cloud.checkup.vo.settlement.SettleReturnPayListVo;
import com.healt.cloud.checkup.vo.settlement.SettleReturnPersonInfoVo;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcReturnSettleListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-14 15:17
 */
@RestController
@AllArgsConstructor
@Api(tags = "个人退费接口API")
@RequestMapping("/personSettleReturn")
public class PersonSettleReturnController {

    private PersonSettleReturnService personSettleReturnService;

    private PersonSettleService personSettleService;

    /**
     * 取退费项目列表
     * @param hospitalId,rcptNo
     * @return list
     */
    @ApiOperation(value = "取退费项目列表，原GetSettleItemList的select方法")
    @GetMapping("/findSettleReturnItemList/{hospitalId}/{rcptNo}")
    private List<SettleReturnItemListVo> findSettleReturnItemList(@PathVariable("hospitalId") String hospitalId,
                                                                  @PathVariable("rcptNo") String rcptNo) {
        return personSettleReturnService.findSettleReturnItemList(hospitalId,rcptNo);
    }

    /**
     * 取支付方式列表
     * @param hospitalId,rcptNo
     * @return list
     */
    @ApiOperation(value = "取支付方式列表，原GetSettlePayList方法")
    @GetMapping("/findSettleReturnPayList/{hospitalId}/{rcptNo}")
    private List<SettleReturnPayListVo> findSettleReturnPayList(@PathVariable("hospitalId") String hospitalId,
                                                                @PathVariable("rcptNo") String rcptNo) {
        return personSettleReturnService.findSettleReturnPayList(hospitalId,rcptNo);
    }

    /**
     * 取收费主记录
     * @param hospitalId,rcptNo
     * @return list
     */
    @ApiOperation(value = "取收费主记录，原tePersonId_KeyDown的第一个方法")
    @GetMapping("/findHcSettleMaster/{hospitalId}/{rcptNo}")
    private List<HcSettleMaster> findHcSettleMaster(@PathVariable("hospitalId") String hospitalId,
                                                    @PathVariable("rcptNo") String rcptNo) {
        return personSettleReturnService.findHcSettleMaster(hospitalId,rcptNo);
    }

    /**
     * 取个人体检信息,result_status为“F”则报错
     * @param hospitalId,personId,personVisitId
     * @return list
     */
    @ApiOperation(value = "取个人体检信息，result_status为“F”则报错，原tePersonId_KeyDown的第二个方法")
    @GetMapping("/findSettleReturnPersonInfo/{hospitalId}/{personId}/{personVisitId}")
    private List<SettleReturnPersonInfoVo> findSettleReturnPersonInfo(@PathVariable("hospitalId") String hospitalId,
                                                                      @PathVariable("personId") String personId,
                                                                      @PathVariable("personVisitId") Integer personVisitId) {
        return personSettleReturnService.findSettleReturnPersonInfo(hospitalId,personId,personVisitId);
    }

    /**
     * 取机构记录
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "取机构记录，原barLargeButtonItem1_ItemClick的select方法")
    @GetMapping("/findHospitalDict/{hospitalId}")
    private List<HospitalDictVo> findHospitalDict(@PathVariable("hospitalId") String hospitalId) {
        return personSettleService.findHospitalDict(hospitalId);
    }

    /**
     * 退费主表细表支付方式,还原收费项目计价标志
     * @param saveHcReturnSettleList
     * @return null
     */
    @ApiOperation(value = "退费主表细表支付方式，还原收费项目计价标志,原barLargeButtonItem1_ItemClick方法")
    @PostMapping("/saveHcReturnSettleList")
    public void saveHcReturnSettleList(@RequestBody SaveHcReturnSettleListVo saveHcReturnSettleList) {
        personSettleReturnService.saveHcReturnSettleList(saveHcReturnSettleList);
    }

    /**
     * 取退费项目列表（新）
     * @param hospitalId,rcptNo
     * @return list
     */
    @ApiOperation(value = "取退费项目列表（新），原GetSettleItemList的select方法")
    @GetMapping("/findSettleReturnItemListNew/{hospitalId}/{rcptNo}")
    private List<SettleReturnItemListVo> findSettleReturnItemListNew(@PathVariable("hospitalId") String hospitalId,
                                                                  @PathVariable("rcptNo") String rcptNo) {
        return personSettleReturnService.findSettleReturnItemListNew(hospitalId,rcptNo);
    }
}
