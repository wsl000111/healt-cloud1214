package com.healt.cloud.checkup.controller.settlement;

import com.healt.cloud.checkup.appointmentReg.service.UnitPersonAppointRegService;
import com.healt.cloud.checkup.controller.settlement.vo.UnitPersonSettlt;
import com.healt.cloud.checkup.entity.HcUnitVisitInfo;
import com.healt.cloud.checkup.service.settlement.PersonSettleService;
import com.healt.cloud.checkup.service.settlement.UnitSettleService;
import com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg.DtUnitPersonsVisitVo;
import com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg.HcPersonInfoVo;
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
 * @create 2022-05-03 10:51
 */
@RestController
@AllArgsConstructor
@Api(tags = "单位体检收费接口API")
@RequestMapping("/unitSettle")
public class UnitSettleController {

    private UnitSettleService unitSettleService;

    private PersonSettleService personSettleService;

    private UnitPersonAppointRegService unitPersonAppointRegService;

    /**
     * 获取单位信息
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "获取单位信息，原GetDtUnit的select方法")
    @GetMapping("/findUnitInfo/{hospitalId}")
    public List<UnitInfoVo> findUnitInfo(@PathVariable("hospitalId") String hospitalId){
        return unitSettleService.findUnitInfo(hospitalId);
    }

    /**
     * 获取打折方案
     * @param
     * @return list
     */
    @ApiOperation(value = "获取打折方案，原FrmUnitSettle_Load方法")
    @GetMapping("/findDiscountScheme")
    public List<DiscountSchemeVo> findDiscountScheme(){
        return unitSettleService.findDiscountScheme();
    }

    /**
     * 获取单位综合信息
     * @param hospitalId,unitId,visitId
     * @return list
     */
    @ApiOperation(value = "获取单位综合信息，原GetDtUnitPersonsVisit方法")
    @GetMapping("/findDtUnitPersonsVisit/{hospitalId}/{unitId}/{visitId}")
    public List<DtUnitPersonsVisitVo> findDtUnitPersonsVisit(@PathVariable("hospitalId") String hospitalId,
                                                             @PathVariable("unitId") String unitId,
                                                             @PathVariable("visitId") String visitId){
        return unitPersonAppointRegService.findDtUnitPersonsVisit(hospitalId, unitId, visitId);
    }

    /**
     * 全部单位体检次数
     * @param hospitalId,unitId
     * @return list
     */
    @ApiOperation(value = "全部单位体检次数，原GetDtUnitVisit（unitId）方法")
    @GetMapping("/findDtUnitVisit/{hospitalId}/{unitId}")
    public List<HcUnitVisitInfo> findDtUnitVisit(@PathVariable String hospitalId, @PathVariable String unitId){
        return unitPersonAppointRegService.findDtUnitVisit(hospitalId, unitId);
    }

    @ApiOperation(value = "单位分组信息，原GetDtUnitGroup方法")
    @GetMapping("/findDtUnitGroup/{hospitalId}/{unitId}/{unitVisitId}")
    public List<HcUnitGroupVo> findDtUnitGroup(@PathVariable String hospitalId, @PathVariable String unitId, @PathVariable Integer unitVisitId){
        return unitSettleService.findDtUnitGroup(hospitalId, unitId, unitVisitId);
    }

    @ApiOperation(value = "原GetDtUnitPersons方法")
    @GetMapping("/findDtUnitPersons/{hospitalId}/{unitId}")
    public List<HcPersonInfoVo> findDtUnitPersons(@PathVariable String hospitalId, @PathVariable String unitId){
        return unitPersonAppointRegService.findDtUnitPersons(hospitalId, unitId);
    }

    /**
     * 获取体检项目明细
     * @param hospitalId,unitId,unitVisitId
     * @return list
     */
    @ApiOperation(value = "获取体检项目明细，原GetDtxmmx方法")
    @GetMapping("/findDtxmmx/{hospitalId}/{unitId}/{unitVisitId}")
    public List<DtxmmxVo> findDtxmmx(@PathVariable String hospitalId, @PathVariable String unitId, @PathVariable Integer unitVisitId){
        return unitSettleService.findDtxmmx(hospitalId, unitId, unitVisitId);
    }

    @ApiOperation(value = "单元人员费用明细查询")
    @PostMapping("/findDtxmmxPerson")
    public List<DtxmmxVo> findDtxmmxPerson(@RequestBody UnitPersonSettlt unitPersonSettlt){
        return unitSettleService.findDtxmmxPerson(unitPersonSettlt.getHospitalId(),
                unitPersonSettlt.getUnitId(), unitPersonSettlt.getUnitVisitId(), unitPersonSettlt.getPersonIdStr());
    }

    /**
     * 获取体检项目汇总
     * @param hospitalId,unitId
     * @return list
     */
    @ApiOperation(value = "获取体检项目汇总，原GetDtxmHZ方法")
    @GetMapping("/findDtxmHZ/{hospitalId}/{unitId}/{unitVisitId}")
    public List<DtxmHZVo> findDtxmHZ(@PathVariable String hospitalId, @PathVariable String unitId, @PathVariable Integer unitVisitId){
        return unitSettleService.findDtxmHZ(hospitalId, unitId, unitVisitId);
    }

    @ApiOperation(value = "获取体检项目汇总")
    @PostMapping("/findDtxmHZPerson")
    public List<DtxmHZVo> findDtxmHZPerson(@RequestBody UnitPersonSettlt unitPersonSettlt){
        return unitSettleService.findDtxmHZPerson(unitPersonSettlt.getHospitalId(),
                unitPersonSettlt.getUnitId(), unitPersonSettlt.getUnitVisitId(), unitPersonSettlt.getPersonIdStr());
    }

    @ApiOperation(value = "原SbYy_Click的select方法")
    @GetMapping("/findSbYy/{hospitalId}/{unitId}/{unitVisitId}/{schemeCode}")
    public List<SbYyVo> findSbYy(@PathVariable String hospitalId, @PathVariable String unitId,
                                 @PathVariable Integer unitVisitId,@PathVariable String schemeCode){
        return unitSettleService.findSbYy(hospitalId, unitId, unitVisitId, schemeCode);
    }

    /**
     * 取机构记录
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "取机构记录，原sB_OK_Click方法的第一个sql")
    @GetMapping("/findHospitalDict/{hospitalId}")
    private List<HospitalDictVo> findHospitalDict(@PathVariable("hospitalId") String hospitalId) {
        return personSettleService.findHospitalDict(hospitalId);
    }

    /**
     * 收费主表细表支付方式
     * @param saveHcSettleList
     * @return null
     */
    @ApiOperation(value = "收费主表细表支付方式，原sB_OK_Click方法")
    @PostMapping("/saveHcSettleList")
    private void saveHcSettleList(@RequestBody SaveHcSettleListVo saveHcSettleList) {
        unitSettleService.saveHcSettleList(saveHcSettleList);
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
     * 取会员卡余额
     * @param hospitalId,cardNo
     * @return BigDecimal
     */
    @ApiOperation(value = "取会员卡余额，cardNo错误则提示卡号不存在，原te_jke_KeyDown方法")
    @GetMapping("/findMoneyInCard/{hospitalId}/{cardNo}")
    private BigDecimal findMoneyInCard(@PathVariable("hospitalId") String hospitalId,
                                       @PathVariable("cardNo") String cardNo) {
        return personSettleService.findMoneyInCard(hospitalId,cardNo);
    }

    @ApiOperation(value = "获取人员信息（20220829新增）")
    @GetMapping("/findPersonsInfo/{hospitalId}/{unitId}")
    public List<PersonsInfoVo> findPersonsInfo(@PathVariable String hospitalId, @PathVariable String unitId){
        return unitPersonAppointRegService.findPersonsInfo(hospitalId, unitId);
    }

    @ApiOperation(value = "获取人员信息（20220903新增）")
    @PostMapping("/findPersonsInfoByTime")
    public List<PersonsInfoVo> findPersonsInfoByTime(@RequestBody PersonsInfoDictVo personsInfoDictVo){
        return unitPersonAppointRegService.findPersonsInfoByTime(personsInfoDictVo);
    }
}
