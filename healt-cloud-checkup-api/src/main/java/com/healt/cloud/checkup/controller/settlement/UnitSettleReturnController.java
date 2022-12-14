package com.healt.cloud.checkup.controller.settlement;

import com.healt.cloud.checkup.entity.HcSettleMaster;
import com.healt.cloud.checkup.service.settlement.PersonSettleReturnService;
import com.healt.cloud.checkup.service.settlement.PersonSettleService;
import com.healt.cloud.checkup.service.settlement.UnitSettleReturnService;
import com.healt.cloud.checkup.vo.settlement.*;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcReturnSettleListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-07 9:40
 */
@RestController
@AllArgsConstructor
@Api(tags = "单位体检退费接口API")
@RequestMapping("/unitSettleReturn")
public class UnitSettleReturnController {

    private UnitSettleReturnService unitSettleReturnService;

    private PersonSettleReturnService personSettleReturnService;
    private PersonSettleService personSettleService;

    /**
     * 取退费项目列表
     * @param hospitalId,rcptNo
     * @return list
     */
    @ApiOperation(value = "取退费项目列表，原GetSettleItemList的select方法")
    @GetMapping("/findUnitSettleReturnItemList/{hospitalId}/{rcptNo}")
    public List<UnitSettleReturnItemListVo> findUnitSettleReturnItemList(@PathVariable("hospitalId") String hospitalId,
                                                                         @PathVariable("rcptNo") String rcptNo){
        return unitSettleReturnService.findUnitSettleReturnItemList(hospitalId,rcptNo);
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
    @ApiOperation(value = "取收费主记录，原teRcptNo_KeyDown的select方法")
    @GetMapping("/findHcSettleMaster/{hospitalId}/{rcptNo}")
    private List<HcSettleMaster> findHcSettleMaster(@PathVariable("hospitalId") String hospitalId,
                                                    @PathVariable("rcptNo") String rcptNo) {
        return unitSettleReturnService.findHcSettleMaster(hospitalId,rcptNo);
    }

    /**
     * 获取体检新项目明细
     * @param hospitalId,rcptNo
     * @return list
     */
    @ApiOperation(value = "获取体检新项目明细，原GetDtxmmx方法")
    @GetMapping("/findDtxmmx/{hospitalId}/{rcptNo}")
    public List<DtxmmxVo> findDtxmmx(@PathVariable String hospitalId, @PathVariable String rcptNo){
        return unitSettleReturnService.findDtxmmx(hospitalId, rcptNo);
    }

    /**
     * 获取体检新项目汇总
     * @param hospitalId,rcptNo
     * @return list
     */
    @ApiOperation(value = "获取体检新项目汇总，原GetDtxmHZ方法")
    @GetMapping("/findDtxmHZ/{hospitalId}/{rcptNo}")
    public List<DtxmHZVo> findDtxmHZ(@PathVariable String hospitalId, @PathVariable String rcptNo){
        return unitSettleReturnService.findDtxmHZ(hospitalId, rcptNo);
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

    /**
     * 退费主表细表支付方式,还原收费项目计价标志
     * TODO 保存退费主表时returnCosts和returnCharges两个参数问题
     * @param saveHcReturnSettleList
     * @return null
     */
    @ApiOperation(value = "退费主表细表支付方式，还原收费项目计价标志,原barLargeButtonItem1_ItemClick方法")
    @PostMapping("/saveHcReturnSettleList")
    public void saveHcReturnSettleList(@RequestBody SaveHcReturnSettleListVo saveHcReturnSettleList) {
        personSettleReturnService.saveHcReturnSettleList(saveHcReturnSettleList);
    }

}
