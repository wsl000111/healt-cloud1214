package com.healt.cloud.checkup.controller.member;

import com.healt.cloud.checkup.appointmentReg.service.PersonAppointRegService;
import com.healt.cloud.checkup.entity.CommonDict;
import com.healt.cloud.checkup.service.member.MemberListService;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.UnitListVo;
import com.healt.cloud.checkup.vo.member.MemberListVo;
import com.healt.cloud.checkup.vo.member.UserListVo;
import com.healt.cloud.checkup.vo.member.vo.SaveCommonDictListVo;
import com.healt.cloud.checkup.vo.member.vo.SaveHcMemberInfoListVo;
import com.healt.cloud.checkup.vo.member.MemberDictVo;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-09 13:51
 */
@RestController
@AllArgsConstructor
@Api(tags = "卡管理接口API")
@RequestMapping("/memberList")
public class MemberListController {

    private MemberListService memberListService;

    private PersonAppointRegService personAppointRegService;

    /**
     * 取会员列表并分页
     * @param memberDictVo
     * @return PageResult
     */
    @ApiOperation(value = "取会员列表并分页，原GetMemberList方法")
    @PostMapping("/findMemberListPage")
    public PageResult findMemberListPage(@RequestBody MemberDictVo memberDictVo){
        return memberListService.findMemberListPage(memberDictVo);
    }

    /**
     * 取单位信息
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "取单位信息，原GetUnitList方法")
    @GetMapping("/findUnitList/{hospitalId}")
    public List<UnitListVo> findUnitList(@PathVariable("hospitalId") String hospitalId){
        return personAppointRegService.findUnitList(hospitalId);
    }

    /**
     * 取人员列表
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "取人员列表，原GetUserList方法")
    @GetMapping("/findUserList/{hospitalId}")
    public List<UserListVo> findUserList(@PathVariable("hospitalId") String hospitalId){
        return memberListService.findUserList(hospitalId);
    }

    /**
     * 获取卡号
     * @param hospitalId,cardNo
     * @return list
     */
    @ApiOperation(value = "获取卡号，FrmCreate、FrmCancel和FrmRecharge模块:barLargeButtonItem1_ItemClick的select方法")
    @GetMapping("/findCardNo/{hospitalId}/{cardNo}")
    public List findCardNo(@PathVariable("hospitalId") String hospitalId,
                             @PathVariable("cardNo") String cardNo){
        return memberListService.findCardNo(hospitalId,cardNo);
    }

    /**
     * 保存HC_MEMBER_INFO表，并插入交易表
     * @param
     * @return void
     */
    @ApiOperation(value = "保存HC_MEMBER_INFO表，并插入交易表，FrmCreate模块:barLargeButtonItem1_ItemClick的insert方法")
    @PostMapping("/saveHcMemberInfo")
    public void saveHcMemberInfo(@RequestBody SaveHcMemberInfoListVo saveHcMemberInfoList) {
        memberListService.saveHcMemberInfo(saveHcMemberInfoList);
    }

    /**
     * 取指定会员
     * @param hospitalId,cardNo
     * @return list
     */
    @ApiOperation(value = "取指定会员，FrmCancel和FrmRecharge模块：GetDataByCardNo方法")
    @GetMapping("/findDataByCardNo/{hospitalId}/{cardNo}")
    public List<MemberListVo> findDataByCardNo(@PathVariable("hospitalId") String hospitalId,
                                               @PathVariable("cardNo") String cardNo){
        return memberListService.findDataByCardNo(hospitalId,cardNo);
    }

    /**
     * 更新HC_MEMBER_INFO表状态，并插入交易表
     * @param hospitalId,cardNo,status
     * @return list
     */
    @ApiOperation(value = "更新HC_MEMBER_INFO表状态，并插入交易表，FrmCancel模块：barLargeButtonItem1_ItemClick的update方法")
    @GetMapping("/updateMemberInfo/{hospitalId}/{cardNo}/{status}")
    public void updateMemberInfo(@PathVariable("hospitalId") String hospitalId,
                                 @PathVariable("cardNo") String cardNo,
                                 @PathVariable("status") String status){
        memberListService.updateMemberInfo(hospitalId,cardNo,status);
    }

    /**
     * 取列表
     * @param hospitalId
     * @return list
     */
    @ApiOperation(value = "取列表，FrmNewCardType模块：GetCardTypeList方法")
    @GetMapping("/findCardTypeList/{hospitalId}")
    public List<CommonDict> findCardTypeList(@PathVariable("hospitalId") String hospitalId){
        return memberListService.findCardTypeList(hospitalId);
    }

    /**
     * 更新HC_MEMBER_INFO表金额，并插入交易表
     * @param hospitalId,cardNo,money
     * @return list
     */
    @ApiOperation(value = "更新HC_MEMBER_INFO表金额，并插入交易表，rmRecharge模块：barLargeButtonItem1_ItemClick的update方法")
    @GetMapping("/updateMemberInfoMoney/{hospitalId}/{cardNo}/{decTransMoney}/{transType}/{pay}")
    public void updateMemberInfoMoney(@PathVariable("hospitalId") String hospitalId,
                                 @PathVariable("cardNo") String cardNo,
                                 @PathVariable("decTransMoney") BigDecimal decTransMoney,
                                 @PathVariable("transType") String transType,
                                 @PathVariable("pay") String pay){
        memberListService.updateMemberInfoMoney(hospitalId,cardNo,decTransMoney,transType,pay);
    }

    /**
     * 保存、修改或删除common_dict表
     * @param
     * @return void
     */
    @ApiOperation(value = "保存、修改或删除common_dict表")
    @PostMapping("/saveCommonDict")
    public void saveCommonDict(@RequestBody SaveCommonDictListVo saveCommonDictList) {
        memberListService.saveCommonDict(saveCommonDictList);
    }
}
